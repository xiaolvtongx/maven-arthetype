package com.example.bankmap.impl;

import com.example.bankmap.entity.BankBranch;
import com.example.bankmap.repository.BankBranchRepository;
import com.example.bankmap.service.BankBranchService;
import com.example.bankmap.utils.SearchResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * 银行网点服务实现类，它实现了BankBranchService接口，并使用@Service注解将其标记为一个Spring Bean。
 *
 * 在其中，我们注入了BankBranchRepository类的实例，用于与数据库交互。该类实现了search()方法，它接受四个参数：searchTerm、pageIndex、pageSize和sortBy。我们使用Spring Data JPA提供的分页和排序支持来执行查询操作，并返回查询结果的列表。
 *
 * 另外，该类还实现了updateBankBranch()和deleteBankBranch()方法，用于更新和删除银行网点信息。这些方法仅调用相应的银行网点存储库方法即可完成操作。
 *
 * 最后，我们还可以看到SearchResultUtils类的引用，这是一个帮助类，用于将分页查询结果转换为可序列化的JSON格式。
 */
@Service
public class BankBranchServiceImpl implements BankBranchService {


    private BankBranchRepository bankBranchRepository;

//    @Override
//    public List<BankBranch> search(String searchTerm, Integer pageIndex, Integer pageSize, String sortBy) {
//        // Add search, pagination, and sorting logic here.
//        Sort sort = null;
//        if (sortBy != null && !sortBy.isEmpty()) {
//            sort = Sort.by(sortBy);
//        }
//        PageRequest pageRequest = PageRequest.of(pageIndex, pageSize, sort);
//        Page<BankBranch> page = bankBranchRepository.findByNameContaining(searchTerm, pageRequest);
//        return page.getContent();
//    }
    @Override
    public List<BankBranch> search(String searchTerm, Integer pageIndex, Integer pageSize, String sortBy) {
        // Add search, pagination, and sorting logic here.
        Sort sort = null;
        if (sortBy != null && !sortBy.isEmpty()) {
            sort = Sort.by(sortBy);
        }
        PageRequest pageRequest = PageRequest.of(pageIndex, pageSize, sort);
        Page<BankBranch> page = bankBranchRepository.findByNameContaining(searchTerm, pageRequest);
        List<BankBranch> searchResult = page.getContent();
        return SearchResultUtils.processSearchResult(searchResult, searchTerm, pageIndex, pageSize, sortBy);
    }

    @Override
    public void updateBankBranch(BankBranch bankBranch) {
        bankBranchRepository.save(bankBranch);
    }

    @Override
    public void deleteBankBranch(Long id) {
        bankBranchRepository.deleteById(id);
    }


}