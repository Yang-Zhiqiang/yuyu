package yuyu.common.hozen.setuibean;

import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Htnpkkn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_KihonssyuruiKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SyukyhkinkataKbn;
import yuyu.def.classification.C_Tkjyhyouten;
import yuyu.def.classification.C_Tkjyskgnkkn;
import yuyu.def.classification.C_TokkoudosghtnpKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YendthnkJyoutaiKbn;

/**
 * 契約保全 UiBean設定 保障内容設定UiBeanパラメータ
 */
public interface SetHosyouExecUiBeanParam {

    String getSyono();

    public void setVhsyusyusyouhnnm(String pVhsyusyusyouhnnm);

    public void setVhsyuaisyoumeikbn(C_AisyoumeiKbn pVhsyuaisyoumeikbn);

    public void setVhsyusyukyktuukasyu(C_Tuukasyu pVhsyusyukyktuukasyu);

    public void setVhsyusyukykjisiteituukasyu(C_Tuukasyu pVhsyusyukykjisiteituukasyu);

    public void setVhsyusyukatakbn(C_KataKbn pVhsyusyukatakbn);

    public void setVhsyusyukyhgndkatakbn(C_KyhgndkataKbn pVhsyusyukyhgndkatakbn);

    public void setVhsyusyuhhknnen(Integer pVhsyusyuhhknnen);

    public void setVhsyusyukykymd(BizDate pVhsyusyukykymd);

    public void setVhsyusyusknnkaisiymd(BizDate pVhsyusyusknnkaisiymd);

    public void setVhsyugansknnkaisiymd(BizDate pVhsyugansknnkaisiymd);

    public void setVhsyusyufktsknnkaisiymd(BizDate pVhsyusyufktsknnkaisiymd);

    public void setVhsyuhkgogansknnkaisiymd(BizDate pVhsyuhkgogansknnkaisiymd);

    public void setVhsyusyuhknkkn(Integer pVhsyusyuhknkkn);

    public void setVhsyusyuhknkknsmnkbn(C_HknkknsmnKbn pVhsyusyuhknkknsmnkbn);

    public void setVhsyusdpdkbn(C_Sdpd pVhsyusdpdkbn);

    public void setVhsyusyuhrkkkn(Integer pVhsyusyuhrkkkn);

    public void setVhsyusyuhrkkknsmnkbn(C_HrkkknsmnKbn pVhsyusyuhrkkknsmnkbn);

    public void setVhsyudai1hknkkn(Integer pVhsyudai1hknkkn);

    public void setVhsyusyukihonssyuruikbn(C_KihonssyuruiKbn pVhsyusyukihonssyuruikbn);

    public void setVhsyusyukihons(BizCurrency pVhsyusyukihons);

    public void setVhsyusyukykkjnkngk(BizCurrency pVhsyusyukykkjnkngk);

    public void setVhsyugenzaisbhknkngaku(BizCurrency pVhsyugenzaisbhknkngaku);

    public void setVhsyusaigaisbhknkngaku(BizCurrency pVhsyusaigaisbhknkngaku);

    public void setVhsyusyukihonkyhgk(BizCurrency pVhsyusyukihonkyhgk);

    public void setVhsyusyup(BizCurrency pVhsyusyup);

    public void setVhsyusyunextkosgop(BizCurrency pVhsyusyunextkosgop);

    public void setVhsyusyusyukyhkinkatakbn(C_SyukyhkinkataKbn pVhsyusyusyukyhkinkatakbn);

    public void setVhsyusyurokudaildkbn(C_6daiLdKbn pVhsyusyurokudaildkbn);

    public void setVhsyusyugannyukyhntgk(BizCurrency pVhsyusyugannyukyhntgk);

    public void setVhsyusyushrskgnstartymd(BizDate pVhsyusyushrskgnstartymd);

    public void setVhsyusyushrskgnendymd(BizDate pVhsyusyushrskgnendymd);

    public void setVhsyusyushrskgngos(BizCurrency pVhsyusyushrskgngos);

    public void setVhsyusyunnkinsyukbn(C_Nenkinsyu pVhsyusyunnkinsyukbn);

    public void setVhsyusyunenkinkkn(Integer pVhsyusyunenkinkkn);

    public void setVhsyusyutkjyskgnkkn(C_Tkjyskgnkkn pVhsyusyutkjyskgnkkn);

    public void setVhsyusyutkjyskgnhkndsymd1(BizDate pVhsyusyutkjyskgnhkndsymd1);

    public void setVhsyusyutkjyskgnhkndeymd1(BizDate pVhsyusyutkjyskgnhkndeymd1);

    public void setVhsyusyutkjyskgns1(BizCurrency pVhsyusyutkjyskgns1);

    public void setVhsyusyutkjyskgnhkndsymd2(BizDate pVhsyusyutkjyskgnhkndsymd2);

    public void setVhsyusyutkjyskgnhkndeymd2(BizDate pVhsyusyutkjyskgnhkndeymd2);

    public void setVhsyusyutkjyskgns2(BizCurrency pVhsyusyutkjyskgns2);

    public void setVhsyusyutkjyskgnhkndsymd3(BizDate pVhsyusyutkjyskgnhkndsymd3);

    public void setVhsyusyutkjyskgnhkndeymd3(BizDate pVhsyusyutkjyskgnhkndeymd3);

    public void setVhsyusyutkjyskgns3(BizCurrency pVhsyusyutkjyskgns3);

    public void setVhsyusyutkjyskgnhkndsymd4(BizDate pVhsyusyutkjyskgnhkndsymd4);

    public void setVhsyusyutkjyskgnhkndeymd4(BizDate pVhsyusyutkjyskgnhkndeymd4);

    public void setVhsyusyutkjyskgns4(BizCurrency pVhsyusyutkjyskgns4);

    public void setVhsyusyutkjyskgnhkndsymd5(BizDate pVhsyusyutkjyskgnhkndsymd5);

    public void setVhsyusyutkjyskgnhkndeymd5(BizDate pVhsyusyutkjyskgnhkndeymd5);

    public void setVhsyusyutkjyskgns5(BizCurrency pVhsyusyutkjyskgns5);

    public void setVhsyusyutkjyhyouten(C_Tkjyhyouten pVhsyusyutkjyhyouten);

    public void setVhsyusyutkjyp(BizCurrency pVhsyusyutkjyp);

    public void setVhsyusyuhtnpbuicd1(String pVhsyusyuhtnpbuicd1);

    public void setVhsyusyuhtnpbuinm1(String pVhsyusyuhtnpbuinm1);

    public void setVhsyusyuhtnpkkn1(C_Htnpkkn pVhsyusyuhtnpkkn1);

    public void setVhsyusyuhtnpbuicd2(String pVhsyusyuhtnpbuicd2);

    public void setVhsyusyuhtnpbuinm2(String pVhsyusyuhtnpbuinm2);

    public void setVhsyusyuhtnpkkn2(C_Htnpkkn pVhsyusyuhtnpkkn2);

    public void setVhsyusyuhtnpbuicd3(String pVhsyusyuhtnpbuicd3);

    public void setVhsyusyuhtnpbuinm3(String pVhsyusyuhtnpbuinm3);

    public void setVhsyusyuhtnpkkn3(C_Htnpkkn pVhsyusyuhtnpkkn3);

    public void setVhsyusyuhtnpbuicd4(String pVhsyusyuhtnpbuicd4);

    public void setVhsyusyuhtnpbuinm4(String pVhsyusyuhtnpbuinm4);

    public void setVhsyusyuhtnpkkn4(C_Htnpkkn pVhsyusyuhtnpkkn4);

    public void setVhsyusyutokkdsghtnpkbn(C_TokkoudosghtnpKbn pVhsyusyutokkdsghtnpkbn);

    public void setVhsyusyututakngk(BizCurrency pVhsyusyututakngk);

    public void setVhsyusyukouryokuhasseiymd(BizDate pVhsyusyukouryokuhasseiymd);

    public void setVhsyudai1hknkknsbsyokuseiumu(C_UmuKbn pVhsyudai1hknkknsbsyokuseiumu);

    public void setVhsyusgsbhsyumu(C_UmuKbn pVhsyusgsbhsyumu);

    public void setVhsyuhknKknKbn(C_HknKknKbn pVhsyuhknKknKbn);

    public void setVhsyusyohinhanteikbn(int pVhsyusyohinhanteikbn);

    public void setVhsyumvatekiumu(C_UmuKbn pVhsyumvatekiumu);

    public void setVhsyusbhkuktumu(C_UmuKbn pVhsyusbhkuktumu);

    public void setVhsyusbkyuuhukinuktumu(C_UmuKbn pVhsyusbkyuuhukinuktumu);

    public void setVhsyuyendthnkymd(BizDate pVhsyuyendthnkymd);

    public void setVhsyutmttknitenymd(BizDate pVhsyutmttknitenymd);

    public void setVhsyusyunkshrstartymd(BizDate pVhsyusyunkshrstartymd);

    public void setVhsyuteiritutmttkngk(BizCurrency pVhsyuteiritutmttkngk);

    public void setVhsyusisuurendoutmttkngk(BizCurrency pVhsyusisuurendoutmttkngk);

    public void setVhsyugenzaitmttkngk(BizCurrency pVhsyugenzaitmttkngk);

    public void setVhsyusisuurendourate(BizNumber pVhsyusisuurendourate);

    public void setVhsyuteiritutmttrate(BizNumber pVhsyuteiritutmttrate);

    public void setVhsyusisuunm(String pVhsyusisuunm);

    public void setVhsyusetteibairitu(BizNumber pVhsyusetteibairitu);

    public void setVhsyuyoteiriritu(BizNumber pVhsyuyoteiriritu);

    public void setVhsyutumitateriritu(BizNumber pVhsyutumitateriritu);

    public void setVhsyukyktumitateriritu(BizNumber pVhsyukyktumitateriritu);

    public void setVhsyu10nentumitateriritu(BizNumber pVhsyu10nentumitateriritu);

    public void setVhsyukyksjkkktyouseiriritu(BizNumber pVhsyukyksjkkktyouseiriritu);

    public void setVhsyuskisjkkktyouseiriritu(BizNumber pVhsyuskisjkkktyouseiriritu);

    public void setVhsyudisptksyouhnnm(String pVhsyudisptksyouhnnm);

    public void setVhsyunkshrtkyknksyukbn(C_Nstknsyu pVhsyunkshrtkyknksyukbn);

    public void setVhsyunkshrtkyknksyukkn(Integer pVhsyunkshrtkyknksyukkn);

    public void setVhsyudisptksyouhnnm1(String pVhsyudisptksyouhnnm1);

