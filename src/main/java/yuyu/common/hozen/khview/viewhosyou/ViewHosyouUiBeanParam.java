package yuyu.common.hozen.khview.viewhosyou;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;
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
 * 契約保全 契約保全画面部品 保障内容表示 <br />
 */
public interface ViewHosyouUiBeanParam extends CommonViewUiBeanParam {

    public String getVhsyusyusyouhnnm();

    public void setVhsyusyusyouhnnm(String pVhsyusyusyouhnnm);

    public C_AisyoumeiKbn getVhsyuaisyoumeikbn();

    public void setVhsyuaisyoumeikbn(C_AisyoumeiKbn pVhsyuaisyoumeikbn);

    public C_Tuukasyu getVhsyusyukyktuukasyu();

    public void setVhsyusyukyktuukasyu(C_Tuukasyu pVhsyusyukyktuukasyu);

    public C_Tuukasyu getVhsyusyukykjisiteituukasyu();

    public void setVhsyusyukykjisiteituukasyu(C_Tuukasyu pVhsyusyukykjisiteituukasyu);

    public C_KataKbn getVhsyusyukatakbn();

    public void setVhsyusyukatakbn(C_KataKbn pVhsyusyukatakbn);

    public C_KyhgndkataKbn getVhsyusyukyhgndkatakbn();

    public void setVhsyusyukyhgndkatakbn(C_KyhgndkataKbn pVhsyusyukyhgndkatakbn);

    public Integer getVhsyusyuhhknnen();

    public void setVhsyusyuhhknnen(Integer pVhsyusyuhhknnen);

    public BizDate getVhsyusyukykymd();

    public void setVhsyusyukykymd(BizDate pVhsyusyukykymd);

    public BizDate getVhsyusyusknnkaisiymd();

    public void setVhsyusyusknnkaisiymd(BizDate pVhsyusyusknnkaisiymd);

    public BizDate getVhsyugansknnkaisiymd();

    public void setVhsyugansknnkaisiymd(BizDate pVhsyugansknnkaisiymd);

    public BizDate getVhsyusyufktsknnkaisiymd();

    public void setVhsyusyufktsknnkaisiymd(BizDate pVhsyusyufktsknnkaisiymd);

    public BizDate getVhsyuhkgogansknnkaisiymd();

    public void setVhsyuhkgogansknnkaisiymd(BizDate pVhsyuhkgogansknnkaisiymd);

    public Integer getVhsyusyuhknkkn();

    public void setVhsyusyuhknkkn(Integer pVhsyusyuhknkkn);

    public C_HknkknsmnKbn getVhsyusyuhknkknsmnkbn();

    public void setVhsyusyuhknkknsmnkbn(C_HknkknsmnKbn pVhsyusyuhknkknsmnkbn);

    public Integer getVhsyudai1hknkkn();

    public void setVhsyudai1hknkkn(Integer pVhsyudai1hknkkn);

    public Integer getVhsyusyuhrkkkn();

    public void setVhsyusyuhrkkkn(Integer pVhsyusyuhrkkkn);

    public C_HrkkknsmnKbn getVhsyusyuhrkkknsmnkbn();

    public void setVhsyusyuhrkkknsmnkbn(C_HrkkknsmnKbn pVhsyusyuhrkkknsmnkbn);

    public C_Sdpd getVhsyusdpdkbn();

    public void setVhsyusdpdkbn(C_Sdpd pVhsyusdpdkbn);

    public C_KihonssyuruiKbn getVhsyusyukihonssyuruikbn();

    public void setVhsyusyukihonssyuruikbn(C_KihonssyuruiKbn pVhsyusyukihonssyuruikbn);

    public BizCurrency getVhsyusyukihons();

    public void setVhsyusyukihons(BizCurrency pVhsyusyukihons);

    public BizCurrency getVhsyusyukykkjnkngk();

    public void setVhsyusyukykkjnkngk(BizCurrency pVhsyusyukykkjnkngk);

    public BizCurrency getVhsyugenzaisbhknkngaku();

    public void setVhsyugenzaisbhknkngaku(BizCurrency pVhsyugenzaisbhknkngaku);

    public BizCurrency getVhsyusaigaisbhknkngaku();

    public void setVhsyusaigaisbhknkngaku(BizCurrency pVhsyusaigaisbhknkngaku);

    public BizCurrency getVhsyudispsyutsnshrgndgk();

    public void setVhsyudispsyutsnshrgndgk(BizCurrency pVhsyudispsyutsnshrgndgk);

    public BizCurrency getVhsyusyup();

    public void setVhsyusyup(BizCurrency pVhsyusyup);

    public BizCurrency getVhsyusyukihonkyhgk();

    public void setVhsyusyukihonkyhgk(BizCurrency pVhsyusyukihonkyhgk);

    public BizCurrency getVhsyusyunextkosgop();

    public void setVhsyusyunextkosgop(BizCurrency pVhsyusyunextkosgop);

    public C_SyukyhkinkataKbn getVhsyusyusyukyhkinkatakbn();

    public void setVhsyusyusyukyhkinkatakbn(C_SyukyhkinkataKbn pVhsyusyusyukyhkinkatakbn);

    public C_6daiLdKbn getVhsyusyurokudaildkbn();

    public void setVhsyusyurokudaildkbn(C_6daiLdKbn pVhsyusyurokudaildkbn);

    public BizCurrency getVhsyusyugannyukyhntgk();

    public void setVhsyusyugannyukyhntgk(BizCurrency pVhsyusyugannyukyhntgk);

    public BizDate getVhsyusyushrskgnstartymd();

    public void setVhsyusyushrskgnstartymd(BizDate pVhsyusyushrskgnstartymd);

    public BizDate getVhsyusyushrskgnendymd();

    public void setVhsyusyushrskgnendymd(BizDate pVhsyusyushrskgnendymd);

    public BizCurrency getVhsyusyushrskgngos();

    public void setVhsyusyushrskgngos(BizCurrency pVhsyusyushrskgngos);

    public C_Nenkinsyu getVhsyusyunnkinsyukbn();

    public void setVhsyusyunnkinsyukbn(C_Nenkinsyu pVhsyusyunnkinsyukbn);

    public Integer getVhsyusyunenkinkkn();

    public void setVhsyusyunenkinkkn(Integer pVhsyusyunenkinkkn);

    public C_Tkjyskgnkkn getVhsyusyutkjyskgnkkn();

    public void setVhsyusyutkjyskgnkkn(C_Tkjyskgnkkn pVhsyusyutkjyskgnkkn);

    public BizDate getVhsyusyutkjyskgnhkndsymd1();

    public void setVhsyusyutkjyskgnhkndsymd1(BizDate pVhsyusyutkjyskgnhkndsymd1);

    public BizDate getVhsyusyutkjyskgnhkndeymd1();

    public void setVhsyusyutkjyskgnhkndeymd1(BizDate pVhsyusyutkjyskgnhkndeymd1);

    public BizCurrency getVhsyusyutkjyskgns1();

    public void setVhsyusyutkjyskgns1(BizCurrency pVhsyusyutkjyskgns1);

    public BizDate getVhsyusyutkjyskgnhkndsymd2();

    public void setVhsyusyutkjyskgnhkndsymd2(BizDate pVhsyusyutkjyskgnhkndsymd2);

    public BizDate getVhsyusyutkjyskgnhkndeymd2();

    public void setVhsyusyutkjyskgnhkndeymd2(BizDate pVhsyusyutkjyskgnhkndeymd2);

    public BizCurrency getVhsyusyutkjyskgns2();

    public void setVhsyusyutkjyskgns2(BizCurrency pVhsyusyutkjyskgns2);

    public BizDate getVhsyusyutkjyskgnhkndsymd3();

    public void setVhsyusyutkjyskgnhkndsymd3(BizDate pVhsyusyutkjyskgnhkndsymd3);

    public BizDate getVhsyusyutkjyskgnhkndeymd3();

    public void setVhsyusyutkjyskgnhkndeymd3(BizDate pVhsyusyutkjyskgnhkndeymd3);

    public BizCurrency getVhsyusyutkjyskgns3();

    public void setVhsyusyutkjyskgns3(BizCurrency pVhsyusyutkjyskgns3);

    public BizDate getVhsyusyutkjyskgnhkndsymd4();

    public void setVhsyusyutkjyskgnhkndsymd4(BizDate pVhsyusyutkjyskgnhkndsymd4);

    public BizDate getVhsyusyutkjyskgnhkndeymd4();

    public void setVhsyusyutkjyskgnhkndeymd4(BizDate pVhsyusyutkjyskgnhkndeymd4);

    public BizCurrency getVhsyusyutkjyskgns4();

    public void setVhsyusyutkjyskgns4(BizCurrency pVhsyusyutkjyskgns4);

    public BizDate getVhsyusyutkjyskgnhkndsymd5();

    public void setVhsyusyutkjyskgnhkndsymd5(BizDate pVhsyusyutkjyskgnhkndsymd5);

    public BizDate getVhsyusyutkjyskgnhkndeymd5();

    public void setVhsyusyutkjyskgnhkndeymd5(BizDate pVhsyusyutkjyskgnhkndeymd5);

    public BizCurrency getVhsyusyutkjyskgns5();

    public void setVhsyusyutkjyskgns5(BizCurrency pVhsyusyutkjyskgns5);

    public C_Tkjyhyouten getVhsyusyutkjyhyouten();

    public void setVhsyusyutkjyhyouten(C_Tkjyhyouten pVhsyusyutkjyhyouten);

    public BizCurrency getVhsyusyutkjyp();

    public void setVhsyusyutkjyp(BizCurrency pVhsyusyutkjyp);

    public String getVhsyusyuhtnpbuicd1();

    public void setVhsyusyuhtnpbuicd1(String pVhsyusyuhtnpbuicd1);

    public String getVhsyusyuhtnpbuinm1();

    public void setVhsyusyuhtnpbuinm1(String pVhsyusyuhtnpbuinm1);

    public C_Htnpkkn getVhsyusyuhtnpkkn1();

    public void setVhsyusyuhtnpkkn1(C_Htnpkkn pVhsyusyuhtnpkkn1);

    public String getVhsyusyuhtnpbuicd2();

    public void setVhsyusyuhtnpbuicd2(String pVhsyusyuhtnpbuicd2);

    public String getVhsyusyuhtnpbuinm2();

    public void setVhsyusyuhtnpbuinm2(String pVhsyusyuhtnpbuinm2);

    public C_Htnpkkn getVhsyusyuhtnpkkn2();

    public void setVhsyusyuhtnpkkn2(C_Htnpkkn pVhsyusyuhtnpkkn2);

    public String getVhsyusyuhtnpbuicd3();

    public void setVhsyusyuhtnpbuicd3(String pVhsyusyuhtnpbuicd3);

    public String getVhsyusyuhtnpbuinm3();

    public void setVhsyusyuhtnpbuinm3(String pVhsyusyuhtnpbuinm3);

    public C_Htnpkkn getVhsyusyuhtnpkkn3();

    public void setVhsyusyuhtnpkkn3(C_Htnpkkn pVhsyusyuhtnpkkn3);

    public String getVhsyusyuhtnpbuicd4();

    public void setVhsyusyuhtnpbuicd4(String pVhsyusyuhtnpbuicd4);

    public String getVhsyusyuhtnpbuinm4();

    public void setVhsyusyuhtnpbuinm4(String pVhsyusyuhtnpbuinm4);

    public C_Htnpkkn getVhsyusyuhtnpkkn4();

    public void setVhsyusyuhtnpkkn4(C_Htnpkkn pVhsyusyuhtnpkkn4);

    public C_TokkoudosghtnpKbn getVhsyusyutokkdsghtnpkbn();

    public void setVhsyusyutokkdsghtnpkbn(C_TokkoudosghtnpKbn pVhsyusyutokkdsghtnpkbn);

    public BizCurrency getVhsyusyututakngk();

    public void setVhsyusyututakngk(BizCurrency pVhsyusyututakngk);

    public BizDate getVhsyusyukouryokuhasseiymd();

    public void setVhsyusyukouryokuhasseiymd(BizDate pVhsyusyukouryokuhasseiymd);

    public C_UmuKbn getVhsyudai1hknkknsbsyokuseiumu();

    public void setVhsyudai1hknkknsbsyokuseiumu(C_UmuKbn pVhsyudai1hknkknsbsyokuseiumu);

    public C_UmuKbn getVhsyusgsbhsyumu();

    public void setVhsyusgsbhsyumu(C_UmuKbn pVhsyusgsbhsyumu);

    public C_HknKknKbn getVhsyuhknKknKbn();

    public void setVhsyuhknKknKbn(C_HknKknKbn pVhsyuhknKknKbn);

    public int getVhsyusyohinhanteikbn();

    public void setVhsyusyohinhanteikbn(int pVhsyusyohinhanteikbn);

    public C_UmuKbn getVhsyumvatekiumu();

    public void setVhsyumvatekiumu(C_UmuKbn pVhsyumvatekiumu);

    public C_UmuKbn getVhsyusbhkuktumu();

    public void setVhsyusbhkuktumu(C_UmuKbn pVhsyusbhkuktumu);

    public C_UmuKbn getVhsyusbkyuuhukinuktumu();

    public void setVhsyusbkyuuhukinuktumu(C_UmuKbn pVhsyusbkyuuhukinuktumu);

    public BizDate getVhsyuyendthnkymd();

    public void setVhsyuyendthnkymd(BizDate pVhsyuyendthnkymd);

    public BizDate getVhsyutmttknitenymd();

    public void setVhsyutmttknitenymd(BizDate pVhsyutmttknitenymd);

    public BizDate getVhsyusyunkshrstartymd();

    public void setVhsyusyunkshrstartymd(BizDate pVhsyusyunkshrstartymd);

    public BizCurrency getVhsyuteiritutmttkngk();
    public void setVhsyuteiritutmttkngk(BizCurrency pVhsyuteiritutmttkngk);

    public BizCurrency getVhsyusisuurendoutmttkngk();
    public void setVhsyusisuurendoutmttkngk(BizCurrency pVhsyusisuurendoutmttkngk);

    public BizCurrency getVhsyugenzaitmttkngk();
    public void setVhsyugenzaitmttkngk(BizCurrency pVhsyugenzaitmttkngk);

    public BizNumber getVhsyusisuurendourate();
    public void setVhsyusisuurendourate(BizNumber pVhsyusisuurendourate);

    public BizNumber getVhsyuteiritutmttrate();
    public void setVhsyuteiritutmttrate(BizNumber pVhsyuteiritutmttrate);

    public String getVhsyusisuunm();
    public void setVhsyusisuunm(String pVhsyusisuunm);

    public BizNumber getVhsyusetteibairitu();
    public void setVhsyusetteibairitu(BizNumber pVhsyusetteibairitu);

    public BizNumber getVhsyuyoteiriritu();

    public void setVhsyuyoteiriritu(BizNumber pVhsyuyoteiriritu);

    public BizNumber getVhsyutumitateriritu();
    public void setVhsyutumitateriritu(BizNumber pVhsyutumitateriritu);

    public BizNumber getVhsyukyktumitateriritu();
    public void setVhsyukyktumitateriritu(BizNumber pVhsyukyktumitateriritu);

    public BizNumber getVhsyu10nentumitateriritu();
    public void setVhsyu10nentumitateriritu(BizNumber pVhsyu10nentumitateriritu);

    public BizNumber getVhsyukyksjkkktyouseiriritu();
    public void setVhsyukyksjkkktyouseiriritu(BizNumber pVhsyukyksjkkktyouseiriritu);

    public BizNumber getVhsyuskisjkkktyouseiriritu();

    public void setVhsyuskisjkkktyouseiriritu(BizNumber pVhsyuskisjkkktyouseiriritu);

    public String getVhsyudisptksyouhnnm();

    public void setVhsyudisptksyouhnnm(String pVhsyudisptksyouhnnm);

    public C_Nstknsyu getVhsyunkshrtkyknksyukbn();

    public void setVhsyunkshrtkyknksyukbn(C_Nstknsyu pVhsyunkshrtkyknksyukbn);

    public Integer getVhsyunkshrtkyknksyukkn();

    public void setVhsyunkshrtkyknksyukkn(Integer pVhsyunkshrtkyknksyukkn);

    public String getVhsyudisptksyouhnnm1();

    public void setVhsyudisptksyouhnnm1(String pVhsyudisptksyouhnnm1);

    public C_Tuukasyu getVhsyudisptkktuukasyu1();

    public void setVhsyudisptkktuukasyu1(C_Tuukasyu pVhsyudisptkktuukasyu1);

    public C_KataKbn getVhsyudisptokyakukatakbn1();

    public void setVhsyudisptokyakukatakbn1(C_KataKbn pVhsyudisptokyakukatakbn1);

    public C_KyhgndkataKbn getVhsyudisptkkyhgdkatakbn1();

    public void setVhsyudisptkkyhgdkatakbn1(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn1);

    public Integer getVhsyudisptkhhknnen1();

