package yuyu.app.base.systemsyoukai.tablesyoukai;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static yuyu.app.base.systemsyoukai.tablesyoukai.GenTableSyoukaiConstants.*;
import static yuyu.app.base.systemsyoukai.tablesyoukai.TableSyoukaiConstants.*;

import java.beans.PropertyDescriptor;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.resource.ResourceUtil;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.typesafe.AbstractExDBEntity;
import jp.co.slcs.swak.db.typesafe.ExDBPrimaryKey;
import jp.co.slcs.swak.util.string.ConvertUtil;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;
import lombok.Data;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_TblsSearchCondition;
import yuyu.def.db.entity.AM_TblsRefLimitSosiki;
import yuyu.def.db.entity.AM_TblsSearchPattern;
import yuyu.def.db.entity.AM_TblsTarget;
import yuyu.def.db.entity.AS_SubSystem;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;

/**
 * テーブル照会 のビジネスロジックです。
 */
public class TableSyoukaiBizLogic {

    @Inject
    private static Logger logger;

    @Inject
    private TableSyoukaiUiBean uiBean;

    @Inject
    private ExDBEntityManager em;

    @Inject
    private MessageManager msgManager;

    @Inject
    private TableSyoukaiDao dao;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    private List<SearchConditionBean> searchConditionBeanList = new ArrayList<>();

    private List<String> searchDdIdList  = new ArrayList<>();

    private Set<String> maskingDdSosikiSet = new HashSet<>();

    void init() {
        createSubsystemList();
    }

    void chkSrhCond() {
        if (Strings.isNullOrEmpty(uiBean.getBaseTableId()) && Strings.isNullOrEmpty(uiBean.getBaseTableNm())) {
            throw new BizLogicException(MessageId.EAC1002,
                    new Item[]{GenTableSyoukaiConstants.DDID_TABLESEARCHRESULTLIST_BASETABLEID,
                    GenTableSyoukaiConstants.DDID_TABLESEARCHRESULTLIST_BASETABLENM},
                    "テーブルID", "テーブル名" );
        }
    }

    @SuppressWarnings("deprecation")
    void getTableData(){
        List<AM_TblsTarget> tblTargets = dao.getTblTargetsBySubsystemIdTableIdTableNm(
                uiBean.getSubSystemId(),
                uiBean.getBaseTableId(),
                uiBean.getBaseTableNm());

        if(tblTargets == null || tblTargets.size() == 0){
            msgManager.addMessageId(MessageId.IAC0021, "テーブル");
            uiBean.setTableSearchResultList(null);
            return;
        }

        List<AM_TblsTarget> amTblTargets = new ArrayList<>();
        for (AM_TblsTarget tmpTblTargets : tblTargets){
            if (!YuyuBizConfig.getInstance().getTableSyoukaiSansyouHukaList().contains(tmpTblTargets.getBaseTableId())){
                amTblTargets.add(tmpTblTargets);
            }
        }

        if(amTblTargets.isEmpty() || amTblTargets.size() == 0){
            msgManager.addMessageId(MessageId.IAC0021, "テーブル");
            uiBean.setTableSearchResultList(null);
            return;
        }

        setupTableDatas(amTblTargets);

        Collections.sort(
                uiBean.getTableSearchResultList(),
                new Comparator<TableSearchResultListDataSourceBean>() {

                    @Override
                    public int compare(TableSearchResultListDataSourceBean o1, TableSearchResultListDataSourceBean o2) {
                        if(!o1.getBaseTableId().equals(o2.getBaseTableId())){
                            return o1.getBaseTableId().compareTo(o2.getBaseTableId());
                        }
                        return o1.getBaseSearchPtnNm().compareTo(o2.getBaseSearchPtnNm());
                    }

                });
    }

