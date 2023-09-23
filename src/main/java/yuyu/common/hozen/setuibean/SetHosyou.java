package yuyu.common.hozen.setuibean;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateSpan;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyouriritu;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyourirituBean;
import yuyu.common.biz.bzcommon.GetYoteiriritu;
import yuyu.common.biz.bzcommon.GetYoteirirituBean;
import yuyu.common.biz.bzcommon.HanteiHokenKikan;
import yuyu.common.biz.bzcommon.HanteiHokenKikanBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.CVBean;
import yuyu.common.hozen.khcommon.HanteiKhSisuurendoTmttknJyoutai;
import yuyu.common.hozen.khcommon.HanteiTmttknJyoutaiBean;
import yuyu.common.hozen.khcommon.KeisanCV;
import yuyu.common.hozen.khcommon.KeisanGaisanPsougk;
import yuyu.common.hozen.khcommon.KeisanKijyungk;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkTmttkn;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.SyouhntaniKousingoPkeisan;
import yuyu.common.hozen.khcommon.TokujoSSakugenNaiyouKeisan;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Htnpkkn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_KihonssyuruiKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SyukyhkinkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_Tkjyhyouten;
import yuyu.def.classification.C_Tkjyskgnkkn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_TokkoudosghtnpKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.classification.C_YendthnkJyoutaiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.BM_HutanpoBui;
import yuyu.def.db.entity.BM_SisuuKihon;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_SyouhnTokujou;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.SisurendoTmttknInfoBean;

/**
 * 契約保全 UiBean設定 保障内容設定
 */
public class SetHosyou {

    private static final String BLANK = "";

    @Inject
    private SyouhntaniKousingoPkeisan syouhntaniKousingoPkeisan;

    @Inject
    private TokujoSSakugenNaiyouKeisan tokujoSSakugenNaiyouKeisan;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    public SetHosyou() {
        super();
    }

    public boolean exec(KhozenCommonParam pKCParm, SetHosyouExecUiBeanParam pUiBean) {

        setBP_Syu(pKCParm, pUiBean);

        setBP_Tbkt(pKCParm, pUiBean);

        setBP_Tk(pKCParm, pUiBean);

        setBP_Hsny(pKCParm, pUiBean);

        return true;
    }