    public void setVhsyudisptkhhknnen1(Integer pVhsyudisptkhhknnen1);

    public BizDate getVhsyudisptkkykymd1();

    public void setVhsyudisptkkykymd1(BizDate pVhsyudisptkkykymd1);

    public BizDate getVhsyudisptksknnkaisiymd1();

    public void setVhsyudisptksknnkaisiymd1(BizDate pVhsyudisptksknnkaisiymd1);

    public BizDate getVhsyudisptkgaskkaisiymd1();

    public void setVhsyudisptkgaskkaisiymd1(BizDate pVhsyudisptkgaskkaisiymd1);

    public BizDate getVhsyudisptkhkskkaisiymd1();

    public void setVhsyudisptkhkskkaisiymd1(BizDate pVhsyudisptkhkskkaisiymd1);

    public BizDate getVhsyudisptkhkgskksiymd1();

    public void setVhsyudisptkhkgskksiymd1(BizDate pVhsyudisptkhkgskksiymd1);

    public Integer getVhsyudisptkhknkkn1();

    public void setVhsyudisptkhknkkn1(Integer pVhsyudisptkhknkkn1);

    public C_HknkknsmnKbn getVhsyudisptkhknkknsmnkbn1();

    public void setVhsyudisptkhknkknsmnkbn1(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn1);

    public Integer getVhsyudisptkhrkkkn1();

    public void setVhsyudisptkhrkkkn1(Integer pVhsyudisptkhrkkkn1);

    public C_HrkkknsmnKbn getVhsyudisptkhrkkknsmnkbn1();

    public void setVhsyudisptkhrkkknsmnkbn1(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn1);

    public C_KihonssyuruiKbn getVhsyudisptkkihsyuruikbn1();

    public void setVhsyudisptkkihsyuruikbn1(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn1);

    public BizCurrency getVhsyudisptkkihons1();

    public void setVhsyudisptkkihons1(BizCurrency pVhsyudisptkkihons1);

    public BizCurrency getVhsyudisptktsnshrgndgk1();

    public void setVhsyudisptktsnshrgndgk1(BizCurrency pVhsyudisptktsnshrgndgk1);

    public BizCurrency getVhsyudisptkp1();

    public void setVhsyudisptkp1(BizCurrency pVhsyudisptkp1);

    public BizCurrency getVhsyudisptkkihonkyhgk1();

    public void setVhsyudisptkkihonkyhgk1(BizCurrency pVhsyudisptkkihonkyhgk1);

    public BizCurrency getVhsyudisptknextkosgop1();

    public void setVhsyudisptknextkosgop1(BizCurrency pVhsyudisptknextkosgop1);

    public C_SyukyhkinkataKbn getVhsyudisptksykyhkatakbn1();

    public void setVhsyudisptksykyhkatakbn1(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn1);

    public C_6daiLdKbn getVhsyudisptk6daildkbn1();

    public void setVhsyudisptk6daildkbn1(C_6daiLdKbn pVhsyudisptk6daildkbn1);

    public BizCurrency getVhsyudisptkganyukyhntgk1();

    public void setVhsyudisptkganyukyhntgk1(BizCurrency pVhsyudisptkganyukyhntgk1);

    public BizDate getVhsyudisptkshrskgstrymd1();

    public void setVhsyudisptkshrskgstrymd1(BizDate pVhsyudisptkshrskgstrymd1);

    public BizDate getVhsyudisptkshrskgnedymd1();

    public void setVhsyudisptkshrskgnedymd1(BizDate pVhsyudisptkshrskgnedymd1);

    public BizCurrency getVhsyudisptkshrskgngos1();

    public void setVhsyudisptkshrskgngos1(BizCurrency pVhsyudisptkshrskgngos1);

    public C_Nenkinsyu getVhsyudisptknenkinsyukbn1();

    public void setVhsyudisptknenkinsyukbn1(C_Nenkinsyu pVhsyudisptknenkinsyukbn1);

    public Integer getVhsyudisptknenkinkkn1();

    public void setVhsyudisptknenkinkkn1(Integer pVhsyudisptknenkinkkn1);

    public C_Tkjyskgnkkn getVhsyudisptktkjyskgnkkn1();

    public void setVhsyudisptktkjyskgnkkn1(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn1);

    public BizDate getVhsyudisptktkjkhkdsymd11();

    public void setVhsyudisptktkjkhkdsymd11(BizDate pVhsyudisptktkjkhkdsymd11);

    public BizDate getVhsyudisptktkjkhkdeymd11();

    public void setVhsyudisptktkjkhkdeymd11(BizDate pVhsyudisptktkjkhkdeymd11);

    public BizCurrency getVhsyudisptktkjyskgns11();

    public void setVhsyudisptktkjyskgns11(BizCurrency pVhsyudisptktkjyskgns11);

    public BizDate getVhsyudisptktkjkhkdsymd21();

    public void setVhsyudisptktkjkhkdsymd21(BizDate pVhsyudisptktkjkhkdsymd21);

    public BizDate getVhsyudisptktkjkhkdeymd21();

    public void setVhsyudisptktkjkhkdeymd21(BizDate pVhsyudisptktkjkhkdeymd21);

    public BizCurrency getVhsyudisptktkjyskgns21();

    public void setVhsyudisptktkjyskgns21(BizCurrency pVhsyudisptktkjyskgns21);

    public BizDate getVhsyudisptktkjkhkdsymd31();

    public void setVhsyudisptktkjkhkdsymd31(BizDate pVhsyudisptktkjkhkdsymd31);

    public BizDate getVhsyudisptktkjkhkdeymd31();

    public void setVhsyudisptktkjkhkdeymd31(BizDate pVhsyudisptktkjkhkdeymd31);

    public BizCurrency getVhsyudisptktkjyskgns31();

    public void setVhsyudisptktkjyskgns31(BizCurrency pVhsyudisptktkjyskgns31);

    public BizDate getVhsyudisptktkjkhkdsymd41();

    public void setVhsyudisptktkjkhkdsymd41(BizDate pVhsyudisptktkjkhkdsymd41);

    public BizDate getVhsyudisptktkjkhkdeymd41();

    public void setVhsyudisptktkjkhkdeymd41(BizDate pVhsyudisptktkjkhkdeymd41);

    public BizCurrency getVhsyudisptktkjyskgns41();

    public void setVhsyudisptktkjyskgns41(BizCurrency pVhsyudisptktkjyskgns41);

    public BizDate getVhsyudisptktkjkhkdsymd51();

    public void setVhsyudisptktkjkhkdsymd51(BizDate pVhsyudisptktkjkhkdsymd51);

    public BizDate getVhsyudisptktkjkhkdeymd51();

    public void setVhsyudisptktkjkhkdeymd51(BizDate pVhsyudisptktkjkhkdeymd51);

    public BizCurrency getVhsyudisptktkjyskgns51();

    public void setVhsyudisptktkjyskgns51(BizCurrency pVhsyudisptktkjyskgns51);

    public C_Tkjyhyouten getVhsyudisptktkjyhyouten1();

    public void setVhsyudisptktkjyhyouten1(C_Tkjyhyouten pVhsyudisptktkjyhyouten1);

    public BizCurrency getVhsyudisptktkjyp1();

    public void setVhsyudisptktkjyp1(BizCurrency pVhsyudisptktkjyp1);

    public String getVhsyudisptkhtnpbuicd11();

    public void setVhsyudisptkhtnpbuicd11(String pVhsyudisptkhtnpbuicd11);

    public String getVhsyudisptkhtnpbuinm11();

    public void setVhsyudisptkhtnpbuinm11(String pVhsyudisptkhtnpbuinm11);

    public C_Htnpkkn getVhsyudisptkhtnpkkn11();

    public void setVhsyudisptkhtnpkkn11(C_Htnpkkn pVhsyudisptkhtnpkkn11);

    public String getVhsyudisptkhtnpbuicd21();

    public void setVhsyudisptkhtnpbuicd21(String pVhsyudisptkhtnpbuicd21);

    public String getVhsyudisptkhtnpbuinm21();

    public void setVhsyudisptkhtnpbuinm21(String pVhsyudisptkhtnpbuinm21);

    public C_Htnpkkn getVhsyudisptkhtnpkkn21();

    public void setVhsyudisptkhtnpkkn21(C_Htnpkkn pVhsyudisptkhtnpkkn21);

    public String getVhsyudisptkhtnpbuicd31();

    public void setVhsyudisptkhtnpbuicd31(String pVhsyudisptkhtnpbuicd31);

    public String getVhsyudisptkhtnpbuinm31();

    public void setVhsyudisptkhtnpbuinm31(String pVhsyudisptkhtnpbuinm31);

    public C_Htnpkkn getVhsyudisptkhtnpkkn31();

    public void setVhsyudisptkhtnpkkn31(C_Htnpkkn pVhsyudisptkhtnpkkn31);

    public String getVhsyudisptkhtnpbuicd41();

    public void setVhsyudisptkhtnpbuicd41(String pVhsyudisptkhtnpbuicd41);

    public String getVhsyudisptkhtnpbuinm41();

    public void setVhsyudisptkhtnpbuinm41(String pVhsyudisptkhtnpbuinm41);

    public C_Htnpkkn getVhsyudisptkhtnpkkn41();

    public void setVhsyudisptkhtnpkkn41(C_Htnpkkn pVhsyudisptkhtnpkkn41);

    public C_TokkoudosghtnpKbn getVhsyudisptktkkdsghtpkbn1();

    public void setVhsyudisptktkkdsghtpkbn1(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn1);

    public BizCurrency getVhsyudisptktutakngk1();

    public void setVhsyudisptktutakngk1(BizCurrency pVhsyudisptktutakngk1);

    public BizDate getVhsyudisptkkrkhasseiymd1();

    public void setVhsyudisptkkrkhasseiymd1(BizDate pVhsyudisptkkrkhasseiymd1);

    public String getVhsyudisptksyouhnnm2();

    public void setVhsyudisptksyouhnnm2(String pVhsyudisptksyouhnnm2);

    public C_Tuukasyu getVhsyudisptkktuukasyu2();

    public void setVhsyudisptkktuukasyu2(C_Tuukasyu pVhsyudisptkktuukasyu2);

    public C_KataKbn getVhsyudisptokyakukatakbn2();

    public void setVhsyudisptokyakukatakbn2(C_KataKbn pVhsyudisptokyakukatakbn2);

    public C_KyhgndkataKbn getVhsyudisptkkyhgdkatakbn2();

    public void setVhsyudisptkkyhgdkatakbn2(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn2);

    public Integer getVhsyudisptkhhknnen2();

    public void setVhsyudisptkhhknnen2(Integer pVhsyudisptkhhknnen2);

    public BizDate getVhsyudisptkkykymd2();

    public void setVhsyudisptkkykymd2(BizDate pVhsyudisptkkykymd2);

    public BizDate getVhsyudisptksknnkaisiymd2();

    public void setVhsyudisptksknnkaisiymd2(BizDate pVhsyudisptksknnkaisiymd2);

    public BizDate getVhsyudisptkgaskkaisiymd2();

    public void setVhsyudisptkgaskkaisiymd2(BizDate pVhsyudisptkgaskkaisiymd2);

    public BizDate getVhsyudisptkhkskkaisiymd2();

    public void setVhsyudisptkhkskkaisiymd2(BizDate pVhsyudisptkhkskkaisiymd2);

    public BizDate getVhsyudisptkhkgskksiymd2();

    public void setVhsyudisptkhkgskksiymd2(BizDate pVhsyudisptkhkgskksiymd2);

    public Integer getVhsyudisptkhknkkn2();

    public void setVhsyudisptkhknkkn2(Integer pVhsyudisptkhknkkn2);

    public C_HknkknsmnKbn getVhsyudisptkhknkknsmnkbn2();

    public void setVhsyudisptkhknkknsmnkbn2(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn2);

    public Integer getVhsyudisptkhrkkkn2();

    public void setVhsyudisptkhrkkkn2(Integer pVhsyudisptkhrkkkn2);

    public C_HrkkknsmnKbn getVhsyudisptkhrkkknsmnkbn2();

    public void setVhsyudisptkhrkkknsmnkbn2(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn2);

    public C_KihonssyuruiKbn getVhsyudisptkkihsyuruikbn2();

    public void setVhsyudisptkkihsyuruikbn2(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn2);

    public BizCurrency getVhsyudisptkkihons2();

    public void setVhsyudisptkkihons2(BizCurrency pVhsyudisptkkihons2);

    public BizCurrency getVhsyudisptktsnshrgndgk2();

    public void setVhsyudisptktsnshrgndgk2(BizCurrency pVhsyudisptktsnshrgndgk2);

    public BizCurrency getVhsyudisptkp2();

    public void setVhsyudisptkp2(BizCurrency pVhsyudisptkp2);

    public BizCurrency getVhsyudisptkkihonkyhgk2();

    public void setVhsyudisptkkihonkyhgk2(BizCurrency pVhsyudisptkkihonkyhgk2);

    public BizCurrency getVhsyudisptknextkosgop2();

    public void setVhsyudisptknextkosgop2(BizCurrency pVhsyudisptknextkosgop2);

    public C_SyukyhkinkataKbn getVhsyudisptksykyhkatakbn2();

    public void setVhsyudisptksykyhkatakbn2(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn2);

    public C_6daiLdKbn getVhsyudisptk6daildkbn2();

    public void setVhsyudisptk6daildkbn2(C_6daiLdKbn pVhsyudisptk6daildkbn2);

    public BizCurrency getVhsyudisptkganyukyhntgk2();

    public void setVhsyudisptkganyukyhntgk2(BizCurrency pVhsyudisptkganyukyhntgk2);

    public BizDate getVhsyudisptkshrskgstrymd2();

    public void setVhsyudisptkshrskgstrymd2(BizDate pVhsyudisptkshrskgstrymd2);

    public BizDate getVhsyudisptkshrskgnedymd2();

    public void setVhsyudisptkshrskgnedymd2(BizDate pVhsyudisptkshrskgnedymd2);

    public BizCurrency getVhsyudisptkshrskgngos2();

    public void setVhsyudisptkshrskgngos2(BizCurrency pVhsyudisptkshrskgngos2);

    public C_Nenkinsyu getVhsyudisptknenkinsyukbn2();

    public void setVhsyudisptknenkinsyukbn2(C_Nenkinsyu pVhsyudisptknenkinsyukbn2);

    public Integer getVhsyudisptknenkinkkn2();

    public void setVhsyudisptknenkinkkn2(Integer pVhsyudisptknenkinkkn2);

    public C_Tkjyskgnkkn getVhsyudisptktkjyskgnkkn2();

    public void setVhsyudisptktkjyskgnkkn2(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn2);

    public BizDate getVhsyudisptktkjkhkdsymd12();

    public void setVhsyudisptktkjkhkdsymd12(BizDate pVhsyudisptktkjkhkdsymd12);

    public BizDate getVhsyudisptktkjkhkdeymd12();

    public void setVhsyudisptktkjkhkdeymd12(BizDate pVhsyudisptktkjkhkdeymd12);

    public BizCurrency getVhsyudisptktkjyskgns12();

    public void setVhsyudisptktkjyskgns12(BizCurrency pVhsyudisptktkjyskgns12);

    public BizDate getVhsyudisptktkjkhkdsymd22();

    public void setVhsyudisptktkjkhkdsymd22(BizDate pVhsyudisptktkjkhkdsymd22);

    public BizDate getVhsyudisptktkjkhkdeymd22();

    public void setVhsyudisptktkjkhkdeymd22(BizDate pVhsyudisptktkjkhkdeymd22);

    public BizCurrency getVhsyudisptktkjyskgns22();

    public void setVhsyudisptktkjyskgns22(BizCurrency pVhsyudisptktkjyskgns22);

    public BizDate getVhsyudisptktkjkhkdsymd32();

    public void setVhsyudisptktkjkhkdsymd32(BizDate pVhsyudisptktkjkhkdsymd32);

    public BizDate getVhsyudisptktkjkhkdeymd32();

    public void setVhsyudisptktkjkhkdeymd32(BizDate pVhsyudisptktkjkhkdeymd32);

    public BizCurrency getVhsyudisptktkjyskgns32();

    public void setVhsyudisptktkjyskgns32(BizCurrency pVhsyudisptktkjyskgns32);

    public BizDate getVhsyudisptktkjkhkdsymd42();

    public void setVhsyudisptktkjkhkdsymd42(BizDate pVhsyudisptktkjkhkdsymd42);

    public BizDate getVhsyudisptktkjkhkdeymd42();

    public void setVhsyudisptktkjkhkdeymd42(BizDate pVhsyudisptktkjkhkdeymd42);

    public BizCurrency getVhsyudisptktkjyskgns42();

    public void setVhsyudisptktkjyskgns42(BizCurrency pVhsyudisptktkjyskgns42);

    public BizDate getVhsyudisptktkjkhkdsymd52();

    public void setVhsyudisptktkjkhkdsymd52(BizDate pVhsyudisptktkjkhkdsymd52);