    void setupSearchConditionUiBean() {

        uiBean.setBkSelectTableId         (uiBean.getBaseTableId());
        uiBean.setBkSelectTableNm         (uiBean.getBaseTableNm());

        uiBean.setBaseTableId    (uiBean.getTableSearchResultListDataSource().getSelectedBean().getBaseTableId());
        uiBean.setBaseTableNm    (uiBean.getTableSearchResultListDataSource().getSelectedBean().getBaseTableNm());
        uiBean.setBaseSearchPtnNm(uiBean.getTableSearchResultListDataSource().getSelectedBean().getBaseSearchPtnNm());

        String[] searchDdNms = uiBean.getTableSearchResultListDataSource().getSelectedBean().getBaseSearchDdNm().split(",");
        List<InputSearchConditionDataSourceBean> inputDsBeanList = new ArrayList<>();

        for(String searchDdNm : searchDdNms){
            InputSearchConditionDataSourceBean inputDsBean = new InputSearchConditionDataSourceBean();
            inputDsBean.setBaseSearchDdNm(searchDdNm);
            inputDsBeanList.add(inputDsBean);
        }

        uiBean.setInputSearchCondition(inputDsBeanList);
    }

    @SuppressWarnings("deprecation")
    void resetData() {

        uiBean.setBaseToken("0");
        uiBean.setTokenBk("0");

        uiBean.setBaseTableId     (uiBean.getBkSelectTableId());
        uiBean.setBaseTableNm     (uiBean.getBkSelectTableNm());

        if(uiBean.getFieldsList()  != null) {
            uiBean.getFieldsList().clear();
        }
        if(uiBean.getFieldsBk()    != null) {
            uiBean.getFieldsBk().clear();
        }
        if(uiBean.getResultsList() != null) {
            uiBean.getResultsList().clear();
        }
        if(uiBean.getResultsBk()   != null) {
            uiBean.getResultsBk().clear();
        }
    }

    void clearSearchCondition() {
        for(InputSearchConditionDataSourceBean in : uiBean.getInputSearchConditionDataSource().getAllData()){
            if(!C_TblsSearchCondition.INPUT.eq(in.getBaseSearchConditionKbn())){
                in.setBaseSearchCondition(null);
            }
        }
    }

    void relationCheck() {
        List<InputSearchConditionDataSourceBean> inList = uiBean.getInputSearchConditionDataSource().getAllData();

        for(int i=0; i<inList.size()-1; i++){

            if(   C_TblsSearchCondition.NONE.eq(inList.get(i).getBaseSearchConditionKbn())
                    && !C_TblsSearchCondition.NONE.eq(inList.get(i+1).getBaseSearchConditionKbn())){
                throw new BizLogicException(MessageId.EAF1023);

            }
        }
    }

    void createMaskingDataMap(){

        final String sosikiCd = Strings.nullToEmpty(baseUserInfo.getTmSosikiCd());

        List<AM_TblsRefLimitSosiki> refPossibleDDList = dao.getTblsRefLimitSosiki(uiBean.getBaseTableId());

        maskingDdSosikiSet = new HashSet<>(
                ImmutableSet.copyOf(
                        Iterables.transform(refPossibleDDList,
                                new Function<AM_TblsRefLimitSosiki,String>(){
                            @Override
                            public String apply(AM_TblsRefLimitSosiki tblsRefLimitSosiki){
                                return tblsRefLimitSosiki.getBaseDdId().toUpperCase();
                            }
                        }
                                )
                        )
                );

        Set<String> refPossibleDDForSosikiSet = new HashSet<>(
                ImmutableSet.copyOf(
                        Iterables.transform(
                                Iterables.filter(
                                        refPossibleDDList,
                                        new Predicate<AM_TblsRefLimitSosiki>(){
                                            @Override
                                            public boolean apply(AM_TblsRefLimitSosiki tblsRefLimitSosiki){
                                                return sosikiCd.equals(tblsRefLimitSosiki.getTanmatusettisosikicd());
                                            }
                                        }
                                        ),new Function<AM_TblsRefLimitSosiki,String>(){
                                    @Override
                                    public String apply(AM_TblsRefLimitSosiki tblsRefLimitSosiki){
                                        return tblsRefLimitSosiki.getBaseDdId().toUpperCase();
                                    }
                                }
                                )
                        )
                );

        maskingDdSosikiSet.removeAll(refPossibleDDForSosikiSet);

    }

    void searchData(){

        StringBuilder sb = new StringBuilder();

        sb.append($SELECT);
        sb.append("*");
        sb.append($FROM);
        sb.append(uiBean.getBaseTableId());

        sb.append(makeSearchParameter());

        sb.append(makeOrderBy());

        createResultData(sb.toString());

    }

