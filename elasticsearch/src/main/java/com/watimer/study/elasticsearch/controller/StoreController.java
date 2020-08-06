package com.watimer.study.elasticsearch.controller;

import com.fasterxml.jackson.databind.node.IntNode;
import com.watimer.study.elasticsearch.docindex.repo.StoreRepository;
import com.watimer.study.elasticsearch.docindex.service.StoreDocumentIndexService;
import com.watimer.study.elasticsearch.document.StoreDocument;
import com.watimer.study.elasticsearch.document.store.StoreBaseInfo;
import com.watimer.study.elasticsearch.exception.BaseException;
import com.watimer.study.elasticsearch.global.Global;
import com.watimer.study.elasticsearch.response.ResponseResult;
import com.watimer.study.elasticsearch.search.impl.StoreSearchService;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

/**
 * store
 * @author 李锋镝
 * @date Create at 17:27 2019/8/23
 */
@RestController
@RequestMapping("/store")
public class StoreController extends BaseController {

    @Resource
    private StoreDocumentIndexService storeDocumentIndexService;

    @Resource
    private StoreRepository storeRepository;

    @Resource
    private StoreSearchService storeSearchService;

    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;

    @GetMapping("/createStoreIndex")
    public int createIndex(){
        StoreBaseInfo storeBaseInfo = new StoreBaseInfo();
        String uuid = UUID.randomUUID().toString();
        storeBaseInfo.setStoreId(uuid);
        storeBaseInfo.setStoreName("测试");

        boolean a = elasticsearchTemplate.createIndex(uuid,storeBaseInfo);
        System.out.println(uuid);
        if(a){
            return 1;
        }else{
            return 0;
        }
    }

    @GetMapping("/insertStore")
    public int insertStore(){
        insert(1,1,10000000);

        return 1;
    }

    private int insert(int a, int numStart, int numEnd){
        for(int i = numStart;i<numEnd;i++){
            StoreBaseInfo storeBaseInfo = new StoreBaseInfo();
            String uuid = UUID.randomUUID().toString();
            storeBaseInfo.setStoreId(uuid);
            storeBaseInfo.setStoreName("测试"+UUID.randomUUID().toString());
            storeBaseInfo.setStatus(UUID.randomUUID().toString());
            storeBaseInfo.setRegionCode(UUID.randomUUID().toString());
            storeBaseInfo.setRegionName(UUID.randomUUID().toString());
            storeBaseInfo.setStoreNo(UUID.randomUUID().toString());
            storeBaseInfo.setUpdatedUserName(UUID.randomUUID().toString());
            StoreDocument storeDocument = new StoreDocument();
            storeDocument.setBaseInfo(storeBaseInfo);
            storeDocument.setId(UUID.randomUUID().toString());

            storeRepository.save(storeDocument);
            System.out.println(i);
//            storeRepository.deleteAll();
        }
        return a;
    }

    /**
     * 保存索引
     * @param params 数据
     * @return ID
     */
    @PostMapping("/index")
    public ResponseResult index(@RequestBody Map<String, Object> params) {

        return ResponseResult.success(storeDocumentIndexService.index(params));
    }

    /**
     * 搜索
     * @param params 查询参数
     * @return 搜索结果
     */
    @PostMapping("/search")
    public ResponseResult search(@RequestBody Map<String, String> params) {

        return ResponseResult.success(storeSearchService.search(params));
    }

    /**
     * 搜索
     * @param params 查询参数
     * @return 搜索结果
     */
    @PostMapping("/aggregate")
    public ResponseResult aggregate(@RequestBody Map<String, String> params) {

        return ResponseResult.success(storeSearchService.aggregate(params));
    }

    /**
     * 搜索数量
     * @param params 查询参数
     * @return 搜索结果
     */
    @PostMapping("/count")
    public ResponseResult count(@RequestBody Map<String, String> params) {

        return ResponseResult.success(storeSearchService.count(params));
    }

    /**
     * 根据ID获取数据
     * @param id ID
     * @return 搜索结果
     */
    @GetMapping("/get/{id}")
    public ResponseResult get(@PathVariable String id) {
        return ResponseResult.success(storeSearchService.get(id));
    }

    /**
     * 批量更新
     * @param params 更新的数据
     * @return ResponseResult
     */
    @PostMapping("/sync/bulk/update")
    public ResponseResult bulkUpdate(@RequestBody Map<String, String> params) {
        if (!params.containsKey("ids") || !params.containsKey("source")) {
            return ResponseResult.fail(BaseException.NULL_PARAM_EXCEPTION.build());
        }
        storeDocumentIndexService.bulkUpdate(Arrays.asList(params.get("ids").split(Global.SPLIT_FLAG_COMMA)),
                params.get("source"));
        return ResponseResult.success(null);
    }

}