    public BizDate getVhsyudisptktkjkhkdeymd52();

    public void setVhsyudisptktkjkhkdeymd52(BizDate pVhsyudisptktkjkhkdeymd52);

    public BizCurrency getVhsyudisptktkjyskgns52();

    public void setVhsyudisptktkjyskgns52(BizCurrency pVhsyudisptktkjyskgns52);

    public C_Tkjyhyouten getVhsyudisptktkjyhyouten2();

    public void setVhsyudisptktkjyhyouten2(C_Tkjyhyouten pVhsyudisptktkjyhyouten2);

    public BizCurrency getVhsyudisptktkjyp2();

    public void setVhsyudisptktkjyp2(BizCurrency pVhsyudisptktkjyp2);

    public String getVhsyudisptkhtnpbuicd12();

    public void setVhsyudisptkhtnpbuicd12(String pVhsyudisptkhtnpbuicd12);

    public String getVhsyudisptkhtnpbuinm12();

    public void setVhsyudisptkhtnpbuinm12(String pVhsyudisptkhtnpbuinm12);

    public C_Htnpkkn getVhsyudisptkhtnpkkn12();

    public void setVhsyudisptkhtnpkkn12(C_Htnpkkn pVhsyudisptkhtnpkkn12);

    public String getVhsyudisptkhtnpbuicd22();

    public void setVhsyudisptkhtnpbuicd22(String pVhsyudisptkhtnpbuicd22);

    public String getVhsyudisptkhtnpbuinm22();

    public void setVhsyudisptkhtnpbuinm22(String pVhsyudisptkhtnpbuinm22);

    public C_Htnpkkn getVhsyudisptkhtnpkkn22();

    public void setVhsyudisptkhtnpkkn22(C_Htnpkkn pVhsyudisptkhtnpkkn22);

    public String getVhsyudisptkhtnpbuicd32();

    public void setVhsyudisptkhtnpbuicd32(String pVhsyudisptkhtnpbuicd32);

    public String getVhsyudisptkhtnpbuinm32();

    public void setVhsyudisptkhtnpbuinm32(String pVhsyudisptkhtnpbuinm32);

    public C_Htnpkkn getVhsyudisptkhtnpkkn32();

    public void setVhsyudisptkhtnpkkn32(C_Htnpkkn pVhsyudisptkhtnpkkn32);

    public String getVhsyudisptkhtnpbuicd42();

    public void setVhsyudisptkhtnpbuicd42(String pVhsyudisptkhtnpbuicd42);

    public String getVhsyudisptkhtnpbuinm42();

    public void setVhsyudisptkhtnpbuinm42(String pVhsyudisptkhtnpbuinm42);

    public C_Htnpkkn getVhsyudisptkhtnpkkn42();

    public void setVhsyudisptkhtnpkkn42(C_Htnpkkn pVhsyudisptkhtnpkkn42);

    public C_TokkoudosghtnpKbn getVhsyudisptktkkdsghtpkbn2();

    public void setVhsyudisptktkkdsghtpkbn2(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn2);

    public BizCurrency getVhsyudisptktutakngk2();

    public void setVhsyudisptktutakngk2(BizCurrency pVhsyudisptktutakngk2);

    public BizDate getVhsyudisptkkrkhasseiymd2();

    public void setVhsyudisptkkrkhasseiymd2(BizDate pVhsyudisptkkrkhasseiymd2);

    public String getVhsyudisptksyouhnnm3();

    public void setVhsyudisptksyouhnnm3(String pVhsyudisptksyouhnnm3);

    public C_Tuukasyu getVhsyudisptkktuukasyu3();

    public void setVhsyudisptkktuukasyu3(C_Tuukasyu pVhsyudisptkktuukasyu3);

    public C_KataKbn getVhsyudisptokyakukatakbn3();

    public void setVhsyudisptokyakukatakbn3(C_KataKbn pVhsyudisptokyakukatakbn3);

    public C_KyhgndkataKbn getVhsyudisptkkyhgdkatakbn3();

    public void setVhsyudisptkkyhgdkatakbn3(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn3);

    public Integer getVhsyudisptkhhknnen3();

    public void setVhsyudisptkhhknnen3(Integer pVhsyudisptkhhknnen3);

    public BizDate getVhsyudisptkkykymd3();

    public void setVhsyudisptkkykymd3(BizDate pVhsyudisptkkykymd3);

    public BizDate getVhsyudisptksknnkaisiymd3();

    public void setVhsyudisptksknnkaisiymd3(BizDate pVhsyudisptksknnkaisiymd3);

    public BizDate getVhsyudisptkgaskkaisiymd3();

    public void setVhsyudisptkgaskkaisiymd3(BizDate pVhsyudisptkgaskkaisiymd3);

    public BizDate getVhsyudisptkhkskkaisiymd3();

    public void setVhsyudisptkhkskkaisiymd3(BizDate pVhsyudisptkhkskkaisiymd3);

    public BizDate getVhsyudisptkhkgskksiymd3();

    public void setVhsyudisptkhkgskksiymd3(BizDate pVhsyudisptkhkgskksiymd3);

    public Integer getVhsyudisptkhknkkn3();

    public void setVhsyudisptkhknkkn3(Integer pVhsyudisptkhknkkn3);

    public C_HknkknsmnKbn getVhsyudisptkhknkknsmnkbn3();

    public void setVhsyudisptkhknkknsmnkbn3(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn3);

    public Integer getVhsyudisptkhrkkkn3();

    public void setVhsyudisptkhrkkkn3(Integer pVhsyudisptkhrkkkn3);

    public C_HrkkknsmnKbn getVhsyudisptkhrkkknsmnkbn3();

    public void setVhsyudisptkhrkkknsmnkbn3(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn3);

    public C_KihonssyuruiKbn getVhsyudisptkkihsyuruikbn3();

    public void setVhsyudisptkkihsyuruikbn3(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn3);

    public BizCurrency getVhsyudisptkkihons3();

    public void setVhsyudisptkkihons3(BizCurrency pVhsyudisptkkihons3);

    public BizCurrency getVhsyudisptktsnshrgndgk3();

    public void setVhsyudisptktsnshrgndgk3(BizCurrency pVhsyudisptktsnshrgndgk3);

    public BizCurrency getVhsyudisptkp3();

    public void setVhsyudisptkp3(BizCurrency pVhsyudisptkp3);

    public BizCurrency getVhsyudisptkkihonkyhgk3();

    public void setVhsyudisptkkihonkyhgk3(BizCurrency pVhsyudisptkkihonkyhgk3);

    public BizCurrency getVhsyudisptknextkosgop3();

    public void setVhsyudisptknextkosgop3(BizCurrency pVhsyudisptknextkosgop3);

    public C_SyukyhkinkataKbn getVhsyudisptksykyhkatakbn3();

    public void setVhsyudisptksykyhkatakbn3(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn3);

    public C_6daiLdKbn getVhsyudisptk6daildkbn3();

    public void setVhsyudisptk6daildkbn3(C_6daiLdKbn pVhsyudisptk6daildkbn3);

    public BizCurrency getVhsyudisptkganyukyhntgk3();

    public void setVhsyudisptkganyukyhntgk3(BizCurrency pVhsyudisptkganyukyhntgk3);

    public BizDate getVhsyudisptkshrskgstrymd3();

    public void setVhsyudisptkshrskgstrymd3(BizDate pVhsyudisptkshrskgstrymd3);

    public BizDate getVhsyudisptkshrskgnedymd3();

    public void setVhsyudisptkshrskgnedymd3(BizDate pVhsyudisptkshrskgnedymd3);

    public BizCurrency getVhsyudisptkshrskgngos3();

    public void setVhsyudisptkshrskgngos3(BizCurrency pVhsyudisptkshrskgngos3);

    public C_Nenkinsyu getVhsyudisptknenkinsyukbn3();

    public void setVhsyudisptknenkinsyukbn3(C_Nenkinsyu pVhsyudisptknenkinsyukbn3);

    public Integer getVhsyudisptknenkinkkn3();

    public void setVhsyudisptknenkinkkn3(Integer pVhsyudisptknenkinkkn3);

    public C_Tkjyskgnkkn getVhsyudisptktkjyskgnkkn3();

    public void setVhsyudisptktkjyskgnkkn3(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn3);

    public BizDate getVhsyudisptktkjkhkdsymd13();

    public void setVhsyudisptktkjkhkdsymd13(BizDate pVhsyudisptktkjkhkdsymd13);

    public BizDate getVhsyudisptktkjkhkdeymd13();

    public void setVhsyudisptktkjkhkdeymd13(BizDate pVhsyudisptktkjkhkdeymd13);

    public BizCurrency getVhsyudisptktkjyskgns13();

    public void setVhsyudisptktkjyskgns13(BizCurrency pVhsyudisptktkjyskgns13);

    public BizDate getVhsyudisptktkjkhkdsymd23();

    public void setVhsyudisptktkjkhkdsymd23(BizDate pVhsyudisptktkjkhkdsymd23);

    public BizDate getVhsyudisptktkjkhkdeymd23();

    public void setVhsyudisptktkjkhkdeymd23(BizDate pVhsyudisptktkjkhkdeymd23);

    public BizCurrency getVhsyudisptktkjyskgns23();

    public void setVhsyudisptktkjyskgns23(BizCurrency pVhsyudisptktkjyskgns23);

    public BizDate getVhsyudisptktkjkhkdsymd33();

    public void setVhsyudisptktkjkhkdsymd33(BizDate pVhsyudisptktkjkhkdsymd33);

    public BizDate getVhsyudisptktkjkhkdeymd33();

    public void setVhsyudisptktkjkhkdeymd33(BizDate pVhsyudisptktkjkhkdeymd33);

    public BizCurrency getVhsyudisptktkjyskgns33();

    public void setVhsyudisptktkjyskgns33(BizCurrency pVhsyudisptktkjyskgns33);

    public BizDate getVhsyudisptktkjkhkdsymd43();

    public void setVhsyudisptktkjkhkdsymd43(BizDate pVhsyudisptktkjkhkdsymd43);

    public BizDate getVhsyudisptktkjkhkdeymd43();

    public void setVhsyudisptktkjkhkdeymd43(BizDate pVhsyudisptktkjkhkdeymd43);

    public BizCurrency getVhsyudisptktkjyskgns43();

    public void setVhsyudisptktkjyskgns43(BizCurrency pVhsyudisptktkjyskgns43);

    public BizDate getVhsyudisptktkjkhkdsymd53();

    public void setVhsyudisptktkjkhkdsymd53(BizDate pVhsyudisptktkjkhkdsymd53);

    public BizDate getVhsyudisptktkjkhkdeymd53();

    public void setVhsyudisptktkjkhkdeymd53(BizDate pVhsyudisptktkjkhkdeymd53);

    public BizCurrency getVhsyudisptktkjyskgns53();

    public void setVhsyudisptktkjyskgns53(BizCurrency pVhsyudisptktkjyskgns53);

    public C_Tkjyhyouten getVhsyudisptktkjyhyouten3();

    public void setVhsyudisptktkjyhyouten3(C_Tkjyhyouten pVhsyudisptktkjyhyouten3);

    public BizCurrency getVhsyudisptktkjyp3();

    public void setVhsyudisptktkjyp3(BizCurrency pVhsyudisptktkjyp3);

    public String getVhsyudisptkhtnpbuicd13();

    public void setVhsyudisptkhtnpbuicd13(String pVhsyudisptkhtnpbuicd13);

    public String getVhsyudisptkhtnpbuinm13();

    public void setVhsyudisptkhtnpbuinm13(String pVhsyudisptkhtnpbuinm13);

    public C_Htnpkkn getVhsyudisptkhtnpkkn13();

    public void setVhsyudisptkhtnpkkn13(C_Htnpkkn pVhsyudisptkhtnpkkn13);

    public String getVhsyudisptkhtnpbuicd23();

    public void setVhsyudisptkhtnpbuicd23(String pVhsyudisptkhtnpbuicd23);

    public String getVhsyudisptkhtnpbuinm23();

    public void setVhsyudisptkhtnpbuinm23(String pVhsyudisptkhtnpbuinm23);

    public C_Htnpkkn getVhsyudisptkhtnpkkn23();

    public void setVhsyudisptkhtnpkkn23(C_Htnpkkn pVhsyudisptkhtnpkkn23);

    public String getVhsyudisptkhtnpbuicd33();

    public void setVhsyudisptkhtnpbuicd33(String pVhsyudisptkhtnpbuicd33);

    public String getVhsyudisptkhtnpbuinm33();

    public void setVhsyudisptkhtnpbuinm33(String pVhsyudisptkhtnpbuinm33);

    public C_Htnpkkn getVhsyudisptkhtnpkkn33();

    public void setVhsyudisptkhtnpkkn33(C_Htnpkkn pVhsyudisptkhtnpkkn33);

    public String getVhsyudisptkhtnpbuicd43();

    public void setVhsyudisptkhtnpbuicd43(String pVhsyudisptkhtnpbuicd43);

    public String getVhsyudisptkhtnpbuinm43();

    public void setVhsyudisptkhtnpbuinm43(String pVhsyudisptkhtnpbuinm43);

    public C_Htnpkkn getVhsyudisptkhtnpkkn43();

    public void setVhsyudisptkhtnpkkn43(C_Htnpkkn pVhsyudisptkhtnpkkn43);

    public C_TokkoudosghtnpKbn getVhsyudisptktkkdsghtpkbn3();

    public void setVhsyudisptktkkdsghtpkbn3(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn3);

    public BizCurrency getVhsyudisptktutakngk3();

    public void setVhsyudisptktutakngk3(BizCurrency pVhsyudisptktutakngk3);

    public BizDate getVhsyudisptkkrkhasseiymd3();

    public void setVhsyudisptkkrkhasseiymd3(BizDate pVhsyudisptkkrkhasseiymd3);

    public String getVhsyudisptksyouhnnm4();

    public void setVhsyudisptksyouhnnm4(String pVhsyudisptksyouhnnm4);

    public C_Tuukasyu getVhsyudisptkktuukasyu4();

    public void setVhsyudisptkktuukasyu4(C_Tuukasyu pVhsyudisptkktuukasyu4);

    public C_KataKbn getVhsyudisptokyakukatakbn4();

    public void setVhsyudisptokyakukatakbn4(C_KataKbn pVhsyudisptokyakukatakbn4);

    public C_KyhgndkataKbn getVhsyudisptkkyhgdkatakbn4();

    public void setVhsyudisptkkyhgdkatakbn4(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn4);

    public Integer getVhsyudisptkhhknnen4();

    public void setVhsyudisptkhhknnen4(Integer pVhsyudisptkhhknnen4);

    public BizDate getVhsyudisptkkykymd4();

    public void setVhsyudisptkkykymd4(BizDate pVhsyudisptkkykymd4);

    public BizDate getVhsyudisptksknnkaisiymd4();

    public void setVhsyudisptksknnkaisiymd4(BizDate pVhsyudisptksknnkaisiymd4);

    public BizDate getVhsyudisptkgaskkaisiymd4();

    public void setVhsyudisptkgaskkaisiymd4(BizDate pVhsyudisptkgaskkaisiymd4);

    public BizDate getVhsyudisptkhkskkaisiymd4();

    public void setVhsyudisptkhkskkaisiymd4(BizDate pVhsyudisptkhkskkaisiymd4);

    public BizDate getVhsyudisptkhkgskksiymd4();

    public void setVhsyudisptkhkgskksiymd4(BizDate pVhsyudisptkhkgskksiymd4);

    public Integer getVhsyudisptkhknkkn4();

    public void setVhsyudisptkhknkkn4(Integer pVhsyudisptkhknkkn4);

    public C_HknkknsmnKbn getVhsyudisptkhknkknsmnkbn4();

    public void setVhsyudisptkhknkknsmnkbn4(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn4);

    public Integer getVhsyudisptkhrkkkn4();

    public void setVhsyudisptkhrkkkn4(Integer pVhsyudisptkhrkkkn4);

    public C_HrkkknsmnKbn getVhsyudisptkhrkkknsmnkbn4();

    public void setVhsyudisptkhrkkknsmnkbn4(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn4);

    public C_KihonssyuruiKbn getVhsyudisptkkihsyuruikbn4();

    public void setVhsyudisptkkihsyuruikbn4(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn4);

    public BizCurrency getVhsyudisptkkihons4();

    public void setVhsyudisptkkihons4(BizCurrency pVhsyudisptkkihons4);

    public BizCurrency getVhsyudisptktsnshrgndgk4();

    public void setVhsyudisptktsnshrgndgk4(BizCurrency pVhsyudisptktsnshrgndgk4);

    public BizCurrency getVhsyudisptkp4();

    public void setVhsyudisptkp4(BizCurrency pVhsyudisptkp4);

    public BizCurrency getVhsyudisptkkihonkyhgk4();

    public void setVhsyudisptkkihonkyhgk4(BizCurrency pVhsyudisptkkihonkyhgk4);

    public BizCurrency getVhsyudisptknextkosgop4();

