package ru.saraev.myspringshop.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.saraev.myspringshop.services.ProductService;
import ru.saraev.myspringshop.services.StudentService;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final StudentService studentService;
    private final ProductService productService;

    // http://localhost:8189/app

    // http://localhost:8189/app/hello
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "<h1>Hello world!</h1>";
    }

    // http://localhost:8189/app/bye
    @GetMapping("/bye")
    @ResponseBody
    public String bye() {
        return "Have a nice day!";
    }

    // http://localhost:8189/app/calculate?first=4&second=2
    @GetMapping("/calculate")
    @ResponseBody
    public int calculate(@RequestParam(name = "first") int a,
                         @RequestParam(required = false, defaultValue = "0", name = "second") int b) {
        return a + b;
    }

    // http://localhost:8189/product/12/info
    @GetMapping("/product/{anyName}/info")
    @ResponseBody
    public String info(@PathVariable(name = "anyName") String id) {
        return "Product with id: " + id;
    }

    // 1) Приходит запрос на страницу page
    // 2) Создаем модель, которую отдадим на нашу страницу
    // 3) Thymeleaf вшивает модель, которую мы создали в страницу (перед тем как отдать ее)
    // http://localhost:8189/app/page
    @GetMapping("/page")
    public String page(Model model, @RequestParam Long id) {
        model.addAttribute("studentFront", studentService.getStudent(id));
        return "index.html";
    }

    @GetMapping("/students")
    public String students(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students.html";
    }

    @GetMapping("/product")
    public String product(Model model, @RequestParam Long id) {
        model.addAttribute("product", productService.getProduct(id));
        return "product-page.html";
    }

    @GetMapping("/products")
    public String products(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "products-page.html";
    }
}