    void setTimeStamp() {

        String timeStamp = Long.valueOf(System.currentTimeMillis()).toString();

        uiBean.setBaseToken(timeStamp);
        uiBean.setTokenBk(timeStamp);
    }

    void chkTimeStamp() {

        if(uiBean.getTokenBk() != null
                && uiBean.getBaseToken() != null
                && !uiBean.getTokenBk().equals(uiBean.getBaseToken()))
        {
            throw new BizLogicException(MessageId.EAS0005);
        }

    }

    @SuppressWarnings("deprecation")
    void getDetailData() {

        List<ResultDetailListDataSourceBean> resultDetail = new ArrayList<>();

        int columnCount = uiBean.getColumnCount();

        int searchFieldCount = uiBean.getSearchFieldSet().size();

        int fieldCount = columnCount - searchFieldCount;

        int beginSearchFieldRowIndex = (uiBean.getBaseClickRowNo()-1) * searchFieldCount;

        for(int i = 0 ; i < searchFieldCount; i++){

            String searchDdNm  = uiBean.getFieldsListDataSource().getAllData().get(i).getBaseFieldNm();
            String searchDdVal = uiBean.getResultsListDataSource().getAllData().get(i+beginSearchFieldRowIndex).getBaseFieldValue();

            resultDetail.add(new ResultDetailListDataSourceBean(searchDdNm,searchDdVal));
        }

        int beginFieldRowIndex = (uiBean.getBaseClickRowNo()-1) * fieldCount;

        for(int i = 0 ; i < fieldCount; i++){

            String ddNm = uiBean.getFieldsBk().get(i).getBaseFieldNm();
            String ddVal = uiBean.getResultsBk().get(i+beginFieldRowIndex).getBaseFieldValue();

            resultDetail.add(new ResultDetailListDataSourceBean(ddNm,ddVal));
        }

        uiBean.setResultDetailList(resultDetail);

    }


    private void createSubsystemList() {

        List<AM_TblsTarget> targets = dao.getAllTblTargets();
        final Set<String> subsystemIdSet = new HashSet<>();
        for(AM_TblsTarget target : targets){
            subsystemIdSet.add(target.getSubSystemId());
        }


        UserDefsList list = new UserDefsList();

        list.addAll(
                ImmutableList.<LabelValuePair> builder()
                .addAll(
                        Iterables.transform(
                                new Ordering<AS_SubSystem>() {

                                    @Override
                                    public int compare(AS_SubSystem subsys1, AS_SubSystem subsys2) {
                                        return subsys1.getSortNo().compareTo(subsys2.getSortNo());
                                    }
                                }.sortedCopy(
                                        Iterables.filter(
                                                baseDomManager.getAllSubSystems(),
                                                new Predicate<AS_SubSystem>() {
                                                    @Override
                                                    public boolean apply(AS_SubSystem subSystem){
                                                        return subsystemIdSet.contains(subSystem.getSubSystemId());
                                                    }

                                                }
                                                )
                                        ),
                                        new Function<AS_SubSystem, LabelValuePair>() {
                                    @Override
                                    public LabelValuePair apply(AS_SubSystem subsys) {
                                        return new LabelValuePair(subsys.getSubSystemNm(), subsys.getSubSystemId());
                                    }
                                }
                                )
                        ).build()
                );

        uiBean.setSubSystemIdOptionBeanList(list);

    }