    public void setVhsyudisptknextkosgop4(BizCurrency pVhsyudisptknextkosgop4);

    public C_SyukyhkinkataKbn getVhsyudisptksykyhkatakbn4();

    public void setVhsyudisptksykyhkatakbn4(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn4);

    public C_6daiLdKbn getVhsyudisptk6daildkbn4();

    public void setVhsyudisptk6daildkbn4(C_6daiLdKbn pVhsyudisptk6daildkbn4);

    public BizCurrency getVhsyudisptkganyukyhntgk4();

    public void setVhsyudisptkganyukyhntgk4(BizCurrency pVhsyudisptkganyukyhntgk4);

    public BizDate getVhsyudisptkshrskgstrymd4();

    public void setVhsyudisptkshrskgstrymd4(BizDate pVhsyudisptkshrskgstrymd4);

    public BizDate getVhsyudisptkshrskgnedymd4();

    public void setVhsyudisptkshrskgnedymd4(BizDate pVhsyudisptkshrskgnedymd4);

    public BizCurrency getVhsyudisptkshrskgngos4();

    public void setVhsyudisptkshrskgngos4(BizCurrency pVhsyudisptkshrskgngos4);

    public C_Nenkinsyu getVhsyudisptknenkinsyukbn4();

    public void setVhsyudisptknenkinsyukbn4(C_Nenkinsyu pVhsyudisptknenkinsyukbn4);

    public Integer getVhsyudisptknenkinkkn4();

    public void setVhsyudisptknenkinkkn4(Integer pVhsyudisptknenkinkkn4);

    public C_Tkjyskgnkkn getVhsyudisptktkjyskgnkkn4();

    public void setVhsyudisptktkjyskgnkkn4(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn4);

    public BizDate getVhsyudisptktkjkhkdsymd14();

    public void setVhsyudisptktkjkhkdsymd14(BizDate pVhsyudisptktkjkhkdsymd14);

    public BizDate getVhsyudisptktkjkhkdeymd14();

    public void setVhsyudisptktkjkhkdeymd14(BizDate pVhsyudisptktkjkhkdeymd14);

    public BizCurrency getVhsyudisptktkjyskgns14();

    public void setVhsyudisptktkjyskgns14(BizCurrency pVhsyudisptktkjyskgns14);

    public BizDate getVhsyudisptktkjkhkdsymd24();

    public void setVhsyudisptktkjkhkdsymd24(BizDate pVhsyudisptktkjkhkdsymd24);

    public BizDate getVhsyudisptktkjkhkdeymd24();

    public void setVhsyudisptktkjkhkdeymd24(BizDate pVhsyudisptktkjkhkdeymd24);

    public BizCurrency getVhsyudisptktkjyskgns24();

    public void setVhsyudisptktkjyskgns24(BizCurrency pVhsyudisptktkjyskgns24);

    public BizDate getVhsyudisptktkjkhkdsymd34();

    public void setVhsyudisptktkjkhkdsymd34(BizDate pVhsyudisptktkjkhkdsymd34);

    public BizDate getVhsyudisptktkjkhkdeymd34();

    public void setVhsyudisptktkjkhkdeymd34(BizDate pVhsyudisptktkjkhkdeymd34);

    public BizCurrency getVhsyudisptktkjyskgns34();

    public void setVhsyudisptktkjyskgns34(BizCurrency pVhsyudisptktkjyskgns34);

    public BizDate getVhsyudisptktkjkhkdsymd44();

    public void setVhsyudisptktkjkhkdsymd44(BizDate pVhsyudisptktkjkhkdsymd44);

    public BizDate getVhsyudisptktkjkhkdeymd44();

    public void setVhsyudisptktkjkhkdeymd44(BizDate pVhsyudisptktkjkhkdeymd44);

    public BizCurrency getVhsyudisptktkjyskgns44();

    public void setVhsyudisptktkjyskgns44(BizCurrency pVhsyudisptktkjyskgns44);

    public BizDate getVhsyudisptktkjkhkdsymd54();

    public void setVhsyudisptktkjkhkdsymd54(BizDate pVhsyudisptktkjkhkdsymd54);

    public BizDate getVhsyudisptktkjkhkdeymd54();

    public void setVhsyudisptktkjkhkdeymd54(BizDate pVhsyudisptktkjkhkdeymd54);

    public BizCurrency getVhsyudisptktkjyskgns54();

    public void setVhsyudisptktkjyskgns54(BizCurrency pVhsyudisptktkjyskgns54);

    public C_Tkjyhyouten getVhsyudisptktkjyhyouten4();

    public void setVhsyudisptktkjyhyouten4(C_Tkjyhyouten pVhsyudisptktkjyhyouten4);

    public BizCurrency getVhsyudisptktkjyp4();

    public void setVhsyudisptktkjyp4(BizCurrency pVhsyudisptktkjyp4);

    public String getVhsyudisptkhtnpbuicd14();

    public void setVhsyudisptkhtnpbuicd14(String pVhsyudisptkhtnpbuicd14);

    public String getVhsyudisptkhtnpbuinm14();

    public void setVhsyudisptkhtnpbuinm14(String pVhsyudisptkhtnpbuinm14);

    public C_Htnpkkn getVhsyudisptkhtnpkkn14();

    public void setVhsyudisptkhtnpkkn14(C_Htnpkkn pVhsyudisptkhtnpkkn14);

    public String getVhsyudisptkhtnpbuicd24();

    public void setVhsyudisptkhtnpbuicd24(String pVhsyudisptkhtnpbuicd24);

    public String getVhsyudisptkhtnpbuinm24();

    public void setVhsyudisptkhtnpbuinm24(String pVhsyudisptkhtnpbuinm24);

    public C_Htnpkkn getVhsyudisptkhtnpkkn24();

    public void setVhsyudisptkhtnpkkn24(C_Htnpkkn pVhsyudisptkhtnpkkn24);

    public String getVhsyudisptkhtnpbuicd34();

    public void setVhsyudisptkhtnpbuicd34(String pVhsyudisptkhtnpbuicd34);

    public String getVhsyudisptkhtnpbuinm34();

    public void setVhsyudisptkhtnpbuinm34(String pVhsyudisptkhtnpbuinm34);

    public C_Htnpkkn getVhsyudisptkhtnpkkn34();

    public void setVhsyudisptkhtnpkkn34(C_Htnpkkn pVhsyudisptkhtnpkkn34);

    public String getVhsyudisptkhtnpbuicd44();

    public void setVhsyudisptkhtnpbuicd44(String pVhsyudisptkhtnpbuicd44);

    public String getVhsyudisptkhtnpbuinm44();

    public void setVhsyudisptkhtnpbuinm44(String pVhsyudisptkhtnpbuinm44);

    public C_Htnpkkn getVhsyudisptkhtnpkkn44();

    public void setVhsyudisptkhtnpkkn44(C_Htnpkkn pVhsyudisptkhtnpkkn44);

    public C_TokkoudosghtnpKbn getVhsyudisptktkkdsghtpkbn4();

    public void setVhsyudisptktkkdsghtpkbn4(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn4);

    public BizCurrency getVhsyudisptktutakngk4();

    public void setVhsyudisptktutakngk4(BizCurrency pVhsyudisptktutakngk4);

    public BizDate getVhsyudisptkkrkhasseiymd4();

    public void setVhsyudisptkkrkhasseiymd4(BizDate pVhsyudisptkkrkhasseiymd4);

    public String getVhsyudisptksyouhnnm5();

    public void setVhsyudisptksyouhnnm5(String pVhsyudisptksyouhnnm5);

    public C_Tuukasyu getVhsyudisptkktuukasyu5();

    public void setVhsyudisptkktuukasyu5(C_Tuukasyu pVhsyudisptkktuukasyu5);

    public C_KataKbn getVhsyudisptokyakukatakbn5();

    public void setVhsyudisptokyakukatakbn5(C_KataKbn pVhsyudisptokyakukatakbn5);

    public C_KyhgndkataKbn getVhsyudisptkkyhgdkatakbn5();

    public void setVhsyudisptkkyhgdkatakbn5(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn5);

    public Integer getVhsyudisptkhhknnen5();

    public void setVhsyudisptkhhknnen5(Integer pVhsyudisptkhhknnen5);

    public BizDate getVhsyudisptkkykymd5();

    public void setVhsyudisptkkykymd5(BizDate pVhsyudisptkkykymd5);

    public BizDate getVhsyudisptksknnkaisiymd5();

    public void setVhsyudisptksknnkaisiymd5(BizDate pVhsyudisptksknnkaisiymd5);

    public BizDate getVhsyudisptkgaskkaisiymd5();

    public void setVhsyudisptkgaskkaisiymd5(BizDate pVhsyudisptkgaskkaisiymd5);

    public BizDate getVhsyudisptkhkskkaisiymd5();

    public void setVhsyudisptkhkskkaisiymd5(BizDate pVhsyudisptkhkskkaisiymd5);

    public BizDate getVhsyudisptkhkgskksiymd5();

    public void setVhsyudisptkhkgskksiymd5(BizDate pVhsyudisptkhkgskksiymd5);

    public Integer getVhsyudisptkhknkkn5();

    public void setVhsyudisptkhknkkn5(Integer pVhsyudisptkhknkkn5);

    public C_HknkknsmnKbn getVhsyudisptkhknkknsmnkbn5();

    public void setVhsyudisptkhknkknsmnkbn5(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn5);

    public Integer getVhsyudisptkhrkkkn5();

    public void setVhsyudisptkhrkkkn5(Integer pVhsyudisptkhrkkkn5);

    public C_HrkkknsmnKbn getVhsyudisptkhrkkknsmnkbn5();

    public void setVhsyudisptkhrkkknsmnkbn5(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn5);

    public C_KihonssyuruiKbn getVhsyudisptkkihsyuruikbn5();

    public void setVhsyudisptkkihsyuruikbn5(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn5);

    public BizCurrency getVhsyudisptkkihons5();

    public void setVhsyudisptkkihons5(BizCurrency pVhsyudisptkkihons5);

    public BizCurrency getVhsyudisptktsnshrgndgk5();

    public void setVhsyudisptktsnshrgndgk5(BizCurrency pVhsyudisptktsnshrgndgk5);

    public BizCurrency getVhsyudisptkp5();

    public void setVhsyudisptkp5(BizCurrency pVhsyudisptkp5);

    public BizCurrency getVhsyudisptkkihonkyhgk5();

    public void setVhsyudisptkkihonkyhgk5(BizCurrency pVhsyudisptkkihonkyhgk5);

    public BizCurrency getVhsyudisptknextkosgop5();

    public void setVhsyudisptknextkosgop5(BizCurrency pVhsyudisptknextkosgop5);

    public C_SyukyhkinkataKbn getVhsyudisptksykyhkatakbn5();

    public void setVhsyudisptksykyhkatakbn5(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn5);

    public C_6daiLdKbn getVhsyudisptk6daildkbn5();

    public void setVhsyudisptk6daildkbn5(C_6daiLdKbn pVhsyudisptk6daildkbn5);

    public BizCurrency getVhsyudisptkganyukyhntgk5();

    public void setVhsyudisptkganyukyhntgk5(BizCurrency pVhsyudisptkganyukyhntgk5);

    public BizDate getVhsyudisptkshrskgstrymd5();

    public void setVhsyudisptkshrskgstrymd5(BizDate pVhsyudisptkshrskgstrymd5);

    public BizDate getVhsyudisptkshrskgnedymd5();

    public void setVhsyudisptkshrskgnedymd5(BizDate pVhsyudisptkshrskgnedymd5);

    public BizCurrency getVhsyudisptkshrskgngos5();

    public void setVhsyudisptkshrskgngos5(BizCurrency pVhsyudisptkshrskgngos5);

    public C_Nenkinsyu getVhsyudisptknenkinsyukbn5();

    public void setVhsyudisptknenkinsyukbn5(C_Nenkinsyu pVhsyudisptknenkinsyukbn5);

    public Integer getVhsyudisptknenkinkkn5();

    public void setVhsyudisptknenkinkkn5(Integer pVhsyudisptknenkinkkn5);

    public C_Tkjyskgnkkn getVhsyudisptktkjyskgnkkn5();

    public void setVhsyudisptktkjyskgnkkn5(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn5);

    public BizDate getVhsyudisptktkjkhkdsymd15();

    public void setVhsyudisptktkjkhkdsymd15(BizDate pVhsyudisptktkjkhkdsymd15);

    public BizDate getVhsyudisptktkjkhkdeymd15();

    public void setVhsyudisptktkjkhkdeymd15(BizDate pVhsyudisptktkjkhkdeymd15);

    public BizCurrency getVhsyudisptktkjyskgns15();

    public void setVhsyudisptktkjyskgns15(BizCurrency pVhsyudisptktkjyskgns15);

    public BizDate getVhsyudisptktkjkhkdsymd25();

    public void setVhsyudisptktkjkhkdsymd25(BizDate pVhsyudisptktkjkhkdsymd25);

    public BizDate getVhsyudisptktkjkhkdeymd25();

    public void setVhsyudisptktkjkhkdeymd25(BizDate pVhsyudisptktkjkhkdeymd25);

    public BizCurrency getVhsyudisptktkjyskgns25();

    public void setVhsyudisptktkjyskgns25(BizCurrency pVhsyudisptktkjyskgns25);

    public BizDate getVhsyudisptktkjkhkdsymd35();

    public void setVhsyudisptktkjkhkdsymd35(BizDate pVhsyudisptktkjkhkdsymd35);

    public BizDate getVhsyudisptktkjkhkdeymd35();

    public void setVhsyudisptktkjkhkdeymd35(BizDate pVhsyudisptktkjkhkdeymd35);

    public BizCurrency getVhsyudisptktkjyskgns35();

    public void setVhsyudisptktkjyskgns35(BizCurrency pVhsyudisptktkjyskgns35);

    public BizDate getVhsyudisptktkjkhkdsymd45();

    public void setVhsyudisptktkjkhkdsymd45(BizDate pVhsyudisptktkjkhkdsymd45);

    public BizDate getVhsyudisptktkjkhkdeymd45();

    public void setVhsyudisptktkjkhkdeymd45(BizDate pVhsyudisptktkjkhkdeymd45);

    public BizCurrency getVhsyudisptktkjyskgns45();

    public void setVhsyudisptktkjyskgns45(BizCurrency pVhsyudisptktkjyskgns45);

    public BizDate getVhsyudisptktkjkhkdsymd55();

    public void setVhsyudisptktkjkhkdsymd55(BizDate pVhsyudisptktkjkhkdsymd55);

    public BizDate getVhsyudisptktkjkhkdeymd55();

    public void setVhsyudisptktkjkhkdeymd55(BizDate pVhsyudisptktkjkhkdeymd55);

    public BizCurrency getVhsyudisptktkjyskgns55();

    public void setVhsyudisptktkjyskgns55(BizCurrency pVhsyudisptktkjyskgns55);

    public C_Tkjyhyouten getVhsyudisptktkjyhyouten5();

    public void setVhsyudisptktkjyhyouten5(C_Tkjyhyouten pVhsyudisptktkjyhyouten5);

    public BizCurrency getVhsyudisptktkjyp5();

    public void setVhsyudisptktkjyp5(BizCurrency pVhsyudisptktkjyp5);

    public String getVhsyudisptkhtnpbuicd15();

    public void setVhsyudisptkhtnpbuicd15(String pVhsyudisptkhtnpbuicd15);

    public String getVhsyudisptkhtnpbuinm15();

    public void setVhsyudisptkhtnpbuinm15(String pVhsyudisptkhtnpbuinm15);

    public C_Htnpkkn getVhsyudisptkhtnpkkn15();

    public void setVhsyudisptkhtnpkkn15(C_Htnpkkn pVhsyudisptkhtnpkkn15);

    public String getVhsyudisptkhtnpbuicd25();

    public void setVhsyudisptkhtnpbuicd25(String pVhsyudisptkhtnpbuicd25);

    public String getVhsyudisptkhtnpbuinm25();

    public void setVhsyudisptkhtnpbuinm25(String pVhsyudisptkhtnpbuinm25);

    public C_Htnpkkn getVhsyudisptkhtnpkkn25();

    public void setVhsyudisptkhtnpkkn25(C_Htnpkkn pVhsyudisptkhtnpkkn25);

    public String getVhsyudisptkhtnpbuicd35();

    public void setVhsyudisptkhtnpbuicd35(String pVhsyudisptkhtnpbuicd35);

    public String getVhsyudisptkhtnpbuinm35();

    public void setVhsyudisptkhtnpbuinm35(String pVhsyudisptkhtnpbuinm35);

    public C_Htnpkkn getVhsyudisptkhtnpkkn35();

    public void setVhsyudisptkhtnpkkn35(C_Htnpkkn pVhsyudisptkhtnpkkn35);

    public String getVhsyudisptkhtnpbuicd45();

    public void setVhsyudisptkhtnpbuicd45(String pVhsyudisptkhtnpbuicd45);

