package yuyu.app.hozen.khkessan.khbikinsakujyo;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.SetDenSimebi;
import yuyu.def.MessageId;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_BknsyoriKbn;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全備金削除 のビジネスロジックです。
 */
public class KhBikinSakujyoBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhBikinSakujyoUiBean uiBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private MessageManager messageManager;

    void init() {
    }

    void clear() {
    }

    void pushKetteiBL() {

        BizPropertyInitializer.initialize(uiBean);

        String syono = uiBean.getSyono();
        C_BkncdKbn bkncdKbn = uiBean.getBkncdkbn();
        BizDate bknkktYmd = uiBean.getBknkktymd();
        C_BknsyoriKbn bknsyoriKbn = uiBean.getBknsyorikbn();
        BizDate syoriYmd = BizDate.getSysDate();

        if (!(syoriYmd.getMonth() == KhBikinSakujyoConstants.JANUARY
            || syoriYmd.getMonth() == KhBikinSakujyoConstants.APRIL
            || syoriYmd.getMonth() == KhBikinSakujyoConstants.JULY
            || syoriYmd.getMonth() == KhBikinSakujyoConstants.OCTOBER)) {

            throw new BizLogicException(MessageId.EIA1014);
        }

        SetDenSimebi setDenSimebi = SWAKInjector.getInstance(SetDenSimebi.class);

        BizDate zengetudensimeymd = setDenSimebi.exec(syoriYmd);

        if (BizDateUtil.compareYmd(zengetudensimeymd, syoriYmd) < 0) {

            throw new BizLogicException(MessageId.EIA1014);
        }

        IT_KykKihon itKykKihon = hozenDomManager.getKykKihon(syono);

        if (itKykKihon == null) {

            throw new BizLogicException(MessageId.EBA0090);
        }

        BizDate kessanKijyunYmd = syoriYmd.getBizDateYM().getPreviousMonth().getLastDay();

        List<IT_KhBikinkanri> itKhBikinkanriList = hozenDomManager.getKhBikinkanrisByPKWithoutRenno(
            syono,
            kessanKijyunYmd,
            bkncdKbn,
            bknkktYmd);

        if (itKhBikinkanriList.size() == 0) {

            throw new BizLogicException(MessageId.EBA0030, KhBikinSakujyoConstants.BIKINJYOUHOU);
        }
        IT_KhBikinkanri itKhBikinkanri = itKhBikinkanriList.get(0);

        uiBean.setItKhBikinkanri(itKhBikinkanri);

        if (C_BknsyoriKbn.SAKUJYO.eq(bknsyoriKbn)) {

            if (!C_BknrigiKbn.BLNK.eq(itKhBikinkanri.getBknrigikbn())) {

                throw new BizLogicException(MessageId.EIA1015, KhBikinSakujyoConstants.BIKINSAKUJYOSUMI);
            }

        }

        if (C_BknsyoriKbn.TORIKESI.eq(bknsyoriKbn)) {

            if (C_BknrigiKbn.BLNK.eq(itKhBikinkanri.getBknrigikbn())) {

                throw new BizLogicException(MessageId.EIF1067);
            }

            if (!C_BknJkuKbn.SINBI.eq(itKhBikinkanri.getBknjkukbn())) {

                throw new BizLogicException(MessageId.EIA1016, KhBikinSakujyoConstants.SINBIIGAI);
            }

        }

        uiBean.setKessankijyunymd(kessanKijyunYmd);
        uiBean.setBknrigikbn(itKhBikinkanri.getBknrigikbn());
        uiBean.setBkngk(itKhBikinkanri.getBkngk());
        uiBean.setCalckijyunymd(itKhBikinkanri.getCalckijyunymd());
        uiBean.setKbnkeirisegcd(itKhBikinkanri.getKbnkeirisegcd());
        uiBean.setSyouhncd(itKhBikinkanri.getSyouhncd());
        uiBean.setShrsyoriymd(itKhBikinkanri.getShrsyoriymd());
        uiBean.setTyakkinymd(itKhBikinkanri.getTyakkinymd());

    }

    void pushKakuninBL() {

        messageManager.addMessageId(MessageId.QBA0001);
    }

    @Transactional
    void pushKakuteiBL() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        String kinouId = khozenCommonParam.getFunctionId();
        String userId = khozenCommonParam.getUserID();
        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();

        IT_KhBikinkanri itKhBikinkanri = uiBean.getItKhBikinkanri();

        if (C_BknsyoriKbn.SAKUJYO.eq(uiBean.getBknsyorikbn())) {

            itKhBikinkanri.setBknrigikbn(C_BknrigiKbn.DEL);

        }
        else if (C_BknsyoriKbn.TORIKESI.eq(uiBean.getBknsyorikbn())) {

            itKhBikinkanri.setBknrigikbn(C_BknrigiKbn.BLNK);

        }

        itKhBikinkanri.setGyoumuKousinKinou(kinouId);
        itKhBikinkanri.setGyoumuKousinsyaId(userId);
        itKhBikinkanri.setGyoumuKousinTime(sysDateTimeMilli);

        hozenDomManager.update(itKhBikinkanri);

        messageManager.addMessageId(MessageId.IAC0009);

    }

}