    public void setVhsyudisptkktuukasyu1(C_Tuukasyu pVhsyudisptkktuukasyu1);

    public void setVhsyudisptokyakukatakbn1(C_KataKbn pVhsyudisptokyakukatakbn1);

    public void setVhsyudisptkkyhgdkatakbn1(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn1);

    public void setVhsyudisptkhhknnen1(Integer pVhsyudisptkhhknnen1);

    public void setVhsyudisptkkykymd1(BizDate pVhsyudisptkkykymd1);

    public void setVhsyudisptksknnkaisiymd1(BizDate pVhsyudisptksknnkaisiymd1);

    public void setVhsyudisptkgaskkaisiymd1(BizDate pVhsyudisptkgaskkaisiymd1);

    public void setVhsyudisptkhkskkaisiymd1(BizDate pVhsyudisptkhkskkaisiymd1);

    public void setVhsyudisptkhkgskksiymd1(BizDate pVhsyudisptkhkgskksiymd1);

    public void setVhsyudisptkhknkkn1(Integer pVhsyudisptkhknkkn1);

    public void setVhsyudisptkhknkknsmnkbn1(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn1);

    public void setVhsyudisptkhrkkkn1(Integer pVhsyudisptkhrkkkn1);

    public void setVhsyudisptkhrkkknsmnkbn1(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn1);

    public void setVhsyudisptkkihsyuruikbn1(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn1);

    public void setVhsyudisptkkihons1(BizCurrency pVhsyudisptkkihons1);

    public void setVhsyudisptkp1(BizCurrency pVhsyudisptkp1);

    public void setVhsyudisptkkihonkyhgk1(BizCurrency pVhsyudisptkkihonkyhgk1);

    public void setVhsyudisptknextkosgop1(BizCurrency pVhsyudisptknextkosgop1);

    public void setVhsyudisptksykyhkatakbn1(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn1);

    public void setVhsyudisptk6daildkbn1(C_6daiLdKbn pVhsyudisptk6daildkbn1);

    public void setVhsyudisptkganyukyhntgk1(BizCurrency pVhsyudisptkganyukyhntgk1);

    public void setVhsyudisptkshrskgstrymd1(BizDate pVhsyudisptkshrskgstrymd1);

    public void setVhsyudisptkshrskgnedymd1(BizDate pVhsyudisptkshrskgnedymd1);

    public void setVhsyudisptkshrskgngos1(BizCurrency pVhsyudisptkshrskgngos1);

    public void setVhsyudisptknenkinsyukbn1(C_Nenkinsyu pVhsyudisptknenkinsyukbn1);

    public void setVhsyudisptknenkinkkn1(Integer pVhsyudisptknenkinkkn1);

    public void setVhsyudisptktkjyskgnkkn1(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn1);

    public void setVhsyudisptktkjkhkdsymd11(BizDate pVhsyudisptktkjkhkdsymd11);

    public void setVhsyudisptktkjkhkdeymd11(BizDate pVhsyudisptktkjkhkdeymd11);

    public void setVhsyudisptktkjyskgns11(BizCurrency pVhsyudisptktkjyskgns11);

    public void setVhsyudisptktkjkhkdsymd21(BizDate pVhsyudisptktkjkhkdsymd21);

    public void setVhsyudisptktkjkhkdeymd21(BizDate pVhsyudisptktkjkhkdeymd21);

    public void setVhsyudisptktkjyskgns21(BizCurrency pVhsyudisptktkjyskgns21);

    public void setVhsyudisptktkjkhkdsymd31(BizDate pVhsyudisptktkjkhkdsymd31);

    public void setVhsyudisptktkjkhkdeymd31(BizDate pVhsyudisptktkjkhkdeymd31);

    public void setVhsyudisptktkjyskgns31(BizCurrency pVhsyudisptktkjyskgns31);

    public void setVhsyudisptktkjkhkdsymd41(BizDate pVhsyudisptktkjkhkdsymd41);

    public void setVhsyudisptktkjkhkdeymd41(BizDate pVhsyudisptktkjkhkdeymd41);

    public void setVhsyudisptktkjyskgns41(BizCurrency pVhsyudisptktkjyskgns41);

    public void setVhsyudisptktkjkhkdsymd51(BizDate pVhsyudisptktkjkhkdsymd51);

    public void setVhsyudisptktkjkhkdeymd51(BizDate pVhsyudisptktkjkhkdeymd51);

    public void setVhsyudisptktkjyskgns51(BizCurrency pVhsyudisptktkjyskgns51);

    public void setVhsyudisptktkjyhyouten1(C_Tkjyhyouten pVhsyudisptktkjyhyouten1);

    public void setVhsyudisptktkjyp1(BizCurrency pVhsyudisptktkjyp1);

    public void setVhsyudisptkhtnpbuicd11(String pVhsyudisptkhtnpbuicd11);

    public void setVhsyudisptkhtnpbuinm11(String pVhsyudisptkhtnpbuinm11);

    public void setVhsyudisptkhtnpkkn11(C_Htnpkkn pVhsyudisptkhtnpkkn11);

    public void setVhsyudisptkhtnpbuicd21(String pVhsyudisptkhtnpbuicd21);

    public void setVhsyudisptkhtnpbuinm21(String pVhsyudisptkhtnpbuinm21);

    public void setVhsyudisptkhtnpkkn21(C_Htnpkkn pVhsyudisptkhtnpkkn21);

    public void setVhsyudisptkhtnpbuicd31(String pVhsyudisptkhtnpbuicd31);

    public void setVhsyudisptkhtnpbuinm31(String pVhsyudisptkhtnpbuinm31);

    public void setVhsyudisptkhtnpkkn31(C_Htnpkkn pVhsyudisptkhtnpkkn31);

    public void setVhsyudisptkhtnpbuicd41(String pVhsyudisptkhtnpbuicd41);

    public void setVhsyudisptkhtnpbuinm41(String pVhsyudisptkhtnpbuinm41);

    public void setVhsyudisptkhtnpkkn41(C_Htnpkkn pVhsyudisptkhtnpkkn41);

    public void setVhsyudisptktkkdsghtpkbn1(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn1);

    public void setVhsyudisptktutakngk1(BizCurrency pVhsyudisptktutakngk1);

    public void setVhsyudisptkkrkhasseiymd1(BizDate pVhsyudisptkkrkhasseiymd1);

    public void setVhsyudisptksyouhnnm2(String pVhsyudisptksyouhnnm2);

    public void setVhsyudisptkktuukasyu2(C_Tuukasyu pVhsyudisptkktuukasyu2);

    public void setVhsyudisptokyakukatakbn2(C_KataKbn pVhsyudisptokyakukatakbn2);

    public void setVhsyudisptkkyhgdkatakbn2(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn2);

    public void setVhsyudisptkhhknnen2(Integer pVhsyudisptkhhknnen2);

    public void setVhsyudisptkkykymd2(BizDate pVhsyudisptkkykymd2);

    public void setVhsyudisptksknnkaisiymd2(BizDate pVhsyudisptksknnkaisiymd2);

    public void setVhsyudisptkgaskkaisiymd2(BizDate pVhsyudisptkgaskkaisiymd2);

    public void setVhsyudisptkhkskkaisiymd2(BizDate pVhsyudisptkhkskkaisiymd2);

    public void setVhsyudisptkhkgskksiymd2(BizDate pVhsyudisptkhkgskksiymd2);

    public void setVhsyudisptkhknkkn2(Integer pVhsyudisptkhknkkn2);

    public void setVhsyudisptkhknkknsmnkbn2(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn2);

    public void setVhsyudisptkhrkkkn2(Integer pVhsyudisptkhrkkkn2);

    public void setVhsyudisptkhrkkknsmnkbn2(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn2);

    public void setVhsyudisptkkihsyuruikbn2(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn2);

    public void setVhsyudisptkkihons2(BizCurrency pVhsyudisptkkihons2);

    public void setVhsyudisptkp2(BizCurrency pVhsyudisptkp2);

    public void setVhsyudisptkkihonkyhgk2(BizCurrency pVhsyudisptkkihonkyhgk2);

    public void setVhsyudisptknextkosgop2(BizCurrency pVhsyudisptknextkosgop2);

    public void setVhsyudisptksykyhkatakbn2(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn2);

    public void setVhsyudisptk6daildkbn2(C_6daiLdKbn pVhsyudisptk6daildkbn2);

    public void setVhsyudisptkganyukyhntgk2(BizCurrency pVhsyudisptkganyukyhntgk2);

    public void setVhsyudisptkshrskgstrymd2(BizDate pVhsyudisptkshrskgstrymd2);

    public void setVhsyudisptkshrskgnedymd2(BizDate pVhsyudisptkshrskgnedymd2);

    public void setVhsyudisptkshrskgngos2(BizCurrency pVhsyudisptkshrskgngos2);

    public void setVhsyudisptknenkinsyukbn2(C_Nenkinsyu pVhsyudisptknenkinsyukbn2);

    public void setVhsyudisptknenkinkkn2(Integer pVhsyudisptknenkinkkn2);

    public void setVhsyudisptktkjyskgnkkn2(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn2);

    public void setVhsyudisptktkjkhkdsymd12(BizDate pVhsyudisptktkjkhkdsymd12);

    public void setVhsyudisptktkjkhkdeymd12(BizDate pVhsyudisptktkjkhkdeymd12);

    public void setVhsyudisptktkjyskgns12(BizCurrency pVhsyudisptktkjyskgns12);

    public void setVhsyudisptktkjkhkdsymd22(BizDate pVhsyudisptktkjkhkdsymd22);

    public void setVhsyudisptktkjkhkdeymd22(BizDate pVhsyudisptktkjkhkdeymd22);

    public void setVhsyudisptktkjyskgns22(BizCurrency pVhsyudisptktkjyskgns22);

    public void setVhsyudisptktkjkhkdsymd32(BizDate pVhsyudisptktkjkhkdsymd32);

    public void setVhsyudisptktkjkhkdeymd32(BizDate pVhsyudisptktkjkhkdeymd32);

    public void setVhsyudisptktkjyskgns32(BizCurrency pVhsyudisptktkjyskgns32);

    public void setVhsyudisptktkjkhkdsymd42(BizDate pVhsyudisptktkjkhkdsymd42);

    public void setVhsyudisptktkjkhkdeymd42(BizDate pVhsyudisptktkjkhkdeymd42);

    public void setVhsyudisptktkjyskgns42(BizCurrency pVhsyudisptktkjyskgns42);

    public void setVhsyudisptktkjkhkdsymd52(BizDate pVhsyudisptktkjkhkdsymd52);

    public void setVhsyudisptktkjkhkdeymd52(BizDate pVhsyudisptktkjkhkdeymd52);

