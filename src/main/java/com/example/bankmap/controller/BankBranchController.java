package com.example.bankmap.controller;

import com.example.bankmap.entity.BankBranch;
import com.example.bankmap.service.BankBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Administrator
 * 银行网点控制器类，它使用@RestController注解标记为一个RESTful Web服务。在其中，我们定义了一个名为getBankBranches()的GET请求处理方法，并使用@GetMapping注解将其映射到“/api/bankbranches”路径上。
 *
 * 该方法接受四个可选参数：searchTerm（搜索关键字），pageIndex（页码），pageSize（每页显示的记录数）和sortBy（按哪个字段进行排序）。我们将这些参数传递给BankBranchService类的search()方法来执行查询操作，并返回查询结果的列表
 */
@RestController
public class BankBranchController {

    @Autowired
    private BankBranchService bankBranchService;

    @GetMapping("/api/bank-branches")
    public List<BankBranch> getBankBranches(
            @RequestParam(required = false) String searchTerm,
            @RequestParam(required = false) Integer pageIndex,
            @RequestParam(required = false) Integer pageSize,
            @RequestParam(required = false) String sortBy) {
        return bankBranchService.search(searchTerm, pageIndex, pageSize, sortBy);
    }


}