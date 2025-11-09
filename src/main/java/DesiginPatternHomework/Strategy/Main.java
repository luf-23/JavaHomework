package DesiginPatternHomework.Strategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== 图书折扣系统（策略模式） ===");

        // 创建几本书（模拟输入或硬编码）
        Book[] books = {
                new Book("Java编程思想", 120.0, "CS"),
                new Book("新概念英语", 80.0, "EN"),
                new Book("三体", 59.9, "NOVEL"),
                new Book("经济学原理", 99.0, "OTHER")
        };

        // 为每本书根据类型自动配置折扣策略
        for (Book book : books) {
            book.applyStrategyByType();
            System.out.println(book);
        }

        System.out.println("\n--- 动态切换策略演示 ---");
        System.out.print("选择一本书（输入序号 0~" + (books.length - 1) + "）: ");
        int idx = sc.nextInt();
        if (idx >= 0 && idx < books.length) {
            Book selected = books[idx];
            System.out.println("当前: " + selected);

            System.out.println("可选策略：1-计算机类(7折) 2-英语类(6折) 3-小说类(8折) 4-无折扣");
            System.out.print("请选择新策略编号: ");
            int choice = sc.nextInt();

            DiscountStrategy newStrategy = switch (choice) {
                case 1 -> new ComputerDiscount();
                case 2 -> new EnglishDiscount();
                case 3 -> new NovelDiscount();
                default -> new NoDiscount();
            };

            selected.setDiscountStrategy(newStrategy);
            System.out.println("策略已更新 → " + selected);
        }

        sc.close();
    }
}
