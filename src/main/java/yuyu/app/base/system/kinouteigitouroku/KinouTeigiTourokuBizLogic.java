package yuyu.app.base.system.kinouteigitouroku;

import static yuyu.app.base.system.kinouteigitouroku.GenKinouTeigiTourokuConstants.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;

import org.slf4j.Logger;

import yuyu.common.base.collection.predicate.CheckedCommonCheckBoxPredicate;
import yuyu.def.MessageId;
import yuyu.def.base.configuration.YuyuBaseConfig;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_KousinNaiyouHaneiKbn;
import yuyu.def.classification.C_SysSiyouKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukouKbn;
import yuyu.def.db.entity.AM_Role;
import yuyu.def.db.entity.AS_Category;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.def.db.entity.AS_KinouModeSiborikomi;
import yuyu.def.db.entity.AS_SubSystem;
import yuyu.def.db.entity.AT_KadouTimeGroup;
import yuyu.def.db.entity.AT_KinouKengen;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

/**
 * 機能定義登録 のビジネスロジックです。
 */
public class KinouTeigiTourokuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KinouTeigiTourokuUiBean uiBean;

    @Inject
    private MessageManager message;

    @Inject
    private BaseDomManager manager;

    @Inject
    private YuyuBaseConfig config;

    void init() {
        clear();
        setSubSystemSelectList();
        setKinouModeList("");
        uiBean.setSubSystemEnableFlg(config.isSubSystemEnableFlg());
    }

    void clear() {
        uiBean.setSubSystemId(null);
        uiBean.setKengenSetteiList(null);
        uiBean.setBakRoleInfo(null);
    }

    void filterKinouModelList() {
        setKinouModeList(uiBean.getSubSystemId());
    }

    void setupUiBean() {

        KinouModeInfoListDataSourceBean selectedData = uiBean.getKinouModeInfoListDataSource().getSelectedBean();

        uiBean.setSubSystem(new AS_SubSystem());
        uiBean.setCategory(new AS_Category());
        uiBean.setKinou(new AS_Kinou());
        uiBean.setKinouMode(new AS_KinouMode());

        uiBean.getSubSystem().setSubSystemId(selectedData.getSubSystemId());
        uiBean.getSubSystem().setSubSystemNm(selectedData.getSubSystemNm());
        uiBean.getCategory().setCategoryId(selectedData.getCategoryId());
        uiBean.getCategory().setCategoryNm(selectedData.getCategoryNm());
        uiBean.getKinou().setKinouId(selectedData.getKinouId());
        uiBean.getKinou().setKinouNm(selectedData.getKinouNm());
        uiBean.getKinou().setKinouKbn(selectedData.getKinouKbn());
        uiBean.getKinou().setKidouKengenHanteiYouhiKbn(selectedData.getKidouKengenHanteiYouhiKbn());
        uiBean.getKinouMode().setKinouModeId(selectedData.getKinouModeId());
        uiBean.getKinouMode().setKinouModeNm(selectedData.getKinouModeNm());

        AS_Kinou kinou = manager.getKinou(selectedData.getKinouId());
        AS_KinouMode kinouMode = kinou.getKinouMode(selectedData.getKinouModeId());

        uiBean.getKinouMode().setYuukouKbn(kinouMode.getYuukouKbn());

        uiBean.getKinouMode().setYuukouKaisiYmd(kinouMode.getYuukouKaisiYmd());
        uiBean.setKousinNaiyouHaneiKbn(C_KousinNaiyouHaneiKbn.KINOU_MODE);

        uiBean.setKinou(kinou);

        setForm();
    }


    void chkRelation() {

        if (C_YuukouKbn.BYDATE.eq(uiBean.getKinouMode().getYuukouKbn())) {

            BizDate yuukouKaisiYmd = uiBean.getKinouMode().getYuukouKaisiYmd();

            if (yuukouKaisiYmd == null) {
                throw new BizLogicException(MessageId.EAV0001, DDID_SYSTEMSETTEIINFO_YUUKOUKAISIYMD);
            }

            if (yuukouKaisiYmd.compareTo(BizDate.getSysDate()) <= 0) {
                throw new BizLogicException(MessageId.EAC0008, DDID_SYSTEMSETTEIINFO_YUUKOUKAISIYMD);
            }
        }
        else {
            uiBean.getKinouMode().setYuukouKaisiYmd(null);
        }

        if (!C_KinouKbn.BATCH.eq(uiBean.getKinou().getKinouKbn()) &&
            Strings.isNullOrEmpty(uiBean.getKinouMode().getKadouTimeGroupCd())) {
            throw new BizLogicException(MessageId.EAC0042, DDID_SYSTEMSETTEIINFO_KADOUTIMEGROUPCD);
        }

        chkSiborikomiId();

    }

    void setHaneiList() {

        uiBean.setBakRoleInfo(uiBean.getKengenSetteiListDataSource().getAllData());

        List<KengenSetteiListDataSourceBean> KengenSetteiList = uiBean.getKengenSetteiListDataSource().getAllData();

        for (KengenSetteiListDataSourceBean dsBean : KengenSetteiList) {
            if (!dsBean.getCommonCheckBox()) {
                dsBean.setSiborikomiId(null);
            }
        }

        if (C_KousinNaiyouHaneiKbn.KINOU_MODE.eq(uiBean.getKousinNaiyouHaneiKbn())) {
            uiBean.setKinouModeInfoList(null);
        }
        else if (C_KousinNaiyouHaneiKbn.KINOU.eq(uiBean.getKousinNaiyouHaneiKbn())) {
            AS_Kinou kinou = manager.getKinou(uiBean.getKinou().getKinouId());

            List<AS_Kinou> kinouList = Lists.newArrayList();
            kinouList.add(kinou);
            setKinouList(kinouList);
        }
        else if (C_KousinNaiyouHaneiKbn.CATEGORY.eq(uiBean.getKousinNaiyouHaneiKbn())) {
            List<AS_Kinou> kinouList = manager.getKinousByCategory(uiBean.getCategory().getCategoryId());

            Ordering<AS_Kinou> ordering = Ordering.from(new KinouInfoSortComparator());
            List<AS_Kinou> sortedList = ordering.sortedCopy(kinouList);

            setKinouList(sortedList);
        }
        else if (C_KousinNaiyouHaneiKbn.SUBSYSTEM.eq(uiBean.getKousinNaiyouHaneiKbn())) {
            List<AS_Kinou> kinouList = manager.getKinousBySubSystem(uiBean.getSubSystem().getSubSystemId());

            setKinouList(kinouList);
        }
    }

    void setConfirmMessage() {

        message.addMessageId(MessageId.QAC0009);

        if (!C_KousinNaiyouHaneiKbn.KINOU_MODE.eq(uiBean.getKousinNaiyouHaneiKbn())) {
            message.addMessageId(MessageId.WAF0002,
                MessageUtil.getMessage(DDID_HANEIKBNINFO_KOUSINNAIYOUHANEIKBN.getErrorResourceKey()),
                C_KousinNaiyouHaneiKbn.getContentByValue(uiBean.getKousinNaiyouHaneiKbn().getValue()),
                MessageUtil.getMessage(MessageId.IAW0039));

        }

    }

    void resetInitUiBean() {
        uiBean.setKinouModeInfoList(uiBean.getKinouModeInfoListDataSourceBeanBak());

        List<KengenSetteiListDataSourceBean> kengenSetteiListDSBeanList = uiBean.getKengenSetteiListDataSource().getAllData();

        for (int i=0; i<kengenSetteiListDSBeanList.size();i++ ) {
            kengenSetteiListDSBeanList.get(i).clearSiborikomiIdOptionBeanList();
        }
    }

    @Transactional
    void commitKinou() {

        if (C_KousinNaiyouHaneiKbn.KINOU_MODE.eq(uiBean.getKousinNaiyouHaneiKbn())) {

            comittKinouModeSingle();
        }
        else {
            commitKinouModeMultiple();
        }
        message.addMessageId(MessageId.IAC0015);
    }

    void chkReferenceMaster(){

        if(!chkExistUserRole()){
            throw new BizLogicException(MessageId.EAC0046, MessageUtil.getMessage(MessageId.IAW0037));
        }

        String kadouTimeCd = uiBean.getKinouMode().getKadouTimeGroupCd();
        AT_KadouTimeGroup kadouTimeGroup = manager.getKadouTimeGroup(kadouTimeCd);

        if(kadouTimeGroup == null){
            throw new BizLogicException(MessageId.EAC0001, DDID_SYSTEMSETTEIINFO_KADOUTIMEGROUPCD);
        }

    }

    void setRoleInfo() {
        setForm();
    }

    private void setForm() {

        uiBean.clearKadouTimeGroupCdOptionBeanList();

        UserDefsList udList = new UserDefsList();
        LabelValuePair pair = new LabelValuePair();
        pair.setLabel("");
        pair.setValue("");
        udList.add(pair);

        List<AT_KadouTimeGroup> kadouTimeGroupList = manager.getAllKadouTimeGroups();

        for (AT_KadouTimeGroup kadouTimeGroup : kadouTimeGroupList) {
            pair = new LabelValuePair();
            pair.setLabel(kadouTimeGroup.getKadouTimeGroupNm());
            pair.setValue(kadouTimeGroup.getKadouTimeGroupCd());
            udList.add(pair);
        }

        uiBean.setKadouTimeGroupCdOptionBeanList(udList);

        AS_Kinou kinou = uiBean.getKinou();

        AS_KinouMode kinouMode =  kinou.getKinouMode(uiBean.getKinouMode().getKinouModeId());
        uiBean.getKinouMode().setKadouTimeGroupCd(kinouMode.getKadouTimeGroupCd());

        List<AS_KinouModeSiborikomi> kinouModeSiborikomiList = kinouMode.getKinouModeSiborikomis();

        Collections.sort(kinouModeSiborikomiList,new Comparator<AS_KinouModeSiborikomi>(){
            @Override
            public int compare(AS_KinouModeSiborikomi siborikomi1, AS_KinouModeSiborikomi siborikomi2) {
                return siborikomi1.getSiborikomiId().compareTo(siborikomi2.getSiborikomiId());
            }
        });

        udList = new UserDefsList();

        if (kinouModeSiborikomiList.isEmpty()) {
            uiBean.setKinouModeSiborikomiDataumuFlg(false);
        }
        else {
            uiBean.setKinouModeSiborikomiDataumuFlg(true);

            pair = new LabelValuePair();
            pair.setLabel("");
            pair.setValue("");
            udList.add(pair);
            for (AS_KinouModeSiborikomi kinouModeSiborikomi : kinouModeSiborikomiList) {
                pair = new LabelValuePair();
                pair.setLabel(kinouModeSiborikomi.getSiborikomiNm());
                pair.setValue(kinouModeSiborikomi.getSiborikomiId());
                udList.add(pair);
            }
        }


        List<AM_Role> roleList = ImmutableList.copyOf(Iterables.filter(manager.getAllRoles(), new RoleEntityFilter()));

        List<AT_KinouKengen> kinouKengenList = kinouMode.getKinouKengens();

        List<KengenSetteiListDataSourceBean> kengenSetteiListDSBeanList = Lists.newArrayList();

        List<KengenSetteiListDataSourceBean> kengenUiBeanList = uiBean.getKengenSetteiListDataSource().getAllData();

        for (AM_Role role : roleList) {
            KengenSetteiListDataSourceBean kengenSetteiListDSBean = new KengenSetteiListDataSourceBean();
            kengenSetteiListDSBean.setCommonCheckBox(false);
            kengenSetteiListDSBean.setRoleCd(role.getRoleCd());
            kengenSetteiListDSBean.setRoleNm(role.getRoleNm());
            kengenSetteiListDSBean.setRoleSetumei(role.getRoleSetumei());

            if (kinouKengenList.size() == 0) {
                setRoleList(role, kengenSetteiListDSBean, kengenUiBeanList);
            } else {
                for (AT_KinouKengen kinouKengen : kinouKengenList) {
                    if (role.getRoleCd().equals(kinouKengen.getRoleCd()) && kengenUiBeanList.size() == 0) {
                        kengenSetteiListDSBean.setCommonCheckBox(true);
                        kengenSetteiListDSBean.setSiborikomiId(kinouKengen.getSiborikomiId());
                        break;
                    } else if (kengenUiBeanList.size() > 0) {
                        setRoleList(role, kengenSetteiListDSBean, kengenUiBeanList);
                    }
                }
            }
            kengenSetteiListDSBeanList.add(kengenSetteiListDSBean);
        }

        for (KengenSetteiListDataSourceBean dsBean : kengenSetteiListDSBeanList) {
            dsBean.setSiborikomiIdOptionBeanList(udList);
        }

        if(uiBean.getBakRoleInfo() != null){
            resetChkBox(kengenSetteiListDSBeanList);
        }

        uiBean.setKengenSetteiList(kengenSetteiListDSBeanList);

        uiBean.setKinouModeInfoListDataSourceBeanBak(uiBean.getKinouModeInfoListDataSource().getDatas());
    }

    private void comittKinouModeSingle() {

        AS_Kinou kinouEntity = uiBean.getKinou();
        updateKinouModeSingle(kinouEntity);

        if (C_YouhiKbn.YOU.eq(uiBean.getKinou().getKidouKengenHanteiYouhiKbn())) {

            AS_KinouMode kinouModeEntity =  kinouEntity.getKinouMode(uiBean.getKinouMode().getKinouModeId());

            List<KengenSetteiListDataSourceBean> filteredKengenList =
                ImmutableList.copyOf(Iterables.filter(uiBean.getKengenSetteiListDataSource().getDatas(),
                    new CheckedCommonCheckBoxPredicate()));

            deleteKinouKengen(kinouModeEntity, filteredKengenList);

            List<AT_KinouKengen> kinouKengenList = kinouModeEntity.getKinouKengens();

            for (KengenSetteiListDataSourceBean filterdKengenDsBean : filteredKengenList) {

                AT_KinouKengen aT_KinouKengen = getKinouKengenEntity(kinouKengenList, filterdKengenDsBean.getRoleCd());

                updateInsertKinouKengen(aT_KinouKengen,
                    uiBean.getKinou().getKinouId(),
                    uiBean.getKinouMode().getKinouModeId(),
                    filterdKengenDsBean.getRoleCd(),
                    filterdKengenDsBean.getSiborikomiId(),
                    kinouModeEntity);
            }
        }
    }

    private void commitKinouModeMultiple() {

        List<KinouModeInfoListDataSourceBean> hanneiList = uiBean.getKinouModeInfoListDataSource().getDatas();

        updateKinouModeMultiple();

        if (C_YouhiKbn.YOU.eq(uiBean.getKinou().getKidouKengenHanteiYouhiKbn())) {

            for (KinouModeInfoListDataSourceBean hanneiDsBean : hanneiList) {

                if (C_YouhiKbn.YOU.eq(hanneiDsBean.getKidouKengenHanteiYouhiKbn())) {

                    AS_Kinou kinouEntity = manager.getKinou(hanneiDsBean.getKinouId());
                    AS_KinouMode kinouModeEntity =  kinouEntity.getKinouMode(hanneiDsBean.getKinouModeId());

                    List<KengenSetteiListDataSourceBean> filteredKengenList =
                        ImmutableList.copyOf(Iterables.filter(uiBean.getKengenSetteiListDataSource().getDatas(),
                            new CheckedCommonCheckBoxPredicate()));

                    deleteKinouKengen(kinouModeEntity, filteredKengenList);

                    List<AT_KinouKengen> kinouKengenList = kinouModeEntity.getKinouKengens();

                    for (KengenSetteiListDataSourceBean filterdKengenDsBean : filteredKengenList) {

                        String siborikomiId = filterdKengenDsBean.getSiborikomiId();

                        AT_KinouKengen aT_KinouKengen = getKinouKengenEntity(kinouKengenList, filterdKengenDsBean.getRoleCd());

                        if (isExistSikibetuId(hanneiDsBean, kinouModeEntity, filterdKengenDsBean, aT_KinouKengen)) {
                            updateInsertKinouKengen(aT_KinouKengen,
                                hanneiDsBean.getKinouId(),
                                hanneiDsBean.getKinouModeId(),
                                filterdKengenDsBean.getRoleCd(),
                                filterdKengenDsBean.getSiborikomiId(),
                                kinouModeEntity);

                            filterdKengenDsBean.setSiborikomiId(siborikomiId);
                        }
                    }
                }
            }
        }
    }

    private boolean isExistSikibetuId(KinouModeInfoListDataSourceBean pHanneiDsBean,
        AS_KinouMode pKinouModeEntity,
        KengenSetteiListDataSourceBean pFilteredKengenList,
        AT_KinouKengen pKinouKengen) {

        AS_KinouModeSiborikomi kinouModeSiborikomi =
            pKinouModeEntity.getKinouModoSiborikomi(pFilteredKengenList.getSiborikomiId());

        if (kinouModeSiborikomi != null) {
            return true;
        } else if (pKinouKengen == null) {
            pFilteredKengenList.setSiborikomiId(null);
            return true;
        }

        return false;
    }

    private void updateKinouModeSingle(AS_Kinou pKinouEntity) {

        AS_KinouMode kinouModeEntity =  pKinouEntity.getKinouMode(uiBean.getKinouMode().getKinouModeId());

        kinouModeEntity.setYuukouKbn(uiBean.getKinouMode().getYuukouKbn());

        if (!C_YuukouKbn.BYDATE.eq(uiBean.getKinouMode().getYuukouKbn())) {
            kinouModeEntity.setYuukouKaisiYmd(null);
        } else {
            kinouModeEntity.setYuukouKaisiYmd(uiBean.getKinouMode().getYuukouKaisiYmd());
        }

        if (!C_KinouKbn.BATCH.eq(uiBean.getKinou().getKinouKbn())) {
            kinouModeEntity.setKadouTimeGroupCd(uiBean.getKinouMode().getKadouTimeGroupCd());
        }

    }

    private void updateKinouModeMultiple() {
        List<KinouModeInfoListDataSourceBean> hanneiList = uiBean.getKinouModeInfoListDataSource().getDatas();
        for (KinouModeInfoListDataSourceBean dsBean : hanneiList) {
            AS_Kinou kinouEntity = manager.getKinou(dsBean.getKinouId());
            AS_KinouMode kinouModeEntity =  kinouEntity.getKinouMode(dsBean.getKinouModeId());

            kinouModeEntity.setYuukouKbn(uiBean.getKinouMode().getYuukouKbn());

            if (!C_YuukouKbn.BYDATE.eq(uiBean.getKinouMode().getYuukouKbn())) {
                kinouModeEntity.setYuukouKaisiYmd(null);
            } else {
                kinouModeEntity.setYuukouKaisiYmd(uiBean.getKinouMode().getYuukouKaisiYmd());
            }

            if (!C_KinouKbn.BATCH.eq(uiBean.getKinou().getKinouKbn())) {
                kinouModeEntity.setKadouTimeGroupCd(uiBean.getKinouMode().getKadouTimeGroupCd());
            }

        }
    }

    private void setSubSystemSelectList() {

        uiBean.clearSubSystemIdOptionBeanList();

        List<AS_SubSystem> subSystems = manager.getAllSubSystemsSortNoOrder();

        LabelValuePair pair = new LabelValuePair();
        pair.setLabel("");
        pair.setValue("");

        UserDefsList udList = new UserDefsList();
        udList.add(pair);

        for (AS_SubSystem subSystem : subSystems) {
            pair = new LabelValuePair();
            pair.setLabel(subSystem.getSubSystemNm());
            pair.setValue(subSystem.getSubSystemId());
            udList.add(pair);
        }

        uiBean.setSubSystemIdOptionBeanList(udList);
    }

    private void setKinouModeList(String pSubSystemId) {

        List<AS_Kinou> kinouList;

        if (Strings.isNullOrEmpty(pSubSystemId)) {
            kinouList = BeanUtil.createList(AS_Kinou.class,
                ImmutableList.copyOf(Iterables.filter(manager.getAllKinous4KinouList(), new KinouEntityPredicate())));
        }
        else {
            kinouList = BeanUtil.createList(AS_Kinou.class,
                ImmutableList.copyOf(Iterables.filter(manager.getKinousBySubSystem(pSubSystemId), new KinouEntityPredicate())));
        }

        String henkouMsg = MessageUtil.getMessage(DDID_KINOUMODEINFOLIST_HENKOULINK.getErrorResourceKey());

        List<KinouModeInfoListDataSourceBean> dsBeanList = Lists.newArrayList();
        KinouModeInfoListDataSourceBean dsBean;

        for (AS_Kinou kinou : kinouList) {

            Ordering<AS_KinouMode> ordering = Ordering.natural().nullsFirst().onResultOf(new KinouModeInfoSortFunction());
            List<AS_KinouMode> sortedKinouModeList = ordering.sortedCopy(kinou.getKinouModes());

            for (AS_KinouMode kinouMode : sortedKinouModeList) {
                dsBean = new KinouModeInfoListDataSourceBean();
                dsBean.setSubSystemId(kinou.getSubSystem().getSubSystemId());
                dsBean.setSubSystemNm(kinou.getSubSystem().getSubSystemNm());
                dsBean.setCategoryId(kinou.getCategory().getCategoryId());
                dsBean.setCategoryNm(kinou.getCategory().getCategoryNm());
                dsBean.setKinouId(kinou.getKinouId());
                dsBean.setKinouNm(kinou.getKinouNm());
                dsBean.setKinouModeId(kinouMode.getKinouModeId());
                dsBean.setKinouModeNm(kinouMode.getKinouModeNm());
                dsBean.setHenkouLink(henkouMsg);
                dsBean.setKinouKbn(kinou.getKinouKbn());
                dsBean.setKidouKengenHanteiYouhiKbn(kinou.getKidouKengenHanteiYouhiKbn());
                dsBeanList.add(dsBean);
            }
        }

        uiBean.setKinouModeInfoList(dsBeanList);
    }

    private void setKinouList(List<AS_Kinou> pKinouList) {

        List<KinouModeInfoListDataSourceBean> sourceBeanList = Lists.newArrayList();
        KinouModeInfoListDataSourceBean sourceBean = new KinouModeInfoListDataSourceBean();

        for (AS_Kinou Kinou : pKinouList) {

            Set<AS_KinouMode>  kinouModeList = Kinou.getKinouModes();

            Ordering<AS_KinouMode> ordering = Ordering.natural().nullsFirst().onResultOf(new KinouModeInfoSortFunction ());
            List<AS_KinouMode> sortedKinouModeList = ordering.sortedCopy(kinouModeList);

            for (AS_KinouMode kinouMode : sortedKinouModeList) {

                sourceBean = new KinouModeInfoListDataSourceBean();

                sourceBean.setSubSystemId(Kinou.getSubSystem().getSubSystemId());
                sourceBean.setSubSystemNm(Kinou.getSubSystem().getSubSystemNm());
                sourceBean.setCategoryId(Kinou.getCategory().getCategoryId());
                sourceBean.setCategoryNm(Kinou.getCategory().getCategoryNm());
                sourceBean.setKinouId(Kinou.getKinouId());
                sourceBean.setKinouNm(Kinou.getKinouNm());
                sourceBean.setKinouModeId(kinouMode.getKinouModeId());
                sourceBean.setKinouModeNm(kinouMode.getKinouModeNm());
                sourceBean.setKidouKengenHanteiYouhiKbn(Kinou.getKidouKengenHanteiYouhiKbn());

                sourceBeanList.add(sourceBean);
            }
        }

        uiBean.setKinouModeInfoList(sourceBeanList);
    }

    private void deleteKinouKengen(AS_KinouMode pKinouModeEntity,
        List<KengenSetteiListDataSourceBean> pFilteredKengenList) {

        List<AT_KinouKengen> kinouKengenList = pKinouModeEntity.getKinouKengens();
        List<AT_KinouKengen> delKinouKengenList = Lists.newArrayList();

        boolean existFlag;

        for (AT_KinouKengen kinouKengen : kinouKengenList) {

            existFlag = false;

            if(C_SysSiyouKbn.SYSSIYOU.eq(kinouKengen.getRole().getSysSiyouKbn())){
                continue;
            }

            for (KengenSetteiListDataSourceBean dsBean : pFilteredKengenList) {
                if (kinouKengen.getRoleCd().equals(dsBean.getRoleCd())) {
                    existFlag = true;
                    break;
                }
            }

            if (!existFlag) {
                delKinouKengenList.add(kinouKengen);
            }
        }

        pKinouModeEntity.getKinouKengens().removeAll(delKinouKengenList);
        manager.update(pKinouModeEntity);
    }

    private static AT_KinouKengen getKinouKengenEntity(List<AT_KinouKengen> pKinouKengenList,
        String pRoleCd) {

        for (AT_KinouKengen kinouKengen : pKinouKengenList) {
            if (kinouKengen.getRoleCd().equals(pRoleCd)) {
                return kinouKengen;
            }
        }
        return null;
    }

    private void updateInsertKinouKengen(AT_KinouKengen pKinouKengen,
        String pKinouID,
        String pKinouModeId,
        String pRoleCd,
        String pSiborikomiId,
        AS_KinouMode pKinouMode) {

        if (pKinouKengen != null) {
            AT_KinouKengen kinouKengen = pKinouMode.getKinouKengen(pKinouKengen.getRoleCd());
            kinouKengen.setSiborikomiId(pSiborikomiId);
            manager.update(pKinouMode);
        }
        else {

            AT_KinouKengen kinouKengen = pKinouMode.createKinouKengen();
            kinouKengen.setKinouId(pKinouID);
            kinouKengen.setKinouModeId(pKinouModeId);
            kinouKengen.setRoleCd(pRoleCd);
            kinouKengen.setSiborikomiId(pSiborikomiId);

            manager.insert(pKinouMode);
        }
    }

    private boolean chkExistUserRole(){

        List<KengenSetteiListDataSourceBean> filteredList = ImmutableList.copyOf(
            Iterables.filter(uiBean.getKengenSetteiListDataSource().getDatas(), new CheckedCommonCheckBoxPredicate()));

        for(KengenSetteiListDataSourceBean roleInfo : filteredList){

            if(manager.getRole(roleInfo.getRoleCd()) == null){

                setForm();

                return false;
            }

        }
        return true;
    }

    private void resetChkBox(List<KengenSetteiListDataSourceBean> pDsList) {

        for(KengenSetteiListDataSourceBean ds : pDsList){
            for(KengenSetteiListDataSourceBean bk : uiBean.getBakRoleInfo().getAllData()){

                if(ds.getRoleCd().equals(bk.getRoleCd())){
                    ds.setCommonCheckBox(bk.getCommonCheckBox());
                    ds.setSiborikomiId(bk.getSiborikomiId());
                }
            }
        }
    }

    private void chkSiborikomiId() {

        List<KengenSetteiListDataSourceBean> filteredList = ImmutableList.copyOf(
            Iterables.filter(uiBean.getKengenSetteiListDataSource().getDatas(), new CheckedCommonCheckBoxPredicate()));

        for(KengenSetteiListDataSourceBean roleInfo : filteredList){

            if (Strings.isNullOrEmpty(roleInfo.getSiborikomiId()) && C_YouhiKbn.YOU.eq(uiBean.getKinou().getKidouKengenHanteiYouhiKbn())) {

                List<AS_KinouModeSiborikomi> kinouModeSiborikomiList
                = manager.getKinouModeSiborikomi(uiBean.getKinou().getKinouId(), uiBean.getKinouMode().getKinouModeId());

                if (kinouModeSiborikomiList.size() > 0) {
                    throw new BizLogicException(MessageId.EAC0006, DDID_KENGENSETTEILIST_SIBORIKOMIID);
                }

            }
        }
    }

    private void setRoleList(AM_Role pRole, KengenSetteiListDataSourceBean pkengenSetteiListDSBean,
        List<KengenSetteiListDataSourceBean> pkengenUiBeanList){

        for (KengenSetteiListDataSourceBean dsBean : pkengenUiBeanList) {
            if (pRole.getRoleCd().equals(dsBean.getRoleCd()) && dsBean.getCommonCheckBox()) {
                pkengenSetteiListDSBean.setCommonCheckBox(true);
                pkengenSetteiListDSBean.setSiborikomiId(dsBean.getSiborikomiId());
                break;
            }
        }
    }
}
