package yuyu.common.sinkeiyaku.skcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.classification.C_Rendouflg;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_SmbcStyKanri;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 新契約 新契約共通 SMBC進捗管理データ作成クーリングオフ
 */
public class SmbcsintyokukanriCoolingoff {

    private String syoNo;

    private BizDate coolingOffDate;

    private BizDate syoriDate;

    private String sysTime;

    private String kosID;

    private String kinouID;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    public SmbcsintyokukanriCoolingoff() {
        super();
    }

    public String getFunctionId() {

        return kinou.getKinouId();
    }

    public String getUserID() {
        return baseUserInfo.getUserId();
    }

    public void exec(String pSyoNo, BizDate pCoolingOffDate, BizDate pSyoriDate) {

        kinouID = getFunctionId();
        kosID = getUserID();
        sysTime = BizDate.getSysDateTimeMilli();


        syoNo = pSyoNo;
        coolingOffDate = pCoolingOffDate;
        syoriDate = pSyoriDate;


        if (coolingOffDate != null) {
            entryCleaningoffDate();
        }
        else {
            cancelCleaningoffDate();
        }
    }

    private void entryCleaningoffDate() {

        List<HT_SmbcStyKanri> smbcStyKanriLst = sinkeiyakuDomManager.
            getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymd(syoNo, "");

        if (smbcStyKanriLst.size() == 0) {
            return;
        }

        if (!checkTaisyou(smbcStyKanriLst.get(0).getSmbcseihohktymd(), syoriDate) &&
            !checkTaisyou(coolingOffDate.toString(), syoriDate) &&
            !checkTaisyou(smbcStyKanriLst.get(0).getSmbcseihosyknhkkzmymd(), syoriDate)) {
            return;
        }

        BizNumber renNo = BizNumber.valueOf(0);
        BizNumber rtSmbcMaxRenNo = sinkeiyakuDomManager.
            getSmbcStyKanriMaxDatasakuseirennoByDatarenymd(syoriDate);
        if (rtSmbcMaxRenNo != null) {
            renNo = rtSmbcMaxRenNo;
        }


        HT_SmbcStyKanri smbcStyKanri = new HT_SmbcStyKanri();

        smbcStyKanri.setDatarenymd(syoriDate);
        smbcStyKanri.setDatasakuseirenno(renNo.add(BizNumber.valueOf(1)));
        smbcStyKanri.setSyono(syoNo);
        smbcStyKanri.setMosno(smbcStyKanriLst.get(0).getMosno());
        smbcStyKanri.setRendouflg(C_Rendouflg.MIRENDOU);
        smbcStyKanri.setSmbcdatakbn(smbcStyKanriLst.get(0).getSmbcdatakbn());
        smbcStyKanri.setSmbcdatasakuseiymd(syoriDate.toString());
        smbcStyKanri.setSmbchknkaisyacd(smbcStyKanriLst.get(0).getSmbchknkaisyacd());
        smbcStyKanri.setSmbcuktkkanriid(smbcStyKanriLst.get(0).getSmbcuktkkanriid());
        smbcStyKanri.setSmbcseihouktkzmymd(smbcStyKanriLst.get(0).getSmbcseihouktkzmymd());
        smbcStyKanri.setSmbcseihohbymd(smbcStyKanriLst.get(0).getSmbcseihohbymd());
        smbcStyKanri.setSmbcbankhnkykflg(smbcStyKanriLst.get(0).getSmbcbankhnkykflg());
        smbcStyKanri.setSmbcseihohbksyymd(smbcStyKanriLst.get(0).getSmbcseihohbksyymd());
        smbcStyKanri.setSmbcseihohjyttykymd(smbcStyKanriLst.get(0).getSmbcseihohjyttykymd());
        smbcStyKanri.setSmbcseihonyknzmymd(smbcStyKanriLst.get(0).getSmbcseihonyknzmymd());
        smbcStyKanri.setSmbcseihosnszmymd(smbcStyKanriLst.get(0).getSmbcseihosnszmymd());
        smbcStyKanri.setSmbcseihosyknhkkzmymd(smbcStyKanriLst.get(0).getSmbcseihosyknhkkzmymd());
        smbcStyKanri.setSmbcseihosyumoku(smbcStyKanriLst.get(0).getSmbcseihosyumoku());
        smbcStyKanri.setSmbcseihosyurui(smbcStyKanriLst.get(0).getSmbcseihosyurui());
        smbcStyKanri.setSmbcsyono(smbcStyKanriLst.get(0).getSmbcsyono());
        smbcStyKanri.setSmbcsyonoedaban(smbcStyKanriLst.get(0).getSmbcsyonoedaban());
        smbcStyKanri.setSmbcjktkflg(smbcStyKanriLst.get(0).getSmbcjktkflg());
        smbcStyKanri.setSmbcseihotrksymd(coolingOffDate.toString());
        smbcStyKanri.setSmbcseihohktymd(smbcStyKanriLst.get(0).getSmbcseihohktymd());
        smbcStyKanri.setSmbckykseiymd(smbcStyKanriLst.get(0).getSmbckykseiymd());
        smbcStyKanri.setSmbckyknmkn(smbcStyKanriLst.get(0).getSmbckyknmkn());
        smbcStyKanri.setSmbcmosuktymd(smbcStyKanriLst.get(0).getSmbcmosuktymd());
        smbcStyKanri.setSmbcmossyoriflg(smbcStyKanriLst.get(0).getSmbcmossyoriflg());
        smbcStyKanri.setSmbckosyaareastyknr(smbcStyKanriLst.get(0).getSmbckosyaareastyknr());
        smbcStyKanri.setGyoumuKousinKinou(kinouID);
        smbcStyKanri.setGyoumuKousinsyaId(kosID);
        smbcStyKanri.setGyoumuKousinTime(sysTime);

        BizPropertyInitializer.initialize(smbcStyKanri);

        sinkeiyakuDomManager.insert(smbcStyKanri);
    }

    private void cancelCleaningoffDate() {

        List<HT_SmbcStyKanri> smbcStyKanriLst = sinkeiyakuDomManager
            .getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymdSmbcseihotrksymd(syoNo, "", "");
        if (smbcStyKanriLst.size() > 0) {
            sinkeiyakuDomManager.delete(smbcStyKanriLst);
        }
    }

    public static boolean checkTaisyou(String pTarget, BizDate pSyoriYmd) {
        if (BizUtil.isBlank(pTarget)) {
            return false;
        }
        BizDate targetYmd = BizDate.valueOf(pTarget);
        if (!targetYmd.isRekijyou()) {
            return false;
        }
        BizDate kjnYmd = targetYmd.addMonths(3).getRekijyou();
        if (BizDateUtil.compareYmd(pSyoriYmd, kjnYmd) == BizDateUtil.COMPARE_LESSER) {
            return true;
        }
        return false;
    }
}