    public String getVhsyudisptkhtnpbuinm45();

    public void setVhsyudisptkhtnpbuinm45(String pVhsyudisptkhtnpbuinm45);

    public C_Htnpkkn getVhsyudisptkhtnpkkn45();

    public void setVhsyudisptkhtnpkkn45(C_Htnpkkn pVhsyudisptkhtnpkkn45);

    public C_TokkoudosghtnpKbn getVhsyudisptktkkdsghtpkbn5();

    public void setVhsyudisptktkkdsghtpkbn5(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn5);

    public BizCurrency getVhsyudisptktutakngk5();

    public void setVhsyudisptktutakngk5(BizCurrency pVhsyudisptktutakngk5);

    public BizDate getVhsyudisptkkrkhasseiymd5();

    public void setVhsyudisptkkrkhasseiymd5(BizDate pVhsyudisptkkrkhasseiymd5);

    public String getVhsyudisptksyouhnnm6();

    public void setVhsyudisptksyouhnnm6(String pVhsyudisptksyouhnnm6);

    public C_Tuukasyu getVhsyudisptkktuukasyu6();

    public void setVhsyudisptkktuukasyu6(C_Tuukasyu pVhsyudisptkktuukasyu6);

    public C_KataKbn getVhsyudisptokyakukatakbn6();

    public void setVhsyudisptokyakukatakbn6(C_KataKbn pVhsyudisptokyakukatakbn6);

    public C_KyhgndkataKbn getVhsyudisptkkyhgdkatakbn6();

    public void setVhsyudisptkkyhgdkatakbn6(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn6);

    public Integer getVhsyudisptkhhknnen6();

    public void setVhsyudisptkhhknnen6(Integer pVhsyudisptkhhknnen6);

    public BizDate getVhsyudisptkkykymd6();

    public void setVhsyudisptkkykymd6(BizDate pVhsyudisptkkykymd6);

    public BizDate getVhsyudisptksknnkaisiymd6();

    public void setVhsyudisptksknnkaisiymd6(BizDate pVhsyudisptksknnkaisiymd6);

    public BizDate getVhsyudisptkgaskkaisiymd6();

    public void setVhsyudisptkgaskkaisiymd6(BizDate pVhsyudisptkgaskkaisiymd6);

    public BizDate getVhsyudisptkhkskkaisiymd6();

    public void setVhsyudisptkhkskkaisiymd6(BizDate pVhsyudisptkhkskkaisiymd6);

    public BizDate getVhsyudisptkhkgskksiymd6();

    public void setVhsyudisptkhkgskksiymd6(BizDate pVhsyudisptkhkgskksiymd6);

    public Integer getVhsyudisptkhknkkn6();

    public void setVhsyudisptkhknkkn6(Integer pVhsyudisptkhknkkn6);

    public C_HknkknsmnKbn getVhsyudisptkhknkknsmnkbn6();

    public void setVhsyudisptkhknkknsmnkbn6(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn6);

    public Integer getVhsyudisptkhrkkkn6();

    public void setVhsyudisptkhrkkkn6(Integer pVhsyudisptkhrkkkn6);

    public C_HrkkknsmnKbn getVhsyudisptkhrkkknsmnkbn6();

    public void setVhsyudisptkhrkkknsmnkbn6(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn6);

    public C_KihonssyuruiKbn getVhsyudisptkkihsyuruikbn6();

    public void setVhsyudisptkkihsyuruikbn6(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn6);

    public BizCurrency getVhsyudisptkkihons6();

    public void setVhsyudisptkkihons6(BizCurrency pVhsyudisptkkihons6);

    public BizCurrency getVhsyudisptktsnshrgndgk6();

    public void setVhsyudisptktsnshrgndgk6(BizCurrency pVhsyudisptktsnshrgndgk6);

    public BizCurrency getVhsyudisptkp6();

    public void setVhsyudisptkp6(BizCurrency pVhsyudisptkp6);

    public BizCurrency getVhsyudisptkkihonkyhgk6();

    public void setVhsyudisptkkihonkyhgk6(BizCurrency pVhsyudisptkkihonkyhgk6);

    public BizCurrency getVhsyudisptknextkosgop6();

    public void setVhsyudisptknextkosgop6(BizCurrency pVhsyudisptknextkosgop6);

    public C_SyukyhkinkataKbn getVhsyudisptksykyhkatakbn6();

    public void setVhsyudisptksykyhkatakbn6(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn6);

    public C_6daiLdKbn getVhsyudisptk6daildkbn6();

    public void setVhsyudisptk6daildkbn6(C_6daiLdKbn pVhsyudisptk6daildkbn6);

    public BizCurrency getVhsyudisptkganyukyhntgk6();

    public void setVhsyudisptkganyukyhntgk6(BizCurrency pVhsyudisptkganyukyhntgk6);

    public BizDate getVhsyudisptkshrskgstrymd6();

    public void setVhsyudisptkshrskgstrymd6(BizDate pVhsyudisptkshrskgstrymd6);

    public BizDate getVhsyudisptkshrskgnedymd6();

    public void setVhsyudisptkshrskgnedymd6(BizDate pVhsyudisptkshrskgnedymd6);

    public BizCurrency getVhsyudisptkshrskgngos6();

    public void setVhsyudisptkshrskgngos6(BizCurrency pVhsyudisptkshrskgngos6);

    public C_Nenkinsyu getVhsyudisptknenkinsyukbn6();

    public void setVhsyudisptknenkinsyukbn6(C_Nenkinsyu pVhsyudisptknenkinsyukbn6);

    public Integer getVhsyudisptknenkinkkn6();

    public void setVhsyudisptknenkinkkn6(Integer pVhsyudisptknenkinkkn6);

    public C_Tkjyskgnkkn getVhsyudisptktkjyskgnkkn6();

    public void setVhsyudisptktkjyskgnkkn6(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn6);

    public BizDate getVhsyudisptktkjkhkdsymd16();

    public void setVhsyudisptktkjkhkdsymd16(BizDate pVhsyudisptktkjkhkdsymd16);

    public BizDate getVhsyudisptktkjkhkdeymd16();

    public void setVhsyudisptktkjkhkdeymd16(BizDate pVhsyudisptktkjkhkdeymd16);

    public BizCurrency getVhsyudisptktkjyskgns16();

    public void setVhsyudisptktkjyskgns16(BizCurrency pVhsyudisptktkjyskgns16);

    public BizDate getVhsyudisptktkjkhkdsymd26();

    public void setVhsyudisptktkjkhkdsymd26(BizDate pVhsyudisptktkjkhkdsymd26);

    public BizDate getVhsyudisptktkjkhkdeymd26();

    public void setVhsyudisptktkjkhkdeymd26(BizDate pVhsyudisptktkjkhkdeymd26);

    public BizCurrency getVhsyudisptktkjyskgns26();

    public void setVhsyudisptktkjyskgns26(BizCurrency pVhsyudisptktkjyskgns26);

    public BizDate getVhsyudisptktkjkhkdsymd36();

    public void setVhsyudisptktkjkhkdsymd36(BizDate pVhsyudisptktkjkhkdsymd36);

    public BizDate getVhsyudisptktkjkhkdeymd36();

    public void setVhsyudisptktkjkhkdeymd36(BizDate pVhsyudisptktkjkhkdeymd36);

    public BizCurrency getVhsyudisptktkjyskgns36();

    public void setVhsyudisptktkjyskgns36(BizCurrency pVhsyudisptktkjyskgns36);

    public BizDate getVhsyudisptktkjkhkdsymd46();

    public void setVhsyudisptktkjkhkdsymd46(BizDate pVhsyudisptktkjkhkdsymd46);

    public BizDate getVhsyudisptktkjkhkdeymd46();

    public void setVhsyudisptktkjkhkdeymd46(BizDate pVhsyudisptktkjkhkdeymd46);

    public BizCurrency getVhsyudisptktkjyskgns46();

    public void setVhsyudisptktkjyskgns46(BizCurrency pVhsyudisptktkjyskgns46);

    public BizDate getVhsyudisptktkjkhkdsymd56();

    public void setVhsyudisptktkjkhkdsymd56(BizDate pVhsyudisptktkjkhkdsymd56);

    public BizDate getVhsyudisptktkjkhkdeymd56();

    public void setVhsyudisptktkjkhkdeymd56(BizDate pVhsyudisptktkjkhkdeymd56);

    public BizCurrency getVhsyudisptktkjyskgns56();

    public void setVhsyudisptktkjyskgns56(BizCurrency pVhsyudisptktkjyskgns56);

    public C_Tkjyhyouten getVhsyudisptktkjyhyouten6();

    public void setVhsyudisptktkjyhyouten6(C_Tkjyhyouten pVhsyudisptktkjyhyouten6);

    public BizCurrency getVhsyudisptktkjyp6();

    public void setVhsyudisptktkjyp6(BizCurrency pVhsyudisptktkjyp6);

    public String getVhsyudisptkhtnpbuicd16();

    public void setVhsyudisptkhtnpbuicd16(String pVhsyudisptkhtnpbuicd16);

    public String getVhsyudisptkhtnpbuinm16();

    public void setVhsyudisptkhtnpbuinm16(String pVhsyudisptkhtnpbuinm16);

    public C_Htnpkkn getVhsyudisptkhtnpkkn16();

    public void setVhsyudisptkhtnpkkn16(C_Htnpkkn pVhsyudisptkhtnpkkn16);

    public String getVhsyudisptkhtnpbuicd26();

    public void setVhsyudisptkhtnpbuicd26(String pVhsyudisptkhtnpbuicd26);

    public String getVhsyudisptkhtnpbuinm26();

    public void setVhsyudisptkhtnpbuinm26(String pVhsyudisptkhtnpbuinm26);

    public C_Htnpkkn getVhsyudisptkhtnpkkn26();

    public void setVhsyudisptkhtnpkkn26(C_Htnpkkn pVhsyudisptkhtnpkkn26);

    public String getVhsyudisptkhtnpbuicd36();

    public void setVhsyudisptkhtnpbuicd36(String pVhsyudisptkhtnpbuicd36);

    public String getVhsyudisptkhtnpbuinm36();

    public void setVhsyudisptkhtnpbuinm36(String pVhsyudisptkhtnpbuinm36);

    public C_Htnpkkn getVhsyudisptkhtnpkkn36();

    public void setVhsyudisptkhtnpkkn36(C_Htnpkkn pVhsyudisptkhtnpkkn36);

    public String getVhsyudisptkhtnpbuicd46();

    public void setVhsyudisptkhtnpbuicd46(String pVhsyudisptkhtnpbuicd46);

    public String getVhsyudisptkhtnpbuinm46();

    public void setVhsyudisptkhtnpbuinm46(String pVhsyudisptkhtnpbuinm46);

    public C_Htnpkkn getVhsyudisptkhtnpkkn46();

    public void setVhsyudisptkhtnpkkn46(C_Htnpkkn pVhsyudisptkhtnpkkn46);

    public C_TokkoudosghtnpKbn getVhsyudisptktkkdsghtpkbn6();

    public void setVhsyudisptktkkdsghtpkbn6(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn6);

    public BizCurrency getVhsyudisptktutakngk6();

    public void setVhsyudisptktutakngk6(BizCurrency pVhsyudisptktutakngk6);

    public BizDate getVhsyudisptkkrkhasseiymd6();

    public void setVhsyudisptkkrkhasseiymd6(BizDate pVhsyudisptkkrkhasseiymd6);

    public String getVhsyudisptksyouhnnm7();

    public void setVhsyudisptksyouhnnm7(String pVhsyudisptksyouhnnm7);

    public C_Tuukasyu getVhsyudisptkktuukasyu7();

    public void setVhsyudisptkktuukasyu7(C_Tuukasyu pVhsyudisptkktuukasyu7);

    public C_KataKbn getVhsyudisptokyakukatakbn7();

    public void setVhsyudisptokyakukatakbn7(C_KataKbn pVhsyudisptokyakukatakbn7);

    public C_KyhgndkataKbn getVhsyudisptkkyhgdkatakbn7();

    public void setVhsyudisptkkyhgdkatakbn7(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn7);

    public Integer getVhsyudisptkhhknnen7();

    public void setVhsyudisptkhhknnen7(Integer pVhsyudisptkhhknnen7);

    public BizDate getVhsyudisptkkykymd7();

    public void setVhsyudisptkkykymd7(BizDate pVhsyudisptkkykymd7);

    public BizDate getVhsyudisptksknnkaisiymd7();

    public void setVhsyudisptksknnkaisiymd7(BizDate pVhsyudisptksknnkaisiymd7);

    public BizDate getVhsyudisptkgaskkaisiymd7();

    public void setVhsyudisptkgaskkaisiymd7(BizDate pVhsyudisptkgaskkaisiymd7);

    public BizDate getVhsyudisptkhkskkaisiymd7();

    public void setVhsyudisptkhkskkaisiymd7(BizDate pVhsyudisptkhkskkaisiymd7);

    public BizDate getVhsyudisptkhkgskksiymd7();

    public void setVhsyudisptkhkgskksiymd7(BizDate pVhsyudisptkhkgskksiymd7);

    public Integer getVhsyudisptkhknkkn7();

    public void setVhsyudisptkhknkkn7(Integer pVhsyudisptkhknkkn7);

    public C_HknkknsmnKbn getVhsyudisptkhknkknsmnkbn7();

    public void setVhsyudisptkhknkknsmnkbn7(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn7);

    public Integer getVhsyudisptkhrkkkn7();

    public void setVhsyudisptkhrkkkn7(Integer pVhsyudisptkhrkkkn7);

    public C_HrkkknsmnKbn getVhsyudisptkhrkkknsmnkbn7();

    public void setVhsyudisptkhrkkknsmnkbn7(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn7);

    public C_KihonssyuruiKbn getVhsyudisptkkihsyuruikbn7();

    public void setVhsyudisptkkihsyuruikbn7(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn7);

    public BizCurrency getVhsyudisptkkihons7();

    public void setVhsyudisptkkihons7(BizCurrency pVhsyudisptkkihons7);

    public BizCurrency getVhsyudisptktsnshrgndgk7();

    public void setVhsyudisptktsnshrgndgk7(BizCurrency pVhsyudisptktsnshrgndgk7);

    public BizCurrency getVhsyudisptkp7();

    public void setVhsyudisptkp7(BizCurrency pVhsyudisptkp7);

    public BizCurrency getVhsyudisptkkihonkyhgk7();

    public void setVhsyudisptkkihonkyhgk7(BizCurrency pVhsyudisptkkihonkyhgk7);

    public BizCurrency getVhsyudisptknextkosgop7();

    public void setVhsyudisptknextkosgop7(BizCurrency pVhsyudisptknextkosgop7);

    public C_SyukyhkinkataKbn getVhsyudisptksykyhkatakbn7();

    public void setVhsyudisptksykyhkatakbn7(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn7);

    public C_6daiLdKbn getVhsyudisptk6daildkbn7();

    public void setVhsyudisptk6daildkbn7(C_6daiLdKbn pVhsyudisptk6daildkbn7);

    public BizCurrency getVhsyudisptkganyukyhntgk7();

    public void setVhsyudisptkganyukyhntgk7(BizCurrency pVhsyudisptkganyukyhntgk7);

    public BizDate getVhsyudisptkshrskgstrymd7();

    public void setVhsyudisptkshrskgstrymd7(BizDate pVhsyudisptkshrskgstrymd7);

    public BizDate getVhsyudisptkshrskgnedymd7();

    public void setVhsyudisptkshrskgnedymd7(BizDate pVhsyudisptkshrskgnedymd7);

    public BizCurrency getVhsyudisptkshrskgngos7();

    public void setVhsyudisptkshrskgngos7(BizCurrency pVhsyudisptkshrskgngos7);

    public C_Nenkinsyu getVhsyudisptknenkinsyukbn7();

    public void setVhsyudisptknenkinsyukbn7(C_Nenkinsyu pVhsyudisptknenkinsyukbn7);

    public Integer getVhsyudisptknenkinkkn7();

    public void setVhsyudisptknenkinkkn7(Integer pVhsyudisptknenkinkkn7);

    public C_Tkjyskgnkkn getVhsyudisptktkjyskgnkkn7();

    public void setVhsyudisptktkjyskgnkkn7(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn7);

    public BizDate getVhsyudisptktkjkhkdsymd17();

    public void setVhsyudisptktkjkhkdsymd17(BizDate pVhsyudisptktkjkhkdsymd17);

    public BizDate getVhsyudisptktkjkhkdeymd17();

    public void setVhsyudisptktkjkhkdeymd17(BizDate pVhsyudisptktkjkhkdeymd17);

    public BizCurrency getVhsyudisptktkjyskgns17();

    public void setVhsyudisptktkjyskgns17(BizCurrency pVhsyudisptktkjyskgns17);

    public BizDate getVhsyudisptktkjkhkdsymd27();

    public void setVhsyudisptktkjkhkdsymd27(BizDate pVhsyudisptktkjkhkdsymd27);

    public BizDate getVhsyudisptktkjkhkdeymd27();

