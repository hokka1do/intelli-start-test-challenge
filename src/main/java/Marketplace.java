import io.Printer;
import repo.ProductRepository;
import repo.PurchaseRepository;
import repo.UsersRepository;
import service.PurchaseService;

public class Marketplace {
    private static Printer printer;
    private static PurchaseService purchaseService;
    private static UsersRepository usersRepository;
    private static ProductRepository productRepository;
    private static PurchaseRepository purchaseRepository;

    private static void init() {
        printer = new Printer();
        usersRepository = new UsersRepository();
        productRepository = new ProductRepository();
        purchaseRepository = new PurchaseRepository();
        purchaseService = new PurchaseService(usersRepository, productRepository, purchaseRepository);
    }

    public static void main(String[] args) {
        init();
        execute();
    }

    private static void execute() {
        printer.printUsersList(usersRepository.getUserList());
        printer.printProductList(productRepository.getProductList());
        purchaseService.purchase(1L, 2L);
        purchaseService.purchase(1L, 1L);
        purchaseService.purchase(1L, 0L);
        printer.printProductList(purchaseRepository.findProductsByUserId(1L));
        printer.printUsersList(usersRepository.findUsersListById(purchaseRepository.findUsersIdByProductId(1L)));
    }
}