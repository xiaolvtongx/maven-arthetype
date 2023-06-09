package com.example.bankmap.utils;

import com.example.bankmap.entity.BankBranch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * 搜索结果处理工具类。它包含了一个processSearchResult()方法，该方法接受五个参数：bankBranchList（要处理的银行网点列表）、searchTerm（搜索关键字）、pageIndex（页码）、pageSize（每页显示数量）和sortBy（排序字段）。
 *
 * 在其中，我们可以添加过滤、分页和排序逻辑，以便从银行网点列表中提取出符合条件的部分数据，并对其进行适当的排序和分页操作。然而，该方法目前只是简单地将原始银行网点列表返回，没有实现任何处理逻辑。
 */
public class SearchResultUtils {

    public static List<BankBranch> processSearchResult(List<BankBranch> bankBranchList, String searchTerm, Integer pageIndex, Integer pageSize, String sortBy) {
        // Add filtering, pagination, and sorting logic here.
                List<BankBranch> filteredList = new ArrayList<>(bankBranchList);

                // Filtering
                filteredList = filteredList.stream()
                        .filter(branch -> branch.getName().contains(searchTerm) || branch.getAddress().contains(searchTerm))
                        .collect(Collectors.toList());

                // Sorting
                switch (sortBy) {
                    case "name":
                        filteredList.sort(Comparator.comparing(BankBranch::getName));
                        break;
                    case "address":
                        filteredList.sort(Comparator.comparing(BankBranch::getAddress));
                        break;
                    case "distance":
                        // Implement distance-based sorting logic
                        break;
                    default:
                        // Handle the default sorting option
                }

                // Pagination
                int startIndex = pageIndex * pageSize;
                int endIndex = Math.min(startIndex + pageSize, filteredList.size());
                filteredList = filteredList.subList(startIndex, endIndex);

                return filteredList;

            }
        }