    public void setVhsyudisptktkjkhkdeymd27(BizDate pVhsyudisptktkjkhkdeymd27);

    public BizCurrency getVhsyudisptktkjyskgns27();

    public void setVhsyudisptktkjyskgns27(BizCurrency pVhsyudisptktkjyskgns27);

    public BizDate getVhsyudisptktkjkhkdsymd37();

    public void setVhsyudisptktkjkhkdsymd37(BizDate pVhsyudisptktkjkhkdsymd37);

    public BizDate getVhsyudisptktkjkhkdeymd37();

    public void setVhsyudisptktkjkhkdeymd37(BizDate pVhsyudisptktkjkhkdeymd37);

    public BizCurrency getVhsyudisptktkjyskgns37();

    public void setVhsyudisptktkjyskgns37(BizCurrency pVhsyudisptktkjyskgns37);

    public BizDate getVhsyudisptktkjkhkdsymd47();

    public void setVhsyudisptktkjkhkdsymd47(BizDate pVhsyudisptktkjkhkdsymd47);

    public BizDate getVhsyudisptktkjkhkdeymd47();

    public void setVhsyudisptktkjkhkdeymd47(BizDate pVhsyudisptktkjkhkdeymd47);

    public BizCurrency getVhsyudisptktkjyskgns47();

    public void setVhsyudisptktkjyskgns47(BizCurrency pVhsyudisptktkjyskgns47);

    public BizDate getVhsyudisptktkjkhkdsymd57();

    public void setVhsyudisptktkjkhkdsymd57(BizDate pVhsyudisptktkjkhkdsymd57);

    public BizDate getVhsyudisptktkjkhkdeymd57();

    public void setVhsyudisptktkjkhkdeymd57(BizDate pVhsyudisptktkjkhkdeymd57);

    public BizCurrency getVhsyudisptktkjyskgns57();

    public void setVhsyudisptktkjyskgns57(BizCurrency pVhsyudisptktkjyskgns57);

    public C_Tkjyhyouten getVhsyudisptktkjyhyouten7();

    public void setVhsyudisptktkjyhyouten7(C_Tkjyhyouten pVhsyudisptktkjyhyouten7);

    public BizCurrency getVhsyudisptktkjyp7();

    public void setVhsyudisptktkjyp7(BizCurrency pVhsyudisptktkjyp7);

    public String getVhsyudisptkhtnpbuicd17();

    public void setVhsyudisptkhtnpbuicd17(String pVhsyudisptkhtnpbuicd17);

    public String getVhsyudisptkhtnpbuinm17();

    public void setVhsyudisptkhtnpbuinm17(String pVhsyudisptkhtnpbuinm17);

    public C_Htnpkkn getVhsyudisptkhtnpkkn17();

    public void setVhsyudisptkhtnpkkn17(C_Htnpkkn pVhsyudisptkhtnpkkn17);

    public String getVhsyudisptkhtnpbuicd27();

    public void setVhsyudisptkhtnpbuicd27(String pVhsyudisptkhtnpbuicd27);

    public String getVhsyudisptkhtnpbuinm27();

    public void setVhsyudisptkhtnpbuinm27(String pVhsyudisptkhtnpbuinm27);

    public C_Htnpkkn getVhsyudisptkhtnpkkn27();

    public void setVhsyudisptkhtnpkkn27(C_Htnpkkn pVhsyudisptkhtnpkkn27);

    public String getVhsyudisptkhtnpbuicd37();

    public void setVhsyudisptkhtnpbuicd37(String pVhsyudisptkhtnpbuicd37);

    public String getVhsyudisptkhtnpbuinm37();

    public void setVhsyudisptkhtnpbuinm37(String pVhsyudisptkhtnpbuinm37);

    public C_Htnpkkn getVhsyudisptkhtnpkkn37();

    public void setVhsyudisptkhtnpkkn37(C_Htnpkkn pVhsyudisptkhtnpkkn37);

    public String getVhsyudisptkhtnpbuicd47();

    public void setVhsyudisptkhtnpbuicd47(String pVhsyudisptkhtnpbuicd47);

    public String getVhsyudisptkhtnpbuinm47();

    public void setVhsyudisptkhtnpbuinm47(String pVhsyudisptkhtnpbuinm47);

    public C_Htnpkkn getVhsyudisptkhtnpkkn47();

    public void setVhsyudisptkhtnpkkn47(C_Htnpkkn pVhsyudisptkhtnpkkn47);

    public C_TokkoudosghtnpKbn getVhsyudisptktkkdsghtpkbn7();

    public void setVhsyudisptktkkdsghtpkbn7(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn7);

    public BizCurrency getVhsyudisptktutakngk7();

    public void setVhsyudisptktutakngk7(BizCurrency pVhsyudisptktutakngk7);

    public BizDate getVhsyudisptkkrkhasseiymd7();

    public void setVhsyudisptkkrkhasseiymd7(BizDate pVhsyudisptkkrkhasseiymd7);

    public String getVhsyudisptksyouhnnm8();

    public void setVhsyudisptksyouhnnm8(String pVhsyudisptksyouhnnm8);

    public C_Tuukasyu getVhsyudisptkktuukasyu8();

    public void setVhsyudisptkktuukasyu8(C_Tuukasyu pVhsyudisptkktuukasyu8);

    public C_KataKbn getVhsyudisptokyakukatakbn8();

    public void setVhsyudisptokyakukatakbn8(C_KataKbn pVhsyudisptokyakukatakbn8);

    public C_KyhgndkataKbn getVhsyudisptkkyhgdkatakbn8();

    public void setVhsyudisptkkyhgdkatakbn8(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn8);

    public Integer getVhsyudisptkhhknnen8();

    public void setVhsyudisptkhhknnen8(Integer pVhsyudisptkhhknnen8);

    public BizDate getVhsyudisptkkykymd8();

    public void setVhsyudisptkkykymd8(BizDate pVhsyudisptkkykymd8);

    public BizDate getVhsyudisptksknnkaisiymd8();

    public void setVhsyudisptksknnkaisiymd8(BizDate pVhsyudisptksknnkaisiymd8);

    public BizDate getVhsyudisptkgaskkaisiymd8();

    public void setVhsyudisptkgaskkaisiymd8(BizDate pVhsyudisptkgaskkaisiymd8);

    public BizDate getVhsyudisptkhkskkaisiymd8();

    public void setVhsyudisptkhkskkaisiymd8(BizDate pVhsyudisptkhkskkaisiymd8);

    public BizDate getVhsyudisptkhkgskksiymd8();

    public void setVhsyudisptkhkgskksiymd8(BizDate pVhsyudisptkhkgskksiymd8);

    public Integer getVhsyudisptkhknkkn8();

    public void setVhsyudisptkhknkkn8(Integer pVhsyudisptkhknkkn8);

    public C_HknkknsmnKbn getVhsyudisptkhknkknsmnkbn8();

    public void setVhsyudisptkhknkknsmnkbn8(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn8);

    public Integer getVhsyudisptkhrkkkn8();

    public void setVhsyudisptkhrkkkn8(Integer pVhsyudisptkhrkkkn8);

    public C_HrkkknsmnKbn getVhsyudisptkhrkkknsmnkbn8();

    public void setVhsyudisptkhrkkknsmnkbn8(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn8);

    public C_KihonssyuruiKbn getVhsyudisptkkihsyuruikbn8();

    public void setVhsyudisptkkihsyuruikbn8(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn8);

    public BizCurrency getVhsyudisptkkihons8();

    public void setVhsyudisptkkihons8(BizCurrency pVhsyudisptkkihons8);

    public BizCurrency getVhsyudisptktsnshrgndgk8();

    public void setVhsyudisptktsnshrgndgk8(BizCurrency pVhsyudisptktsnshrgndgk8);

    public BizCurrency getVhsyudisptkp8();

    public void setVhsyudisptkp8(BizCurrency pVhsyudisptkp8);

    public BizCurrency getVhsyudisptkkihonkyhgk8();

    public void setVhsyudisptkkihonkyhgk8(BizCurrency pVhsyudisptkkihonkyhgk8);

    public BizCurrency getVhsyudisptknextkosgop8();

    public void setVhsyudisptknextkosgop8(BizCurrency pVhsyudisptknextkosgop8);

    public C_SyukyhkinkataKbn getVhsyudisptksykyhkatakbn8();

    public void setVhsyudisptksykyhkatakbn8(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn8);

    public C_6daiLdKbn getVhsyudisptk6daildkbn8();

    public void setVhsyudisptk6daildkbn8(C_6daiLdKbn pVhsyudisptk6daildkbn8);

    public BizCurrency getVhsyudisptkganyukyhntgk8();

    public void setVhsyudisptkganyukyhntgk8(BizCurrency pVhsyudisptkganyukyhntgk8);

    public BizDate getVhsyudisptkshrskgstrymd8();

    public void setVhsyudisptkshrskgstrymd8(BizDate pVhsyudisptkshrskgstrymd8);

    public BizDate getVhsyudisptkshrskgnedymd8();

    public void setVhsyudisptkshrskgnedymd8(BizDate pVhsyudisptkshrskgnedymd8);

    public BizCurrency getVhsyudisptkshrskgngos8();

    public void setVhsyudisptkshrskgngos8(BizCurrency pVhsyudisptkshrskgngos8);

    public C_Nenkinsyu getVhsyudisptknenkinsyukbn8();

    public void setVhsyudisptknenkinsyukbn8(C_Nenkinsyu pVhsyudisptknenkinsyukbn8);

    public Integer getVhsyudisptknenkinkkn8();

    public void setVhsyudisptknenkinkkn8(Integer pVhsyudisptknenkinkkn8);

    public C_Tkjyskgnkkn getVhsyudisptktkjyskgnkkn8();

    public void setVhsyudisptktkjyskgnkkn8(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn8);

    public BizDate getVhsyudisptktkjkhkdsymd18();

    public void setVhsyudisptktkjkhkdsymd18(BizDate pVhsyudisptktkjkhkdsymd18);

    public BizDate getVhsyudisptktkjkhkdeymd18();

    public void setVhsyudisptktkjkhkdeymd18(BizDate pVhsyudisptktkjkhkdeymd18);

    public BizCurrency getVhsyudisptktkjyskgns18();

    public void setVhsyudisptktkjyskgns18(BizCurrency pVhsyudisptktkjyskgns18);

    public BizDate getVhsyudisptktkjkhkdsymd28();

    public void setVhsyudisptktkjkhkdsymd28(BizDate pVhsyudisptktkjkhkdsymd28);

    public BizDate getVhsyudisptktkjkhkdeymd28();

    public void setVhsyudisptktkjkhkdeymd28(BizDate pVhsyudisptktkjkhkdeymd28);

    public BizCurrency getVhsyudisptktkjyskgns28();

    public void setVhsyudisptktkjyskgns28(BizCurrency pVhsyudisptktkjyskgns28);

    public BizDate getVhsyudisptktkjkhkdsymd38();

    public void setVhsyudisptktkjkhkdsymd38(BizDate pVhsyudisptktkjkhkdsymd38);

    public BizDate getVhsyudisptktkjkhkdeymd38();

    public void setVhsyudisptktkjkhkdeymd38(BizDate pVhsyudisptktkjkhkdeymd38);

    public BizCurrency getVhsyudisptktkjyskgns38();

    public void setVhsyudisptktkjyskgns38(BizCurrency pVhsyudisptktkjyskgns38);

    public BizDate getVhsyudisptktkjkhkdsymd48();

    public void setVhsyudisptktkjkhkdsymd48(BizDate pVhsyudisptktkjkhkdsymd48);

    public BizDate getVhsyudisptktkjkhkdeymd48();

    public void setVhsyudisptktkjkhkdeymd48(BizDate pVhsyudisptktkjkhkdeymd48);

    public BizCurrency getVhsyudisptktkjyskgns48();

    public void setVhsyudisptktkjyskgns48(BizCurrency pVhsyudisptktkjyskgns48);

    public BizDate getVhsyudisptktkjkhkdsymd58();

    public void setVhsyudisptktkjkhkdsymd58(BizDate pVhsyudisptktkjkhkdsymd58);

    public BizDate getVhsyudisptktkjkhkdeymd58();

    public void setVhsyudisptktkjkhkdeymd58(BizDate pVhsyudisptktkjkhkdeymd58);

    public BizCurrency getVhsyudisptktkjyskgns58();

    public void setVhsyudisptktkjyskgns58(BizCurrency pVhsyudisptktkjyskgns58);

    public C_Tkjyhyouten getVhsyudisptktkjyhyouten8();

    public void setVhsyudisptktkjyhyouten8(C_Tkjyhyouten pVhsyudisptktkjyhyouten8);

    public BizCurrency getVhsyudisptktkjyp8();

    public void setVhsyudisptktkjyp8(BizCurrency pVhsyudisptktkjyp8);

    public String getVhsyudisptkhtnpbuicd18();

    public void setVhsyudisptkhtnpbuicd18(String pVhsyudisptkhtnpbuicd18);

    public String getVhsyudisptkhtnpbuinm18();

    public void setVhsyudisptkhtnpbuinm18(String pVhsyudisptkhtnpbuinm18);

    public C_Htnpkkn getVhsyudisptkhtnpkkn18();

    public void setVhsyudisptkhtnpkkn18(C_Htnpkkn pVhsyudisptkhtnpkkn18);

    public String getVhsyudisptkhtnpbuicd28();

    public void setVhsyudisptkhtnpbuicd28(String pVhsyudisptkhtnpbuicd28);

    public String getVhsyudisptkhtnpbuinm28();

    public void setVhsyudisptkhtnpbuinm28(String pVhsyudisptkhtnpbuinm28);

    public C_Htnpkkn getVhsyudisptkhtnpkkn28();

    public void setVhsyudisptkhtnpkkn28(C_Htnpkkn pVhsyudisptkhtnpkkn28);

    public String getVhsyudisptkhtnpbuicd38();

    public void setVhsyudisptkhtnpbuicd38(String pVhsyudisptkhtnpbuicd38);

    public String getVhsyudisptkhtnpbuinm38();

    public void setVhsyudisptkhtnpbuinm38(String pVhsyudisptkhtnpbuinm38);

    public C_Htnpkkn getVhsyudisptkhtnpkkn38();

    public void setVhsyudisptkhtnpkkn38(C_Htnpkkn pVhsyudisptkhtnpkkn38);

    public String getVhsyudisptkhtnpbuicd48();

    public void setVhsyudisptkhtnpbuicd48(String pVhsyudisptkhtnpbuicd48);

    public String getVhsyudisptkhtnpbuinm48();

    public void setVhsyudisptkhtnpbuinm48(String pVhsyudisptkhtnpbuinm48);

    public C_Htnpkkn getVhsyudisptkhtnpkkn48();

    public void setVhsyudisptkhtnpkkn48(C_Htnpkkn pVhsyudisptkhtnpkkn48);

    public C_TokkoudosghtnpKbn getVhsyudisptktkkdsghtpkbn8();

    public void setVhsyudisptktkkdsghtpkbn8(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn8);

    public BizCurrency getVhsyudisptktutakngk8();

    public void setVhsyudisptktutakngk8(BizCurrency pVhsyudisptktutakngk8);

    public BizDate getVhsyudisptkkrkhasseiymd8();

    public void setVhsyudisptkkrkhasseiymd8(BizDate pVhsyudisptkkrkhasseiymd8);

    public String getVhsyudisptksyouhnnm9();

    public void setVhsyudisptksyouhnnm9(String pVhsyudisptksyouhnnm9);

    public C_Tuukasyu getVhsyudisptkktuukasyu9();

    public void setVhsyudisptkktuukasyu9(C_Tuukasyu pVhsyudisptkktuukasyu9);

    public C_KataKbn getVhsyudisptokyakukatakbn9();

    public void setVhsyudisptokyakukatakbn9(C_KataKbn pVhsyudisptokyakukatakbn9);

    public C_KyhgndkataKbn getVhsyudisptkkyhgdkatakbn9();

    public void setVhsyudisptkkyhgdkatakbn9(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn9);

    public Integer getVhsyudisptkhhknnen9();

    public void setVhsyudisptkhhknnen9(Integer pVhsyudisptkhhknnen9);

    public BizDate getVhsyudisptkkykymd9();

    public void setVhsyudisptkkykymd9(BizDate pVhsyudisptkkykymd9);

    public BizDate getVhsyudisptksknnkaisiymd9();

    public void setVhsyudisptksknnkaisiymd9(BizDate pVhsyudisptksknnkaisiymd9);

    public BizDate getVhsyudisptkgaskkaisiymd9();

    public void setVhsyudisptkgaskkaisiymd9(BizDate pVhsyudisptkgaskkaisiymd9);

    public BizDate getVhsyudisptkhkskkaisiymd9();

    public void setVhsyudisptkhkskkaisiymd9(BizDate pVhsyudisptkhkskkaisiymd9);

    public BizDate getVhsyudisptkhkgskksiymd9();

