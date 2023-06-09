package com.example.bankmap.service;

import com.example.bankmap.entity.BankBranch;

import java.util.List;

/**
 * @author Administrator
 */
public interface BankBranchService {

    /**
     * 根据搜索关键字、页码、每页显示数量和排序字段来搜索银行网点信息。
     *
     * @param searchTerm 搜索关键字
     * @param pageIndex 页码
     * @param pageSize 每页显示数量
     * @param sortBy 排序字段
     * @return 符合条件的银行网点信息列表
     */
    List<BankBranch> search(String searchTerm, Integer pageIndex, Integer pageSize, String sortBy);

    /**
     * 更新银行网点信息。
     *
     * @param bankBranch 银行网点信息对象
     */
    void updateBankBranch(BankBranch bankBranch);

    /**
     * 删除指定id对应的银行网点信息。
     *
     * @param id 银行网点信息id
     */
    void deleteBankBranch(Long id);

}
