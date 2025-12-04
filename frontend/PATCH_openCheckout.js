// Cole esta função no lugar da função openCheckout() existente no app.js

async function openCheckout() {
    if (state.cart.length === 0) {
        alert('Seu carrinho está vazio!');
        return;
    }

    // Determine user
    let userId;
    let userName;

    if (state.userRole === 'admin') {
        // For admin, ask which user via prompt
        await loadUsers();

        const userOptions = state.users.map(u => `${u.id}. ${u.name} (${u.email})`).join('\n');
        const userInput = prompt(`Selecione o usuário para o pedido:\n\n${userOptions}\n\nDigite o ID do usuário:`);

        if (!userInput) {
            return; // Cancelled
        }

        userId = parseInt(userInput);
        const user = state.users.find(u => u.id === userId);

        if (!user) {
            alert('Usuário não encontrado!');
            return;
        }

        userName = user.name;
    } else {
        // Customer - use current user
        userId = state.currentUser.id;
        userName = state.currentUser.name;
    }

    // Calculate total
    const total = getCartTotal();
    const itemCount = state.cart.reduce((sum, item) => sum + item.quantity, 0);

    // Show confirmation
    const confirmed = confirm(
        `Confirmar pedido?\n\n` +
        `Cliente: ${userName}\n` +
        `Itens: ${itemCount}\n` +
        `Total: ${formatCurrency(total)}`
    );

    if (!confirmed) {
        return;
    }

    try {
        // Prepare order data
        const orderData = {
            clientId: userId,
            items: state.cart.map(item => ({
                productId: item.product.id,
                quantity: item.quantity
            }))
        };

        console.log('Creating order:', orderData);

        // Create order via API
        const createdOrder = await api.post('/orders', orderData);

        console.log('Order created:', createdOrder);

        // Success!
        alert(`✅ Pedido #${createdOrder.id} criado com sucesso para ${userName}!`);
        showNotification(`Pedido #${createdOrder.id} criado com sucesso!`);

        // Clear cart and close modal
        state.cart = [];
        updateCartCount();
        closeCart();

        // Refresh orders page if currently viewing it
        if (state.currentPage === 'orders') {
            await renderOrdersPage();
        }
    } catch (error) {
        console.error('Erro ao criar pedido:', error);
        alert('❌ Erro ao processar pedido: ' + error.message);
    }
}
