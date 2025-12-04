package io.github.johann0301.webserviceproject.config;

import io.github.johann0301.webserviceproject.entities.*;
import io.github.johann0301.webserviceproject.entities.enums.OrderStatus;
import io.github.johann0301.webserviceproject.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        
        // Só popula o banco se estiver vazio
        if (userRepository.count() > 0) {
            System.out.println("ℹ️ Banco de dados já contém dados. Pulando população inicial.");
            return;
        }
        
        System.out.println("🔄 Populando banco de dados com dados de teste...");

        // ===== CATEGORIAS =====
        Category c1 = new Category(null, "Eletrônicos");
        Category c2 = new Category(null, "Livros");
        Category c3 = new Category(null, "Computadores");
        Category c4 = new Category(null, "Games");
        Category c5 = new Category(null, "Acessórios");
        
        categoryRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));

        // ===== PRODUTOS =====
        // Livros
        Product p1 = new Product(null, "O Senhor dos Anéis", 
            "Trilogia épica de fantasia escrita por J.R.R. Tolkien. Uma jornada inesquecível pela Terra Média.", 
            89.90, "https://m.media-amazon.com/images/I/71jLBXtWJWL._SY466_.jpg");
        
        Product p2 = new Product(null, "Harry Potter - Coleção Completa", 
            "Coleção completa com os 7 livros da saga do bruxinho mais famoso do mundo.", 
            199.90, "https://m.media-amazon.com/images/I/71-++hbbERL._SY466_.jpg");
        
        Product p3 = new Product(null, "1984 - George Orwell", 
            "Clássico distópico sobre vigilância, manipulação e controle totalitário.", 
            34.90, "https://m.media-amazon.com/images/I/819js3EQwbL._SY466_.jpg");

        // Eletrônicos
        Product p4 = new Product(null, "Smart TV 55\" 4K Samsung", 
            "Smart TV LED 55\" UHD 4K com HDR, Wi-Fi integrado e controle remoto único.", 
            2499.00, "https://images.samsung.com/is/image/samsung/p6pim/br/un55cu7700gxzd/gallery/br-crystal-uhd-cu7700-un55cu7700gxzd-537046444");
        
        Product p5 = new Product(null, "iPhone 15 Pro 256GB", 
            "iPhone 15 Pro com chip A17 Pro, câmera de 48MP e tela Super Retina XDR.", 
            7999.00, "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone-15-pro-finish-select-202309-6-1inch-naturaltitanium");
        
        Product p6 = new Product(null, "Fone de Ouvido Sony WH-1000XM5", 
            "Fone premium com cancelamento de ruído líder de mercado e 30h de bateria.", 
            1899.00, "https://m.media-amazon.com/images/I/51K9KGAJ+9L._AC_SX679_.jpg");

        // Computadores
        Product p7 = new Product(null, "MacBook Pro 14\" M3", 
            "MacBook Pro com chip M3, 16GB RAM, 512GB SSD. Perfeito para profissionais criativos.", 
            14999.00, "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/mbp14-spacegray-select-202310");
        
        Product p8 = new Product(null, "PC Gamer Completo RTX 4060", 
            "PC Gamer com Ryzen 5 5600, RTX 4060 8GB, 16GB RAM, SSD 512GB + Monitor 144Hz.", 
            4999.00, "https://images.kabum.com.br/produtos/fotos/sync_mirakl/484644/PC-Gamer-Completo-Mancer");
        
        Product p9 = new Product(null, "Notebook Dell Inspiron 15", 
            "Notebook Dell i5 12ª geração, 8GB RAM, SSD 256GB, tela Full HD 15.6\".", 
            3299.00, "https://i.dell.com/is/image/DellContent/content/dam/ss2/product-images/dell-client-products/notebooks/inspiron-notebooks/15-3520/media-gallery/notebook-inspiron-15-3520-nt-blue-gallery-4.psd");

        // Games
        Product p10 = new Product(null, "PlayStation 5 + 2 Jogos", 
            "Console PS5 com leitor de disco + Spider-Man 2 + God of War Ragnarök.", 
            3899.00, "https://gmedia.playstation.com/is/image/SIEPDC/ps5-product-thumbnail-01-en-14sep21");
        
        Product p11 = new Product(null, "Xbox Series X", 
            "Console Xbox Series X com 1TB de armazenamento e 4K nativo a 120fps.", 
            3799.00, "https://assets.xboxservices.com/assets/fb/d2/fbd2cb56-5c25-414d-9f46-e6a164cdf5be.png");
        
        Product p12 = new Product(null, "Nintendo Switch OLED", 
            "Nintendo Switch modelo OLED com tela de 7\" e cores vibrantes.", 
            2499.00, "https://assets.nintendo.com/image/upload/f_auto/q_auto/dpr_2.0/c_scale,w_500/ncom/en_US/switch/site-design-update/hardware/switch-oled/gallery/image01");

        // Acessórios
        Product p13 = new Product(null, "Teclado Mecânico Gamer RGB", 
            "Teclado mecânico com switches blue, iluminação RGB e teclas anti-ghosting.", 
            299.00, "https://m.media-amazon.com/images/I/61V0f4OQPML._AC_SX679_.jpg");
        
        Product p14 = new Product(null, "Mouse Gamer Logitech G502", 
            "Mouse gamer com sensor HERO 25K, 11 botões programáveis e pesos ajustáveis.", 
            249.00, "https://resource.logitechg.com/w_692,c_lpad,ar_4:3,q_auto,f_auto,dpr_1.0/d_transparent.gif/content/dam/gaming/en/products/g502-hero/g502-hero-gallery-1.png");
        
        Product p15 = new Product(null, "Webcam Logitech C920 Full HD", 
            "Webcam Full HD 1080p com microfone estéreo e correção de iluminação.", 
            399.00, "https://resource.logitech.com/w_692,c_lpad,ar_4:3,q_auto,f_auto,dpr_1.0/d_transparent.gif/content/dam/logitech/en/products/webcams/c920/gallery/c920-gallery-1.png");

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15));

        // Associar produtos às categorias
        p1.getCategories().add(c2);
        p2.getCategories().add(c2);
        p3.getCategories().add(c2);
        
        p4.getCategories().add(c1);
        p5.getCategories().add(c1);
        p6.getCategories().add(c1);
        p6.getCategories().add(c5);
        
        p7.getCategories().add(c3);
        p8.getCategories().add(c3);
        p8.getCategories().add(c4);
        p9.getCategories().add(c3);
        
        p10.getCategories().add(c4);
        p11.getCategories().add(c4);
        p12.getCategories().add(c4);
        
        p13.getCategories().add(c5);
        p14.getCategories().add(c5);
        p15.getCategories().add(c5);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15));

        // ===== USUÁRIOS =====
        User u1 = new User(null, "Maria Silva", "maria@gmail.com", "(11) 98765-4321", "12345");
        User u2 = new User(null, "João Santos", "joao@gmail.com", "(21) 99876-5432", "54321");
        User u3 = new User(null, "Ana Costa", "ana@gmail.com", "(31) 97654-3210", "senha123");
        User u4 = new User(null, "Pedro Oliveira", "pedro@gmail.com", "(41) 96543-2109", "pedro2024");
        User u5 = new User(null, "Julia Ferreira", "julia@gmail.com", "(51) 95432-1098", "julia@123");
        
        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5));

        // ===== PEDIDOS =====
        // Pedidos da Maria
        Order o1 = new Order(null, Instant.parse("2024-11-15T14:30:00Z"), OrderStatus.DELIVERED, u1);
        Order o2 = new Order(null, Instant.parse("2024-11-28T10:15:00Z"), OrderStatus.PAID, u1);
        Order o3 = new Order(null, Instant.parse("2024-12-01T16:45:00Z"), OrderStatus.WAITING_PAYMENT, u1);
        
        // Pedidos do João
        Order o4 = new Order(null, Instant.parse("2024-11-20T09:20:00Z"), OrderStatus.DELIVERED, u2);
        Order o5 = new Order(null, Instant.parse("2024-11-25T18:30:00Z"), OrderStatus.SHIPPED, u2);
        
        // Pedidos da Ana
        Order o6 = new Order(null, Instant.parse("2024-11-22T11:00:00Z"), OrderStatus.DELIVERED, u3);
        Order o7 = new Order(null, Instant.parse("2024-12-02T15:20:00Z"), OrderStatus.PAID, u3);
        
        // Pedidos do Pedro
        Order o8 = new Order(null, Instant.parse("2024-11-18T13:45:00Z"), OrderStatus.CANCELLED, u4);
        Order o9 = new Order(null, Instant.parse("2024-12-03T10:30:00Z"), OrderStatus.WAITING_PAYMENT, u4);
        
        // Pedido da Julia
        Order o10 = new Order(null, Instant.parse("2024-11-30T17:00:00Z"), OrderStatus.SHIPPED, u5);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4, o5, o6, o7, o8, o9, o10));

        // ===== ITENS DOS PEDIDOS =====
        // Pedido 1 - Maria (Livros)
        OrderItem oi1 = new OrderItem(o1, p1, 1, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 2, p3.getPrice());
        
        // Pedido 2 - Maria (Notebook)
        OrderItem oi3 = new OrderItem(o2, p9, 1, p9.getPrice());
        OrderItem oi4 = new OrderItem(o2, p14, 1, p14.getPrice());
        
        // Pedido 3 - Maria (Acessórios)
        OrderItem oi5 = new OrderItem(o3, p13, 1, p13.getPrice());
        OrderItem oi6 = new OrderItem(o3, p15, 1, p15.getPrice());
        
        // Pedido 4 - João (PlayStation)
        OrderItem oi7 = new OrderItem(o4, p10, 1, p10.getPrice());
        OrderItem oi8 = new OrderItem(o4, p6, 1, p6.getPrice());
        
        // Pedido 5 - João (TV)
        OrderItem oi9 = new OrderItem(o5, p4, 1, p4.getPrice());
        
        // Pedido 6 - Ana (iPhone)
        OrderItem oi10 = new OrderItem(o6, p5, 1, p5.getPrice());
        
        // Pedido 7 - Ana (Livros)
        OrderItem oi11 = new OrderItem(o7, p2, 1, p2.getPrice());
        OrderItem oi12 = new OrderItem(o7, p1, 1, p1.getPrice());
        
        // Pedido 8 - Pedro (MacBook - cancelado)
        OrderItem oi13 = new OrderItem(o8, p7, 1, p7.getPrice());
        
        // Pedido 9 - Pedro (PC Gamer)
        OrderItem oi14 = new OrderItem(o9, p8, 1, p8.getPrice());
        OrderItem oi15 = new OrderItem(o9, p13, 1, p13.getPrice());
        OrderItem oi16 = new OrderItem(o9, p14, 1, p14.getPrice());
        
        // Pedido 10 - Julia (Xbox)
        OrderItem oi17 = new OrderItem(o10, p11, 1, p11.getPrice());

        orderItemRepository.saveAll(Arrays.asList(
            oi1, oi2, oi3, oi4, oi5, oi6, oi7, oi8, oi9, oi10,
            oi11, oi12, oi13, oi14, oi15, oi16, oi17
        ));

        // ===== PAGAMENTOS =====
        Payment pay1 = new Payment(null, Instant.parse("2024-11-15T14:35:00Z"), o1);
        o1.setPayment(pay1);
        
        Payment pay2 = new Payment(null, Instant.parse("2024-11-28T10:20:00Z"), o2);
        o2.setPayment(pay2);
        
        Payment pay4 = new Payment(null, Instant.parse("2024-11-20T09:25:00Z"), o4);
        o4.setPayment(pay4);
        
        Payment pay6 = new Payment(null, Instant.parse("2024-11-22T11:05:00Z"), o6);
        o6.setPayment(pay6);
        
        Payment pay7 = new Payment(null, Instant.parse("2024-12-02T15:25:00Z"), o7);
        o7.setPayment(pay7);

        orderRepository.saveAll(Arrays.asList(o1, o2, o4, o6, o7));

        System.out.println("✅ Banco de dados populado com sucesso!");
        System.out.println("📊 Estatísticas:");
        System.out.println("   - 5 Usuários");
        System.out.println("   - 15 Produtos");
        System.out.println("   - 5 Categorias");
        System.out.println("   - 10 Pedidos");
        System.out.println("   - 17 Itens de Pedidos");
    }
}