    public void setVhsyudisptktkjyskgns52(BizCurrency pVhsyudisptktkjyskgns52);

    public void setVhsyudisptktkjyhyouten2(C_Tkjyhyouten pVhsyudisptktkjyhyouten2);

    public void setVhsyudisptktkjyp2(BizCurrency pVhsyudisptktkjyp2);

    public void setVhsyudisptkhtnpbuicd12(String pVhsyudisptkhtnpbuicd12);

    public void setVhsyudisptkhtnpbuinm12(String pVhsyudisptkhtnpbuinm12);

    public void setVhsyudisptkhtnpkkn12(C_Htnpkkn pVhsyudisptkhtnpkkn12);

    public void setVhsyudisptkhtnpbuicd22(String pVhsyudisptkhtnpbuicd22);

    public void setVhsyudisptkhtnpbuinm22(String pVhsyudisptkhtnpbuinm22);

    public void setVhsyudisptkhtnpkkn22(C_Htnpkkn pVhsyudisptkhtnpkkn22);

    public void setVhsyudisptkhtnpbuicd32(String pVhsyudisptkhtnpbuicd32);

    public void setVhsyudisptkhtnpbuinm32(String pVhsyudisptkhtnpbuinm32);

    public void setVhsyudisptkhtnpkkn32(C_Htnpkkn pVhsyudisptkhtnpkkn32);

    public void setVhsyudisptkhtnpbuicd42(String pVhsyudisptkhtnpbuicd42);

    public void setVhsyudisptkhtnpbuinm42(String pVhsyudisptkhtnpbuinm42);

    public void setVhsyudisptkhtnpkkn42(C_Htnpkkn pVhsyudisptkhtnpkkn42);

    public void setVhsyudisptktkkdsghtpkbn2(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn2);

    public void setVhsyudisptktutakngk2(BizCurrency pVhsyudisptktutakngk2);

    public void setVhsyudisptkkrkhasseiymd2(BizDate pVhsyudisptkkrkhasseiymd2);

    public void setVhsyudisptksyouhnnm3(String pVhsyudisptksyouhnnm3);

    public void setVhsyudisptkktuukasyu3(C_Tuukasyu pVhsyudisptkktuukasyu3);

    public void setVhsyudisptokyakukatakbn3(C_KataKbn pVhsyudisptokyakukatakbn3);

    public void setVhsyudisptkkyhgdkatakbn3(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn3);

    public void setVhsyudisptkhhknnen3(Integer pVhsyudisptkhhknnen3);

    public void setVhsyudisptkkykymd3(BizDate pVhsyudisptkkykymd3);

    public void setVhsyudisptksknnkaisiymd3(BizDate pVhsyudisptksknnkaisiymd3);

    public void setVhsyudisptkgaskkaisiymd3(BizDate pVhsyudisptkgaskkaisiymd3);

    public void setVhsyudisptkhkskkaisiymd3(BizDate pVhsyudisptkhkskkaisiymd3);

    public void setVhsyudisptkhkgskksiymd3(BizDate pVhsyudisptkhkgskksiymd3);

    public void setVhsyudisptkhknkkn3(Integer pVhsyudisptkhknkkn3);

    public void setVhsyudisptkhknkknsmnkbn3(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn3);

    public void setVhsyudisptkhrkkkn3(Integer pVhsyudisptkhrkkkn3);

    public void setVhsyudisptkhrkkknsmnkbn3(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn3);

    public void setVhsyudisptkkihsyuruikbn3(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn3);

    public void setVhsyudisptkkihons3(BizCurrency pVhsyudisptkkihons3);

    public void setVhsyudisptkp3(BizCurrency pVhsyudisptkp3);

    public void setVhsyudisptkkihonkyhgk3(BizCurrency pVhsyudisptkkihonkyhgk3);

    public void setVhsyudisptknextkosgop3(BizCurrency pVhsyudisptknextkosgop3);

    public void setVhsyudisptksykyhkatakbn3(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn3);

    public void setVhsyudisptk6daildkbn3(C_6daiLdKbn pVhsyudisptk6daildkbn3);

    public void setVhsyudisptkganyukyhntgk3(BizCurrency pVhsyudisptkganyukyhntgk3);

    public void setVhsyudisptkshrskgstrymd3(BizDate pVhsyudisptkshrskgstrymd3);

    public void setVhsyudisptkshrskgnedymd3(BizDate pVhsyudisptkshrskgnedymd3);

    public void setVhsyudisptkshrskgngos3(BizCurrency pVhsyudisptkshrskgngos3);

    public void setVhsyudisptknenkinsyukbn3(C_Nenkinsyu pVhsyudisptknenkinsyukbn3);

    public void setVhsyudisptknenkinkkn3(Integer pVhsyudisptknenkinkkn3);

    public void setVhsyudisptktkjyskgnkkn3(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn3);

    public void setVhsyudisptktkjkhkdsymd13(BizDate pVhsyudisptktkjkhkdsymd13);

    public void setVhsyudisptktkjkhkdeymd13(BizDate pVhsyudisptktkjkhkdeymd13);

    public void setVhsyudisptktkjyskgns13(BizCurrency pVhsyudisptktkjyskgns13);

    public void setVhsyudisptktkjkhkdsymd23(BizDate pVhsyudisptktkjkhkdsymd23);

    public void setVhsyudisptktkjkhkdeymd23(BizDate pVhsyudisptktkjkhkdeymd23);

    public void setVhsyudisptktkjyskgns23(BizCurrency pVhsyudisptktkjyskgns23);

    public void setVhsyudisptktkjkhkdsymd33(BizDate pVhsyudisptktkjkhkdsymd33);

    public void setVhsyudisptktkjkhkdeymd33(BizDate pVhsyudisptktkjkhkdeymd33);

    public void setVhsyudisptktkjyskgns33(BizCurrency pVhsyudisptktkjyskgns33);

    public void setVhsyudisptktkjkhkdsymd43(BizDate pVhsyudisptktkjkhkdsymd43);

    public void setVhsyudisptktkjkhkdeymd43(BizDate pVhsyudisptktkjkhkdeymd43);

    public void setVhsyudisptktkjyskgns43(BizCurrency pVhsyudisptktkjyskgns43);

    public void setVhsyudisptktkjkhkdsymd53(BizDate pVhsyudisptktkjkhkdsymd53);

    public void setVhsyudisptktkjkhkdeymd53(BizDate pVhsyudisptktkjkhkdeymd53);

    public void setVhsyudisptktkjyskgns53(BizCurrency pVhsyudisptktkjyskgns53);

    public void setVhsyudisptktkjyhyouten3(C_Tkjyhyouten pVhsyudisptktkjyhyouten3);

    public void setVhsyudisptktkjyp3(BizCurrency pVhsyudisptktkjyp3);

    public void setVhsyudisptkhtnpbuicd13(String pVhsyudisptkhtnpbuicd13);

    public void setVhsyudisptkhtnpbuinm13(String pVhsyudisptkhtnpbuinm13);

    public void setVhsyudisptkhtnpkkn13(C_Htnpkkn pVhsyudisptkhtnpkkn13);

    public void setVhsyudisptkhtnpbuicd23(String pVhsyudisptkhtnpbuicd23);

    public void setVhsyudisptkhtnpbuinm23(String pVhsyudisptkhtnpbuinm23);

    public void setVhsyudisptkhtnpkkn23(C_Htnpkkn pVhsyudisptkhtnpkkn23);

    public void setVhsyudisptkhtnpbuicd33(String pVhsyudisptkhtnpbuicd33);

    public void setVhsyudisptkhtnpbuinm33(String pVhsyudisptkhtnpbuinm33);

    public void setVhsyudisptkhtnpkkn33(C_Htnpkkn pVhsyudisptkhtnpkkn33);

    public void setVhsyudisptkhtnpbuicd43(String pVhsyudisptkhtnpbuicd43);

    public void setVhsyudisptkhtnpbuinm43(String pVhsyudisptkhtnpbuinm43);

    public void setVhsyudisptkhtnpkkn43(C_Htnpkkn pVhsyudisptkhtnpkkn43);

    public void setVhsyudisptktkkdsghtpkbn3(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn3);

    public void setVhsyudisptktutakngk3(BizCurrency pVhsyudisptktutakngk3);

    public void setVhsyudisptkkrkhasseiymd3(BizDate pVhsyudisptkkrkhasseiymd3);

    public void setVhsyudisptksyouhnnm4(String pVhsyudisptksyouhnnm4);

    public void setVhsyudisptkktuukasyu4(C_Tuukasyu pVhsyudisptkktuukasyu4);

    public void setVhsyudisptokyakukatakbn4(C_KataKbn pVhsyudisptokyakukatakbn4);

    public void setVhsyudisptkkyhgdkatakbn4(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn4);

    public void setVhsyudisptkhhknnen4(Integer pVhsyudisptkhhknnen4);

    public void setVhsyudisptkkykymd4(BizDate pVhsyudisptkkykymd4);

    public void setVhsyudisptksknnkaisiymd4(BizDate pVhsyudisptksknnkaisiymd4);

    public void setVhsyudisptkgaskkaisiymd4(BizDate pVhsyudisptkgaskkaisiymd4);

    public void setVhsyudisptkhkskkaisiymd4(BizDate pVhsyudisptkhkskkaisiymd4);

    public void setVhsyudisptkhkgskksiymd4(BizDate pVhsyudisptkhkgskksiymd4);

    public void setVhsyudisptkhknkkn4(Integer pVhsyudisptkhknkkn4);

    public void setVhsyudisptkhknkknsmnkbn4(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn4);

    public void setVhsyudisptkhrkkkn4(Integer pVhsyudisptkhrkkkn4);

    public void setVhsyudisptkhrkkknsmnkbn4(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn4);

    public void setVhsyudisptkkihsyuruikbn4(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn4);

    public void setVhsyudisptkkihons4(BizCurrency pVhsyudisptkkihons4);

    public void setVhsyudisptkp4(BizCurrency pVhsyudisptkp4);

    public void setVhsyudisptkkihonkyhgk4(BizCurrency pVhsyudisptkkihonkyhgk4);

    public void setVhsyudisptknextkosgop4(BizCurrency pVhsyudisptknextkosgop4);

    public void setVhsyudisptksykyhkatakbn4(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn4);

    public void setVhsyudisptk6daildkbn4(C_6daiLdKbn pVhsyudisptk6daildkbn4);

    public void setVhsyudisptkganyukyhntgk4(BizCurrency pVhsyudisptkganyukyhntgk4);

    public void setVhsyudisptkshrskgstrymd4(BizDate pVhsyudisptkshrskgstrymd4);

