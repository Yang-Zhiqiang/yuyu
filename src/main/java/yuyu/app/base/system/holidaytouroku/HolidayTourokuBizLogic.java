package yuyu.app.base.system.holidaytouroku;

import static yuyu.app.base.system.holidaytouroku.GenHolidayTourokuConstants.*;
import static yuyu.app.base.system.holidaytouroku.HolidayTourokuConstants.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateMD;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;

import org.slf4j.Logger;

import yuyu.common.base.ConversationStatus;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_HolidayPtn;
import yuyu.def.classification.C_LegalHolidayKbn;
import yuyu.def.classification.C_YoubiKbn;
import yuyu.def.classification.C_YoyakuKbn;
import yuyu.def.db.entity.AT_Holiday;
import yuyu.def.db.entity.AT_HolidayGroup;
import yuyu.def.db.entity.AT_HolidayYoyaku;
import yuyu.def.enumeration.E_HenkanKbn;
import yuyu.def.enumeration.E_SyoriKbn;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * 休日登録 のビジネスロジックです。
 */
public class HolidayTourokuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private UniqueKeyGenerator unique;

    @Inject
    private HolidayTourokuUiBean uiBean;

    @Inject
    private BaseDomManager manager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private ConversationStatus status;

    void init() {

        clear();
        getHolidayGroupInfo();
    }

    void clear() {

        if ( !E_SyoriKbn.NEW.equals(status.getSyoriKbn()) ){
            uiBean.setHolidayGroup(new AT_HolidayGroup());
        }
        uiBean.getHolidayYoyaku().setTekiyouYmdFrom(null);
        uiBean.getHolidayYoyaku().setTekiyouYmdTo(null);
        uiBean.getHolidayYoyaku().setHolidayPatternDescription(null);
        uiBean.setHolidayGroupCd(null);
        uiBean.setHolidayYmd(null);
        uiBean.setHolidayMd(null);
        uiBean.setHolidayM(null);
        uiBean.setHolidayNth(null);
        uiBean.setHolidayYoubi(C_YoubiKbn.SUNDAY);
        uiBean.setHolidaySiteiYoubi(C_YoubiKbn.SUNDAY);
        uiBean.getHolidayYoyaku().setLegalHolidayKbn(C_LegalHolidayKbn.NONE);

        uiBean.clearHolidayGroupCdOptionBeanList();
    }

    void getHolidayInfo() {

        KeyInfoDataSourceBean keyInfoDataSourceBean = uiBean.getKeyInfoDataSource().getSelectedBean();
        String holidayGroupCd = keyInfoDataSourceBean.getHolidayGroupCd();
        String holidayGroupNm = keyInfoDataSourceBean.getHolidayGroupNm();
        String holidayGroupDescription = keyInfoDataSourceBean.getHolidayGroupDescription();

        setHolidayInfo(holidayGroupCd);

        uiBean.getHolidayGroup().setHolidayGroupCd(holidayGroupCd);
        uiBean.getHolidayGroup().setHolidayGroupNm(holidayGroupNm);
        uiBean.getHolidayGroup().setHolidayGroupDescription(holidayGroupDescription);
        uiBean.getHolidayYoyaku().setHolidayPatternParam(C_HolidayPtn.EVERY_WEEK.getValue());

        setHolidayGroupList();

        uiBean.setHolidayGroup(manager.getHolidayGroup(uiBean.getHolidayGroup().getHolidayGroupCd()));
    }

    void chkHolidayPatternNm() {

        clear();

        setHolidayPatternInfo();

        if (Strings.isNullOrEmpty(uiBean.getHolidayYoyaku().getHolidayPatternNm())) {

            throw new BizLogicException(MessageId.EAC0006, DDID_HOLIDAYPATTERN_HOLIDAYPATTERNNM);
        }

        getHolidayGroupInfo();
        setHolidayGroupList();

        if (uiBean.getKeyInfoDataSource().getAllData().size() == 1 && C_HolidayPtn.OTHER_HOLIDAYGROUP.eq(uiBean.getHolidayYoyaku().getHolidayPattern())) {

            throw new BizLogicException(MessageId.EAF0062, MessageUtil.getMessage(MessageId.IAW0036));
        }

        uiBean.setHolidayPattern(uiBean.getHolidayYoyaku().getHolidayPattern());
        uiBean.setHolidayCd(unique.generateUniqueKey());

    }

    void getEditInfo() {

        setHolidayPatternInfo();

        getHolidayGroupInfo();
        setHolidayGroupList();

        HolidayPatternInfoDataSourceBean holidayPatternInfoDataSourceBean
        = uiBean.getHolidayPatternInfoDataSource().getSelectedBean();
        String holidayGroupCd = uiBean.getHolidayGroup().getHolidayGroupCd();
        C_HolidayPtn holidayPtn = holidayPatternInfoDataSourceBean.getHolidayPattern();
        String holidayCd = holidayPatternInfoDataSourceBean.getHolidayCd();
        C_YoyakuKbn yoyakuKbn = holidayPatternInfoDataSourceBean.getYoyakuKbn();

        uiBean.getHolidayYoyaku().setHolidayPattern(holidayPtn);
        uiBean.getHolidayYoyaku().setHolidayPatternNm(holidayPatternInfoDataSourceBean.getHolidayPatternNm());

        AT_HolidayGroup holidayGroup = manager.getHolidayGroup(holidayGroupCd);

        if (C_YoyakuKbn.BLNK.eq(yoyakuKbn)) {

            AT_Holiday holiday = holidayGroup.getHoliday(holidayCd);

            BizDate tekiyouYmdFrom;
            BizDate TekiyouYmdTo;

            if (C_HolidayPtn.SPECIFIC_DAY.eq(holidayPtn)) {

                tekiyouYmdFrom = null;
                TekiyouYmdTo = null;
            } else {

                tekiyouYmdFrom = holiday.getTekiyouYmdFrom();
                TekiyouYmdTo = holiday.getTekiyouYmdTo();
            }

            uiBean.getHolidayYoyaku().setTekiyouYmdFrom(tekiyouYmdFrom);
            uiBean.getHolidayYoyaku().setTekiyouYmdTo(TekiyouYmdTo);
            uiBean.getHolidayYoyaku().setLegalHolidayKbn(holiday.getLegalHolidayKbn());
            uiBean.getHolidayYoyaku().setHolidayPatternDescription(holiday.getHolidayPatternDescription());
            uiBean.getHolidayYoyaku().setYoyakuKbn(yoyakuKbn);
            uiBean.setHolidayCd(holiday.getHolidayCd());

            setInputContantsUiBean(holidayPtn, holiday.getHolidayPatternParam());
        }
        else {
            AT_HolidayYoyaku holidayYoyaku = holidayGroup.getHolidayYoyaku(holidayCd);
            uiBean.setHolidayYoyaku(holidayYoyaku);
            setInputContantsUiBean(holidayPtn, holidayYoyaku.getHolidayPatternParam());
        }

        uiBean.setHolidayPattern(uiBean.getHolidayYoyaku().getHolidayPattern());
        if (E_SyoriKbn.DELETE.equals(status.getSyoriKbn())) {
            convertHolidayGroupInfo(E_HenkanKbn.HYOUJI);
            messageManager.addMessageId(MessageId.QAC0010);
        }
    }

    void chkHolidayInfo() {

        C_HolidayPtn holidayPattern = uiBean.getHolidayYoyaku().getHolidayPattern();
        BizDate tekiyouYmdFrom = uiBean.getHolidayYoyaku().getTekiyouYmdFrom();
        BizDate tekiyouYmdTo = uiBean.getHolidayYoyaku().getTekiyouYmdTo();

        if (!C_HolidayPtn.SPECIFIC_DAY.eq(holidayPattern)) {

            if (tekiyouYmdFrom == null && tekiyouYmdTo == null) {
                throw new BizLogicException(MessageId.EAF0063, DDID_HOLIDAYPATTERNINFOINPUT_TEKIYOUYMDFROM, DDID_HOLIDAYPATTERNINFOINPUT_TEKIYOUYMDTO);
            }

            if (tekiyouYmdFrom == null) {
                throw new BizLogicException(MessageId.EAC0006, DDID_HOLIDAYPATTERNINFOINPUT_TEKIYOUYMDFROM);
            }
            if (tekiyouYmdTo == null) {
                throw new BizLogicException(MessageId.EAC0006, DDID_HOLIDAYPATTERNINFOINPUT_TEKIYOUYMDTO);
            }
            if (tekiyouYmdFrom.compareTo(tekiyouYmdTo) > 0) {

                throw new BizLogicException(MessageId.EAC0005,
                    DDID_HOLIDAYPATTERNINFOINPUT_TEKIYOUYMDFROM, DDID_HOLIDAYPATTERNINFOINPUT_TEKIYOUYMDTO);
            }
        }

        if (C_HolidayPtn.OTHER_HOLIDAYGROUP.eq(holidayPattern)) {

            if (Strings.isNullOrEmpty(uiBean.getHolidayGroupCd())) {

                throw new BizLogicException(MessageId.EAC0006, DDID_HOLIDAYPATTERNINFOINPUT_HOLIDAYGROUPCD);
            }
        }
        else if (C_HolidayPtn.SPECIFIC_DAY.eq(holidayPattern)) {

            if (uiBean.getHolidayYmd() == null) {

                throw new BizLogicException(MessageId.EAC0006, DDID_HOLIDAYPATTERNINFOINPUT_HOLIDAYYMD);
            }
        }
        else if (C_HolidayPtn.SPECIFIC_DAYEVERYYEAR.eq(holidayPattern)) {

            if (uiBean.getHolidayMd() == null) {

                throw new BizLogicException(MessageId.EAC0006, DDID_HOLIDAYPATTERNINFOINPUT_HOLIDAYMD);
            }
        }
        else if (C_HolidayPtn.SPECIFIC_DAYOFWEEK.eq(holidayPattern)) {

            if (uiBean.getHolidayM() == null) {

                throw new BizLogicException(MessageId.EAC0006, DDID_HOLIDAYPATTERNINFOINPUT_HOLIDAYM);
            }
            if (uiBean.getHolidayNth() == null) {

                throw new BizLogicException(MessageId.EAC0006, DDID_HOLIDAYPATTERNINFOINPUT_HOLIDAYNTH);
            }
        }

        if (E_SyoriKbn.NEW.equals(status.getSyoriKbn())) {

            messageManager.addMessageId(MessageId.QAC0008);
        }
        else {

            messageManager.addMessageId(MessageId.QAC0009);
        }

        convertHolidayGroupInfo(E_HenkanKbn.HYOUJI);
    }

    @Transactional
    void updHolidayInfoYoyaku() {

        E_SyoriKbn syoriKbn = status.getSyoriKbn();

        if (E_SyoriKbn.NEW.equals(syoriKbn)) {

            insHolidayYoyaku();
        }
        else {

            C_YoyakuKbn yoyakuKbn = uiBean.getHolidayYoyaku().getYoyakuKbn();

            if (E_SyoriKbn.EDIT.equals(syoriKbn)) {

                if (C_YoyakuKbn.BLNK.eq(yoyakuKbn)) {

                    insHolidayYoyaku();
                }
                else {

                    updHolidayYoyaku(yoyakuKbn);
                }
            }
            else if (E_SyoriKbn.DELETE.equals(syoriKbn)) {

                if (C_YoyakuKbn.BLNK.eq(yoyakuKbn)) {

                    insHolidayYoyaku();
                }
                else {

                    AT_HolidayYoyaku holidayYoyaku = uiBean.getHolidayYoyaku();

                    AT_HolidayGroup parentHolidayGroup = holidayYoyaku.getHolidayGroup();

                    parentHolidayGroup.getHolidayYoyakus().remove(holidayYoyaku);

                    manager.update(parentHolidayGroup);

                }
            }
        }

        messageManager.addMessageId(MessageId.IAC0009);
    }

    void backFromSelectData() {

        uiBean.setHolidayYoyaku(new AT_HolidayYoyaku());
        uiBean.getHolidayYoyaku().setHolidayPattern(uiBean.getBackHolidayPattern());
        uiBean.getHolidayYoyaku().setHolidayPatternNm(uiBean.getBackHolidayPatternNm());

    }

    void backFromConfirm() {

        if (E_SyoriKbn.DELETE.equals(status.getSyoriKbn())) {
            uiBean.setHolidayYoyaku(new AT_HolidayYoyaku());
            uiBean.getHolidayYoyaku().setHolidayPattern(uiBean.getBackHolidayPattern());
            uiBean.getHolidayYoyaku().setHolidayPatternNm(uiBean.getBackHolidayPatternNm());
        }
        convertHolidayGroupInfo(E_HenkanKbn.NYUURYOKU);
    }

    void chkReferenceMaster() {
        chkExistHolidayGroupCd();
    }

    void chkExistHolidayGroupInfo() {

        if(uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM){

            C_HolidayPtn holidayPtn = uiBean.getHolidayYoyaku().getHolidayPattern();

            if (C_HolidayPtn.OTHER_HOLIDAYGROUP.eq(holidayPtn)) {
                String holidayGroupCd = uiBean.getHolidayGroupCd();

                if(!Strings.isNullOrEmpty(holidayGroupCd)){
                    AT_HolidayGroup holidayGroup = manager.getHolidayGroup(holidayGroupCd);

                    if (holidayGroup == null) {

                        holidayGroupCd = uiBean.getHolidayGroup().getHolidayGroupCd();
                        setHolidayInfo(holidayGroupCd);
                        throw new BizLogicException(MessageId.EAC0046, HOLIDAYGROUP);

                    }
                }
            }
        }
    }

    private void setHolidayGroupList() {

        List<KeyInfoDataSourceBean> keyInfoDataSourceList = uiBean.getKeyInfoDataSource().getAllData();
        UserDefsList holidayGroupInfoSelectList = new UserDefsList();
        LabelValuePair usBean = new LabelValuePair();
        usBean.setLabel(null);
        usBean.setValue(null);
        holidayGroupInfoSelectList.add(usBean);

        for (KeyInfoDataSourceBean keyInfoDataSourceBean : keyInfoDataSourceList) {

            if (!uiBean.getHolidayGroup().getHolidayGroupCd().equals(keyInfoDataSourceBean.getHolidayGroupCd())) {
                usBean = new LabelValuePair();
                usBean.setLabel(keyInfoDataSourceBean.getHolidayGroupCd()
                    + CONSTANTS_COLON
                    + keyInfoDataSourceBean.getHolidayGroupNm());
                usBean.setValue(keyInfoDataSourceBean.getHolidayGroupCd());
                holidayGroupInfoSelectList.add(usBean);
            }
        }
        uiBean.setHolidayGroupCdOptionBeanList(holidayGroupInfoSelectList);
    }

    private void getHolidayGroupInfo() {

        List<AT_HolidayGroup> holidayGroupList = manager.getHolidayGroup4Gyoumu();

        List<KeyInfoDataSourceBean> keyInfoDataSourceList = Lists.newArrayList();

        for (AT_HolidayGroup holidayGroupBean : holidayGroupList) {

            KeyInfoDataSourceBean keyInfoDataSourceBean = new KeyInfoDataSourceBean();
            keyInfoDataSourceBean.setHolidayGroupCd(holidayGroupBean.getHolidayGroupCd());
            keyInfoDataSourceBean.setHolidayGroupNm(holidayGroupBean.getHolidayGroupNm());
            keyInfoDataSourceBean.setHolidayGroupDescription(holidayGroupBean.getHolidayGroupDescription());
            keyInfoDataSourceList.add(keyInfoDataSourceBean);
        }

        uiBean.setKeyInfo(keyInfoDataSourceList);
    }

    private void setInputContantsUiBean(C_HolidayPtn pHolidayPattern,
        String pHolidayPatternParam) {

        uiBean.setHolidayGroupCd(null);
        uiBean.setHolidayYmd(null);
        uiBean.setHolidayMd(null);
        uiBean.setHolidayM(null);
        uiBean.setHolidayNth(null);
        uiBean.setHolidaySiteiYoubi(C_YoubiKbn.SUNDAY);
        uiBean.setHolidayYoubi(C_YoubiKbn.SUNDAY);

        if (C_HolidayPtn.OTHER_HOLIDAYGROUP.eq(pHolidayPattern)) {

            uiBean.setHolidayGroupCd(pHolidayPatternParam);
        }
        else if (C_HolidayPtn.SPECIFIC_DAY.eq(pHolidayPattern)) {

            String[] paramInfo = pHolidayPatternParam.split(CONSTANTS_SLASH);
            uiBean.setHolidayYmd(BizDate.valueOf(paramInfo[0] + paramInfo[1]
                + paramInfo[2]));
        }
        else if (C_HolidayPtn.SPECIFIC_DAYEVERYYEAR.eq(pHolidayPattern)) {

            String[] paramInfo = pHolidayPatternParam.split(CONSTANTS_SEMICOLON);
            String month = Strings.padStart(paramInfo[0], 2, '0');
            String day = Strings.padStart(paramInfo[1], 2, '0');
            uiBean.setHolidayMd(BizDateMD.valueOf(month + day));
        }
        else if (C_HolidayPtn.SPECIFIC_DAYOFWEEK.eq(pHolidayPattern)) {

            String[] paramInfo = pHolidayPatternParam.split(CONSTANTS_SEMICOLON);
            uiBean.setHolidayM(Integer.parseInt(paramInfo[0]));
            uiBean.setHolidayNth(Integer.parseInt(paramInfo[1]));
            uiBean.setHolidaySiteiYoubi(C_YoubiKbn.valueOf(paramInfo[2]));
        }
        else if (C_HolidayPtn.EVERY_WEEK.eq(pHolidayPattern)) {

            uiBean.setHolidayYoubi(C_YoubiKbn.valueOf(pHolidayPatternParam));
        }
    }

    private void insHolidayYoyaku() {

        C_YoyakuKbn yoyakuKbn = null;
        C_HolidayPtn holidayPtn = uiBean.getHolidayYoyaku().getHolidayPattern();

        if (E_SyoriKbn.NEW.equals(status.getSyoriKbn())) {

            yoyakuKbn = C_YoyakuKbn.TOUROKU_YOYAKU;
        }
        else if (E_SyoriKbn.EDIT.equals(status.getSyoriKbn())) {

            yoyakuKbn = C_YoyakuKbn.HENKOU_YOYAKU;
        }
        else if (E_SyoriKbn.DELETE.equals(status.getSyoriKbn())) {

            yoyakuKbn = C_YoyakuKbn.SAKUJYO_YOYAKU;
        }

        if (C_HolidayPtn.SPECIFIC_DAY.eq(holidayPtn)) {
            uiBean.getHolidayYoyaku().setTekiyouYmdFrom(null);
            uiBean.getHolidayYoyaku().setTekiyouYmdTo(null);
        }

        AT_HolidayGroup holidayGroup = uiBean.getHolidayGroup();

        AT_HolidayYoyaku holidayYoyaku = holidayGroup.createHolidayYoyaku();

        holidayYoyaku.setHolidayGroupCd(uiBean.getHolidayGroup().getHolidayGroupCd());
        holidayYoyaku.setHolidayCd(uiBean.getHolidayCd());
        holidayYoyaku.setLegalHolidayKbn(uiBean.getHolidayYoyaku().getLegalHolidayKbn());
        holidayYoyaku.setTekiyouYmdFrom(uiBean.getHolidayYoyaku().getTekiyouYmdFrom());
        holidayYoyaku.setTekiyouYmdTo(uiBean.getHolidayYoyaku().getTekiyouYmdTo());
        holidayYoyaku.setHolidayPattern(holidayPtn);
        holidayYoyaku.setHolidayPatternParam(getHolidayPram(holidayPtn));
        holidayYoyaku.setHolidayPatternNm(uiBean.getHolidayYoyaku().getHolidayPatternNm());
        holidayYoyaku.setHolidayPatternDescription(uiBean.getHolidayYoyaku().getHolidayPatternDescription());
        holidayYoyaku.setYoyakuKbn(yoyakuKbn);

        manager.insert(holidayGroup);

    }

    private void updHolidayYoyaku(C_YoyakuKbn pYoyakuKbn) {

        AT_HolidayGroup holidayGroup = uiBean.getHolidayGroup();
        AT_HolidayYoyaku holidayYoyaku = holidayGroup.getHolidayYoyaku(uiBean.getHolidayYoyaku().getHolidayCd());

        C_HolidayPtn holidayPtn = uiBean.getHolidayYoyaku().getHolidayPattern();

        if (C_HolidayPtn.SPECIFIC_DAY.eq(holidayPtn)) {
            holidayYoyaku.setTekiyouYmdFrom(null);
            holidayYoyaku.setTekiyouYmdTo(null);
        }
        else {
            holidayYoyaku.setTekiyouYmdFrom(uiBean.getHolidayYoyaku().getTekiyouYmdFrom());
            holidayYoyaku.setTekiyouYmdTo(uiBean.getHolidayYoyaku().getTekiyouYmdTo());
        }

        holidayYoyaku.setLegalHolidayKbn(uiBean.getHolidayYoyaku().getLegalHolidayKbn());
        holidayYoyaku.setHolidayPattern(uiBean.getHolidayYoyaku().getHolidayPattern());
        holidayYoyaku.setHolidayPatternParam(getHolidayPram(holidayPtn));
        holidayYoyaku.setHolidayPatternNm(uiBean.getHolidayYoyaku().getHolidayPatternNm());
        holidayYoyaku.setHolidayPatternDescription(uiBean.getHolidayYoyaku().getHolidayPatternDescription());
        holidayYoyaku.setYoyakuKbn(pYoyakuKbn);

        manager.update(holidayGroup);

    }

    private String getHolidayPram(C_HolidayPtn pHolidayPtn) {

        String holidayPram = null;

        if (C_HolidayPtn.OTHER_HOLIDAYGROUP.eq(pHolidayPtn)) {

            holidayPram = uiBean.getHolidayGroupCd();
        }
        else if (C_HolidayPtn.SPECIFIC_DAY.eq(pHolidayPtn)) {

            BizDate holidayYmd = uiBean.getHolidayYmd();
            holidayPram = holidayYmd.getYear() + CONSTANTS_SLASH
                + Strings.padStart(String.valueOf(holidayYmd.getMonth()), 2, '0') + CONSTANTS_SLASH
                + Strings.padStart(String.valueOf(holidayYmd.getDay()), 2, '0');
        }
        else if (C_HolidayPtn.SPECIFIC_DAYEVERYYEAR.eq(pHolidayPtn)) {

            BizDateMD holidayMd = uiBean.getHolidayMd();
            holidayPram = holidayMd.getMonth() + CONSTANTS_SEMICOLON + holidayMd.getDay();
        }
        else if (C_HolidayPtn.SPECIFIC_DAYOFWEEK.eq(pHolidayPtn)) {

            holidayPram = uiBean.getHolidayM() + CONSTANTS_SEMICOLON
                + uiBean.getHolidayNth() + CONSTANTS_SEMICOLON
                + uiBean.getHolidaySiteiYoubi();
        }
        else if (C_HolidayPtn.EVERY_WEEK.eq(pHolidayPtn)) {

            holidayPram = uiBean.getHolidayYoubi().toString();
        }

        return holidayPram;
    }

    private void convertHolidayGroupInfo(E_HenkanKbn pHenkanKbn) {

        uiBean.clearHolidayGroupCdOptionBeanList();

        setHolidayGroupList();

        if (E_HenkanKbn.HYOUJI.equals(pHenkanKbn)) {

            List<LabelValuePair>  holidayGroupCdOptionBeanList = uiBean.getHolidayGroupCdOptionBeanList();

            for (LabelValuePair labelVale : holidayGroupCdOptionBeanList) {

                String label = labelVale.getLabel();

                if (Strings.isNullOrEmpty(label)) {
                    continue;
                }

                String[] labels = label.split(CONSTANTS_COLON);

                if (labels.length > 1) {
                    labelVale.setLabel(labels[1]);
                }
            }

        }
    }

    private void setHolidayPatternInfo() {
        uiBean.setBackHolidayPattern(uiBean.getHolidayYoyaku().getHolidayPattern());
        uiBean.setBackHolidayPatternNm(uiBean.getHolidayYoyaku().getHolidayPatternNm());
    }

    private void chkExistHolidayGroupCd() {

        String holidayGroupCd = uiBean.getHolidayGroup().getHolidayGroupCd();

        if(uiBean.getPageNo() == PAGENO_SELECTDATA){

            KeyInfoDataSourceBean keyInfoDataSourceBean = uiBean.getKeyInfoDataSource().getSelectedBean();
            holidayGroupCd = keyInfoDataSourceBean.getHolidayGroupCd();
            uiBean.getHolidayYoyaku().setHolidayPatternNm(null);
            uiBean.getHolidayYoyaku().setHolidayPattern(C_HolidayPtn.EVERY_WEEK);
        }
        if(!Strings.isNullOrEmpty(holidayGroupCd)){

            AT_HolidayGroup holidayGroup = manager.getHolidayGroup(holidayGroupCd);

            if (holidayGroup == null) {

                uiBean.getHolidayYoyaku().setHolidayPatternNm(null);
                uiBean.getHolidayYoyaku().setHolidayPattern(C_HolidayPtn.EVERY_WEEK);
                throw new BizLogicException(MessageId.EAC0046, MessageUtil.getMessage(DDID_KEYINFO_HOLIDAYGROUPCD.getErrorResourceKey()));
            }
        }
    }

    private void setHolidayInfo(String holidayGroupCd) {
        List<HolidayPatternInfoDataSourceBean> holidayPatternInfoList = Lists.newArrayList();

        List<AT_HolidayYoyaku> yoyakus = manager.getHolidayYoyakusByHolidayGroupCd(holidayGroupCd);

        List<AT_Holiday> holidays = manager.getHolidaysNotExistsYoyaku(holidayGroupCd);

        for (AT_HolidayYoyaku yoyaku : yoyakus) {
            HolidayPatternInfoDataSourceBean dsBean = new HolidayPatternInfoDataSourceBean();

            dsBean.setHolidayCd(yoyaku.getHolidayCd());
            dsBean.setLegalHolidayKbn(yoyaku.getLegalHolidayKbn());
            dsBean.setTekiyouYmdFrom(yoyaku.getTekiyouYmdFrom());
            dsBean.setTekiyouYmdTo(yoyaku.getTekiyouYmdTo());
            dsBean.setHolidayPattern(yoyaku.getHolidayPattern());
            dsBean.setHolidayPatternNm(yoyaku.getHolidayPatternNm());
            dsBean.setYoyakuKbn(yoyaku.getYoyakuKbn());

            if (!C_YoyakuKbn.SAKUJYO_YOYAKU.eq(yoyaku.getYoyakuKbn())) {
                dsBean.setHenkouLink(MessageUtil.getMessage(DDID_HOLIDAYPATTERNINFO_HENKOULINK.getErrorResourceKey()));
            }
            dsBean.setSakujyoLink(MessageUtil.getMessage(DDID_HOLIDAYPATTERNINFO_SAKUJYOLINK.getErrorResourceKey()));

            holidayPatternInfoList.add(dsBean);
        }

        for (AT_Holiday holiday : holidays) {

            HolidayPatternInfoDataSourceBean dsBean = new HolidayPatternInfoDataSourceBean();

            dsBean.setHolidayCd(holiday.getHolidayCd());
            dsBean.setLegalHolidayKbn(holiday.getLegalHolidayKbn());
            dsBean.setTekiyouYmdFrom(holiday.getTekiyouYmdFrom());
            dsBean.setTekiyouYmdTo(holiday.getTekiyouYmdTo());
            dsBean.setHolidayPattern(holiday.getHolidayPattern());
            dsBean.setHolidayPatternNm(holiday.getHolidayPatternNm());

            dsBean.setYoyakuKbn(C_YoyakuKbn.BLNK);

            dsBean.setHenkouLink(MessageUtil.getMessage(DDID_HOLIDAYPATTERNINFO_HENKOULINK.getErrorResourceKey()));
            dsBean.setSakujyoLink(MessageUtil.getMessage(DDID_HOLIDAYPATTERNINFO_SAKUJYOLINK.getErrorResourceKey()));

            holidayPatternInfoList.add(dsBean);
        }

        uiBean.setHolidayPatternInfo(holidayPatternInfoList);
    }

}
