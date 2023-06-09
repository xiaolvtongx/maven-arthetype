package com.example.bankmap.repository;

import com.example.bankmap.entity.BankBranch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Administrator
 * 银行网点存储库，它使用JpaRepository接口作为其基本的CRUD操作接口。在其中，我们定义了一个findByNameContaining()方法用于根据名称的部分匹配来查询银行网点。
 *
 * 该方法接受两个参数：searchTerm和pageable。searchTerm表示要搜索的关键字，而pageable表示分页和排序设置。
 *
 * 该方法返回一个Page<BankBranch>对象，它包含与查询条件匹配的所有银行网点数据，并可以通过pageable参数进行分页和
 */



public interface BankBranchRepository extends JpaRepository<BankBranch, Long> {
    Page<BankBranch> findByNameContaining(String searchTerm, Pageable pageable);

}