    public void setVhsyudisptkshrskgnedymd4(BizDate pVhsyudisptkshrskgnedymd4);

    public void setVhsyudisptkshrskgngos4(BizCurrency pVhsyudisptkshrskgngos4);

    public void setVhsyudisptknenkinsyukbn4(C_Nenkinsyu pVhsyudisptknenkinsyukbn4);

    public void setVhsyudisptknenkinkkn4(Integer pVhsyudisptknenkinkkn4);

    public void setVhsyudisptktkjyskgnkkn4(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn4);

    public void setVhsyudisptktkjkhkdsymd14(BizDate pVhsyudisptktkjkhkdsymd14);

    public void setVhsyudisptktkjkhkdeymd14(BizDate pVhsyudisptktkjkhkdeymd14);

    public void setVhsyudisptktkjyskgns14(BizCurrency pVhsyudisptktkjyskgns14);

    public void setVhsyudisptktkjkhkdsymd24(BizDate pVhsyudisptktkjkhkdsymd24);

    public void setVhsyudisptktkjkhkdeymd24(BizDate pVhsyudisptktkjkhkdeymd24);

    public void setVhsyudisptktkjyskgns24(BizCurrency pVhsyudisptktkjyskgns24);

    public void setVhsyudisptktkjkhkdsymd34(BizDate pVhsyudisptktkjkhkdsymd34);

    public void setVhsyudisptktkjkhkdeymd34(BizDate pVhsyudisptktkjkhkdeymd34);

    public void setVhsyudisptktkjyskgns34(BizCurrency pVhsyudisptktkjyskgns34);

    public void setVhsyudisptktkjkhkdsymd44(BizDate pVhsyudisptktkjkhkdsymd44);

    public void setVhsyudisptktkjkhkdeymd44(BizDate pVhsyudisptktkjkhkdeymd44);

    public void setVhsyudisptktkjyskgns44(BizCurrency pVhsyudisptktkjyskgns44);

    public void setVhsyudisptktkjkhkdsymd54(BizDate pVhsyudisptktkjkhkdsymd54);

    public void setVhsyudisptktkjkhkdeymd54(BizDate pVhsyudisptktkjkhkdeymd54);

    public void setVhsyudisptktkjyskgns54(BizCurrency pVhsyudisptktkjyskgns54);

    public void setVhsyudisptktkjyhyouten4(C_Tkjyhyouten pVhsyudisptktkjyhyouten4);

    public void setVhsyudisptktkjyp4(BizCurrency pVhsyudisptktkjyp4);

    public void setVhsyudisptkhtnpbuicd14(String pVhsyudisptkhtnpbuicd14);

    public void setVhsyudisptkhtnpbuinm14(String pVhsyudisptkhtnpbuinm14);

    public void setVhsyudisptkhtnpkkn14(C_Htnpkkn pVhsyudisptkhtnpkkn14);

    public void setVhsyudisptkhtnpbuicd24(String pVhsyudisptkhtnpbuicd24);

    public void setVhsyudisptkhtnpbuinm24(String pVhsyudisptkhtnpbuinm24);

    public void setVhsyudisptkhtnpkkn24(C_Htnpkkn pVhsyudisptkhtnpkkn24);

    public void setVhsyudisptkhtnpbuicd34(String pVhsyudisptkhtnpbuicd34);

    public void setVhsyudisptkhtnpbuinm34(String pVhsyudisptkhtnpbuinm34);

    public void setVhsyudisptkhtnpkkn34(C_Htnpkkn pVhsyudisptkhtnpkkn34);

    public void setVhsyudisptkhtnpbuicd44(String pVhsyudisptkhtnpbuicd44);

    public void setVhsyudisptkhtnpbuinm44(String pVhsyudisptkhtnpbuinm44);

    public void setVhsyudisptkhtnpkkn44(C_Htnpkkn pVhsyudisptkhtnpkkn44);

    public void setVhsyudisptktkkdsghtpkbn4(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn4);

    public void setVhsyudisptktutakngk4(BizCurrency pVhsyudisptktutakngk4);

    public void setVhsyudisptkkrkhasseiymd4(BizDate pVhsyudisptkkrkhasseiymd4);

    public void setVhsyudisptksyouhnnm5(String pVhsyudisptksyouhnnm5);

    public void setVhsyudisptkktuukasyu5(C_Tuukasyu pVhsyudisptkktuukasyu5);

    public void setVhsyudisptokyakukatakbn5(C_KataKbn pVhsyudisptokyakukatakbn5);

    public void setVhsyudisptkkyhgdkatakbn5(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn5);

    public void setVhsyudisptkhhknnen5(Integer pVhsyudisptkhhknnen5);

    public void setVhsyudisptkkykymd5(BizDate pVhsyudisptkkykymd5);

    public void setVhsyudisptksknnkaisiymd5(BizDate pVhsyudisptksknnkaisiymd5);

    public void setVhsyudisptkgaskkaisiymd5(BizDate pVhsyudisptkgaskkaisiymd5);

    public void setVhsyudisptkhkskkaisiymd5(BizDate pVhsyudisptkhkskkaisiymd5);

    public void setVhsyudisptkhkgskksiymd5(BizDate pVhsyudisptkhkgskksiymd5);

    public void setVhsyudisptkhknkkn5(Integer pVhsyudisptkhknkkn5);

    public void setVhsyudisptkhknkknsmnkbn5(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn5);

    public void setVhsyudisptkhrkkkn5(Integer pVhsyudisptkhrkkkn5);

    public void setVhsyudisptkhrkkknsmnkbn5(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn5);

    public void setVhsyudisptkkihsyuruikbn5(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn5);

    public void setVhsyudisptkkihons5(BizCurrency pVhsyudisptkkihons5);

    public void setVhsyudisptkp5(BizCurrency pVhsyudisptkp5);

    public void setVhsyudisptkkihonkyhgk5(BizCurrency pVhsyudisptkkihonkyhgk5);

    public void setVhsyudisptknextkosgop5(BizCurrency pVhsyudisptknextkosgop5);

    public void setVhsyudisptksykyhkatakbn5(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn5);

    public void setVhsyudisptk6daildkbn5(C_6daiLdKbn pVhsyudisptk6daildkbn5);

    public void setVhsyudisptkganyukyhntgk5(BizCurrency pVhsyudisptkganyukyhntgk5);

    public void setVhsyudisptkshrskgstrymd5(BizDate pVhsyudisptkshrskgstrymd5);

    public void setVhsyudisptkshrskgnedymd5(BizDate pVhsyudisptkshrskgnedymd5);

    public void setVhsyudisptkshrskgngos5(BizCurrency pVhsyudisptkshrskgngos5);

    public void setVhsyudisptknenkinsyukbn5(C_Nenkinsyu pVhsyudisptknenkinsyukbn5);

    public void setVhsyudisptknenkinkkn5(Integer pVhsyudisptknenkinkkn5);

    public void setVhsyudisptktkjyskgnkkn5(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn5);

    public void setVhsyudisptktkjkhkdsymd15(BizDate pVhsyudisptktkjkhkdsymd15);

    public void setVhsyudisptktkjkhkdeymd15(BizDate pVhsyudisptktkjkhkdeymd15);

    public void setVhsyudisptktkjyskgns15(BizCurrency pVhsyudisptktkjyskgns15);

    public void setVhsyudisptktkjkhkdsymd25(BizDate pVhsyudisptktkjkhkdsymd25);

    public void setVhsyudisptktkjkhkdeymd25(BizDate pVhsyudisptktkjkhkdeymd25);

    public void setVhsyudisptktkjyskgns25(BizCurrency pVhsyudisptktkjyskgns25);

    public void setVhsyudisptktkjkhkdsymd35(BizDate pVhsyudisptktkjkhkdsymd35);

    public void setVhsyudisptktkjkhkdeymd35(BizDate pVhsyudisptktkjkhkdeymd35);

    public void setVhsyudisptktkjyskgns35(BizCurrency pVhsyudisptktkjyskgns35);

    public void setVhsyudisptktkjkhkdsymd45(BizDate pVhsyudisptktkjkhkdsymd45);

    public void setVhsyudisptktkjkhkdeymd45(BizDate pVhsyudisptktkjkhkdeymd45);

    public void setVhsyudisptktkjyskgns45(BizCurrency pVhsyudisptktkjyskgns45);

    public void setVhsyudisptktkjkhkdsymd55(BizDate pVhsyudisptktkjkhkdsymd55);

    public void setVhsyudisptktkjkhkdeymd55(BizDate pVhsyudisptktkjkhkdeymd55);

    public void setVhsyudisptktkjyskgns55(BizCurrency pVhsyudisptktkjyskgns55);

    public void setVhsyudisptktkjyhyouten5(C_Tkjyhyouten pVhsyudisptktkjyhyouten5);

    public void setVhsyudisptktkjyp5(BizCurrency pVhsyudisptktkjyp5);

    public void setVhsyudisptkhtnpbuicd15(String pVhsyudisptkhtnpbuicd15);

    public void setVhsyudisptkhtnpbuinm15(String pVhsyudisptkhtnpbuinm15);

    public void setVhsyudisptkhtnpkkn15(C_Htnpkkn pVhsyudisptkhtnpkkn15);

    public void setVhsyudisptkhtnpbuicd25(String pVhsyudisptkhtnpbuicd25);

    public void setVhsyudisptkhtnpbuinm25(String pVhsyudisptkhtnpbuinm25);

    public void setVhsyudisptkhtnpkkn25(C_Htnpkkn pVhsyudisptkhtnpkkn25);

    public void setVhsyudisptkhtnpbuicd35(String pVhsyudisptkhtnpbuicd35);

    public void setVhsyudisptkhtnpbuinm35(String pVhsyudisptkhtnpbuinm35);

    public void setVhsyudisptkhtnpkkn35(C_Htnpkkn pVhsyudisptkhtnpkkn35);

    public void setVhsyudisptkhtnpbuicd45(String pVhsyudisptkhtnpbuicd45);

    public void setVhsyudisptkhtnpbuinm45(String pVhsyudisptkhtnpbuinm45);

    public void setVhsyudisptkhtnpkkn45(C_Htnpkkn pVhsyudisptkhtnpkkn45);

    public void setVhsyudisptktkkdsghtpkbn5(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn5);

    public void setVhsyudisptktutakngk5(BizCurrency pVhsyudisptktutakngk5);

    public void setVhsyudisptkkrkhasseiymd5(BizDate pVhsyudisptkkrkhasseiymd5);

    public void setVhsyudisptksyouhnnm6(String pVhsyudisptksyouhnnm6);

    public void setVhsyudisptkktuukasyu6(C_Tuukasyu pVhsyudisptkktuukasyu6);

