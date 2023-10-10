package yuyu.app.base.system.kadoutimetouroku;

import static yuyu.app.base.system.kadoutimetouroku.GenKadouTimeTourokuConstants.*;
import static yuyu.app.base.system.kadoutimetouroku.KadouTimeTourokuConstants.*;
import static yuyu.common.base.kadoutime.KadouTimeConstants.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.base.kadoutime.DispKadouTime;
import yuyu.common.base.kadoutime.KadouTimeRelationCheck;
import yuyu.common.base.kadoutime.KadouTimes;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_EigyoubiKbn;
import yuyu.def.classification.C_KadouTimeSiteiKbn;
import yuyu.def.classification.C_KadouTimeYoubiKbn;
import yuyu.def.db.entity.AT_HolidayGroup;
import yuyu.def.db.entity.AT_KadouTime;
import yuyu.def.db.entity.AT_KadouTimeGroup;
import yuyu.def.enumeration.E_HenkanKbn;

import com.google.common.collect.Lists;

/**
 * 稼働時間登録 のビジネスロジックです。
 */
public class KadouTimeTourokuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KadouTimeTourokuUiBean uiBean;

    @Inject
    private BaseDomManager manager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private KadouTimeRelationCheck check;

    void init() {
        clear();

        getKadouTimeGroupList();

    }

    void clear() {
        uiBean.setKadouTimeGroup(new AT_KadouTimeGroup());
        uiBean.setKadouTime(new AT_KadouTime());
        uiBean.setHolidayGroup(new AT_HolidayGroup());
    }

    void getKadouTimeList() {

        KeyInfoDataSourceBean keyInfoDataSourceBean =
            uiBean.getKeyInfoDataSource().getSelectedBean();

        String kadouTimeGroupCd = keyInfoDataSourceBean.getKadouTimeGroupCd();

        AT_KadouTimeGroup aT_KadouTimeGroup = manager.getKadouTimeGroup(kadouTimeGroupCd);
        AT_HolidayGroup aT_HolidayGroup = aT_KadouTimeGroup.getHolidayGroup();

        List<EigyoubiKadouTimeInfoDataSourceBean> eigyoubiKadouTimeInfoList = Lists.newArrayList();

        for(C_KadouTimeYoubiKbn youbiKbn : YOUBIKBNS){
            eigyoubiKadouTimeInfoList.add(getEigyoubiKadouTimeList(aT_KadouTimeGroup, youbiKbn));
        }

        List<HiEigyoubiKadouTimeInfoDataSourceBean> hieigyoubiKadouTimeInfoList = Lists.newArrayList();

        for(C_KadouTimeYoubiKbn youbiKbn : YOUBIKBNS){
            hieigyoubiKadouTimeInfoList.add(getHiEigyoubiKadouTimeList(aT_KadouTimeGroup, youbiKbn));
        }

        uiBean.setHolidayGroup(aT_HolidayGroup);
        uiBean.setKadouTimeGroup(aT_KadouTimeGroup);
        uiBean.setEigyoubiKadouTimeInfo(eigyoubiKadouTimeInfoList);
        uiBean.setHiEigyoubiKadouTimeInfo(hieigyoubiKadouTimeInfoList);
        uiBean.getHolidayGroup().setHolidayGroupNm(aT_HolidayGroup.getHolidayGroupNm());
        uiBean.getKadouTimeGroup().setKadouTimeGroupCd(kadouTimeGroupCd);
        uiBean.getKadouTimeGroup().setKadouTimeGroupNm(keyInfoDataSourceBean.getKadouTimeGroupNm());
        uiBean.getKadouTimeGroup().setKadouTimeGroupDescription(keyInfoDataSourceBean.getKadouTimeGroupDescription());

    }

    void setupEigyoubiUiBean() {

        AT_KadouTimeGroup kadouTimeGroup = uiBean.getKadouTimeGroup();

        EigyoubiKadouTimeInfoDataSourceBean eigyoubiKadouTimeInfoDsBean =
            uiBean.getEigyoubiKadouTimeInfoDataSource().getSelectedBean();

        AT_KadouTime kadouTime = kadouTimeGroup.getKadouTime(eigyoubiKadouTimeInfoDsBean.getEigyouKadouTimeYoubiKbn(), C_EigyoubiKbn.EIGYOUBI);

        uiBean.getKadouTime().setEigyoubiKbn(C_EigyoubiKbn.EIGYOUBI);
        uiBean.getKadouTime().setKadouTimeYoubiKbn(kadouTime.getKadouTimeYoubiKbn());
        C_KadouTimeSiteiKbn kadouTimeSiteiKbn = eigyoubiKadouTimeInfoDsBean.getKadouTimeSiteiKbn();

        String hyoujunKadouTimeInfo;
        if (C_KadouTimeSiteiKbn.SITEI.eq(kadouTimeSiteiKbn)) {
            hyoujunKadouTimeInfo = uiBean.getEigyoubiKadouTimeInfoDataSource().getAllData().get(0).getEigyouKadouTime();
        } else {
            hyoujunKadouTimeInfo = kadouTimeSiteiKbn.getContent();

        }

        setupUiBean(eigyoubiKadouTimeInfoDsBean);
        uiBean.setHyoujunKadouTimeInfo(hyoujunKadouTimeInfo);
        uiBean.setKadouTimeGroup(kadouTimeGroup);

    }
    void setupHieigyoubiUiBean() {

        AT_KadouTimeGroup kadouTimeGroup = uiBean.getKadouTimeGroup();

        HiEigyoubiKadouTimeInfoDataSourceBean hieigyoubiKadouTimeInfoDsBean =
            uiBean.getHiEigyoubiKadouTimeInfoDataSource().getSelectedBean();

        AT_KadouTime kadouTime = kadouTimeGroup.getKadouTime(hieigyoubiKadouTimeInfoDsBean.getHiEigyouKadouTimeYoubiKbn(), C_EigyoubiKbn.HIEIGYOUBI);

        uiBean.getKadouTime().setEigyoubiKbn(C_EigyoubiKbn.HIEIGYOUBI);
        uiBean.getKadouTime().setKadouTimeYoubiKbn(kadouTime.getKadouTimeYoubiKbn());

        C_KadouTimeSiteiKbn kadouTimeSiteiKbn = hieigyoubiKadouTimeInfoDsBean.getKadouTimeSiteiKbn();

        String hyoujunKadouTimeInfo;
        if (C_KadouTimeSiteiKbn.SITEI.eq(kadouTimeSiteiKbn)) {
            hyoujunKadouTimeInfo = uiBean.getHiEigyoubiKadouTimeInfoDataSource().getAllData().get(0).getHiEigyouKadouTime();
        } else {
            hyoujunKadouTimeInfo = kadouTimeSiteiKbn.getContent();
        }

        setupUiBean(hieigyoubiKadouTimeInfoDsBean);
        uiBean.setHyoujunKadouTimeInfo(hyoujunKadouTimeInfo);
        uiBean.setKadouTimeGroup(kadouTimeGroup);

    }

    void relationChk() {
        KadouTimes times = new KadouTimes(uiBean);

        if (C_KadouTimeSiteiKbn.SITEI.eq(uiBean.getKadouTime().getKadouTimeSiteiKbn())) {
            check.init(times, FROM_ITEMS, TO_ITEMS);

            check.relationChk(new Item[]{ DDID_KADOUTIMEINFOINPUT_KADOUTIMESITEIKBN,
                DDID_KADOUTIMEINFOINPUT_KADOUTIMEFROM1,
                DDID_KADOUTIMEINFOINPUT_KADOUTIMETO1});

        } else {
            chkKadouTimeYoubiKbn();

            uiBean.setAllBlank();
        }

        messageManager.addMessageId(MessageId.QAC0009);

    }

    void setKadouTimeDisp(){
        DispKadouTime.convDispInputKadouTimes(uiBean.getKadouTime(), E_HenkanKbn.HYOUJI);
    }

    void resetKadouTimeNyuuryou(){
        DispKadouTime.convDispInputKadouTimes(uiBean.getKadouTime(), E_HenkanKbn.NYUURYOKU);
    }

    @Transactional
    void updKadouTime() {

        DispKadouTime.convDispInputKadouTimes(uiBean.getKadouTime(), E_HenkanKbn.NYUURYOKU);

        AT_KadouTimeGroup kadouTimeGroup = uiBean.getKadouTimeGroup();

        AT_KadouTime kadouTime = kadouTimeGroup.getKadouTime(uiBean.getKadouTime().getKadouTimeYoubiKbn(), uiBean.getKadouTime().getEigyoubiKbn());

        kadouTime.setKadouTimeSiteiKbn(uiBean.getKadouTime().getKadouTimeSiteiKbn());

        KadouTimes times = new KadouTimes(uiBean);

        times.setupEntity(kadouTime);

        manager.update(kadouTimeGroup);

        messageManager.addMessageId(MessageId.IAC0009);

    }

    void chkReferenceKadouTimeGroup(){

        if (!chkExistKadouTimeGroup(getKadouTimeGroupCd())) {
            throw new BizLogicException(MessageId.EAC0046, MessageUtil
                .getMessage(DDID_KEYINFO_KADOUTIMEGROUPCD.getErrorResourceKey()));
        }
    }

    private String getKadouTimeGroupCd() {
        if(uiBean.getKadouTimeGroup().getKadouTimeGroupCd() != null){
            return uiBean.getKadouTimeGroup().getKadouTimeGroupCd();
        }

        return uiBean.getKeyInfoDataSource().getSelectedBean().getKadouTimeGroupCd();
    }

    private boolean chkExistKadouTimeGroup(String pKadouTimeGroupCd) {

        AT_KadouTimeGroup kadouTimeGroup = manager.getKadouTimeGroup(pKadouTimeGroupCd);

        if (kadouTimeGroup == null) {
            return false;
        }
        return true;

    }

    private void getKadouTimeGroupList() {

        List<AT_KadouTimeGroup> kadouTimeGroupList = manager.getAllKadouTimeGroups();

        List<KeyInfoDataSourceBean> kadouTimeGroupInfoBeanList =
            BeanUtil.createList(KeyInfoDataSourceBean.class, kadouTimeGroupList);

        uiBean.setKeyInfo(kadouTimeGroupInfoBeanList);
    }

    private static EigyoubiKadouTimeInfoDataSourceBean getEigyoubiKadouTimeList(
        AT_KadouTimeGroup pAT_KadouTimeGroup,
        C_KadouTimeYoubiKbn pC_KadouTimeYoubiKbn) {

        AT_KadouTime aT_KadouTime = pAT_KadouTimeGroup.getKadouTime(pC_KadouTimeYoubiKbn, C_EigyoubiKbn.EIGYOUBI);

        String henkouEigyoubi = MessageUtil.getMessage(DDID_EIGYOUBIKADOUTIMEINFO_HENKOUEIGYOUBILINK.getErrorResourceKey());

        EigyoubiKadouTimeInfoDataSourceBean eigyoubiKadouTimeInfoDsBean = new EigyoubiKadouTimeInfoDataSourceBean();

        StringBuilder kadouTime = new StringBuilder("");

        setKadouTimeInfoDataSourceBean(eigyoubiKadouTimeInfoDsBean,aT_KadouTime,kadouTime);

        eigyoubiKadouTimeInfoDsBean.setHenkouEigyoubiLink(henkouEigyoubi);
        eigyoubiKadouTimeInfoDsBean.setEigyouKadouTimeYoubiKbn(pC_KadouTimeYoubiKbn);
        eigyoubiKadouTimeInfoDsBean.setEigyouKadouTime(kadouTime.toString());

        return eigyoubiKadouTimeInfoDsBean;
    }

    private static HiEigyoubiKadouTimeInfoDataSourceBean getHiEigyoubiKadouTimeList(
        AT_KadouTimeGroup pAT_KadouTimeGroup,
        C_KadouTimeYoubiKbn pC_KadouTimeYoubiKbn) {

        AT_KadouTime aT_KadouTime = pAT_KadouTimeGroup.getKadouTime(pC_KadouTimeYoubiKbn, C_EigyoubiKbn.HIEIGYOUBI);

        String henkouHieigyoubi = MessageUtil.getMessage(DDID_HIEIGYOUBIKADOUTIMEINFO_HENKOUHIEIGYOUBILINK.getErrorResourceKey());

        HiEigyoubiKadouTimeInfoDataSourceBean hiEigyoubiKadouTimeInfoDsBean = new HiEigyoubiKadouTimeInfoDataSourceBean();

        StringBuilder kadouTime = new StringBuilder("");

        setKadouTimeInfoDataSourceBean(hiEigyoubiKadouTimeInfoDsBean,aT_KadouTime,kadouTime);

        hiEigyoubiKadouTimeInfoDsBean.setHenkouHieigyoubiLink(henkouHieigyoubi);
        hiEigyoubiKadouTimeInfoDsBean.setHiEigyouKadouTimeYoubiKbn(pC_KadouTimeYoubiKbn);
        hiEigyoubiKadouTimeInfoDsBean.setHiEigyouKadouTime(kadouTime.toString());

        return hiEigyoubiKadouTimeInfoDsBean;

    }

    private static void setKadouTimeInfoDataSourceBean(KadouTimeInfoDataSourceBean pDs, AT_KadouTime pAtKadouTime,
        StringBuilder pKadouTime){

        if (C_KadouTimeSiteiKbn.SITEI.eq(pAtKadouTime.getKadouTimeSiteiKbn()) ) {
            pKadouTime.append(DispKadouTime.getDispKadouTimesFromTo(pAtKadouTime));
        }

        pDs.setKadouTimeSiteiKbn(pAtKadouTime.getKadouTimeSiteiKbn());

        for(int i=1; i<= MAX_KADOUTIME_COUNT; i++){
            pDs.setKadouTime(pAtKadouTime, i);
        }

    }


    private void setupUiBean(KadouTimeInfoDataSourceBean pDs){

        uiBean.getKadouTime().setKadouTimeSiteiKbn(pDs.getKadouTimeSiteiKbn());

        for(int i=1; i<=MAX_KADOUTIME_COUNT; i++){
            uiBean.setDsKadouTime(pDs, i);
        }
    }

    private void chkKadouTimeYoubiKbn() {

        if (C_KadouTimeYoubiKbn.HYOUJYUN.eq(uiBean.getKadouTime().getKadouTimeYoubiKbn()) &&
            C_KadouTimeSiteiKbn.HYOUJUN.eq(uiBean.getKadouTime().getKadouTimeSiteiKbn())) {

            throw new BizLogicException(MessageId.EAF0036, new Item[] {DDID_KADOUTIMEINFO_KADOUTIMEYOUBIKBN,DDID_KADOUTIMEINFOINPUT_KADOUTIMESITEIKBN},
                C_KadouTimeYoubiKbn.HYOUJYUN.getContent(),
                C_KadouTimeSiteiKbn.HYOUJUN.getContent());
        }
    }
}