    private void setupTableDatas(List<AM_TblsTarget> tblTargets) {

        List<TableSearchResultListDataSourceBean> dsList =  new ArrayList<>();

        Set<List<String>> tableIdPtnNmSet = new HashSet<>();

        int count = 0;
        for(AM_TblsTarget tblTarget : tblTargets){
            for(AM_TblsSearchPattern searchPattern : tblTarget.getTblSearchPattern()){

                List<String> tableIdPtnNmList = Arrays.asList(searchPattern.getBaseTableId(),searchPattern.getBaseSearchPtnNm());

                if(tableIdPtnNmSet.contains(tableIdPtnNmList)){
                    continue;
                }

                if(count >= TABLE_SEARCH_PTN_RESULT_MAX_ROWS){
                    msgManager.addMessageId(MessageId.IAC0022);
                    break;
                }

                tableIdPtnNmSet.add(tableIdPtnNmList);

                TableSearchResultListDataSourceBean dsBean = new TableSearchResultListDataSourceBean();
                dsBean.setBaseSelectLink("選択");
                dsBean.setSubSystemNm(tblTarget.getSubsystem().getSubSystemNm());
                dsBean.setBaseTableId(tblTarget.getBaseTableId());
                dsBean.setBaseTableNm(tblTarget.getBaseTableNm());
                dsBean.setBaseSearchPtnNm(searchPattern.getBaseSearchPtnNm());

                dsBean.setBaseSearchDdNm(getSearchDDNms(dao.getSearchPatternByTableIdSearchPtnNm(searchPattern.getBaseTableId(), searchPattern.getBaseSearchPtnNm())));

                dsList.add(dsBean);

                count++;
            }
        }
        uiBean.setTableSearchResultList(dsList);

    }

