// API Configuration
const API_BASE_URL = 'http://localhost:8080';

// ===== Login Functions =====
async function login(email, password) {
    try {
        // Buscar todos os usuários
        const response = await fetch(`${API_BASE_URL}/users`);
        if (!response.ok) throw new Error('Erro ao conectar com a API');

        const users = await response.json();

        // Encontrar usuário por email e senha
        const user = users.find(u => u.email === email && u.password === password);

        if (user) {
            // Salvar usuário no localStorage
            localStorage.setItem('currentUser', JSON.stringify(user));
            localStorage.setItem('userRole', 'customer');

            // Redirecionar para a loja
            window.location.href = 'index.html';
            return true;
        } else {
            throw new Error('Email ou senha incorretos');
        }
    } catch (error) {
        console.error('Erro no login:', error);
        throw error;
    }
}

async function adminLogin(email, password) {
    // Credenciais fixas do administrador
    const ADMIN_EMAIL = 'johann@gmail.com';
    const ADMIN_PASSWORD = 'johann';

    if (email === ADMIN_EMAIL && password === ADMIN_PASSWORD) {
        // Login como admin
        localStorage.setItem('userRole', 'admin');
        localStorage.setItem('currentUser', JSON.stringify({
            id: 0,
            name: 'Administrador',
            email: ADMIN_EMAIL,
            phone: 'Admin',
            password: ADMIN_PASSWORD
        }));
        window.location.href = 'index.html';
        return true;
    } else {
        throw new Error('Credenciais de administrador inválidas');
    }
}

async function register(userData) {
    try {
        const response = await fetch(`${API_BASE_URL}/users`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(userData)
        });

        if (!response.ok) throw new Error('Erro ao criar conta');

        const newUser = await response.json();

        // Fazer login automático
        localStorage.setItem('currentUser', JSON.stringify(newUser));
        localStorage.setItem('userRole', 'customer');

        window.location.href = 'index.html';
        return true;
    } catch (error) {
        console.error('Erro no registro:', error);
        throw error;
    }
}

// ===== Modal Functions =====
function openRegisterModal() {
    document.getElementById('registerModal').classList.add('active');
}

function closeRegisterModal() {
    document.getElementById('registerModal').classList.remove('active');
}

// ===== Event Listeners =====
document.addEventListener('DOMContentLoaded', () => {
    // Login form
    document.getElementById('loginForm').addEventListener('submit', async (e) => {
        e.preventDefault();

        const email = document.getElementById('loginEmail').value;
        const password = document.getElementById('loginPassword').value;

        try {
            // Primeiro tenta login como admin
            if (email === 'johann@gmail.com') {
                await adminLogin(email, password);
            } else {
                // Se não for admin, tenta login normal
                await login(email, password);
            }
        } catch (error) {
            alert(error.message);
        }
    });

    // Register link
    document.getElementById('registerLink').addEventListener('click', (e) => {
        e.preventDefault();
        openRegisterModal();
    });

    // Register modal
    document.getElementById('closeRegisterModal').addEventListener('click', closeRegisterModal);
    document.getElementById('cancelRegisterBtn').addEventListener('click', closeRegisterModal);

    document.getElementById('registerModal').addEventListener('click', (e) => {
        if (e.target.id === 'registerModal') {
            closeRegisterModal();
        }
    });

    // Register form
    document.getElementById('registerForm').addEventListener('submit', async (e) => {
        e.preventDefault();

        const userData = {
            name: document.getElementById('registerName').value,
            email: document.getElementById('registerEmail').value,
            phone: document.getElementById('registerPhone').value,
            password: document.getElementById('registerPassword').value
        };

        try {
            await register(userData);
        } catch (error) {
            alert('Erro ao criar conta: ' + error.message);
        }
    });
});