    public void setVhsyudisptokyakukatakbn6(C_KataKbn pVhsyudisptokyakukatakbn6);

    public void setVhsyudisptkkyhgdkatakbn6(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn6);

    public void setVhsyudisptkhhknnen6(Integer pVhsyudisptkhhknnen6);

    public void setVhsyudisptkkykymd6(BizDate pVhsyudisptkkykymd6);

    public void setVhsyudisptksknnkaisiymd6(BizDate pVhsyudisptksknnkaisiymd6);

    public void setVhsyudisptkgaskkaisiymd6(BizDate pVhsyudisptkgaskkaisiymd6);

    public void setVhsyudisptkhkskkaisiymd6(BizDate pVhsyudisptkhkskkaisiymd6);

    public void setVhsyudisptkhkgskksiymd6(BizDate pVhsyudisptkhkgskksiymd6);

    public void setVhsyudisptkhknkkn6(Integer pVhsyudisptkhknkkn6);

    public void setVhsyudisptkhknkknsmnkbn6(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn6);

    public void setVhsyudisptkhrkkkn6(Integer pVhsyudisptkhrkkkn6);

    public void setVhsyudisptkhrkkknsmnkbn6(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn6);

    public void setVhsyudisptkkihsyuruikbn6(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn6);

    public void setVhsyudisptkkihons6(BizCurrency pVhsyudisptkkihons6);

    public void setVhsyudisptkp6(BizCurrency pVhsyudisptkp6);

    public void setVhsyudisptkkihonkyhgk6(BizCurrency pVhsyudisptkkihonkyhgk6);

    public void setVhsyudisptknextkosgop6(BizCurrency pVhsyudisptknextkosgop6);

    public void setVhsyudisptksykyhkatakbn6(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn6);

    public void setVhsyudisptk6daildkbn6(C_6daiLdKbn pVhsyudisptk6daildkbn6);

    public void setVhsyudisptkganyukyhntgk6(BizCurrency pVhsyudisptkganyukyhntgk6);

    public void setVhsyudisptkshrskgstrymd6(BizDate pVhsyudisptkshrskgstrymd6);

    public void setVhsyudisptkshrskgnedymd6(BizDate pVhsyudisptkshrskgnedymd6);

    public void setVhsyudisptkshrskgngos6(BizCurrency pVhsyudisptkshrskgngos6);

    public void setVhsyudisptknenkinsyukbn6(C_Nenkinsyu pVhsyudisptknenkinsyukbn6);

    public void setVhsyudisptknenkinkkn6(Integer pVhsyudisptknenkinkkn6);

    public void setVhsyudisptktkjyskgnkkn6(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn6);

    public void setVhsyudisptktkjkhkdsymd16(BizDate pVhsyudisptktkjkhkdsymd16);

    public void setVhsyudisptktkjkhkdeymd16(BizDate pVhsyudisptktkjkhkdeymd16);

    public void setVhsyudisptktkjyskgns16(BizCurrency pVhsyudisptktkjyskgns16);

    public void setVhsyudisptktkjkhkdsymd26(BizDate pVhsyudisptktkjkhkdsymd26);

    public void setVhsyudisptktkjkhkdeymd26(BizDate pVhsyudisptktkjkhkdeymd26);

    public void setVhsyudisptktkjyskgns26(BizCurrency pVhsyudisptktkjyskgns26);

    public void setVhsyudisptktkjkhkdsymd36(BizDate pVhsyudisptktkjkhkdsymd36);

    public void setVhsyudisptktkjkhkdeymd36(BizDate pVhsyudisptktkjkhkdeymd36);

    public void setVhsyudisptktkjyskgns36(BizCurrency pVhsyudisptktkjyskgns36);

    public void setVhsyudisptktkjkhkdsymd46(BizDate pVhsyudisptktkjkhkdsymd46);

    public void setVhsyudisptktkjkhkdeymd46(BizDate pVhsyudisptktkjkhkdeymd46);

    public void setVhsyudisptktkjyskgns46(BizCurrency pVhsyudisptktkjyskgns46);

    public void setVhsyudisptktkjkhkdsymd56(BizDate pVhsyudisptktkjkhkdsymd56);

    public void setVhsyudisptktkjkhkdeymd56(BizDate pVhsyudisptktkjkhkdeymd56);

    public void setVhsyudisptktkjyskgns56(BizCurrency pVhsyudisptktkjyskgns56);

    public void setVhsyudisptktkjyhyouten6(C_Tkjyhyouten pvhsyudisptktkjyhyouten6);

    public void setVhsyudisptktkjyp6(BizCurrency pVhsyudisptktkjyp6);

    public void setVhsyudisptkhtnpbuicd16(String pVhsyudisptkhtnpbuicd16);

    public void setVhsyudisptkhtnpbuinm16(String pVhsyudisptkhtnpbuinm16);

    public void setVhsyudisptkhtnpkkn16(C_Htnpkkn pVhsyudisptkhtnpkkn16);

    public void setVhsyudisptkhtnpbuicd26(String pVhsyudisptkhtnpbuicd26);

    public void setVhsyudisptkhtnpbuinm26(String pVhsyudisptkhtnpbuinm26);

    public void setVhsyudisptkhtnpkkn26(C_Htnpkkn pVhsyudisptkhtnpkkn26);

    public void setVhsyudisptkhtnpbuicd36(String pVhsyudisptkhtnpbuicd36);

    public void setVhsyudisptkhtnpbuinm36(String pVhsyudisptkhtnpbuinm36);

    public void setVhsyudisptkhtnpkkn36(C_Htnpkkn pVhsyudisptkhtnpkkn36);

    public void setVhsyudisptkhtnpbuicd46(String pVhsyudisptkhtnpbuicd46);

    public void setVhsyudisptkhtnpbuinm46(String pVhsyudisptkhtnpbuinm46);

    public void setVhsyudisptkhtnpkkn46(C_Htnpkkn pVhsyudisptkhtnpkkn46);

    public void setVhsyudisptktkkdsghtpkbn6(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn6);

    public void setVhsyudisptktutakngk6(BizCurrency pVhsyudisptktutakngk6);

    public void setVhsyudisptkkrkhasseiymd6(BizDate pVhsyudisptkkrkhasseiymd6);

    public void setVhsyudisptksyouhnnm7(String pVhsyudisptksyouhnnm7);

    public void setVhsyudisptkktuukasyu7(C_Tuukasyu pVhsyudisptkktuukasyu7);

    public void setVhsyudisptokyakukatakbn7(C_KataKbn pVhsyudisptokyakukatakbn7);

    public void setVhsyudisptkkyhgdkatakbn7(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn7);

    public void setVhsyudisptkhhknnen7(Integer pVhsyudisptkhhknnen7);

    public void setVhsyudisptkkykymd7(BizDate pVhsyudisptkkykymd7);

    public void setVhsyudisptksknnkaisiymd7(BizDate pVhsyudisptksknnkaisiymd7);

    public void setVhsyudisptkgaskkaisiymd7(BizDate pVhsyudisptkgaskkaisiymd7);

    public void setVhsyudisptkhkskkaisiymd7(BizDate pVhsyudisptkhkskkaisiymd7);

    public void setVhsyudisptkhkgskksiymd7(BizDate pVhsyudisptkhkgskksiymd7);

    public void setVhsyudisptkhknkkn7(Integer pVhsyudisptkhknkkn7);

    public void setVhsyudisptkhknkknsmnkbn7(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn7);

    public void setVhsyudisptkhrkkkn7(Integer pVhsyudisptkhrkkkn7);

    public void setVhsyudisptkhrkkknsmnkbn7(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn7);

    public void setVhsyudisptkkihsyuruikbn7(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn7);

    public void setVhsyudisptkkihons7(BizCurrency pVhsyudisptkkihons7);

    public void setVhsyudisptkp7(BizCurrency pVhsyudisptkp7);

    public void setVhsyudisptkkihonkyhgk7(BizCurrency pVhsyudisptkkihonkyhgk7);

    public void setVhsyudisptknextkosgop7(BizCurrency pVhsyudisptknextkosgop7);

    public void setVhsyudisptksykyhkatakbn7(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn7);

    public void setVhsyudisptk6daildkbn7(C_6daiLdKbn pVhsyudisptk6daildkbn7);

    public void setVhsyudisptkganyukyhntgk7(BizCurrency pVhsyudisptkganyukyhntgk7);

    public void setVhsyudisptkshrskgstrymd7(BizDate pVhsyudisptkshrskgstrymd7);

    public void setVhsyudisptkshrskgnedymd7(BizDate pVhsyudisptkshrskgnedymd7);

    public void setVhsyudisptkshrskgngos7(BizCurrency pVhsyudisptkshrskgngos7);

    public void setVhsyudisptknenkinsyukbn7(C_Nenkinsyu pVhsyudisptknenkinsyukbn7);

    public void setVhsyudisptknenkinkkn7(Integer pVhsyudisptknenkinkkn7);

    public void setVhsyudisptktkjyskgnkkn7(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn7);

    public void setVhsyudisptktkjkhkdsymd17(BizDate pVhsyudisptktkjkhkdsymd17);

    public void setVhsyudisptktkjkhkdeymd17(BizDate pVhsyudisptktkjkhkdeymd17);

    public void setVhsyudisptktkjyskgns17(BizCurrency pVhsyudisptktkjyskgns17);

    public void setVhsyudisptktkjkhkdsymd27(BizDate pVhsyudisptktkjkhkdsymd27);

    public void setVhsyudisptktkjkhkdeymd27(BizDate pVhsyudisptktkjkhkdeymd27);

    public void setVhsyudisptktkjyskgns27(BizCurrency pVhsyudisptktkjyskgns27);

    public void setVhsyudisptktkjkhkdsymd37(BizDate pVhsyudisptktkjkhkdsymd37);

    public void setVhsyudisptktkjkhkdeymd37(BizDate pVhsyudisptktkjkhkdeymd37);

    public void setVhsyudisptktkjyskgns37(BizCurrency pVhsyudisptktkjyskgns37);

    public void setVhsyudisptktkjkhkdsymd47(BizDate pVhsyudisptktkjkhkdsymd47);

    public void setVhsyudisptktkjkhkdeymd47(BizDate pVhsyudisptktkjkhkdeymd47);

    public void setVhsyudisptktkjyskgns47(BizCurrency pVhsyudisptktkjyskgns47);

    public void setVhsyudisptktkjkhkdsymd57(BizDate pVhsyudisptktkjkhkdsymd57);

    public void setVhsyudisptktkjkhkdeymd57(BizDate pVhsyudisptktkjkhkdeymd57);

    public void setVhsyudisptktkjyskgns57(BizCurrency pVhsyudisptktkjyskgns57);

