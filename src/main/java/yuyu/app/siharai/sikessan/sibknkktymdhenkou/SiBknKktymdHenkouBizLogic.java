package yuyu.app.siharai.sikessan.sibknkktymdhenkou;

import static yuyu.app.siharai.sikessan.sibknkktymdhenkou.GenSiBknKktymdHenkouConstants.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.hozen.khcommon.SetDenSimebi;
import yuyu.common.hozen.khcommon.SetKessanNensibi;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.def.MessageId;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.kinoumode.KinouMode;

/**
 * 備金確定日変更 のビジネスロジックです。
 */
public class SiBknKktymdHenkouBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SiBknKktymdHenkouUiBean uiBean;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    void init() {
    }

    void clear() {
    }

    String ketteiBtnOnClickBL() {

        BizPropertyInitializer.initialize(uiBean);

        BizDate sysDate = BizDate.getSysDate();

        if(sysDate.getMonth() >= 4) {
            throw new BizLogicException(MessageId.EBA1032);
        }

        if(sysDate.getMonth() == 1) {
            SetDenSimebi setDenSimebi = SWAKInjector.getInstance(SetDenSimebi.class);

            BizDate denSimebiDate = setDenSimebi.exec(sysDate);

            if (BizDateUtil.compareYmd(sysDate, denSimebiDate) == BizDateUtil.COMPARE_EQUAL ||
                BizDateUtil.compareYmd(sysDate, denSimebiDate) == BizDateUtil.COMPARE_LESSER) {
                throw new BizLogicException(MessageId.EBA1032);
            }
        }

        KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);

        KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);

        keiyakuPrm.setSyono(uiBean.getSyono());
        keiyakuPrm.setINayoseyh(C_NayoseYouhi.HUYOU);

        keiyakuInfoSyutoku.getInfos(keiyakuPrm);

        List<JT_SiKykKihon> siKykKihonLst = keiyakuInfoSyutoku.getKykKihons();

        if (siKykKihonLst.get(0) == null) {
            throw new BizLogicException(MessageId.EBA0024, MessageUtil.getMessage(MessageId.IJW1001));
        }

        JT_SiKykKihon siKykKihon = siKykKihonLst.get(0);

        BizDate kessankijyunYmd = BizDate.valueOf(sysDate.getBizDateY().addYears(-1), 12, 31);

        List<JT_SiBikinkanri> siBikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyonoKsnYmdJkukbnRigikbnNe(
            uiBean.getSyono(), kessankijyunYmd, C_BknJkuKbn.SAISAISAIBI, C_BknrigiKbn.DEL);

        if (siBikinkanriLst.size() == 0) {
            throw new BizLogicException(MessageId.EJA1062);
        }
        uiBean.setSiBikinkanri(siBikinkanriLst.get(0));

        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyono(uiBean.getSyono());

        for(int i = skKihonLst.size() - 1; i >= 0; i--) {
            if(C_SeikyuuSyubetu.SDSSHR.eq(skKihonLst.get(i).getSeikyuusyubetu())) {
                skKihonLst.remove(i);
            }
        }

        uiBean.setSkKihonLst(skKihonLst);

        uiBean.setSkno(uiBean.getSiBikinkanri().getSkno());

        uiBean.setKyknmkn(siKykKihon.getKyknmkn());
        uiBean.setKykseiymd(siKykKihon.getKykseiymd());
        uiBean.setKyknmkj(siKykKihon.getKyknmkj());
        uiBean.setKyksei(siKykKihon.getKyksei());

        uiBean.setHhknnmkn(siKykKihon.getHhknnmkn());
        uiBean.setHhknseiymd(siKykKihon.getHhknseiymd());
        uiBean.setHhknnmkj(siKykKihon.getHhknnmkj());
        uiBean.setHhknsei(siKykKihon.getHhknsei());

        uiBean.setSiboukaritrkymd(uiBean.getSkKihonLst().get(0).getSiboukaritrkymd());

        uiBean.setBknkktymd(null);

        return FORWARDNAME_INPUTCONTENTS;
    }

    String kakuninBtnOnClickBL() {

        BizDate sysDate = BizDate.getSysDate();

        SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);

        int sysnnd = setKessanNensibi.exec(sysDate).getYear();

        int bknkktinnd = setKessanNensibi.exec(uiBean.getBknkktymd()).getYear();

        if(sysnnd - bknkktinnd < 2 ) {
            throw new BizLogicException(MessageId.EBA0028,
                MessageUtil.getMessage(DDID_BIKOUINFOAFTER_BKNKKTYMD.getErrorResourceKey()));
        }

        if(sysnnd - bknkktinnd >=3  &&
            !(BizDateUtil.compareYmd(uiBean.getBknkktymd(), uiBean.getSiBikinkanri().getBknkktymd()) == BizDateUtil.COMPARE_EQUAL)) {
            throw new BizLogicException(MessageId.EBA0028,
                MessageUtil.getMessage(DDID_BIKOUINFOAFTER_BKNKKTYMD.getErrorResourceKey()));
        }

        messageManager.addMessageId(MessageId.QBA0001);

        return FORWARDNAME_CONFIRM;
    }

    @Transactional
    String kakuteiBtnOnClickBL() {

        String sysDateTime = BizDate.getSysDateTimeMilli();

        for(JT_SkKihon skKihon : uiBean.getSkKihonLst()) {

            skKihon.setSiboukaritrkymd(uiBean.getBknkktymd());
            skKihon.setKossyoricd(kinou.getKinouId());
            skKihon.setKossyorisscd(kinouMode.getKinouMode());
            skKihon.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            skKihon.setGyoumuKousinTime(sysDateTime);

            siharaiDomManager.update(skKihon);
        }

        messageManager.addMessageId(MessageId.IAC0009);

        return FORWARDNAME_RESULT;
    }
}