    public void setVhsyudisptkhkgskksiymd9(BizDate pVhsyudisptkhkgskksiymd9);

    public Integer getVhsyudisptkhknkkn9();

    public void setVhsyudisptkhknkkn9(Integer pVhsyudisptkhknkkn9);

    public C_HknkknsmnKbn getVhsyudisptkhknkknsmnkbn9();

    public void setVhsyudisptkhknkknsmnkbn9(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn9);

    public Integer getVhsyudisptkhrkkkn9();

    public void setVhsyudisptkhrkkkn9(Integer pVhsyudisptkhrkkkn9);

    public C_HrkkknsmnKbn getVhsyudisptkhrkkknsmnkbn9();

    public void setVhsyudisptkhrkkknsmnkbn9(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn9);

    public C_KihonssyuruiKbn getVhsyudisptkkihsyuruikbn9();

    public void setVhsyudisptkkihsyuruikbn9(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn9);

    public BizCurrency getVhsyudisptkkihons9();

    public void setVhsyudisptkkihons9(BizCurrency pVhsyudisptkkihons9);

    public BizCurrency getVhsyudisptktsnshrgndgk9();

    public void setVhsyudisptktsnshrgndgk9(BizCurrency pVhsyudisptktsnshrgndgk9);

    public BizCurrency getVhsyudisptkp9();

    public void setVhsyudisptkp9(BizCurrency pVhsyudisptkp9);

    public BizCurrency getVhsyudisptkkihonkyhgk9();

    public void setVhsyudisptkkihonkyhgk9(BizCurrency pVhsyudisptkkihonkyhgk9);

    public BizCurrency getVhsyudisptknextkosgop9();

    public void setVhsyudisptknextkosgop9(BizCurrency pVhsyudisptknextkosgop9);

    public C_SyukyhkinkataKbn getVhsyudisptksykyhkatakbn9();

    public void setVhsyudisptksykyhkatakbn9(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn9);

    public C_6daiLdKbn getVhsyudisptk6daildkbn9();

    public void setVhsyudisptk6daildkbn9(C_6daiLdKbn pVhsyudisptk6daildkbn9);

    public BizCurrency getVhsyudisptkganyukyhntgk9();

    public void setVhsyudisptkganyukyhntgk9(BizCurrency pVhsyudisptkganyukyhntgk9);

    public BizDate getVhsyudisptkshrskgstrymd9();

    public void setVhsyudisptkshrskgstrymd9(BizDate pVhsyudisptkshrskgstrymd9);

    public BizDate getVhsyudisptkshrskgnedymd9();

    public void setVhsyudisptkshrskgnedymd9(BizDate pVhsyudisptkshrskgnedymd9);

    public BizCurrency getVhsyudisptkshrskgngos9();

    public void setVhsyudisptkshrskgngos9(BizCurrency pVhsyudisptkshrskgngos9);

    public C_Nenkinsyu getVhsyudisptknenkinsyukbn9();

    public void setVhsyudisptknenkinsyukbn9(C_Nenkinsyu pVhsyudisptknenkinsyukbn9);

    public Integer getVhsyudisptknenkinkkn9();

    public void setVhsyudisptknenkinkkn9(Integer pVhsyudisptknenkinkkn9);

    public C_Tkjyskgnkkn getVhsyudisptktkjyskgnkkn9();

    public void setVhsyudisptktkjyskgnkkn9(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn9);

    public BizDate getVhsyudisptktkjkhkdsymd19();

    public void setVhsyudisptktkjkhkdsymd19(BizDate pVhsyudisptktkjkhkdsymd19);

    public BizDate getVhsyudisptktkjkhkdeymd19();

    public void setVhsyudisptktkjkhkdeymd19(BizDate pVhsyudisptktkjkhkdeymd19);

    public BizCurrency getVhsyudisptktkjyskgns19();

    public void setVhsyudisptktkjyskgns19(BizCurrency pVhsyudisptktkjyskgns19);

    public BizDate getVhsyudisptktkjkhkdsymd29();

    public void setVhsyudisptktkjkhkdsymd29(BizDate pVhsyudisptktkjkhkdsymd29);

    public BizDate getVhsyudisptktkjkhkdeymd29();

    public void setVhsyudisptktkjkhkdeymd29(BizDate pVhsyudisptktkjkhkdeymd29);

    public BizCurrency getVhsyudisptktkjyskgns29();

    public void setVhsyudisptktkjyskgns29(BizCurrency pVhsyudisptktkjyskgns29);

    public BizDate getVhsyudisptktkjkhkdsymd39();

    public void setVhsyudisptktkjkhkdsymd39(BizDate pVhsyudisptktkjkhkdsymd39);

    public BizDate getVhsyudisptktkjkhkdeymd39();

    public void setVhsyudisptktkjkhkdeymd39(BizDate pVhsyudisptktkjkhkdeymd39);

    public BizCurrency getVhsyudisptktkjyskgns39();

    public void setVhsyudisptktkjyskgns39(BizCurrency pVhsyudisptktkjyskgns39);

    public BizDate getVhsyudisptktkjkhkdsymd49();

    public void setVhsyudisptktkjkhkdsymd49(BizDate pVhsyudisptktkjkhkdsymd49);

    public BizDate getVhsyudisptktkjkhkdeymd49();

    public void setVhsyudisptktkjkhkdeymd49(BizDate pVhsyudisptktkjkhkdeymd49);

    public BizCurrency getVhsyudisptktkjyskgns49();

    public void setVhsyudisptktkjyskgns49(BizCurrency pVhsyudisptktkjyskgns49);

    public BizDate getVhsyudisptktkjkhkdsymd59();

    public void setVhsyudisptktkjkhkdsymd59(BizDate pVhsyudisptktkjkhkdsymd59);

    public BizDate getVhsyudisptktkjkhkdeymd59();

    public void setVhsyudisptktkjkhkdeymd59(BizDate pVhsyudisptktkjkhkdeymd59);

    public BizCurrency getVhsyudisptktkjyskgns59();

    public void setVhsyudisptktkjyskgns59(BizCurrency pVhsyudisptktkjyskgns59);

    public C_Tkjyhyouten getVhsyudisptktkjyhyouten9();

    public void setVhsyudisptktkjyhyouten9(C_Tkjyhyouten pVhsyudisptktkjyhyouten9);

    public BizCurrency getVhsyudisptktkjyp9();

    public void setVhsyudisptktkjyp9(BizCurrency pVhsyudisptktkjyp9);

    public String getVhsyudisptkhtnpbuicd19();

    public void setVhsyudisptkhtnpbuicd19(String pVhsyudisptkhtnpbuicd19);

    public String getVhsyudisptkhtnpbuinm19();

    public void setVhsyudisptkhtnpbuinm19(String pVhsyudisptkhtnpbuinm19);

    public C_Htnpkkn getVhsyudisptkhtnpkkn19();

    public void setVhsyudisptkhtnpkkn19(C_Htnpkkn pVhsyudisptkhtnpkkn19);

    public String getVhsyudisptkhtnpbuicd29();

    public void setVhsyudisptkhtnpbuicd29(String pVhsyudisptkhtnpbuicd29);

    public String getVhsyudisptkhtnpbuinm29();

    public void setVhsyudisptkhtnpbuinm29(String pVhsyudisptkhtnpbuinm29);

    public C_Htnpkkn getVhsyudisptkhtnpkkn29();

    public void setVhsyudisptkhtnpkkn29(C_Htnpkkn pVhsyudisptkhtnpkkn29);

    public String getVhsyudisptkhtnpbuicd39();

    public void setVhsyudisptkhtnpbuicd39(String pVhsyudisptkhtnpbuicd39);

    public String getVhsyudisptkhtnpbuinm39();

    public void setVhsyudisptkhtnpbuinm39(String pVhsyudisptkhtnpbuinm39);

    public C_Htnpkkn getVhsyudisptkhtnpkkn39();

    public void setVhsyudisptkhtnpkkn39(C_Htnpkkn pVhsyudisptkhtnpkkn39);

    public String getVhsyudisptkhtnpbuicd49();

    public void setVhsyudisptkhtnpbuicd49(String pVhsyudisptkhtnpbuicd49);

    public String getVhsyudisptkhtnpbuinm49();

    public void setVhsyudisptkhtnpbuinm49(String pVhsyudisptkhtnpbuinm49);

    public C_Htnpkkn getVhsyudisptkhtnpkkn49();

    public void setVhsyudisptkhtnpkkn49(C_Htnpkkn pVhsyudisptkhtnpkkn49);

    public C_TokkoudosghtnpKbn getVhsyudisptktkkdsghtpkbn9();

    public void setVhsyudisptktkkdsghtpkbn9(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn9);

    public BizCurrency getVhsyudisptktutakngk9();

    public void setVhsyudisptktutakngk9(BizCurrency pVhsyudisptktutakngk9);

    public BizDate getVhsyudisptkkrkhasseiymd9();

    public void setVhsyudisptkkrkhasseiymd9(BizDate pVhsyudisptkkrkhasseiymd9);

    public String getVhsyudisptksyouhnnm10();

    public void setVhsyudisptksyouhnnm10(String pVhsyudisptksyouhnnm10);

    public C_Tuukasyu getVhsyudisptkktuukasyu10();

    public void setVhsyudisptkktuukasyu10(C_Tuukasyu pVhsyudisptkktuukasyu10);

    public C_KataKbn getVhsyudisptokyakukatakbn10();

    public void setVhsyudisptokyakukatakbn10(C_KataKbn pVhsyudisptokyakukatakbn10);

    public C_KyhgndkataKbn getVhsyudisptkkyhgdkatakbn10();

    public void setVhsyudisptkkyhgdkatakbn10(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn10);

    public Integer getVhsyudisptkhhknnen10();

    public void setVhsyudisptkhhknnen10(Integer pVhsyudisptkhhknnen10);

    public BizDate getVhsyudisptkkykymd10();

    public void setVhsyudisptkkykymd10(BizDate pVhsyudisptkkykymd10);

    public BizDate getVhsyudisptksknnkaisiymd10();

    public void setVhsyudisptksknnkaisiymd10(BizDate pVhsyudisptksknnkaisiymd10);

    public BizDate getVhsyudisptkgaskkaisiymd10();

    public void setVhsyudisptkgaskkaisiymd10(BizDate pVhsyudisptkgaskkaisiymd10);

    public BizDate getVhsyudisptkhkskkaisiymd10();

    public void setVhsyudisptkhkskkaisiymd10(BizDate pVhsyudisptkhkskkaisiymd10);

    public BizDate getVhsyudisptkhkgskksiymd10();

    public void setVhsyudisptkhkgskksiymd10(BizDate pVhsyudisptkhkgskksiymd10);

    public Integer getVhsyudisptkhknkkn10();

    public void setVhsyudisptkhknkkn10(Integer pVhsyudisptkhknkkn10);

    public C_HknkknsmnKbn getVhsyudisptkhknkknsmnkbn10();

    public void setVhsyudisptkhknkknsmnkbn10(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn10);

    public Integer getVhsyudisptkhrkkkn10();

    public void setVhsyudisptkhrkkkn10(Integer pVhsyudisptkhrkkkn10);

    public C_HrkkknsmnKbn getVhsyudisptkhrkkknsmnkbn10();

    public void setVhsyudisptkhrkkknsmnkbn10(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn10);

    public C_KihonssyuruiKbn getVhsyudisptkkihsyuruikbn10();

    public void setVhsyudisptkkihsyuruikbn10(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn10);

    public BizCurrency getVhsyudisptkkihons10();

    public void setVhsyudisptkkihons10(BizCurrency pVhsyudisptkkihons10);

    public BizCurrency getVhsyudisptktsnshrgndgk10();

    public void setVhsyudisptktsnshrgndgk10(BizCurrency pVhsyudisptktsnshrgndgk10);

    public BizCurrency getVhsyudisptkp10();

    public void setVhsyudisptkp10(BizCurrency pVhsyudisptkp10);

    public BizCurrency getVhsyudisptkkihonkyhgk10();

    public void setVhsyudisptkkihonkyhgk10(BizCurrency pVhsyudisptkkihonkyhgk10);

    public BizCurrency getVhsyudisptknextkosgop10();

    public void setVhsyudisptknextkosgop10(BizCurrency pVhsyudisptknextkosgop10);

    public C_SyukyhkinkataKbn getVhsyudisptksykyhkatakbn10();

    public void setVhsyudisptksykyhkatakbn10(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn10);

    public C_6daiLdKbn getVhsyudisptk6daildkbn10();

    public void setVhsyudisptk6daildkbn10(C_6daiLdKbn pVhsyudisptk6daildkbn10);

    public BizCurrency getVhsyudisptkganyukyhntgk10();

    public void setVhsyudisptkganyukyhntgk10(BizCurrency pVhsyudisptkganyukyhntgk10);

    public BizDate getVhsyudisptkshrskgstrymd10();

    public void setVhsyudisptkshrskgstrymd10(BizDate pVhsyudisptkshrskgstrymd10);

    public BizDate getVhsyudisptkshrskgnedymd10();

    public void setVhsyudisptkshrskgnedymd10(BizDate pVhsyudisptkshrskgnedymd10);

    public BizCurrency getVhsyudisptkshrskgngos10();

    public void setVhsyudisptkshrskgngos10(BizCurrency pVhsyudisptkshrskgngos10);

    public C_Nenkinsyu getVhsyudisptknenkinsyukbn10();

    public void setVhsyudisptknenkinsyukbn10(C_Nenkinsyu pVhsyudisptknenkinsyukbn10);

    public Integer getVhsyudisptknenkinkkn10();

    public void setVhsyudisptknenkinkkn10(Integer pVhsyudisptknenkinkkn10);

    public C_Tkjyskgnkkn getVhsyudisptktkjyskgnkkn10();

    public void setVhsyudisptktkjyskgnkkn10(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn10);

    public BizDate getVhsyudisptktkjkhkdsymd110();

    public void setVhsyudisptktkjkhkdsymd110(BizDate pVhsyudisptktkjkhkdsymd110);

    public BizDate getVhsyudisptktkjkhkdeymd110();

    public void setVhsyudisptktkjkhkdeymd110(BizDate pVhsyudisptktkjkhkdeymd110);

    public BizCurrency getVhsyudisptktkjyskgns110();

    public void setVhsyudisptktkjyskgns110(BizCurrency pVhsyudisptktkjyskgns110);

    public BizDate getVhsyudisptktkjkhkdsymd210();

    public void setVhsyudisptktkjkhkdsymd210(BizDate pVhsyudisptktkjkhkdsymd210);

    public BizDate getVhsyudisptktkjkhkdeymd210();

    public void setVhsyudisptktkjkhkdeymd210(BizDate pVhsyudisptktkjkhkdeymd210);

    public BizCurrency getVhsyudisptktkjyskgns210();

    public void setVhsyudisptktkjyskgns210(BizCurrency pVhsyudisptktkjyskgns210);

    public BizDate getVhsyudisptktkjkhkdsymd310();

    public void setVhsyudisptktkjkhkdsymd310(BizDate pVhsyudisptktkjkhkdsymd310);

    public BizDate getVhsyudisptktkjkhkdeymd310();

    public void setVhsyudisptktkjkhkdeymd310(BizDate pVhsyudisptktkjkhkdeymd310);

    public BizCurrency getVhsyudisptktkjyskgns310();

    public void setVhsyudisptktkjyskgns310(BizCurrency pVhsyudisptktkjyskgns310);

    public BizDate getVhsyudisptktkjkhkdsymd410();

    public void setVhsyudisptktkjkhkdsymd410(BizDate pVhsyudisptktkjkhkdsymd410);

    public BizDate getVhsyudisptktkjkhkdeymd410();

    public void setVhsyudisptktkjkhkdeymd410(BizDate pVhsyudisptktkjkhkdeymd410);

    public BizCurrency getVhsyudisptktkjyskgns410();

    public void setVhsyudisptktkjyskgns410(BizCurrency pVhsyudisptktkjyskgns410);

    public BizDate getVhsyudisptktkjkhkdsymd510();

    public void setVhsyudisptktkjkhkdsymd510(BizDate pVhsyudisptktkjkhkdsymd510);

    public BizDate getVhsyudisptktkjkhkdeymd510();

    public void setVhsyudisptktkjkhkdeymd510(BizDate pVhsyudisptktkjkhkdeymd510);

    public BizCurrency getVhsyudisptktkjyskgns510();

    public void setVhsyudisptktkjyskgns510(BizCurrency pVhsyudisptktkjyskgns510);

    public C_Tkjyhyouten getVhsyudisptktkjyhyouten10();

    public void setVhsyudisptktkjyhyouten10(C_Tkjyhyouten pVhsyudisptktkjyhyouten10);

    public BizCurrency getVhsyudisptktkjyp10();

    public void setVhsyudisptktkjyp10(BizCurrency pVhsyudisptktkjyp10);

    public String getVhsyudisptkhtnpbuicd110();

    public void setVhsyudisptkhtnpbuicd110(String pVhsyudisptkhtnpbuicd110);