    public void setVhsyudisptktkjyhyouten7(C_Tkjyhyouten pVhsyudisptktkjyhyouten7);

    public void setVhsyudisptktkjyp7(BizCurrency pVhsyudisptktkjyp7);

    public void setVhsyudisptkhtnpbuicd17(String pVhsyudisptkhtnpbuicd17);

    public void setVhsyudisptkhtnpbuinm17(String pVhsyudisptkhtnpbuinm17);

    public void setVhsyudisptkhtnpkkn17(C_Htnpkkn pVhsyudisptkhtnpkkn17);

    public void setVhsyudisptkhtnpbuicd27(String pVhsyudisptkhtnpbuicd27);

    public void setVhsyudisptkhtnpbuinm27(String pVhsyudisptkhtnpbuinm27);

    public void setVhsyudisptkhtnpkkn27(C_Htnpkkn pVhsyudisptkhtnpkkn27);

    public void setVhsyudisptkhtnpbuicd37(String pVhsyudisptkhtnpbuicd37);

    public void setVhsyudisptkhtnpbuinm37(String pVhsyudisptkhtnpbuinm37);

    public void setVhsyudisptkhtnpkkn37(C_Htnpkkn pVhsyudisptkhtnpkkn37);

    public void setVhsyudisptkhtnpbuicd47(String pVhsyudisptkhtnpbuicd47);

    public void setVhsyudisptkhtnpbuinm47(String pVhsyudisptkhtnpbuinm47);

    public void setVhsyudisptkhtnpkkn47(C_Htnpkkn pVhsyudisptkhtnpkkn47);

    public void setVhsyudisptktkkdsghtpkbn7(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn7);

    public void setVhsyudisptktutakngk7(BizCurrency pVhsyudisptktutakngk7);

    public void setVhsyudisptkkrkhasseiymd7(BizDate pVhsyudisptkkrkhasseiymd7);

    public void setVhsyudisptksyouhnnm8(String pVhsyudisptksyouhnnm8);

    public void setVhsyudisptkktuukasyu8(C_Tuukasyu pVhsyudisptkktuukasyu8);

    public void setVhsyudisptokyakukatakbn8(C_KataKbn pVhsyudisptokyakukatakbn8);

    public void setVhsyudisptkkyhgdkatakbn8(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn8);

    public void setVhsyudisptkhhknnen8(Integer pVhsyudisptkhhknnen8);

    public void setVhsyudisptkkykymd8(BizDate pVhsyudisptkkykymd8);

    public void setVhsyudisptksknnkaisiymd8(BizDate pVhsyudisptksknnkaisiymd8);

    public void setVhsyudisptkgaskkaisiymd8(BizDate pVhsyudisptkgaskkaisiymd8);

    public void setVhsyudisptkhkskkaisiymd8(BizDate pVhsyudisptkhkskkaisiymd8);

    public void setVhsyudisptkhkgskksiymd8(BizDate pVhsyudisptkhkgskksiymd8);

    public void setVhsyudisptkhknkkn8(Integer pVhsyudisptkhknkkn8);

    public void setVhsyudisptkhknkknsmnkbn8(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn8);

    public void setVhsyudisptkhrkkkn8(Integer pVhsyudisptkhrkkkn8);

    public void setVhsyudisptkhrkkknsmnkbn8(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn8);

    public void setVhsyudisptkkihsyuruikbn8(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn8);

    public void setVhsyudisptkkihons8(BizCurrency pVhsyudisptkkihons8);

    public void setVhsyudisptkp8(BizCurrency pVhsyudisptkp8);

    public void setVhsyudisptkkihonkyhgk8(BizCurrency pVhsyudisptkkihonkyhgk8);

    public void setVhsyudisptknextkosgop8(BizCurrency pVhsyudisptknextkosgop8);

    public void setVhsyudisptksykyhkatakbn8(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn8);

    public void setVhsyudisptk6daildkbn8(C_6daiLdKbn pVhsyudisptk6daildkbn8);

    public void setVhsyudisptkganyukyhntgk8(BizCurrency pVhsyudisptkganyukyhntgk8);

    public void setVhsyudisptkshrskgstrymd8(BizDate pVhsyudisptkshrskgstrymd8);

    public void setVhsyudisptkshrskgnedymd8(BizDate pVhsyudisptkshrskgnedymd8);

    public void setVhsyudisptkshrskgngos8(BizCurrency pVhsyudisptkshrskgngos8);

    public void setVhsyudisptknenkinsyukbn8(C_Nenkinsyu pVhsyudisptknenkinsyukbn8);

    public void setVhsyudisptknenkinkkn8(Integer pVhsyudisptknenkinkkn8);

    public void setVhsyudisptktkjyskgnkkn8(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn8);

    public void setVhsyudisptktkjkhkdsymd18(BizDate pVhsyudisptktkjkhkdsymd18);

    public void setVhsyudisptktkjkhkdeymd18(BizDate pVhsyudisptktkjkhkdeymd18);

    public void setVhsyudisptktkjyskgns18(BizCurrency pVhsyudisptktkjyskgns18);

    public void setVhsyudisptktkjkhkdsymd28(BizDate pVhsyudisptktkjkhkdsymd28);

    public void setVhsyudisptktkjkhkdeymd28(BizDate pVhsyudisptktkjkhkdeymd28);

    public void setVhsyudisptktkjyskgns28(BizCurrency pVhsyudisptktkjyskgns28);

    public void setVhsyudisptktkjkhkdsymd38(BizDate pVhsyudisptktkjkhkdsymd38);

    public void setVhsyudisptktkjkhkdeymd38(BizDate pVhsyudisptktkjkhkdeymd38);

    public void setVhsyudisptktkjyskgns38(BizCurrency pVhsyudisptktkjyskgns38);

    public void setVhsyudisptktkjkhkdsymd48(BizDate pVhsyudisptktkjkhkdsymd48);

    public void setVhsyudisptktkjkhkdeymd48(BizDate pVhsyudisptktkjkhkdeymd48);

    public void setVhsyudisptktkjyskgns48(BizCurrency pVhsyudisptktkjyskgns48);

    public void setVhsyudisptktkjkhkdsymd58(BizDate pVhsyudisptktkjkhkdsymd58);

    public void setVhsyudisptktkjkhkdeymd58(BizDate pVhsyudisptktkjkhkdeymd58);

    public void setVhsyudisptktkjyskgns58(BizCurrency pVhsyudisptktkjyskgns58);

    public void setVhsyudisptktkjyhyouten8(C_Tkjyhyouten pVhsyudisptktkjyhyouten8);

    public void setVhsyudisptktkjyp8(BizCurrency pVhsyudisptktkjyp8);

    public void setVhsyudisptkhtnpbuicd18(String pVhsyudisptkhtnpbuicd18);

    public void setVhsyudisptkhtnpbuinm18(String pVhsyudisptkhtnpbuinm18);

    public void setVhsyudisptkhtnpkkn18(C_Htnpkkn pVhsyudisptkhtnpkkn18);

    public void setVhsyudisptkhtnpbuicd28(String pVhsyudisptkhtnpbuicd28);

    public void setVhsyudisptkhtnpbuinm28(String pVhsyudisptkhtnpbuinm28);

    public void setVhsyudisptkhtnpkkn28(C_Htnpkkn pVhsyudisptkhtnpkkn28);

    public void setVhsyudisptkhtnpbuicd38(String pVhsyudisptkhtnpbuicd38);

    public void setVhsyudisptkhtnpbuinm38(String pVhsyudisptkhtnpbuinm38);

    public void setVhsyudisptkhtnpkkn38(C_Htnpkkn pVhsyudisptkhtnpkkn38);

    public void setVhsyudisptkhtnpbuicd48(String pVhsyudisptkhtnpbuicd48);

    public void setVhsyudisptkhtnpbuinm48(String pVhsyudisptkhtnpbuinm48);

    public void setVhsyudisptkhtnpkkn48(C_Htnpkkn pVhsyudisptkhtnpkkn48);

    public void setVhsyudisptktkkdsghtpkbn8(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn8);

    public void setVhsyudisptktutakngk8(BizCurrency pVhsyudisptktutakngk8);

    public void setVhsyudisptkkrkhasseiymd8(BizDate pVhsyudisptkkrkhasseiymd8);

    public void setVhsyudisptksyouhnnm9(String pVhsyudisptksyouhnnm9);

    public void setVhsyudisptkktuukasyu9(C_Tuukasyu pVhsyudisptkktuukasyu9);

    public void setVhsyudisptokyakukatakbn9(C_KataKbn pVhsyudisptokyakukatakbn9);

    public void setVhsyudisptkkyhgdkatakbn9(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn9);

    public void setVhsyudisptkhhknnen9(Integer pVhsyudisptkhhknnen9);

    public void setVhsyudisptkkykymd9(BizDate pVhsyudisptkkykymd9);

    public void setVhsyudisptksknnkaisiymd9(BizDate pVhsyudisptksknnkaisiymd9);

    public void setVhsyudisptkgaskkaisiymd9(BizDate pVhsyudisptkgaskkaisiymd9);

    public void setVhsyudisptkhkskkaisiymd9(BizDate pVhsyudisptkhkskkaisiymd9);

    public void setVhsyudisptkhkgskksiymd9(BizDate pVhsyudisptkhkgskksiymd9);

    public void setVhsyudisptkhknkkn9(Integer pVhsyudisptkhknkkn9);

    public void setVhsyudisptkhknkknsmnkbn9(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn9);

    public void setVhsyudisptkhrkkkn9(Integer pVhsyudisptkhrkkkn9);

    public void setVhsyudisptkhrkkknsmnkbn9(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn9);

    public void setVhsyudisptkkihsyuruikbn9(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn9);

    public void setVhsyudisptkkihons9(BizCurrency pVhsyudisptkkihons9);

    public void setVhsyudisptkp9(BizCurrency pVhsyudisptkp9);

    public void setVhsyudisptkkihonkyhgk9(BizCurrency pVhsyudisptkkihonkyhgk9);

    public void setVhsyudisptknextkosgop9(BizCurrency pVhsyudisptknextkosgop9);

    public void setVhsyudisptksykyhkatakbn9(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn9);

    public void setVhsyudisptk6daildkbn9(C_6daiLdKbn pVhsyudisptk6daildkbn9);

    public void setVhsyudisptkganyukyhntgk9(BizCurrency pVhsyudisptkganyukyhntgk9);

    public void setVhsyudisptkshrskgstrymd9(BizDate pVhsyudisptkshrskgstrymd9);

    public void setVhsyudisptkshrskgnedymd9(BizDate pVhsyudisptkshrskgnedymd9);

