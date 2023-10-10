package yuyu.app.base.system.tokuteibikadoutimetouroku;

import static yuyu.app.base.system.tokuteibikadoutimetouroku.GenTokuteibiKadouTimeTourokuConstants.*;
import static yuyu.app.base.system.tokuteibikadoutimetouroku.TokuteibiKadouTimeTourokuConstants.*;
import static yuyu.common.base.kadoutime.KadouTimeConstants.*;
import static yuyu.def.enumeration.E_SyoriKbn.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.base.ConversationStatus;
import yuyu.common.base.UnknownForwardException;
import yuyu.common.base.collection.predicate.CheckedCommonCheckBoxPredicate;
import yuyu.common.base.kadoutime.DispKadouTime;
import yuyu.common.base.kadoutime.KadouTime;
import yuyu.common.base.kadoutime.KadouTimeRelationCheck;
import yuyu.common.base.kadoutime.KadouTimes;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_KadouTimeSiteiKbn;
import yuyu.def.db.entity.AT_KadouTimeGroup;
import yuyu.def.db.entity.AT_TokuteibiKadouTime;
import yuyu.def.enumeration.E_HenkanKbn;
import yuyu.def.enumeration.E_SyoriKbn;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * 特定日稼働時間登録 のビジネスロジックです。
 */
public class TokuteibiKadouTimeTourokuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private TokuteibiKadouTimeTourokuUiBean uiBean;

    @Inject
    private BaseDomManager manager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private ConversationStatus status;

    @Inject
    private KadouTimeRelationCheck check;

    void init() {
        clear();

        setUiBean();
    }

    void clear() {
        uiBean.getTokuteibiKadouTime().setKadouTimeSiteiYmd(null);

        for (KadouTimeGroupListDataSourceBean dsBean : uiBean.getKadouTimeGroupListDataSource().getAllData()) {
            dsBean.setCommonCheckBox(false);
        }
    }

    void setupUiBean() {

        uiBean.setKadouTimeGroupListBak(uiBean.getKadouTimeGroupListDataSource().getAllData());

        chkKadouYmd();

        if (NEW.equals(status.getSyoriKbn())) {
            chkKadouTimeGroupSentaku();
        }

        setKadouTimeGroupInfo();
        setTokuteibiKadouTimeGroupInfo();

        if (DELETE.equals(status.getSyoriKbn())) {
            DispKadouTime.convDispInputKadouTimes(uiBean.getKadouTime(),E_HenkanKbn.HYOUJI);
            messageManager.addMessageId(MessageId.QAC0010);
        }
    }

    void relationChk() {

        KadouTimes times = new KadouTimes(uiBean);

        if (C_KadouTimeSiteiKbn.SITEI.eq(uiBean.getTokuteibiKadouTime().getKadouTimeSiteiKbn())) {

            check.init(times, FROM_ITEMS, TO_ITEMS);

            check.relationChk(new Item[] {
                DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN,
                DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMEFROM1,
                DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMETO1 });

        }
        else {
            setAllKadouTimeBlank();
        }

        switch (status.getSyoriKbn()) {
            case NEW :messageManager.addMessageId(MessageId.QAC0008); break;
            case EDIT:messageManager.addMessageId(MessageId.QAC0009); break;
            default  :throw new UnknownForwardException();
        }

    }

    void setKadouTimeMoji() {
        DispKadouTime.convDispInputKadouTimes(uiBean.getTokuteibiKadouTime(),E_HenkanKbn.HYOUJI);
    }

    void resetKadouTime() {
        DispKadouTime.convDispInputKadouTimes(uiBean.getKadouTime(),E_HenkanKbn.NYUURYOKU);
    }

    void dataKousin() {

        DispKadouTime.convDispInputKadouTimes(uiBean.getTokuteibiKadouTime(),E_HenkanKbn.NYUURYOKU);

        switch (status.getSyoriKbn()) {
            case NEW    : doInsert(); break;
            case EDIT   : doUpdate(); break;
            case DELETE : doDelete(); break;
            default     : throw new UnknownForwardException();
        }

        messageManager.addMessageId(MessageId.IAC0009);

    }

    void resetInitUiBean() {

        clear();

        uiBean.setKadouTimeGroupList(uiBean.getKadouTimeGroupListBak());

    }

    @Transactional
    void doInsert() {

        List<AT_KadouTimeGroup> kadouTimeGroupList = uiBean.getKadouTimeGroups();

        for (AT_KadouTimeGroup kadouTimeGroup : kadouTimeGroupList) {

            KadouTimes times = new KadouTimes(uiBean);

            AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();

            tokuteibiKadouTime.setKadouTimeGroupCd(kadouTimeGroup.getKadouTimeGroupCd());
            tokuteibiKadouTime.setKadouTimeSiteiYmd(uiBean.getTokuteibiKadouTime().getKadouTimeSiteiYmd());
            tokuteibiKadouTime.setKadouTimeSiteiKbn(uiBean.getTokuteibiKadouTime().getKadouTimeSiteiKbn());

            times.setupEntity(tokuteibiKadouTime);

        }
        manager.insert(kadouTimeGroupList);
    }

    @Transactional
    void doUpdate() {

        AT_KadouTimeGroup kadouTimeGroup = uiBean.getTokuteibiKadouTime().getKadouTimeGroup();

        manager.update(kadouTimeGroup);

    }

    @Transactional
    void doDelete() {
        AT_TokuteibiKadouTime tokuteibiKadouTime = uiBean.getTokuteibiKadouTime();

        AT_KadouTimeGroup parerntKadouTimeGroup = tokuteibiKadouTime.getKadouTimeGroup();

        parerntKadouTimeGroup.getTokuteibiKadouTimes().remove(tokuteibiKadouTime);

        manager.update(parerntKadouTimeGroup);

    }

    void chkReferenceKadouTimeGroup() {
        if (!chkExistKadouTimeGroup()) {
            throw new BizLogicException(MessageId.EAC0046, MessageUtil
                .getMessage(DDID_KADOUTIMEGROUPLIST_KADOUTIMEGROUPCD.getErrorResourceKey()));
        }
    }

    void setUiBean() {
        getKadouTimeGroupList();
        getTokuteibiKadouTimeGroupList();
    }

    void clearInputData(){
        uiBean.getTokuteibiKadouTime().setKadouTimeSiteiKbn(null);
        setAllKadouTimeBlank();

    }
    void chkTokuteibiKadouTimeExistence() {
        TokuteibiKadouTimeSelectListDataSourceBean dsBean = uiBean.getTokuteibiKadouTimeSelectListDataSource().getSelectedBean();

        String kadouTimeGroupCd = dsBean.getKadouTimeGroupCd();
        BizDate kadouTimeSiteiYmd = dsBean.getKadouTimeSiteiYmd();

        if (manager.getTokuteibiKadouTime(kadouTimeGroupCd, kadouTimeSiteiYmd) == null) {
            throw new BizLogicException(MessageId.EAC0046, MessageUtil.getMessage(MessageId.IAW0038));
        }

    }
    private boolean chkExistKadouTimeGroup() {

        if( E_SyoriKbn.NEW.equals(status.getSyoriKbn()) ){
            List<KadouTimeGroupListDataSourceBean> filteredList = ImmutableList.copyOf(
                Iterables.filter(uiBean.getKadouTimeGroupListDataSource().getAllData(),
                    new CheckedCommonCheckBoxPredicate()));

            for (KadouTimeGroupListDataSourceBean ds : filteredList) {
                AT_KadouTimeGroup kadouTimeGroup = manager.getKadouTimeGroup(ds.getKadouTimeGroupCd());
                if (kadouTimeGroup == null) {
                    return false;
                }
            }
        } else {
            TokuteibiKadouTimeSelectListDataSourceBean dsBean = uiBean.getTokuteibiKadouTimeSelectListDataSource().getSelectedBean();
            String kadouTimeGroupCd = dsBean.getKadouTimeGroupCd();

            AT_KadouTimeGroup kadouTimeGroup = manager.getKadouTimeGroup(kadouTimeGroupCd);
            if (kadouTimeGroup == null) {
                return false;
            }
        }
        return true;
    }

    private void getKadouTimeGroupList() {

        List<AT_KadouTimeGroup> kadouTimeGroupInfoList = manager.getAllKadouTimeGroups();

        if (kadouTimeGroupInfoList.size() == 0) {
            throw new BizAppException(MessageId.EAF0027,
                MessageUtil.getMessage(MessageId.IAW0038,
                    MessageUtil.getMessage(MessageId.IAW0041)));
        }

        List<KadouTimeGroupListDataSourceBean> dsBeanList =
            BeanUtil.createList(KadouTimeGroupListDataSourceBean.class,kadouTimeGroupInfoList);

        if (uiBean.getKadouTimeGroupListBak() != null) {
            resetChkBox(dsBeanList);
        }

        uiBean.setKadouTimeGroupList(dsBeanList);

    }

    private void resetChkBox(List<KadouTimeGroupListDataSourceBean> pDsBeanList) {
        for (KadouTimeGroupListDataSourceBean ds : pDsBeanList) {
            for (KadouTimeGroupListDataSourceBean bk : uiBean.getKadouTimeGroupListBak()) {
                if (ds.getKadouTimeGroupCd().equals(bk.getKadouTimeGroupCd())) {
                    ds.setCommonCheckBox(bk.getCommonCheckBox());
                }
            }
        }

    }

    private void getTokuteibiKadouTimeGroupList() {

        List<AT_TokuteibiKadouTime> tokuteibiKadouTimeList = manager.getAllTokuteibiKadouTime();

        if (tokuteibiKadouTimeList.size() == 0) {
            messageManager.addMessageId(MessageId.WAF0003);
            uiBean.setTokuteibiKadouTimeDataumuFlg(false);
        } else {
            uiBean.setTokuteibiKadouTimeDataumuFlg(true);
        }

        String henkou = MessageUtil.getMessage(DDID_TOKUTEIBIKADOUTIMESELECTLIST_HENKOULINK.getErrorResourceKey());
        String sakujyo = MessageUtil.getMessage(DDID_TOKUTEIBIKADOUTIMESELECTLIST_SAKUJYOLINK.getErrorResourceKey());

        List<TokuteibiKadouTimeSelectListDataSourceBean> tokuteibiKadouTimeSelectList = Lists.newArrayList();

        String kadouTime = null;

        for (AT_TokuteibiKadouTime bean : tokuteibiKadouTimeList) {
            TokuteibiKadouTimeSelectListDataSourceBean tokuteibiKadouTimeSelectListDsBean = new TokuteibiKadouTimeSelectListDataSourceBean();

            if (C_KadouTimeSiteiKbn.SITEI.eq(bean.getKadouTimeSiteiKbn())) {
                kadouTime = DispKadouTime.getDispKadouTimesFromTo(bean);
            }
            else {
                kadouTime = bean.getKadouTimeSiteiKbn().getContent();
            }

            tokuteibiKadouTimeSelectListDsBean.setKadouTimeGroupNm(bean.getKadouTimeGroup().getKadouTimeGroupNm());
            tokuteibiKadouTimeSelectListDsBean.setKadouTimeSiteiYmd(bean.getKadouTimeSiteiYmd());
            tokuteibiKadouTimeSelectListDsBean.setKadouTimeDisp(kadouTime);
            tokuteibiKadouTimeSelectListDsBean.setHenkouLink(henkou);
            tokuteibiKadouTimeSelectListDsBean.setSakujyoLink(sakujyo);
            tokuteibiKadouTimeSelectListDsBean.setKadouTimeGroupCd(bean.getKadouTimeGroupCd());
            tokuteibiKadouTimeSelectListDsBean.setKadouTimeSiteiKbn(bean.getKadouTimeSiteiKbn());

            for (int i = 1; i <= MAX_KADOUTIME_COUNT; i++) {
                tokuteibiKadouTimeSelectListDsBean.setKadouTime(bean, i);
            }

            tokuteibiKadouTimeSelectList.add(tokuteibiKadouTimeSelectListDsBean);

        }

        uiBean.setTokuteibiKadouTimeSelectList(tokuteibiKadouTimeSelectList);
    }

    private void chkKadouYmd() {

        switch (status.getSyoriKbn()) {

            case NEW:
                BizDate kadouTimeSiteiYmd = uiBean.getTokuteibiKadouTime().getKadouTimeSiteiYmd();

                if (kadouTimeSiteiYmd == null) {
                    throw new BizLogicException(MessageId.EAC0006,DDID_KEYINFO_KADOUTIMESITEIYMD);
                }

                chkKadouYmdSysDate(kadouTimeSiteiYmd, MessageId.EAC0047);

                List<KadouTimeGroupListDataSourceBean> filteredList = ImmutableList
                    .copyOf(Iterables.filter(uiBean.getKadouTimeGroupListDataSource().getAllData(),
                        new CheckedCommonCheckBoxPredicate()));

                for (KadouTimeGroupListDataSourceBean dsBean : filteredList) {

                    AT_TokuteibiKadouTime tokuteibiKadouTime = manager.getTokuteibiKadouTime(
                        dsBean.getKadouTimeGroupCd(),
                        uiBean.getTokuteibiKadouTime().getKadouTimeSiteiYmd());

                    if (tokuteibiKadouTime != null) {
                        throw new BizLogicException(MessageId.EAC0002,DDID_KEYINFO_KADOUTIMESITEIYMD);
                    }
                }

                break;

            case EDIT:
            case DELETE:
                chkKadouYmdSysDate(uiBean.getTokuteibiKadouTimeSelectListDataSource()
                    .getSelectedBean().getKadouTimeSiteiYmd(), MessageId.EAC0048);
                break;
            default:
                throw new UnknownForwardException();
        }
    }

    private void chkKadouYmdSysDate(BizDate pKadouYmd, String pMessageId) {

        if (pKadouYmd.compareTo(BizDate.getSysDate()) < 0) {
            throw new BizLogicException(pMessageId,
                MessageUtil.getMessage(DDID_TOKUTEIBIKADOUTIMESELECTLIST_KADOUTIMESITEIYMD.getErrorResourceKey()));

        }
    }

    private void chkKadouTimeGroupSentaku() {

        List<KadouTimeGroupListDataSourceBean> filteredList = ImmutableList.copyOf(
            Iterables.filter(uiBean.getKadouTimeGroupListDataSource().getAllData(),
                new CheckedCommonCheckBoxPredicate()));

        if (filteredList.size() == 0) {
            throw new BizLogicException(MessageId.EAC0010, DDID_KADOUTIMEGROUPLIST_KADOUTIMEGROUPNM);
        }

        List<AT_KadouTimeGroup> kadoutimeGroupList = Lists.newArrayList();
        for (KadouTimeGroupListDataSourceBean dsBean : filteredList) {

            AT_KadouTimeGroup kadoutime = manager.getKadouTimeGroup(dsBean.getKadouTimeGroupCd());
            kadoutimeGroupList.add(kadoutime);

        }
        uiBean.setKadouTimeGroups(kadoutimeGroupList);
    }

    private void setKadouTimeGroupInfo() {

        if (NEW.equals(status.getSyoriKbn())) {

            List<KadouTimeGroupListDataSourceBean> filteredList = ImmutableList.copyOf(
                Iterables.filter(uiBean.getKadouTimeGroupListDataSource().getAllData(),
                    new CheckedCommonCheckBoxPredicate()));
            uiBean.setKadouTimeGroupList(filteredList);

        }
        else {
            String kadouTimeGroupCd = uiBean.getTokuteibiKadouTimeSelectListDataSource().getSelectedBean().getKadouTimeGroupCd();
            AT_KadouTimeGroup kadouTimeGroup = manager.getKadouTimeGroup(kadouTimeGroupCd);
            AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(uiBean.getTokuteibiKadouTimeSelectListDataSource().getSelectedBean().getKadouTimeSiteiYmd());

            uiBean.setTokuteibiKadouTime(tokuteibiKadouTime);

            List<KadouTimeGroupListDataSourceBean> kadouTimeGroupDsBeanList = Lists.newArrayList();

            for (KadouTimeGroupListDataSourceBean dsBean : uiBean.getKadouTimeGroupListDataSource().getAllData()) {

                if (dsBean.getKadouTimeGroupCd().equals(kadouTimeGroupCd)) {
                    dsBean.setCommonCheckBox(true);
                    kadouTimeGroupDsBeanList.add(dsBean);
                    break;
                }
            }

            uiBean.setKadouTimeGroupList(kadouTimeGroupDsBeanList);
        }
    }

    private void setTokuteibiKadouTimeGroupInfo() {

        if (!NEW.equals(status.getSyoriKbn())) {
            deploySelectedDataSource();
        }
    }

    private void setAllKadouTimeBlank() {

        for (int i = 1; i <= MAX_KADOUTIME_COUNT; i++) {
            uiBean.setKadouTime(new KadouTime(null, null), i);
        }
    }

    private void deploySelectedDataSource() {

        TokuteibiKadouTimeSelectListDataSourceBean tokuteibiKadouTimeSelectListDsBean = new TokuteibiKadouTimeSelectListDataSourceBean();

        AT_TokuteibiKadouTime tokuteibiKadouTime = uiBean.getTokuteibiKadouTime();

        for (int i = 1; i <= MAX_KADOUTIME_COUNT; i++) {
            tokuteibiKadouTimeSelectListDsBean.setKadouTime(tokuteibiKadouTime, i);
        }
    }
}
