package yuyu.common.biz.bzcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.classification.C_SosikiNmKbn;
import yuyu.def.classification.C_SosikiYuuksHantKbn;
import yuyu.def.classification.C_SosikimasterUmuKbn;

/**
 * 業務共通 共通 組織情報取得Beanクラス
 */
public class BzGetSosikiDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_SosikimasterUmuKbn sosikimasterumukbn;

    private C_SosikiYuuksHantKbn sosikiyuukshantkbn;

    private String kijyunymdjdsosikikihontikucd;

    private String sosikicd;

    private C_SosikiNmKbn sosikinmkbn;

    private String sosikinm20;

    private String kanjisosikinm20;

    private BizDateYM sosikihaisiym;

    private BizDateYM sosikisinsetuym;

    private String tougetukeisyouusosikicd;

    private String tougetukeisyoueigyoubucd;

    private String zengetukeisyousosikicd;

    private String zengetukeisyoueigyoubucd;

    private String sosikikihontikucd;

    private String sosikikanjikaijyuusyo30;

    private String kanjibirunm15;

    private String sosikinyuukyokaisuu;

    private String sosikitelno;

    private String sosikifaxno;

    private BizDate kouryokukaisiymd;

    private String hensosikikihontikucd;

    private String henkanjisosikikaijyuusyo30;

    private String henkanjibirunm15;

    private String hensosikinyuukyokaisuu;

    private String hensosikitelno;

    private String hensosikifaxno;

    public BzGetSosikiDataBean() {
        super();
    }

    public C_SosikimasterUmuKbn getSosikimasterumukbn() {
        return sosikimasterumukbn;
    }

    public void setSosikimasterumukbn(C_SosikimasterUmuKbn pSosikimasterumukbn) {
        sosikimasterumukbn = pSosikimasterumukbn;
    }

    public C_SosikiYuuksHantKbn getSosikiyuukshantkbn() {
        return sosikiyuukshantkbn;
    }

    public void setSosikiyuukshantkbn(C_SosikiYuuksHantKbn pSosikiyuukshantkbn) {
        sosikiyuukshantkbn = pSosikiyuukshantkbn;
    }

    public String getKijyunymdjdsosikikihontikucd() {
        return kijyunymdjdsosikikihontikucd;
    }

    public void setKijyunymdjdsosikikihontikucd(String pKijyunymdjdsosikikihontikucd) {
        kijyunymdjdsosikikihontikucd = pKijyunymdjdsosikikihontikucd;
    }

    public String getSosikicd() {
        return sosikicd;
    }

    public void setSosikicd(String pSosikicd) {
        sosikicd = pSosikicd;
    }

    public C_SosikiNmKbn getSosikinmkbn() {
        return sosikinmkbn;
    }

    public void setSosikinmkbn(C_SosikiNmKbn pSosikinmkbn) {
        sosikinmkbn = pSosikinmkbn;
    }

    public String getSosikinm20() {
        return sosikinm20;
    }

    public void setSosikinm20(String pSosikinm20) {
        sosikinm20 = pSosikinm20;
    }

    public String getKanjisosikinm20() {
        return kanjisosikinm20;
    }

    public void setKanjisosikinm20(String pKanjisosikinm20) {
        kanjisosikinm20 = pKanjisosikinm20;
    }

    public BizDateYM getSosikihaisiym() {
        return sosikihaisiym;
    }

    public void setSosikihaisiym(BizDateYM pSosikihaisiym) {
        sosikihaisiym = pSosikihaisiym;
    }

    public BizDateYM getSosikisinsetuym() {
        return sosikisinsetuym;
    }

    public void setSosikisinsetuym(BizDateYM pSosikisinsetuym) {
        sosikisinsetuym = pSosikisinsetuym;
    }

    public String getTougetukeisyouusosikicd() {
        return tougetukeisyouusosikicd;
    }

    public void setTougetukeisyouusosikicd(String pTougetukeisyouusosikicd) {
        tougetukeisyouusosikicd = pTougetukeisyouusosikicd;
    }

    public String getTougetukeisyoueigyoubucd() {
        return tougetukeisyoueigyoubucd;
    }

    public void setTougetukeisyoueigyoubucd(String pTougetukeisyoueigyoubucd) {
        tougetukeisyoueigyoubucd = pTougetukeisyoueigyoubucd;
    }

    public String getZengetukeisyousosikicd() {
        return zengetukeisyousosikicd;
    }

    public void setZengetukeisyousosikicd(String pZengetukeisyousosikicd) {
        zengetukeisyousosikicd = pZengetukeisyousosikicd;
    }

    public String getZengetukeisyoueigyoubucd() {
        return zengetukeisyoueigyoubucd;
    }

    public void setZengetukeisyoueigyoubucd(String pZengetukeisyoueigyoubucd) {
        zengetukeisyoueigyoubucd = pZengetukeisyoueigyoubucd;
    }

    public String getSosikikihontikucd() {
        return sosikikihontikucd;
    }

    public void setSosikikihontikucd(String pSosikikihontikucd) {
        sosikikihontikucd = pSosikikihontikucd;
    }

    public String getSosikikanjikaijyuusyo30() {
        return sosikikanjikaijyuusyo30;
    }

    public void setSosikikanjikaijyuusyo30(String pSosikikanjikaijyuusyo30) {
        sosikikanjikaijyuusyo30 = pSosikikanjikaijyuusyo30;
    }

    public String getKanjibirunm15() {
        return kanjibirunm15;
    }

    public void setKanjibirunm15(String pKanjibirunm15) {
        kanjibirunm15 = pKanjibirunm15;
    }

    public String getSosikinyuukyokaisuu() {
        return sosikinyuukyokaisuu;
    }

    public void setSosikinyuukyokaisuu(String pSosikinyuukyokaisuu) {
        sosikinyuukyokaisuu = pSosikinyuukyokaisuu;
    }

    public String getSosikitelno() {
        return sosikitelno;
    }

    public void setSosikitelno(String pSosikitelno) {
        sosikitelno = pSosikitelno;
    }

    public String getSosikifaxno() {
        return sosikifaxno;
    }

    public void setSosikifaxno(String pSosikifaxno) {
        sosikifaxno = pSosikifaxno;
    }

    public BizDate getKouryokukaisiymd() {
        return kouryokukaisiymd;
    }

    public void setKouryokukaisiymd(BizDate pKouryokukaisiymd) {
        kouryokukaisiymd = pKouryokukaisiymd;
    }

    public String getHensosikikihontikucd() {
        return hensosikikihontikucd;
    }

    public void setHensosikikihontikucd(String pHensosikikihontikucd) {
        hensosikikihontikucd = pHensosikikihontikucd;
    }

    public String getHenkanjisosikikaijyuusyo30() {
        return henkanjisosikikaijyuusyo30;
    }

    public void setHenkanjisosikikaijyuusyo30(String pHenkanjisosikikaijyuusyo30) {
        henkanjisosikikaijyuusyo30 = pHenkanjisosikikaijyuusyo30;
    }

    public String getHenkanjibirunm15() {
        return henkanjibirunm15;
    }

    public void setHenkanjibirunm15(String pHenkanjibirunm15) {
        henkanjibirunm15 = pHenkanjibirunm15;
    }

    public String getHensosikinyuukyokaisuu() {
        return hensosikinyuukyokaisuu;
    }

    public void setHensosikinyuukyokaisuu(String pHensosikinyuukyokaisuu) {
        hensosikinyuukyokaisuu = pHensosikinyuukyokaisuu;
    }

    public String getHensosikitelno() {
        return hensosikitelno;
    }

    public void setHensosikitelno(String pHensosikitelno) {
        hensosikitelno = pHensosikitelno;
    }

    public String getHensosikifaxno() {
        return hensosikifaxno;
    }

    public void setHensosikifaxno(String pHensosikifaxno) {
        hensosikifaxno = pHensosikifaxno;
    }

}