    public void setVhsyudisptkshrskgngos9(BizCurrency pVhsyudisptkshrskgngos9);

    public void setVhsyudisptknenkinsyukbn9(C_Nenkinsyu pVhsyudisptknenkinsyukbn9);

    public void setVhsyudisptknenkinkkn9(Integer pVhsyudisptknenkinkkn9);

    public void setVhsyudisptktkjyskgnkkn9(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn9);

    public void setVhsyudisptktkjkhkdsymd19(BizDate pVhsyudisptktkjkhkdsymd19);

    public void setVhsyudisptktkjkhkdeymd19(BizDate pVhsyudisptktkjkhkdeymd19);

    public void setVhsyudisptktkjyskgns19(BizCurrency pVhsyudisptktkjyskgns19);

    public void setVhsyudisptktkjkhkdsymd29(BizDate pVhsyudisptktkjkhkdsymd29);

    public void setVhsyudisptktkjkhkdeymd29(BizDate pVhsyudisptktkjkhkdeymd29);

    public void setVhsyudisptktkjyskgns29(BizCurrency pVhsyudisptktkjyskgns29);

    public void setVhsyudisptktkjkhkdsymd39(BizDate pVhsyudisptktkjkhkdsymd39);

    public void setVhsyudisptktkjkhkdeymd39(BizDate pVhsyudisptktkjkhkdeymd39);

    public void setVhsyudisptktkjyskgns39(BizCurrency pVhsyudisptktkjyskgns39);

    public void setVhsyudisptktkjkhkdsymd49(BizDate pVhsyudisptktkjkhkdsymd49);

    public void setVhsyudisptktkjkhkdeymd49(BizDate pVhsyudisptktkjkhkdeymd49);

    public void setVhsyudisptktkjyskgns49(BizCurrency pVhsyudisptktkjyskgns49);

    public void setVhsyudisptktkjkhkdsymd59(BizDate pVhsyudisptktkjkhkdsymd59);

    public void setVhsyudisptktkjkhkdeymd59(BizDate pVhsyudisptktkjkhkdeymd59);

    public void setVhsyudisptktkjyskgns59(BizCurrency pVhsyudisptktkjyskgns59);

    public void setVhsyudisptktkjyhyouten9(C_Tkjyhyouten pVhsyudisptktkjyhyouten9);

    public void setVhsyudisptktkjyp9(BizCurrency pVhsyudisptktkjyp9);

    public void setVhsyudisptkhtnpbuicd19(String pVhsyudisptkhtnpbuicd19);

    public void setVhsyudisptkhtnpbuinm19(String pVhsyudisptkhtnpbuinm19);

    public void setVhsyudisptkhtnpkkn19(C_Htnpkkn pVhsyudisptkhtnpkkn19);

    public void setVhsyudisptkhtnpbuicd29(String pVhsyudisptkhtnpbuicd29);

    public void setVhsyudisptkhtnpbuinm29(String pVhsyudisptkhtnpbuinm29);

    public void setVhsyudisptkhtnpkkn29(C_Htnpkkn pVhsyudisptkhtnpkkn29);

    public void setVhsyudisptkhtnpbuicd39(String pVhsyudisptkhtnpbuicd39);

    public void setVhsyudisptkhtnpbuinm39(String pVhsyudisptkhtnpbuinm39);

    public void setVhsyudisptkhtnpkkn39(C_Htnpkkn pVhsyudisptkhtnpkkn39);

    public void setVhsyudisptkhtnpbuicd49(String pVhsyudisptkhtnpbuicd49);

    public void setVhsyudisptkhtnpbuinm49(String pVhsyudisptkhtnpbuinm49);

    public void setVhsyudisptkhtnpkkn49(C_Htnpkkn pVhsyudisptkhtnpkkn49);

    public void setVhsyudisptktkkdsghtpkbn9(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn9);

    public void setVhsyudisptktutakngk9(BizCurrency pVhsyudisptktutakngk9);

    public void setVhsyudisptkkrkhasseiymd9(BizDate pVhsyudisptkkrkhasseiymd9);

    public void setVhsyudisptksyouhnnm10(String pVhsyudisptksyouhnnm10);

    public void setVhsyudisptkktuukasyu10(C_Tuukasyu pVhsyudisptkktuukasyu10);

    public void setVhsyudisptokyakukatakbn10(C_KataKbn pVhsyudisptokyakukatakbn10);

    public void setVhsyudisptkkyhgdkatakbn10(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn10);

    public void setVhsyudisptkhhknnen10(Integer pVhsyudisptkhhknnen10);

    public void setVhsyudisptkkykymd10(BizDate pVhsyudisptkkykymd10);

    public void setVhsyudisptksknnkaisiymd10(BizDate pVhsyudisptksknnkaisiymd10);

    public void setVhsyudisptkgaskkaisiymd10(BizDate pVhsyudisptkgaskkaisiymd10);

    public void setVhsyudisptkhkskkaisiymd10(BizDate pVhsyudisptkhkskkaisiymd10);

    public void setVhsyudisptkhkgskksiymd10(BizDate pVhsyudisptkhkgskksiymd10);

    public void setVhsyudisptkhknkkn10(Integer pVhsyudisptkhknkkn10);

    public void setVhsyudisptkhknkknsmnkbn10(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn10);

    public void setVhsyudisptkhrkkkn10(Integer pVhsyudisptkhrkkkn10);

    public void setVhsyudisptkhrkkknsmnkbn10(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn10);

    public void setVhsyudisptkkihsyuruikbn10(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn10);

    public void setVhsyudisptkkihons10(BizCurrency pVhsyudisptkkihons10);

    public void setVhsyudisptkp10(BizCurrency pVhsyudisptkp10);

    public void setVhsyudisptkkihonkyhgk10(BizCurrency pVhsyudisptkkihonkyhgk10);

    public void setVhsyudisptknextkosgop10(BizCurrency pVhsyudisptknextkosgop10);

    public void setVhsyudisptksykyhkatakbn10(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn10);

    public void setVhsyudisptk6daildkbn10(C_6daiLdKbn pVhsyudisptk6daildkbn10);

    public void setVhsyudisptkganyukyhntgk10(BizCurrency pVhsyudisptkganyukyhntgk10);

    public void setVhsyudisptkshrskgstrymd10(BizDate pVhsyudisptkshrskgstrymd10);

    public void setVhsyudisptkshrskgnedymd10(BizDate pVhsyudisptkshrskgnedymd10);

    public void setVhsyudisptkshrskgngos10(BizCurrency pVhsyudisptkshrskgngos10);

    public void setVhsyudisptknenkinsyukbn10(C_Nenkinsyu pVhsyudisptknenkinsyukbn10);

    public void setVhsyudisptknenkinkkn10(Integer pVhsyudisptknenkinkkn10);

    public void setVhsyudisptktkjyskgnkkn10(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn10);

    public void setVhsyudisptktkjkhkdsymd110(BizDate pVhsyudisptktkjkhkdsymd110);

    public void setVhsyudisptktkjkhkdeymd110(BizDate pVhsyudisptktkjkhkdeymd110);

    public void setVhsyudisptktkjyskgns110(BizCurrency pVhsyudisptktkjyskgns110);

    public void setVhsyudisptktkjkhkdsymd210(BizDate pVhsyudisptktkjkhkdsymd210);

    public void setVhsyudisptktkjkhkdeymd210(BizDate pVhsyudisptktkjkhkdeymd210);

    public void setVhsyudisptktkjyskgns210(BizCurrency pVhsyudisptktkjyskgns210);

    public void setVhsyudisptktkjkhkdsymd310(BizDate pVhsyudisptktkjkhkdsymd310);

    public void setVhsyudisptktkjkhkdeymd310(BizDate pVhsyudisptktkjkhkdeymd310);

    public void setVhsyudisptktkjyskgns310(BizCurrency pVhsyudisptktkjyskgns310);

    public void setVhsyudisptktkjkhkdsymd410(BizDate pVhsyudisptktkjkhkdsymd410);

    public void setVhsyudisptktkjkhkdeymd410(BizDate pVhsyudisptktkjkhkdeymd410);

    public void setVhsyudisptktkjyskgns410(BizCurrency pVhsyudisptktkjyskgns410);

    public void setVhsyudisptktkjkhkdsymd510(BizDate pVhsyudisptktkjkhkdsymd510);

    public void setVhsyudisptktkjkhkdeymd510(BizDate pVhsyudisptktkjkhkdeymd510);

    public void setVhsyudisptktkjyskgns510(BizCurrency pVhsyudisptktkjyskgns510);

    public void setVhsyudisptktkjyhyouten10(C_Tkjyhyouten pVhsyudisptktkjyhyouten10);

    public void setVhsyudisptktkjyp10(BizCurrency pVhsyudisptktkjyp10);

    public void setVhsyudisptkhtnpbuicd110(String pVhsyudisptkhtnpbuicd110);

    public void setVhsyudisptkhtnpbuinm110(String pVhsyudisptkhtnpbuinm110);

    public void setVhsyudisptkhtnpkkn110(C_Htnpkkn pVhsyudisptkhtnpkkn110);

    public void setVhsyudisptkhtnpbuicd210(String pVhsyudisptkhtnpbuicd210);

    public void setVhsyudisptkhtnpbuinm210(String pVhsyudisptkhtnpbuinm210);

    public void setVhsyudisptkhtnpkkn210(C_Htnpkkn pVhsyudisptkhtnpkkn210);

    public void setVhsyudisptkhtnpbuicd310(String pVhsyudisptkhtnpbuicd310);

    public void setVhsyudisptkhtnpbuinm310(String pVhsyudisptkhtnpbuinm310);

    public void setVhsyudisptkhtnpkkn310(C_Htnpkkn pVhsyudisptkhtnpkkn310);

    public void setVhsyudisptkhtnpbuicd410(String pVhsyudisptkhtnpbuicd410);

    public void setVhsyudisptkhtnpbuinm410(String pVhsyudisptkhtnpbuinm410);

    public void setVhsyudisptkhtnpkkn410(C_Htnpkkn pVhsyudisptkhtnpkkn410);

    public void setVhsyudisptktkkdsghtpkbn10(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn10);

    public void setVhsyudisptktutakngk10(BizCurrency pVhsyudisptktutakngk10);

    public void setVhsyudisptkkrkhasseiymd10(BizDate pVhsyudisptkkrkhasseiymd10);

    public void setVhsyusyunkhknumu(C_UmuKbn pVhsyusyunkhknumu);

    public void setVhsyusyugannyukyhumu(C_UmuKbn pVhsyusyugannyukyhumu);

    public void setVhsyusyukhnkyhkgbairitukbn(C_KhnkyhkgbairituKbn pVhsyusyukhnkyhkgbairitukbn);