    private String getSearchDDNms(List<AM_TblsSearchPattern> searchPatternsByTableIdPtnNm) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for(AM_TblsSearchPattern searchPattern : searchPatternsByTableIdPtnNm){
            if(!first) {
                sb.append(",");
            }

            TableDDInfoBean tableDdinfoBean = getFieldName(searchPattern.getBaseTableId(), searchPattern.getBaseSearchDdId());
            if(tableDdinfoBean == null){
                throw new RuntimeException();
            }

            sb.append(tableDdinfoBean.getDdNm());
            first = false;
        }
        return sb.toString();
    }

    @SuppressWarnings("rawtypes")
    TableDDInfoBean getFieldName(String tableId, String fieldId) {
        Map<String, Map<String, TableDDInfoBean>> tableDdNmMap = uiBean.getTableDdNmMap();
        Map<String, TableDDInfoBean> valueMap = new HashMap<>();

        if(tableDdNmMap == null){
            tableDdNmMap = new HashMap<>();
        }

        if(!tableDdNmMap.containsKey(tableId)){
            for (PropertyDescriptor prop : getEntity(tableId).getPersistProps()){

                String ddNm;

                switch(prop.getName()){
                    case "kousinsyaId" : ddNm = "更新者ＩＤ"; break;
                    case "kousinTime"  : ddNm = "更新時間";   break;
                    case "kousinKinou" : ddNm = "更新機能";   break;
                    case "version"     : ddNm = "バージョン"; break;
                    default            : ddNm = ResourceUtil.getApplicationResources().getString(tableId + "." + prop.getName());
                }
                Class clazz = prop.getPropertyType();

                valueMap.put(prop.getName().toUpperCase(), new TableDDInfoBean(ddNm, clazz));

                if(TWO_DBDD_JAVA_TYPE.containsKey(clazz)){
                    valueMap.put(
                            prop.getName().toUpperCase() +TWO_DBDD_JAVA_TYPE.get(clazz).getKey(),
                            new TableDDInfoBean(ddNm + TWO_DBDD_JAVA_TYPE.get(clazz).getValue(),clazz)
                            );
                }

            }
            tableDdNmMap.put(tableId, valueMap);
            uiBean.setTableDdNmMap(tableDdNmMap);
        }

        return tableDdNmMap.get(tableId).get(fieldId.toUpperCase());
    }

    @SuppressWarnings("unchecked")
    private <E extends AbstractExDBEntity<E,PK>, PK extends ExDBPrimaryKey<E,PK>>
    E getEntity(String tableId) {
        try {
            return (E) getEntityClass(tableId).newInstance();
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    private <E extends AbstractExDBEntity<E,PK>, PK extends ExDBPrimaryKey<E,PK>>
    Class<E> getEntityClass(String tableId) {
        try {
            return (Class<E>) Class.forName("yuyu.def.db.entity." + tableId);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private String makeSearchParameter() {
        StringBuilder sb = new StringBuilder();

        List<AM_TblsSearchPattern> searchPatterns = dao.getSearchPatternByTableIdSearchPtnNm(uiBean.getBaseTableId(), uiBean.getBaseSearchPtnNm());

        for(AM_TblsSearchPattern searchPattern : searchPatterns){
            searchDdIdList.add(searchPattern.getBaseSearchDdId());
        }

        setupSearchFieldSet(searchPatterns);

        List<InputSearchConditionDataSourceBean> inSearchCondition = uiBean.getInputSearchConditionDataSource().getAllData();
        int index = 0;
        boolean first = true;
        for(InputSearchConditionDataSourceBean in : inSearchCondition){

            if(C_TblsSearchCondition.INPUT.eq(in.getBaseSearchConditionKbn())){

                if(Strings.isNullOrEmpty(in.getBaseSearchCondition())){
                    throw new BizLogicException(MessageId.EAF0030,
                            new Item[]{DDID_INPUTSEARCHCONDITION_BASESEARCHCONDITIONKBN},
                            new String[]
                                    {C_TblsSearchCondition.INPUT.getContent(),
                            DDID_INPUTSEARCHCONDITION_BASESEARCHCONDITION.toString()}
                            );
                }

                makeWhere(sb, first);

                sb.append(searchPatterns.get(index).getBaseSearchDdId());
                sb.append(" = ?");

                searchConditionBeanList.add(
                        new SearchConditionBean(
                                searchPatterns.get(index).getBaseSearchDdId().toUpperCase(),
                                in.getBaseSearchCondition()
                                )
                        );

                first = false;
                index++;
            }else if (C_TblsSearchCondition.ISNULL.eq(in.getBaseSearchConditionKbn())){
                makeWhere(sb, first);

                sb.append(searchPatterns.get(index).getBaseSearchDdId());
                sb.append(" IS NULL");

                first = false;
                index++;
            }else if (C_TblsSearchCondition.BLANK.eq(in.getBaseSearchConditionKbn())){
                makeWhere(sb, first);

                sb.append(searchPatterns.get(index).getBaseSearchDdId());
                sb.append(" = ?");

                searchConditionBeanList.add(
                        new SearchConditionBean(
                                searchPatterns.get(index).getBaseSearchDdId().toUpperCase(),
                                ""
                                )
                        );


                first = false;
                index++;
            }

        }

        return sb.toString();
    }

    private String makeOrderBy() {

        StringBuilder sb= new StringBuilder();
        boolean first = true;
        for(String ddId : searchDdIdList){

            Map<String, Map<String, TableDDInfoBean>> map = uiBean.getTableDdNmMap();

            if(map.get(uiBean.getBaseTableId()).get(ddId.toUpperCase()).getType() == byte[].class){
                continue;
            }

            if(first){
                sb.append(" ORDER BY ");
                first = false;
            }else{
                sb.append(", ");
            }
            sb.append(ddId + $ASC);
        }

        return sb.toString();

    }

    private void setupSearchFieldSet(List<AM_TblsSearchPattern> searchPatterns) {
        Set<String> searchFieldSet = new HashSet<>();
        Map<String,Integer> fieldsSortNoMap = new HashMap<>();
        int i=1;

        for(AM_TblsSearchPattern searchPtn : searchPatterns){
            searchFieldSet.add(searchPtn.getBaseSearchDdId().toUpperCase());
            fieldsSortNoMap.put(searchPtn.getBaseSearchDdId().toUpperCase(), Integer.valueOf(i));
            i++;
        }

        uiBean.setFieldsSortNoMap(fieldsSortNoMap);
        uiBean.setSearchFieldSet(searchFieldSet);

    }

    private void makeWhere(StringBuilder pSb, boolean pFirst) {
        if(!pFirst) {
            pSb.append(" "+ $AND +" ");
        }else{
            pSb.append($WHERE);
        }
    }

    @SuppressWarnings({ "resource", "deprecation" })
    private void createResultData(String st) {
        Connection con = em.getJDBCConnection();
        int isoLevel = 0;
        boolean chgIsoLevelFlg = false;

        try {
            isoLevel = con.getTransactionIsolation();
            con.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
            chgIsoLevelFlg = true;
        } catch (@SuppressWarnings("unused") SQLException e) {
            logger.debug("トランザクション分離レベルの変更に失敗しました。");
        }

        try (PreparedStatement stmt = con.prepareStatement(st)) {

            stmt.setFetchSize(100);
            int count = 1;
            ResultSetMetaData stMeta = stmt.getMetaData();

            Map<String, MetadataBean> metaMap = createMetaMap(stMeta);

            for(SearchConditionBean condition : searchConditionBeanList){

                MetadataBean metadataBean = metaMap.get(condition.getDdId().toUpperCase());

                String searchCondition = null;

                switch (metadataBean.getColType()){
                    case Types.BIGINT  :
                    case Types.DECIMAL :
                    case Types.DOUBLE  :
                    case Types.FLOAT   :
                    case Types.INTEGER :
                    case Types.NUMERIC :
                    case Types.REAL    :

                        searchCondition = ConvertUtil.toHanAll(condition.getSearchCondition(), 0, 0).trim();

                        BigDecimal val = null;
                        try{
                            val = new BigDecimal(searchCondition);
                        }catch(@SuppressWarnings("unused") NumberFormatException e){
                            throw new BizLogicException(MessageId.EAC0052, getFieldName(uiBean.getBaseTableId(),condition.getDdId().toUpperCase()).getDdNm());
                        }

                        if (val.precision() - val.scale() > metadataBean.getPrecision() - metadataBean.getScale()
                                || val.scale() > metadataBean.getScale()) {
                            throw new BizLogicException(MessageId.EAC0052, getFieldName(uiBean.getBaseTableId(),condition.getDdId().toUpperCase()).getDdNm());
                        }

                        break;

                    default :
                        if(condition.getSearchCondition().length() > metadataBean.getPrecision()){
                            throw new BizLogicException(MessageId.EAC0052, getFieldName(uiBean.getBaseTableId(),condition.getDdId().toUpperCase()).getDdNm());
                        }

                        searchCondition = condition.getSearchCondition();
                }

                int scale = metadataBean.getScale();

                try{
                    if(scale > 0){
                        stmt.setObject(count, searchCondition, metadataBean.getColType(), scale);
                    }else{
                        stmt.setObject(count, searchCondition, metadataBean.getColType());
                    }
                }catch(@SuppressWarnings("unused") SQLException e){
                    throw new BizLogicException(MessageId.EAC0052, uiBean.getTableDdNmMap().get(uiBean.getBaseTableId()).get(condition.getDdId().toUpperCase()).getDdNm());
                }

                count++;
            }

            try (ResultSet rs = stmt.executeQuery()) {

                ResultSetMetaData meta = rs.getMetaData();
                int columnCount = meta.getColumnCount();
                uiBean.setColumnCount(columnCount);
                List<FieldsListDataSourceBean> fields = new ArrayList<>(columnCount);
                List<FieldsListDataSourceBean> fieldsBk = new ArrayList<>(columnCount);

                for (int colIndex = 1; colIndex <= columnCount; colIndex++) {
                    if(isSearchField(meta.getColumnName(colIndex))) {
                        fields.add(
                                new FieldsListDataSourceBean(
                                        uiBean.getFieldsSortNoMap().get(meta.getColumnName(colIndex).toUpperCase()),
                                        getFieldName(uiBean.getBaseTableId(), meta.getColumnName(colIndex)).getDdNm()
                                        )
                                );
                    } else {
                        fieldsBk.add(
                                new FieldsListDataSourceBean(
                                        colIndex,
                                        getFieldName(uiBean.getBaseTableId(), meta.getColumnName(colIndex)).getDdNm()
                                        )
                                );
                    }
                }

                Collections.sort(fields, new Comparator<FieldsListDataSourceBean>() {
                    @Override
                    public int compare(FieldsListDataSourceBean o1, FieldsListDataSourceBean o2) {
                        return o1.getBaseColNo() - o2.getBaseColNo();
                    }
                });

                uiBean.setFieldsList(fields);
                uiBean.setFieldsBk(fieldsBk);

                List<ResultsListDataSourceBean> results = new LinkedList<>();
                List<ResultsListDataSourceBean> resultsBk = new LinkedList<>();
                int rowIndex = 0;
                while (rs.next()) {
                    rowIndex++;

                    for (int colIndex = 1; colIndex <= columnCount; colIndex++){

                        String ddValue;
                        switch(meta.getColumnType(colIndex)){
                            case Types.BLOB   :
                            case Types.CLOB   :
                            case Types.BINARY :
                            case Types.NCLOB  : ddValue = (Strings.isNullOrEmpty(rs.getString(colIndex))) ? null : "[バイナリデータ]"; break;
                            default           : ddValue = rs.getString(colIndex); break;
                        }

                        String ddId = meta.getColumnName(colIndex).toUpperCase();

                        if(isSearchField(meta.getColumnName(colIndex))){
                            results.add(
                                    maskingData(
                                            rowIndex,
                                            uiBean.getFieldsSortNoMap().get(ddId),
                                            ddId,
                                            ddValue
                                            )
                                    );
                        }
                        else{
                            resultsBk.add(
                                    maskingData(
                                            rowIndex,
                                            colIndex,
                                            ddId,
                                            ddValue
                                            )
                                    );
                        }
                    }

                    if (rowIndex >= DATA_RESULT_MAX_ROWS) {
                        if (rs.next()){
                            msgManager.addMessageId(MessageId.IAC0022);
                        }
                        break;
                    }
                }

                if(rowIndex == 0){
                    msgManager.addMessageId(MessageId.IAC0021, "テーブルデータ");
                    uiBean.setResultsList(null);
                    uiBean.setResultsBk(null);
                    return;
                }

                Collections.sort(results, new Comparator<ResultsListDataSourceBean>() {
                    @Override
                    public int compare(ResultsListDataSourceBean o1, ResultsListDataSourceBean o2) {
                        if(o1.getBaseRowNo().equals(o2.getBaseRowNo())){
                            return o1.getBaseColNo().compareTo(o2.getBaseColNo());
                        }
                        return o1.getBaseRowNo().compareTo(o2.getBaseRowNo());
                    }
                });

                uiBean.setResultsList(results);
                uiBean.setResultsBk(resultsBk);
            }
        } catch (SQLException e) {
            logger.warn(e.getMessage(), e);
            throw new BizLogicException(MessageId.EAC1001);
        }finally{
            if(chgIsoLevelFlg){
                try {
                    con.setTransactionIsolation(isoLevel);
                } catch (SQLException e) {
                    logger.error("データベースエラーが発生しているため、トランザクション分離レベルの復元に失敗しました。");
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private Map<String, MetadataBean> createMetaMap(ResultSetMetaData metaData){
        Map<String, MetadataBean> metaMap = new HashMap<>();
        try {
            for(int colIndex = 1; colIndex <= metaData.getColumnCount(); colIndex++){
                metaMap.put(
                        metaData.getColumnName(colIndex).toUpperCase(),
                        new MetadataBean(
                                metaData.getScale(colIndex),
                                metaData.getColumnType(colIndex),
                                metaData.getPrecision(colIndex))
                        );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return metaMap;
    }

    private boolean isSearchField(String searchDdId) {
        return uiBean.getSearchFieldSet().contains(searchDdId.toUpperCase());
    }

    private ResultsListDataSourceBean maskingData(int rowNo, int colNo, String ddId, String ddVal){
        if(isMaskingData(ddId)){

            if(Strings.isNullOrEmpty(ddVal)){
                return new ResultsListDataSourceBean(rowNo, colNo, MASKING_NONE_DATA);
            }

            return new ResultsListDataSourceBean(rowNo, colNo, MASKING_DATA);
        }

        return new ResultsListDataSourceBean(rowNo, colNo, ddVal);
    }

    private boolean isMaskingData(String ddId){

        return maskingDdSosikiSet.contains(ddId);
    }

    @Data
    private class MetadataBean{
        MetadataBean(int pScale, int pColType, int pPrecision){
            scale     = pScale;
            colType   = pColType;
            precision = pPrecision;
        }
        private int scale;
        private int colType;
        private int precision;
    }

    @Data
    private class SearchConditionBean{
        SearchConditionBean(String pDdId, String pSearchCondition){
            ddId            = pDdId;
            searchCondition = pSearchCondition;
        }
        private String ddId;
        private String searchCondition;
    }

}