    public void init(SetHosyouExecUiBeanParam pUiBean) {
        pUiBean.setVhsyusyusyouhnnm(BLANK);
        pUiBean.setVhsyuaisyoumeikbn(C_AisyoumeiKbn.BLNK);
        pUiBean.setVhsyusyukyktuukasyu(C_Tuukasyu.BLNK);
        pUiBean.setVhsyusyukykjisiteituukasyu(C_Tuukasyu.BLNK);
        pUiBean.setVhsyusyukatakbn(C_KataKbn.BLNK);
        pUiBean.setVhsyusyukyhgndkatakbn(C_KyhgndkataKbn.BLNK);
        pUiBean.setVhsyusyuhhknnen(null);
        pUiBean.setVhsyusyukykymd(null);
        pUiBean.setVhsyusyusknnkaisiymd(null);
        pUiBean.setVhsyugansknnkaisiymd(null);
        pUiBean.setVhsyusyufktsknnkaisiymd(null);
        pUiBean.setVhsyuhkgogansknnkaisiymd(null);
        pUiBean.setVhsyusyuhknkkn(null);
        pUiBean.setVhsyusyuhknkknsmnkbn(C_HknkknsmnKbn.BLNK);
        pUiBean.setVhsyusdpdkbn(C_Sdpd.BLNK);
        pUiBean.setVhsyusyuhrkkkn(null);
        pUiBean.setVhsyusyuhrkkknsmnkbn(C_HrkkknsmnKbn.BLNK);
        pUiBean.setVhsyudai1hknkkn(null);
        pUiBean.setVhsyusyukihonssyuruikbn(C_KihonssyuruiKbn.BLNK);
        pUiBean.setVhsyusyukihons(BizCurrency.optional());
        pUiBean.setVhsyusyukykkjnkngk(BizCurrency.optional());
        pUiBean.setVhsyugenzaisbhknkngaku(BizCurrency.optional());
        pUiBean.setVhsyusaigaisbhknkngaku(BizCurrency.optional());
        pUiBean.setVhsyusyukihonkyhgk(BizCurrency.optional());
        pUiBean.setVhsyusyup(BizCurrency.optional());
        pUiBean.setVhsyusyunextkosgop(BizCurrency.optional());
        pUiBean.setVhsyusyusyukyhkinkatakbn(C_SyukyhkinkataKbn.BLNK);
        pUiBean.setVhsyusyurokudaildkbn(C_6daiLdKbn.BLNK);
        pUiBean.setVhsyusyugannyukyhntgk(BizCurrency.optional());
        pUiBean.setVhsyusyushrskgnstartymd(null);
        pUiBean.setVhsyusyushrskgnendymd(null);
        pUiBean.setVhsyusyushrskgngos(BizCurrency.optional());
        pUiBean.setVhsyusyunnkinsyukbn(C_Nenkinsyu.BLNK);
        pUiBean.setVhsyusyunenkinkkn(null);
        pUiBean.setVhsyusyutkjyskgnkkn(C_Tkjyskgnkkn.BLNK);
        pUiBean.setVhsyusyutkjyskgnhkndsymd1(null);
        pUiBean.setVhsyusyutkjyskgnhkndeymd1(null);
        pUiBean.setVhsyusyutkjyskgns1(BizCurrency.optional());
        pUiBean.setVhsyusyutkjyskgnhkndsymd2(null);
        pUiBean.setVhsyusyutkjyskgnhkndeymd2(null);
        pUiBean.setVhsyusyutkjyskgns2(BizCurrency.optional());
        pUiBean.setVhsyusyutkjyskgnhkndsymd3(null);
        pUiBean.setVhsyusyutkjyskgnhkndeymd3(null);
        pUiBean.setVhsyusyutkjyskgns3(BizCurrency.optional());
        pUiBean.setVhsyusyutkjyskgnhkndsymd4(null);
        pUiBean.setVhsyusyutkjyskgnhkndeymd4(null);
        pUiBean.setVhsyusyutkjyskgns4(BizCurrency.optional());
        pUiBean.setVhsyusyutkjyskgnhkndsymd5(null);
        pUiBean.setVhsyusyutkjyskgnhkndeymd5(null);
        pUiBean.setVhsyusyutkjyskgns5(BizCurrency.optional());
        pUiBean.setVhsyusyutkjyhyouten(C_Tkjyhyouten.BLNK);
        pUiBean.setVhsyusyutkjyp(BizCurrency.optional());
        pUiBean.setVhsyusyuhtnpbuicd1(BLANK);
        pUiBean.setVhsyusyuhtnpbuinm1(BLANK);
        pUiBean.setVhsyusyuhtnpkkn1(C_Htnpkkn.BLNK);
        pUiBean.setVhsyusyuhtnpbuicd2(BLANK);
        pUiBean.setVhsyusyuhtnpbuinm2(BLANK);
        pUiBean.setVhsyusyuhtnpkkn2(C_Htnpkkn.BLNK);
        pUiBean.setVhsyusyuhtnpbuicd3(BLANK);
        pUiBean.setVhsyusyuhtnpbuinm3(BLANK);
        pUiBean.setVhsyusyuhtnpkkn3(C_Htnpkkn.BLNK);
        pUiBean.setVhsyusyuhtnpbuicd4(BLANK);
        pUiBean.setVhsyusyuhtnpbuinm4(BLANK);
        pUiBean.setVhsyusyuhtnpkkn4(C_Htnpkkn.BLNK);
        pUiBean.setVhsyusyutokkdsghtnpkbn(C_TokkoudosghtnpKbn.BLNK);
        pUiBean.setVhsyusyututakngk(BizCurrency.optional());
        pUiBean.setVhsyusyukouryokuhasseiymd(null);
        pUiBean.setVhsyudai1hknkknsbsyokuseiumu(C_UmuKbn.NONE);
        pUiBean.setVhsyusgsbhsyumu(C_UmuKbn.NONE);
        pUiBean.setVhsyuhknKknKbn(C_HknKknKbn.BLNK);
        pUiBean.setVhsyusyunkhknumu(C_UmuKbn.NONE);
        pUiBean.setVhsyusyugannyukyhumu(C_UmuKbn.NONE);
        pUiBean.setVhsyusyukhnkyhkgbairitukbn(C_KhnkyhkgbairituKbn.BLNK);
        pUiBean.setVhsyusyusndkyhkinshrskgnumu(C_UmuKbn.NONE);
        pUiBean.setVhsyusyunextkosumu(C_UmuKbn.NONE);
        pUiBean.setVhsyusyutsnshrgndhjumu(C_UmuKbn.NONE);
        pUiBean.setVhsyudispsyutsnshrgndgk(BizCurrency.optional());
        pUiBean.setVhsyusyuhghkumu(C_UmuKbn.NONE);
        pUiBean.setVhsyusyohinhanteikbn(SyouhinUtil.SYOHIN_BLNK);
        pUiBean.setVhsyumvatekiumu(C_UmuKbn.NONE);
        pUiBean.setVhsyusbhkuktumu(C_UmuKbn.NONE);
        pUiBean.setVhsyusbkyuuhukinuktumu(C_UmuKbn.NONE);
        pUiBean.setVhsyuyendthnkymd(null);
        pUiBean.setVhsyutmttknitenymd(null);
        pUiBean.setVhsyusyunkshrstartymd(null);
        pUiBean.setVhsyuteiritutmttkngk(BizCurrency.optional());
        pUiBean.setVhsyusisuurendoutmttkngk(BizCurrency.optional());
        pUiBean.setVhsyugenzaitmttkngk(BizCurrency.optional());
        pUiBean.setVhsyusisuurendourate(BizNumber.ZERO);
        pUiBean.setVhsyuteiritutmttrate(BizNumber.ZERO);
        pUiBean.setVhsyusisuunm(BLANK);
        pUiBean.setVhsyusetteibairitu(BizNumber.ZERO);
        pUiBean.setVhsyuyoteiriritu(BizNumber.ZERO);
        pUiBean.setVhsyutumitateriritu(BizNumber.ZERO);
        pUiBean.setVhsyukyktumitateriritu(BizNumber.ZERO);
        pUiBean.setVhsyu10nentumitateriritu(BizNumber.ZERO);
        pUiBean.setVhsyukyksjkkktyouseiriritu(BizNumber.ZERO);
        pUiBean.setVhsyuskisjkkktyouseiriritu(BizNumber.ZERO);

        pUiBean.setVhsyudisptksyouhnnm(BLANK);
        pUiBean.setVhsyunkshrtkyknksyukbn(C_Nstknsyu.BLNK);
        pUiBean.setVhsyunkshrtkyknksyukkn(null);

        pUiBean.setVhsyudisptksyouhncd1(BLANK);
        pUiBean.setVhsyudisptksyouhnnm1(BLANK);
        pUiBean.setVhsyudisptkktuukasyu1(C_Tuukasyu.BLNK);
        pUiBean.setVhsyudisptokyakukatakbn1(C_KataKbn.BLNK);
        pUiBean.setVhsyudisptkkyhgdkatakbn1(C_KyhgndkataKbn.BLNK);
        pUiBean.setVhsyudisptkhhknnen1(null);
        pUiBean.setVhsyudisptkkykymd1(null);
        pUiBean.setVhsyudisptksknnkaisiymd1(null);
        pUiBean.setVhsyudisptkgaskkaisiymd1(null);
        pUiBean.setVhsyudisptkhkskkaisiymd1(null);
        pUiBean.setVhsyudisptkhkgskksiymd1(null);
        pUiBean.setVhsyudisptkhknkkn1(null);
        pUiBean.setVhsyudisptkhknkknsmnkbn1(C_HknkknsmnKbn.BLNK);
        pUiBean.setVhsyudisptkhrkkkn1(null);
        pUiBean.setVhsyudisptkhrkkknsmnkbn1(C_HrkkknsmnKbn.BLNK);
        pUiBean.setVhsyudisptkkihsyuruikbn1(C_KihonssyuruiKbn.BLNK);
        pUiBean.setVhsyudisptkkihons1(BizCurrency.optional());
        pUiBean.setVhsyudisptkp1(BizCurrency.optional());
        pUiBean.setVhsyudisptkkihonkyhgk1(BizCurrency.optional());
        pUiBean.setVhsyudisptknextkosgop1(BizCurrency.optional());
        pUiBean.setVhsyudisptksykyhkatakbn1(C_SyukyhkinkataKbn.BLNK);
        pUiBean.setVhsyudisptk6daildkbn1(C_6daiLdKbn.BLNK);
        pUiBean.setVhsyudisptkganyukyhntgk1(BizCurrency.optional());
        pUiBean.setVhsyudisptkshrskgstrymd1(null);
        pUiBean.setVhsyudisptkshrskgnedymd1(null);
        pUiBean.setVhsyudisptkshrskgngos1(BizCurrency.optional());
        pUiBean.setVhsyudisptknenkinsyukbn1(C_Nenkinsyu.BLNK);
        pUiBean.setVhsyudisptknenkinkkn1(null);
        pUiBean.setVhsyudisptktkjyskgnkkn1(C_Tkjyskgnkkn.BLNK);
        pUiBean.setVhsyudisptktkjkhkdsymd11(null);
        pUiBean.setVhsyudisptktkjkhkdeymd11(null);
        pUiBean.setVhsyudisptktkjyskgns11(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd21(null);
        pUiBean.setVhsyudisptktkjkhkdeymd21(null);
        pUiBean.setVhsyudisptktkjyskgns21(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd31(null);
        pUiBean.setVhsyudisptktkjkhkdeymd31(null);
        pUiBean.setVhsyudisptktkjyskgns31(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd41(null);
        pUiBean.setVhsyudisptktkjkhkdeymd41(null);
        pUiBean.setVhsyudisptktkjyskgns41(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd51(null);
        pUiBean.setVhsyudisptktkjkhkdeymd51(null);
        pUiBean.setVhsyudisptktkjyskgns51(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjyhyouten1(C_Tkjyhyouten.BLNK);
        pUiBean.setVhsyudisptktkjyp1(BizCurrency.optional());
        pUiBean.setVhsyudisptkhtnpbuicd11(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm11(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn11(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptkhtnpbuicd21(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm21(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn21(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptkhtnpbuicd31(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm31(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn31(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptkhtnpbuicd41(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm41(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn41(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptktkkdsghtpkbn1(C_TokkoudosghtnpKbn.BLNK);
        pUiBean.setVhsyudisptktutakngk1(BizCurrency.optional());
        pUiBean.setVhsyudisptkkrkhasseiymd1(null);
        pUiBean.setVhsyudisptknkhknumu1(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptkgannyukyhumu1(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptkkgbairitukbn1(C_KhnkyhkgbairituKbn.BLNK);
        pUiBean.setVhsyudisptksndkyhkinshrskgnumu1(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptknextkosumu1(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptkhghkumu1(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptktsnshrgndhjumu1(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptktsnshrgndgk1(BizCurrency.optional());

        pUiBean.setVhsyudisptksyouhncd2(BLANK);
        pUiBean.setVhsyudisptksyouhnnm2(BLANK);
        pUiBean.setVhsyudisptkktuukasyu2(C_Tuukasyu.BLNK);
        pUiBean.setVhsyudisptokyakukatakbn2(C_KataKbn.BLNK);
        pUiBean.setVhsyudisptkkyhgdkatakbn2(C_KyhgndkataKbn.BLNK);
        pUiBean.setVhsyudisptkhhknnen2(null);
        pUiBean.setVhsyudisptkkykymd2(null);
        pUiBean.setVhsyudisptksknnkaisiymd2(null);
        pUiBean.setVhsyudisptkgaskkaisiymd2(null);
        pUiBean.setVhsyudisptkhkskkaisiymd2(null);
        pUiBean.setVhsyudisptkhkgskksiymd2(null);
        pUiBean.setVhsyudisptkhknkkn2(null);
        pUiBean.setVhsyudisptkhknkknsmnkbn2(C_HknkknsmnKbn.BLNK);
        pUiBean.setVhsyudisptkhrkkkn2(null);
        pUiBean.setVhsyudisptkhrkkknsmnkbn2(C_HrkkknsmnKbn.BLNK);
        pUiBean.setVhsyudisptkkihsyuruikbn2(C_KihonssyuruiKbn.BLNK);
        pUiBean.setVhsyudisptkkihons2(BizCurrency.optional());
        pUiBean.setVhsyudisptkp2(BizCurrency.optional());
        pUiBean.setVhsyudisptkkihonkyhgk2(BizCurrency.optional());
        pUiBean.setVhsyudisptknextkosgop2(BizCurrency.optional());
        pUiBean.setVhsyudisptksykyhkatakbn2(C_SyukyhkinkataKbn.BLNK);
        pUiBean.setVhsyudisptk6daildkbn2(C_6daiLdKbn.BLNK);
        pUiBean.setVhsyudisptkganyukyhntgk2(BizCurrency.optional());
        pUiBean.setVhsyudisptkshrskgstrymd2(null);
        pUiBean.setVhsyudisptkshrskgnedymd2(null);
        pUiBean.setVhsyudisptkshrskgngos2(BizCurrency.optional());
        pUiBean.setVhsyudisptknenkinsyukbn2(C_Nenkinsyu.BLNK);
        pUiBean.setVhsyudisptknenkinkkn2(null);
        pUiBean.setVhsyudisptktkjyskgnkkn2(C_Tkjyskgnkkn.BLNK);
        pUiBean.setVhsyudisptktkjkhkdsymd12(null);
        pUiBean.setVhsyudisptktkjkhkdeymd12(null);
        pUiBean.setVhsyudisptktkjyskgns12(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd22(null);
        pUiBean.setVhsyudisptktkjkhkdeymd22(null);
        pUiBean.setVhsyudisptktkjyskgns22(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd32(null);
        pUiBean.setVhsyudisptktkjkhkdeymd32(null);
        pUiBean.setVhsyudisptktkjyskgns32(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd42(null);
        pUiBean.setVhsyudisptktkjkhkdeymd42(null);
        pUiBean.setVhsyudisptktkjyskgns42(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd52(null);
        pUiBean.setVhsyudisptktkjkhkdeymd52(null);
        pUiBean.setVhsyudisptktkjyskgns52(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjyhyouten2(C_Tkjyhyouten.BLNK);
        pUiBean.setVhsyudisptktkjyp2(BizCurrency.optional());
        pUiBean.setVhsyudisptkhtnpbuicd12(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm12(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn12(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptkhtnpbuicd22(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm22(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn22(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptkhtnpbuicd32(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm32(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn32(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptkhtnpbuicd42(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm42(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn42(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptktkkdsghtpkbn2(C_TokkoudosghtnpKbn.BLNK);
        pUiBean.setVhsyudisptktutakngk2(BizCurrency.optional());
        pUiBean.setVhsyudisptkkrkhasseiymd2(null);
        pUiBean.setVhsyudisptknkhknumu2(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptkgannyukyhumu2(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptkkgbairitukbn2(C_KhnkyhkgbairituKbn.BLNK);
        pUiBean.setVhsyudisptksndkyhkinshrskgnumu2(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptknextkosumu2(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptkhghkumu2(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptktsnshrgndhjumu2(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptktsnshrgndgk2(BizCurrency.optional());

        pUiBean.setVhsyudisptksyouhncd3(BLANK);
        pUiBean.setVhsyudisptksyouhnnm3(BLANK);
        pUiBean.setVhsyudisptkktuukasyu3(C_Tuukasyu.BLNK);
        pUiBean.setVhsyudisptokyakukatakbn3(C_KataKbn.BLNK);
        pUiBean.setVhsyudisptkkyhgdkatakbn3(C_KyhgndkataKbn.BLNK);
        pUiBean.setVhsyudisptkhhknnen3(null);
        pUiBean.setVhsyudisptkkykymd3(null);
        pUiBean.setVhsyudisptksknnkaisiymd3(null);
        pUiBean.setVhsyudisptkgaskkaisiymd3(null);
        pUiBean.setVhsyudisptkhkskkaisiymd3(null);
        pUiBean.setVhsyudisptkhkgskksiymd3(null);
        pUiBean.setVhsyudisptkhknkkn3(null);
        pUiBean.setVhsyudisptkhknkknsmnkbn3(C_HknkknsmnKbn.BLNK);
        pUiBean.setVhsyudisptkhrkkkn3(null);
        pUiBean.setVhsyudisptkhrkkknsmnkbn3(C_HrkkknsmnKbn.BLNK);
        pUiBean.setVhsyudisptkkihsyuruikbn3(C_KihonssyuruiKbn.BLNK);
        pUiBean.setVhsyudisptkkihons3(BizCurrency.optional());
        pUiBean.setVhsyudisptkp3(BizCurrency.optional());
        pUiBean.setVhsyudisptkkihonkyhgk3(BizCurrency.optional());
        pUiBean.setVhsyudisptknextkosgop3(BizCurrency.optional());
        pUiBean.setVhsyudisptksykyhkatakbn3(C_SyukyhkinkataKbn.BLNK);
        pUiBean.setVhsyudisptk6daildkbn3(C_6daiLdKbn.BLNK);
        pUiBean.setVhsyudisptkganyukyhntgk3(BizCurrency.optional());
        pUiBean.setVhsyudisptkshrskgstrymd3(null);
        pUiBean.setVhsyudisptkshrskgnedymd3(null);
        pUiBean.setVhsyudisptkshrskgngos3(BizCurrency.optional());
        pUiBean.setVhsyudisptknenkinsyukbn3(C_Nenkinsyu.BLNK);
        pUiBean.setVhsyudisptknenkinkkn3(null);
        pUiBean.setVhsyudisptktkjyskgnkkn3(C_Tkjyskgnkkn.BLNK);
        pUiBean.setVhsyudisptktkjkhkdsymd13(null);
        pUiBean.setVhsyudisptktkjkhkdeymd13(null);
        pUiBean.setVhsyudisptktkjyskgns13(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd23(null);
        pUiBean.setVhsyudisptktkjkhkdeymd23(null);
        pUiBean.setVhsyudisptktkjyskgns23(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd33(null);
        pUiBean.setVhsyudisptktkjkhkdeymd33(null);
        pUiBean.setVhsyudisptktkjyskgns33(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd43(null);
        pUiBean.setVhsyudisptktkjkhkdeymd43(null);
        pUiBean.setVhsyudisptktkjyskgns43(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd53(null);
        pUiBean.setVhsyudisptktkjkhkdeymd53(null);
        pUiBean.setVhsyudisptktkjyskgns53(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjyhyouten3(C_Tkjyhyouten.BLNK);
        pUiBean.setVhsyudisptktkjyp3(BizCurrency.optional());
        pUiBean.setVhsyudisptkhtnpbuicd13(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm13(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn13(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptkhtnpbuicd23(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm23(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn23(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptkhtnpbuicd33(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm33(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn33(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptkhtnpbuicd43(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm43(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn43(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptktkkdsghtpkbn3(C_TokkoudosghtnpKbn.BLNK);
        pUiBean.setVhsyudisptktutakngk3(BizCurrency.optional());
        pUiBean.setVhsyudisptkkrkhasseiymd3(null);
        pUiBean.setVhsyudisptknkhknumu3(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptkgannyukyhumu3(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptkkgbairitukbn3(C_KhnkyhkgbairituKbn.BLNK);
        pUiBean.setVhsyudisptksndkyhkinshrskgnumu3(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptknextkosumu3(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptkhghkumu3(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptktsnshrgndhjumu3(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptktsnshrgndgk3(BizCurrency.optional());

        pUiBean.setVhsyudisptksyouhncd4(BLANK);
        pUiBean.setVhsyudisptksyouhnnm4(BLANK);
        pUiBean.setVhsyudisptkktuukasyu4(C_Tuukasyu.BLNK);
        pUiBean.setVhsyudisptokyakukatakbn4(C_KataKbn.BLNK);
        pUiBean.setVhsyudisptkkyhgdkatakbn4(C_KyhgndkataKbn.BLNK);
        pUiBean.setVhsyudisptkhhknnen4(null);
        pUiBean.setVhsyudisptkkykymd4(null);
        pUiBean.setVhsyudisptksknnkaisiymd4(null);
        pUiBean.setVhsyudisptkgaskkaisiymd4(null);
        pUiBean.setVhsyudisptkhkskkaisiymd4(null);
        pUiBean.setVhsyudisptkhkgskksiymd4(null);
        pUiBean.setVhsyudisptkhknkkn4(null);
        pUiBean.setVhsyudisptkhknkknsmnkbn4(C_HknkknsmnKbn.BLNK);
        pUiBean.setVhsyudisptkhrkkkn4(null);
        pUiBean.setVhsyudisptkhrkkknsmnkbn4(C_HrkkknsmnKbn.BLNK);
        pUiBean.setVhsyudisptkkihsyuruikbn4(C_KihonssyuruiKbn.BLNK);
        pUiBean.setVhsyudisptkkihons4(BizCurrency.optional());
        pUiBean.setVhsyudisptkp4(BizCurrency.optional());
        pUiBean.setVhsyudisptkkihonkyhgk4(BizCurrency.optional());
        pUiBean.setVhsyudisptknextkosgop4(BizCurrency.optional());
        pUiBean.setVhsyudisptksykyhkatakbn4(C_SyukyhkinkataKbn.BLNK);
        pUiBean.setVhsyudisptk6daildkbn4(C_6daiLdKbn.BLNK);
        pUiBean.setVhsyudisptkganyukyhntgk4(BizCurrency.optional());
        pUiBean.setVhsyudisptkshrskgstrymd4(null);
        pUiBean.setVhsyudisptkshrskgnedymd4(null);
        pUiBean.setVhsyudisptkshrskgngos4(BizCurrency.optional());
        pUiBean.setVhsyudisptknenkinsyukbn4(C_Nenkinsyu.BLNK);
        pUiBean.setVhsyudisptknenkinkkn4(null);
        pUiBean.setVhsyudisptktkjyskgnkkn4(C_Tkjyskgnkkn.BLNK);
        pUiBean.setVhsyudisptktkjkhkdsymd14(null);
        pUiBean.setVhsyudisptktkjkhkdeymd14(null);
        pUiBean.setVhsyudisptktkjyskgns14(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd24(null);
        pUiBean.setVhsyudisptktkjkhkdeymd24(null);
        pUiBean.setVhsyudisptktkjyskgns24(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd34(null);
        pUiBean.setVhsyudisptktkjkhkdeymd34(null);
        pUiBean.setVhsyudisptktkjyskgns34(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd44(null);
        pUiBean.setVhsyudisptktkjkhkdeymd44(null);
        pUiBean.setVhsyudisptktkjyskgns44(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd54(null);
        pUiBean.setVhsyudisptktkjkhkdeymd54(null);
        pUiBean.setVhsyudisptktkjyskgns54(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjyhyouten4(C_Tkjyhyouten.BLNK);
        pUiBean.setVhsyudisptktkjyp4(BizCurrency.optional());
        pUiBean.setVhsyudisptkhtnpbuicd14(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm14(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn14(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptkhtnpbuicd24(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm24(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn24(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptkhtnpbuicd34(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm34(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn34(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptkhtnpbuicd44(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm44(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn44(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptktkkdsghtpkbn4(C_TokkoudosghtnpKbn.BLNK);
        pUiBean.setVhsyudisptktutakngk4(BizCurrency.optional());
        pUiBean.setVhsyudisptkkrkhasseiymd4(null);
        pUiBean.setVhsyudisptknkhknumu4(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptkgannyukyhumu4(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptkkgbairitukbn4(C_KhnkyhkgbairituKbn.BLNK);
        pUiBean.setVhsyudisptksndkyhkinshrskgnumu4(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptknextkosumu4(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptkhghkumu4(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptktsnshrgndhjumu4(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptktsnshrgndgk4(BizCurrency.optional());

        pUiBean.setVhsyudisptksyouhncd5(BLANK);
        pUiBean.setVhsyudisptksyouhnnm5(BLANK);
        pUiBean.setVhsyudisptkktuukasyu5(C_Tuukasyu.BLNK);
        pUiBean.setVhsyudisptokyakukatakbn5(C_KataKbn.BLNK);
        pUiBean.setVhsyudisptkkyhgdkatakbn5(C_KyhgndkataKbn.BLNK);
        pUiBean.setVhsyudisptkhhknnen5(null);
        pUiBean.setVhsyudisptkkykymd5(null);
        pUiBean.setVhsyudisptksknnkaisiymd5(null);
        pUiBean.setVhsyudisptkgaskkaisiymd5(null);
        pUiBean.setVhsyudisptkhkskkaisiymd5(null);
        pUiBean.setVhsyudisptkhkgskksiymd5(null);
        pUiBean.setVhsyudisptkhknkkn5(null);
        pUiBean.setVhsyudisptkhknkknsmnkbn5(C_HknkknsmnKbn.BLNK);
        pUiBean.setVhsyudisptkhrkkkn5(null);
        pUiBean.setVhsyudisptkhrkkknsmnkbn5(C_HrkkknsmnKbn.BLNK);
        pUiBean.setVhsyudisptkkihsyuruikbn5(C_KihonssyuruiKbn.BLNK);
        pUiBean.setVhsyudisptkkihons5(BizCurrency.optional());
        pUiBean.setVhsyudisptkp5(BizCurrency.optional());
        pUiBean.setVhsyudisptkkihonkyhgk5(BizCurrency.optional());
        pUiBean.setVhsyudisptknextkosgop5(BizCurrency.optional());
        pUiBean.setVhsyudisptksykyhkatakbn5(C_SyukyhkinkataKbn.BLNK);
        pUiBean.setVhsyudisptk6daildkbn5(C_6daiLdKbn.BLNK);
        pUiBean.setVhsyudisptkganyukyhntgk5(BizCurrency.optional());
        pUiBean.setVhsyudisptkshrskgstrymd5(null);
        pUiBean.setVhsyudisptkshrskgnedymd5(null);
        pUiBean.setVhsyudisptkshrskgngos5(BizCurrency.optional());
        pUiBean.setVhsyudisptknenkinsyukbn5(C_Nenkinsyu.BLNK);
        pUiBean.setVhsyudisptknenkinkkn5(null);
        pUiBean.setVhsyudisptktkjyskgnkkn5(C_Tkjyskgnkkn.BLNK);
        pUiBean.setVhsyudisptktkjkhkdsymd15(null);
        pUiBean.setVhsyudisptktkjkhkdeymd15(null);
        pUiBean.setVhsyudisptktkjyskgns15(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd25(null);
        pUiBean.setVhsyudisptktkjkhkdeymd25(null);
        pUiBean.setVhsyudisptktkjyskgns25(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd35(null);
        pUiBean.setVhsyudisptktkjkhkdeymd35(null);
        pUiBean.setVhsyudisptktkjyskgns35(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd45(null);
        pUiBean.setVhsyudisptktkjkhkdeymd45(null);
        pUiBean.setVhsyudisptktkjyskgns45(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd55(null);
        pUiBean.setVhsyudisptktkjkhkdeymd55(null);
        pUiBean.setVhsyudisptktkjyskgns55(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjyhyouten5(C_Tkjyhyouten.BLNK);
        pUiBean.setVhsyudisptktkjyp5(BizCurrency.optional());
        pUiBean.setVhsyudisptkhtnpbuicd15(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm15(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn15(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptkhtnpbuicd25(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm25(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn25(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptkhtnpbuicd35(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm35(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn35(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptkhtnpbuicd45(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm45(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn45(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptktkkdsghtpkbn5(C_TokkoudosghtnpKbn.BLNK);
        pUiBean.setVhsyudisptktutakngk5(BizCurrency.optional());
        pUiBean.setVhsyudisptkkrkhasseiymd5(null);
        pUiBean.setVhsyudisptknkhknumu5(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptkgannyukyhumu5(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptkkgbairitukbn5(C_KhnkyhkgbairituKbn.BLNK);
        pUiBean.setVhsyudisptksndkyhkinshrskgnumu5(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptknextkosumu5(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptkhghkumu5(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptktsnshrgndhjumu5(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptktsnshrgndgk5(BizCurrency.optional());

        pUiBean.setVhsyudisptksyouhncd6(BLANK);
        pUiBean.setVhsyudisptksyouhnnm6(BLANK);
        pUiBean.setVhsyudisptkktuukasyu6(C_Tuukasyu.BLNK);
        pUiBean.setVhsyudisptokyakukatakbn6(C_KataKbn.BLNK);
        pUiBean.setVhsyudisptkkyhgdkatakbn6(C_KyhgndkataKbn.BLNK);
        pUiBean.setVhsyudisptkhhknnen6(null);
        pUiBean.setVhsyudisptkkykymd6(null);
        pUiBean.setVhsyudisptksknnkaisiymd6(null);
        pUiBean.setVhsyudisptkgaskkaisiymd6(null);
        pUiBean.setVhsyudisptkhkskkaisiymd6(null);
        pUiBean.setVhsyudisptkhkgskksiymd6(null);
        pUiBean.setVhsyudisptkhknkkn6(null);
        pUiBean.setVhsyudisptkhknkknsmnkbn6(C_HknkknsmnKbn.BLNK);
        pUiBean.setVhsyudisptkhrkkkn6(null);
        pUiBean.setVhsyudisptkhrkkknsmnkbn6(C_HrkkknsmnKbn.BLNK);
        pUiBean.setVhsyudisptkkihsyuruikbn6(C_KihonssyuruiKbn.BLNK);
        pUiBean.setVhsyudisptkkihons6(BizCurrency.optional());
        pUiBean.setVhsyudisptkp6(BizCurrency.optional());
        pUiBean.setVhsyudisptkkihonkyhgk6(BizCurrency.optional());
        pUiBean.setVhsyudisptknextkosgop6(BizCurrency.optional());
        pUiBean.setVhsyudisptksykyhkatakbn6(C_SyukyhkinkataKbn.BLNK);
        pUiBean.setVhsyudisptk6daildkbn6(C_6daiLdKbn.BLNK);
        pUiBean.setVhsyudisptkganyukyhntgk6(BizCurrency.optional());
        pUiBean.setVhsyudisptkshrskgstrymd6(null);
        pUiBean.setVhsyudisptkshrskgnedymd6(null);
        pUiBean.setVhsyudisptkshrskgngos6(BizCurrency.optional());
        pUiBean.setVhsyudisptknenkinsyukbn6(C_Nenkinsyu.BLNK);
        pUiBean.setVhsyudisptknenkinkkn6(null);
        pUiBean.setVhsyudisptktkjyskgnkkn6(C_Tkjyskgnkkn.BLNK);
        pUiBean.setVhsyudisptktkjkhkdsymd16(null);
        pUiBean.setVhsyudisptktkjkhkdeymd16(null);
        pUiBean.setVhsyudisptktkjyskgns16(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd26(null);
        pUiBean.setVhsyudisptktkjkhkdeymd26(null);
        pUiBean.setVhsyudisptktkjyskgns26(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd36(null);
        pUiBean.setVhsyudisptktkjkhkdeymd36(null);
        pUiBean.setVhsyudisptktkjyskgns36(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd46(null);
        pUiBean.setVhsyudisptktkjkhkdeymd46(null);
        pUiBean.setVhsyudisptktkjyskgns46(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd56(null);
        pUiBean.setVhsyudisptktkjkhkdeymd56(null);
        pUiBean.setVhsyudisptktkjyskgns56(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjyhyouten6(C_Tkjyhyouten.BLNK);
        pUiBean.setVhsyudisptktkjyp6(BizCurrency.optional());
        pUiBean.setVhsyudisptkhtnpbuicd16(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm16(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn16(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptkhtnpbuicd26(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm26(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn26(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptkhtnpbuicd36(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm36(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn36(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptkhtnpbuicd46(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm46(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn46(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptktkkdsghtpkbn6(C_TokkoudosghtnpKbn.BLNK);
        pUiBean.setVhsyudisptktutakngk6(BizCurrency.optional());
        pUiBean.setVhsyudisptkkrkhasseiymd6(null);
        pUiBean.setVhsyudisptknkhknumu6(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptkgannyukyhumu6(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptkkgbairitukbn6(C_KhnkyhkgbairituKbn.BLNK);
        pUiBean.setVhsyudisptksndkyhkinshrskgnumu6(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptknextkosumu6(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptkhghkumu6(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptktsnshrgndhjumu6(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptktsnshrgndgk6(BizCurrency.optional());

        pUiBean.setVhsyudisptksyouhncd7(BLANK);
        pUiBean.setVhsyudisptksyouhnnm7(BLANK);
        pUiBean.setVhsyudisptkktuukasyu7(C_Tuukasyu.BLNK);
        pUiBean.setVhsyudisptokyakukatakbn7(C_KataKbn.BLNK);
        pUiBean.setVhsyudisptkkyhgdkatakbn7(C_KyhgndkataKbn.BLNK);
        pUiBean.setVhsyudisptkhhknnen7(null);
        pUiBean.setVhsyudisptkkykymd7(null);
        pUiBean.setVhsyudisptksknnkaisiymd7(null);
        pUiBean.setVhsyudisptkgaskkaisiymd7(null);
        pUiBean.setVhsyudisptkhkskkaisiymd7(null);
        pUiBean.setVhsyudisptkhkgskksiymd7(null);
        pUiBean.setVhsyudisptkhknkkn7(null);
        pUiBean.setVhsyudisptkhknkknsmnkbn7(C_HknkknsmnKbn.BLNK);
        pUiBean.setVhsyudisptkhrkkkn7(null);
        pUiBean.setVhsyudisptkhrkkknsmnkbn7(C_HrkkknsmnKbn.BLNK);
        pUiBean.setVhsyudisptkkihsyuruikbn7(C_KihonssyuruiKbn.BLNK);
        pUiBean.setVhsyudisptkkihons7(BizCurrency.optional());
        pUiBean.setVhsyudisptkp7(BizCurrency.optional());
        pUiBean.setVhsyudisptkkihonkyhgk7(BizCurrency.optional());
        pUiBean.setVhsyudisptknextkosgop7(BizCurrency.optional());
        pUiBean.setVhsyudisptksykyhkatakbn7(C_SyukyhkinkataKbn.BLNK);
        pUiBean.setVhsyudisptk6daildkbn7(C_6daiLdKbn.BLNK);
        pUiBean.setVhsyudisptkganyukyhntgk7(BizCurrency.optional());
        pUiBean.setVhsyudisptkshrskgstrymd7(null);
        pUiBean.setVhsyudisptkshrskgnedymd7(null);
        pUiBean.setVhsyudisptkshrskgngos7(BizCurrency.optional());
        pUiBean.setVhsyudisptknenkinsyukbn7(C_Nenkinsyu.BLNK);
        pUiBean.setVhsyudisptknenkinkkn7(null);
        pUiBean.setVhsyudisptktkjyskgnkkn7(C_Tkjyskgnkkn.BLNK);
        pUiBean.setVhsyudisptktkjkhkdsymd17(null);
        pUiBean.setVhsyudisptktkjkhkdeymd17(null);
        pUiBean.setVhsyudisptktkjyskgns17(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd27(null);
        pUiBean.setVhsyudisptktkjkhkdeymd27(null);
        pUiBean.setVhsyudisptktkjyskgns27(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd37(null);
        pUiBean.setVhsyudisptktkjkhkdeymd37(null);
        pUiBean.setVhsyudisptktkjyskgns37(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd47(null);
        pUiBean.setVhsyudisptktkjkhkdeymd47(null);
        pUiBean.setVhsyudisptktkjyskgns47(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd57(null);
        pUiBean.setVhsyudisptktkjkhkdeymd57(null);
        pUiBean.setVhsyudisptktkjyskgns57(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjyhyouten7(C_Tkjyhyouten.BLNK);
        pUiBean.setVhsyudisptktkjyp7(BizCurrency.optional());
        pUiBean.setVhsyudisptkhtnpbuicd17(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm17(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn17(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptkhtnpbuicd27(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm27(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn27(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptkhtnpbuicd37(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm37(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn37(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptkhtnpbuicd47(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm47(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn47(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptktkkdsghtpkbn7(C_TokkoudosghtnpKbn.BLNK);
        pUiBean.setVhsyudisptktutakngk7(BizCurrency.optional());
        pUiBean.setVhsyudisptkkrkhasseiymd7(null);
        pUiBean.setVhsyudisptknkhknumu7(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptkgannyukyhumu7(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptkkgbairitukbn7(C_KhnkyhkgbairituKbn.BLNK);
        pUiBean.setVhsyudisptksndkyhkinshrskgnumu7(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptknextkosumu7(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptkhghkumu7(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptktsnshrgndhjumu7(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptktsnshrgndgk7(BizCurrency.optional());

        pUiBean.setVhsyudisptksyouhncd8(BLANK);
        pUiBean.setVhsyudisptksyouhnnm8(BLANK);
        pUiBean.setVhsyudisptkktuukasyu8(C_Tuukasyu.BLNK);
        pUiBean.setVhsyudisptokyakukatakbn8(C_KataKbn.BLNK);
        pUiBean.setVhsyudisptkkyhgdkatakbn8(C_KyhgndkataKbn.BLNK);
        pUiBean.setVhsyudisptkhhknnen8(null);
        pUiBean.setVhsyudisptkkykymd8(null);
        pUiBean.setVhsyudisptksknnkaisiymd8(null);
        pUiBean.setVhsyudisptkgaskkaisiymd8(null);
        pUiBean.setVhsyudisptkhkskkaisiymd8(null);
        pUiBean.setVhsyudisptkhkgskksiymd8(null);
        pUiBean.setVhsyudisptkhknkkn8(null);
        pUiBean.setVhsyudisptkhknkknsmnkbn8(C_HknkknsmnKbn.BLNK);
        pUiBean.setVhsyudisptkhrkkkn8(null);
        pUiBean.setVhsyudisptkhrkkknsmnkbn8(C_HrkkknsmnKbn.BLNK);
        pUiBean.setVhsyudisptkkihsyuruikbn8(C_KihonssyuruiKbn.BLNK);
        pUiBean.setVhsyudisptkkihons8(BizCurrency.optional());
        pUiBean.setVhsyudisptkp8(BizCurrency.optional());
        pUiBean.setVhsyudisptkkihonkyhgk8(BizCurrency.optional());
        pUiBean.setVhsyudisptknextkosgop8(BizCurrency.optional());
        pUiBean.setVhsyudisptksykyhkatakbn8(C_SyukyhkinkataKbn.BLNK);
        pUiBean.setVhsyudisptk6daildkbn8(C_6daiLdKbn.BLNK);
        pUiBean.setVhsyudisptkganyukyhntgk8(BizCurrency.optional());
        pUiBean.setVhsyudisptkshrskgstrymd8(null);
        pUiBean.setVhsyudisptkshrskgnedymd8(null);
        pUiBean.setVhsyudisptkshrskgngos8(BizCurrency.optional());
        pUiBean.setVhsyudisptknenkinsyukbn8(C_Nenkinsyu.BLNK);
        pUiBean.setVhsyudisptknenkinkkn8(null);
        pUiBean.setVhsyudisptktkjyskgnkkn8(C_Tkjyskgnkkn.BLNK);
        pUiBean.setVhsyudisptktkjkhkdsymd18(null);
        pUiBean.setVhsyudisptktkjkhkdeymd18(null);
        pUiBean.setVhsyudisptktkjyskgns18(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd28(null);
        pUiBean.setVhsyudisptktkjkhkdeymd28(null);
        pUiBean.setVhsyudisptktkjyskgns28(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd38(null);
        pUiBean.setVhsyudisptktkjkhkdeymd38(null);
        pUiBean.setVhsyudisptktkjyskgns38(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd48(null);
        pUiBean.setVhsyudisptktkjkhkdeymd48(null);
        pUiBean.setVhsyudisptktkjyskgns48(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd58(null);
        pUiBean.setVhsyudisptktkjkhkdeymd58(null);
        pUiBean.setVhsyudisptktkjyskgns58(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjyhyouten8(C_Tkjyhyouten.BLNK);
        pUiBean.setVhsyudisptktkjyp8(BizCurrency.optional());
        pUiBean.setVhsyudisptkhtnpbuicd18(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm18(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn18(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptkhtnpbuicd28(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm28(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn28(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptkhtnpbuicd38(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm38(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn38(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptkhtnpbuicd48(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm48(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn48(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptktkkdsghtpkbn8(C_TokkoudosghtnpKbn.BLNK);
        pUiBean.setVhsyudisptktutakngk8(BizCurrency.optional());
        pUiBean.setVhsyudisptkkrkhasseiymd8(null);
        pUiBean.setVhsyudisptknkhknumu8(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptkgannyukyhumu8(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptkkgbairitukbn8(C_KhnkyhkgbairituKbn.BLNK);
        pUiBean.setVhsyudisptksndkyhkinshrskgnumu8(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptknextkosumu8(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptkhghkumu8(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptktsnshrgndhjumu8(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptktsnshrgndgk8(BizCurrency.optional());

        pUiBean.setVhsyudisptksyouhncd9(BLANK);
        pUiBean.setVhsyudisptksyouhnnm9(BLANK);
        pUiBean.setVhsyudisptkktuukasyu9(C_Tuukasyu.BLNK);
        pUiBean.setVhsyudisptokyakukatakbn9(C_KataKbn.BLNK);
        pUiBean.setVhsyudisptkkyhgdkatakbn9(C_KyhgndkataKbn.BLNK);
        pUiBean.setVhsyudisptkhhknnen9(null);
        pUiBean.setVhsyudisptkkykymd9(null);
        pUiBean.setVhsyudisptksknnkaisiymd9(null);
        pUiBean.setVhsyudisptkgaskkaisiymd9(null);
        pUiBean.setVhsyudisptkhkskkaisiymd9(null);
        pUiBean.setVhsyudisptkhkgskksiymd9(null);
        pUiBean.setVhsyudisptkhknkkn9(null);
        pUiBean.setVhsyudisptkhknkknsmnkbn9(C_HknkknsmnKbn.BLNK);
        pUiBean.setVhsyudisptkhrkkkn9(null);
        pUiBean.setVhsyudisptkhrkkknsmnkbn9(C_HrkkknsmnKbn.BLNK);
        pUiBean.setVhsyudisptkkihsyuruikbn9(C_KihonssyuruiKbn.BLNK);
        pUiBean.setVhsyudisptkkihons9(BizCurrency.optional());
        pUiBean.setVhsyudisptkp9(BizCurrency.optional());
        pUiBean.setVhsyudisptkkihonkyhgk9(BizCurrency.optional());
        pUiBean.setVhsyudisptknextkosgop9(BizCurrency.optional());
        pUiBean.setVhsyudisptksykyhkatakbn9(C_SyukyhkinkataKbn.BLNK);
        pUiBean.setVhsyudisptk6daildkbn9(C_6daiLdKbn.BLNK);
        pUiBean.setVhsyudisptkganyukyhntgk9(BizCurrency.optional());
        pUiBean.setVhsyudisptkshrskgstrymd9(null);
        pUiBean.setVhsyudisptkshrskgnedymd9(null);
        pUiBean.setVhsyudisptkshrskgngos9(BizCurrency.optional());
        pUiBean.setVhsyudisptknenkinsyukbn9(C_Nenkinsyu.BLNK);
        pUiBean.setVhsyudisptknenkinkkn9(null);
        pUiBean.setVhsyudisptktkjyskgnkkn9(C_Tkjyskgnkkn.BLNK);
        pUiBean.setVhsyudisptktkjkhkdsymd19(null);
        pUiBean.setVhsyudisptktkjkhkdeymd19(null);
        pUiBean.setVhsyudisptktkjyskgns19(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd29(null);
        pUiBean.setVhsyudisptktkjkhkdeymd29(null);
        pUiBean.setVhsyudisptktkjyskgns29(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd39(null);
        pUiBean.setVhsyudisptktkjkhkdeymd39(null);
        pUiBean.setVhsyudisptktkjyskgns39(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd49(null);
        pUiBean.setVhsyudisptktkjkhkdeymd49(null);
        pUiBean.setVhsyudisptktkjyskgns49(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd59(null);
        pUiBean.setVhsyudisptktkjkhkdeymd59(null);
        pUiBean.setVhsyudisptktkjyskgns59(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjyhyouten9(C_Tkjyhyouten.BLNK);
        pUiBean.setVhsyudisptktkjyp9(BizCurrency.optional());
        pUiBean.setVhsyudisptkhtnpbuicd19(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm19(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn19(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptkhtnpbuicd29(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm29(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn29(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptkhtnpbuicd39(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm39(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn39(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptkhtnpbuicd49(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm49(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn49(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptktkkdsghtpkbn9(C_TokkoudosghtnpKbn.BLNK);
        pUiBean.setVhsyudisptktutakngk9(BizCurrency.optional());
        pUiBean.setVhsyudisptkkrkhasseiymd9(null);
        pUiBean.setVhsyudisptknkhknumu9(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptkgannyukyhumu9(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptkkgbairitukbn9(C_KhnkyhkgbairituKbn.BLNK);
        pUiBean.setVhsyudisptksndkyhkinshrskgnumu9(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptknextkosumu9(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptkhghkumu9(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptktsnshrgndhjumu9(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptktsnshrgndgk9(BizCurrency.optional());

        pUiBean.setVhsyudisptksyouhncd10(BLANK);
        pUiBean.setVhsyudisptksyouhnnm10(BLANK);
        pUiBean.setVhsyudisptkktuukasyu10(C_Tuukasyu.BLNK);
        pUiBean.setVhsyudisptokyakukatakbn10(C_KataKbn.BLNK);
        pUiBean.setVhsyudisptkkyhgdkatakbn10(C_KyhgndkataKbn.BLNK);
        pUiBean.setVhsyudisptkhhknnen10(null);
        pUiBean.setVhsyudisptkkykymd10(null);
        pUiBean.setVhsyudisptksknnkaisiymd10(null);
        pUiBean.setVhsyudisptkgaskkaisiymd10(null);
        pUiBean.setVhsyudisptkhkskkaisiymd10(null);
        pUiBean.setVhsyudisptkhkgskksiymd10(null);
        pUiBean.setVhsyudisptkhknkkn10(null);
        pUiBean.setVhsyudisptkhknkknsmnkbn10(C_HknkknsmnKbn.BLNK);
        pUiBean.setVhsyudisptkhrkkkn10(null);
        pUiBean.setVhsyudisptkhrkkknsmnkbn10(C_HrkkknsmnKbn.BLNK);
        pUiBean.setVhsyudisptkkihsyuruikbn10(C_KihonssyuruiKbn.BLNK);
        pUiBean.setVhsyudisptkkihons10(BizCurrency.optional());
        pUiBean.setVhsyudisptkp10(BizCurrency.optional());
        pUiBean.setVhsyudisptkkihonkyhgk10(BizCurrency.optional());
        pUiBean.setVhsyudisptknextkosgop10(BizCurrency.optional());
        pUiBean.setVhsyudisptksykyhkatakbn10(C_SyukyhkinkataKbn.BLNK);
        pUiBean.setVhsyudisptk6daildkbn10(C_6daiLdKbn.BLNK);
        pUiBean.setVhsyudisptkganyukyhntgk10(BizCurrency.optional());
        pUiBean.setVhsyudisptkshrskgstrymd10(null);
        pUiBean.setVhsyudisptkshrskgnedymd10(null);
        pUiBean.setVhsyudisptkshrskgngos10(BizCurrency.optional());
        pUiBean.setVhsyudisptknenkinsyukbn10(C_Nenkinsyu.BLNK);
        pUiBean.setVhsyudisptknenkinkkn10(null);
        pUiBean.setVhsyudisptktkjyskgnkkn10(C_Tkjyskgnkkn.BLNK);
        pUiBean.setVhsyudisptktkjkhkdsymd110(null);
        pUiBean.setVhsyudisptktkjkhkdeymd110(null);
        pUiBean.setVhsyudisptktkjyskgns110(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd210(null);
        pUiBean.setVhsyudisptktkjkhkdeymd210(null);
        pUiBean.setVhsyudisptktkjyskgns210(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd310(null);
        pUiBean.setVhsyudisptktkjkhkdeymd310(null);
        pUiBean.setVhsyudisptktkjyskgns310(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd410(null);
        pUiBean.setVhsyudisptktkjkhkdeymd410(null);
        pUiBean.setVhsyudisptktkjyskgns410(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjkhkdsymd510(null);
        pUiBean.setVhsyudisptktkjkhkdeymd510(null);
        pUiBean.setVhsyudisptktkjyskgns510(BizCurrency.optional());
        pUiBean.setVhsyudisptktkjyhyouten10(C_Tkjyhyouten.BLNK);
        pUiBean.setVhsyudisptktkjyp10(BizCurrency.optional());
        pUiBean.setVhsyudisptkhtnpbuicd110(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm110(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn110(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptkhtnpbuicd210(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm210(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn210(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptkhtnpbuicd310(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm310(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn310(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptkhtnpbuicd410(BLANK);
        pUiBean.setVhsyudisptkhtnpbuinm410(BLANK);
        pUiBean.setVhsyudisptkhtnpkkn410(C_Htnpkkn.BLNK);
        pUiBean.setVhsyudisptktkkdsghtpkbn10(C_TokkoudosghtnpKbn.BLNK);
        pUiBean.setVhsyudisptktutakngk10(BizCurrency.optional());
        pUiBean.setVhsyudisptkkrkhasseiymd10(null);
        pUiBean.setVhsyudisptknkhknumu10(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptkgannyukyhumu10(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptkkgbairitukbn10(C_KhnkyhkgbairituKbn.BLNK);
        pUiBean.setVhsyudisptksndkyhkinshrskgnumu10(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptknextkosumu10(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptkhghkumu10(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptktsnshrgndhjumu10(C_UmuKbn.NONE);
        pUiBean.setVhsyudisptktsnshrgndgk10(BizCurrency.optional());
        pUiBean.setVhsyuitijibrumu(C_UmuKbn.NONE);
        pUiBean.setVhsyuyendthnkjyoutaikbn(C_YendthnkJyoutaiKbn.BLNK);
        pUiBean.setVhsyugenzaikngkhyjfukaumu(C_UmuKbn.NONE);

        List<TbktInfoDataSourceBeanCommonParam> beanLst = new ArrayList<>();
        pUiBean.convertTbktInfoForCommonParam(beanLst);
    }

    private  void setBP_Syu(KhozenCommonParam pKCParm, SetHosyouExecUiBeanParam pUiBean) {

        String syoNo = pUiBean.getSyono();

        List<IT_KykSyouhn> kykSyouhnLst = pKCParm.getKeiyakuSyouhin(syoNo, C_SyutkKbn.SYU);
        if (kykSyouhnLst == null) {
            throw new CommonBizAppException("契約商品TBL 証券番号=" + syoNo);
        }

        String syouhnCd = kykSyouhnLst.get(0).getSyouhncd();
        int syouhnSdno  = kykSyouhnLst.get(0).getSyouhnsdno();
        int syouhnRenno = kykSyouhnLst.get(0).getKyksyouhnrenno();
        C_YendthnkJyoutaiKbn yendthnkJyoutaiKbn = C_YendthnkJyoutaiKbn.BLNK;

        IT_HhknSya hhknSya = pKCParm.getHihokensya(syoNo);

        IT_KykKihon kykKihon = pKCParm.getKeiyakuKihon(syoNo);

        IT_KykSonotaTkyk kykSonotaTkyk = pKCParm.getSonotaTokuyaku(syoNo);

        IT_KykSyouhnHnkmae kykSyouhnHnkmae = hozenDomManager.getKykSyouhnHnkmaeBySyono(syoNo);

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = pKCParm.getNyknJissekiRirekiSk(syoNo);

        C_UmuKbn syuGannyuKyhUmu = kykSyouhnLst.get(0).getSyouhnZokusei().getGannyukyhumu();
        C_UmuKbn syuSynndkyfknshrskgnUmu = kykSyouhnLst.get(0).getSyouhnZokusei().getSynndkyfknshrskgnumu();
        BizDate syuSiharaisakugenStartYmd = null;
        BizDate syuSiharaisakugenEndYmd = null;
        BizCurrency syuShrskgngos = BizCurrency.valueOf(0);
        C_UmuKbn syuKostratkiUmu = kykSyouhnLst.get(0).getSyouhnZokusei().getKostratkiumu();
        C_HknkknsmnKbn syuHknkknsmnKbn = kykSyouhnLst.get(0).getHknkknsmnkbn();
        int syuKousinKaisuu = 0;
        BizCurrency syuJikaiKousingoP = BizCurrency.valueOf(0);
        C_UmuKbn syuJikaikousinUmu = C_UmuKbn.NONE;
        C_Kykjyoutai syuKykjyoutai = kykSyouhnLst.get(0).getKykjyoutai();
        BizDate fstpryosyuumu = null;
        BizCurrency rsgaku = BizCurrency.valueOf(0);
        BizCurrency hrkp = BizCurrency.valueOf(0);
        BizCurrency syuGannyuKyhntGk;
        BizNumber yoteiRiritu = BizNumber.ZERO;
        BizNumber tumitateRiritu = BizNumber.ZERO;
        BizNumber kykSjkkktyouseiRiritu = BizNumber.ZERO;
        BizNumber sjkkktyouseiyouRiritu = BizNumber.ZERO;

        if(kykSyouhnLst.get(0).getYendthnkymd() != null){

            yendthnkJyoutaiKbn = C_YendthnkJyoutaiKbn.YENDTHNKZUMI;
        }

        if (nyknJissekiRirekiLst != null && nyknJissekiRirekiLst.size() > 0) {
            IT_NyknJissekiRireki nyknJissekiRireki = nyknJissekiRirekiLst.get(0);
            fstpryosyuumu = nyknJissekiRireki.getRyosyuymd();
            rsgaku = nyknJissekiRireki.getRsgaku();
            hrkp = nyknJissekiRireki.getHrkp();
        }

        syuGannyuKyhntGk = BizCurrency.valueOf(0);

        if (C_UmuKbn.ARI.eq(syuSynndkyfknshrskgnUmu)){
            syuSiharaisakugenStartYmd = kykSyouhnLst.get(0).getSknnkaisiymd();
            BizDate keisanYmd = kykSyouhnLst.get(0).getKykymd();
            BizDateSpan periodYMD = new BizDateSpan(1, 0, 0);
            keisanYmd = keisanYmd.add(periodYMD).getRekijyou();
            keisanYmd = keisanYmd.getPreviousDay();
            syuSiharaisakugenEndYmd = keisanYmd;
            syuShrskgngos = kykSyouhnLst.get(0).getKihons().multiplyCurrency(
                BizCurrency.valueOf(0.5, kykSyouhnLst.get(0).getKihons().getType())).round(0, RoundingMode.DOWN);
        }

        if (C_UmuKbn.ARI.eq(syuKostratkiUmu) && C_HknkknsmnKbn.NENMANKI.eq(syuHknkknsmnKbn)) {

            syouhntaniKousingoPkeisan.setSyouhncd(syouhnCd);
            syouhntaniKousingoPkeisan.setSyouhnSdno(syouhnSdno);
            syouhntaniKousingoPkeisan.setKeiyakubi(kykSyouhnLst.get(0).getKykymd());
            syouhntaniKousingoPkeisan.setKatakbn(kykSyouhnLst.get(0).getKatakbn());
            syouhntaniKousingoPkeisan.setKyhgndKatakbn(kykSyouhnLst.get(0).getKyhgndkatakbn());
            syouhntaniKousingoPkeisan.setSyukyhkinKatakbn(kykSyouhnLst.get(0).getSyukyhkinkatakbn());
            syouhntaniKousingoPkeisan.setKhnkyhkgbairituKbn(kykSyouhnLst.get(0).getKhnkyhkgbairitukbn());
            syouhntaniKousingoPkeisan.set6DaisktsyknTuikakyhKatakbn(kykSyouhnLst.get(0).getRokudaildkbn());
            syouhntaniKousingoPkeisan.setPmnjtkhukaKbn(kykSyouhnLst.get(0).getPmnjtkkbn());
            syouhntaniKousingoPkeisan.setHknkknSmnkbn(kykSyouhnLst.get(0).getHknkknsmnkbn());
            syouhntaniKousingoPkeisan.setHknkkn(kykSyouhnLst.get(0).getHknkkn());
            syouhntaniKousingoPkeisan.setHrkkknSmnkbn(kykSyouhnLst.get(0).getHrkkknsmnkbn());
            syouhntaniKousingoPkeisan.setHrkkkn(kykSyouhnLst.get(0).getHrkkkn());
            syouhntaniKousingoPkeisan.setHhknNen(kykSyouhnLst.get(0).getHhknnen());
            syouhntaniKousingoPkeisan.setHhknSei(hhknSya.getHhknsei());
            syouhntaniKousingoPkeisan.setHrkKaisuu(kykKihon.getHrkkaisuu());
            syouhntaniKousingoPkeisan.setHrkKeiro(kykKihon.getHrkkeiro());
            syouhntaniKousingoPkeisan.setSdPdKbn(C_Sdpd.SD);
            syouhntaniKousingoPkeisan.setS((kykSyouhnLst.get(0).getKihons()));

            syouhntaniKousingoPkeisan.exec();

            syuKousinKaisuu = syouhntaniKousingoPkeisan.getKoskaisu();
            if (syuKousinKaisuu > 0) {
                syuJikaikousinUmu = C_UmuKbn.ARI;
                if (C_Kykjyoutai.PMEN.eq(syuKykjyoutai)){
                    syuJikaiKousingoP = BizCurrency.valueOf(0);
                }
                else {
                    syuJikaiKousingoP = syouhntaniKousingoPkeisan.getKosnaiymeiskmk()[0].getHknry();
                }
            }
        }

        BizDate calckijyunYmd = BizDate.getSysDate();
        if (!C_YuukousyoumetuKbn.YUUKOU.eq(kykSyouhnLst.get(0).getYuukousyoumetukbn())) {
            if (BizDateUtil.compareYmd(
                calckijyunYmd, kykSyouhnLst.get(0).getSyoumetuymd()) == BizDateUtil.COMPARE_GREATER) {
                calckijyunYmd = kykSyouhnLst.get(0).getSyoumetuymd();
            }
        }

        int syohinHanteiKbn = SyouhinUtil.hantei(syouhnCd);
        C_HokenkinsyuruiKbn hokenkinsyuruiKbn = C_HokenkinsyuruiKbn.SBHOKENKIN;

        if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == syohinHanteiKbn
            || SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == syohinHanteiKbn
            || SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == syohinHanteiKbn) {
            hokenkinsyuruiKbn = C_HokenkinsyuruiKbn.SBKYUUHUKIN;
        }

        CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);

        calcHkShrKngk.execByKeisanWExt(syoNo,
            calckijyunYmd,
            C_SiinKbn.SP,
            hokenkinsyuruiKbn,
            kykKihon.getSdpdkbn(),
            kykKihon.getHrkkeiro());

        BizCurrency genzaisbhknkngaku = calcHkShrKngk.getCalcHkShrKngkBean().getSibousGk();
        BizCurrency genzaitmttkngk = calcHkShrKngk.getCalcHkShrKngkBean().getSbymdTmttKnGk();

        calcHkShrKngk.execByKeisanWExt(syoNo,
            calckijyunYmd,
            C_SiinKbn.SG,
            C_HokenkinsyuruiKbn.SAIGAIHOKENKIN,
            kykKihon.getSdpdkbn(),
            kykKihon.getHrkkeiro());

        BizCurrency saigaisbhknkngaku = calcHkShrKngk.getCalcHkShrKngkBean().getSaigaisGk();

        HanteiHokenKikan hanteiHokenKikan = SWAKInjector.getInstance(HanteiHokenKikan.class);
        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setKykYmd(kykSyouhnLst.get(0).getKykymd());
        hanteiHokenKikanBean.setCalcKijyunYmd(BizDate.getSysDate());
        hanteiHokenKikanBean.setSyouhnZokusei(kykSyouhnLst.get(0).getSyouhnZokusei());
        hanteiHokenKikanBean.setDai1hknkkn(kykSyouhnLst.get(0).getDai1hknkkn());

        C_HknKknKbn hknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

        if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == syohinHanteiKbn) {

            GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
            GetYoteirirituBean getYoteirirituBean = SWAKInjector.getInstance(GetYoteirirituBean.class);
            getYoteirirituBean.setSyouhncd(kykSyouhnLst.get(0).getSyouhncd());
            getYoteirirituBean.setKijyunymd(BizDate.getSysDate());
            getYoteirirituBean.setSknnkaisiymd(kykSyouhnLst.get(0).getSknnkaisiymd());
            getYoteirirituBean.setKykymd(kykSyouhnLst.get(0).getKykymd());
            getYoteirirituBean.setHknkkn(kykSyouhnLst.get(0).getHknkkn());
            getYoteirirituBean.setHknkknsmnkbn(kykSyouhnLst.get(0).getHknkknsmnkbn());
            getYoteirirituBean.setHhknnen(kykSyouhnLst.get(0).getHhknnen());
            getYoteirirituBean.setSitihsyuriritu(kykSyouhnLst.get(0).getYoteirrthendohosyurrt());
            getYoteiriritu.exec(getYoteirirituBean);

            yoteiRiritu = getYoteiriritu.getYoteiriritu();
        }

        HanteiKhSisuurendoTmttknJyoutai hanteiKhSisuurendoTmttknJyoutai = SWAKInjector
            .getInstance(HanteiKhSisuurendoTmttknJyoutai.class);
        HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = SWAKInjector.getInstance(HanteiTmttknJyoutaiBean.class);
        BizDate hanteikijyunymd = null;

        if (BizDateUtil.compareYmd(BizDate.getSysDate(), kykSyouhnLst.get(0).getKykymd()) == BizDateUtil.COMPARE_LESSER) {

            hanteikijyunymd = kykSyouhnLst.get(0).getKykymd();
        }
        else if (!C_YuukousyoumetuKbn.YUUKOU.eq(kykSyouhnLst.get(0).getYuukousyoumetukbn())
            && BizDateUtil.compareYmd(BizDate.getSysDate(), kykSyouhnLst.get(0).getSyoumetuymd())
            == BizDateUtil.COMPARE_GREATER) {

            hanteikijyunymd = kykSyouhnLst.get(0).getSyoumetuymd();
        }
        else {

            hanteikijyunymd = BizDate.getSysDate();
        }

        hanteiTmttknJyoutaiBean.setSyono(syoNo);
        hanteiTmttknJyoutaiBean.setHanteiKijyunymd(hanteikijyunymd);
        hanteiTmttknJyoutaiBean.setKykymd(kykSyouhnLst.get(0).getKykymd());

        boolean result = hanteiKhSisuurendoTmttknJyoutai.execChokuzenOutouymTmttknHantei(hanteiTmttknJyoutaiBean);

        pUiBean.setVhsyusyusyouhnnm(kykSyouhnLst.get(0).getSyouhnZokusei().getSyouhnnm());
        pUiBean.setVhsyuaisyoumeikbn(kykKihon.getAisyoumeikbn());
        pUiBean.setVhsyusyukyktuukasyu(kykSyouhnLst.get(0).getKyktuukasyu());
        pUiBean.setVhsyusyukouryokuhasseiymd(kykSyouhnLst.get(0).getKouryokuhasseiymd());
        pUiBean.setVhsyusyukykymd(kykSyouhnLst.get(0).getKykymd());
        pUiBean.setVhsyusyusknnkaisiymd(kykSyouhnLst.get(0).getSknnkaisiymd());
        pUiBean.setVhsyusyuhhknnen(kykSyouhnLst.get(0).getHhknnen());
        pUiBean.setVhsyusyukatakbn(kykSyouhnLst.get(0).getKatakbn());
        pUiBean.setVhsyusyukyhgndkatakbn(kykSyouhnLst.get(0).getKyhgndkatakbn());
        pUiBean.setVhsyusyuhknkkn(kykSyouhnLst.get(0).getHknkkn());
        pUiBean.setVhsyusyuhknkknsmnkbn(kykSyouhnLst.get(0).getHknkknsmnkbn());
        pUiBean.setVhsyudai1hknkkn(kykSyouhnLst.get(0).getDai1hknkkn());
        pUiBean.setVhsyusyuhrkkkn(kykSyouhnLst.get(0).getHrkkkn());
        pUiBean.setVhsyusyuhrkkknsmnkbn(kykSyouhnLst.get(0).getHrkkknsmnkbn());
        pUiBean.setVhsyusyukihons(kykSyouhnLst.get(0).getKihons());
        pUiBean.setVhsyusyup(kykSyouhnLst.get(0).getHokenryou());
        pUiBean.setVhsyusyunkhknumu(kykSyouhnLst.get(0).getSyouhnZokusei().getNkhknumu());
        pUiBean.setVhsyusyukihonssyuruikbn(kykSyouhnLst.get(0).getSyouhnZokusei().getKihonssyuruikbn());
        pUiBean.setVhsyugansknnkaisiymd(kykSyouhnLst.get(0).getGansknnkaisiymd());
        pUiBean.setVhsyusdpdkbn(kykKihon.getSdpdkbn());
        pUiBean.setVhsyusyunnkinsyukbn(kykSyouhnLst.get(0).getNksyukbn());
        pUiBean.setVhsyusyunenkinkkn(kykSyouhnLst.get(0).getNenkinkkn());
        pUiBean.setVhsyusyugannyukyhumu(syuGannyuKyhUmu);
        pUiBean.setVhsyusyugannyukyhntgk(syuGannyuKyhntGk);
        pUiBean.setVhsyusyufktsknnkaisiymd(kykSyouhnLst.get(0).getHksknnkaisiymd());
        pUiBean.setVhsyuhkgogansknnkaisiymd(kykSyouhnLst.get(0).getHkgansknnkaisiymd());
        pUiBean.setVhsyusyukhnkyhkgbairitukbn(kykSyouhnLst.get(0).getKhnkyhkgbairitukbn());
        pUiBean.setVhsyusyukihonkyhgk(kykSyouhnLst.get(0).getKihons().multiply(
            Integer.parseInt(kykSyouhnLst.get(0).getKhnkyhkgbairitukbn().getValue())));
        pUiBean.setVhsyusyusyukyhkinkatakbn(kykSyouhnLst.get(0).getSyukyhkinkatakbn());
        pUiBean.setVhsyusyurokudaildkbn(kykSyouhnLst.get(0).getRokudaildkbn());
        pUiBean.setVhsyusyusndkyhkinshrskgnumu(syuSynndkyfknshrskgnUmu);
        pUiBean.setVhsyusyushrskgnstartymd(syuSiharaisakugenStartYmd);
        pUiBean.setVhsyusyushrskgnendymd(syuSiharaisakugenEndYmd);
        pUiBean.setVhsyusyushrskgngos(syuShrskgngos);
        pUiBean.setVhsyusyunextkosumu(syuJikaikousinUmu);
        pUiBean.setVhsyusyunextkosgop(syuJikaiKousingoP);
        pUiBean.setVhsyusyutsnshrgndhjumu(
            kykSyouhnLst.get(0).getSyouhnZokusei().getTsnshrgndgkhyoujiumu());
        pUiBean.setVhsyudispsyutsnshrgndgk(
            kykSyouhnLst.get(0).getSyouhnZokusei().getTsnshrgndgk());
        pUiBean.setVhsyusyuhghkumu(kykSyouhnLst.get(0).getSyouhnZokusei().getHengakuumu());
        pUiBean.setVhsyugenzaisbhknkngaku(genzaisbhknkngaku);
        pUiBean.setVhsyusaigaisbhknkngaku(saigaisbhknkngaku);
        pUiBean.setVhsyudai1hknkknsbsyokuseiumu(kykSyouhnLst.get(0).getSyouhnZokusei().getDai1hknkknsbsyokuseiumu());
        pUiBean.setVhsyusgsbhsyumu(kykSyouhnLst.get(0).getSyouhnZokusei().getSgsbhsyumu());
        pUiBean.setVhsyuhknKknKbn(hknKknKbn);
        pUiBean.setVhsyusyohinhanteikbn(syohinHanteiKbn);
        pUiBean.setVhsyumvatekiumu(kykSyouhnLst.get(0).getSyouhnZokusei().getMvatekiumu());
        pUiBean.setVhsyusbhkuktumu(kykSyouhnLst.get(0).getSyouhnZokusei().getSbhkuktumu());
        pUiBean.setVhsyusbkyuuhukinuktumu(kykSyouhnLst.get(0).getSyouhnZokusei().getSbkyuuhukinuktumu());
        pUiBean.setVhsyuyendthnkymd(kykSyouhnLst.get(0).getYendthnkymd());
        pUiBean.setVhsyutmttknitenymd(kykSyouhnLst.get(0).getTmttknitenymd());
        pUiBean.setVhsyusyunkshrstartymd(kykSyouhnLst.get(0).getHknkknmanryouymd());
        pUiBean.setVhsyuyendthnkjyoutaikbn(yendthnkJyoutaiKbn);

        SisurendoTmttknInfoBean sisurendoTmttknInfoBean =
            hozenDomManager.getSisurendoTmttknInfoBean(syoNo, calckijyunYmd);

        KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);
        KeisanSisuuRendouNkTmttkn KeisanSisuuRendouNkTmttkn = SWAKInjector.getInstance(KeisanSisuuRendouNkTmttkn.class);

        if (sisurendoTmttknInfoBean != null) {
            if (C_YendthnkJyoutaiKbn.BLNK.eq(yendthnkJyoutaiKbn)){

                BizDateYM kaiyakuhrKeisankijyunYm = keisanWKijunYM.exec(
                    kykSyouhnLst.get(0).getKykymd(),
                    calckijyunYmd,
                    null,
                    null,
                    kykSyouhnLst.get(0).getKykjyoutai(),
                    kykSyouhnLst.get(0).getSyouhncd(),
                    null);

                KeisanSisuuRendouNkTmttkn.exec(
                    kykSyouhnLst.get(0).getKykymd(),
                    kykSyouhnLst.get(0).getHknkkn(),
                    kykSonotaTkyk.getTeikishrtkykhukaumu(),
                    kykSyouhnLst.get(0).getKyktuukasyu(),
                    calckijyunYmd,
                    kaiyakuhrKeisankijyunYm,
                    sisurendoTmttknInfoBean.getTmttknTaisyouYM(),
                    kykSyouhnLst.get(0).getTumitateriritu(),
                    sisurendoTmttknInfoBean.getTeirituTmttknGK(),
                    sisurendoTmttknInfoBean.getSisuuRendouTmttknGK());
            }
        }

        if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == syohinHanteiKbn
            || SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == syohinHanteiKbn) {

            if (BizDateUtil.compareYmd(BizDate.getSysDate(), kykSyouhnLst.get(0).getKykymd()) == BizDateUtil.COMPARE_LESSER) {
                pUiBean.setVhsyuteiritutmttkngk(BizCurrency.optional());
                pUiBean.setVhsyusisuurendoutmttkngk(BizCurrency.optional());
            }
            else {
                if ((C_YendthnkJyoutaiKbn.BLNK.eq(yendthnkJyoutaiKbn))) {
                    if (result) {
                        pUiBean.setVhsyuteiritutmttkngk(KeisanSisuuRendouNkTmttkn.getTeiritutmttkngk());
                        if (sisurendoTmttknInfoBean != null) {
                            pUiBean.setVhsyusisuurendoutmttkngk(sisurendoTmttknInfoBean.getSisuuRendouTmttknGK());
                        }
                    }
                }
            }
        }
        if (BizDateUtil.compareYmd(BizDate.getSysDate(), kykSyouhnLst.get(0).getKykymd()) == BizDateUtil.COMPARE_LESSER) {
            pUiBean.setVhsyugenzaitmttkngk(BizCurrency.optional());
        }
        else {
            pUiBean.setVhsyugenzaitmttkngk(genzaitmttkngk);
        }

        BizNumber sisuuRendourate = null;
        String sisuunm = BLANK;
        if (kykSyouhnLst.get(0).getTmttknitenymd() != null) {
            if (BizDateUtil.compareYmd(
                BizDate.getSysDate(),kykSyouhnLst.get(0).getTmttknitenymd() ) == BizDateUtil.COMPARE_LESSER) {
                sisuuRendourate = kykSyouhnLst.get(0).getKykjisisuurendourate();
                BM_SisuuKihon sisuuKihon = bizDomManager.getSisuuKihon(kykSyouhnLst.get(0).getSisuukbn());
                if (sisuuKihon!= null) {
                    sisuunm = sisuuKihon.getSisuunm();
                }
                else {
                    sisuunm = BLANK;
                }
            }
            else {
                sisuuRendourate = BizNumber.ZERO;
                sisuunm = BLANK;
            }
        }
        else {
            if (C_TmttknhaibunjyoutaiKbn.SISUUTEIRITU.eq(kykSyouhnLst.get(0).getTmttknhaibunjyoutai()) ||
                C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(kykSyouhnLst.get(0).getTmttknhaibunjyoutai())) {
                sisuuRendourate = kykSyouhnLst.get(0).getKykjisisuurendourate();
                BM_SisuuKihon sisuuKihon = bizDomManager.getSisuuKihon(kykSyouhnLst.get(0).getSisuukbn());
                if (sisuuKihon!= null) {
                    sisuunm = sisuuKihon.getSisuunm();
                }
                else {
                    sisuunm = BLANK;
                }
            }
            else {
                sisuuRendourate = BizNumber.ZERO;
                sisuunm = BLANK;
            }
        }
        pUiBean.setVhsyusisuurendourate(sisuuRendourate);
        pUiBean.setVhsyuteiritutmttrate(BizNumber.valueOf(100).subtract(sisuuRendourate));
        pUiBean.setVhsyusisuunm(sisuunm);
        pUiBean.setVhsyusetteibairitu(kykSyouhnLst.get(0).getSetteibairitu());

        if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == syohinHanteiKbn) {
            pUiBean.setVhsyuyoteiriritu(yoteiRiritu.multiply(100));
        }
        else {
            yoteiRiritu = kykSyouhnLst.get(0).getYoteiriritu();
            if (yoteiRiritu != null) {
                pUiBean.setVhsyuyoteiriritu(yoteiRiritu.multiply(100));
            }
            else {
                pUiBean.setVhsyuyoteiriritu(BizNumber.ZERO);
            }
        }
        tumitateRiritu = kykSyouhnLst.get(0).getTumitateriritu();
        if (tumitateRiritu != null) {
            pUiBean.setVhsyutumitateriritu(tumitateRiritu.multiply(100));
            pUiBean.setVhsyukyktumitateriritu(tumitateRiritu.multiply(100));
        }
        else {
            pUiBean.setVhsyutumitateriritu(BizNumber.ZERO);
            pUiBean.setVhsyukyktumitateriritu(BizNumber.ZERO);
        }
        if (kykSyouhnLst.get(0).getLoadinghnkgtumitateriritu() != null) {
            pUiBean.setVhsyu10nentumitateriritu(kykSyouhnLst.get(0).getLoadinghnkgtumitateriritu().multiply(100));
        }
        else {
            pUiBean.setVhsyu10nentumitateriritu(BizNumber.ZERO);
        }
        kykSjkkktyouseiRiritu = kykSyouhnLst.get(0).getKyksjkkktyouseiriritu();
        if (kykSjkkktyouseiRiritu != null) {
            pUiBean.setVhsyukyksjkkktyouseiriritu(kykSjkkktyouseiRiritu.multiply(100));
        }
        else {
            pUiBean.setVhsyukyksjkkktyouseiriritu(BizNumber.ZERO);
        }

        GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu = SWAKInjector.getInstance(GetSjkkktyouseiyouriritu.class);
        GetSjkkktyouseiyourirituBean sjkkktyouseiyourirituBean =
            SWAKInjector.getInstance(GetSjkkktyouseiyourirituBean.class);
        sjkkktyouseiyourirituBean.setSyouhncd(syouhnCd);
        sjkkktyouseiyourirituBean.setKijyunymd(BizDate.getSysDate());
        sjkkktyouseiyourirituBean.setHknkkn(kykSyouhnLst.get(0).getHknkkn());
        sjkkktyouseiyourirituBean.setHknkknsmnkbn(C_HknkknsmnKbn.BLNK);
        sjkkktyouseiyourirituBean.setHhknnen(0);
        getSjkkktyouseiyouriritu.exec(sjkkktyouseiyourirituBean);
        sjkkktyouseiyouRiritu = getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu();
        if (sjkkktyouseiyouRiritu != null) {
            pUiBean.setVhsyuskisjkkktyouseiriritu(sjkkktyouseiyouRiritu.multiply(100));
        }
        else {
            pUiBean.setVhsyuskisjkkktyouseiriritu(BizNumber.ZERO);
        }
        if (C_YendthnkJyoutaiKbn.BLNK.eq(yendthnkJyoutaiKbn)) {
            pUiBean.setVhsyusyukykjisiteituukasyu(kykSyouhnLst.get(0).getKyktuukasyu());
        }
        else {
            pUiBean.setVhsyusyukykjisiteituukasyu(kykSyouhnHnkmae.getKyktuukasyu());
        }

        if (C_UmuKbn.ARI.eq(kykSyouhnLst.get(0).getSyouhnZokusei().getHeijyunbaraiumu())) {
            if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == syohinHanteiKbn) {

                pUiBean.setVhsyusyukykkjnkngk(kykSyouhnLst.get(0).getPharaikomisougaku());
            }
            if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == syohinHanteiKbn) {

                KeisanGaisanPsougk keisanGaisanPsougk = SWAKInjector.getInstance(KeisanGaisanPsougk.class);
                pUiBean.setVhsyusyukykkjnkngk(keisanGaisanPsougk.exec(kykKihon.getHrkp(), kykKihon.getHrkkaisuu(),
                    kykSyouhnLst.get(0).getKykymd(), kykSyouhnLst.get(0).getHaraimanymd()));
            }
        }
        else if (!C_Tuukasyu.JPY.eq(kykSyouhnLst.get(0).getKyktuukasyu())) {
            if (kykSyouhnLst.get(0).getGengakugoyenitijibrpstgk()
                .compareTo(BizCurrency.valueOf(0, kykSyouhnLst.get(0).getGengakugoyenitijibrpstgk().getType())) == 0) {

                KeisanKijyungk keisanKijyungk = SWAKInjector.getInstance(KeisanKijyungk.class);
                C_Tkhukaumu tkhukaumu = C_Tkhukaumu.NONE;

                if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getYennykntkhkumu())) {

                    tkhukaumu = C_Tkhukaumu.HUKA;
                }

                keisanKijyungk.exec(fstpryosyuumu,
                    rsgaku,
                    hrkp,
                    kykSyouhnLst.get(0).getKyktuukasyu(),
                    tkhukaumu);

                pUiBean.setVhsyusyukykkjnkngk(keisanKijyungk.getKijyungk());
            }
            else{
                pUiBean.setVhsyusyukykkjnkngk(kykSyouhnLst.get(0).getGengakugoyenitijibrpstgk());
            }
        }

        pUiBean.setVhsyuitijibrumu(kykSyouhnLst.get(0).getSyouhnZokusei().getItijibrumu());

        if ((SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == syohinHanteiKbn
            || SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == syohinHanteiKbn)
            && C_YendthnkJyoutaiKbn.BLNK.eq(yendthnkJyoutaiKbn)) {

            if (!result) {
                pUiBean.setVhsyugenzaikngkhyjfukaumu(C_UmuKbn.ARI);
            }
            else {
                pUiBean.setVhsyugenzaikngkhyjfukaumu(C_UmuKbn.NONE);
            }
        }
        else {
            pUiBean.setVhsyugenzaikngkhyjfukaumu(C_UmuKbn.NONE);
        }

        IT_SyouhnTokujou syouhnTokujou = pKCParm.getSyouhinTokujyou(
            syoNo, C_SyutkKbn.SYU, syouhnCd, syouhnSdno, syouhnRenno);

        if (syouhnTokujou == null) {
            pUiBean.setVhsyusyutkjyskgnkkn(C_Tkjyskgnkkn.BLNK);
            pUiBean.setVhsyusyutkjyskgnhkndsymd1(null);
            pUiBean.setVhsyusyutkjyskgnhkndeymd1(null);
            pUiBean.setVhsyusyutkjyskgns1(BizCurrency.valueOf(0));
            pUiBean.setVhsyusyutkjyskgnhkndsymd2(null);
            pUiBean.setVhsyusyutkjyskgnhkndeymd2(null);
            pUiBean.setVhsyusyutkjyskgns2(BizCurrency.valueOf(0));
            pUiBean.setVhsyusyutkjyskgnhkndsymd3(null);
            pUiBean.setVhsyusyutkjyskgnhkndeymd3(null);
            pUiBean.setVhsyusyutkjyskgns3(BizCurrency.valueOf(0));
            pUiBean.setVhsyusyutkjyskgnhkndsymd4(null);
            pUiBean.setVhsyusyutkjyskgnhkndeymd4(null);
            pUiBean.setVhsyusyutkjyskgns4(BizCurrency.valueOf(0));
            pUiBean.setVhsyusyutkjyskgnhkndsymd5(null);
            pUiBean.setVhsyusyutkjyskgnhkndeymd5(null);
            pUiBean.setVhsyusyutkjyskgns5(BizCurrency.valueOf(0));
            pUiBean.setVhsyusyutkjyhyouten(C_Tkjyhyouten.BLNK);
            pUiBean.setVhsyusyutkjyp(BizCurrency.valueOf(0));
            pUiBean.setVhsyusyuhtnpbuicd1(BLANK);
            pUiBean.setVhsyusyuhtnpbuinm1(BLANK);
            pUiBean.setVhsyusyuhtnpkkn1(C_Htnpkkn.BLNK);
            pUiBean.setVhsyusyuhtnpbuicd2(BLANK);
            pUiBean.setVhsyusyuhtnpbuinm2(BLANK);
            pUiBean.setVhsyusyuhtnpkkn2(C_Htnpkkn.BLNK);
            pUiBean.setVhsyusyuhtnpbuicd3(BLANK);
            pUiBean.setVhsyusyuhtnpbuinm3(BLANK);
            pUiBean.setVhsyusyuhtnpkkn3(C_Htnpkkn.BLNK);
            pUiBean.setVhsyusyuhtnpbuicd4(BLANK);
            pUiBean.setVhsyusyuhtnpbuinm4(BLANK);
            pUiBean.setVhsyusyuhtnpkkn4(C_Htnpkkn.BLNK);
            pUiBean.setVhsyusyutokkdsghtnpkbn(C_TokkoudosghtnpKbn.BLNK);
        }
        else {
            pUiBean.setVhsyusyutkjyskgnkkn(syouhnTokujou.getTkjyskgnkkn());
            pUiBean.setVhsyusyutkjyhyouten(syouhnTokujou.getTkjyhyouten());
            pUiBean.setVhsyusyutkjyp(syouhnTokujou.getTkjyp());
            BM_HutanpoBui hutanpoBui1 = pKCParm.getHutanpoBui(syouhnTokujou.getHtnpbuicd1());
            if (hutanpoBui1 == null) {
                pUiBean.setVhsyusyuhtnpbuicd1(BLANK);
                pUiBean.setVhsyusyuhtnpbuinm1(BLANK);
            }
            else {
                pUiBean.setVhsyusyuhtnpbuicd1(syouhnTokujou.getHtnpbuicd1());
                pUiBean.setVhsyusyuhtnpbuinm1(hutanpoBui1.getHtnpbuinm());
            }
            pUiBean.setVhsyusyuhtnpkkn1(syouhnTokujou.getHtnpkkn1());

            BM_HutanpoBui hutanpoBui2 = pKCParm.getHutanpoBui(syouhnTokujou.getHtnpbuicd2());
            if (hutanpoBui2 == null) {
                pUiBean.setVhsyusyuhtnpbuicd2(BLANK);
                pUiBean.setVhsyusyuhtnpbuinm2(BLANK);
            }
            else {
                pUiBean.setVhsyusyuhtnpbuicd2(syouhnTokujou.getHtnpbuicd2());
                pUiBean.setVhsyusyuhtnpbuinm2(hutanpoBui2.getHtnpbuinm());
            }
            pUiBean.setVhsyusyuhtnpkkn2(syouhnTokujou.getHtnpkkn2());

            BM_HutanpoBui hutanpoBui3 = pKCParm.getHutanpoBui(syouhnTokujou.getHtnpbuicd3());
            if (hutanpoBui3 == null) {
                pUiBean.setVhsyusyuhtnpbuicd3(BLANK);
                pUiBean.setVhsyusyuhtnpbuinm3(BLANK);
            }
            else {
                pUiBean.setVhsyusyuhtnpbuicd3(syouhnTokujou.getHtnpbuicd3());
                pUiBean.setVhsyusyuhtnpbuinm3(hutanpoBui3.getHtnpbuinm());
            }
            pUiBean.setVhsyusyuhtnpkkn3(syouhnTokujou.getHtnpkkn3());

            BM_HutanpoBui hutanpoBui4 = pKCParm.getHutanpoBui(syouhnTokujou.getHtnpbuicd4());
            if (hutanpoBui4 == null) {
                pUiBean.setVhsyusyuhtnpbuicd4(BLANK);
                pUiBean.setVhsyusyuhtnpbuinm4(BLANK);
            }
            else {
                pUiBean.setVhsyusyuhtnpbuicd4(syouhnTokujou.getHtnpbuicd4());
                pUiBean.setVhsyusyuhtnpbuinm4(hutanpoBui4.getHtnpbuinm());
            }
            pUiBean.setVhsyusyuhtnpkkn4(syouhnTokujou.getHtnpkkn4());
            pUiBean.setVhsyusyutokkdsghtnpkbn(syouhnTokujou.getTokkoudosghtnpkbn());

            int nendo = 5;
            BizDate[] hokenNendoStartYmds = new BizDate[nendo];
            BizDate[] hokenNendoEndYmds = new BizDate[nendo];
            BizCurrency[] skgns = new BizCurrency[nendo];
            for (int index = 0; index < 5; index++) {
                hokenNendoStartYmds[index] = null;
                hokenNendoEndYmds[index] = null;
                skgns[index] = BizCurrency.valueOf(0);
            }
            tokujoSSakugenNaiyouKeisan = SWAKInjector.getInstance(TokujoSSakugenNaiyouKeisan.class);
            C_Tkjyskgnkkn tkjyskgnkkn = syouhnTokujou.getTkjyskgnkkn();
            if (!C_Tkjyskgnkkn.BLNK.eq(tkjyskgnkkn)) {

                tokujoSSakugenNaiyouKeisan.setSyouhncd(syouhnCd);
                tokujoSSakugenNaiyouKeisan.setSyouhnSdno(syouhnSdno);
                tokujoSSakugenNaiyouKeisan.setKykbi(kykSyouhnLst.get(0).getKykymd());
                tokujoSSakugenNaiyouKeisan.setSknnKaisibi(kykSyouhnLst.get(0).getSknnkaisiymd());
                tokujoSSakugenNaiyouKeisan.setTkjSkgnKkn(tkjyskgnkkn);
                tokujoSSakugenNaiyouKeisan.setS(kykSyouhnLst.get(0).getKihons());

                tokujoSSakugenNaiyouKeisan.exec();

                for (int index = 0; index < Integer.parseInt(tkjyskgnkkn.getValue()); index++) {
                    hokenNendoStartYmds[index] =
                        tokujoSSakugenNaiyouKeisan.getSsakugenBeans()[index].getStartNendoYmd();
                    hokenNendoEndYmds[index] = tokujoSSakugenNaiyouKeisan.getSsakugenBeans()[index].getEndNendoYmd();
                    skgns[index] = tokujoSSakugenNaiyouKeisan.getSsakugenBeans()[index].getS();
                }
            }
            pUiBean.setVhsyusyutkjyskgnhkndsymd1(hokenNendoStartYmds[0]);
            pUiBean.setVhsyusyutkjyskgnhkndeymd1(hokenNendoEndYmds[0]);
            pUiBean.setVhsyusyutkjyskgns1(skgns[0]);
            pUiBean.setVhsyusyutkjyskgnhkndsymd2(hokenNendoStartYmds[1]);
            pUiBean.setVhsyusyutkjyskgnhkndeymd2(hokenNendoEndYmds[1]);
            pUiBean.setVhsyusyutkjyskgns2(skgns[1]);
            pUiBean.setVhsyusyutkjyskgnhkndsymd3(hokenNendoStartYmds[2]);
            pUiBean.setVhsyusyutkjyskgnhkndeymd3(hokenNendoEndYmds[2]);
            pUiBean.setVhsyusyutkjyskgns3(skgns[2]);
            pUiBean.setVhsyusyutkjyskgnhkndsymd4(hokenNendoStartYmds[3]);
            pUiBean.setVhsyusyutkjyskgnhkndeymd4(hokenNendoEndYmds[3]);
            pUiBean.setVhsyusyutkjyskgns4(skgns[3]);
            pUiBean.setVhsyusyutkjyskgnhkndsymd5(hokenNendoStartYmds[4]);
            pUiBean.setVhsyusyutkjyskgnhkndeymd5(hokenNendoEndYmds[4]);
            pUiBean.setVhsyusyutkjyskgns5(skgns[4]);

        }
    }

    private  void setBP_Tbkt(KhozenCommonParam pKCParm, SetHosyouExecUiBeanParam pUiBean) {

        String syoNo = pUiBean.getSyono();

        KeisanCV keisanCV = SWAKInjector.getInstance(KeisanCV.class);
        List<IT_KykSyouhn> kykSyouhnLst = pKCParm.getKeiyakuSyouhin(syoNo, C_SyutkKbn.SYU);
        C_ErrorKbn errorKbn =  keisanCV.exec(syoNo,
            BizDate.getSysDate(), kykSyouhnLst.get(0).getKyktuukasyu());

        List<TbktInfoDataSourceBeanCommonParam> beanLst = new ArrayList<>();

        if (C_ErrorKbn.ERROR.eq(errorKbn)){
            pUiBean.convertTbktInfoForCommonParam(beanLst);
        }
        else{
            List<CVBean>  cvBeanList = keisanCV.getCVBeanList();
            if (cvBeanList.size() == 0) {
                pUiBean.convertTbktInfoForCommonParam(beanLst);
            }
            else {
                for (CVBean cvBean : cvBeanList){
                    TbktInfoDataSourceBeanCommonParam tbktInfoDataSourceBeanCommonParam =
                        pUiBean.createTbktInfoDataSourceBean();

                    tbktInfoDataSourceBeanCommonParam.setVhsyudispfundunitkbnval(
                        C_UnitFundKbn.getContentByValue(cvBean.getUnitFundKbn().toString()));
                    tbktInfoDataSourceBeanCommonParam.setVhsyudispfundunitkbn(cvBean.getUnitFundKbn());
                    tbktInfoDataSourceBeanCommonParam.setVhsyudispunitsuu(cvBean.getUnitSuu());

                    tbktInfoDataSourceBeanCommonParam.setVhsyudispfundindex(cvBean.getFundIndex());
                    tbktInfoDataSourceBeanCommonParam.setVhsyudisptutakngk(cvBean.getFundBetuTumitatekin());
                    tbktInfoDataSourceBeanCommonParam.setVhsyudispwariai(BizNumber.valueOf(cvBean.getWariAi()));

                    beanLst.add(tbktInfoDataSourceBeanCommonParam);
                }
                pUiBean.convertTbktInfoForCommonParam(beanLst);
            }
        }
    }

    private  void setBP_Tk(KhozenCommonParam pKCParm, SetHosyouExecUiBeanParam pUiBean) {

        String syoNo = pUiBean.getSyono();

        IT_KykSonotaTkyk kykSonotaTk = pKCParm.getSonotaTokuyaku(syoNo);

        if (kykSonotaTk != null) {
            if (C_UmuKbn.ARI.eq(kykSonotaTk.getNstkhkumu())){
                pUiBean.setVhsyudisptksyouhnnm("年金支払特約");
                pUiBean.setVhsyunkshrtkyknksyukbn(kykSonotaTk.getNkshrtkyknksyukbn());
                pUiBean.setVhsyunkshrtkyknksyukkn(kykSonotaTk.getNkshrtkyknksyukkn());
                pUiBean.setVhsyunstkhukaumukbn(C_UmuKbn.ARI);
            }
            else {
                pUiBean.setVhsyunstkhukaumukbn(C_UmuKbn.NONE);
            }
        }
        else {
            pUiBean.setVhsyunstkhukaumukbn(C_UmuKbn.NONE);
        }
    }

    private void setBP_Hsny(KhozenCommonParam pKCParm, SetHosyouExecUiBeanParam pUiBean) {

        String syoNo = pUiBean.getSyono();

        List<IT_KykSyouhn> kykSyouhnLst = pKCParm.getKeiyakuSyouhin(syoNo, C_SyutkKbn.TK);
        if (kykSyouhnLst == null) {
            return;
        }

        IT_HhknSya hhknSya = pKCParm.getHihokensya(syoNo);

        IT_KykKihon kykKihon = pKCParm.getKeiyakuKihon(syoNo);

        int size =  kykSyouhnLst.size();
        String [] syouhnCds                    = new String [size];
        int [] syouhnSdNos                     = new int [size];
        int [] renNos                          = new int [size];
        String [] syouhnNms                    = new String [size];
        C_Kykjyoutai [] kykJyoutai             = new C_Kykjyoutai [size];
        BizDate [] kouyokuHasseiYmds           = new BizDate [size];
        BizDate [] kykYmds                     = new BizDate [size];
        BizDate [] sknnKsYmds                  = new BizDate [size];
        int [] hhknNens                        = new int [size];
        BizDate [] haraimanYmds                = new BizDate [size];
        BizDate [] hknkknManryouYmds           = new BizDate [size];
        C_KataKbn [] kataKbns                  = new C_KataKbn [size];
        C_KyhgndkataKbn [] kyhGndKataKbns      = new C_KyhgndkataKbn [size];
        int [] hknKkns                         = new int [size];
        C_HknkknsmnKbn [] hknKknSmnKbns        = new C_HknkknsmnKbn [size];
        int [] hrkKkns                         = new int [size];
        C_HrkkknsmnKbn [] hrkKknSmnKbns        = new C_HrkkknsmnKbn [size];
        BizCurrency [] kihonSs                 = new BizCurrency [size];
        BizCurrency [] premiums                = new BizCurrency [size];
        C_UmuKbn [] nkKknUmus                  = new C_UmuKbn [size];
        C_KihonssyuruiKbn [] kihonSSyuruiKbns  = new C_KihonssyuruiKbn [size];
        C_Nenkinsyu [] nkSyus                  = new C_Nenkinsyu [size];
        int [] nkKkns                          = new int [size];
        C_Tkjyskgnkkn [] tkjyskgnKkns          = new C_Tkjyskgnkkn [size];
        C_Tkjyhyouten [] tkjyHyoutens          = new C_Tkjyhyouten [size];
        BizCurrency [] tkjyPs                  = new BizCurrency [size];
        String [] htnpBuiCd1s                  = new String [size];
        String [] htnpBuiNm1s                  = new String [size];
        C_Htnpkkn [] htnpKkn1s                 = new C_Htnpkkn [size];
        String [] htnpBuiCd2s                  = new String [size];
        String [] htnpBuiNm2s                  = new String [size];
        C_Htnpkkn [] htnpKkn2s                 = new C_Htnpkkn [size];
        String [] htnpBuiCd3s                  = new String [size];
        String [] htnpBuiNm3s                  = new String [size];
        C_Htnpkkn [] htnpKkn3s                 = new C_Htnpkkn [size];
        String [] htnpBuiCd4s                  = new String [size];
        String [] htnpBuiNm4s                  = new String [size];
        C_Htnpkkn [] htnpKkn4s                 = new C_Htnpkkn [size];

        C_UmuKbn [] tsnshrgndgkhyoujiumus = new C_UmuKbn [size];
        BizCurrency [] tsnshrgndgks       = new BizCurrency [size];
        BizDate [] gansknnkaisiymds       = new BizDate [size];
        C_UmuKbn [] gannyukyhumus         = new C_UmuKbn [size];
        BizCurrency [] gannyukyhntgks     = new BizCurrency [size];
        BizDate [] hkSknnKsYmds           = new BizDate [size];
        BizDate [] hkGansknnkaisiymds     = new BizDate [size];

        C_KhnkyhkgbairituKbn [] khnKyhKgBairituKbns   = new C_KhnkyhkgbairituKbn [size];
        C_SyukyhkinkataKbn [] syuKyhkinkataKbns       = new C_SyukyhkinkataKbn [size];
        C_6daiLdKbn [] lokuDaiSktsyknTuikaKyhkataKbns = new C_6daiLdKbn [size];
        C_PmnjtkKbn [] pmnjTkKbns                     = new C_PmnjtkKbn [size];
        C_Tuukasyu [] tuukasyu                        = new C_Tuukasyu [size];
        C_TokkoudosghtnpKbn [] tokKoudoSgHtnpKbns     = new C_TokkoudosghtnpKbn [size];

        C_UmuKbn [] tksynndkyfknshrskgnumus  = new C_UmuKbn [size];
        BizDate [] tksiharaisakugenStartYmds = new BizDate [size];
        BizDate [] tksiharaisakugenEndYmds   = new BizDate [size];
        BizCurrency [] tkshrskgngoss         = new BizCurrency [size];
        C_UmuKbn [] tkkostratkiumus          = new C_UmuKbn [size];
        BizCurrency [] tkjikaikousingops     = new BizCurrency[size];
        C_UmuKbn [] tkjikaikousinumus        = new C_UmuKbn [size];
        C_UmuKbn [] dsyuhghkumu              = new C_UmuKbn [size];

        C_HknkknsmnKbn tkhknkknsmnkbn;
        int tkkousinkaisuu;

        BizDate[] hokenNendoStartYmd1s = new BizDate[size];
        BizDate[] hokenNendoEndYmd1s   = new BizDate[size];
        BizCurrency[] skgn1s           = new BizCurrency[size];
        BizDate[] hokenNendoStartYmd2s = new BizDate[size];
        BizDate[] hokenNendoEndYmd2s   = new BizDate[size];
        BizCurrency[] skgn2s           = new BizCurrency[size];
        BizDate[] hokenNendoStartYmd3s = new BizDate[size];
        BizDate[] hokenNendoEndYmd3s   = new BizDate[size];
        BizCurrency[] skgn3s           = new BizCurrency[size];
        BizDate[] hokenNendoStartYmd4s = new BizDate[size];
        BizDate[] hokenNendoEndYmd4s   = new BizDate[size];
        BizCurrency[] skgn4s           = new BizCurrency[size];
        BizDate[] hokenNendoStartYmd5s = new BizDate[size];
        BizDate[] hokenNendoEndYmd5s   = new BizDate[size];
        BizCurrency[] skgn5s           = new BizCurrency[size];

        IT_SyouhnTokujou tokujyou   = null;
        BM_HutanpoBui hutanpoBui1   = null;
        BM_HutanpoBui hutanpoBui2   = null;
        BM_HutanpoBui hutanpoBui3   = null;
        BM_HutanpoBui hutanpoBui4   = null;

        C_UmuKbn tkgannyukyhumu;
        BizCurrency tkgannyukyhntgk;

        for (int idx = 0; idx < size; idx++) {

            syouhnCds[idx]             = kykSyouhnLst.get(idx).getSyouhncd();
            syouhnSdNos[idx]           = kykSyouhnLst.get(idx).getSyouhnsdno();
            renNos[idx]                = kykSyouhnLst.get(idx).getKyksyouhnrenno();
            syouhnNms[idx]             = kykSyouhnLst.get(idx).getSyouhnZokusei().getSyouhnnm();
            kykJyoutai[idx]            = kykSyouhnLst.get(idx).getKykjyoutai();
            kouyokuHasseiYmds[idx]     = kykSyouhnLst.get(idx).getKouryokuhasseiymd();
            kykYmds[idx]               = kykSyouhnLst.get(idx).getKykymd();
            sknnKsYmds[idx]            = kykSyouhnLst.get(idx).getSknnkaisiymd();
            hhknNens[idx]              = kykSyouhnLst.get(idx).getHhknnen();
            haraimanYmds[idx]          = kykSyouhnLst.get(idx).getHaraimanymd();
            hknkknManryouYmds[idx]     = kykSyouhnLst.get(idx).getHknkknmanryouymd();
            kataKbns[idx]              = kykSyouhnLst.get(idx).getKatakbn();
            kyhGndKataKbns[idx]        = kykSyouhnLst.get(idx).getKyhgndkatakbn();
            hknKkns[idx]               = kykSyouhnLst.get(idx).getHknkkn();
            hknKknSmnKbns[idx]         = kykSyouhnLst.get(idx).getHknkknsmnkbn();
            hrkKkns[idx]               = kykSyouhnLst.get(idx).getHrkkkn();
            hrkKknSmnKbns[idx]         = kykSyouhnLst.get(idx).getHrkkknsmnkbn();
            kihonSs[idx]               = kykSyouhnLst.get(idx).getKihons();
            premiums[idx]              = kykSyouhnLst.get(idx).getHokenryou();
            nkKknUmus[idx]             = kykSyouhnLst.get(idx).getSyouhnZokusei().getNkhknumu();
            kihonSSyuruiKbns[idx]      = kykSyouhnLst.get(idx).getSyouhnZokusei().getKihonssyuruikbn();
            tsnshrgndgkhyoujiumus[idx] = kykSyouhnLst.get(idx).getSyouhnZokusei().getTsnshrgndgkhyoujiumu();
            tsnshrgndgks[idx]          = kykSyouhnLst.get(idx).getSyouhnZokusei().getTsnshrgndgk();
            gansknnkaisiymds[idx]      = kykSyouhnLst.get(idx).getGansknnkaisiymd();
            hkSknnKsYmds[idx]          = kykSyouhnLst.get(idx).getHksknnkaisiymd();
            hkGansknnkaisiymds[idx]    = kykSyouhnLst.get(idx).getHkgansknnkaisiymd();
            khnKyhKgBairituKbns[idx]   = kykSyouhnLst.get(idx).getKhnkyhkgbairitukbn();
            syuKyhkinkataKbns[idx]     = kykSyouhnLst.get(idx).getSyukyhkinkatakbn();
            lokuDaiSktsyknTuikaKyhkataKbns[idx] = kykSyouhnLst.get(idx).getRokudaildkbn();
            pmnjTkKbns[idx]            = kykSyouhnLst.get(idx).getPmnjtkkbn();
            tuukasyu[idx]              = kykSyouhnLst.get(idx).getKyktuukasyu();
            nkSyus[idx]                = kykSyouhnLst.get(idx).getNksyukbn();
            nkKkns[idx]                = kykSyouhnLst.get(idx).getNenkinkkn();
            tkgannyukyhumu = kykSyouhnLst.get(idx).getSyouhnZokusei().getGannyukyhumu();
            tksynndkyfknshrskgnumus[idx] = kykSyouhnLst.get(idx).getSyouhnZokusei().getSynndkyfknshrskgnumu();
            tksiharaisakugenStartYmds[idx] = null;
            tksiharaisakugenEndYmds[idx] = null;
            tkshrskgngoss[idx] = BizCurrency.valueOf(0);
            tkkostratkiumus[idx] = kykSyouhnLst.get(idx).getSyouhnZokusei().getKostratkiumu();
            tkhknkknsmnkbn = kykSyouhnLst.get(idx).getHknkknsmnkbn();
            tkkousinkaisuu = 0;
            tkjikaikousingops[idx] = BizCurrency.valueOf(0);
            tkjikaikousinumus[idx] = C_UmuKbn.NONE;
            dsyuhghkumu[idx] = kykSyouhnLst.get(idx).getSyouhnZokusei().getHengakuumu();

            tkgannyukyhntgk = BizCurrency.valueOf(0);

            gannyukyhumus[idx]      = tkgannyukyhumu;
            gannyukyhntgks[idx]     = tkgannyukyhntgk;

            if (C_UmuKbn.ARI.eq(tksynndkyfknshrskgnumus[idx])){
                tksiharaisakugenStartYmds[idx] = kykSyouhnLst.get(idx).getSknnkaisiymd();
                BizDate keisanYmd = kykSyouhnLst.get(idx).getKykymd();
                BizDateSpan periodYMD = new BizDateSpan(1, 0, 0);
                keisanYmd = keisanYmd.add(periodYMD).getRekijyou();
                keisanYmd = keisanYmd.getPreviousDay();
                tksiharaisakugenEndYmds[idx] = keisanYmd;
                tkshrskgngoss[idx] = kykSyouhnLst.get(idx).getKihons()
                    .multiplyCurrency(BizCurrency.valueOf(0.5)).round(0, RoundingMode.DOWN);
            }

            if (C_UmuKbn.ARI.eq(tkkostratkiumus[idx]) && C_HknkknsmnKbn.NENMANKI.eq(tkhknkknsmnkbn)) {

                SyouhntaniKousingoPkeisan syouhntaniKosgoPkeisan =
                    SWAKInjector.getInstance(SyouhntaniKousingoPkeisan.class);

                syouhntaniKosgoPkeisan.setSyouhncd(kykSyouhnLst.get(idx).getSyouhncd());
                syouhntaniKosgoPkeisan.setSyouhnSdno(kykSyouhnLst.get(idx).getSyouhnsdno());
                syouhntaniKosgoPkeisan.setKeiyakubi(kykSyouhnLst.get(idx).getKykymd());
                syouhntaniKosgoPkeisan.setKatakbn(kykSyouhnLst.get(idx).getKatakbn());
                syouhntaniKosgoPkeisan.setKyhgndKatakbn(kykSyouhnLst.get(idx).getKyhgndkatakbn());
                syouhntaniKosgoPkeisan.setSyukyhkinKatakbn(kykSyouhnLst.get(idx).getSyukyhkinkatakbn());
                syouhntaniKosgoPkeisan.setKhnkyhkgbairituKbn(kykSyouhnLst.get(idx).getKhnkyhkgbairitukbn());
                syouhntaniKosgoPkeisan.set6DaisktsyknTuikakyhKatakbn(kykSyouhnLst.get(idx).getRokudaildkbn());
                syouhntaniKosgoPkeisan.setPmnjtkhukaKbn(kykSyouhnLst.get(idx).getPmnjtkkbn());
                syouhntaniKosgoPkeisan.setHknkknSmnkbn(kykSyouhnLst.get(idx).getHknkknsmnkbn());
                syouhntaniKosgoPkeisan.setHknkkn(kykSyouhnLst.get(idx).getHknkkn());
                syouhntaniKosgoPkeisan.setHrkkknSmnkbn(kykSyouhnLst.get(idx).getHrkkknsmnkbn());
                syouhntaniKosgoPkeisan.setHrkkkn(kykSyouhnLst.get(idx).getHrkkkn());
                syouhntaniKosgoPkeisan.setHhknNen(kykSyouhnLst.get(idx).getHhknnen());
                syouhntaniKosgoPkeisan.setHhknSei(hhknSya.getHhknsei());
                syouhntaniKosgoPkeisan.setHrkKaisuu(kykKihon.getHrkkaisuu());
                syouhntaniKosgoPkeisan.setHrkKeiro(kykKihon.getHrkkeiro());
                syouhntaniKosgoPkeisan.setSdPdKbn(C_Sdpd.SD);
                syouhntaniKosgoPkeisan.setS(kykSyouhnLst.get(idx).getKihons());

                syouhntaniKosgoPkeisan.exec();

                tkkousinkaisuu = syouhntaniKosgoPkeisan.getKoskaisu();
                if (tkkousinkaisuu > 0) {
                    tkjikaikousinumus[idx] = C_UmuKbn.ARI;
                    if (C_Kykjyoutai.PMEN.eq(kykJyoutai[idx])){
                        tkjikaikousingops[idx] = BizCurrency.valueOf(0);
                    }
                    else{
                        tkjikaikousingops[idx] = syouhntaniKosgoPkeisan.getKosnaiymeiskmk()[0].getHknry();
                    }
                }
            }

            tokujyou = pKCParm.getSyouhinTokujyou(syoNo, C_SyutkKbn.TK,
                syouhnCds[idx], syouhnSdNos[idx], renNos[idx]);

            hokenNendoStartYmd1s[idx] = null;
            hokenNendoEndYmd1s[idx] = null;
            skgn1s[idx] = BizCurrency.valueOf(0);
            hokenNendoStartYmd2s[idx] = null;
            hokenNendoEndYmd2s[idx] = null;
            skgn2s[idx] = BizCurrency.valueOf(0);
            hokenNendoStartYmd3s[idx] = null;
            hokenNendoEndYmd3s[idx] = null;
            skgn3s[idx] = BizCurrency.valueOf(0);
            hokenNendoStartYmd4s[idx] = null;
            hokenNendoEndYmd4s[idx] = null;
            skgn4s[idx] = BizCurrency.valueOf(0);
            hokenNendoStartYmd5s[idx] = null;
            hokenNendoEndYmd5s[idx] = null;
            skgn5s[idx] = BizCurrency.valueOf(0);

            if (tokujyou == null) {
                tkjyskgnKkns[idx] = C_Tkjyskgnkkn.BLNK;
                tkjyHyoutens[idx] = C_Tkjyhyouten.BLNK;
                tkjyPs[idx]       = BizCurrency.valueOf(0);
                htnpBuiCd1s[idx]  = BLANK;
                htnpBuiNm1s[idx]  = BLANK;
                htnpKkn1s[idx]    = C_Htnpkkn.BLNK;
                htnpBuiCd2s[idx]  = BLANK;
                htnpBuiNm2s[idx]  = BLANK;
                htnpKkn2s[idx]    = C_Htnpkkn.BLNK;
                htnpBuiCd3s[idx]  = BLANK;
                htnpBuiNm3s[idx]  = BLANK;
                htnpKkn3s[idx]    = C_Htnpkkn.BLNK;
                htnpBuiCd4s[idx]  = BLANK;
                htnpBuiNm4s[idx]  = BLANK;
                htnpKkn4s[idx]    = C_Htnpkkn.BLNK;
                tokKoudoSgHtnpKbns[idx] = C_TokkoudosghtnpKbn.BLNK;
            }
            else {
                tkjyskgnKkns[idx] = tokujyou.getTkjyskgnkkn();
                tkjyHyoutens[idx] = tokujyou.getTkjyhyouten();
                tkjyPs[idx]       = tokujyou.getTkjyp();

                hutanpoBui1 = pKCParm.getHutanpoBui(tokujyou.getHtnpbuicd1());
                if (hutanpoBui1 == null) {
                    htnpBuiCd1s[idx] = BLANK;
                    htnpBuiNm1s[idx] = BLANK;
                }
                else {
                    htnpBuiCd1s[idx]  = tokujyou.getHtnpbuicd1();
                    htnpBuiNm1s[idx] = hutanpoBui1.getHtnpbuinm();
                }
                htnpKkn1s[idx]   = tokujyou.getHtnpkkn1();

                hutanpoBui2 = pKCParm.getHutanpoBui(tokujyou.getHtnpbuicd2());
                if (hutanpoBui2 == null) {
                    htnpBuiCd2s[idx] = BLANK;
                    htnpBuiNm2s[idx] = BLANK;
                }
                else {
                    htnpBuiCd2s[idx] = tokujyou.getHtnpbuicd2();
                    htnpBuiNm2s[idx] = hutanpoBui2.getHtnpbuinm();
                }
                htnpKkn2s[idx] = tokujyou.getHtnpkkn2();

                hutanpoBui3 = pKCParm.getHutanpoBui(tokujyou.getHtnpbuicd3());
                if (hutanpoBui3 == null) {
                    htnpBuiCd3s[idx] = BLANK;
                    htnpBuiNm3s[idx] = BLANK;
                }
                else {
                    htnpBuiCd3s[idx] = tokujyou.getHtnpbuicd3();
                    htnpBuiNm3s[idx] = hutanpoBui3.getHtnpbuinm();
                }
                htnpKkn3s[idx] = tokujyou.getHtnpkkn3();

                hutanpoBui4 = pKCParm.getHutanpoBui(tokujyou.getHtnpbuicd4());
                if (hutanpoBui4 == null) {
                    htnpBuiCd4s[idx] = BLANK;
                    htnpBuiNm4s[idx] = BLANK;
                }
                else {
                    htnpBuiCd4s[idx] = tokujyou.getHtnpbuicd4();
                    htnpBuiNm4s[idx] = hutanpoBui4.getHtnpbuinm();
                }
                htnpKkn4s[idx] = tokujyou.getHtnpkkn4();
                tokKoudoSgHtnpKbns[idx] = tokujyou.getTokkoudosghtnpkbn();

                C_Tkjyskgnkkn tkjyskgnkkn = tokujyou.getTkjyskgnkkn();
                if (!C_Tkjyskgnkkn.BLNK.eq(tkjyskgnkkn)) {

                    TokujoSSakugenNaiyouKeisan tokujoSSakugenNaiyouKs =
                        SWAKInjector.getInstance(TokujoSSakugenNaiyouKeisan.class);

                    tokujoSSakugenNaiyouKs.setSyouhncd(kykSyouhnLst.get(idx).getSyouhncd());
                    tokujoSSakugenNaiyouKs.setSyouhnSdno(kykSyouhnLst.get(idx).getSyouhnsdno());
                    tokujoSSakugenNaiyouKs.setKykbi(kykSyouhnLst.get(idx).getKykymd());
                    tokujoSSakugenNaiyouKs.setSknnKaisibi(kykSyouhnLst.get(idx).getSknnkaisiymd());
                    tokujoSSakugenNaiyouKs.setTkjSkgnKkn(tkjyskgnkkn);
                    tokujoSSakugenNaiyouKs.setS(kykSyouhnLst.get(idx).getKihons());

                    tokujoSSakugenNaiyouKs.exec();

                    if (Integer.parseInt(tkjyskgnkkn.getValue()) > 0) {
                        hokenNendoStartYmd1s[idx] = tokujoSSakugenNaiyouKs.getSsakugenBeans()[0].getStartNendoYmd();
                        hokenNendoEndYmd1s[idx] = tokujoSSakugenNaiyouKs.getSsakugenBeans()[0].getEndNendoYmd();
                        skgn1s[idx] = tokujoSSakugenNaiyouKs.getSsakugenBeans()[0].getS();
                    }
                    if (Integer.parseInt(tkjyskgnkkn.getValue()) > 1) {
                        hokenNendoStartYmd2s[idx] = tokujoSSakugenNaiyouKs.getSsakugenBeans()[1].getStartNendoYmd();
                        hokenNendoEndYmd2s[idx] = tokujoSSakugenNaiyouKs.getSsakugenBeans()[1].getEndNendoYmd();
                        skgn2s[idx] = tokujoSSakugenNaiyouKs.getSsakugenBeans()[1].getS();
                    }
                    if (Integer.parseInt(tkjyskgnkkn.getValue()) > 2) {
                        hokenNendoStartYmd3s[idx] = tokujoSSakugenNaiyouKs.getSsakugenBeans()[2].getStartNendoYmd();
                        hokenNendoEndYmd3s[idx] = tokujoSSakugenNaiyouKs.getSsakugenBeans()[2].getEndNendoYmd();
                        skgn3s[idx] = tokujoSSakugenNaiyouKs.getSsakugenBeans()[2].getS();
                    }
                    if (Integer.parseInt(tkjyskgnkkn.getValue()) > 3) {
                        hokenNendoStartYmd4s[idx] = tokujoSSakugenNaiyouKs.getSsakugenBeans()[3].getStartNendoYmd();
                        hokenNendoEndYmd4s[idx] = tokujoSSakugenNaiyouKs.getSsakugenBeans()[3].getEndNendoYmd();
                        skgn4s[idx] = tokujoSSakugenNaiyouKs.getSsakugenBeans()[3].getS();
                    }
                    if (Integer.parseInt(tkjyskgnkkn.getValue()) > 4) {
                        hokenNendoStartYmd5s[idx] = tokujoSSakugenNaiyouKs.getSsakugenBeans()[4].getStartNendoYmd();
                        hokenNendoEndYmd5s[idx] = tokujoSSakugenNaiyouKs.getSsakugenBeans()[4].getEndNendoYmd();
                        skgn5s[idx] = tokujoSSakugenNaiyouKs.getSsakugenBeans()[4].getS();
                    }
                }
            }
        }

        for (int index = 0; index < size; index++) {

            if(index == 0){
                pUiBean.setVhsyudisptksyouhncd1(syouhnCds[index]);
                pUiBean.setVhsyudisptksyouhnnm1(syouhnNms[index]);
                pUiBean.setVhsyudisptkktuukasyu1(tuukasyu[index]);
                pUiBean.setVhsyudisptokyakukatakbn1(kataKbns[index]);
                pUiBean.setVhsyudisptkkyhgdkatakbn1(kyhGndKataKbns[index]);
                pUiBean.setVhsyudisptkhhknnen1(hhknNens[index]);
                pUiBean.setVhsyudisptkkykymd1(kykYmds[index]);
                pUiBean.setVhsyudisptksknnkaisiymd1(sknnKsYmds[index]);
                pUiBean.setVhsyudisptkgaskkaisiymd1(gansknnkaisiymds[index]);
                pUiBean.setVhsyudisptkhkskkaisiymd1(hkSknnKsYmds[index]);
                pUiBean.setVhsyudisptkhkgskksiymd1(hkGansknnkaisiymds[index]);
                pUiBean.setVhsyudisptkhknkkn1(hknKkns[index]);
                pUiBean.setVhsyudisptkhknkknsmnkbn1(hknKknSmnKbns[index]);
                pUiBean.setVhsyudisptkhrkkkn1(hrkKkns[index]);
                pUiBean.setVhsyudisptkhrkkknsmnkbn1(hrkKknSmnKbns[index]);
                pUiBean.setVhsyudisptkkihsyuruikbn1(kihonSSyuruiKbns[index]);
                pUiBean.setVhsyudisptkkihons1(kihonSs[index]);
                pUiBean.setVhsyudisptkp1(premiums[index]);
                pUiBean.setVhsyudisptkkihonkyhgk1(kihonSs[index].multiply(
                    Integer.parseInt(khnKyhKgBairituKbns[index].getValue())));
                pUiBean.setVhsyudisptknextkosgop1(tkjikaikousingops[index]);
                pUiBean.setVhsyudisptksykyhkatakbn1(syuKyhkinkataKbns[index]);
                pUiBean.setVhsyudisptk6daildkbn1(lokuDaiSktsyknTuikaKyhkataKbns[index]);
                pUiBean.setVhsyudisptkganyukyhntgk1(gannyukyhntgks[index]);
                pUiBean.setVhsyudisptkshrskgstrymd1(tksiharaisakugenStartYmds[index]);
                pUiBean.setVhsyudisptkshrskgnedymd1(tksiharaisakugenEndYmds[index]);
                pUiBean.setVhsyudisptkshrskgngos1(tkshrskgngoss[index]);
                pUiBean.setVhsyudisptknenkinsyukbn1(nkSyus[index]);
                pUiBean.setVhsyudisptknenkinkkn1(nkKkns[index]);
                pUiBean.setVhsyudisptktkjyskgnkkn1(tkjyskgnKkns[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd11(hokenNendoStartYmd1s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd11(hokenNendoEndYmd1s[index]);
                pUiBean.setVhsyudisptktkjyskgns11(skgn1s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd21(hokenNendoStartYmd2s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd21(hokenNendoEndYmd2s[index]);
                pUiBean.setVhsyudisptktkjyskgns21(skgn2s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd31(hokenNendoStartYmd3s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd31(hokenNendoEndYmd3s[index]);
                pUiBean.setVhsyudisptktkjyskgns31(skgn3s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd41(hokenNendoStartYmd4s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd41(hokenNendoEndYmd4s[index]);
                pUiBean.setVhsyudisptktkjyskgns41(skgn4s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd51(hokenNendoStartYmd5s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd51(hokenNendoEndYmd5s[index]);
                pUiBean.setVhsyudisptktkjyskgns51(skgn5s[index]);
                pUiBean.setVhsyudisptktkjyhyouten1(tkjyHyoutens[index]);
                pUiBean.setVhsyudisptktkjyp1(tkjyPs[index]);
                pUiBean.setVhsyudisptkhtnpbuicd11(htnpBuiCd1s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm11(htnpBuiNm1s[index]);
                pUiBean.setVhsyudisptkhtnpkkn11(htnpKkn1s[index]);
                pUiBean.setVhsyudisptkhtnpbuicd21(htnpBuiCd2s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm21(htnpBuiNm2s[index]);
                pUiBean.setVhsyudisptkhtnpkkn21(htnpKkn2s[index]);
                pUiBean.setVhsyudisptkhtnpbuicd31(htnpBuiCd3s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm31(htnpBuiNm3s[index]);
                pUiBean.setVhsyudisptkhtnpkkn31(htnpKkn3s[index]);
                pUiBean.setVhsyudisptkhtnpbuicd41(htnpBuiCd4s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm41(htnpBuiNm4s[index]);
                pUiBean.setVhsyudisptkhtnpkkn41(htnpKkn4s[index]);
                pUiBean.setVhsyudisptktkkdsghtpkbn1(tokKoudoSgHtnpKbns[index]);
                pUiBean.setVhsyudisptktutakngk1(BizCurrency.valueOf(0));
                pUiBean.setVhsyudisptkkrkhasseiymd1(kouyokuHasseiYmds[index]);
                pUiBean.setVhsyudisptknkhknumu1(nkKknUmus[index]);
                pUiBean.setVhsyudisptkgannyukyhumu1(gannyukyhumus[index]);
                pUiBean.setVhsyudisptkkgbairitukbn1(khnKyhKgBairituKbns[index]);
                pUiBean.setVhsyudisptksndkyhkinshrskgnumu1(tksynndkyfknshrskgnumus[index]);
                pUiBean.setVhsyudisptknextkosumu1(tkjikaikousinumus[index]);
                pUiBean.setVhsyudisptktsnshrgndhjumu1(tsnshrgndgkhyoujiumus[index]);
                pUiBean.setVhsyudisptktsnshrgndgk1(tsnshrgndgks[index]);
                pUiBean.setVhsyudisptkhghkumu1(dsyuhghkumu[index]);
            }

            if(index == 1){
                pUiBean.setVhsyudisptksyouhncd2(syouhnCds[index]);
                pUiBean.setVhsyudisptksyouhnnm2(syouhnNms[index]);
                pUiBean.setVhsyudisptkktuukasyu2(tuukasyu[index]);
                pUiBean.setVhsyudisptokyakukatakbn2(kataKbns[index]);
                pUiBean.setVhsyudisptkkyhgdkatakbn2(kyhGndKataKbns[index]);
                pUiBean.setVhsyudisptkhhknnen2(hhknNens[index]);
                pUiBean.setVhsyudisptkkykymd2(kykYmds[index]);
                pUiBean.setVhsyudisptksknnkaisiymd2(sknnKsYmds[index]);
                pUiBean.setVhsyudisptkgaskkaisiymd2(gansknnkaisiymds[index]);
                pUiBean.setVhsyudisptkhkskkaisiymd2(hkSknnKsYmds[index]);
                pUiBean.setVhsyudisptkhkgskksiymd2(hkGansknnkaisiymds[index]);
                pUiBean.setVhsyudisptkhknkkn2(hknKkns[index]);
                pUiBean.setVhsyudisptkhknkknsmnkbn2(hknKknSmnKbns[index]);
                pUiBean.setVhsyudisptkhrkkkn2(hrkKkns[index]);
                pUiBean.setVhsyudisptkhrkkknsmnkbn2(hrkKknSmnKbns[index]);
                pUiBean.setVhsyudisptkkihsyuruikbn2(kihonSSyuruiKbns[index]);
                pUiBean.setVhsyudisptkkihons2(kihonSs[index]);
                pUiBean.setVhsyudisptkp2(premiums[index]);
                pUiBean.setVhsyudisptkkihonkyhgk2(kihonSs[index].multiply(
                    Integer.parseInt(khnKyhKgBairituKbns[index].getValue())));
                pUiBean.setVhsyudisptknextkosgop2(tkjikaikousingops[index]);
                pUiBean.setVhsyudisptksykyhkatakbn2(syuKyhkinkataKbns[index]);
                pUiBean.setVhsyudisptk6daildkbn2(lokuDaiSktsyknTuikaKyhkataKbns[index]);
                pUiBean.setVhsyudisptkganyukyhntgk2(gannyukyhntgks[index]);
                pUiBean.setVhsyudisptkshrskgstrymd2(tksiharaisakugenStartYmds[index]);
                pUiBean.setVhsyudisptkshrskgnedymd2(tksiharaisakugenEndYmds[index]);
                pUiBean.setVhsyudisptkshrskgngos2(tkshrskgngoss[index]);
                pUiBean.setVhsyudisptknenkinsyukbn2(nkSyus[index]);
                pUiBean.setVhsyudisptknenkinkkn2(nkKkns[index]);
                pUiBean.setVhsyudisptktkjyskgnkkn2(tkjyskgnKkns[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd12(hokenNendoStartYmd1s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd12(hokenNendoEndYmd1s[index]);
                pUiBean.setVhsyudisptktkjyskgns12(skgn1s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd22(hokenNendoStartYmd2s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd22(hokenNendoEndYmd2s[index]);
                pUiBean.setVhsyudisptktkjyskgns22(skgn2s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd32(hokenNendoStartYmd3s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd32(hokenNendoEndYmd3s[index]);
                pUiBean.setVhsyudisptktkjyskgns32(skgn3s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd42(hokenNendoStartYmd4s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd42(hokenNendoEndYmd4s[index]);
                pUiBean.setVhsyudisptktkjyskgns42(skgn4s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd52(hokenNendoStartYmd5s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd52(hokenNendoEndYmd5s[index]);
                pUiBean.setVhsyudisptktkjyskgns52(skgn5s[index]);
                pUiBean.setVhsyudisptktkjyhyouten2(tkjyHyoutens[index]);
                pUiBean.setVhsyudisptktkjyp2(tkjyPs[index]);
                pUiBean.setVhsyudisptkhtnpbuicd12(htnpBuiCd1s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm12(htnpBuiNm1s[index]);
                pUiBean.setVhsyudisptkhtnpkkn12(htnpKkn1s[index]);
                pUiBean.setVhsyudisptkhtnpbuicd22(htnpBuiCd2s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm22(htnpBuiNm2s[index]);
                pUiBean.setVhsyudisptkhtnpkkn22(htnpKkn2s[index]);
                pUiBean.setVhsyudisptkhtnpbuicd32(htnpBuiCd3s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm32(htnpBuiNm3s[index]);
                pUiBean.setVhsyudisptkhtnpkkn32(htnpKkn3s[index]);
                pUiBean.setVhsyudisptkhtnpbuicd42(htnpBuiCd4s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm42(htnpBuiNm4s[index]);
                pUiBean.setVhsyudisptkhtnpkkn42(htnpKkn4s[index]);
                pUiBean.setVhsyudisptktkkdsghtpkbn2(tokKoudoSgHtnpKbns[index]);
                pUiBean.setVhsyudisptktutakngk2(BizCurrency.valueOf(0));
                pUiBean.setVhsyudisptkkrkhasseiymd2(kouyokuHasseiYmds[index]);
                pUiBean.setVhsyudisptknkhknumu2(nkKknUmus[index]);
                pUiBean.setVhsyudisptkgannyukyhumu2(gannyukyhumus[index]);
                pUiBean.setVhsyudisptkkgbairitukbn2(khnKyhKgBairituKbns[index]);
                pUiBean.setVhsyudisptksndkyhkinshrskgnumu2(tksynndkyfknshrskgnumus[index]);
                pUiBean.setVhsyudisptknextkosumu2(tkjikaikousinumus[index]);
                pUiBean.setVhsyudisptktsnshrgndhjumu2(tsnshrgndgkhyoujiumus[index]);
                pUiBean.setVhsyudisptktsnshrgndgk2(tsnshrgndgks[index]);
                pUiBean.setVhsyudisptkhghkumu2(dsyuhghkumu[index]);
            }

            if(index == 2){
                pUiBean.setVhsyudisptksyouhncd3(syouhnCds[index]);
                pUiBean.setVhsyudisptksyouhnnm3(syouhnNms[index]);
                pUiBean.setVhsyudisptkktuukasyu3(tuukasyu[index]);
                pUiBean.setVhsyudisptokyakukatakbn3(kataKbns[index]);
                pUiBean.setVhsyudisptkkyhgdkatakbn3(kyhGndKataKbns[index]);
                pUiBean.setVhsyudisptkhhknnen3(hhknNens[index]);
                pUiBean.setVhsyudisptkkykymd3(kykYmds[index]);
                pUiBean.setVhsyudisptksknnkaisiymd3(sknnKsYmds[index]);
                pUiBean.setVhsyudisptkgaskkaisiymd3(gansknnkaisiymds[index]);
                pUiBean.setVhsyudisptkhkskkaisiymd3(hkSknnKsYmds[index]);
                pUiBean.setVhsyudisptkhkgskksiymd3(hkGansknnkaisiymds[index]);
                pUiBean.setVhsyudisptkhknkkn3(hknKkns[index]);
                pUiBean.setVhsyudisptkhknkknsmnkbn3(hknKknSmnKbns[index]);
                pUiBean.setVhsyudisptkhrkkkn3(hrkKkns[index]);
                pUiBean.setVhsyudisptkhrkkknsmnkbn3(hrkKknSmnKbns[index]);
                pUiBean.setVhsyudisptkkihsyuruikbn3(kihonSSyuruiKbns[index]);
                pUiBean.setVhsyudisptkkihons3(kihonSs[index]);
                pUiBean.setVhsyudisptkp3(premiums[index]);
                pUiBean.setVhsyudisptkkihonkyhgk3(kihonSs[index].multiply(
                    Integer.parseInt(khnKyhKgBairituKbns[index].getValue())));
                pUiBean.setVhsyudisptknextkosgop3(tkjikaikousingops[index]);
                pUiBean.setVhsyudisptksykyhkatakbn3(syuKyhkinkataKbns[index]);
                pUiBean.setVhsyudisptk6daildkbn3(lokuDaiSktsyknTuikaKyhkataKbns[index]);
                pUiBean.setVhsyudisptkganyukyhntgk3(gannyukyhntgks[index]);
                pUiBean.setVhsyudisptkshrskgstrymd3(tksiharaisakugenStartYmds[index]);
                pUiBean.setVhsyudisptkshrskgnedymd3(tksiharaisakugenEndYmds[index]);
                pUiBean.setVhsyudisptkshrskgngos3(tkshrskgngoss[index]);
                pUiBean.setVhsyudisptknenkinsyukbn3(nkSyus[index]);
                pUiBean.setVhsyudisptknenkinkkn3(nkKkns[index]);
                pUiBean.setVhsyudisptktkjyskgnkkn3(tkjyskgnKkns[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd13(hokenNendoStartYmd1s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd13(hokenNendoEndYmd1s[index]);
                pUiBean.setVhsyudisptktkjyskgns13(skgn1s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd23(hokenNendoStartYmd2s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd23(hokenNendoEndYmd2s[index]);
                pUiBean.setVhsyudisptktkjyskgns23(skgn2s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd33(hokenNendoStartYmd3s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd33(hokenNendoEndYmd3s[index]);
                pUiBean.setVhsyudisptktkjyskgns33(skgn3s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd43(hokenNendoStartYmd4s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd43(hokenNendoEndYmd4s[index]);
                pUiBean.setVhsyudisptktkjyskgns43(skgn4s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd53(hokenNendoStartYmd5s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd53(hokenNendoEndYmd5s[index]);
                pUiBean.setVhsyudisptktkjyskgns53(skgn5s[index]);
                pUiBean.setVhsyudisptktkjyhyouten3(tkjyHyoutens[index]);
                pUiBean.setVhsyudisptktkjyp3(tkjyPs[index]);
                pUiBean.setVhsyudisptkhtnpbuicd13(htnpBuiCd1s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm13(htnpBuiNm1s[index]);
                pUiBean.setVhsyudisptkhtnpkkn13(htnpKkn1s[index]);
                pUiBean.setVhsyudisptkhtnpbuicd23(htnpBuiCd2s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm23(htnpBuiNm2s[index]);
                pUiBean.setVhsyudisptkhtnpkkn23(htnpKkn2s[index]);
                pUiBean.setVhsyudisptkhtnpbuicd33(htnpBuiCd3s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm33(htnpBuiNm3s[index]);
                pUiBean.setVhsyudisptkhtnpkkn33(htnpKkn3s[index]);
                pUiBean.setVhsyudisptkhtnpbuicd43(htnpBuiCd4s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm43(htnpBuiNm4s[index]);
                pUiBean.setVhsyudisptkhtnpkkn43(htnpKkn4s[index]);
                pUiBean.setVhsyudisptktkkdsghtpkbn3(tokKoudoSgHtnpKbns[index]);
                pUiBean.setVhsyudisptktutakngk3(BizCurrency.valueOf(0));
                pUiBean.setVhsyudisptkkrkhasseiymd3(kouyokuHasseiYmds[index]);
                pUiBean.setVhsyudisptknkhknumu3(nkKknUmus[index]);
                pUiBean.setVhsyudisptkgannyukyhumu3(gannyukyhumus[index]);
                pUiBean.setVhsyudisptkkgbairitukbn3(khnKyhKgBairituKbns[index]);
                pUiBean.setVhsyudisptksndkyhkinshrskgnumu3(tksynndkyfknshrskgnumus[index]);
                pUiBean.setVhsyudisptknextkosumu3(tkjikaikousinumus[index]);
                pUiBean.setVhsyudisptktsnshrgndhjumu3(tsnshrgndgkhyoujiumus[index]);
                pUiBean.setVhsyudisptktsnshrgndgk3(tsnshrgndgks[index]);
                pUiBean.setVhsyudisptkhghkumu3(dsyuhghkumu[index]);
            }

            if(index == 3){
                pUiBean.setVhsyudisptksyouhncd4(syouhnCds[index]);
                pUiBean.setVhsyudisptksyouhnnm4(syouhnNms[index]);
                pUiBean.setVhsyudisptkktuukasyu4(tuukasyu[index]);
                pUiBean.setVhsyudisptokyakukatakbn4(kataKbns[index]);
                pUiBean.setVhsyudisptkkyhgdkatakbn4(kyhGndKataKbns[index]);
                pUiBean.setVhsyudisptkhhknnen4(hhknNens[index]);
                pUiBean.setVhsyudisptkkykymd4(kykYmds[index]);
                pUiBean.setVhsyudisptksknnkaisiymd4(sknnKsYmds[index]);
                pUiBean.setVhsyudisptkgaskkaisiymd4(gansknnkaisiymds[index]);
                pUiBean.setVhsyudisptkhkskkaisiymd4(hkSknnKsYmds[index]);
                pUiBean.setVhsyudisptkhkgskksiymd4(hkGansknnkaisiymds[index]);
                pUiBean.setVhsyudisptkhknkkn4(hknKkns[index]);
                pUiBean.setVhsyudisptkhknkknsmnkbn4(hknKknSmnKbns[index]);
                pUiBean.setVhsyudisptkhrkkkn4(hrkKkns[index]);
                pUiBean.setVhsyudisptkhrkkknsmnkbn4(hrkKknSmnKbns[index]);
                pUiBean.setVhsyudisptkkihsyuruikbn4(kihonSSyuruiKbns[index]);
                pUiBean.setVhsyudisptkkihons4(kihonSs[index]);
                pUiBean.setVhsyudisptkp4(premiums[index]);
                pUiBean.setVhsyudisptkkihonkyhgk4(kihonSs[index].multiply(
                    Integer.parseInt(khnKyhKgBairituKbns[index].getValue())));
                pUiBean.setVhsyudisptknextkosgop4(tkjikaikousingops[index]);
                pUiBean.setVhsyudisptksykyhkatakbn4(syuKyhkinkataKbns[index]);
                pUiBean.setVhsyudisptk6daildkbn4(lokuDaiSktsyknTuikaKyhkataKbns[index]);
                pUiBean.setVhsyudisptkganyukyhntgk4(gannyukyhntgks[index]);
                pUiBean.setVhsyudisptkshrskgstrymd4(tksiharaisakugenStartYmds[index]);
                pUiBean.setVhsyudisptkshrskgnedymd4(tksiharaisakugenEndYmds[index]);
                pUiBean.setVhsyudisptkshrskgngos4(tkshrskgngoss[index]);
                pUiBean.setVhsyudisptknenkinsyukbn4(nkSyus[index]);
                pUiBean.setVhsyudisptknenkinkkn4(nkKkns[index]);
                pUiBean.setVhsyudisptktkjyskgnkkn4(tkjyskgnKkns[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd14(hokenNendoStartYmd1s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd14(hokenNendoEndYmd1s[index]);
                pUiBean.setVhsyudisptktkjyskgns14(skgn1s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd24(hokenNendoStartYmd2s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd24(hokenNendoEndYmd2s[index]);
                pUiBean.setVhsyudisptktkjyskgns24(skgn2s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd34(hokenNendoStartYmd3s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd34(hokenNendoEndYmd3s[index]);
                pUiBean.setVhsyudisptktkjyskgns34(skgn3s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd44(hokenNendoStartYmd4s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd44(hokenNendoEndYmd4s[index]);
                pUiBean.setVhsyudisptktkjyskgns44(skgn4s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd54(hokenNendoStartYmd5s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd54(hokenNendoEndYmd5s[index]);
                pUiBean.setVhsyudisptktkjyskgns54(skgn5s[index]);
                pUiBean.setVhsyudisptktkjyhyouten4(tkjyHyoutens[index]);
                pUiBean.setVhsyudisptktkjyp4(tkjyPs[index]);
                pUiBean.setVhsyudisptkhtnpbuicd14(htnpBuiCd1s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm14(htnpBuiNm1s[index]);
                pUiBean.setVhsyudisptkhtnpkkn14(htnpKkn1s[index]);
                pUiBean.setVhsyudisptkhtnpbuicd24(htnpBuiCd2s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm24(htnpBuiNm2s[index]);
                pUiBean.setVhsyudisptkhtnpkkn24(htnpKkn2s[index]);
                pUiBean.setVhsyudisptkhtnpbuicd34(htnpBuiCd3s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm34(htnpBuiNm3s[index]);
                pUiBean.setVhsyudisptkhtnpkkn34(htnpKkn3s[index]);
                pUiBean.setVhsyudisptkhtnpbuicd44(htnpBuiCd4s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm44(htnpBuiNm4s[index]);
                pUiBean.setVhsyudisptkhtnpkkn44(htnpKkn4s[index]);
                pUiBean.setVhsyudisptktkkdsghtpkbn4(tokKoudoSgHtnpKbns[index]);
                pUiBean.setVhsyudisptktutakngk4(BizCurrency.valueOf(0));
                pUiBean.setVhsyudisptkkrkhasseiymd4(kouyokuHasseiYmds[index]);
                pUiBean.setVhsyudisptknkhknumu4(nkKknUmus[index]);
                pUiBean.setVhsyudisptkgannyukyhumu4(gannyukyhumus[index]);
                pUiBean.setVhsyudisptkkgbairitukbn4(khnKyhKgBairituKbns[index]);
                pUiBean.setVhsyudisptksndkyhkinshrskgnumu4(tksynndkyfknshrskgnumus[index]);
                pUiBean.setVhsyudisptknextkosumu4(tkjikaikousinumus[index]);
                pUiBean.setVhsyudisptktsnshrgndhjumu4(tsnshrgndgkhyoujiumus[index]);
                pUiBean.setVhsyudisptktsnshrgndgk4(tsnshrgndgks[index]);
                pUiBean.setVhsyudisptkhghkumu4(dsyuhghkumu[index]);
            }

            if(index == 4){
                pUiBean.setVhsyudisptksyouhncd5(syouhnCds[index]);
                pUiBean.setVhsyudisptksyouhnnm5(syouhnNms[index]);
                pUiBean.setVhsyudisptkktuukasyu5(tuukasyu[index]);
                pUiBean.setVhsyudisptokyakukatakbn5(kataKbns[index]);
                pUiBean.setVhsyudisptkkyhgdkatakbn5(kyhGndKataKbns[index]);
                pUiBean.setVhsyudisptkhhknnen5(hhknNens[index]);
                pUiBean.setVhsyudisptkkykymd5(kykYmds[index]);
                pUiBean.setVhsyudisptksknnkaisiymd5(sknnKsYmds[index]);
                pUiBean.setVhsyudisptkgaskkaisiymd5(gansknnkaisiymds[index]);
                pUiBean.setVhsyudisptkhkskkaisiymd5(hkSknnKsYmds[index]);
                pUiBean.setVhsyudisptkhkgskksiymd5(hkGansknnkaisiymds[index]);
                pUiBean.setVhsyudisptkhknkkn5(hknKkns[index]);
                pUiBean.setVhsyudisptkhknkknsmnkbn5(hknKknSmnKbns[index]);
                pUiBean.setVhsyudisptkhrkkkn5(hrkKkns[index]);
                pUiBean.setVhsyudisptkhrkkknsmnkbn5(hrkKknSmnKbns[index]);
                pUiBean.setVhsyudisptkkihsyuruikbn5(kihonSSyuruiKbns[index]);
                pUiBean.setVhsyudisptkkihons5(kihonSs[index]);
                pUiBean.setVhsyudisptkp5(premiums[index]);
                pUiBean.setVhsyudisptkkihonkyhgk5(kihonSs[index].multiply(
                    Integer.parseInt(khnKyhKgBairituKbns[index].getValue())));
                pUiBean.setVhsyudisptknextkosgop5(tkjikaikousingops[index]);
                pUiBean.setVhsyudisptksykyhkatakbn5(syuKyhkinkataKbns[index]);
                pUiBean.setVhsyudisptk6daildkbn5(lokuDaiSktsyknTuikaKyhkataKbns[index]);
                pUiBean.setVhsyudisptkganyukyhntgk5(gannyukyhntgks[index]);
                pUiBean.setVhsyudisptkshrskgstrymd5(tksiharaisakugenStartYmds[index]);
                pUiBean.setVhsyudisptkshrskgnedymd5(tksiharaisakugenEndYmds[index]);
                pUiBean.setVhsyudisptkshrskgngos5(tkshrskgngoss[index]);
                pUiBean.setVhsyudisptknenkinsyukbn5(nkSyus[index]);
                pUiBean.setVhsyudisptknenkinkkn5(nkKkns[index]);
                pUiBean.setVhsyudisptktkjyskgnkkn5(tkjyskgnKkns[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd15(hokenNendoStartYmd1s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd15(hokenNendoEndYmd1s[index]);
                pUiBean.setVhsyudisptktkjyskgns15(skgn1s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd25(hokenNendoStartYmd2s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd25(hokenNendoEndYmd2s[index]);
                pUiBean.setVhsyudisptktkjyskgns25(skgn2s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd35(hokenNendoStartYmd3s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd35(hokenNendoEndYmd3s[index]);
                pUiBean.setVhsyudisptktkjyskgns35(skgn3s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd45(hokenNendoStartYmd4s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd45(hokenNendoEndYmd4s[index]);
                pUiBean.setVhsyudisptktkjyskgns45(skgn4s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd55(hokenNendoStartYmd5s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd55(hokenNendoEndYmd5s[index]);
                pUiBean.setVhsyudisptktkjyskgns55(skgn5s[index]);
                pUiBean.setVhsyudisptktkjyhyouten5(tkjyHyoutens[index]);
                pUiBean.setVhsyudisptktkjyp5(tkjyPs[index]);
                pUiBean.setVhsyudisptkhtnpbuicd15(htnpBuiCd1s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm15(htnpBuiNm1s[index]);
                pUiBean.setVhsyudisptkhtnpkkn15(htnpKkn1s[index]);
                pUiBean.setVhsyudisptkhtnpbuicd25(htnpBuiCd2s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm25(htnpBuiNm2s[index]);
                pUiBean.setVhsyudisptkhtnpkkn25(htnpKkn2s[index]);
                pUiBean.setVhsyudisptkhtnpbuicd35(htnpBuiCd3s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm35(htnpBuiNm3s[index]);
                pUiBean.setVhsyudisptkhtnpkkn35(htnpKkn3s[index]);
                pUiBean.setVhsyudisptkhtnpbuicd45(htnpBuiCd4s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm45(htnpBuiNm4s[index]);
                pUiBean.setVhsyudisptkhtnpkkn45(htnpKkn4s[index]);
                pUiBean.setVhsyudisptktkkdsghtpkbn5(tokKoudoSgHtnpKbns[index]);
                pUiBean.setVhsyudisptktutakngk5(BizCurrency.valueOf(0));
                pUiBean.setVhsyudisptkkrkhasseiymd5(kouyokuHasseiYmds[index]);
                pUiBean.setVhsyudisptknkhknumu5(nkKknUmus[index]);
                pUiBean.setVhsyudisptkgannyukyhumu5(gannyukyhumus[index]);
                pUiBean.setVhsyudisptkkgbairitukbn5(khnKyhKgBairituKbns[index]);
                pUiBean.setVhsyudisptksndkyhkinshrskgnumu5(tksynndkyfknshrskgnumus[index]);
                pUiBean.setVhsyudisptknextkosumu5(tkjikaikousinumus[index]);
                pUiBean.setVhsyudisptktsnshrgndhjumu5(tsnshrgndgkhyoujiumus[index]);
                pUiBean.setVhsyudisptktsnshrgndgk5(tsnshrgndgks[index]);
                pUiBean.setVhsyudisptkhghkumu5(dsyuhghkumu[index]);
            }

            if(index == 5){
                pUiBean.setVhsyudisptksyouhncd6(syouhnCds[index]);
                pUiBean.setVhsyudisptksyouhnnm6(syouhnNms[index]);
                pUiBean.setVhsyudisptkktuukasyu6(tuukasyu[index]);
                pUiBean.setVhsyudisptokyakukatakbn6(kataKbns[index]);
                pUiBean.setVhsyudisptkkyhgdkatakbn6(kyhGndKataKbns[index]);
                pUiBean.setVhsyudisptkhhknnen6(hhknNens[index]);
                pUiBean.setVhsyudisptkkykymd6(kykYmds[index]);
                pUiBean.setVhsyudisptksknnkaisiymd6(sknnKsYmds[index]);
                pUiBean.setVhsyudisptkgaskkaisiymd6(gansknnkaisiymds[index]);
                pUiBean.setVhsyudisptkhkskkaisiymd6(hkSknnKsYmds[index]);
                pUiBean.setVhsyudisptkhkgskksiymd6(hkGansknnkaisiymds[index]);
                pUiBean.setVhsyudisptkhknkkn6(hknKkns[index]);
                pUiBean.setVhsyudisptkhknkknsmnkbn6(hknKknSmnKbns[index]);
                pUiBean.setVhsyudisptkhrkkkn6(hrkKkns[index]);
                pUiBean.setVhsyudisptkhrkkknsmnkbn6(hrkKknSmnKbns[index]);
                pUiBean.setVhsyudisptkkihsyuruikbn6(kihonSSyuruiKbns[index]);
                pUiBean.setVhsyudisptkkihons6(kihonSs[index]);
                pUiBean.setVhsyudisptkp6(premiums[index]);
                pUiBean.setVhsyudisptkkihonkyhgk6(kihonSs[index].multiply(
                    Integer.parseInt(khnKyhKgBairituKbns[index].getValue())));
                pUiBean.setVhsyudisptknextkosgop6(tkjikaikousingops[index]);
                pUiBean.setVhsyudisptksykyhkatakbn6(syuKyhkinkataKbns[index]);
                pUiBean.setVhsyudisptk6daildkbn6(lokuDaiSktsyknTuikaKyhkataKbns[index]);
                pUiBean.setVhsyudisptkganyukyhntgk6(gannyukyhntgks[index]);
                pUiBean.setVhsyudisptkshrskgstrymd6(tksiharaisakugenStartYmds[index]);
                pUiBean.setVhsyudisptkshrskgnedymd6(tksiharaisakugenEndYmds[index]);
                pUiBean.setVhsyudisptkshrskgngos6(tkshrskgngoss[index]);
                pUiBean.setVhsyudisptknenkinsyukbn6(nkSyus[index]);
                pUiBean.setVhsyudisptknenkinkkn6(nkKkns[index]);
                pUiBean.setVhsyudisptktkjyskgnkkn6(tkjyskgnKkns[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd16(hokenNendoStartYmd1s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd16(hokenNendoEndYmd1s[index]);
                pUiBean.setVhsyudisptktkjyskgns16(skgn1s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd26(hokenNendoStartYmd2s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd26(hokenNendoEndYmd2s[index]);
                pUiBean.setVhsyudisptktkjyskgns26(skgn2s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd36(hokenNendoStartYmd3s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd36(hokenNendoEndYmd3s[index]);
                pUiBean.setVhsyudisptktkjyskgns36(skgn3s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd46(hokenNendoStartYmd4s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd46(hokenNendoEndYmd4s[index]);
                pUiBean.setVhsyudisptktkjyskgns46(skgn4s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd56(hokenNendoStartYmd5s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd56(hokenNendoEndYmd5s[index]);
                pUiBean.setVhsyudisptktkjyskgns56(skgn5s[index]);
                pUiBean.setVhsyudisptktkjyhyouten6(tkjyHyoutens[index]);
                pUiBean.setVhsyudisptktkjyp6(tkjyPs[index]);
                pUiBean.setVhsyudisptkhtnpbuicd16(htnpBuiCd1s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm16(htnpBuiNm1s[index]);
                pUiBean.setVhsyudisptkhtnpkkn16(htnpKkn1s[index]);
                pUiBean.setVhsyudisptkhtnpbuicd26(htnpBuiCd2s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm26(htnpBuiNm2s[index]);
                pUiBean.setVhsyudisptkhtnpkkn26(htnpKkn2s[index]);
                pUiBean.setVhsyudisptkhtnpbuicd36(htnpBuiCd3s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm36(htnpBuiNm3s[index]);
                pUiBean.setVhsyudisptkhtnpkkn36(htnpKkn3s[index]);
                pUiBean.setVhsyudisptkhtnpbuicd46(htnpBuiCd4s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm46(htnpBuiNm4s[index]);
                pUiBean.setVhsyudisptkhtnpkkn46(htnpKkn4s[index]);
                pUiBean.setVhsyudisptktkkdsghtpkbn6(tokKoudoSgHtnpKbns[index]);
                pUiBean.setVhsyudisptktutakngk6(BizCurrency.valueOf(0));
                pUiBean.setVhsyudisptkkrkhasseiymd6(kouyokuHasseiYmds[index]);
                pUiBean.setVhsyudisptknkhknumu6(nkKknUmus[index]);
                pUiBean.setVhsyudisptkgannyukyhumu6(gannyukyhumus[index]);
                pUiBean.setVhsyudisptkkgbairitukbn6(khnKyhKgBairituKbns[index]);
                pUiBean.setVhsyudisptksndkyhkinshrskgnumu6(tksynndkyfknshrskgnumus[index]);
                pUiBean.setVhsyudisptknextkosumu6(tkjikaikousinumus[index]);
                pUiBean.setVhsyudisptktsnshrgndhjumu6(tsnshrgndgkhyoujiumus[index]);
                pUiBean.setVhsyudisptktsnshrgndgk6(tsnshrgndgks[index]);
                pUiBean.setVhsyudisptkhghkumu6(dsyuhghkumu[index]);
            }

            if(index == 6){
                pUiBean.setVhsyudisptksyouhncd7(syouhnCds[index]);
                pUiBean.setVhsyudisptksyouhnnm7(syouhnNms[index]);
                pUiBean.setVhsyudisptkktuukasyu7(tuukasyu[index]);
                pUiBean.setVhsyudisptokyakukatakbn7(kataKbns[index]);
                pUiBean.setVhsyudisptkkyhgdkatakbn7(kyhGndKataKbns[index]);
                pUiBean.setVhsyudisptkhhknnen7(hhknNens[index]);
                pUiBean.setVhsyudisptkkykymd7(kykYmds[index]);
                pUiBean.setVhsyudisptksknnkaisiymd7(sknnKsYmds[index]);
                pUiBean.setVhsyudisptkgaskkaisiymd7(gansknnkaisiymds[index]);
                pUiBean.setVhsyudisptkhkskkaisiymd7(hkSknnKsYmds[index]);
                pUiBean.setVhsyudisptkhkgskksiymd7(hkGansknnkaisiymds[index]);
                pUiBean.setVhsyudisptkhknkkn7(hknKkns[index]);
                pUiBean.setVhsyudisptkhknkknsmnkbn7(hknKknSmnKbns[index]);
                pUiBean.setVhsyudisptkhrkkkn7(hrkKkns[index]);
                pUiBean.setVhsyudisptkhrkkknsmnkbn7(hrkKknSmnKbns[index]);
                pUiBean.setVhsyudisptkkihsyuruikbn7(kihonSSyuruiKbns[index]);
                pUiBean.setVhsyudisptkkihons7(kihonSs[index]);
                pUiBean.setVhsyudisptkp7(premiums[index]);
                pUiBean.setVhsyudisptkkihonkyhgk7(kihonSs[index].multiply(
                    Integer.parseInt(khnKyhKgBairituKbns[index].getValue())));
                pUiBean.setVhsyudisptknextkosgop7(tkjikaikousingops[index]);
                pUiBean.setVhsyudisptksykyhkatakbn7(syuKyhkinkataKbns[index]);
                pUiBean.setVhsyudisptk6daildkbn7(lokuDaiSktsyknTuikaKyhkataKbns[index]);
                pUiBean.setVhsyudisptkganyukyhntgk7(gannyukyhntgks[index]);
                pUiBean.setVhsyudisptkshrskgstrymd7(tksiharaisakugenStartYmds[index]);
                pUiBean.setVhsyudisptkshrskgnedymd7(tksiharaisakugenEndYmds[index]);
                pUiBean.setVhsyudisptkshrskgngos7(tkshrskgngoss[index]);
                pUiBean.setVhsyudisptknenkinsyukbn7(nkSyus[index]);
                pUiBean.setVhsyudisptknenkinkkn7(nkKkns[index]);
                pUiBean.setVhsyudisptktkjyskgnkkn7(tkjyskgnKkns[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd17(hokenNendoStartYmd1s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd17(hokenNendoEndYmd1s[index]);
                pUiBean.setVhsyudisptktkjyskgns17(skgn1s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd27(hokenNendoStartYmd2s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd27(hokenNendoEndYmd2s[index]);
                pUiBean.setVhsyudisptktkjyskgns27(skgn2s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd37(hokenNendoStartYmd3s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd37(hokenNendoEndYmd3s[index]);
                pUiBean.setVhsyudisptktkjyskgns37(skgn3s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd47(hokenNendoStartYmd4s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd47(hokenNendoEndYmd4s[index]);
                pUiBean.setVhsyudisptktkjyskgns47(skgn4s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd57(hokenNendoStartYmd5s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd57(hokenNendoEndYmd5s[index]);
                pUiBean.setVhsyudisptktkjyskgns57(skgn5s[index]);
                pUiBean.setVhsyudisptktkjyhyouten7(tkjyHyoutens[index]);
                pUiBean.setVhsyudisptktkjyp7(tkjyPs[index]);
                pUiBean.setVhsyudisptkhtnpbuicd17(htnpBuiCd1s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm17(htnpBuiNm1s[index]);
                pUiBean.setVhsyudisptkhtnpkkn17(htnpKkn1s[index]);
                pUiBean.setVhsyudisptkhtnpbuicd27(htnpBuiCd2s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm27(htnpBuiNm2s[index]);
                pUiBean.setVhsyudisptkhtnpkkn27(htnpKkn2s[index]);
                pUiBean.setVhsyudisptkhtnpbuicd37(htnpBuiCd3s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm37(htnpBuiNm3s[index]);
                pUiBean.setVhsyudisptkhtnpkkn37(htnpKkn3s[index]);
                pUiBean.setVhsyudisptkhtnpbuicd47(htnpBuiCd4s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm47(htnpBuiNm4s[index]);
                pUiBean.setVhsyudisptkhtnpkkn47(htnpKkn4s[index]);
                pUiBean.setVhsyudisptktkkdsghtpkbn7(tokKoudoSgHtnpKbns[index]);
                pUiBean.setVhsyudisptktutakngk7(BizCurrency.valueOf(0));
                pUiBean.setVhsyudisptkkrkhasseiymd7(kouyokuHasseiYmds[index]);
                pUiBean.setVhsyudisptknkhknumu7(nkKknUmus[index]);
                pUiBean.setVhsyudisptkgannyukyhumu7(gannyukyhumus[index]);
                pUiBean.setVhsyudisptkkgbairitukbn7(khnKyhKgBairituKbns[index]);
                pUiBean.setVhsyudisptksndkyhkinshrskgnumu7(tksynndkyfknshrskgnumus[index]);
                pUiBean.setVhsyudisptknextkosumu7(tkjikaikousinumus[index]);
                pUiBean.setVhsyudisptktsnshrgndhjumu7(tsnshrgndgkhyoujiumus[index]);
                pUiBean.setVhsyudisptktsnshrgndgk7(tsnshrgndgks[index]);
                pUiBean.setVhsyudisptkhghkumu7(dsyuhghkumu[index]);
            }

            if(index == 7){
                pUiBean.setVhsyudisptksyouhncd8(syouhnCds[index]);
                pUiBean.setVhsyudisptksyouhnnm8(syouhnNms[index]);
                pUiBean.setVhsyudisptkktuukasyu8(tuukasyu[index]);
                pUiBean.setVhsyudisptokyakukatakbn8(kataKbns[index]);
                pUiBean.setVhsyudisptkkyhgdkatakbn8(kyhGndKataKbns[index]);
                pUiBean.setVhsyudisptkhhknnen8(hhknNens[index]);
                pUiBean.setVhsyudisptkkykymd8(kykYmds[index]);
                pUiBean.setVhsyudisptksknnkaisiymd8(sknnKsYmds[index]);
                pUiBean.setVhsyudisptkgaskkaisiymd8(gansknnkaisiymds[index]);
                pUiBean.setVhsyudisptkhkskkaisiymd8(hkSknnKsYmds[index]);
                pUiBean.setVhsyudisptkhkgskksiymd8(hkGansknnkaisiymds[index]);
                pUiBean.setVhsyudisptkhknkkn8(hknKkns[index]);
                pUiBean.setVhsyudisptkhknkknsmnkbn8(hknKknSmnKbns[index]);
                pUiBean.setVhsyudisptkhrkkkn8(hrkKkns[index]);
                pUiBean.setVhsyudisptkhrkkknsmnkbn8(hrkKknSmnKbns[index]);
                pUiBean.setVhsyudisptkkihsyuruikbn8(kihonSSyuruiKbns[index]);
                pUiBean.setVhsyudisptkkihons8(kihonSs[index]);
                pUiBean.setVhsyudisptkp8(premiums[index]);
                pUiBean.setVhsyudisptkkihonkyhgk8(kihonSs[index].multiply(
                    Integer.parseInt(khnKyhKgBairituKbns[index].getValue())));
                pUiBean.setVhsyudisptknextkosgop8(tkjikaikousingops[index]);
                pUiBean.setVhsyudisptksykyhkatakbn8(syuKyhkinkataKbns[index]);
                pUiBean.setVhsyudisptk6daildkbn8(lokuDaiSktsyknTuikaKyhkataKbns[index]);
                pUiBean.setVhsyudisptkganyukyhntgk8(gannyukyhntgks[index]);
                pUiBean.setVhsyudisptkshrskgstrymd8(tksiharaisakugenStartYmds[index]);
                pUiBean.setVhsyudisptkshrskgnedymd8(tksiharaisakugenEndYmds[index]);
                pUiBean.setVhsyudisptkshrskgngos8(tkshrskgngoss[index]);
                pUiBean.setVhsyudisptknenkinsyukbn8(nkSyus[index]);
                pUiBean.setVhsyudisptknenkinkkn8(nkKkns[index]);
                pUiBean.setVhsyudisptktkjyskgnkkn8(tkjyskgnKkns[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd18(hokenNendoStartYmd1s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd18(hokenNendoEndYmd1s[index]);
                pUiBean.setVhsyudisptktkjyskgns18(skgn1s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd28(hokenNendoStartYmd2s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd28(hokenNendoEndYmd2s[index]);
                pUiBean.setVhsyudisptktkjyskgns28(skgn2s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd38(hokenNendoStartYmd3s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd38(hokenNendoEndYmd3s[index]);
                pUiBean.setVhsyudisptktkjyskgns38(skgn3s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd48(hokenNendoStartYmd4s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd48(hokenNendoEndYmd4s[index]);
                pUiBean.setVhsyudisptktkjyskgns48(skgn4s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd58(hokenNendoStartYmd5s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd58(hokenNendoEndYmd5s[index]);
                pUiBean.setVhsyudisptktkjyskgns58(skgn5s[index]);
                pUiBean.setVhsyudisptktkjyhyouten8(tkjyHyoutens[index]);
                pUiBean.setVhsyudisptktkjyp8(tkjyPs[index]);
                pUiBean.setVhsyudisptkhtnpbuicd18(htnpBuiCd1s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm18(htnpBuiNm1s[index]);
                pUiBean.setVhsyudisptkhtnpkkn18(htnpKkn1s[index]);
                pUiBean.setVhsyudisptkhtnpbuicd28(htnpBuiCd2s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm28(htnpBuiNm2s[index]);
                pUiBean.setVhsyudisptkhtnpkkn28(htnpKkn2s[index]);
                pUiBean.setVhsyudisptkhtnpbuicd38(htnpBuiCd3s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm38(htnpBuiNm3s[index]);
                pUiBean.setVhsyudisptkhtnpkkn38(htnpKkn3s[index]);
                pUiBean.setVhsyudisptkhtnpbuicd48(htnpBuiCd4s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm48(htnpBuiNm4s[index]);
                pUiBean.setVhsyudisptkhtnpkkn48(htnpKkn4s[index]);
                pUiBean.setVhsyudisptktkkdsghtpkbn8(tokKoudoSgHtnpKbns[index]);
                pUiBean.setVhsyudisptktutakngk8(BizCurrency.valueOf(0));
                pUiBean.setVhsyudisptkkrkhasseiymd8(kouyokuHasseiYmds[index]);
                pUiBean.setVhsyudisptknkhknumu8(nkKknUmus[index]);
                pUiBean.setVhsyudisptkgannyukyhumu8(gannyukyhumus[index]);
                pUiBean.setVhsyudisptkkgbairitukbn8(khnKyhKgBairituKbns[index]);
                pUiBean.setVhsyudisptksndkyhkinshrskgnumu8(tksynndkyfknshrskgnumus[index]);
                pUiBean.setVhsyudisptknextkosumu8(tkjikaikousinumus[index]);
                pUiBean.setVhsyudisptktsnshrgndhjumu8(tsnshrgndgkhyoujiumus[index]);
                pUiBean.setVhsyudisptktsnshrgndgk8(tsnshrgndgks[index]);
                pUiBean.setVhsyudisptkhghkumu8(dsyuhghkumu[index]);
            }

            if(index == 8){
                pUiBean.setVhsyudisptksyouhncd9(syouhnCds[index]);
                pUiBean.setVhsyudisptksyouhnnm9(syouhnNms[index]);
                pUiBean.setVhsyudisptkktuukasyu9(tuukasyu[index]);
                pUiBean.setVhsyudisptokyakukatakbn9(kataKbns[index]);
                pUiBean.setVhsyudisptkkyhgdkatakbn9(kyhGndKataKbns[index]);
                pUiBean.setVhsyudisptkhhknnen9(hhknNens[index]);
                pUiBean.setVhsyudisptkkykymd9(kykYmds[index]);
                pUiBean.setVhsyudisptksknnkaisiymd9(sknnKsYmds[index]);
                pUiBean.setVhsyudisptkgaskkaisiymd9(gansknnkaisiymds[index]);
                pUiBean.setVhsyudisptkhkskkaisiymd9(hkSknnKsYmds[index]);
                pUiBean.setVhsyudisptkhkgskksiymd9(hkGansknnkaisiymds[index]);
                pUiBean.setVhsyudisptkhknkkn9(hknKkns[index]);
                pUiBean.setVhsyudisptkhknkknsmnkbn9(hknKknSmnKbns[index]);
                pUiBean.setVhsyudisptkhrkkkn9(hrkKkns[index]);
                pUiBean.setVhsyudisptkhrkkknsmnkbn9(hrkKknSmnKbns[index]);
                pUiBean.setVhsyudisptkkihsyuruikbn9(kihonSSyuruiKbns[index]);
                pUiBean.setVhsyudisptkkihons9(kihonSs[index]);
                pUiBean.setVhsyudisptkp9(premiums[index]);
                pUiBean.setVhsyudisptkkihonkyhgk9(kihonSs[index].multiply(
                    Integer.parseInt(khnKyhKgBairituKbns[index].getValue())));
                pUiBean.setVhsyudisptknextkosgop9(tkjikaikousingops[index]);
                pUiBean.setVhsyudisptksykyhkatakbn9(syuKyhkinkataKbns[index]);
                pUiBean.setVhsyudisptk6daildkbn9(lokuDaiSktsyknTuikaKyhkataKbns[index]);
                pUiBean.setVhsyudisptkganyukyhntgk9(gannyukyhntgks[index]);
                pUiBean.setVhsyudisptkshrskgstrymd9(tksiharaisakugenStartYmds[index]);
                pUiBean.setVhsyudisptkshrskgnedymd9(tksiharaisakugenEndYmds[index]);
                pUiBean.setVhsyudisptkshrskgngos9(tkshrskgngoss[index]);
                pUiBean.setVhsyudisptknenkinsyukbn9(nkSyus[index]);
                pUiBean.setVhsyudisptknenkinkkn9(nkKkns[index]);
                pUiBean.setVhsyudisptktkjyskgnkkn9(tkjyskgnKkns[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd19(hokenNendoStartYmd1s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd19(hokenNendoEndYmd1s[index]);
                pUiBean.setVhsyudisptktkjyskgns19(skgn1s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd29(hokenNendoStartYmd2s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd29(hokenNendoEndYmd2s[index]);
                pUiBean.setVhsyudisptktkjyskgns29(skgn2s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd39(hokenNendoStartYmd3s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd39(hokenNendoEndYmd3s[index]);
                pUiBean.setVhsyudisptktkjyskgns39(skgn3s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd49(hokenNendoStartYmd4s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd49(hokenNendoEndYmd4s[index]);
                pUiBean.setVhsyudisptktkjyskgns49(skgn4s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd59(hokenNendoStartYmd5s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd59(hokenNendoEndYmd5s[index]);
                pUiBean.setVhsyudisptktkjyskgns59(skgn5s[index]);
                pUiBean.setVhsyudisptktkjyhyouten9(tkjyHyoutens[index]);
                pUiBean.setVhsyudisptktkjyp9(tkjyPs[index]);
                pUiBean.setVhsyudisptkhtnpbuicd19(htnpBuiCd1s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm19(htnpBuiNm1s[index]);
                pUiBean.setVhsyudisptkhtnpkkn19(htnpKkn1s[index]);
                pUiBean.setVhsyudisptkhtnpbuicd29(htnpBuiCd2s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm29(htnpBuiNm2s[index]);
                pUiBean.setVhsyudisptkhtnpkkn29(htnpKkn2s[index]);
                pUiBean.setVhsyudisptkhtnpbuicd39(htnpBuiCd3s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm39(htnpBuiNm3s[index]);
                pUiBean.setVhsyudisptkhtnpkkn39(htnpKkn3s[index]);
                pUiBean.setVhsyudisptkhtnpbuicd49(htnpBuiCd4s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm49(htnpBuiNm4s[index]);
                pUiBean.setVhsyudisptkhtnpkkn49(htnpKkn4s[index]);
                pUiBean.setVhsyudisptktkkdsghtpkbn9(tokKoudoSgHtnpKbns[index]);
                pUiBean.setVhsyudisptktutakngk9(BizCurrency.valueOf(0));
                pUiBean.setVhsyudisptkkrkhasseiymd9(kouyokuHasseiYmds[index]);
                pUiBean.setVhsyudisptknkhknumu9(nkKknUmus[index]);
                pUiBean.setVhsyudisptkgannyukyhumu9(gannyukyhumus[index]);
                pUiBean.setVhsyudisptkkgbairitukbn9(khnKyhKgBairituKbns[index]);
                pUiBean.setVhsyudisptksndkyhkinshrskgnumu9(tksynndkyfknshrskgnumus[index]);
                pUiBean.setVhsyudisptknextkosumu9(tkjikaikousinumus[index]);
                pUiBean.setVhsyudisptktsnshrgndhjumu9(tsnshrgndgkhyoujiumus[index]);
                pUiBean.setVhsyudisptktsnshrgndgk9(tsnshrgndgks[index]);
                pUiBean.setVhsyudisptkhghkumu9(dsyuhghkumu[index]);
            }

            if(index == 9){
                pUiBean.setVhsyudisptksyouhncd10(syouhnCds[index]);
                pUiBean.setVhsyudisptksyouhnnm10(syouhnNms[index]);
                pUiBean.setVhsyudisptkktuukasyu10(tuukasyu[index]);
                pUiBean.setVhsyudisptokyakukatakbn10(kataKbns[index]);
                pUiBean.setVhsyudisptkkyhgdkatakbn10(kyhGndKataKbns[index]);
                pUiBean.setVhsyudisptkhhknnen10(hhknNens[index]);
                pUiBean.setVhsyudisptkkykymd10(kykYmds[index]);
                pUiBean.setVhsyudisptksknnkaisiymd10(sknnKsYmds[index]);
                pUiBean.setVhsyudisptkgaskkaisiymd10(gansknnkaisiymds[index]);
                pUiBean.setVhsyudisptkhkskkaisiymd10(hkSknnKsYmds[index]);
                pUiBean.setVhsyudisptkhkgskksiymd10(hkGansknnkaisiymds[index]);
                pUiBean.setVhsyudisptkhknkkn10(hknKkns[index]);
                pUiBean.setVhsyudisptkhknkknsmnkbn10(hknKknSmnKbns[index]);
                pUiBean.setVhsyudisptkhrkkkn10(hrkKkns[index]);
                pUiBean.setVhsyudisptkhrkkknsmnkbn10(hrkKknSmnKbns[index]);
                pUiBean.setVhsyudisptkkihsyuruikbn10(kihonSSyuruiKbns[index]);
                pUiBean.setVhsyudisptkkihons10(kihonSs[index]);
                pUiBean.setVhsyudisptkp10(premiums[index]);
                pUiBean.setVhsyudisptkkihonkyhgk10(kihonSs[index].multiply(
                    Integer.parseInt(khnKyhKgBairituKbns[index].getValue())));
                pUiBean.setVhsyudisptknextkosgop10(tkjikaikousingops[index]);
                pUiBean.setVhsyudisptksykyhkatakbn10(syuKyhkinkataKbns[index]);
                pUiBean.setVhsyudisptk6daildkbn10(lokuDaiSktsyknTuikaKyhkataKbns[index]);
                pUiBean.setVhsyudisptkganyukyhntgk10(gannyukyhntgks[index]);
                pUiBean.setVhsyudisptkshrskgstrymd10(tksiharaisakugenStartYmds[index]);
                pUiBean.setVhsyudisptkshrskgnedymd10(tksiharaisakugenEndYmds[index]);
                pUiBean.setVhsyudisptkshrskgngos10(tkshrskgngoss[index]);
                pUiBean.setVhsyudisptknenkinsyukbn10(nkSyus[index]);
                pUiBean.setVhsyudisptknenkinkkn10(nkKkns[index]);
                pUiBean.setVhsyudisptktkjyskgnkkn10(tkjyskgnKkns[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd110(hokenNendoStartYmd1s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd110(hokenNendoEndYmd1s[index]);
                pUiBean.setVhsyudisptktkjyskgns110(skgn1s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd210(hokenNendoStartYmd2s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd210(hokenNendoEndYmd2s[index]);
                pUiBean.setVhsyudisptktkjyskgns210(skgn2s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd310(hokenNendoStartYmd3s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd310(hokenNendoEndYmd3s[index]);
                pUiBean.setVhsyudisptktkjyskgns310(skgn3s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd410(hokenNendoStartYmd4s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd410(hokenNendoEndYmd4s[index]);
                pUiBean.setVhsyudisptktkjyskgns410(skgn4s[index]);
                pUiBean.setVhsyudisptktkjkhkdsymd510(hokenNendoStartYmd5s[index]);
                pUiBean.setVhsyudisptktkjkhkdeymd510(hokenNendoEndYmd5s[index]);
                pUiBean.setVhsyudisptktkjyskgns510(skgn5s[index]);
                pUiBean.setVhsyudisptktkjyhyouten10(tkjyHyoutens[index]);
                pUiBean.setVhsyudisptktkjyp10(tkjyPs[index]);
                pUiBean.setVhsyudisptkhtnpbuicd110(htnpBuiCd1s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm110(htnpBuiNm1s[index]);
                pUiBean.setVhsyudisptkhtnpkkn110(htnpKkn1s[index]);
                pUiBean.setVhsyudisptkhtnpbuicd210(htnpBuiCd2s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm210(htnpBuiNm2s[index]);
                pUiBean.setVhsyudisptkhtnpkkn210(htnpKkn2s[index]);
                pUiBean.setVhsyudisptkhtnpbuicd310(htnpBuiCd3s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm310(htnpBuiNm3s[index]);
                pUiBean.setVhsyudisptkhtnpkkn310(htnpKkn3s[index]);
                pUiBean.setVhsyudisptkhtnpbuicd410(htnpBuiCd4s[index]);
                pUiBean.setVhsyudisptkhtnpbuinm410(htnpBuiNm4s[index]);
                pUiBean.setVhsyudisptkhtnpkkn410(htnpKkn4s[index]);
                pUiBean.setVhsyudisptktkkdsghtpkbn10(tokKoudoSgHtnpKbns[index]);
                pUiBean.setVhsyudisptktutakngk10(BizCurrency.valueOf(0));
                pUiBean.setVhsyudisptkkrkhasseiymd10(kouyokuHasseiYmds[index]);
                pUiBean.setVhsyudisptknkhknumu10(nkKknUmus[index]);
                pUiBean.setVhsyudisptkgannyukyhumu10(gannyukyhumus[index]);
                pUiBean.setVhsyudisptkkgbairitukbn10(khnKyhKgBairituKbns[index]);
                pUiBean.setVhsyudisptksndkyhkinshrskgnumu10(tksynndkyfknshrskgnumus[index]);
                pUiBean.setVhsyudisptknextkosumu10(tkjikaikousinumus[index]);
                pUiBean.setVhsyudisptktsnshrgndhjumu10(tsnshrgndgkhyoujiumus[index]);
                pUiBean.setVhsyudisptktsnshrgndgk10(tsnshrgndgks[index]);
                pUiBean.setVhsyudisptkhghkumu10(dsyuhghkumu[index]);
            }
        }
    }
}