    public String getVhsyudisptkhtnpbuinm110();

    public void setVhsyudisptkhtnpbuinm110(String pVhsyudisptkhtnpbuinm110);

    public C_Htnpkkn getVhsyudisptkhtnpkkn110();

    public void setVhsyudisptkhtnpkkn110(C_Htnpkkn pVhsyudisptkhtnpkkn110);

    public String getVhsyudisptkhtnpbuicd210();

    public void setVhsyudisptkhtnpbuicd210(String pVhsyudisptkhtnpbuicd210);

    public String getVhsyudisptkhtnpbuinm210();

    public void setVhsyudisptkhtnpbuinm210(String pVhsyudisptkhtnpbuinm210);

    public C_Htnpkkn getVhsyudisptkhtnpkkn210();

    public void setVhsyudisptkhtnpkkn210(C_Htnpkkn pVhsyudisptkhtnpkkn210);

    public String getVhsyudisptkhtnpbuicd310();

    public void setVhsyudisptkhtnpbuicd310(String pVhsyudisptkhtnpbuicd310);

    public String getVhsyudisptkhtnpbuinm310();

    public void setVhsyudisptkhtnpbuinm310(String pVhsyudisptkhtnpbuinm310);

    public C_Htnpkkn getVhsyudisptkhtnpkkn310();

    public void setVhsyudisptkhtnpkkn310(C_Htnpkkn pVhsyudisptkhtnpkkn310);

    public String getVhsyudisptkhtnpbuicd410();

    public void setVhsyudisptkhtnpbuicd410(String pVhsyudisptkhtnpbuicd410);

    public String getVhsyudisptkhtnpbuinm410();

    public void setVhsyudisptkhtnpbuinm410(String pVhsyudisptkhtnpbuinm410);

    public C_Htnpkkn getVhsyudisptkhtnpkkn410();

    public void setVhsyudisptkhtnpkkn410(C_Htnpkkn pVhsyudisptkhtnpkkn410);

    public C_TokkoudosghtnpKbn getVhsyudisptktkkdsghtpkbn10();

    public void setVhsyudisptktkkdsghtpkbn10(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn10);

    public BizCurrency getVhsyudisptktutakngk10();

    public void setVhsyudisptktutakngk10(BizCurrency pVhsyudisptktutakngk10);

    public BizDate getVhsyudisptkkrkhasseiymd10();

    public void setVhsyudisptkkrkhasseiymd10(BizDate pVhsyudisptkkrkhasseiymd10);

    public C_UmuKbn getVhsyusyunkhknumu();

    public void setVhsyusyunkhknumu(C_UmuKbn pVhsyusyunkhknumu);

    public C_UmuKbn getVhsyusyugannyukyhumu();

    public void setVhsyusyugannyukyhumu(C_UmuKbn pVhsyusyugannyukyhumu);

    public C_KhnkyhkgbairituKbn getVhsyusyukhnkyhkgbairitukbn();

    public void setVhsyusyukhnkyhkgbairitukbn(C_KhnkyhkgbairituKbn pVhsyusyukhnkyhkgbairitukbn);

    public C_UmuKbn getVhsyusyusndkyhkinshrskgnumu();

    public void setVhsyusyusndkyhkinshrskgnumu(C_UmuKbn pVhsyusyusndkyhkinshrskgnumu);

    public C_UmuKbn getVhsyusyutsnshrgndhjumu();

    public void setVhsyusyutsnshrgndhjumu(C_UmuKbn pVhsyusyutsnshrgndhjumu);

    public C_UmuKbn getVhsyusyunextkosumu();

    public void setVhsyusyunextkosumu(C_UmuKbn pVhsyusyunextkosumu);

    public C_UmuKbn getVhsyusyuhghkumu();

    public void setVhsyusyuhghkumu(C_UmuKbn pVhsyusyuhghkumu);

    public C_UmuKbn getVhsyunstkhukaumukbn();

    public void setVhsyunstkhukaumukbn(C_UmuKbn pVhsyunstkhukaumukbn);

    public String getVhsyudisptksyouhncd1();

    public void setVhsyudisptksyouhncd1(String pVhsyudisptksyouhncd1);

    public String getVhsyudisptksyouhncd2();

    public void setVhsyudisptksyouhncd2(String pVhsyudisptksyouhncd2);

    public String getVhsyudisptksyouhncd3();

    public void setVhsyudisptksyouhncd3(String pVhsyudisptksyouhncd3);

    public String getVhsyudisptksyouhncd4();

    public void setVhsyudisptksyouhncd4(String pVhsyudisptksyouhncd4);

    public String getVhsyudisptksyouhncd5();

    public void setVhsyudisptksyouhncd5(String pVhsyudisptksyouhncd5);

    public String getVhsyudisptksyouhncd6();

    public void setVhsyudisptksyouhncd6(String pVhsyudisptksyouhncd6);

    public String getVhsyudisptksyouhncd7();

    public void setVhsyudisptksyouhncd7(String pVhsyudisptksyouhncd7);

    public String getVhsyudisptksyouhncd8();

    public void setVhsyudisptksyouhncd8(String pVhsyudisptksyouhncd8);

    public String getVhsyudisptksyouhncd9();

    public void setVhsyudisptksyouhncd9(String pVhsyudisptksyouhncd9);

    public String getVhsyudisptksyouhncd10();

    public void setVhsyudisptksyouhncd10(String pVhsyudisptksyouhncd10);

    public C_UmuKbn getVhsyudisptknkhknumu1();

    public void setVhsyudisptknkhknumu1(C_UmuKbn pVhsyudisptknkhknumu1);

    public C_UmuKbn getVhsyudisptknkhknumu2();

    public void setVhsyudisptknkhknumu2(C_UmuKbn pVhsyudisptknkhknumu2);

    public C_UmuKbn getVhsyudisptknkhknumu3();

    public void setVhsyudisptknkhknumu3(C_UmuKbn pVhsyudisptknkhknumu3);

    public C_UmuKbn getVhsyudisptknkhknumu4() ;

    public void setVhsyudisptknkhknumu4(C_UmuKbn pVhsyudisptknkhknumu4);

    public C_UmuKbn getVhsyudisptknkhknumu5();

    public void setVhsyudisptknkhknumu5(C_UmuKbn pVhsyudisptknkhknumu5);

    public C_UmuKbn getVhsyudisptknkhknumu6();

    public void setVhsyudisptknkhknumu6(C_UmuKbn pVhsyudisptknkhknumu6);

    public C_UmuKbn getVhsyudisptknkhknumu7();

    public void setVhsyudisptknkhknumu7(C_UmuKbn pVhsyudisptknkhknumu7);

    public C_UmuKbn getVhsyudisptknkhknumu8();

    public void setVhsyudisptknkhknumu8(C_UmuKbn pVhsyudisptknkhknumu8);

    public C_UmuKbn getVhsyudisptknkhknumu9() ;

    public void setVhsyudisptknkhknumu9(C_UmuKbn pVhsyudisptknkhknumu9);

    public C_UmuKbn getVhsyudisptknkhknumu10();

    public void setVhsyudisptknkhknumu10(C_UmuKbn pVhsyudisptknkhknumu10);

    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn1();

    public void setVhsyudisptkkgbairitukbn1(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn1);

    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn2();

    public void setVhsyudisptkkgbairitukbn2(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn2);

    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn3();

    public void setVhsyudisptkkgbairitukbn3(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn3);

    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn4();

    public void setVhsyudisptkkgbairitukbn4(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn4);

    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn5();

    public void setVhsyudisptkkgbairitukbn5(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn5);

    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn6();

    public void setVhsyudisptkkgbairitukbn6(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn6);

    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn7();

    public void setVhsyudisptkkgbairitukbn7(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn7);

    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn8();

    public void setVhsyudisptkkgbairitukbn8(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn8);

    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn9();

    public void setVhsyudisptkkgbairitukbn9(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn9);

    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn10();

    public void setVhsyudisptkkgbairitukbn10(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn10);

    public C_UmuKbn getVhsyudisptknextkosumu1() ;

    public void setVhsyudisptknextkosumu1(C_UmuKbn pVhsyudisptknextkosumu1);

    public C_UmuKbn getVhsyudisptknextkosumu2() ;

    public void setVhsyudisptknextkosumu2(C_UmuKbn pVhsyudisptknextkosumu2);

    public C_UmuKbn getVhsyudisptknextkosumu3();

    public void setVhsyudisptknextkosumu3(C_UmuKbn pVhsyudisptknextkosumu3);

    public C_UmuKbn getVhsyudisptknextkosumu4();

    public void setVhsyudisptknextkosumu4(C_UmuKbn pVhsyudisptknextkosumu4) ;

    public C_UmuKbn getVhsyudisptknextkosumu5();

    public void setVhsyudisptknextkosumu5(C_UmuKbn pVhsyudisptknextkosumu5) ;

    public C_UmuKbn getVhsyudisptknextkosumu6() ;

    public void setVhsyudisptknextkosumu6(C_UmuKbn pVhsyudisptknextkosumu6);

    public C_UmuKbn getVhsyudisptknextkosumu7();

    public void setVhsyudisptknextkosumu7(C_UmuKbn pVhsyudisptknextkosumu7);

    public C_UmuKbn getVhsyudisptknextkosumu8();

    public void setVhsyudisptknextkosumu8(C_UmuKbn pVhsyudisptknextkosumu8);

    public C_UmuKbn getVhsyudisptknextkosumu9();

    public void setVhsyudisptknextkosumu9(C_UmuKbn pVhsyudisptknextkosumu9);

    public C_UmuKbn getVhsyudisptknextkosumu10();

    public void setVhsyudisptknextkosumu10(C_UmuKbn pVhsyudisptknextkosumu10);

    public C_UmuKbn getVhsyudisptkgannyukyhumu1();

    public void setVhsyudisptkgannyukyhumu1(C_UmuKbn pVhsyudisptkgannyukyhumu1);

    public C_UmuKbn getVhsyudisptkgannyukyhumu2();

    public void setVhsyudisptkgannyukyhumu2(C_UmuKbn pVhsyudisptkgannyukyhumu2);

    public C_UmuKbn getVhsyudisptkgannyukyhumu3();

    public void setVhsyudisptkgannyukyhumu3(C_UmuKbn pVhsyudisptkgannyukyhumu3);

    public C_UmuKbn getVhsyudisptkgannyukyhumu4();

    public void setVhsyudisptkgannyukyhumu4(C_UmuKbn pVhsyudisptkgannyukyhumu4);

    public C_UmuKbn getVhsyudisptkgannyukyhumu5();

    public void setVhsyudisptkgannyukyhumu5(C_UmuKbn pVhsyudisptkgannyukyhumu5);

    public C_UmuKbn getVhsyudisptkgannyukyhumu6();

    public void setVhsyudisptkgannyukyhumu6(C_UmuKbn pVhsyudisptkgannyukyhumu6);

    public C_UmuKbn getVhsyudisptkgannyukyhumu7();

    public void setVhsyudisptkgannyukyhumu7(C_UmuKbn pVhsyudisptkgannyukyhumu7);

    public C_UmuKbn getVhsyudisptkgannyukyhumu8();

    public void setVhsyudisptkgannyukyhumu8(C_UmuKbn pVhsyudisptkgannyukyhumu8);

    public C_UmuKbn getVhsyudisptkgannyukyhumu9();

    public void setVhsyudisptkgannyukyhumu9(C_UmuKbn pVhsyudisptkgannyukyhumu9);

    public C_UmuKbn getVhsyudisptkgannyukyhumu10();

    public void setVhsyudisptkgannyukyhumu10(C_UmuKbn pVhsyudisptkgannyukyhumu10);

    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu1() ;

    public void setVhsyudisptksndkyhkinshrskgnumu1(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu1) ;

    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu2();

    public void setVhsyudisptksndkyhkinshrskgnumu2(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu2);

    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu3();

    public void setVhsyudisptksndkyhkinshrskgnumu3(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu3);

    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu4();

    public void setVhsyudisptksndkyhkinshrskgnumu4(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu4);

    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu5() ;

    public void setVhsyudisptksndkyhkinshrskgnumu5(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu5);

    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu6();

    public void setVhsyudisptksndkyhkinshrskgnumu6(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu6) ;

    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu7();

    public void setVhsyudisptksndkyhkinshrskgnumu7(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu7);

    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu8();

    public void setVhsyudisptksndkyhkinshrskgnumu8(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu8) ;

    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu9() ;

    public void setVhsyudisptksndkyhkinshrskgnumu9(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu9);

    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu10() ;

    public void setVhsyudisptksndkyhkinshrskgnumu10(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu10);

    public C_UmuKbn getVhsyudisptktsnshrgndhjumu1();

    public void setVhsyudisptktsnshrgndhjumu1(C_UmuKbn pVhsyudisptktsnshrgndhjumu1);

    public C_UmuKbn getVhsyudisptktsnshrgndhjumu2();

    public void setVhsyudisptktsnshrgndhjumu2(C_UmuKbn pVhsyudisptktsnshrgndhjumu2);

    public C_UmuKbn getVhsyudisptktsnshrgndhjumu3();

    public void setVhsyudisptktsnshrgndhjumu3(C_UmuKbn pVhsyudisptktsnshrgndhjumu3);

    public C_UmuKbn getVhsyudisptktsnshrgndhjumu4();

    public void setVhsyudisptktsnshrgndhjumu4(C_UmuKbn pVhsyudisptktsnshrgndhjumu4);

    public C_UmuKbn getVhsyudisptktsnshrgndhjumu5();

    public void setVhsyudisptktsnshrgndhjumu5(C_UmuKbn pVhsyudisptktsnshrgndhjumu5);

    public C_UmuKbn getVhsyudisptktsnshrgndhjumu6();

    public void setVhsyudisptktsnshrgndhjumu6(C_UmuKbn pVhsyudisptktsnshrgndhjumu6);

    public C_UmuKbn getVhsyudisptktsnshrgndhjumu7();

    public void setVhsyudisptktsnshrgndhjumu7(C_UmuKbn pVhsyudisptktsnshrgndhjumu7);

    public C_UmuKbn getVhsyudisptktsnshrgndhjumu8() ;

    public void setVhsyudisptktsnshrgndhjumu8(C_UmuKbn pVhsyudisptktsnshrgndhjumu8);

    public C_UmuKbn getVhsyudisptktsnshrgndhjumu9();

    public void setVhsyudisptktsnshrgndhjumu9(C_UmuKbn pVhsyudisptktsnshrgndhjumu9);

    public C_UmuKbn getVhsyudisptktsnshrgndhjumu10();

    public void setVhsyudisptktsnshrgndhjumu10(C_UmuKbn pVhsyudisptktsnshrgndhjumu10);

    public C_UmuKbn getVhsyudisptkhghkumu1();

    public void setVhsyudisptkhghkumu1(C_UmuKbn pVhsyudisptkhghkumu1);

    public C_UmuKbn getVhsyudisptkhghkumu2();

    public void setVhsyudisptkhghkumu2(C_UmuKbn pVhsyudisptkhghkumu2);

    public C_UmuKbn getVhsyudisptkhghkumu3();

    public void setVhsyudisptkhghkumu3(C_UmuKbn pVhsyudisptkhghkumu3);

    public C_UmuKbn getVhsyudisptkhghkumu4();

    public void setVhsyudisptkhghkumu4(C_UmuKbn pVhsyudisptkhghkumu4);

    public C_UmuKbn getVhsyudisptkhghkumu5();

    public void setVhsyudisptkhghkumu5(C_UmuKbn pVhsyudisptkhghkumu5);

    public C_UmuKbn getVhsyudisptkhghkumu6();

    public void setVhsyudisptkhghkumu6(C_UmuKbn pVhsyudisptkhghkumu6);

    public C_UmuKbn getVhsyudisptkhghkumu7();

    public void setVhsyudisptkhghkumu7(C_UmuKbn pVhsyudisptkhghkumu7);

    public C_UmuKbn getVhsyudisptkhghkumu8();

    public void setVhsyudisptkhghkumu8(C_UmuKbn pVhsyudisptkhghkumu8);

    public C_UmuKbn getVhsyudisptkhghkumu9();

    public void setVhsyudisptkhghkumu9(C_UmuKbn pVhsyudisptkhghkumu9);

    public C_UmuKbn getVhsyudisptkhghkumu10();

    public void setVhsyudisptkhghkumu10(C_UmuKbn pVhsyudisptkhghkumu10);

    public C_UmuKbn getVhsyuitijibrumu();

    public C_UmuKbn getVhsyugenzaikngkhyjfukaumu();

    public void setVhsyugenzaikngkhyjfukaumu(C_UmuKbn pVhsyugenzaikngkhyjfukaumu);

    public C_YendthnkJyoutaiKbn getVhsyuyendthnkjyoutaikbn();

    public void setVhsyuyendthnkjyoutaikbn(C_YendthnkJyoutaiKbn pVhsyuyendthnkjyoutaikbn);

    public DataSource getTbktInfoDataSource();
}