    public void setVhsyusyusndkyhkinshrskgnumu(C_UmuKbn pVhsyusyusndkyhkinshrskgnumu);

    public void setVhsyusyuhghkumu(C_UmuKbn pVhsyusyuhghkumu);

    public void setVhsyusyunextkosumu(C_UmuKbn pVhsyusyunextkosumu);

    public void setVhsyudisptksyouhncd1(String pVhsyudisptksyouhncd1);

    public void setVhsyudisptksyouhncd2(String pVhsyudisptksyouhncd2);

    public void setVhsyudisptksyouhncd3(String pVhsyudisptksyouhncd3);

    public void setVhsyudisptksyouhncd4(String pVhsyudisptksyouhncd4);

    public void setVhsyudisptksyouhncd5(String pVhsyudisptksyouhncd5);

    public void setVhsyudisptksyouhncd6(String pVhsyudisptksyouhncd6);

    public void setVhsyudisptksyouhncd7(String pVhsyudisptksyouhncd7);

    public void setVhsyudisptksyouhncd8(String pVhsyudisptksyouhncd8);

    public void setVhsyudisptksyouhncd9(String pVhsyudisptksyouhncd9);

    public void setVhsyudisptksyouhncd10(String pVhsyudisptksyouhncd10);

    public void setVhsyudisptknkhknumu1(C_UmuKbn pVhsyudisptknkhknumu1);

    public void setVhsyudisptknkhknumu2(C_UmuKbn pVhsyudisptknkhknumu2);

    public void setVhsyudisptknkhknumu3(C_UmuKbn pVhsyudisptknkhknumu3);

    public void setVhsyudisptknkhknumu4(C_UmuKbn pVhsyudisptknkhknumu4);

    public void setVhsyudisptknkhknumu5(C_UmuKbn pVhsyudisptknkhknumu5);

    public void setVhsyudisptknkhknumu6(C_UmuKbn pVhsyudisptknkhknumu6);

    public void setVhsyudisptknkhknumu7(C_UmuKbn pVhsyudisptknkhknumu7);

    public void setVhsyudisptknkhknumu8(C_UmuKbn pVhsyudisptknkhknumu8);

    public void setVhsyudisptknkhknumu9(C_UmuKbn pVhsyudisptknkhknumu9);

    public void setVhsyudisptknkhknumu10(C_UmuKbn pVhsyudisptknkhknumu10);

    public void setVhsyudisptkhghkumu1(C_UmuKbn pVhsyudisptkhghkumu1);

    public void setVhsyudisptkhghkumu2(C_UmuKbn pVhsyudisptkhghkumu2);

    public void setVhsyudisptkhghkumu3(C_UmuKbn pVhsyudisptkhghkumu3);

    public void setVhsyudisptkhghkumu4(C_UmuKbn pVhsyudisptkhghkumu4);

    public void setVhsyudisptkhghkumu5(C_UmuKbn pVhsyudisptkhghkumu5);

    public void setVhsyudisptkhghkumu6(C_UmuKbn pVhsyudisptkhghkumu6);

    public void setVhsyudisptkhghkumu7(C_UmuKbn pVhsyudisptkhghkumu7);

    public void setVhsyudisptkhghkumu8(C_UmuKbn pVhsyudisptkhghkumu8);

    public void setVhsyudisptkhghkumu9(C_UmuKbn pVhsyudisptkhghkumu9);

    public void setVhsyudisptkhghkumu10(C_UmuKbn pVhsyudisptkhghkumu10);

    public void setVhsyudisptkgannyukyhumu1 (C_UmuKbn pVhsyudisptkgannyukyhumu1 );

    public void setVhsyudisptkgannyukyhumu2(C_UmuKbn pVhsyudisptkgannyukyhumu2);

    public void setVhsyudisptkgannyukyhumu3(C_UmuKbn pVhsyudisptkgannyukyhumu3);

    public void setVhsyudisptkgannyukyhumu4(C_UmuKbn pVhsyudisptkgannyukyhumu4);

    public void setVhsyudisptkgannyukyhumu5(C_UmuKbn pVhsyudisptkgannyukyhumu5);

    public void setVhsyudisptkgannyukyhumu6(C_UmuKbn pVhsyudisptkgannyukyhumu6);

    public void setVhsyudisptkgannyukyhumu7(C_UmuKbn pVhsyudisptkgannyukyhumu7);

    public void setVhsyudisptkgannyukyhumu8(C_UmuKbn pVhsyudisptkgannyukyhumu8);

    public void setVhsyudisptkgannyukyhumu9(C_UmuKbn pVhsyudisptkgannyukyhumu9);

    public void setVhsyudisptkgannyukyhumu10(C_UmuKbn pVhsyudisptkgannyukyhumu10);

    public void setVhsyudisptksndkyhkinshrskgnumu1(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu1);

    public void setVhsyudisptksndkyhkinshrskgnumu2(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu2);

    public void setVhsyudisptksndkyhkinshrskgnumu3(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu3);

    public void setVhsyudisptksndkyhkinshrskgnumu4(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu4);

    public void setVhsyudisptksndkyhkinshrskgnumu5(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu5);

    public void setVhsyudisptksndkyhkinshrskgnumu6(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu6);

    public void setVhsyudisptksndkyhkinshrskgnumu7(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu7);

    public void setVhsyudisptksndkyhkinshrskgnumu8(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu8);

    public void setVhsyudisptksndkyhkinshrskgnumu9(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu9);

    public void setVhsyudisptksndkyhkinshrskgnumu10(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu10);

    public void setVhsyudisptknextkosumu1(C_UmuKbn pVhsyudisptknextkosumu1);

    public void setVhsyudisptknextkosumu2(C_UmuKbn pVhsyudisptknextkosumu2);

    public void setVhsyudisptknextkosumu3(C_UmuKbn pVhsyudisptknextkosumu3);

    public void setVhsyudisptknextkosumu4(C_UmuKbn pVhsyudisptknextkosumu4);

    public void setVhsyudisptknextkosumu5(C_UmuKbn pVhsyudisptknextkosumu5);

    public void setVhsyudisptknextkosumu6(C_UmuKbn pVhsyudisptknextkosumu6);

    public void setVhsyudisptknextkosumu7(C_UmuKbn pVhsyudisptknextkosumu7);

    public void setVhsyudisptknextkosumu8(C_UmuKbn pVhsyudisptknextkosumu8);

    public void setVhsyudisptknextkosumu9(C_UmuKbn pVhsyudisptknextkosumu9);

    public void setVhsyudisptknextkosumu10(C_UmuKbn pVhsyudisptknextkosumu10);

    public void setVhsyusyutsnshrgndhjumu(C_UmuKbn pVhsyusyutsnshrgndhjumu );

    public void setVhsyudispsyutsnshrgndgk(BizCurrency pVhsyudispsyutsnshrgndgk );

    public void setVhsyudisptktsnshrgndhjumu1(C_UmuKbn pVhsyudisptktsnshrgndhjumu1);

    public void setVhsyudisptktsnshrgndhjumu2(C_UmuKbn pVhsyudisptktsnshrgndhjumu2);

    public void setVhsyudisptktsnshrgndhjumu3(C_UmuKbn pVhsyudisptktsnshrgndhjumu3);

    public void setVhsyudisptktsnshrgndhjumu4(C_UmuKbn pVhsyudisptktsnshrgndhjumu4);

    public void setVhsyudisptktsnshrgndhjumu5(C_UmuKbn pVhsyudisptktsnshrgndhjumu5);

    public void setVhsyudisptktsnshrgndhjumu6(C_UmuKbn pVhsyudisptktsnshrgndhjumu6);

    public void setVhsyudisptktsnshrgndhjumu7(C_UmuKbn pVhsyudisptktsnshrgndhjumu7);

    public void setVhsyudisptktsnshrgndhjumu8(C_UmuKbn pVhsyudisptktsnshrgndhjumu8);

    public void setVhsyudisptktsnshrgndhjumu9(C_UmuKbn pVhsyudisptktsnshrgndhjumu9);

    public void setVhsyudisptktsnshrgndhjumu10(C_UmuKbn pVhsyudisptktsnshrgndhjumu10);

    public void setVhsyudisptktsnshrgndgk1(BizCurrency pVhsyudisptktsnshrgndgk1);

    public void setVhsyudisptktsnshrgndgk2(BizCurrency pVhsyudisptktsnshrgndgk2);

    public void setVhsyudisptktsnshrgndgk3(BizCurrency pVhsyudisptktsnshrgndgk3);

    public void setVhsyudisptktsnshrgndgk4(BizCurrency pVhsyudisptktsnshrgndgk4);

    public void setVhsyudisptktsnshrgndgk5(BizCurrency pVhsyudisptktsnshrgndgk5);

    public void setVhsyudisptktsnshrgndgk6(BizCurrency pVhsyudisptktsnshrgndgk6);

    public void setVhsyudisptktsnshrgndgk7(BizCurrency pVhsyudisptktsnshrgndgk7);

    public void setVhsyudisptktsnshrgndgk8(BizCurrency pVhsyudisptktsnshrgndgk8);

    public void setVhsyudisptktsnshrgndgk9(BizCurrency pVhsyudisptktsnshrgndgk9);

    public void setVhsyudisptktsnshrgndgk10(BizCurrency pVhsyudisptktsnshrgndgk10);

    public void setVhsyudisptkkgbairitukbn1(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn1);

    public void setVhsyudisptkkgbairitukbn2(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn2);

    public void setVhsyudisptkkgbairitukbn3(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn3);

    public void setVhsyudisptkkgbairitukbn4(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn4);

    public void setVhsyudisptkkgbairitukbn5(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn5);

    public void setVhsyudisptkkgbairitukbn6(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn6);

    public void setVhsyudisptkkgbairitukbn7(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn7);

    public void setVhsyudisptkkgbairitukbn8(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn8);

    public void setVhsyudisptkkgbairitukbn9(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn9);

    public void setVhsyudisptkkgbairitukbn10(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn10);

    public void setVhsyunstkhukaumukbn(C_UmuKbn pVhsyunstkhukaumukbn);

    public void setVhsyuitijibrumu(C_UmuKbn pVhsyuitijibrumu);

    public void setVhsyugenzaikngkhyjfukaumu(C_UmuKbn pVhsyugenzaikngkhyjfukaumu);

    public void setVhsyuyendthnkjyoutaikbn(C_YendthnkJyoutaiKbn pVhsyuyendthnkjyoutaikbn);

    TbktInfoDataSourceBeanCommonParam createTbktInfoDataSourceBean();

    void convertTbktInfoForCommonParam(List<TbktInfoDataSourceBeanCommonParam> pTbktInfo);


}
