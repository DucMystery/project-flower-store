package duc.controller;

import duc.model.Category;
import duc.service.CategoryService;
import duc.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public ModelAndView showCate(){
        Iterable<Category> categories = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/categories/list");
        modelAndView.addObject("categories",categories);
        return modelAndView;
    }

    @GetMapping("/create-category")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/categories/create");
        modelAndView.addObject("category",new Category());
        return modelAndView;
    }

    @PostMapping("/create-category")
    public ModelAndView saveCategory(@ModelAttribute("category")Category category){
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/categories/create");
        modelAndView.addObject("category",category);
        modelAndView.addObject("message","Thêm Thành công !");
        return modelAndView;
    }

    @GetMapping("/edit-category/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Category category = categoryService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/categories/edit");
        if (category!=null){
            modelAndView.addObject("category",category);
            return modelAndView;
        }else {
            modelAndView.addObject("message","Lỗi !");
            return modelAndView;
        }
    }

    @PostMapping("/edit-category")
    public ModelAndView updateCategory(@ModelAttribute("category") Category category){
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/categories/edit");
        modelAndView.addObject("category",category);
        modelAndView.addObject("message","Cập nhật thành công !");
        return modelAndView;
    }

    @GetMapping("/delete-category/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Category category = categoryService.findById(id);
        ModelAndView modelAndView= new ModelAndView("/categories/delete");
        if (category!=null){
            modelAndView.addObject("category",category);
        }else {
            modelAndView.addObject("message","Không thể xóa !");
        }
        return modelAndView;
    }

    @PostMapping("/delete-category")
    public String deleteCategory(@ModelAttribute("category")Category category){
        categoryService.remove(category.getCategory_id());
        return "redirect:/categories";
    }
}
