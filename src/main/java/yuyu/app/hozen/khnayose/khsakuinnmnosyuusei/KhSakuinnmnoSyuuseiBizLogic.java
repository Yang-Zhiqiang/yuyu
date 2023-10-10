package yuyu.app.hozen.khnayose.khsakuinnmnosyuusei;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SyuuseiTaisyouKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全索引名番号修正 のビジネスロジックです。
 */
public class KhSakuinnmnoSyuuseiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhSakuinnmnoSyuuseiUiBean uiBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private MessageManager messageManager;

    void init() {
        clear();
    }

    void clear() {
    }

    void pushKetteiBL() {

        BizPropertyInitializer.initialize(uiBean);

        IT_KykKihon itKykKihon = hozenDomManager.getKykKihon(uiBean.getSyono());

        if (itKykKihon == null) {

            throw new BizLogicException(MessageId.EBA0090);
        }

        uiBean.setItKykKihon(itKykKihon);

        IT_KykSya itKykSya = itKykKihon.getKykSya();

        IT_HhknSya itHhknSya = itKykKihon.getHhknSya();

        String taisyoudouituhyouji = MessageUtil.getMessage(MessageId.IIW1001);

        if (C_SyuuseiTaisyouKbn.HHKN.eq(uiBean.getSyuuseitaisyoukbn())) {

            uiBean.setTaisyoudouituhyouji(taisyoudouituhyouji);
            uiBean.setTaisyounmkn(itHhknSya.getHhknnmkn());
            uiBean.setTaisyounmkj(itHhknSya.getHhknnmkj());
            uiBean.setTaisyouseiymd(itHhknSya.getHhknseiymd());
            uiBean.setTaisyousakuinnmno(itHhknSya.getHhknsakuinmeino());

        }
        if (C_SyuuseiTaisyouKbn.KYK.eq(uiBean.getSyuuseitaisyoukbn())) {

            uiBean.setTaisyoudouituhyouji(taisyoudouituhyouji);
            uiBean.setTaisyounmkn(itKykSya.getKyknmkn());
            uiBean.setTaisyounmkj(itKykSya.getKyknmkj());
            uiBean.setTaisyouseiymd(itKykSya.getKykseiymd());
            uiBean.setTaisyousakuinnmno(itKykSya.getKyksakuinmeino());
        }

    }
    void pushKakuninBL() {

        messageManager.addMessageId(MessageId.QAC0009);

    }
    @Transactional
    void pushKakuteiBL() {

        BizDate sysDate = BizDate.getSysDate();

        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();

        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        String henkouSikibetukey = khozenCommonParam.getSikibetuKey(uiBean.getSyono());

        tableMaintenanceUtil.backUp(uiBean.getSyono(), henkouSikibetukey);

        if (C_SyuuseiTaisyouKbn.HHKN.eq(uiBean.getSyuuseitaisyoukbn())) {

            if (C_Tdk.HONNIN.eq(uiBean.getItKykKihon().getKykSya().getKkkyktdk())) {

                setKykSya();

                setHhknSya();

            }
            else {

                setHhknSya();

            }

        }
        else if (C_SyuuseiTaisyouKbn.KYK.eq(uiBean.getSyuuseitaisyoukbn())) {

            if (C_Tdk.HONNIN.eq(uiBean.getItKykKihon().getKykSya().getKkkyktdk())) {

                setKykSya();

                setHhknSya();

            }
            else {

                setKykSya();

            }

        }

        uiBean.getItKykKihon().setSyhenkouymd(sysDate);
        uiBean.getItKykKihon().setGyoumuKousinKinou(kinou.getKinouId());
        uiBean.getItKykKihon().setGyoumuKousinsyaId(baseUserInfo.getUserId());
        uiBean.getItKykKihon().setGyoumuKousinTime(sysDateTimeMilli);

        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);

        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

        editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
        editTtdkRirekiTblParam.setSyoNo(uiBean.getSyono());
        editTtdkRirekiTblParam.setSyoriYmd(sysDate);
        editTtdkRirekiTblParam.setSysTime(sysDateTimeMilli);
        editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);

        IT_KhTtdkRireki itKhTtdkRireki = uiBean.getItKykKihon().createKhTtdkRireki();
        itKhTtdkRireki.setHenkousikibetukey(henkouSikibetukey);

        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

        hozenDomManager.update(uiBean.getItKykKihon());

        messageManager.addMessageId(MessageId.IAC0009);

    }

    private void setKykSya() {

        IT_KykSya itKykSya = uiBean.getItKykKihon().getKykSya();

        itKykSya.setKyksakuinmeino(uiBean.getSyuuseigosakuinnmno());
        itKykSya.setGyoumuKousinKinou(kinou.getKinouId());
        itKykSya.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        itKykSya.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

    }

    private void setHhknSya() {

        IT_HhknSya itHhknSya = uiBean.getItKykKihon().getHhknSya();

        itHhknSya.setHhknsakuinmeino(uiBean.getSyuuseigosakuinnmno());
        itHhknSya.setGyoumuKousinKinou(kinou.getKinouId());
        itHhknSya.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        itHhknSya.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

    }

}
