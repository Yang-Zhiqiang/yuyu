package yuyu.common.suuri.srcommon;

import jp.co.slcs.swak.date.BizDateY;
import yuyu.common.hozen.haitou.SetDNnd;
import yuyu.common.hozen.haitou.SetDNnd.DRateSyutokuInfoBean;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_NaiteiKakuteiKbn;

/**
 *  数理 数理共通 配当所要算出用Dレート取得条件Bean
 */
public class SrDRateSyutokuInfoBeanForDSyoyou extends DRateSyutokuInfoBean {

    public SrDRateSyutokuInfoBeanForDSyoyou(SetDNnd setDNnd) {
        setDNnd.super();
    }

    public void setKoumoku(
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        C_Hrkkaisuu pHrkkaisuu,
        BizDateY pDratenendo,
        C_Kykjyoutai pKykjyoutaiHenkango) {

        setSyouhncd(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
        setRyouritusdno(pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());
        setYoteiriritu(pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu());
        setHrkkaisuu(pHrkkaisuu);
        setHhknsei(pTkJitenKeiyakuSyouhinKijyunBean.getHhknsei());
        setHhknnen(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen());
        setHknkknsmnkbn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn());
        setHknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn());
        setHrkkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHrkkkn());
        setKykjyoutai(pKykjyoutaiHenkango);
        setTuukasyu(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());
        setDai1hknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getDai1hknkkn());
        setDratenendo(pDratenendo);
        setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
    }
}
