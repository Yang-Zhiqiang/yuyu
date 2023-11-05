package yuyu.common.hozen.setuibean;

import java.util.ArrayList;
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
 * 契約保全 UiBean設定 保障内容設定UiBean
 */
public class SetHosyouExecUiBeanParamImpl implements SetHosyouExecUiBeanParam{

    private String syono;

    private String vhsyusyusyouhnnm;

    private C_AisyoumeiKbn vhsyuaisyoumeikbn;

    private C_Tuukasyu vhsyusyukyktuukasyu;

    private C_Tuukasyu vhsyusyukykjisiteituukasyu;

    private C_KataKbn vhsyusyukatakbn;

    private C_KyhgndkataKbn vhsyusyukyhgndkatakbn;

    private Integer vhsyusyuhhknnen;

    private BizDate vhsyusyukykymd;

    private BizDate vhsyusyusknnkaisiymd;

    private BizDate vhsyugansknnkaisiymd;

    private BizDate vhsyusyufktsknnkaisiymd;

    private BizDate vhsyuhkgogansknnkaisiymd;

    private Integer vhsyusyuhknkkn;

    private C_HknkknsmnKbn vhsyusyuhknkknsmnkbn;

    private Integer vhsyudai1hknkkn;

    private C_Sdpd  vhsyusdpdkbn;

    private Integer vhsyusyuhrkkkn;

    private C_HrkkknsmnKbn vhsyusyuhrkkknsmnkbn;

    private C_KihonssyuruiKbn vhsyusyukihonssyuruikbn;

    private BizCurrency vhsyusyukihons;

    private BizCurrency vhsyusyukykkjnkngk;

    private BizCurrency vhsyugenzaisbhknkngaku;

    private BizCurrency vhsyusaigaisbhknkngaku;

    private BizCurrency vhsyusyukihonkyhgk;

    private BizCurrency vhsyusyup;

    private BizCurrency vhsyusyunextkosgop;

    private C_SyukyhkinkataKbn vhsyusyusyukyhkinkatakbn;

    private C_6daiLdKbn vhsyusyurokudaildkbn;

    private BizCurrency vhsyusyugannyukyhntgk;

    private BizDate vhsyusyushrskgnstartymd;

    private BizDate vhsyusyushrskgnendymd;

    private BizCurrency vhsyusyushrskgngos;

    private C_Nenkinsyu vhsyusyunnkinsyukbn;

    private Integer vhsyusyunenkinkkn;

    private C_Tkjyskgnkkn vhsyusyutkjyskgnkkn;

    private BizDate vhsyusyutkjyskgnhkndsymd1;

    private BizDate vhsyusyutkjyskgnhkndeymd1;

    private BizCurrency vhsyusyutkjyskgns1;

    private BizDate vhsyusyutkjyskgnhkndsymd2;

    private BizDate  vhsyusyutkjyskgnhkndeymd2;

    private BizCurrency vhsyusyutkjyskgns2;

    private BizDate vhsyusyutkjyskgnhkndsymd3;

    private BizDate vhsyusyutkjyskgnhkndeymd3;

    private BizCurrency vhsyusyutkjyskgns3;

    private BizDate vhsyusyutkjyskgnhkndsymd4;

    private BizDate vhsyusyutkjyskgnhkndeymd4;

    private BizCurrency vhsyusyutkjyskgns4;

    private BizDate vhsyusyutkjyskgnhkndsymd5;

    private BizDate vhsyusyutkjyskgnhkndeymd5;

    private BizCurrency vhsyusyutkjyskgns5;

    private C_Tkjyhyouten vhsyusyutkjyhyouten;

    private BizCurrency vhsyusyutkjyp;

    private String vhsyusyuhtnpbuicd1;

    private String vhsyusyuhtnpbuinm1;

    private C_Htnpkkn vhsyusyuhtnpkkn1;

    private String vhsyusyuhtnpbuicd2;

    private String vhsyusyuhtnpbuinm2;

    private C_Htnpkkn vhsyusyuhtnpkkn2;

    private String vhsyusyuhtnpbuicd3;

    private String vhsyusyuhtnpbuinm3;

    private C_Htnpkkn vhsyusyuhtnpkkn3;

    private String vhsyusyuhtnpbuicd4;

    private String vhsyusyuhtnpbuinm4;

    private C_Htnpkkn vhsyusyuhtnpkkn4;

    private C_TokkoudosghtnpKbn vhsyusyutokkdsghtnpkbn;

    private BizCurrency vhsyusyututakngk;

    private BizDate vhsyusyukouryokuhasseiymd;

    private C_UmuKbn vhsyudai1hknkknsbsyokuseiumu;

    private C_UmuKbn vhsyusgsbhsyumu;

    private C_HknKknKbn vhsyuhknKknKbn;

    private int vhsyusyohinhanteikbn;

    private C_UmuKbn vhsyumvatekiumu;

    private C_UmuKbn vhsyusbhkuktumu;

    private C_UmuKbn vhsyusbkyuuhukinuktumu;

    private BizDate vhsyuyendthnkymd;

    private BizDate vhsyutmttknitenymd;

    private BizDate vhsyusyunkshrstartymd;

    private BizCurrency vhsyuteiritutmttkngk;

    private BizCurrency vhsyusisuurendoutmttkngk;

    private BizCurrency vhsyugenzaitmttkngk;

    private BizNumber vhsyusisuurendourate;

    private BizNumber vhsyuteiritutmttrate;

    private String vhsyusisuunm;

    private BizNumber vhsyusetteibairitu;

    private BizNumber vhsyuyoteiriritu;

    private BizNumber vhsyutumitateriritu;

    private BizNumber vhsyukyktumitateriritu;

    private BizNumber vhsyu10nentumitateriritu;

    private BizNumber vhsyukyksjkkktyouseiriritu;

    private BizNumber vhsyuskisjkkktyouseiriritu;

    private String vhsyudisptksyouhnnm;

    private C_Nstknsyu vhsyunkshrtkyknksyukbn;

    private Integer vhsyunkshrtkyknksyukkn;

    private String vhsyudisptksyouhnnm1;

    private C_Tuukasyu vhsyudisptkktuukasyu1;

    private C_KataKbn vhsyudisptokyakukatakbn1;

    private C_KyhgndkataKbn vhsyudisptkkyhgdkatakbn1;

    private Integer vhsyudisptkhhknnen1;

    private BizDate vhsyudisptkkykymd1;

    private BizDate vhsyudisptksknnkaisiymd1;

    private BizDate vhsyudisptkgaskkaisiymd1;

    private BizDate vhsyudisptkhkskkaisiymd1;

    private BizDate vhsyudisptkhkgskksiymd1;

    private Integer vhsyudisptkhknkkn1;

    private C_HknkknsmnKbn vhsyudisptkhknkknsmnkbn1;

    private Integer vhsyudisptkhrkkkn1;

    private C_HrkkknsmnKbn vhsyudisptkhrkkknsmnkbn1;

    private C_KihonssyuruiKbn vhsyudisptkkihsyuruikbn1;

    private BizCurrency vhsyudisptkkihons1;

    private BizCurrency vhsyudisptkp1;

    private BizCurrency vhsyudisptkkihonkyhgk1;

    private BizCurrency vhsyudisptknextkosgop1;

    private C_SyukyhkinkataKbn vhsyudisptksykyhkatakbn1;

    private C_6daiLdKbn vhsyudisptk6daildkbn1;

    private BizCurrency vhsyudisptkganyukyhntgk1;

    private BizDate vhsyudisptkshrskgstrymd1;

    private BizDate vhsyudisptkshrskgnedymd1;

    private BizCurrency vhsyudisptkshrskgngos1;

    private C_Nenkinsyu vhsyudisptknenkinsyukbn1;

    private Integer vhsyudisptknenkinkkn1;

    private C_Tkjyskgnkkn vhsyudisptktkjyskgnkkn1;

    private BizDate vhsyudisptktkjkhkdsymd11;

    private BizDate vhsyudisptktkjkhkdeymd11;

    private BizCurrency vhsyudisptktkjyskgns11;

    private BizDate vhsyudisptktkjkhkdsymd21;

    private BizDate vhsyudisptktkjkhkdeymd21;

    private BizCurrency vhsyudisptktkjyskgns21;

    private BizDate vhsyudisptktkjkhkdsymd31;

    private BizDate vhsyudisptktkjkhkdeymd31;

    private BizCurrency vhsyudisptktkjyskgns31;

    private BizDate vhsyudisptktkjkhkdsymd41;

    private BizDate vhsyudisptktkjkhkdeymd41;

    private BizCurrency vhsyudisptktkjyskgns41;

    private BizDate vhsyudisptktkjkhkdsymd51;

    private BizDate vhsyudisptktkjkhkdeymd51;

    private BizCurrency vhsyudisptktkjyskgns51;

    private C_Tkjyhyouten vhsyudisptktkjyhyouten1;

    private BizCurrency vhsyudisptktkjyp1;

    private String vhsyudisptkhtnpbuicd11;

    private String vhsyudisptkhtnpbuinm11;

    private C_Htnpkkn vhsyudisptkhtnpkkn11;

    private String vhsyudisptkhtnpbuicd21;

    private String vhsyudisptkhtnpbuinm21;

    private C_Htnpkkn vhsyudisptkhtnpkkn21;

    private String vhsyudisptkhtnpbuicd31;

    private String vhsyudisptkhtnpbuinm31;

    private C_Htnpkkn vhsyudisptkhtnpkkn31;

    private String vhsyudisptkhtnpbuicd41;

    private String vhsyudisptkhtnpbuinm41;

    private C_Htnpkkn vhsyudisptkhtnpkkn41;

    private C_TokkoudosghtnpKbn vhsyudisptktkkdsghtpkbn1;

    private BizCurrency vhsyudisptktutakngk1;

    private BizDate vhsyudisptkkrkhasseiymd1;

    private String vhsyudisptksyouhnnm2;

    private C_Tuukasyu vhsyudisptkktuukasyu2;

    private C_KataKbn vhsyudisptokyakukatakbn2;

    private C_KyhgndkataKbn vhsyudisptkkyhgdkatakbn2;

    private Integer vhsyudisptkhhknnen2;

    private BizDate vhsyudisptkkykymd2;

    private BizDate vhsyudisptksknnkaisiymd2;

    private BizDate vhsyudisptkgaskkaisiymd2;

    private BizDate vhsyudisptkhkskkaisiymd2;

    private BizDate vhsyudisptkhkgskksiymd2;

    private Integer vhsyudisptkhknkkn2;

    private C_HknkknsmnKbn vhsyudisptkhknkknsmnkbn2;

    private Integer vhsyudisptkhrkkkn2;

    private C_HrkkknsmnKbn vhsyudisptkhrkkknsmnkbn2;

    private C_KihonssyuruiKbn vhsyudisptkkihsyuruikbn2;

    private BizCurrency vhsyudisptkkihons2;

    private BizCurrency vhsyudisptkp2;

    private BizCurrency vhsyudisptkkihonkyhgk2;

    private BizCurrency vhsyudisptknextkosgop2;

    private C_SyukyhkinkataKbn vhsyudisptksykyhkatakbn2;

    private C_6daiLdKbn vhsyudisptk6daildkbn2;

    private BizCurrency vhsyudisptkganyukyhntgk2;

    private BizDate vhsyudisptkshrskgstrymd2;

    private BizDate vhsyudisptkshrskgnedymd2;

    private BizCurrency vhsyudisptkshrskgngos2;

    private C_Nenkinsyu vhsyudisptknenkinsyukbn2;

    private Integer vhsyudisptknenkinkkn2;

    private C_Tkjyskgnkkn vhsyudisptktkjyskgnkkn2;

    private BizDate vhsyudisptktkjkhkdsymd12;

    private BizDate vhsyudisptktkjkhkdeymd12;

    private BizCurrency vhsyudisptktkjyskgns12;

    private BizDate vhsyudisptktkjkhkdsymd22;

    private BizDate vhsyudisptktkjkhkdeymd22;

    private BizCurrency vhsyudisptktkjyskgns22;

    private BizDate vhsyudisptktkjkhkdsymd32;

    private BizDate vhsyudisptktkjkhkdeymd32;

    private BizCurrency vhsyudisptktkjyskgns32;

    private BizDate vhsyudisptktkjkhkdsymd42;

    private BizDate vhsyudisptktkjkhkdeymd42;

    private BizCurrency vhsyudisptktkjyskgns42;

    private BizDate vhsyudisptktkjkhkdsymd52;

    private BizDate vhsyudisptktkjkhkdeymd52;

    private BizCurrency vhsyudisptktkjyskgns52;

    private C_Tkjyhyouten vhsyudisptktkjyhyouten2;

    private BizCurrency vhsyudisptktkjyp2;

    private String vhsyudisptkhtnpbuicd12;

    private String vhsyudisptkhtnpbuinm12;

    private C_Htnpkkn vhsyudisptkhtnpkkn12;

    private String vhsyudisptkhtnpbuicd22;

    private String vhsyudisptkhtnpbuinm22;

    private C_Htnpkkn vhsyudisptkhtnpkkn22;

    private String vhsyudisptkhtnpbuicd32;

    private String vhsyudisptkhtnpbuinm32;

    private C_Htnpkkn vhsyudisptkhtnpkkn32;

    private String vhsyudisptkhtnpbuicd42;

    private String vhsyudisptkhtnpbuinm42;

    private C_Htnpkkn vhsyudisptkhtnpkkn42;

    private C_TokkoudosghtnpKbn vhsyudisptktkkdsghtpkbn2;

    private BizCurrency vhsyudisptktutakngk2;

    private BizDate vhsyudisptkkrkhasseiymd2;

    private String vhsyudisptksyouhnnm3;

    private C_Tuukasyu vhsyudisptkktuukasyu3;

    private C_KataKbn vhsyudisptokyakukatakbn3;

    private C_KyhgndkataKbn vhsyudisptkkyhgdkatakbn3;

    private Integer vhsyudisptkhhknnen3;

    private BizDate vhsyudisptkkykymd3;

    private BizDate vhsyudisptksknnkaisiymd3;

    private BizDate vhsyudisptkgaskkaisiymd3;

    private BizDate vhsyudisptkhkskkaisiymd3;

    private BizDate vhsyudisptkhkgskksiymd3;

    private Integer vhsyudisptkhknkkn3;

    private C_HknkknsmnKbn vhsyudisptkhknkknsmnkbn3;

    private Integer vhsyudisptkhrkkkn3;

    private C_HrkkknsmnKbn vhsyudisptkhrkkknsmnkbn3;

    private C_KihonssyuruiKbn vhsyudisptkkihsyuruikbn3;

    private BizCurrency vhsyudisptkkihons3;

    private BizCurrency vhsyudisptkp3;

    private BizCurrency vhsyudisptkkihonkyhgk3;

    private BizCurrency vhsyudisptknextkosgop3;

    private C_SyukyhkinkataKbn vhsyudisptksykyhkatakbn3;

    private C_6daiLdKbn vhsyudisptk6daildkbn3;

    private BizCurrency vhsyudisptkganyukyhntgk3;

    private BizDate vhsyudisptkshrskgstrymd3;

    private BizDate vhsyudisptkshrskgnedymd3;

    private BizCurrency vhsyudisptkshrskgngos3;

    private C_Nenkinsyu vhsyudisptknenkinsyukbn3;

    private Integer vhsyudisptknenkinkkn3;

    private C_Tkjyskgnkkn vhsyudisptktkjyskgnkkn3;

    private BizDate vhsyudisptktkjkhkdsymd13;

    private BizDate vhsyudisptktkjkhkdeymd13;

    private BizCurrency vhsyudisptktkjyskgns13;

    private BizDate vhsyudisptktkjkhkdsymd23;

    private BizDate vhsyudisptktkjkhkdeymd23;

    private BizCurrency vhsyudisptktkjyskgns23;

    private BizDate vhsyudisptktkjkhkdsymd33;

    private BizDate vhsyudisptktkjkhkdeymd33;

    private BizCurrency vhsyudisptktkjyskgns33;

    private BizDate vhsyudisptktkjkhkdsymd43;

    private BizDate vhsyudisptktkjkhkdeymd43;

    private BizCurrency vhsyudisptktkjyskgns43;

    private BizDate vhsyudisptktkjkhkdsymd53;

    private BizDate vhsyudisptktkjkhkdeymd53;

    private BizCurrency vhsyudisptktkjyskgns53;

    private C_Tkjyhyouten vhsyudisptktkjyhyouten3;

    private BizCurrency vhsyudisptktkjyp3;

    private String vhsyudisptkhtnpbuicd13;

    private String vhsyudisptkhtnpbuinm13;

    private C_Htnpkkn vhsyudisptkhtnpkkn13;

    private String vhsyudisptkhtnpbuicd23;

    private String vhsyudisptkhtnpbuinm23;

    private C_Htnpkkn vhsyudisptkhtnpkkn23;

    private String vhsyudisptkhtnpbuicd33;

    private String vhsyudisptkhtnpbuinm33;

    private C_Htnpkkn vhsyudisptkhtnpkkn33;

    private String vhsyudisptkhtnpbuicd43;

    private String vhsyudisptkhtnpbuinm43;

    private C_Htnpkkn vhsyudisptkhtnpkkn43;

    private C_TokkoudosghtnpKbn vhsyudisptktkkdsghtpkbn3;

    private BizCurrency vhsyudisptktutakngk3;

    private BizDate vhsyudisptkkrkhasseiymd3;

    private String vhsyudisptksyouhnnm4;

    private C_Tuukasyu vhsyudisptkktuukasyu4;

    private C_KataKbn vhsyudisptokyakukatakbn4;

    private C_KyhgndkataKbn vhsyudisptkkyhgdkatakbn4;

    private Integer vhsyudisptkhhknnen4;

    private BizDate vhsyudisptkkykymd4;

    private BizDate vhsyudisptksknnkaisiymd4;

    private BizDate vhsyudisptkgaskkaisiymd4;

    private BizDate vhsyudisptkhkskkaisiymd4;

    private BizDate vhsyudisptkhkgskksiymd4;

    private Integer vhsyudisptkhknkkn4;

    private C_HknkknsmnKbn vhsyudisptkhknkknsmnkbn4;

    private Integer vhsyudisptkhrkkkn4;

    private C_HrkkknsmnKbn vhsyudisptkhrkkknsmnkbn4;

    private C_KihonssyuruiKbn vhsyudisptkkihsyuruikbn4;

    private BizCurrency vhsyudisptkkihons4;

    private BizCurrency vhsyudisptkp4;

    private BizCurrency vhsyudisptkkihonkyhgk4;

    private BizCurrency vhsyudisptknextkosgop4;

    private C_SyukyhkinkataKbn vhsyudisptksykyhkatakbn4;

    private C_6daiLdKbn vhsyudisptk6daildkbn4;

    private BizCurrency vhsyudisptkganyukyhntgk4;

    private BizDate vhsyudisptkshrskgstrymd4;

    private BizDate vhsyudisptkshrskgnedymd4;

    private BizCurrency vhsyudisptkshrskgngos4;

    private C_Nenkinsyu vhsyudisptknenkinsyukbn4;

    private Integer vhsyudisptknenkinkkn4;

    private C_Tkjyskgnkkn vhsyudisptktkjyskgnkkn4;

    private BizDate vhsyudisptktkjkhkdsymd14;

    private BizDate vhsyudisptktkjkhkdeymd14;

    private BizCurrency vhsyudisptktkjyskgns14;

    private BizDate vhsyudisptktkjkhkdsymd24;

    private BizDate vhsyudisptktkjkhkdeymd24;

    private BizCurrency vhsyudisptktkjyskgns24;

    private BizDate vhsyudisptktkjkhkdsymd34;

    private BizDate vhsyudisptktkjkhkdeymd34;

    private BizCurrency vhsyudisptktkjyskgns34;

    private BizDate vhsyudisptktkjkhkdsymd44;

    private BizDate vhsyudisptktkjkhkdeymd44;

    private BizCurrency vhsyudisptktkjyskgns44;

    private BizDate vhsyudisptktkjkhkdsymd54;

    private BizDate vhsyudisptktkjkhkdeymd54;

    private BizCurrency vhsyudisptktkjyskgns54;

    private C_Tkjyhyouten vhsyudisptktkjyhyouten4;

    private BizCurrency vhsyudisptktkjyp4;

    private String vhsyudisptkhtnpbuicd14;

    private String vhsyudisptkhtnpbuinm14;

    private C_Htnpkkn vhsyudisptkhtnpkkn14;

    private String vhsyudisptkhtnpbuicd24;

    private String vhsyudisptkhtnpbuinm24;

    private C_Htnpkkn vhsyudisptkhtnpkkn24;

    private String vhsyudisptkhtnpbuicd34;

    private String vhsyudisptkhtnpbuinm34;

    private C_Htnpkkn vhsyudisptkhtnpkkn34;

    private String vhsyudisptkhtnpbuicd44;

    private String vhsyudisptkhtnpbuinm44;

    private C_Htnpkkn vhsyudisptkhtnpkkn44;

    private C_TokkoudosghtnpKbn vhsyudisptktkkdsghtpkbn4;

    private BizCurrency vhsyudisptktutakngk4;

    private BizDate vhsyudisptkkrkhasseiymd4;

    private String vhsyudisptksyouhnnm5;

    private C_Tuukasyu vhsyudisptkktuukasyu5;

    private C_KataKbn vhsyudisptokyakukatakbn5;

    private C_KyhgndkataKbn vhsyudisptkkyhgdkatakbn5;

    private Integer vhsyudisptkhhknnen5;

    private BizDate vhsyudisptkkykymd5;

    private BizDate vhsyudisptksknnkaisiymd5;

    private BizDate vhsyudisptkgaskkaisiymd5;

    private BizDate vhsyudisptkhkskkaisiymd5;

    private BizDate vhsyudisptkhkgskksiymd5;

    private Integer vhsyudisptkhknkkn5;

    private C_HknkknsmnKbn vhsyudisptkhknkknsmnkbn5;

    private Integer vhsyudisptkhrkkkn5;

    private C_HrkkknsmnKbn vhsyudisptkhrkkknsmnkbn5;

    private C_KihonssyuruiKbn vhsyudisptkkihsyuruikbn5;

    private BizCurrency vhsyudisptkkihons5;

    private BizCurrency vhsyudisptkp5;

    private BizCurrency vhsyudisptkkihonkyhgk5;

    private BizCurrency vhsyudisptknextkosgop5;

    private C_SyukyhkinkataKbn vhsyudisptksykyhkatakbn5;

    private C_6daiLdKbn vhsyudisptk6daildkbn5;

    private BizCurrency vhsyudisptkganyukyhntgk5;

    private BizDate vhsyudisptkshrskgstrymd5;

    private BizDate vhsyudisptkshrskgnedymd5;

    private BizCurrency vhsyudisptkshrskgngos5;

    private C_Nenkinsyu vhsyudisptknenkinsyukbn5;

    private Integer vhsyudisptknenkinkkn5;

    private C_Tkjyskgnkkn vhsyudisptktkjyskgnkkn5;

    private BizDate vhsyudisptktkjkhkdsymd15;

    private BizDate vhsyudisptktkjkhkdeymd15;

    private BizCurrency vhsyudisptktkjyskgns15;

    private BizDate vhsyudisptktkjkhkdsymd25;

    private BizDate vhsyudisptktkjkhkdeymd25;

    private BizCurrency vhsyudisptktkjyskgns25;

    private BizDate vhsyudisptktkjkhkdsymd35;

    private BizDate vhsyudisptktkjkhkdeymd35;

    private BizCurrency vhsyudisptktkjyskgns35;

    private BizDate vhsyudisptktkjkhkdsymd45;

    private BizDate vhsyudisptktkjkhkdeymd45;

    private BizCurrency vhsyudisptktkjyskgns45;

    private BizDate vhsyudisptktkjkhkdsymd55;

    private BizDate vhsyudisptktkjkhkdeymd55;

    private BizCurrency vhsyudisptktkjyskgns55;

    private C_Tkjyhyouten vhsyudisptktkjyhyouten5;

    private BizCurrency vhsyudisptktkjyp5;

    private String vhsyudisptkhtnpbuicd15;

    private String vhsyudisptkhtnpbuinm15;

    private C_Htnpkkn vhsyudisptkhtnpkkn15;

    private String vhsyudisptkhtnpbuicd25;

    private String vhsyudisptkhtnpbuinm25;

    private C_Htnpkkn vhsyudisptkhtnpkkn25;

    private String vhsyudisptkhtnpbuicd35;

    private String vhsyudisptkhtnpbuinm35;

    private C_Htnpkkn vhsyudisptkhtnpkkn35;

    private String vhsyudisptkhtnpbuicd45;

    private String vhsyudisptkhtnpbuinm45;

    private C_Htnpkkn vhsyudisptkhtnpkkn45;

    private C_TokkoudosghtnpKbn vhsyudisptktkkdsghtpkbn5;

    private BizCurrency vhsyudisptktutakngk5;

    private BizDate vhsyudisptkkrkhasseiymd5;

    private String vhsyudisptksyouhnnm6;

    private C_Tuukasyu vhsyudisptkktuukasyu6;

    private C_KataKbn vhsyudisptokyakukatakbn6;

    private C_KyhgndkataKbn vhsyudisptkkyhgdkatakbn6;

    private Integer vhsyudisptkhhknnen6;

    private BizDate vhsyudisptkkykymd6;

    private BizDate vhsyudisptksknnkaisiymd6;

    private BizDate vhsyudisptkgaskkaisiymd6;

    private BizDate vhsyudisptkhkskkaisiymd6;

    private BizDate vhsyudisptkhkgskksiymd6;

    private Integer vhsyudisptkhknkkn6;

    private C_HknkknsmnKbn vhsyudisptkhknkknsmnkbn6;

    private Integer vhsyudisptkhrkkkn6;

    private C_HrkkknsmnKbn vhsyudisptkhrkkknsmnkbn6;

    private C_KihonssyuruiKbn vhsyudisptkkihsyuruikbn6;

    private BizCurrency vhsyudisptkkihons6;

    private BizCurrency vhsyudisptkp6;

    private BizCurrency vhsyudisptkkihonkyhgk6;

    private BizCurrency vhsyudisptknextkosgop6;

    private C_SyukyhkinkataKbn vhsyudisptksykyhkatakbn6;

    private C_6daiLdKbn vhsyudisptk6daildkbn6;

    private BizCurrency vhsyudisptkganyukyhntgk6;

    private BizDate vhsyudisptkshrskgstrymd6;

    private BizDate vhsyudisptkshrskgnedymd6;

    private BizCurrency vhsyudisptkshrskgngos6;

    private C_Nenkinsyu vhsyudisptknenkinsyukbn6;

    private Integer vhsyudisptknenkinkkn6;

    private C_Tkjyskgnkkn vhsyudisptktkjyskgnkkn6;

    private BizDate vhsyudisptktkjkhkdsymd16;

    private BizDate vhsyudisptktkjkhkdeymd16;

    private BizCurrency vhsyudisptktkjyskgns16;

    private BizDate vhsyudisptktkjkhkdsymd26;

    private BizDate vhsyudisptktkjkhkdeymd26;

    private BizCurrency vhsyudisptktkjyskgns26;

    private BizDate vhsyudisptktkjkhkdsymd36;

    private BizDate vhsyudisptktkjkhkdeymd36;

    private BizCurrency vhsyudisptktkjyskgns36;

    private BizDate vhsyudisptktkjkhkdsymd46;

    private BizDate vhsyudisptktkjkhkdeymd46;

    private BizCurrency vhsyudisptktkjyskgns46;

    private BizDate vhsyudisptktkjkhkdsymd56;

    private BizDate vhsyudisptktkjkhkdeymd56;

    private BizCurrency vhsyudisptktkjyskgns56;

    private C_Tkjyhyouten vhsyudisptktkjyhyouten6;

    private BizCurrency vhsyudisptktkjyp6;

    private String vhsyudisptkhtnpbuicd16;

    private String vhsyudisptkhtnpbuinm16;

    private C_Htnpkkn vhsyudisptkhtnpkkn16;

    private String vhsyudisptkhtnpbuicd26;

    private String vhsyudisptkhtnpbuinm26;

    private C_Htnpkkn vhsyudisptkhtnpkkn26;

    private String vhsyudisptkhtnpbuicd36;

    private String vhsyudisptkhtnpbuinm36;

    private C_Htnpkkn vhsyudisptkhtnpkkn36;

    private String vhsyudisptkhtnpbuicd46;

    private String vhsyudisptkhtnpbuinm46;

    private C_Htnpkkn vhsyudisptkhtnpkkn46;

    private C_TokkoudosghtnpKbn vhsyudisptktkkdsghtpkbn6;

    private BizCurrency vhsyudisptktutakngk6;

    private BizDate vhsyudisptkkrkhasseiymd6;

    private String vhsyudisptksyouhnnm7;

    private C_Tuukasyu vhsyudisptkktuukasyu7;

    private C_KataKbn vhsyudisptokyakukatakbn7;

    private C_KyhgndkataKbn vhsyudisptkkyhgdkatakbn7;

    private Integer vhsyudisptkhhknnen7;

    private BizDate vhsyudisptkkykymd7;

    private BizDate vhsyudisptksknnkaisiymd7;

    private BizDate vhsyudisptkgaskkaisiymd7;

    private BizDate vhsyudisptkhkskkaisiymd7;

    private BizDate vhsyudisptkhkgskksiymd7;

    private Integer vhsyudisptkhknkkn7;

    private C_HknkknsmnKbn vhsyudisptkhknkknsmnkbn7;

    private Integer vhsyudisptkhrkkkn7;

    private C_HrkkknsmnKbn vhsyudisptkhrkkknsmnkbn7;

    private C_KihonssyuruiKbn vhsyudisptkkihsyuruikbn7;

    private BizCurrency vhsyudisptkkihons7;

    private BizCurrency vhsyudisptkp7;

    private BizCurrency vhsyudisptkkihonkyhgk7;

    private BizCurrency vhsyudisptknextkosgop7;

    private C_SyukyhkinkataKbn vhsyudisptksykyhkatakbn7;

    private C_6daiLdKbn vhsyudisptk6daildkbn7;

    private BizCurrency vhsyudisptkganyukyhntgk7;

    private BizDate vhsyudisptkshrskgstrymd7;

    private BizDate vhsyudisptkshrskgnedymd7;

    private BizCurrency vhsyudisptkshrskgngos7;

    private C_Nenkinsyu vhsyudisptknenkinsyukbn7;

    private Integer vhsyudisptknenkinkkn7;

    private C_Tkjyskgnkkn vhsyudisptktkjyskgnkkn7;

    private BizDate vhsyudisptktkjkhkdsymd17;

    private BizDate vhsyudisptktkjkhkdeymd17;

    private BizCurrency vhsyudisptktkjyskgns17;

    private BizDate vhsyudisptktkjkhkdsymd27;

    private BizDate vhsyudisptktkjkhkdeymd27;

    private BizCurrency vhsyudisptktkjyskgns27;

    private BizDate vhsyudisptktkjkhkdsymd37;

    private BizDate vhsyudisptktkjkhkdeymd37;

    private BizCurrency vhsyudisptktkjyskgns37;

    private BizDate vhsyudisptktkjkhkdsymd47;

    private BizDate vhsyudisptktkjkhkdeymd47;

    private BizCurrency vhsyudisptktkjyskgns47;

    private BizDate vhsyudisptktkjkhkdsymd57;

    private BizDate vhsyudisptktkjkhkdeymd57;

    private BizCurrency vhsyudisptktkjyskgns57;

    private C_Tkjyhyouten vhsyudisptktkjyhyouten7;

    private BizCurrency vhsyudisptktkjyp7;

    private String vhsyudisptkhtnpbuicd17;

    private String vhsyudisptkhtnpbuinm17;

    private C_Htnpkkn vhsyudisptkhtnpkkn17;

    private String vhsyudisptkhtnpbuicd27;

    private String vhsyudisptkhtnpbuinm27;

    private C_Htnpkkn vhsyudisptkhtnpkkn27;

    private String vhsyudisptkhtnpbuicd37;

    private String vhsyudisptkhtnpbuinm37;

    private C_Htnpkkn vhsyudisptkhtnpkkn37;

    private String vhsyudisptkhtnpbuicd47;

    private String vhsyudisptkhtnpbuinm47;

    private C_Htnpkkn vhsyudisptkhtnpkkn47;

    private C_TokkoudosghtnpKbn vhsyudisptktkkdsghtpkbn7;

    private BizCurrency vhsyudisptktutakngk7;

    private BizDate vhsyudisptkkrkhasseiymd7;

    private String vhsyudisptksyouhnnm8;

    private C_Tuukasyu vhsyudisptkktuukasyu8;

    private C_KataKbn vhsyudisptokyakukatakbn8;

    private C_KyhgndkataKbn vhsyudisptkkyhgdkatakbn8;

    private Integer vhsyudisptkhhknnen8;

    private BizDate vhsyudisptkkykymd8;

    private BizDate vhsyudisptksknnkaisiymd8;

    private BizDate vhsyudisptkgaskkaisiymd8;

    private BizDate vhsyudisptkhkskkaisiymd8;

    private BizDate vhsyudisptkhkgskksiymd8;

    private Integer vhsyudisptkhknkkn8;

    private C_HknkknsmnKbn vhsyudisptkhknkknsmnkbn8;

    private Integer vhsyudisptkhrkkkn8;

    private C_HrkkknsmnKbn vhsyudisptkhrkkknsmnkbn8;

    private C_KihonssyuruiKbn vhsyudisptkkihsyuruikbn8;

    private BizCurrency vhsyudisptkkihons8;

    private BizCurrency vhsyudisptkp8;

    private BizCurrency vhsyudisptkkihonkyhgk8;

    private BizCurrency vhsyudisptknextkosgop8;

    private C_SyukyhkinkataKbn vhsyudisptksykyhkatakbn8;

    private C_6daiLdKbn vhsyudisptk6daildkbn8;

    private BizCurrency vhsyudisptkganyukyhntgk8;

    private BizDate vhsyudisptkshrskgstrymd8;

    private BizDate vhsyudisptkshrskgnedymd8;

    private BizCurrency vhsyudisptkshrskgngos8;

    private C_Nenkinsyu vhsyudisptknenkinsyukbn8;

    private Integer vhsyudisptknenkinkkn8;

    private C_Tkjyskgnkkn vhsyudisptktkjyskgnkkn8;

    private BizDate vhsyudisptktkjkhkdsymd18;

    private BizDate vhsyudisptktkjkhkdeymd18;

    private BizCurrency vhsyudisptktkjyskgns18;

    private BizDate vhsyudisptktkjkhkdsymd28;

    private BizDate vhsyudisptktkjkhkdeymd28;

    private BizCurrency vhsyudisptktkjyskgns28;

    private BizDate vhsyudisptktkjkhkdsymd38;

    private BizDate vhsyudisptktkjkhkdeymd38;

    private BizCurrency vhsyudisptktkjyskgns38;

    private BizDate vhsyudisptktkjkhkdsymd48;

    private BizDate vhsyudisptktkjkhkdeymd48;

    private BizCurrency vhsyudisptktkjyskgns48;

    private BizDate vhsyudisptktkjkhkdsymd58;

    private BizDate vhsyudisptktkjkhkdeymd58;

    private BizCurrency vhsyudisptktkjyskgns58;

    private C_Tkjyhyouten vhsyudisptktkjyhyouten8;

    private BizCurrency vhsyudisptktkjyp8;

    private String vhsyudisptkhtnpbuicd18;

    private String vhsyudisptkhtnpbuinm18;

    private C_Htnpkkn vhsyudisptkhtnpkkn18;

    private String vhsyudisptkhtnpbuicd28;

    private String vhsyudisptkhtnpbuinm28;

    private C_Htnpkkn vhsyudisptkhtnpkkn28;

    private String vhsyudisptkhtnpbuicd38;

    private String vhsyudisptkhtnpbuinm38;

    private C_Htnpkkn vhsyudisptkhtnpkkn38;

    private String vhsyudisptkhtnpbuicd48;

    private String vhsyudisptkhtnpbuinm48;

    private C_Htnpkkn vhsyudisptkhtnpkkn48;

    private C_TokkoudosghtnpKbn vhsyudisptktkkdsghtpkbn8;

    private BizCurrency vhsyudisptktutakngk8;

    private BizDate vhsyudisptkkrkhasseiymd8;

    private String vhsyudisptksyouhnnm9;

    private C_Tuukasyu vhsyudisptkktuukasyu9;

    private C_KataKbn vhsyudisptokyakukatakbn9;

    private C_KyhgndkataKbn vhsyudisptkkyhgdkatakbn9;

    private Integer vhsyudisptkhhknnen9;

    private BizDate vhsyudisptkkykymd9;

    private BizDate vhsyudisptksknnkaisiymd9;

    private BizDate vhsyudisptkgaskkaisiymd9;

    private BizDate vhsyudisptkhkskkaisiymd9;

    private BizDate vhsyudisptkhkgskksiymd9;

    private Integer vhsyudisptkhknkkn9;

    private C_HknkknsmnKbn vhsyudisptkhknkknsmnkbn9;

    private Integer vhsyudisptkhrkkkn9;

    private C_HrkkknsmnKbn vhsyudisptkhrkkknsmnkbn9;

    private C_KihonssyuruiKbn vhsyudisptkkihsyuruikbn9;

    private BizCurrency vhsyudisptkkihons9;

    private BizCurrency vhsyudisptkp9;

    private BizCurrency vhsyudisptkkihonkyhgk9;

    private BizCurrency vhsyudisptknextkosgop9;

    private C_SyukyhkinkataKbn vhsyudisptksykyhkatakbn9;

    private C_6daiLdKbn vhsyudisptk6daildkbn9;

    private BizCurrency vhsyudisptkganyukyhntgk9;

    private BizDate vhsyudisptkshrskgstrymd9;

    private BizDate vhsyudisptkshrskgnedymd9;

    private BizCurrency vhsyudisptkshrskgngos9;

    private C_Nenkinsyu vhsyudisptknenkinsyukbn9;

    private Integer vhsyudisptknenkinkkn9;

    private C_Tkjyskgnkkn vhsyudisptktkjyskgnkkn9;

    private BizDate vhsyudisptktkjkhkdsymd19;

    private BizDate vhsyudisptktkjkhkdeymd19;

    private BizCurrency vhsyudisptktkjyskgns19;

    private BizDate vhsyudisptktkjkhkdsymd29;

    private BizDate vhsyudisptktkjkhkdeymd29;

    private BizCurrency vhsyudisptktkjyskgns29;

    private BizDate vhsyudisptktkjkhkdsymd39;

    private BizDate vhsyudisptktkjkhkdeymd39;

    private BizCurrency vhsyudisptktkjyskgns39;

    private BizDate vhsyudisptktkjkhkdsymd49;

    private BizDate vhsyudisptktkjkhkdeymd49;

    private BizCurrency vhsyudisptktkjyskgns49;

    private BizDate vhsyudisptktkjkhkdsymd59;

    private BizDate vhsyudisptktkjkhkdeymd59;

    private BizCurrency vhsyudisptktkjyskgns59;

    private C_Tkjyhyouten vhsyudisptktkjyhyouten9;

    private BizCurrency vhsyudisptktkjyp9;

    private String vhsyudisptkhtnpbuicd19;

    private String vhsyudisptkhtnpbuinm19;

    private C_Htnpkkn vhsyudisptkhtnpkkn19;

    private String vhsyudisptkhtnpbuicd29;

    private String vhsyudisptkhtnpbuinm29;

    private C_Htnpkkn vhsyudisptkhtnpkkn29;

    private String vhsyudisptkhtnpbuicd39;

    private String vhsyudisptkhtnpbuinm39;

    private C_Htnpkkn vhsyudisptkhtnpkkn39;

    private String vhsyudisptkhtnpbuicd49;

    private String vhsyudisptkhtnpbuinm49;

    private C_Htnpkkn vhsyudisptkhtnpkkn49;

    private C_TokkoudosghtnpKbn vhsyudisptktkkdsghtpkbn9;

    private BizCurrency vhsyudisptktutakngk9;

    private BizDate vhsyudisptkkrkhasseiymd9;

    private String vhsyudisptksyouhnnm10;

    private C_Tuukasyu vhsyudisptkktuukasyu10;

    private C_KataKbn vhsyudisptokyakukatakbn10;

    private C_KyhgndkataKbn vhsyudisptkkyhgdkatakbn10;

    private Integer vhsyudisptkhhknnen10;

    private BizDate vhsyudisptkkykymd10;

    private BizDate vhsyudisptksknnkaisiymd10;

    private BizDate vhsyudisptkgaskkaisiymd10;

    private BizDate vhsyudisptkhkskkaisiymd10;

    private BizDate vhsyudisptkhkgskksiymd10;

    private Integer vhsyudisptkhknkkn10;

    private C_HknkknsmnKbn vhsyudisptkhknkknsmnkbn10;

    private Integer vhsyudisptkhrkkkn10;

    private C_HrkkknsmnKbn vhsyudisptkhrkkknsmnkbn10;

    private C_KihonssyuruiKbn vhsyudisptkkihsyuruikbn10;

    private BizCurrency vhsyudisptkkihons10;

    private BizCurrency vhsyudisptkp10;

    private BizCurrency vhsyudisptkkihonkyhgk10;

    private BizCurrency vhsyudisptknextkosgop10;

    private C_SyukyhkinkataKbn vhsyudisptksykyhkatakbn10;

    private C_6daiLdKbn vhsyudisptk6daildkbn10;

    private BizCurrency vhsyudisptkganyukyhntgk10;

    private BizDate vhsyudisptkshrskgstrymd10;

    private BizDate vhsyudisptkshrskgnedymd10;

    private BizCurrency vhsyudisptkshrskgngos10;

    private C_Nenkinsyu vhsyudisptknenkinsyukbn10;

    private Integer vhsyudisptknenkinkkn10;

    private C_Tkjyskgnkkn vhsyudisptktkjyskgnkkn10;

    private BizDate vhsyudisptktkjkhkdsymd110;

    private BizDate vhsyudisptktkjkhkdeymd110;

    private BizCurrency vhsyudisptktkjyskgns110;

    private BizDate vhsyudisptktkjkhkdsymd210;

    private BizDate vhsyudisptktkjkhkdeymd210;

    private BizCurrency vhsyudisptktkjyskgns210;

    private BizDate vhsyudisptktkjkhkdsymd310;

    private BizDate vhsyudisptktkjkhkdeymd310;

    private BizCurrency vhsyudisptktkjyskgns310;

    private BizDate vhsyudisptktkjkhkdsymd410;

    private BizDate vhsyudisptktkjkhkdeymd410;

    private BizCurrency vhsyudisptktkjyskgns410;

    private BizDate vhsyudisptktkjkhkdsymd510;

    private BizDate vhsyudisptktkjkhkdeymd510;

    private BizCurrency vhsyudisptktkjyskgns510;

    private C_Tkjyhyouten vhsyudisptktkjyhyouten10;

    private BizCurrency vhsyudisptktkjyp10;

    private String vhsyudisptkhtnpbuicd110;

    private String vhsyudisptkhtnpbuinm110;

    private C_Htnpkkn vhsyudisptkhtnpkkn110;

    private String vhsyudisptkhtnpbuicd210;

    private String vhsyudisptkhtnpbuinm210;

    private C_Htnpkkn vhsyudisptkhtnpkkn210;

    private String vhsyudisptkhtnpbuicd310;

    private String vhsyudisptkhtnpbuinm310;

    private C_Htnpkkn vhsyudisptkhtnpkkn310;

    private String vhsyudisptkhtnpbuicd410;

    private String vhsyudisptkhtnpbuinm410;

    private C_Htnpkkn vhsyudisptkhtnpkkn410;

    private C_TokkoudosghtnpKbn vhsyudisptktkkdsghtpkbn10;

    private BizCurrency vhsyudisptktutakngk10;

    private BizDate vhsyudisptkkrkhasseiymd10;

    private C_UmuKbn vhsyusyunkhknumu;

    private C_UmuKbn vhsyusyugannyukyhumu;

    private C_KhnkyhkgbairituKbn vhsyusyukhnkyhkgbairitukbn;

    private C_UmuKbn vhsyusyusndkyhkinshrskgnumu;

    private C_UmuKbn vhsyusyuhghkumu;

    private C_UmuKbn vhsyusyunextkosumu;

    private String vhsyudisptksyouhncd1;

    private String vhsyudisptksyouhncd2;

    private String vhsyudisptksyouhncd3;

    private String vhsyudisptksyouhncd4;

    private String vhsyudisptksyouhncd5;

    private String vhsyudisptksyouhncd6;

    private String vhsyudisptksyouhncd7;

    private String vhsyudisptksyouhncd8;

    private String vhsyudisptksyouhncd9;

    private String vhsyudisptksyouhncd10;

    private C_UmuKbn vhsyudisptknkhknumu1;

    private C_UmuKbn vhsyudisptknkhknumu2;

    private C_UmuKbn vhsyudisptknkhknumu3;

    private C_UmuKbn vhsyudisptknkhknumu4;

    private C_UmuKbn vhsyudisptknkhknumu5;

    private C_UmuKbn vhsyudisptknkhknumu6;

    private C_UmuKbn vhsyudisptknkhknumu7;

    private C_UmuKbn vhsyudisptknkhknumu8;

    private C_UmuKbn vhsyudisptknkhknumu9;

    private C_UmuKbn vhsyudisptknkhknumu10;

    private C_UmuKbn vhsyuddisptkhghkumu1;

    private C_UmuKbn vhsyuddisptkhghkumu2;

    private C_UmuKbn vhsyuddisptkhghkumu3;

    private C_UmuKbn vhsyuddisptkhghkumu4;

    private C_UmuKbn vhsyuddisptkhghkumu5;

    private C_UmuKbn vhsyuddisptkhghkumu6;

    private C_UmuKbn vhsyuddisptkhghkumu7;

    private C_UmuKbn vhsyuddisptkhghkumu8;

    private C_UmuKbn vhsyuddisptkhghkumu9;

    private C_UmuKbn vhsyuddisptkhghkumu10;

    private C_UmuKbn vhsyuddisptkgannyukyhumu1 ;

    private C_UmuKbn vhsyuddisptkgannyukyhumu2;

    private C_UmuKbn vhsyuddisptkgannyukyhumu3;

    private C_UmuKbn vhsyuddisptkgannyukyhumu4;

    private C_UmuKbn vhsyuddisptkgannyukyhumu5;

    private C_UmuKbn vhsyuddisptkgannyukyhumu6;

    private C_UmuKbn vhsyuddisptkgannyukyhumu7;

    private C_UmuKbn vhsyuddisptkgannyukyhumu8;

    private C_UmuKbn vhsyuddisptkgannyukyhumu9;

    private C_UmuKbn vhsyuddisptkgannyukyhumu10;

    private C_UmuKbn vhsyudisptksndkyhkinshrskgnumu1;

    private C_UmuKbn vhsyudisptksndkyhkinshrskgnumu2;

    private C_UmuKbn vhsyudisptksndkyhkinshrskgnumu3;

    private C_UmuKbn vhsyudisptksndkyhkinshrskgnumu4;

    private C_UmuKbn vhsyudisptksndkyhkinshrskgnumu5;

    private C_UmuKbn vhsyudisptksndkyhkinshrskgnumu6;

    private C_UmuKbn vhsyudisptksndkyhkinshrskgnumu7;

    private C_UmuKbn vhsyudisptksndkyhkinshrskgnumu8;

    private C_UmuKbn vhsyudisptksndkyhkinshrskgnumu9;

    private C_UmuKbn vhsyudisptksndkyhkinshrskgnumu10;

    private C_UmuKbn vhsyudisptknextkosumu1;

    private C_UmuKbn vhsyudisptknextkosumu2;

    private C_UmuKbn vhsyudisptknextkosumu3;

    private C_UmuKbn vhsyudisptknextkosumu4;

    private C_UmuKbn vhsyudisptknextkosumu5;

    private C_UmuKbn vhsyudisptknextkosumu6;

    private C_UmuKbn vhsyudisptknextkosumu7;

    private C_UmuKbn vhsyudisptknextkosumu8;

    private C_UmuKbn vhsyudisptknextkosumu9;

    private C_UmuKbn vhsyudisptknextkosumu10;

    private C_UmuKbn vhsyusyutsnshrgndhjumu;

    private BizCurrency vhsyudispsyutsnshrgndgk;

    private C_UmuKbn vhsyudisptktsnshrgndhjumu1;

    private C_UmuKbn vhsyudisptktsnshrgndhjumu2;

    private C_UmuKbn vhsyudisptktsnshrgndhjumu3;

    private C_UmuKbn vhsyudisptktsnshrgndhjumu4;

    private C_UmuKbn vhsyudisptktsnshrgndhjumu5;

    private C_UmuKbn vhsyudisptktsnshrgndhjumu6;

    private C_UmuKbn vhsyudisptktsnshrgndhjumu7;

    private C_UmuKbn vhsyudisptktsnshrgndhjumu8;

    private C_UmuKbn vhsyudisptktsnshrgndhjumu9;

    private C_UmuKbn vhsyudisptktsnshrgndhjumu10;

    private BizCurrency vhsyudisptktsnshrgndgk1;

    private BizCurrency vhsyudisptktsnshrgndgk2;

    private BizCurrency vhsyudisptktsnshrgndgk3;

    private BizCurrency vhsyudisptktsnshrgndgk4;

    private BizCurrency vhsyudisptktsnshrgndgk5;

    private BizCurrency vhsyudisptktsnshrgndgk6;

    private BizCurrency vhsyudisptktsnshrgndgk7;

    private BizCurrency vhsyudisptktsnshrgndgk8;

    private BizCurrency vhsyudisptktsnshrgndgk9;

    private BizCurrency vhsyudisptktsnshrgndgk10;

    private C_KhnkyhkgbairituKbn vhsyudisptkkgbairitukbn1;

    private C_KhnkyhkgbairituKbn vhsyudisptkkgbairitukbn2;

    private C_KhnkyhkgbairituKbn vhsyudisptkkgbairitukbn3;

    private C_KhnkyhkgbairituKbn vhsyudisptkkgbairitukbn4;

    private C_KhnkyhkgbairituKbn vhsyudisptkkgbairitukbn5;

    private C_KhnkyhkgbairituKbn vhsyudisptkkgbairitukbn6;

    private C_KhnkyhkgbairituKbn vhsyudisptkkgbairitukbn7;

    private C_KhnkyhkgbairituKbn vhsyudisptkkgbairitukbn8;

    private C_KhnkyhkgbairituKbn vhsyudisptkkgbairitukbn9;

    private C_KhnkyhkgbairituKbn vhsyudisptkkgbairitukbn10;

    private  C_UmuKbn vhsyunstkhukaumukbn;

    private C_UmuKbn vhsyuitijibrumu;

    private C_UmuKbn vhsyugenzaikngkhyjfukaumu;

    private C_YendthnkJyoutaiKbn vhsyuyendthnkjyoutaikbn;

    private List<TbktInfoDataSourceBeanCommonParamImpl> tbktInfoDataSourceBeanCommonParamLst;

    @Override
    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        this.syono = pSyono;
    }

    public String getVhsyusyusyouhnnm() {
        return vhsyusyusyouhnnm;
    }

    @Override
    public void setVhsyusyusyouhnnm(String pVhsyusyusyouhnnm) {
        vhsyusyusyouhnnm = pVhsyusyusyouhnnm;
    }


    public C_AisyoumeiKbn getVhsyuaisyoumeikbn() {
        return vhsyuaisyoumeikbn;
    }


    @Override
    public void setVhsyuaisyoumeikbn(C_AisyoumeiKbn pVhsyuaisyoumeikbn) {
        vhsyuaisyoumeikbn = pVhsyuaisyoumeikbn;
    }

    public C_Tuukasyu getVhsyusyukyktuukasyu() {
        return vhsyusyukyktuukasyu;
    }

    @Override
    public void setVhsyusyukyktuukasyu(C_Tuukasyu pVhsyusyukyktuukasyu) {
        vhsyusyukyktuukasyu = pVhsyusyukyktuukasyu;
    }

    public C_Tuukasyu getVhsyusyukykjisiteituukasyu() {
        return vhsyusyukykjisiteituukasyu;
    }

    @Override
    public void setVhsyusyukykjisiteituukasyu(C_Tuukasyu pVhsyusyukykjisiteituukasyu) {
        vhsyusyukykjisiteituukasyu = pVhsyusyukykjisiteituukasyu;
    }

    public C_KataKbn getVhsyusyukatakbn() {
        return vhsyusyukatakbn;
    }

    @Override
    public void setVhsyusyukatakbn(C_KataKbn pVhsyusyukatakbn) {
        vhsyusyukatakbn = pVhsyusyukatakbn;
    }

    public C_KyhgndkataKbn getVhsyusyukyhgndkatakbn() {
        return vhsyusyukyhgndkatakbn;
    }

    @Override
    public void setVhsyusyukyhgndkatakbn(C_KyhgndkataKbn pVhsyusyukyhgndkatakbn) {
        vhsyusyukyhgndkatakbn = pVhsyusyukyhgndkatakbn;
    }

    public Integer getVhsyusyuhhknnen() {
        return vhsyusyuhhknnen;
    }

    @Override
    public void setVhsyusyuhhknnen(Integer pVhsyusyuhhknnen) {
        vhsyusyuhhknnen = pVhsyusyuhhknnen;
    }

    public BizDate getVhsyusyukykymd() {
        return vhsyusyukykymd;
    }

    @Override
    public void setVhsyusyukykymd(BizDate pVhsyusyukykymd) {
        vhsyusyukykymd = pVhsyusyukykymd;
    }

    public BizDate getVhsyusyusknnkaisiymd() {
        return vhsyusyusknnkaisiymd;
    }

    @Override
    public void setVhsyusyusknnkaisiymd(BizDate pVhsyusyusknnkaisiymd) {
        vhsyusyusknnkaisiymd = pVhsyusyusknnkaisiymd;
    }

    public BizDate getVhsyugansknnkaisiymd() {
        return vhsyugansknnkaisiymd;
    }

    @Override
    public void setVhsyugansknnkaisiymd(BizDate pVhsyugansknnkaisiymd) {
        vhsyugansknnkaisiymd = pVhsyugansknnkaisiymd;
    }

    public BizDate getVhsyusyufktsknnkaisiymd() {
        return vhsyusyufktsknnkaisiymd;
    }

    @Override
    public void setVhsyusyufktsknnkaisiymd(BizDate pVhsyusyufktsknnkaisiymd) {
        vhsyusyufktsknnkaisiymd = pVhsyusyufktsknnkaisiymd;
    }

    public BizDate getVhsyuhkgogansknnkaisiymd() {
        return vhsyuhkgogansknnkaisiymd;
    }

    @Override
    public void setVhsyuhkgogansknnkaisiymd(BizDate pVhsyuhkgogansknnkaisiymd) {
        vhsyuhkgogansknnkaisiymd = pVhsyuhkgogansknnkaisiymd;
    }

    public Integer getVhsyusyuhknkkn() {
        return vhsyusyuhknkkn;
    }

    @Override
    public void setVhsyusyuhknkkn(Integer pVhsyusyuhknkkn) {
        vhsyusyuhknkkn = pVhsyusyuhknkkn;
    }

    public C_HknkknsmnKbn getVhsyusyuhknkknsmnkbn() {
        return vhsyusyuhknkknsmnkbn;
    }

    @Override
    public void setVhsyusyuhknkknsmnkbn(C_HknkknsmnKbn pVhsyusyuhknkknsmnkbn) {
        vhsyusyuhknkknsmnkbn = pVhsyusyuhknkknsmnkbn;
    }

    public Integer getVhsyudai1hknkkn() {
        return vhsyudai1hknkkn;
    }

    @Override
    public void setVhsyudai1hknkkn(Integer pVhsyudai1hknkkn) {
        vhsyudai1hknkkn = pVhsyudai1hknkkn;
    }

    public C_Sdpd getVhsyusdpdkbn() {
        return vhsyusdpdkbn;
    }

    @Override
    public void setVhsyusdpdkbn(C_Sdpd pVhsyusdpdkbn) {
        vhsyusdpdkbn = pVhsyusdpdkbn;
    }

    public Integer getVhsyusyuhrkkkn() {
        return vhsyusyuhrkkkn;
    }

    @Override
    public void setVhsyusyuhrkkkn(Integer pVhsyusyuhrkkkn) {
        vhsyusyuhrkkkn = pVhsyusyuhrkkkn;
    }

    public C_HrkkknsmnKbn getVhsyusyuhrkkknsmnkbn() {
        return vhsyusyuhrkkknsmnkbn;
    }

    @Override
    public void setVhsyusyuhrkkknsmnkbn(C_HrkkknsmnKbn pVhsyusyuhrkkknsmnkbn) {
        vhsyusyuhrkkknsmnkbn = pVhsyusyuhrkkknsmnkbn;
    }

    public C_KihonssyuruiKbn getVhsyusyukihonssyuruikbn() {
        return vhsyusyukihonssyuruikbn;
    }

    @Override
    public void setVhsyusyukihonssyuruikbn(C_KihonssyuruiKbn pVhsyusyukihonssyuruikbn) {
        vhsyusyukihonssyuruikbn = pVhsyusyukihonssyuruikbn;
    }

    public BizCurrency getVhsyusyukihons() {
        return vhsyusyukihons;
    }

    @Override
    public void setVhsyusyukihons(BizCurrency pVhsyusyukihons) {
        vhsyusyukihons = pVhsyusyukihons;
    }

    public BizCurrency getVhsyusyukykkjnkngk() {
        return vhsyusyukykkjnkngk;
    }

    @Override
    public void setVhsyusyukykkjnkngk(BizCurrency pVhsyusyukykkjnkngk) {
        vhsyusyukykkjnkngk = pVhsyusyukykkjnkngk;
    }

    public BizCurrency getVhsyugenzaisbhknkngaku() {
        return vhsyugenzaisbhknkngaku;
    }

    @Override
    public void setVhsyugenzaisbhknkngaku(BizCurrency pVhsyugenzaisbhknkngaku) {
        vhsyugenzaisbhknkngaku = pVhsyugenzaisbhknkngaku;
    }

    public BizCurrency getVhsyusaigaisbhknkngaku() {
        return vhsyusaigaisbhknkngaku;
    }

    @Override
    public void setVhsyusaigaisbhknkngaku(BizCurrency pVhsyusaigaisbhknkngaku) {
        vhsyusaigaisbhknkngaku = pVhsyusaigaisbhknkngaku;
    }

    public BizCurrency getVhsyusyukihonkyhgk() {
        return vhsyusyukihonkyhgk;
    }

    @Override
    public void setVhsyusyukihonkyhgk(BizCurrency pVhsyusyukihonkyhgk) {
        vhsyusyukihonkyhgk = pVhsyusyukihonkyhgk;
    }

    public BizCurrency getVhsyusyup() {
        return vhsyusyup;
    }

    @Override
    public void setVhsyusyup(BizCurrency pVhsyusyup) {
        vhsyusyup = pVhsyusyup;
    }

    public BizCurrency getVhsyusyunextkosgop() {
        return vhsyusyunextkosgop;
    }

    @Override
    public void setVhsyusyunextkosgop(BizCurrency pVhsyusyunextkosgop) {
        vhsyusyunextkosgop = pVhsyusyunextkosgop;
    }

    public C_SyukyhkinkataKbn getVhsyusyusyukyhkinkatakbn() {
        return vhsyusyusyukyhkinkatakbn;
    }

    @Override
    public void setVhsyusyusyukyhkinkatakbn(C_SyukyhkinkataKbn pVhsyusyusyukyhkinkatakbn) {
        vhsyusyusyukyhkinkatakbn = pVhsyusyusyukyhkinkatakbn;
    }

    public C_6daiLdKbn getVhsyusyurokudaildkbn() {
        return vhsyusyurokudaildkbn;
    }

    @Override
    public void setVhsyusyurokudaildkbn(C_6daiLdKbn pVhsyusyurokudaildkbn) {
        vhsyusyurokudaildkbn = pVhsyusyurokudaildkbn;
    }

    public BizCurrency getVhsyusyugannyukyhntgk() {
        return vhsyusyugannyukyhntgk;
    }

    @Override
    public void setVhsyusyugannyukyhntgk(BizCurrency pVhsyusyugannyukyhntgk) {
        vhsyusyugannyukyhntgk = pVhsyusyugannyukyhntgk;
    }

    public BizDate getVhsyusyushrskgnstartymd() {
        return vhsyusyushrskgnstartymd;
    }

    @Override
    public void setVhsyusyushrskgnstartymd(BizDate pVhsyusyushrskgnstartymd) {
        vhsyusyushrskgnstartymd = pVhsyusyushrskgnstartymd;
    }

    public BizDate getVhsyusyushrskgnendymd() {
        return vhsyusyushrskgnendymd;
    }

    @Override
    public void setVhsyusyushrskgnendymd(BizDate pVhsyusyushrskgnendymd) {
        vhsyusyushrskgnendymd = pVhsyusyushrskgnendymd;
    }

    public BizCurrency getVhsyusyushrskgngos() {
        return vhsyusyushrskgngos;
    }

    @Override
    public void setVhsyusyushrskgngos(BizCurrency pVhsyusyushrskgngos) {
        vhsyusyushrskgngos = pVhsyusyushrskgngos;
    }

    public C_Nenkinsyu getVhsyusyunnkinsyukbn() {
        return vhsyusyunnkinsyukbn;
    }

    @Override
    public void setVhsyusyunnkinsyukbn(C_Nenkinsyu pVhsyusyunnkinsyukbn) {
        vhsyusyunnkinsyukbn = pVhsyusyunnkinsyukbn;
    }

    public Integer getVhsyusyunenkinkkn() {
        return vhsyusyunenkinkkn;
    }

    @Override
    public void setVhsyusyunenkinkkn(Integer pVhsyusyunenkinkkn) {
        vhsyusyunenkinkkn = pVhsyusyunenkinkkn;
    }

    public C_Tkjyskgnkkn getVhsyusyutkjyskgnkkn() {
        return vhsyusyutkjyskgnkkn;
    }

    @Override
    public void setVhsyusyutkjyskgnkkn(C_Tkjyskgnkkn pVhsyusyutkjyskgnkkn) {
        vhsyusyutkjyskgnkkn = pVhsyusyutkjyskgnkkn;
    }

    public BizDate getVhsyusyutkjyskgnhkndsymd1() {
        return vhsyusyutkjyskgnhkndsymd1;
    }

    @Override
    public void setVhsyusyutkjyskgnhkndsymd1(BizDate pVhsyusyutkjyskgnhkndsymd1) {
        vhsyusyutkjyskgnhkndsymd1 = pVhsyusyutkjyskgnhkndsymd1;
    }

    public BizDate getVhsyusyutkjyskgnhkndeymd1() {
        return vhsyusyutkjyskgnhkndeymd1;
    }

    @Override
    public void setVhsyusyutkjyskgnhkndeymd1(BizDate pVhsyusyutkjyskgnhkndeymd1) {
        vhsyusyutkjyskgnhkndeymd1 = pVhsyusyutkjyskgnhkndeymd1;
    }

    public BizCurrency getVhsyusyutkjyskgns1() {
        return vhsyusyutkjyskgns1;
    }

    @Override
    public void setVhsyusyutkjyskgns1(BizCurrency pVhsyusyutkjyskgns1) {
        vhsyusyutkjyskgns1 = pVhsyusyutkjyskgns1;
    }

    public BizDate getVhsyusyutkjyskgnhkndsymd2() {
        return vhsyusyutkjyskgnhkndsymd2;
    }

    @Override
    public void setVhsyusyutkjyskgnhkndsymd2(BizDate pVhsyusyutkjyskgnhkndsymd2) {
        vhsyusyutkjyskgnhkndsymd2 = pVhsyusyutkjyskgnhkndsymd2;
    }

    public BizDate getVhsyusyutkjyskgnhkndeymd2() {
        return vhsyusyutkjyskgnhkndeymd2;
    }

    @Override
    public void setVhsyusyutkjyskgnhkndeymd2(BizDate pVhsyusyutkjyskgnhkndeymd2) {
        vhsyusyutkjyskgnhkndeymd2 = pVhsyusyutkjyskgnhkndeymd2;
    }

    public BizCurrency getVhsyusyutkjyskgns2() {
        return vhsyusyutkjyskgns2;
    }

    @Override
    public void setVhsyusyutkjyskgns2(BizCurrency pVhsyusyutkjyskgns2) {
        vhsyusyutkjyskgns2 = pVhsyusyutkjyskgns2;
    }

    public BizDate getVhsyusyutkjyskgnhkndsymd3() {
        return vhsyusyutkjyskgnhkndsymd3;
    }

    @Override
    public void setVhsyusyutkjyskgnhkndsymd3(BizDate pVhsyusyutkjyskgnhkndsymd3) {
        vhsyusyutkjyskgnhkndsymd3 = pVhsyusyutkjyskgnhkndsymd3;
    }

    public BizDate getVhsyusyutkjyskgnhkndeymd3() {
        return vhsyusyutkjyskgnhkndeymd3;
    }

    @Override
    public void setVhsyusyutkjyskgnhkndeymd3(BizDate pVhsyusyutkjyskgnhkndeymd3) {
        vhsyusyutkjyskgnhkndeymd3 = pVhsyusyutkjyskgnhkndeymd3;
    }

    public BizCurrency getVhsyusyutkjyskgns3() {
        return vhsyusyutkjyskgns3;
    }

    @Override
    public void setVhsyusyutkjyskgns3(BizCurrency pVhsyusyutkjyskgns3) {
        vhsyusyutkjyskgns3 = pVhsyusyutkjyskgns3;
    }

    public BizDate getVhsyusyutkjyskgnhkndsymd4() {
        return vhsyusyutkjyskgnhkndsymd4;
    }

    @Override
    public void setVhsyusyutkjyskgnhkndsymd4(BizDate pVhsyusyutkjyskgnhkndsymd4) {
        vhsyusyutkjyskgnhkndsymd4 = pVhsyusyutkjyskgnhkndsymd4;
    }

    public BizDate getVhsyusyutkjyskgnhkndeymd4() {
        return vhsyusyutkjyskgnhkndeymd4;
    }

    @Override
    public void setVhsyusyutkjyskgnhkndeymd4(BizDate pVhsyusyutkjyskgnhkndeymd4) {
        vhsyusyutkjyskgnhkndeymd4 = pVhsyusyutkjyskgnhkndeymd4;
    }

    public BizCurrency getVhsyusyutkjyskgns4() {
        return vhsyusyutkjyskgns4;
    }

    @Override
    public void setVhsyusyutkjyskgns4(BizCurrency pVhsyusyutkjyskgns4) {
        vhsyusyutkjyskgns4 = pVhsyusyutkjyskgns4;
    }

    public BizDate getVhsyusyutkjyskgnhkndsymd5() {
        return vhsyusyutkjyskgnhkndsymd5;
    }

    @Override
    public void setVhsyusyutkjyskgnhkndsymd5(BizDate pVhsyusyutkjyskgnhkndsymd5) {
        vhsyusyutkjyskgnhkndsymd5 = pVhsyusyutkjyskgnhkndsymd5;
    }

    public BizDate getVhsyusyutkjyskgnhkndeymd5() {
        return vhsyusyutkjyskgnhkndeymd5;
    }

    @Override
    public void setVhsyusyutkjyskgnhkndeymd5(BizDate pVhsyusyutkjyskgnhkndeymd5) {
        vhsyusyutkjyskgnhkndeymd5 = pVhsyusyutkjyskgnhkndeymd5;
    }

    public BizCurrency getVhsyusyutkjyskgns5() {
        return vhsyusyutkjyskgns5;
    }

    @Override
    public void setVhsyusyutkjyskgns5(BizCurrency pVhsyusyutkjyskgns5) {
        vhsyusyutkjyskgns5 = pVhsyusyutkjyskgns5;
    }

    public C_Tkjyhyouten getVhsyusyutkjyhyouten() {
        return vhsyusyutkjyhyouten;
    }

    @Override
    public void setVhsyusyutkjyhyouten(C_Tkjyhyouten pVhsyusyutkjyhyouten) {
        vhsyusyutkjyhyouten = pVhsyusyutkjyhyouten;
    }

    public BizCurrency getVhsyusyutkjyp() {
        return vhsyusyutkjyp;
    }

    @Override
    public void setVhsyusyutkjyp(BizCurrency pVhsyusyutkjyp) {
        vhsyusyutkjyp = pVhsyusyutkjyp;
    }

    public String getVhsyusyuhtnpbuicd1() {
        return vhsyusyuhtnpbuicd1;
    }

    @Override
    public void setVhsyusyuhtnpbuicd1(String pVhsyusyuhtnpbuicd1) {
        vhsyusyuhtnpbuicd1 = pVhsyusyuhtnpbuicd1;
    }

    public String getVhsyusyuhtnpbuinm1() {
        return vhsyusyuhtnpbuinm1;
    }

    @Override
    public void setVhsyusyuhtnpbuinm1(String pVhsyusyuhtnpbuinm1) {
        vhsyusyuhtnpbuinm1 = pVhsyusyuhtnpbuinm1;
    }

    public C_Htnpkkn getVhsyusyuhtnpkkn1() {
        return vhsyusyuhtnpkkn1;
    }

    @Override
    public void setVhsyusyuhtnpkkn1(C_Htnpkkn pVhsyusyuhtnpkkn1) {
        vhsyusyuhtnpkkn1 = pVhsyusyuhtnpkkn1;
    }

    public String getVhsyusyuhtnpbuicd2() {
        return vhsyusyuhtnpbuicd2;
    }

    @Override
    public void setVhsyusyuhtnpbuicd2(String pVhsyusyuhtnpbuicd2) {
        vhsyusyuhtnpbuicd2 = pVhsyusyuhtnpbuicd2;
    }

    public String getVhsyusyuhtnpbuinm2() {
        return vhsyusyuhtnpbuinm2;
    }

    @Override
    public void setVhsyusyuhtnpbuinm2(String pVhsyusyuhtnpbuinm2) {
        vhsyusyuhtnpbuinm2 = pVhsyusyuhtnpbuinm2;
    }

    public C_Htnpkkn getVhsyusyuhtnpkkn2() {
        return vhsyusyuhtnpkkn2;
    }

    @Override
    public void setVhsyusyuhtnpkkn2(C_Htnpkkn pVhsyusyuhtnpkkn2) {
        vhsyusyuhtnpkkn2 = pVhsyusyuhtnpkkn2;
    }

    public String getVhsyusyuhtnpbuicd3() {
        return vhsyusyuhtnpbuicd3;
    }

    @Override
    public void setVhsyusyuhtnpbuicd3(String pVhsyusyuhtnpbuicd3) {
        vhsyusyuhtnpbuicd3 = pVhsyusyuhtnpbuicd3;
    }

    public String getVhsyusyuhtnpbuinm3() {
        return vhsyusyuhtnpbuinm3;
    }

    @Override
    public void setVhsyusyuhtnpbuinm3(String pVhsyusyuhtnpbuinm3) {
        vhsyusyuhtnpbuinm3 = pVhsyusyuhtnpbuinm3;
    }

    public C_Htnpkkn getVhsyusyuhtnpkkn3() {
        return vhsyusyuhtnpkkn3;
    }

    @Override
    public void setVhsyusyuhtnpkkn3(C_Htnpkkn pVhsyusyuhtnpkkn3) {
        vhsyusyuhtnpkkn3 = pVhsyusyuhtnpkkn3;
    }

    public String getVhsyusyuhtnpbuicd4() {
        return vhsyusyuhtnpbuicd4;
    }

    @Override
    public void setVhsyusyuhtnpbuicd4(String pVhsyusyuhtnpbuicd4) {
        vhsyusyuhtnpbuicd4 = pVhsyusyuhtnpbuicd4;
    }

    public String getVhsyusyuhtnpbuinm4() {
        return vhsyusyuhtnpbuinm4;
    }

    @Override
    public void setVhsyusyuhtnpbuinm4(String pVhsyusyuhtnpbuinm4) {
        vhsyusyuhtnpbuinm4 = pVhsyusyuhtnpbuinm4;
    }

    public C_Htnpkkn getVhsyusyuhtnpkkn4() {
        return vhsyusyuhtnpkkn4;
    }

    @Override
    public void setVhsyusyuhtnpkkn4(C_Htnpkkn pVhsyusyuhtnpkkn4) {
        vhsyusyuhtnpkkn4 = pVhsyusyuhtnpkkn4;
    }

    public C_TokkoudosghtnpKbn getVhsyusyutokkdsghtnpkbn() {
        return vhsyusyutokkdsghtnpkbn;
    }

    @Override
    public void setVhsyusyutokkdsghtnpkbn(C_TokkoudosghtnpKbn pVhsyusyutokkdsghtnpkbn) {
        vhsyusyutokkdsghtnpkbn = pVhsyusyutokkdsghtnpkbn;
    }

    public BizCurrency getVhsyusyututakngk() {
        return vhsyusyututakngk;
    }

    @Override
    public void setVhsyusyututakngk(BizCurrency pVhsyusyututakngk) {
        vhsyusyututakngk = pVhsyusyututakngk;
    }

    public BizDate getVhsyusyukouryokuhasseiymd() {
        return vhsyusyukouryokuhasseiymd;
    }

    @Override
    public void setVhsyusyukouryokuhasseiymd(BizDate pVhsyusyukouryokuhasseiymd) {
        vhsyusyukouryokuhasseiymd = pVhsyusyukouryokuhasseiymd;
    }

    public C_UmuKbn getVhsyudai1hknkknsbsyokuseiumu() {
        return vhsyudai1hknkknsbsyokuseiumu;
    }

    @Override
    public void setVhsyudai1hknkknsbsyokuseiumu(C_UmuKbn pVhsyudai1hknkknsbsyokuseiumu) {
        vhsyudai1hknkknsbsyokuseiumu = pVhsyudai1hknkknsbsyokuseiumu;
    }

    public C_UmuKbn getVhsyusgsbhsyumu() {
        return vhsyusgsbhsyumu;
    }

    @Override
    public void setVhsyusgsbhsyumu(C_UmuKbn pVhsyusgsbhsyumu) {
        vhsyusgsbhsyumu = pVhsyusgsbhsyumu;
    }

    public C_HknKknKbn getVhsyuhknKknKbn() {
        return vhsyuhknKknKbn;
    }

    @Override
    public void setVhsyuhknKknKbn(C_HknKknKbn pVhsyuhknKknKbn) {
        vhsyuhknKknKbn = pVhsyuhknKknKbn;
    }

    public String getVhsyudisptksyouhnnm() {
        return vhsyudisptksyouhnnm;
    }

    @Override
    public void setVhsyudisptksyouhnnm(String pVhsyudisptksyouhnnm) {
        vhsyudisptksyouhnnm = pVhsyudisptksyouhnnm;
    }

    public C_Nstknsyu getVhsyunkshrtkyknksyukbn() {
        return vhsyunkshrtkyknksyukbn;
    }

    @Override
    public void setVhsyunkshrtkyknksyukbn(C_Nstknsyu pVhsyunkshrtkyknksyukbn) {
        vhsyunkshrtkyknksyukbn = pVhsyunkshrtkyknksyukbn;
    }

    public Integer getVhsyunkshrtkyknksyukkn() {
        return vhsyunkshrtkyknksyukkn;
    }

    @Override
    public void setVhsyunkshrtkyknksyukkn(Integer pVhsyunkshrtkyknksyukkn) {
        vhsyunkshrtkyknksyukkn = pVhsyunkshrtkyknksyukkn;
    }

    public String getVhsyudisptksyouhnnm1() {
        return vhsyudisptksyouhnnm1;
    }

    @Override
    public void setVhsyudisptksyouhnnm1(String pVhsyudisptksyouhnnm1) {
        vhsyudisptksyouhnnm1 = pVhsyudisptksyouhnnm1;
    }

    public C_Tuukasyu getVhsyudisptkktuukasyu1() {
        return vhsyudisptkktuukasyu1;
    }

    @Override
    public void setVhsyudisptkktuukasyu1(C_Tuukasyu pVhsyudisptkktuukasyu1) {
        vhsyudisptkktuukasyu1 = pVhsyudisptkktuukasyu1;
    }

    public C_KataKbn getVhsyudisptokyakukatakbn1() {
        return vhsyudisptokyakukatakbn1;
    }

    @Override
    public void setVhsyudisptokyakukatakbn1(C_KataKbn pVhsyudisptokyakukatakbn1) {
        vhsyudisptokyakukatakbn1 = pVhsyudisptokyakukatakbn1;
    }

    public C_KyhgndkataKbn getVhsyudisptkkyhgdkatakbn1() {
        return vhsyudisptkkyhgdkatakbn1;
    }

    @Override
    public void setVhsyudisptkkyhgdkatakbn1(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn1) {
        vhsyudisptkkyhgdkatakbn1 = pVhsyudisptkkyhgdkatakbn1;
    }

    public Integer getVhsyudisptkhhknnen1() {
        return vhsyudisptkhhknnen1;
    }

    @Override
    public void setVhsyudisptkhhknnen1(Integer pVhsyudisptkhhknnen1) {
        vhsyudisptkhhknnen1 = pVhsyudisptkhhknnen1;
    }

    public BizDate getVhsyudisptkkykymd1() {
        return vhsyudisptkkykymd1;
    }

    @Override
    public void setVhsyudisptkkykymd1(BizDate pVhsyudisptkkykymd1) {
        vhsyudisptkkykymd1 = pVhsyudisptkkykymd1;
    }

    public BizDate getVhsyudisptksknnkaisiymd1() {
        return vhsyudisptksknnkaisiymd1;
    }

    @Override
    public void setVhsyudisptksknnkaisiymd1(BizDate pVhsyudisptksknnkaisiymd1) {
        vhsyudisptksknnkaisiymd1 = pVhsyudisptksknnkaisiymd1;
    }

    public BizDate getVhsyudisptkgaskkaisiymd1() {
        return vhsyudisptkgaskkaisiymd1;
    }

    @Override
    public void setVhsyudisptkgaskkaisiymd1(BizDate pVhsyudisptkgaskkaisiymd1) {
        vhsyudisptkgaskkaisiymd1 = pVhsyudisptkgaskkaisiymd1;
    }

    public BizDate getVhsyudisptkhkskkaisiymd1() {
        return vhsyudisptkhkskkaisiymd1;
    }

    @Override
    public void setVhsyudisptkhkskkaisiymd1(BizDate pVhsyudisptkhkskkaisiymd1) {
        vhsyudisptkhkskkaisiymd1 = pVhsyudisptkhkskkaisiymd1;
    }

    public BizDate getVhsyudisptkhkgskksiymd1() {
        return vhsyudisptkhkgskksiymd1;
    }

    @Override
    public void setVhsyudisptkhkgskksiymd1(BizDate pVhsyudisptkhkgskksiymd1) {
        vhsyudisptkhkgskksiymd1 = pVhsyudisptkhkgskksiymd1;
    }

    public Integer getVhsyudisptkhknkkn1() {
        return vhsyudisptkhknkkn1;
    }

    @Override
    public void setVhsyudisptkhknkkn1(Integer pVhsyudisptkhknkkn1) {
        vhsyudisptkhknkkn1 = pVhsyudisptkhknkkn1;
    }

    public C_HknkknsmnKbn getVhsyudisptkhknkknsmnkbn1() {
        return vhsyudisptkhknkknsmnkbn1;
    }

    @Override
    public void setVhsyudisptkhknkknsmnkbn1(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn1) {
        vhsyudisptkhknkknsmnkbn1 = pVhsyudisptkhknkknsmnkbn1;
    }

    public Integer getVhsyudisptkhrkkkn1() {
        return vhsyudisptkhrkkkn1;
    }

    @Override
    public void setVhsyudisptkhrkkkn1(Integer pVhsyudisptkhrkkkn1) {
        vhsyudisptkhrkkkn1 = pVhsyudisptkhrkkkn1;
    }

    public C_HrkkknsmnKbn getVhsyudisptkhrkkknsmnkbn1() {
        return vhsyudisptkhrkkknsmnkbn1;
    }

    @Override
    public void setVhsyudisptkhrkkknsmnkbn1(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn1) {
        vhsyudisptkhrkkknsmnkbn1 = pVhsyudisptkhrkkknsmnkbn1;
    }

    public C_KihonssyuruiKbn getVhsyudisptkkihsyuruikbn1() {
        return vhsyudisptkkihsyuruikbn1;
    }

    @Override
    public void setVhsyudisptkkihsyuruikbn1(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn1) {
        vhsyudisptkkihsyuruikbn1 = pVhsyudisptkkihsyuruikbn1;
    }

    public BizCurrency getVhsyudisptkkihons1() {
        return vhsyudisptkkihons1;
    }

    @Override
    public void setVhsyudisptkkihons1(BizCurrency pVhsyudisptkkihons1) {
        vhsyudisptkkihons1 = pVhsyudisptkkihons1;
    }

    public BizCurrency getVhsyudisptkp1() {
        return vhsyudisptkp1;
    }

    @Override
    public void setVhsyudisptkp1(BizCurrency pVhsyudisptkp1) {
        vhsyudisptkp1 = pVhsyudisptkp1;
    }

    public BizCurrency getVhsyudisptkkihonkyhgk1() {
        return vhsyudisptkkihonkyhgk1;
    }

    @Override
    public void setVhsyudisptkkihonkyhgk1(BizCurrency pVhsyudisptkkihonkyhgk1) {
        vhsyudisptkkihonkyhgk1 = pVhsyudisptkkihonkyhgk1;
    }

    public BizCurrency getVhsyudisptknextkosgop1() {
        return vhsyudisptknextkosgop1;
    }

    @Override
    public void setVhsyudisptknextkosgop1(BizCurrency pVhsyudisptknextkosgop1) {
        vhsyudisptknextkosgop1 = pVhsyudisptknextkosgop1;
    }

    public C_SyukyhkinkataKbn getVhsyudisptksykyhkatakbn1() {
        return vhsyudisptksykyhkatakbn1;
    }

    @Override
    public void setVhsyudisptksykyhkatakbn1(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn1) {
        vhsyudisptksykyhkatakbn1 = pVhsyudisptksykyhkatakbn1;
    }

    public C_6daiLdKbn getVhsyudisptk6daildkbn1() {
        return vhsyudisptk6daildkbn1;
    }

    @Override
    public void setVhsyudisptk6daildkbn1(C_6daiLdKbn pVhsyudisptk6daildkbn1) {
        vhsyudisptk6daildkbn1 = pVhsyudisptk6daildkbn1;
    }

    public BizCurrency getVhsyudisptkganyukyhntgk1() {
        return vhsyudisptkganyukyhntgk1;
    }

    @Override
    public void setVhsyudisptkganyukyhntgk1(BizCurrency pVhsyudisptkganyukyhntgk1) {
        vhsyudisptkganyukyhntgk1 = pVhsyudisptkganyukyhntgk1;
    }

    public BizDate getVhsyudisptkshrskgstrymd1() {
        return vhsyudisptkshrskgstrymd1;
    }

    @Override
    public void setVhsyudisptkshrskgstrymd1(BizDate pVhsyudisptkshrskgstrymd1) {
        vhsyudisptkshrskgstrymd1 = pVhsyudisptkshrskgstrymd1;
    }

    public BizDate getVhsyudisptkshrskgnedymd1() {
        return vhsyudisptkshrskgnedymd1;
    }

    @Override
    public void setVhsyudisptkshrskgnedymd1(BizDate pVhsyudisptkshrskgnedymd1) {
        vhsyudisptkshrskgnedymd1 = pVhsyudisptkshrskgnedymd1;
    }

    public BizCurrency getVhsyudisptkshrskgngos1() {
        return vhsyudisptkshrskgngos1;
    }

    @Override
    public void setVhsyudisptkshrskgngos1(BizCurrency pVhsyudisptkshrskgngos1) {
        vhsyudisptkshrskgngos1 = pVhsyudisptkshrskgngos1;
    }

    public C_Nenkinsyu getVhsyudisptknenkinsyukbn1() {
        return vhsyudisptknenkinsyukbn1;
    }

    @Override
    public void setVhsyudisptknenkinsyukbn1(C_Nenkinsyu pVhsyudisptknenkinsyukbn1) {
        vhsyudisptknenkinsyukbn1 = pVhsyudisptknenkinsyukbn1;
    }

    public Integer getVhsyudisptknenkinkkn1() {
        return vhsyudisptknenkinkkn1;
    }

    @Override
    public void setVhsyudisptknenkinkkn1(Integer pVhsyudisptknenkinkkn1) {
        vhsyudisptknenkinkkn1 = pVhsyudisptknenkinkkn1;
    }

    public C_Tkjyskgnkkn getVhsyudisptktkjyskgnkkn1() {
        return vhsyudisptktkjyskgnkkn1;
    }

    @Override
    public void setVhsyudisptktkjyskgnkkn1(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn1) {
        vhsyudisptktkjyskgnkkn1 = pVhsyudisptktkjyskgnkkn1;
    }

    public BizDate getVhsyudisptktkjkhkdsymd11() {
        return vhsyudisptktkjkhkdsymd11;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd11(BizDate pVhsyudisptktkjkhkdsymd11) {
        vhsyudisptktkjkhkdsymd11 = pVhsyudisptktkjkhkdsymd11;
    }

    public BizDate getVhsyudisptktkjkhkdeymd11() {
        return vhsyudisptktkjkhkdeymd11;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd11(BizDate pVhsyudisptktkjkhkdeymd11) {
        vhsyudisptktkjkhkdeymd11 = pVhsyudisptktkjkhkdeymd11;
    }

    public BizCurrency getVhsyudisptktkjyskgns11() {
        return vhsyudisptktkjyskgns11;
    }

    @Override
    public void setVhsyudisptktkjyskgns11(BizCurrency pVhsyudisptktkjyskgns11) {
        vhsyudisptktkjyskgns11 = pVhsyudisptktkjyskgns11;
    }

    public BizDate getVhsyudisptktkjkhkdsymd21() {
        return vhsyudisptktkjkhkdsymd21;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd21(BizDate pVhsyudisptktkjkhkdsymd21) {
        vhsyudisptktkjkhkdsymd21 = pVhsyudisptktkjkhkdsymd21;
    }

    public BizDate getVhsyudisptktkjkhkdeymd21() {
        return vhsyudisptktkjkhkdeymd21;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd21(BizDate pVhsyudisptktkjkhkdeymd21) {
        vhsyudisptktkjkhkdeymd21 = pVhsyudisptktkjkhkdeymd21;
    }

    public BizCurrency getVhsyudisptktkjyskgns21() {
        return vhsyudisptktkjyskgns21;
    }

    @Override
    public void setVhsyudisptktkjyskgns21(BizCurrency pVhsyudisptktkjyskgns21) {
        vhsyudisptktkjyskgns21 = pVhsyudisptktkjyskgns21;
    }

    public BizDate getVhsyudisptktkjkhkdsymd31() {
        return vhsyudisptktkjkhkdsymd31;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd31(BizDate pVhsyudisptktkjkhkdsymd31) {
        vhsyudisptktkjkhkdsymd31 = pVhsyudisptktkjkhkdsymd31;
    }

    public BizDate getVhsyudisptktkjkhkdeymd31() {
        return vhsyudisptktkjkhkdeymd31;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd31(BizDate pVhsyudisptktkjkhkdeymd31) {
        vhsyudisptktkjkhkdeymd31 = pVhsyudisptktkjkhkdeymd31;
    }

    public BizCurrency getVhsyudisptktkjyskgns31() {
        return vhsyudisptktkjyskgns31;
    }

    @Override
    public void setVhsyudisptktkjyskgns31(BizCurrency pVhsyudisptktkjyskgns31) {
        vhsyudisptktkjyskgns31 = pVhsyudisptktkjyskgns31;
    }

    public BizDate getVhsyudisptktkjkhkdsymd41() {
        return vhsyudisptktkjkhkdsymd41;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd41(BizDate pVhsyudisptktkjkhkdsymd41) {
        vhsyudisptktkjkhkdsymd41 = pVhsyudisptktkjkhkdsymd41;
    }

    public BizDate getVhsyudisptktkjkhkdeymd41() {
        return vhsyudisptktkjkhkdeymd41;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd41(BizDate pVhsyudisptktkjkhkdeymd41) {
        vhsyudisptktkjkhkdeymd41 = pVhsyudisptktkjkhkdeymd41;
    }

    public BizCurrency getVhsyudisptktkjyskgns41() {
        return vhsyudisptktkjyskgns41;
    }

    @Override
    public void setVhsyudisptktkjyskgns41(BizCurrency pVhsyudisptktkjyskgns41) {
        vhsyudisptktkjyskgns41 = pVhsyudisptktkjyskgns41;
    }

    public BizDate getVhsyudisptktkjkhkdsymd51() {
        return vhsyudisptktkjkhkdsymd51;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd51(BizDate pVhsyudisptktkjkhkdsymd51) {
        vhsyudisptktkjkhkdsymd51 = pVhsyudisptktkjkhkdsymd51;
    }

    public BizDate getVhsyudisptktkjkhkdeymd51() {
        return vhsyudisptktkjkhkdeymd51;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd51(BizDate pVhsyudisptktkjkhkdeymd51) {
        vhsyudisptktkjkhkdeymd51 = pVhsyudisptktkjkhkdeymd51;
    }

    public BizCurrency getVhsyudisptktkjyskgns51() {
        return vhsyudisptktkjyskgns51;
    }

    @Override
    public void setVhsyudisptktkjyskgns51(BizCurrency pVhsyudisptktkjyskgns51) {
        vhsyudisptktkjyskgns51 = pVhsyudisptktkjyskgns51;
    }

    public C_Tkjyhyouten getVhsyudisptktkjyhyouten1() {
        return vhsyudisptktkjyhyouten1;
    }

    @Override
    public void setVhsyudisptktkjyhyouten1(C_Tkjyhyouten pVhsyudisptktkjyhyouten1) {
        vhsyudisptktkjyhyouten1 = pVhsyudisptktkjyhyouten1;
    }

    public BizCurrency getVhsyudisptktkjyp1() {
        return vhsyudisptktkjyp1;
    }

    @Override
    public void setVhsyudisptktkjyp1(BizCurrency pVhsyudisptktkjyp1) {
        vhsyudisptktkjyp1 = pVhsyudisptktkjyp1;
    }

    public String getVhsyudisptkhtnpbuicd11() {
        return vhsyudisptkhtnpbuicd11;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd11(String pVhsyudisptkhtnpbuicd11) {
        vhsyudisptkhtnpbuicd11 = pVhsyudisptkhtnpbuicd11;
    }

    public String getVhsyudisptkhtnpbuinm11() {
        return vhsyudisptkhtnpbuinm11;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm11(String pVhsyudisptkhtnpbuinm11) {
        vhsyudisptkhtnpbuinm11 = pVhsyudisptkhtnpbuinm11;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn11() {
        return vhsyudisptkhtnpkkn11;
    }

    @Override
    public void setVhsyudisptkhtnpkkn11(C_Htnpkkn pVhsyudisptkhtnpkkn11) {
        vhsyudisptkhtnpkkn11 = pVhsyudisptkhtnpkkn11;
    }

    public String getVhsyudisptkhtnpbuicd21() {
        return vhsyudisptkhtnpbuicd21;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd21(String pVhsyudisptkhtnpbuicd21) {
        vhsyudisptkhtnpbuicd21 = pVhsyudisptkhtnpbuicd21;
    }

    public String getVhsyudisptkhtnpbuinm21() {
        return vhsyudisptkhtnpbuinm21;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm21(String pVhsyudisptkhtnpbuinm21) {
        vhsyudisptkhtnpbuinm21 = pVhsyudisptkhtnpbuinm21;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn21() {
        return vhsyudisptkhtnpkkn21;
    }

    @Override
    public void setVhsyudisptkhtnpkkn21(C_Htnpkkn pVhsyudisptkhtnpkkn21) {
        vhsyudisptkhtnpkkn21 = pVhsyudisptkhtnpkkn21;
    }

    public String getVhsyudisptkhtnpbuicd31() {
        return vhsyudisptkhtnpbuicd31;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd31(String pVhsyudisptkhtnpbuicd31) {
        vhsyudisptkhtnpbuicd31 = pVhsyudisptkhtnpbuicd31;
    }

    public String getVhsyudisptkhtnpbuinm31() {
        return vhsyudisptkhtnpbuinm31;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm31(String pVhsyudisptkhtnpbuinm31) {
        vhsyudisptkhtnpbuinm31 = pVhsyudisptkhtnpbuinm31;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn31() {
        return vhsyudisptkhtnpkkn31;
    }

    @Override
    public void setVhsyudisptkhtnpkkn31(C_Htnpkkn pVhsyudisptkhtnpkkn31) {
        vhsyudisptkhtnpkkn31 = pVhsyudisptkhtnpkkn31;
    }

    public String getVhsyudisptkhtnpbuicd41() {
        return vhsyudisptkhtnpbuicd41;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd41(String pVhsyudisptkhtnpbuicd41) {
        vhsyudisptkhtnpbuicd41 = pVhsyudisptkhtnpbuicd41;
    }

    public String getVhsyudisptkhtnpbuinm41() {
        return vhsyudisptkhtnpbuinm41;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm41(String pVhsyudisptkhtnpbuinm41) {
        vhsyudisptkhtnpbuinm41 = pVhsyudisptkhtnpbuinm41;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn41() {
        return vhsyudisptkhtnpkkn41;
    }

    @Override
    public void setVhsyudisptkhtnpkkn41(C_Htnpkkn pVhsyudisptkhtnpkkn41) {
        vhsyudisptkhtnpkkn41 = pVhsyudisptkhtnpkkn41;
    }

    public C_TokkoudosghtnpKbn getVhsyudisptktkkdsghtpkbn1() {
        return vhsyudisptktkkdsghtpkbn1;
    }

    @Override
    public void setVhsyudisptktkkdsghtpkbn1(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn1) {
        vhsyudisptktkkdsghtpkbn1 = pVhsyudisptktkkdsghtpkbn1;
    }

    public BizCurrency getVhsyudisptktutakngk1() {
        return vhsyudisptktutakngk1;
    }

    @Override
    public void setVhsyudisptktutakngk1(BizCurrency pVhsyudisptktutakngk1) {
        vhsyudisptktutakngk1 = pVhsyudisptktutakngk1;
    }

    public BizDate getVhsyudisptkkrkhasseiymd1() {
        return vhsyudisptkkrkhasseiymd1;
    }

    @Override
    public void setVhsyudisptkkrkhasseiymd1(BizDate pVhsyudisptkkrkhasseiymd1) {
        vhsyudisptkkrkhasseiymd1 = pVhsyudisptkkrkhasseiymd1;
    }

    public String getVhsyudisptksyouhnnm2() {
        return vhsyudisptksyouhnnm2;
    }

    @Override
    public void setVhsyudisptksyouhnnm2(String pVhsyudisptksyouhnnm2) {
        vhsyudisptksyouhnnm2 = pVhsyudisptksyouhnnm2;
    }

    public C_Tuukasyu getVhsyudisptkktuukasyu2() {
        return vhsyudisptkktuukasyu2;
    }

    @Override
    public void setVhsyudisptkktuukasyu2(C_Tuukasyu pVhsyudisptkktuukasyu2) {
        vhsyudisptkktuukasyu2 = pVhsyudisptkktuukasyu2;
    }

    public C_KataKbn getVhsyudisptokyakukatakbn2() {
        return vhsyudisptokyakukatakbn2;
    }

    @Override
    public void setVhsyudisptokyakukatakbn2(C_KataKbn pVhsyudisptokyakukatakbn2) {
        vhsyudisptokyakukatakbn2 = pVhsyudisptokyakukatakbn2;
    }

    public C_KyhgndkataKbn getVhsyudisptkkyhgdkatakbn2() {
        return vhsyudisptkkyhgdkatakbn2;
    }

    @Override
    public void setVhsyudisptkkyhgdkatakbn2(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn2) {
        vhsyudisptkkyhgdkatakbn2 = pVhsyudisptkkyhgdkatakbn2;
    }

    public Integer getVhsyudisptkhhknnen2() {
        return vhsyudisptkhhknnen2;
    }

    @Override
    public void setVhsyudisptkhhknnen2(Integer pVhsyudisptkhhknnen2) {
        vhsyudisptkhhknnen2 = pVhsyudisptkhhknnen2;
    }

    public BizDate getVhsyudisptkkykymd2() {
        return vhsyudisptkkykymd2;
    }

    @Override
    public void setVhsyudisptkkykymd2(BizDate pVhsyudisptkkykymd2) {
        vhsyudisptkkykymd2 = pVhsyudisptkkykymd2;
    }

    public BizDate getVhsyudisptksknnkaisiymd2() {
        return vhsyudisptksknnkaisiymd2;
    }

    @Override
    public void setVhsyudisptksknnkaisiymd2(BizDate pVhsyudisptksknnkaisiymd2) {
        vhsyudisptksknnkaisiymd2 = pVhsyudisptksknnkaisiymd2;
    }

    public BizDate getVhsyudisptkgaskkaisiymd2() {
        return vhsyudisptkgaskkaisiymd2;
    }

    @Override
    public void setVhsyudisptkgaskkaisiymd2(BizDate pVhsyudisptkgaskkaisiymd2) {
        vhsyudisptkgaskkaisiymd2 = pVhsyudisptkgaskkaisiymd2;
    }

    public BizDate getVhsyudisptkhkskkaisiymd2() {
        return vhsyudisptkhkskkaisiymd2;
    }

    @Override
    public void setVhsyudisptkhkskkaisiymd2(BizDate pVhsyudisptkhkskkaisiymd2) {
        vhsyudisptkhkskkaisiymd2 = pVhsyudisptkhkskkaisiymd2;
    }

    public BizDate getVhsyudisptkhkgskksiymd2() {
        return vhsyudisptkhkgskksiymd2;
    }

    @Override
    public void setVhsyudisptkhkgskksiymd2(BizDate pVhsyudisptkhkgskksiymd2) {
        vhsyudisptkhkgskksiymd2 = pVhsyudisptkhkgskksiymd2;
    }

    public Integer getVhsyudisptkhknkkn2() {
        return vhsyudisptkhknkkn2;
    }

    @Override
    public void setVhsyudisptkhknkkn2(Integer pVhsyudisptkhknkkn2) {
        vhsyudisptkhknkkn2 = pVhsyudisptkhknkkn2;
    }

    public C_HknkknsmnKbn getVhsyudisptkhknkknsmnkbn2() {
        return vhsyudisptkhknkknsmnkbn2;
    }

    @Override
    public void setVhsyudisptkhknkknsmnkbn2(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn2) {
        vhsyudisptkhknkknsmnkbn2 = pVhsyudisptkhknkknsmnkbn2;
    }

    public Integer getVhsyudisptkhrkkkn2() {
        return vhsyudisptkhrkkkn2;
    }

    @Override
    public void setVhsyudisptkhrkkkn2(Integer pVhsyudisptkhrkkkn2) {
        vhsyudisptkhrkkkn2 = pVhsyudisptkhrkkkn2;
    }

    public C_HrkkknsmnKbn getVhsyudisptkhrkkknsmnkbn2() {
        return vhsyudisptkhrkkknsmnkbn2;
    }

    @Override
    public void setVhsyudisptkhrkkknsmnkbn2(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn2) {
        vhsyudisptkhrkkknsmnkbn2 = pVhsyudisptkhrkkknsmnkbn2;
    }

    public C_KihonssyuruiKbn getVhsyudisptkkihsyuruikbn2() {
        return vhsyudisptkkihsyuruikbn2;
    }

    @Override
    public void setVhsyudisptkkihsyuruikbn2(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn2) {
        vhsyudisptkkihsyuruikbn2 = pVhsyudisptkkihsyuruikbn2;
    }

    public BizCurrency getVhsyudisptkkihons2() {
        return vhsyudisptkkihons2;
    }

    @Override
    public void setVhsyudisptkkihons2(BizCurrency pVhsyudisptkkihons2) {
        vhsyudisptkkihons2 = pVhsyudisptkkihons2;
    }

    public BizCurrency getVhsyudisptkp2() {
        return vhsyudisptkp2;
    }

    @Override
    public void setVhsyudisptkp2(BizCurrency pVhsyudisptkp2) {
        vhsyudisptkp2 = pVhsyudisptkp2;
    }

    public BizCurrency getVhsyudisptkkihonkyhgk2() {
        return vhsyudisptkkihonkyhgk2;
    }

    @Override
    public void setVhsyudisptkkihonkyhgk2(BizCurrency pVhsyudisptkkihonkyhgk2) {
        vhsyudisptkkihonkyhgk2 = pVhsyudisptkkihonkyhgk2;
    }

    public BizCurrency getVhsyudisptknextkosgop2() {
        return vhsyudisptknextkosgop2;
    }

    @Override
    public void setVhsyudisptknextkosgop2(BizCurrency pVhsyudisptknextkosgop2) {
        vhsyudisptknextkosgop2 = pVhsyudisptknextkosgop2;
    }

    public C_SyukyhkinkataKbn getVhsyudisptksykyhkatakbn2() {
        return vhsyudisptksykyhkatakbn2;
    }

    @Override
    public void setVhsyudisptksykyhkatakbn2(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn2) {
        vhsyudisptksykyhkatakbn2 = pVhsyudisptksykyhkatakbn2;
    }

    public C_6daiLdKbn getVhsyudisptk6daildkbn2() {
        return vhsyudisptk6daildkbn2;
    }

    @Override
    public void setVhsyudisptk6daildkbn2(C_6daiLdKbn pVhsyudisptk6daildkbn2) {
        vhsyudisptk6daildkbn2 = pVhsyudisptk6daildkbn2;
    }

    public BizCurrency getVhsyudisptkganyukyhntgk2() {
        return vhsyudisptkganyukyhntgk2;
    }

    @Override
    public void setVhsyudisptkganyukyhntgk2(BizCurrency pVhsyudisptkganyukyhntgk2) {
        vhsyudisptkganyukyhntgk2 = pVhsyudisptkganyukyhntgk2;
    }

    public BizDate getVhsyudisptkshrskgstrymd2() {
        return vhsyudisptkshrskgstrymd2;
    }

    @Override
    public void setVhsyudisptkshrskgstrymd2(BizDate pVhsyudisptkshrskgstrymd2) {
        vhsyudisptkshrskgstrymd2 = pVhsyudisptkshrskgstrymd2;
    }

    public BizDate getVhsyudisptkshrskgnedymd2() {
        return vhsyudisptkshrskgnedymd2;
    }

    @Override
    public void setVhsyudisptkshrskgnedymd2(BizDate pVhsyudisptkshrskgnedymd2) {
        vhsyudisptkshrskgnedymd2 = pVhsyudisptkshrskgnedymd2;
    }

    public BizCurrency getVhsyudisptkshrskgngos2() {
        return vhsyudisptkshrskgngos2;
    }

    @Override
    public void setVhsyudisptkshrskgngos2(BizCurrency pVhsyudisptkshrskgngos2) {
        vhsyudisptkshrskgngos2 = pVhsyudisptkshrskgngos2;
    }

    public C_Nenkinsyu getVhsyudisptknenkinsyukbn2() {
        return vhsyudisptknenkinsyukbn2;
    }

    @Override
    public void setVhsyudisptknenkinsyukbn2(C_Nenkinsyu pVhsyudisptknenkinsyukbn2) {
        vhsyudisptknenkinsyukbn2 = pVhsyudisptknenkinsyukbn2;
    }

    public Integer getVhsyudisptknenkinkkn2() {
        return vhsyudisptknenkinkkn2;
    }

    @Override
    public void setVhsyudisptknenkinkkn2(Integer pVhsyudisptknenkinkkn2) {
        vhsyudisptknenkinkkn2 = pVhsyudisptknenkinkkn2;
    }

    public C_Tkjyskgnkkn getVhsyudisptktkjyskgnkkn2() {
        return vhsyudisptktkjyskgnkkn2;
    }

    @Override
    public void setVhsyudisptktkjyskgnkkn2(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn2) {
        vhsyudisptktkjyskgnkkn2 = pVhsyudisptktkjyskgnkkn2;
    }

    public BizDate getVhsyudisptktkjkhkdsymd12() {
        return vhsyudisptktkjkhkdsymd12;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd12(BizDate pVhsyudisptktkjkhkdsymd12) {
        vhsyudisptktkjkhkdsymd12 = pVhsyudisptktkjkhkdsymd12;
    }

    public BizDate getVhsyudisptktkjkhkdeymd12() {
        return vhsyudisptktkjkhkdeymd12;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd12(BizDate pVhsyudisptktkjkhkdeymd12) {
        vhsyudisptktkjkhkdeymd12 = pVhsyudisptktkjkhkdeymd12;
    }

    public BizCurrency getVhsyudisptktkjyskgns12() {
        return vhsyudisptktkjyskgns12;
    }

    @Override
    public void setVhsyudisptktkjyskgns12(BizCurrency pVhsyudisptktkjyskgns12) {
        vhsyudisptktkjyskgns12 = pVhsyudisptktkjyskgns12;
    }

    public BizDate getVhsyudisptktkjkhkdsymd22() {
        return vhsyudisptktkjkhkdsymd22;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd22(BizDate pVhsyudisptktkjkhkdsymd22) {
        vhsyudisptktkjkhkdsymd22 = pVhsyudisptktkjkhkdsymd22;
    }

    public BizDate getVhsyudisptktkjkhkdeymd22() {
        return vhsyudisptktkjkhkdeymd22;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd22(BizDate pVhsyudisptktkjkhkdeymd22) {
        vhsyudisptktkjkhkdeymd22 = pVhsyudisptktkjkhkdeymd22;
    }

    public BizCurrency getVhsyudisptktkjyskgns22() {
        return vhsyudisptktkjyskgns22;
    }

    @Override
    public void setVhsyudisptktkjyskgns22(BizCurrency pVhsyudisptktkjyskgns22) {
        vhsyudisptktkjyskgns22 = pVhsyudisptktkjyskgns22;
    }

    public BizDate getVhsyudisptktkjkhkdsymd32() {
        return vhsyudisptktkjkhkdsymd32;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd32(BizDate pVhsyudisptktkjkhkdsymd32) {
        vhsyudisptktkjkhkdsymd32 = pVhsyudisptktkjkhkdsymd32;
    }

    public BizDate getVhsyudisptktkjkhkdeymd32() {
        return vhsyudisptktkjkhkdeymd32;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd32(BizDate pVhsyudisptktkjkhkdeymd32) {
        vhsyudisptktkjkhkdeymd32 = pVhsyudisptktkjkhkdeymd32;
    }

    public BizCurrency getVhsyudisptktkjyskgns32() {
        return vhsyudisptktkjyskgns32;
    }

    @Override
    public void setVhsyudisptktkjyskgns32(BizCurrency pVhsyudisptktkjyskgns32) {
        vhsyudisptktkjyskgns32 = pVhsyudisptktkjyskgns32;
    }

    public BizDate getVhsyudisptktkjkhkdsymd42() {
        return vhsyudisptktkjkhkdsymd42;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd42(BizDate pVhsyudisptktkjkhkdsymd42) {
        vhsyudisptktkjkhkdsymd42 = pVhsyudisptktkjkhkdsymd42;
    }

    public BizDate getVhsyudisptktkjkhkdeymd42() {
        return vhsyudisptktkjkhkdeymd42;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd42(BizDate pVhsyudisptktkjkhkdeymd42) {
        vhsyudisptktkjkhkdeymd42 = pVhsyudisptktkjkhkdeymd42;
    }

    public BizCurrency getVhsyudisptktkjyskgns42() {
        return vhsyudisptktkjyskgns42;
    }

    @Override
    public void setVhsyudisptktkjyskgns42(BizCurrency pVhsyudisptktkjyskgns42) {
        vhsyudisptktkjyskgns42 = pVhsyudisptktkjyskgns42;
    }

    public BizDate getVhsyudisptktkjkhkdsymd52() {
        return vhsyudisptktkjkhkdsymd52;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd52(BizDate pVhsyudisptktkjkhkdsymd52) {
        vhsyudisptktkjkhkdsymd52 = pVhsyudisptktkjkhkdsymd52;
    }

    public BizDate getVhsyudisptktkjkhkdeymd52() {
        return vhsyudisptktkjkhkdeymd52;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd52(BizDate pVhsyudisptktkjkhkdeymd52) {
        vhsyudisptktkjkhkdeymd52 = pVhsyudisptktkjkhkdeymd52;
    }

    public BizCurrency getVhsyudisptktkjyskgns52() {
        return vhsyudisptktkjyskgns52;
    }

    @Override
    public void setVhsyudisptktkjyskgns52(BizCurrency pVhsyudisptktkjyskgns52) {
        vhsyudisptktkjyskgns52 = pVhsyudisptktkjyskgns52;
    }

    public C_Tkjyhyouten getVhsyudisptktkjyhyouten2() {
        return vhsyudisptktkjyhyouten2;
    }

    @Override
    public void setVhsyudisptktkjyhyouten2(C_Tkjyhyouten pVhsyudisptktkjyhyouten2) {
        vhsyudisptktkjyhyouten2 = pVhsyudisptktkjyhyouten2;
    }

    public BizCurrency getVhsyudisptktkjyp2() {
        return vhsyudisptktkjyp2;
    }

    @Override
    public void setVhsyudisptktkjyp2(BizCurrency pVhsyudisptktkjyp2) {
        vhsyudisptktkjyp2 = pVhsyudisptktkjyp2;
    }

    public String getVhsyudisptkhtnpbuicd12() {
        return vhsyudisptkhtnpbuicd12;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd12(String pVhsyudisptkhtnpbuicd12) {
        vhsyudisptkhtnpbuicd12 = pVhsyudisptkhtnpbuicd12;
    }

    public String getVhsyudisptkhtnpbuinm12() {
        return vhsyudisptkhtnpbuinm12;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm12(String pVhsyudisptkhtnpbuinm12) {
        vhsyudisptkhtnpbuinm12 = pVhsyudisptkhtnpbuinm12;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn12() {
        return vhsyudisptkhtnpkkn12;
    }

    @Override
    public void setVhsyudisptkhtnpkkn12(C_Htnpkkn pVhsyudisptkhtnpkkn12) {
        vhsyudisptkhtnpkkn12 = pVhsyudisptkhtnpkkn12;
    }

    public String getVhsyudisptkhtnpbuicd22() {
        return vhsyudisptkhtnpbuicd22;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd22(String pVhsyudisptkhtnpbuicd22) {
        vhsyudisptkhtnpbuicd22 = pVhsyudisptkhtnpbuicd22;
    }

    public String getVhsyudisptkhtnpbuinm22() {
        return vhsyudisptkhtnpbuinm22;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm22(String pVhsyudisptkhtnpbuinm22) {
        vhsyudisptkhtnpbuinm22 = pVhsyudisptkhtnpbuinm22;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn22() {
        return vhsyudisptkhtnpkkn22;
    }

    @Override
    public void setVhsyudisptkhtnpkkn22(C_Htnpkkn pVhsyudisptkhtnpkkn22) {
        vhsyudisptkhtnpkkn22 = pVhsyudisptkhtnpkkn22;
    }

    public String getVhsyudisptkhtnpbuicd32() {
        return vhsyudisptkhtnpbuicd32;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd32(String pVhsyudisptkhtnpbuicd32) {
        vhsyudisptkhtnpbuicd32 = pVhsyudisptkhtnpbuicd32;
    }

    public String getVhsyudisptkhtnpbuinm32() {
        return vhsyudisptkhtnpbuinm32;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm32(String pVhsyudisptkhtnpbuinm32) {
        vhsyudisptkhtnpbuinm32 = pVhsyudisptkhtnpbuinm32;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn32() {
        return vhsyudisptkhtnpkkn32;
    }

    @Override
    public void setVhsyudisptkhtnpkkn32(C_Htnpkkn pVhsyudisptkhtnpkkn32) {
        vhsyudisptkhtnpkkn32 = pVhsyudisptkhtnpkkn32;
    }

    public String getVhsyudisptkhtnpbuicd42() {
        return vhsyudisptkhtnpbuicd42;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd42(String pVhsyudisptkhtnpbuicd42) {
        vhsyudisptkhtnpbuicd42 = pVhsyudisptkhtnpbuicd42;
    }

    public String getVhsyudisptkhtnpbuinm42() {
        return vhsyudisptkhtnpbuinm42;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm42(String pVhsyudisptkhtnpbuinm42) {
        vhsyudisptkhtnpbuinm42 = pVhsyudisptkhtnpbuinm42;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn42() {
        return vhsyudisptkhtnpkkn42;
    }

    @Override
    public void setVhsyudisptkhtnpkkn42(C_Htnpkkn pVhsyudisptkhtnpkkn42) {
        vhsyudisptkhtnpkkn42 = pVhsyudisptkhtnpkkn42;
    }

    public C_TokkoudosghtnpKbn getVhsyudisptktkkdsghtpkbn2() {
        return vhsyudisptktkkdsghtpkbn2;
    }

    @Override
    public void setVhsyudisptktkkdsghtpkbn2(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn2) {
        vhsyudisptktkkdsghtpkbn2 = pVhsyudisptktkkdsghtpkbn2;
    }

    public BizCurrency getVhsyudisptktutakngk2() {
        return vhsyudisptktutakngk2;
    }

    @Override
    public void setVhsyudisptktutakngk2(BizCurrency pVhsyudisptktutakngk2) {
        vhsyudisptktutakngk2 = pVhsyudisptktutakngk2;
    }

    public BizDate getVhsyudisptkkrkhasseiymd2() {
        return vhsyudisptkkrkhasseiymd2;
    }

    @Override
    public void setVhsyudisptkkrkhasseiymd2(BizDate pVhsyudisptkkrkhasseiymd2) {
        vhsyudisptkkrkhasseiymd2 = pVhsyudisptkkrkhasseiymd2;
    }

    public String getVhsyudisptksyouhnnm3() {
        return vhsyudisptksyouhnnm3;
    }

    @Override
    public void setVhsyudisptksyouhnnm3(String pVhsyudisptksyouhnnm3) {
        vhsyudisptksyouhnnm3 = pVhsyudisptksyouhnnm3;
    }

    public C_Tuukasyu getVhsyudisptkktuukasyu3() {
        return vhsyudisptkktuukasyu3;
    }

    @Override
    public void setVhsyudisptkktuukasyu3(C_Tuukasyu pVhsyudisptkktuukasyu3) {
        vhsyudisptkktuukasyu3 = pVhsyudisptkktuukasyu3;
    }

    public C_KataKbn getVhsyudisptokyakukatakbn3() {
        return vhsyudisptokyakukatakbn3;
    }

    @Override
    public void setVhsyudisptokyakukatakbn3(C_KataKbn pVhsyudisptokyakukatakbn3) {
        vhsyudisptokyakukatakbn3 = pVhsyudisptokyakukatakbn3;
    }

    public C_KyhgndkataKbn getVhsyudisptkkyhgdkatakbn3() {
        return vhsyudisptkkyhgdkatakbn3;
    }

    @Override
    public void setVhsyudisptkkyhgdkatakbn3(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn3) {
        vhsyudisptkkyhgdkatakbn3 = pVhsyudisptkkyhgdkatakbn3;
    }

    public Integer getVhsyudisptkhhknnen3() {
        return vhsyudisptkhhknnen3;
    }

    @Override
    public void setVhsyudisptkhhknnen3(Integer pVhsyudisptkhhknnen3) {
        vhsyudisptkhhknnen3 = pVhsyudisptkhhknnen3;
    }

    public BizDate getVhsyudisptkkykymd3() {
        return vhsyudisptkkykymd3;
    }

    @Override
    public void setVhsyudisptkkykymd3(BizDate pVhsyudisptkkykymd3) {
        vhsyudisptkkykymd3 = pVhsyudisptkkykymd3;
    }

    public BizDate getVhsyudisptksknnkaisiymd3() {
        return vhsyudisptksknnkaisiymd3;
    }

    @Override
    public void setVhsyudisptksknnkaisiymd3(BizDate pVhsyudisptksknnkaisiymd3) {
        vhsyudisptksknnkaisiymd3 = pVhsyudisptksknnkaisiymd3;
    }

    public BizDate getVhsyudisptkgaskkaisiymd3() {
        return vhsyudisptkgaskkaisiymd3;
    }

    @Override
    public void setVhsyudisptkgaskkaisiymd3(BizDate pVhsyudisptkgaskkaisiymd3) {
        vhsyudisptkgaskkaisiymd3 = pVhsyudisptkgaskkaisiymd3;
    }

    public BizDate getVhsyudisptkhkskkaisiymd3() {
        return vhsyudisptkhkskkaisiymd3;
    }

    @Override
    public void setVhsyudisptkhkskkaisiymd3(BizDate pVhsyudisptkhkskkaisiymd3) {
        vhsyudisptkhkskkaisiymd3 = pVhsyudisptkhkskkaisiymd3;
    }

    public BizDate getVhsyudisptkhkgskksiymd3() {
        return vhsyudisptkhkgskksiymd3;
    }

    @Override
    public void setVhsyudisptkhkgskksiymd3(BizDate pVhsyudisptkhkgskksiymd3) {
        vhsyudisptkhkgskksiymd3 = pVhsyudisptkhkgskksiymd3;
    }

    public Integer getVhsyudisptkhknkkn3() {
        return vhsyudisptkhknkkn3;
    }

    @Override
    public void setVhsyudisptkhknkkn3(Integer pVhsyudisptkhknkkn3) {
        vhsyudisptkhknkkn3 = pVhsyudisptkhknkkn3;
    }

    public C_HknkknsmnKbn getVhsyudisptkhknkknsmnkbn3() {
        return vhsyudisptkhknkknsmnkbn3;
    }

    @Override
    public void setVhsyudisptkhknkknsmnkbn3(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn3) {
        vhsyudisptkhknkknsmnkbn3 = pVhsyudisptkhknkknsmnkbn3;
    }

    public Integer getVhsyudisptkhrkkkn3() {
        return vhsyudisptkhrkkkn3;
    }

    @Override
    public void setVhsyudisptkhrkkkn3(Integer pVhsyudisptkhrkkkn3) {
        vhsyudisptkhrkkkn3 = pVhsyudisptkhrkkkn3;
    }

    public C_HrkkknsmnKbn getVhsyudisptkhrkkknsmnkbn3() {
        return vhsyudisptkhrkkknsmnkbn3;
    }

    @Override
    public void setVhsyudisptkhrkkknsmnkbn3(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn3) {
        vhsyudisptkhrkkknsmnkbn3 = pVhsyudisptkhrkkknsmnkbn3;
    }

    public C_KihonssyuruiKbn getVhsyudisptkkihsyuruikbn3() {
        return vhsyudisptkkihsyuruikbn3;
    }

    @Override
    public void setVhsyudisptkkihsyuruikbn3(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn3) {
        vhsyudisptkkihsyuruikbn3 = pVhsyudisptkkihsyuruikbn3;
    }

    public BizCurrency getVhsyudisptkkihons3() {
        return vhsyudisptkkihons3;
    }

    @Override
    public void setVhsyudisptkkihons3(BizCurrency pVhsyudisptkkihons3) {
        vhsyudisptkkihons3 = pVhsyudisptkkihons3;
    }

    public BizCurrency getVhsyudisptkp3() {
        return vhsyudisptkp3;
    }

    @Override
    public void setVhsyudisptkp3(BizCurrency pVhsyudisptkp3) {
        vhsyudisptkp3 = pVhsyudisptkp3;
    }

    public BizCurrency getVhsyudisptkkihonkyhgk3() {
        return vhsyudisptkkihonkyhgk3;
    }

    @Override
    public void setVhsyudisptkkihonkyhgk3(BizCurrency pVhsyudisptkkihonkyhgk3) {
        vhsyudisptkkihonkyhgk3 = pVhsyudisptkkihonkyhgk3;
    }

    public BizCurrency getVhsyudisptknextkosgop3() {
        return vhsyudisptknextkosgop3;
    }

    @Override
    public void setVhsyudisptknextkosgop3(BizCurrency pVhsyudisptknextkosgop3) {
        vhsyudisptknextkosgop3 = pVhsyudisptknextkosgop3;
    }

    public C_SyukyhkinkataKbn getVhsyudisptksykyhkatakbn3() {
        return vhsyudisptksykyhkatakbn3;
    }

    @Override
    public void setVhsyudisptksykyhkatakbn3(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn3) {
        vhsyudisptksykyhkatakbn3 = pVhsyudisptksykyhkatakbn3;
    }

    public C_6daiLdKbn getVhsyudisptk6daildkbn3() {
        return vhsyudisptk6daildkbn3;
    }

    @Override
    public void setVhsyudisptk6daildkbn3(C_6daiLdKbn pVhsyudisptk6daildkbn3) {
        vhsyudisptk6daildkbn3 = pVhsyudisptk6daildkbn3;
    }

    public BizCurrency getVhsyudisptkganyukyhntgk3() {
        return vhsyudisptkganyukyhntgk3;
    }

    @Override
    public void setVhsyudisptkganyukyhntgk3(BizCurrency pVhsyudisptkganyukyhntgk3) {
        vhsyudisptkganyukyhntgk3 = pVhsyudisptkganyukyhntgk3;
    }

    public BizDate getVhsyudisptkshrskgstrymd3() {
        return vhsyudisptkshrskgstrymd3;
    }

    @Override
    public void setVhsyudisptkshrskgstrymd3(BizDate pVhsyudisptkshrskgstrymd3) {
        vhsyudisptkshrskgstrymd3 = pVhsyudisptkshrskgstrymd3;
    }

    public BizDate getVhsyudisptkshrskgnedymd3() {
        return vhsyudisptkshrskgnedymd3;
    }

    @Override
    public void setVhsyudisptkshrskgnedymd3(BizDate pVhsyudisptkshrskgnedymd3) {
        vhsyudisptkshrskgnedymd3 = pVhsyudisptkshrskgnedymd3;
    }

    public BizCurrency getVhsyudisptkshrskgngos3() {
        return vhsyudisptkshrskgngos3;
    }

    @Override
    public void setVhsyudisptkshrskgngos3(BizCurrency pVhsyudisptkshrskgngos3) {
        vhsyudisptkshrskgngos3 = pVhsyudisptkshrskgngos3;
    }

    public C_Nenkinsyu getVhsyudisptknenkinsyukbn3() {
        return vhsyudisptknenkinsyukbn3;
    }

    @Override
    public void setVhsyudisptknenkinsyukbn3(C_Nenkinsyu pVhsyudisptknenkinsyukbn3) {
        vhsyudisptknenkinsyukbn3 = pVhsyudisptknenkinsyukbn3;
    }

    public Integer getVhsyudisptknenkinkkn3() {
        return vhsyudisptknenkinkkn3;
    }

    @Override
    public void setVhsyudisptknenkinkkn3(Integer pVhsyudisptknenkinkkn3) {
        vhsyudisptknenkinkkn3 = pVhsyudisptknenkinkkn3;
    }

    public C_Tkjyskgnkkn getVhsyudisptktkjyskgnkkn3() {
        return vhsyudisptktkjyskgnkkn3;
    }

    @Override
    public void setVhsyudisptktkjyskgnkkn3(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn3) {
        vhsyudisptktkjyskgnkkn3 = pVhsyudisptktkjyskgnkkn3;
    }

    public BizDate getVhsyudisptktkjkhkdsymd13() {
        return vhsyudisptktkjkhkdsymd13;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd13(BizDate pVhsyudisptktkjkhkdsymd13) {
        vhsyudisptktkjkhkdsymd13 = pVhsyudisptktkjkhkdsymd13;
    }

    public BizDate getVhsyudisptktkjkhkdeymd13() {
        return vhsyudisptktkjkhkdeymd13;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd13(BizDate pVhsyudisptktkjkhkdeymd13) {
        vhsyudisptktkjkhkdeymd13 = pVhsyudisptktkjkhkdeymd13;
    }

    public BizCurrency getVhsyudisptktkjyskgns13() {
        return vhsyudisptktkjyskgns13;
    }

    @Override
    public void setVhsyudisptktkjyskgns13(BizCurrency pVhsyudisptktkjyskgns13) {
        vhsyudisptktkjyskgns13 = pVhsyudisptktkjyskgns13;
    }

    public BizDate getVhsyudisptktkjkhkdsymd23() {
        return vhsyudisptktkjkhkdsymd23;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd23(BizDate pVhsyudisptktkjkhkdsymd23) {
        vhsyudisptktkjkhkdsymd23 = pVhsyudisptktkjkhkdsymd23;
    }

    public BizDate getVhsyudisptktkjkhkdeymd23() {
        return vhsyudisptktkjkhkdeymd23;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd23(BizDate pVhsyudisptktkjkhkdeymd23) {
        vhsyudisptktkjkhkdeymd23 = pVhsyudisptktkjkhkdeymd23;
    }

    public BizCurrency getVhsyudisptktkjyskgns23() {
        return vhsyudisptktkjyskgns23;
    }

    @Override
    public void setVhsyudisptktkjyskgns23(BizCurrency pVhsyudisptktkjyskgns23) {
        vhsyudisptktkjyskgns23 = pVhsyudisptktkjyskgns23;
    }

    public BizDate getVhsyudisptktkjkhkdsymd33() {
        return vhsyudisptktkjkhkdsymd33;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd33(BizDate pVhsyudisptktkjkhkdsymd33) {
        vhsyudisptktkjkhkdsymd33 = pVhsyudisptktkjkhkdsymd33;
    }

    public BizDate getVhsyudisptktkjkhkdeymd33() {
        return vhsyudisptktkjkhkdeymd33;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd33(BizDate pVhsyudisptktkjkhkdeymd33) {
        vhsyudisptktkjkhkdeymd33 = pVhsyudisptktkjkhkdeymd33;
    }

    public BizCurrency getVhsyudisptktkjyskgns33() {
        return vhsyudisptktkjyskgns33;
    }

    @Override
    public void setVhsyudisptktkjyskgns33(BizCurrency pVhsyudisptktkjyskgns33) {
        vhsyudisptktkjyskgns33 = pVhsyudisptktkjyskgns33;
    }

    public BizDate getVhsyudisptktkjkhkdsymd43() {
        return vhsyudisptktkjkhkdsymd43;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd43(BizDate pVhsyudisptktkjkhkdsymd43) {
        vhsyudisptktkjkhkdsymd43 = pVhsyudisptktkjkhkdsymd43;
    }

    public BizDate getVhsyudisptktkjkhkdeymd43() {
        return vhsyudisptktkjkhkdeymd43;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd43(BizDate pVhsyudisptktkjkhkdeymd43) {
        vhsyudisptktkjkhkdeymd43 = pVhsyudisptktkjkhkdeymd43;
    }

    public BizCurrency getVhsyudisptktkjyskgns43() {
        return vhsyudisptktkjyskgns43;
    }

    @Override
    public void setVhsyudisptktkjyskgns43(BizCurrency pVhsyudisptktkjyskgns43) {
        vhsyudisptktkjyskgns43 = pVhsyudisptktkjyskgns43;
    }

    public BizDate getVhsyudisptktkjkhkdsymd53() {
        return vhsyudisptktkjkhkdsymd53;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd53(BizDate pVhsyudisptktkjkhkdsymd53) {
        vhsyudisptktkjkhkdsymd53 = pVhsyudisptktkjkhkdsymd53;
    }

    public BizDate getVhsyudisptktkjkhkdeymd53() {
        return vhsyudisptktkjkhkdeymd53;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd53(BizDate pVhsyudisptktkjkhkdeymd53) {
        vhsyudisptktkjkhkdeymd53 = pVhsyudisptktkjkhkdeymd53;
    }

    public BizCurrency getVhsyudisptktkjyskgns53() {
        return vhsyudisptktkjyskgns53;
    }

    @Override
    public void setVhsyudisptktkjyskgns53(BizCurrency pVhsyudisptktkjyskgns53) {
        vhsyudisptktkjyskgns53 = pVhsyudisptktkjyskgns53;
    }

    public C_Tkjyhyouten getVhsyudisptktkjyhyouten3() {
        return vhsyudisptktkjyhyouten3;
    }

    @Override
    public void setVhsyudisptktkjyhyouten3(C_Tkjyhyouten pVhsyudisptktkjyhyouten3) {
        vhsyudisptktkjyhyouten3 = pVhsyudisptktkjyhyouten3;
    }

    public BizCurrency getVhsyudisptktkjyp3() {
        return vhsyudisptktkjyp3;
    }

    @Override
    public void setVhsyudisptktkjyp3(BizCurrency pVhsyudisptktkjyp3) {
        vhsyudisptktkjyp3 = pVhsyudisptktkjyp3;
    }

    public String getVhsyudisptkhtnpbuicd13() {
        return vhsyudisptkhtnpbuicd13;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd13(String pVhsyudisptkhtnpbuicd13) {
        vhsyudisptkhtnpbuicd13 = pVhsyudisptkhtnpbuicd13;
    }

    public String getVhsyudisptkhtnpbuinm13() {
        return vhsyudisptkhtnpbuinm13;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm13(String pVhsyudisptkhtnpbuinm13) {
        vhsyudisptkhtnpbuinm13 = pVhsyudisptkhtnpbuinm13;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn13() {
        return vhsyudisptkhtnpkkn13;
    }

    @Override
    public void setVhsyudisptkhtnpkkn13(C_Htnpkkn pVhsyudisptkhtnpkkn13) {
        vhsyudisptkhtnpkkn13 = pVhsyudisptkhtnpkkn13;
    }

    public String getVhsyudisptkhtnpbuicd23() {
        return vhsyudisptkhtnpbuicd23;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd23(String pVhsyudisptkhtnpbuicd23) {
        vhsyudisptkhtnpbuicd23 = pVhsyudisptkhtnpbuicd23;
    }

    public String getVhsyudisptkhtnpbuinm23() {
        return vhsyudisptkhtnpbuinm23;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm23(String pVhsyudisptkhtnpbuinm23) {
        vhsyudisptkhtnpbuinm23 = pVhsyudisptkhtnpbuinm23;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn23() {
        return vhsyudisptkhtnpkkn23;
    }

    @Override
    public void setVhsyudisptkhtnpkkn23(C_Htnpkkn pVhsyudisptkhtnpkkn23) {
        vhsyudisptkhtnpkkn23 = pVhsyudisptkhtnpkkn23;
    }

    public String getVhsyudisptkhtnpbuicd33() {
        return vhsyudisptkhtnpbuicd33;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd33(String pVhsyudisptkhtnpbuicd33) {
        vhsyudisptkhtnpbuicd33 = pVhsyudisptkhtnpbuicd33;
    }

    public String getVhsyudisptkhtnpbuinm33() {
        return vhsyudisptkhtnpbuinm33;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm33(String pVhsyudisptkhtnpbuinm33) {
        vhsyudisptkhtnpbuinm33 = pVhsyudisptkhtnpbuinm33;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn33() {
        return vhsyudisptkhtnpkkn33;
    }

    @Override
    public void setVhsyudisptkhtnpkkn33(C_Htnpkkn pVhsyudisptkhtnpkkn33) {
        vhsyudisptkhtnpkkn33 = pVhsyudisptkhtnpkkn33;
    }

    public String getVhsyudisptkhtnpbuicd43() {
        return vhsyudisptkhtnpbuicd43;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd43(String pVhsyudisptkhtnpbuicd43) {
        vhsyudisptkhtnpbuicd43 = pVhsyudisptkhtnpbuicd43;
    }

    public String getVhsyudisptkhtnpbuinm43() {
        return vhsyudisptkhtnpbuinm43;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm43(String pVhsyudisptkhtnpbuinm43) {
        vhsyudisptkhtnpbuinm43 = pVhsyudisptkhtnpbuinm43;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn43() {
        return vhsyudisptkhtnpkkn43;
    }

    @Override
    public void setVhsyudisptkhtnpkkn43(C_Htnpkkn pVhsyudisptkhtnpkkn43) {
        vhsyudisptkhtnpkkn43 = pVhsyudisptkhtnpkkn43;
    }

    public C_TokkoudosghtnpKbn getVhsyudisptktkkdsghtpkbn3() {
        return vhsyudisptktkkdsghtpkbn3;
    }

    @Override
    public void setVhsyudisptktkkdsghtpkbn3(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn3) {
        vhsyudisptktkkdsghtpkbn3 = pVhsyudisptktkkdsghtpkbn3;
    }

    public BizCurrency getVhsyudisptktutakngk3() {
        return vhsyudisptktutakngk3;
    }

    @Override
    public void setVhsyudisptktutakngk3(BizCurrency pVhsyudisptktutakngk3) {
        vhsyudisptktutakngk3 = pVhsyudisptktutakngk3;
    }

    public BizDate getVhsyudisptkkrkhasseiymd3() {
        return vhsyudisptkkrkhasseiymd3;
    }

    @Override
    public void setVhsyudisptkkrkhasseiymd3(BizDate pVhsyudisptkkrkhasseiymd3) {
        vhsyudisptkkrkhasseiymd3 = pVhsyudisptkkrkhasseiymd3;
    }

    public String getVhsyudisptksyouhnnm4() {
        return vhsyudisptksyouhnnm4;
    }

    @Override
    public void setVhsyudisptksyouhnnm4(String pVhsyudisptksyouhnnm4) {
        vhsyudisptksyouhnnm4 = pVhsyudisptksyouhnnm4;
    }

    public C_Tuukasyu getVhsyudisptkktuukasyu4() {
        return vhsyudisptkktuukasyu4;
    }

    @Override
    public void setVhsyudisptkktuukasyu4(C_Tuukasyu pVhsyudisptkktuukasyu4) {
        vhsyudisptkktuukasyu4 = pVhsyudisptkktuukasyu4;
    }

    public C_KataKbn getVhsyudisptokyakukatakbn4() {
        return vhsyudisptokyakukatakbn4;
    }

    @Override
    public void setVhsyudisptokyakukatakbn4(C_KataKbn pVhsyudisptokyakukatakbn4) {
        vhsyudisptokyakukatakbn4 = pVhsyudisptokyakukatakbn4;
    }

    public C_KyhgndkataKbn getVhsyudisptkkyhgdkatakbn4() {
        return vhsyudisptkkyhgdkatakbn4;
    }

    @Override
    public void setVhsyudisptkkyhgdkatakbn4(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn4) {
        vhsyudisptkkyhgdkatakbn4 = pVhsyudisptkkyhgdkatakbn4;
    }

    public Integer getVhsyudisptkhhknnen4() {
        return vhsyudisptkhhknnen4;
    }

    @Override
    public void setVhsyudisptkhhknnen4(Integer pVhsyudisptkhhknnen4) {
        vhsyudisptkhhknnen4 = pVhsyudisptkhhknnen4;
    }

    public BizDate getVhsyudisptkkykymd4() {
        return vhsyudisptkkykymd4;
    }

    @Override
    public void setVhsyudisptkkykymd4(BizDate pVhsyudisptkkykymd4) {
        vhsyudisptkkykymd4 = pVhsyudisptkkykymd4;
    }

    public BizDate getVhsyudisptksknnkaisiymd4() {
        return vhsyudisptksknnkaisiymd4;
    }

    @Override
    public void setVhsyudisptksknnkaisiymd4(BizDate pVhsyudisptksknnkaisiymd4) {
        vhsyudisptksknnkaisiymd4 = pVhsyudisptksknnkaisiymd4;
    }

    public BizDate getVhsyudisptkgaskkaisiymd4() {
        return vhsyudisptkgaskkaisiymd4;
    }

    @Override
    public void setVhsyudisptkgaskkaisiymd4(BizDate pVhsyudisptkgaskkaisiymd4) {
        vhsyudisptkgaskkaisiymd4 = pVhsyudisptkgaskkaisiymd4;
    }

    public BizDate getVhsyudisptkhkskkaisiymd4() {
        return vhsyudisptkhkskkaisiymd4;
    }

    @Override
    public void setVhsyudisptkhkskkaisiymd4(BizDate pVhsyudisptkhkskkaisiymd4) {
        vhsyudisptkhkskkaisiymd4 = pVhsyudisptkhkskkaisiymd4;
    }

    public BizDate getVhsyudisptkhkgskksiymd4() {
        return vhsyudisptkhkgskksiymd4;
    }

    @Override
    public void setVhsyudisptkhkgskksiymd4(BizDate pVhsyudisptkhkgskksiymd4) {
        vhsyudisptkhkgskksiymd4 = pVhsyudisptkhkgskksiymd4;
    }

    public Integer getVhsyudisptkhknkkn4() {
        return vhsyudisptkhknkkn4;
    }

    @Override
    public void setVhsyudisptkhknkkn4(Integer pVhsyudisptkhknkkn4) {
        vhsyudisptkhknkkn4 = pVhsyudisptkhknkkn4;
    }

    public C_HknkknsmnKbn getVhsyudisptkhknkknsmnkbn4() {
        return vhsyudisptkhknkknsmnkbn4;
    }

    @Override
    public void setVhsyudisptkhknkknsmnkbn4(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn4) {
        vhsyudisptkhknkknsmnkbn4 = pVhsyudisptkhknkknsmnkbn4;
    }

    public Integer getVhsyudisptkhrkkkn4() {
        return vhsyudisptkhrkkkn4;
    }

    @Override
    public void setVhsyudisptkhrkkkn4(Integer pVhsyudisptkhrkkkn4) {
        vhsyudisptkhrkkkn4 = pVhsyudisptkhrkkkn4;
    }

    public C_HrkkknsmnKbn getVhsyudisptkhrkkknsmnkbn4() {
        return vhsyudisptkhrkkknsmnkbn4;
    }

    @Override
    public void setVhsyudisptkhrkkknsmnkbn4(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn4) {
        vhsyudisptkhrkkknsmnkbn4 = pVhsyudisptkhrkkknsmnkbn4;
    }

    public C_KihonssyuruiKbn getVhsyudisptkkihsyuruikbn4() {
        return vhsyudisptkkihsyuruikbn4;
    }

    @Override
    public void setVhsyudisptkkihsyuruikbn4(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn4) {
        vhsyudisptkkihsyuruikbn4 = pVhsyudisptkkihsyuruikbn4;
    }

    public BizCurrency getVhsyudisptkkihons4() {
        return vhsyudisptkkihons4;
    }

    @Override
    public void setVhsyudisptkkihons4(BizCurrency pVhsyudisptkkihons4) {
        vhsyudisptkkihons4 = pVhsyudisptkkihons4;
    }

    public BizCurrency getVhsyudisptkp4() {
        return vhsyudisptkp4;
    }

    @Override
    public void setVhsyudisptkp4(BizCurrency pVhsyudisptkp4) {
        vhsyudisptkp4 = pVhsyudisptkp4;
    }

    public BizCurrency getVhsyudisptkkihonkyhgk4() {
        return vhsyudisptkkihonkyhgk4;
    }

    @Override
    public void setVhsyudisptkkihonkyhgk4(BizCurrency pVhsyudisptkkihonkyhgk4) {
        vhsyudisptkkihonkyhgk4 = pVhsyudisptkkihonkyhgk4;
    }

    public BizCurrency getVhsyudisptknextkosgop4() {
        return vhsyudisptknextkosgop4;
    }

    @Override
    public void setVhsyudisptknextkosgop4(BizCurrency pVhsyudisptknextkosgop4) {
        vhsyudisptknextkosgop4 = pVhsyudisptknextkosgop4;
    }

    public C_SyukyhkinkataKbn getVhsyudisptksykyhkatakbn4() {
        return vhsyudisptksykyhkatakbn4;
    }

    @Override
    public void setVhsyudisptksykyhkatakbn4(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn4) {
        vhsyudisptksykyhkatakbn4 = pVhsyudisptksykyhkatakbn4;
    }

    public C_6daiLdKbn getVhsyudisptk6daildkbn4() {
        return vhsyudisptk6daildkbn4;
    }

    @Override
    public void setVhsyudisptk6daildkbn4(C_6daiLdKbn pVhsyudisptk6daildkbn4) {
        vhsyudisptk6daildkbn4 = pVhsyudisptk6daildkbn4;
    }

    public BizCurrency getVhsyudisptkganyukyhntgk4() {
        return vhsyudisptkganyukyhntgk4;
    }

    @Override
    public void setVhsyudisptkganyukyhntgk4(BizCurrency pVhsyudisptkganyukyhntgk4) {
        vhsyudisptkganyukyhntgk4 = pVhsyudisptkganyukyhntgk4;
    }

    public BizDate getVhsyudisptkshrskgstrymd4() {
        return vhsyudisptkshrskgstrymd4;
    }

    @Override
    public void setVhsyudisptkshrskgstrymd4(BizDate pVhsyudisptkshrskgstrymd4) {
        vhsyudisptkshrskgstrymd4 = pVhsyudisptkshrskgstrymd4;
    }

    public BizDate getVhsyudisptkshrskgnedymd4() {
        return vhsyudisptkshrskgnedymd4;
    }

    @Override
    public void setVhsyudisptkshrskgnedymd4(BizDate pVhsyudisptkshrskgnedymd4) {
        vhsyudisptkshrskgnedymd4 = pVhsyudisptkshrskgnedymd4;
    }

    public BizCurrency getVhsyudisptkshrskgngos4() {
        return vhsyudisptkshrskgngos4;
    }

    @Override
    public void setVhsyudisptkshrskgngos4(BizCurrency pVhsyudisptkshrskgngos4) {
        vhsyudisptkshrskgngos4 = pVhsyudisptkshrskgngos4;
    }

    public C_Nenkinsyu getVhsyudisptknenkinsyukbn4() {
        return vhsyudisptknenkinsyukbn4;
    }

    @Override
    public void setVhsyudisptknenkinsyukbn4(C_Nenkinsyu pVhsyudisptknenkinsyukbn4) {
        vhsyudisptknenkinsyukbn4 = pVhsyudisptknenkinsyukbn4;
    }

    public Integer getVhsyudisptknenkinkkn4() {
        return vhsyudisptknenkinkkn4;
    }

    @Override
    public void setVhsyudisptknenkinkkn4(Integer pVhsyudisptknenkinkkn4) {
        vhsyudisptknenkinkkn4 = pVhsyudisptknenkinkkn4;
    }

    public C_Tkjyskgnkkn getVhsyudisptktkjyskgnkkn4() {
        return vhsyudisptktkjyskgnkkn4;
    }

    @Override
    public void setVhsyudisptktkjyskgnkkn4(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn4) {
        vhsyudisptktkjyskgnkkn4 = pVhsyudisptktkjyskgnkkn4;
    }

    public BizDate getVhsyudisptktkjkhkdsymd14() {
        return vhsyudisptktkjkhkdsymd14;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd14(BizDate pVhsyudisptktkjkhkdsymd14) {
        vhsyudisptktkjkhkdsymd14 = pVhsyudisptktkjkhkdsymd14;
    }

    public BizDate getVhsyudisptktkjkhkdeymd14() {
        return vhsyudisptktkjkhkdeymd14;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd14(BizDate pVhsyudisptktkjkhkdeymd14) {
        vhsyudisptktkjkhkdeymd14 = pVhsyudisptktkjkhkdeymd14;
    }

    public BizCurrency getVhsyudisptktkjyskgns14() {
        return vhsyudisptktkjyskgns14;
    }

    @Override
    public void setVhsyudisptktkjyskgns14(BizCurrency pVhsyudisptktkjyskgns14) {
        vhsyudisptktkjyskgns14 = pVhsyudisptktkjyskgns14;
    }

    public BizDate getVhsyudisptktkjkhkdsymd24() {
        return vhsyudisptktkjkhkdsymd24;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd24(BizDate pVhsyudisptktkjkhkdsymd24) {
        vhsyudisptktkjkhkdsymd24 = pVhsyudisptktkjkhkdsymd24;
    }

    public BizDate getVhsyudisptktkjkhkdeymd24() {
        return vhsyudisptktkjkhkdeymd24;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd24(BizDate pVhsyudisptktkjkhkdeymd24) {
        vhsyudisptktkjkhkdeymd24 = pVhsyudisptktkjkhkdeymd24;
    }

    public BizCurrency getVhsyudisptktkjyskgns24() {
        return vhsyudisptktkjyskgns24;
    }

    @Override
    public void setVhsyudisptktkjyskgns24(BizCurrency pVhsyudisptktkjyskgns24) {
        vhsyudisptktkjyskgns24 = pVhsyudisptktkjyskgns24;
    }

    public BizDate getVhsyudisptktkjkhkdsymd34() {
        return vhsyudisptktkjkhkdsymd34;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd34(BizDate pVhsyudisptktkjkhkdsymd34) {
        vhsyudisptktkjkhkdsymd34 = pVhsyudisptktkjkhkdsymd34;
    }

    public BizDate getVhsyudisptktkjkhkdeymd34() {
        return vhsyudisptktkjkhkdeymd34;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd34(BizDate pVhsyudisptktkjkhkdeymd34) {
        vhsyudisptktkjkhkdeymd34 = pVhsyudisptktkjkhkdeymd34;
    }

    public BizCurrency getVhsyudisptktkjyskgns34() {
        return vhsyudisptktkjyskgns34;
    }

    @Override
    public void setVhsyudisptktkjyskgns34(BizCurrency pVhsyudisptktkjyskgns34) {
        vhsyudisptktkjyskgns34 = pVhsyudisptktkjyskgns34;
    }

    public BizDate getVhsyudisptktkjkhkdsymd44() {
        return vhsyudisptktkjkhkdsymd44;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd44(BizDate pVhsyudisptktkjkhkdsymd44) {
        vhsyudisptktkjkhkdsymd44 = pVhsyudisptktkjkhkdsymd44;
    }

    public BizDate getVhsyudisptktkjkhkdeymd44() {
        return vhsyudisptktkjkhkdeymd44;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd44(BizDate pVhsyudisptktkjkhkdeymd44) {
        vhsyudisptktkjkhkdeymd44 = pVhsyudisptktkjkhkdeymd44;
    }

    public BizCurrency getVhsyudisptktkjyskgns44() {
        return vhsyudisptktkjyskgns44;
    }

    @Override
    public void setVhsyudisptktkjyskgns44(BizCurrency pVhsyudisptktkjyskgns44) {
        vhsyudisptktkjyskgns44 = pVhsyudisptktkjyskgns44;
    }

    public BizDate getVhsyudisptktkjkhkdsymd54() {
        return vhsyudisptktkjkhkdsymd54;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd54(BizDate pVhsyudisptktkjkhkdsymd54) {
        vhsyudisptktkjkhkdsymd54 = pVhsyudisptktkjkhkdsymd54;
    }

    public BizDate getVhsyudisptktkjkhkdeymd54() {
        return vhsyudisptktkjkhkdeymd54;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd54(BizDate pVhsyudisptktkjkhkdeymd54) {
        vhsyudisptktkjkhkdeymd54 = pVhsyudisptktkjkhkdeymd54;
    }

    public BizCurrency getVhsyudisptktkjyskgns54() {
        return vhsyudisptktkjyskgns54;
    }

    @Override
    public void setVhsyudisptktkjyskgns54(BizCurrency pVhsyudisptktkjyskgns54) {
        vhsyudisptktkjyskgns54 = pVhsyudisptktkjyskgns54;
    }

    public C_Tkjyhyouten getVhsyudisptktkjyhyouten4() {
        return vhsyudisptktkjyhyouten4;
    }

    @Override
    public void setVhsyudisptktkjyhyouten4(C_Tkjyhyouten pVhsyudisptktkjyhyouten4) {
        vhsyudisptktkjyhyouten4 = pVhsyudisptktkjyhyouten4;
    }

    public BizCurrency getVhsyudisptktkjyp4() {
        return vhsyudisptktkjyp4;
    }

    @Override
    public void setVhsyudisptktkjyp4(BizCurrency pVhsyudisptktkjyp4) {
        vhsyudisptktkjyp4 = pVhsyudisptktkjyp4;
    }

    public String getVhsyudisptkhtnpbuicd14() {
        return vhsyudisptkhtnpbuicd14;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd14(String pVhsyudisptkhtnpbuicd14) {
        vhsyudisptkhtnpbuicd14 = pVhsyudisptkhtnpbuicd14;
    }

    public String getVhsyudisptkhtnpbuinm14() {
        return vhsyudisptkhtnpbuinm14;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm14(String pVhsyudisptkhtnpbuinm14) {
        vhsyudisptkhtnpbuinm14 = pVhsyudisptkhtnpbuinm14;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn14() {
        return vhsyudisptkhtnpkkn14;
    }

    @Override
    public void setVhsyudisptkhtnpkkn14(C_Htnpkkn pVhsyudisptkhtnpkkn14) {
        vhsyudisptkhtnpkkn14 = pVhsyudisptkhtnpkkn14;
    }

    public String getVhsyudisptkhtnpbuicd24() {
        return vhsyudisptkhtnpbuicd24;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd24(String pVhsyudisptkhtnpbuicd24) {
        vhsyudisptkhtnpbuicd24 = pVhsyudisptkhtnpbuicd24;
    }

    public String getVhsyudisptkhtnpbuinm24() {
        return vhsyudisptkhtnpbuinm24;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm24(String pVhsyudisptkhtnpbuinm24) {
        vhsyudisptkhtnpbuinm24 = pVhsyudisptkhtnpbuinm24;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn24() {
        return vhsyudisptkhtnpkkn24;
    }

    @Override
    public void setVhsyudisptkhtnpkkn24(C_Htnpkkn pVhsyudisptkhtnpkkn24) {
        vhsyudisptkhtnpkkn24 = pVhsyudisptkhtnpkkn24;
    }

    public String getVhsyudisptkhtnpbuicd34() {
        return vhsyudisptkhtnpbuicd34;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd34(String pVhsyudisptkhtnpbuicd34) {
        vhsyudisptkhtnpbuicd34 = pVhsyudisptkhtnpbuicd34;
    }

    public String getVhsyudisptkhtnpbuinm34() {
        return vhsyudisptkhtnpbuinm34;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm34(String pVhsyudisptkhtnpbuinm34) {
        vhsyudisptkhtnpbuinm34 = pVhsyudisptkhtnpbuinm34;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn34() {
        return vhsyudisptkhtnpkkn34;
    }

    @Override
    public void setVhsyudisptkhtnpkkn34(C_Htnpkkn pVhsyudisptkhtnpkkn34) {
        vhsyudisptkhtnpkkn34 = pVhsyudisptkhtnpkkn34;
    }

    public String getVhsyudisptkhtnpbuicd44() {
        return vhsyudisptkhtnpbuicd44;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd44(String pVhsyudisptkhtnpbuicd44) {
        vhsyudisptkhtnpbuicd44 = pVhsyudisptkhtnpbuicd44;
    }

    public String getVhsyudisptkhtnpbuinm44() {
        return vhsyudisptkhtnpbuinm44;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm44(String pVhsyudisptkhtnpbuinm44) {
        vhsyudisptkhtnpbuinm44 = pVhsyudisptkhtnpbuinm44;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn44() {
        return vhsyudisptkhtnpkkn44;
    }

    @Override
    public void setVhsyudisptkhtnpkkn44(C_Htnpkkn pVhsyudisptkhtnpkkn44) {
        vhsyudisptkhtnpkkn44 = pVhsyudisptkhtnpkkn44;
    }

    public C_TokkoudosghtnpKbn getVhsyudisptktkkdsghtpkbn4() {
        return vhsyudisptktkkdsghtpkbn4;
    }

    @Override
    public void setVhsyudisptktkkdsghtpkbn4(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn4) {
        vhsyudisptktkkdsghtpkbn4 = pVhsyudisptktkkdsghtpkbn4;
    }

    public BizCurrency getVhsyudisptktutakngk4() {
        return vhsyudisptktutakngk4;
    }

    @Override
    public void setVhsyudisptktutakngk4(BizCurrency pVhsyudisptktutakngk4) {
        vhsyudisptktutakngk4 = pVhsyudisptktutakngk4;
    }

    public BizDate getVhsyudisptkkrkhasseiymd4() {
        return vhsyudisptkkrkhasseiymd4;
    }

    @Override
    public void setVhsyudisptkkrkhasseiymd4(BizDate pVhsyudisptkkrkhasseiymd4) {
        vhsyudisptkkrkhasseiymd4 = pVhsyudisptkkrkhasseiymd4;
    }

    public String getVhsyudisptksyouhnnm5() {
        return vhsyudisptksyouhnnm5;
    }

    @Override
    public void setVhsyudisptksyouhnnm5(String pVhsyudisptksyouhnnm5) {
        vhsyudisptksyouhnnm5 = pVhsyudisptksyouhnnm5;
    }

    public C_Tuukasyu getVhsyudisptkktuukasyu5() {
        return vhsyudisptkktuukasyu5;
    }

    @Override
    public void setVhsyudisptkktuukasyu5(C_Tuukasyu pVhsyudisptkktuukasyu5) {
        vhsyudisptkktuukasyu5 = pVhsyudisptkktuukasyu5;
    }

    public C_KataKbn getVhsyudisptokyakukatakbn5() {
        return vhsyudisptokyakukatakbn5;
    }

    @Override
    public void setVhsyudisptokyakukatakbn5(C_KataKbn pVhsyudisptokyakukatakbn5) {
        vhsyudisptokyakukatakbn5 = pVhsyudisptokyakukatakbn5;
    }

    public C_KyhgndkataKbn getVhsyudisptkkyhgdkatakbn5() {
        return vhsyudisptkkyhgdkatakbn5;
    }

    @Override
    public void setVhsyudisptkkyhgdkatakbn5(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn5) {
        vhsyudisptkkyhgdkatakbn5 = pVhsyudisptkkyhgdkatakbn5;
    }

    public Integer getVhsyudisptkhhknnen5() {
        return vhsyudisptkhhknnen5;
    }

    @Override
    public void setVhsyudisptkhhknnen5(Integer pVhsyudisptkhhknnen5) {
        vhsyudisptkhhknnen5 = pVhsyudisptkhhknnen5;
    }

    public BizDate getVhsyudisptkkykymd5() {
        return vhsyudisptkkykymd5;
    }

    @Override
    public void setVhsyudisptkkykymd5(BizDate pVhsyudisptkkykymd5) {
        vhsyudisptkkykymd5 = pVhsyudisptkkykymd5;
    }

    public BizDate getVhsyudisptksknnkaisiymd5() {
        return vhsyudisptksknnkaisiymd5;
    }

    @Override
    public void setVhsyudisptksknnkaisiymd5(BizDate pVhsyudisptksknnkaisiymd5) {
        vhsyudisptksknnkaisiymd5 = pVhsyudisptksknnkaisiymd5;
    }

    public BizDate getVhsyudisptkgaskkaisiymd5() {
        return vhsyudisptkgaskkaisiymd5;
    }

    @Override
    public void setVhsyudisptkgaskkaisiymd5(BizDate pVhsyudisptkgaskkaisiymd5) {
        vhsyudisptkgaskkaisiymd5 = pVhsyudisptkgaskkaisiymd5;
    }

    public BizDate getVhsyudisptkhkskkaisiymd5() {
        return vhsyudisptkhkskkaisiymd5;
    }

    @Override
    public void setVhsyudisptkhkskkaisiymd5(BizDate pVhsyudisptkhkskkaisiymd5) {
        vhsyudisptkhkskkaisiymd5 = pVhsyudisptkhkskkaisiymd5;
    }

    public BizDate getVhsyudisptkhkgskksiymd5() {
        return vhsyudisptkhkgskksiymd5;
    }

    @Override
    public void setVhsyudisptkhkgskksiymd5(BizDate pVhsyudisptkhkgskksiymd5) {
        vhsyudisptkhkgskksiymd5 = pVhsyudisptkhkgskksiymd5;
    }

    public Integer getVhsyudisptkhknkkn5() {
        return vhsyudisptkhknkkn5;
    }

    @Override
    public void setVhsyudisptkhknkkn5(Integer pVhsyudisptkhknkkn5) {
        vhsyudisptkhknkkn5 = pVhsyudisptkhknkkn5;
    }

    public C_HknkknsmnKbn getVhsyudisptkhknkknsmnkbn5() {
        return vhsyudisptkhknkknsmnkbn5;
    }

    @Override
    public void setVhsyudisptkhknkknsmnkbn5(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn5) {
        vhsyudisptkhknkknsmnkbn5 = pVhsyudisptkhknkknsmnkbn5;
    }

    public Integer getVhsyudisptkhrkkkn5() {
        return vhsyudisptkhrkkkn5;
    }

    @Override
    public void setVhsyudisptkhrkkkn5(Integer pVhsyudisptkhrkkkn5) {
        vhsyudisptkhrkkkn5 = pVhsyudisptkhrkkkn5;
    }

    public C_HrkkknsmnKbn getVhsyudisptkhrkkknsmnkbn5() {
        return vhsyudisptkhrkkknsmnkbn5;
    }

    @Override
    public void setVhsyudisptkhrkkknsmnkbn5(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn5) {
        vhsyudisptkhrkkknsmnkbn5 = pVhsyudisptkhrkkknsmnkbn5;
    }

    public C_KihonssyuruiKbn getVhsyudisptkkihsyuruikbn5() {
        return vhsyudisptkkihsyuruikbn5;
    }

    @Override
    public void setVhsyudisptkkihsyuruikbn5(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn5) {
        vhsyudisptkkihsyuruikbn5 = pVhsyudisptkkihsyuruikbn5;
    }

    public BizCurrency getVhsyudisptkkihons5() {
        return vhsyudisptkkihons5;
    }

    @Override
    public void setVhsyudisptkkihons5(BizCurrency pVhsyudisptkkihons5) {
        vhsyudisptkkihons5 = pVhsyudisptkkihons5;
    }

    public BizCurrency getVhsyudisptkp5() {
        return vhsyudisptkp5;
    }

    @Override
    public void setVhsyudisptkp5(BizCurrency pVhsyudisptkp5) {
        vhsyudisptkp5 = pVhsyudisptkp5;
    }

    public BizCurrency getVhsyudisptkkihonkyhgk5() {
        return vhsyudisptkkihonkyhgk5;
    }

    @Override
    public void setVhsyudisptkkihonkyhgk5(BizCurrency pVhsyudisptkkihonkyhgk5) {
        vhsyudisptkkihonkyhgk5 = pVhsyudisptkkihonkyhgk5;
    }

    public BizCurrency getVhsyudisptknextkosgop5() {
        return vhsyudisptknextkosgop5;
    }

    @Override
    public void setVhsyudisptknextkosgop5(BizCurrency pVhsyudisptknextkosgop5) {
        vhsyudisptknextkosgop5 = pVhsyudisptknextkosgop5;
    }

    public C_SyukyhkinkataKbn getVhsyudisptksykyhkatakbn5() {
        return vhsyudisptksykyhkatakbn5;
    }

    @Override
    public void setVhsyudisptksykyhkatakbn5(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn5) {
        vhsyudisptksykyhkatakbn5 = pVhsyudisptksykyhkatakbn5;
    }

    public C_6daiLdKbn getVhsyudisptk6daildkbn5() {
        return vhsyudisptk6daildkbn5;
    }

    @Override
    public void setVhsyudisptk6daildkbn5(C_6daiLdKbn pVhsyudisptk6daildkbn5) {
        vhsyudisptk6daildkbn5 = pVhsyudisptk6daildkbn5;
    }

    public BizCurrency getVhsyudisptkganyukyhntgk5() {
        return vhsyudisptkganyukyhntgk5;
    }

    @Override
    public void setVhsyudisptkganyukyhntgk5(BizCurrency pVhsyudisptkganyukyhntgk5) {
        vhsyudisptkganyukyhntgk5 = pVhsyudisptkganyukyhntgk5;
    }

    public BizDate getVhsyudisptkshrskgstrymd5() {
        return vhsyudisptkshrskgstrymd5;
    }

    @Override
    public void setVhsyudisptkshrskgstrymd5(BizDate pVhsyudisptkshrskgstrymd5) {
        vhsyudisptkshrskgstrymd5 = pVhsyudisptkshrskgstrymd5;
    }

    public BizDate getVhsyudisptkshrskgnedymd5() {
        return vhsyudisptkshrskgnedymd5;
    }

    @Override
    public void setVhsyudisptkshrskgnedymd5(BizDate pVhsyudisptkshrskgnedymd5) {
        vhsyudisptkshrskgnedymd5 = pVhsyudisptkshrskgnedymd5;
    }

    public BizCurrency getVhsyudisptkshrskgngos5() {
        return vhsyudisptkshrskgngos5;
    }

    @Override
    public void setVhsyudisptkshrskgngos5(BizCurrency pVhsyudisptkshrskgngos5) {
        vhsyudisptkshrskgngos5 = pVhsyudisptkshrskgngos5;
    }

    public C_Nenkinsyu getVhsyudisptknenkinsyukbn5() {
        return vhsyudisptknenkinsyukbn5;
    }

    @Override
    public void setVhsyudisptknenkinsyukbn5(C_Nenkinsyu pVhsyudisptknenkinsyukbn5) {
        vhsyudisptknenkinsyukbn5 = pVhsyudisptknenkinsyukbn5;
    }

    public Integer getVhsyudisptknenkinkkn5() {
        return vhsyudisptknenkinkkn5;
    }

    @Override
    public void setVhsyudisptknenkinkkn5(Integer pVhsyudisptknenkinkkn5) {
        vhsyudisptknenkinkkn5 = pVhsyudisptknenkinkkn5;
    }

    public C_Tkjyskgnkkn getVhsyudisptktkjyskgnkkn5() {
        return vhsyudisptktkjyskgnkkn5;
    }

    @Override
    public void setVhsyudisptktkjyskgnkkn5(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn5) {
        vhsyudisptktkjyskgnkkn5 = pVhsyudisptktkjyskgnkkn5;
    }

    public BizDate getVhsyudisptktkjkhkdsymd15() {
        return vhsyudisptktkjkhkdsymd15;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd15(BizDate pVhsyudisptktkjkhkdsymd15) {
        vhsyudisptktkjkhkdsymd15 = pVhsyudisptktkjkhkdsymd15;
    }

    public BizDate getVhsyudisptktkjkhkdeymd15() {
        return vhsyudisptktkjkhkdeymd15;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd15(BizDate pVhsyudisptktkjkhkdeymd15) {
        vhsyudisptktkjkhkdeymd15 = pVhsyudisptktkjkhkdeymd15;
    }

    public BizCurrency getVhsyudisptktkjyskgns15() {
        return vhsyudisptktkjyskgns15;
    }

    @Override
    public void setVhsyudisptktkjyskgns15(BizCurrency pVhsyudisptktkjyskgns15) {
        vhsyudisptktkjyskgns15 = pVhsyudisptktkjyskgns15;
    }

    public BizDate getVhsyudisptktkjkhkdsymd25() {
        return vhsyudisptktkjkhkdsymd25;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd25(BizDate pVhsyudisptktkjkhkdsymd25) {
        vhsyudisptktkjkhkdsymd25 = pVhsyudisptktkjkhkdsymd25;
    }

    public BizDate getVhsyudisptktkjkhkdeymd25() {
        return vhsyudisptktkjkhkdeymd25;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd25(BizDate pVhsyudisptktkjkhkdeymd25) {
        vhsyudisptktkjkhkdeymd25 = pVhsyudisptktkjkhkdeymd25;
    }

    public BizCurrency getVhsyudisptktkjyskgns25() {
        return vhsyudisptktkjyskgns25;
    }

    @Override
    public void setVhsyudisptktkjyskgns25(BizCurrency pVhsyudisptktkjyskgns25) {
        vhsyudisptktkjyskgns25 = pVhsyudisptktkjyskgns25;
    }

    public BizDate getVhsyudisptktkjkhkdsymd35() {
        return vhsyudisptktkjkhkdsymd35;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd35(BizDate pVhsyudisptktkjkhkdsymd35) {
        vhsyudisptktkjkhkdsymd35 = pVhsyudisptktkjkhkdsymd35;
    }

    public BizDate getVhsyudisptktkjkhkdeymd35() {
        return vhsyudisptktkjkhkdeymd35;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd35(BizDate pVhsyudisptktkjkhkdeymd35) {
        vhsyudisptktkjkhkdeymd35 = pVhsyudisptktkjkhkdeymd35;
    }

    public BizCurrency getVhsyudisptktkjyskgns35() {
        return vhsyudisptktkjyskgns35;
    }

    @Override
    public void setVhsyudisptktkjyskgns35(BizCurrency pVhsyudisptktkjyskgns35) {
        vhsyudisptktkjyskgns35 = pVhsyudisptktkjyskgns35;
    }

    public BizDate getVhsyudisptktkjkhkdsymd45() {
        return vhsyudisptktkjkhkdsymd45;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd45(BizDate pVhsyudisptktkjkhkdsymd45) {
        vhsyudisptktkjkhkdsymd45 = pVhsyudisptktkjkhkdsymd45;
    }

    public BizDate getVhsyudisptktkjkhkdeymd45() {
        return vhsyudisptktkjkhkdeymd45;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd45(BizDate pVhsyudisptktkjkhkdeymd45) {
        vhsyudisptktkjkhkdeymd45 = pVhsyudisptktkjkhkdeymd45;
    }

    public BizCurrency getVhsyudisptktkjyskgns45() {
        return vhsyudisptktkjyskgns45;
    }

    @Override
    public void setVhsyudisptktkjyskgns45(BizCurrency pVhsyudisptktkjyskgns45) {
        vhsyudisptktkjyskgns45 = pVhsyudisptktkjyskgns45;
    }

    public BizDate getVhsyudisptktkjkhkdsymd55() {
        return vhsyudisptktkjkhkdsymd55;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd55(BizDate pVhsyudisptktkjkhkdsymd55) {
        vhsyudisptktkjkhkdsymd55 = pVhsyudisptktkjkhkdsymd55;
    }

    public BizDate getVhsyudisptktkjkhkdeymd55() {
        return vhsyudisptktkjkhkdeymd55;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd55(BizDate pVhsyudisptktkjkhkdeymd55) {
        vhsyudisptktkjkhkdeymd55 = pVhsyudisptktkjkhkdeymd55;
    }

    public BizCurrency getVhsyudisptktkjyskgns55() {
        return vhsyudisptktkjyskgns55;
    }

    @Override
    public void setVhsyudisptktkjyskgns55(BizCurrency pVhsyudisptktkjyskgns55) {
        vhsyudisptktkjyskgns55 = pVhsyudisptktkjyskgns55;
    }

    public C_Tkjyhyouten getVhsyudisptktkjyhyouten5() {
        return vhsyudisptktkjyhyouten5;
    }

    @Override
    public void setVhsyudisptktkjyhyouten5(C_Tkjyhyouten pVhsyudisptktkjyhyouten5) {
        vhsyudisptktkjyhyouten5 = pVhsyudisptktkjyhyouten5;
    }

    public BizCurrency getVhsyudisptktkjyp5() {
        return vhsyudisptktkjyp5;
    }

    @Override
    public void setVhsyudisptktkjyp5(BizCurrency pVhsyudisptktkjyp5) {
        vhsyudisptktkjyp5 = pVhsyudisptktkjyp5;
    }

    public String getVhsyudisptkhtnpbuicd15() {
        return vhsyudisptkhtnpbuicd15;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd15(String pVhsyudisptkhtnpbuicd15) {
        vhsyudisptkhtnpbuicd15 = pVhsyudisptkhtnpbuicd15;
    }

    public String getVhsyudisptkhtnpbuinm15() {
        return vhsyudisptkhtnpbuinm15;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm15(String pVhsyudisptkhtnpbuinm15) {
        vhsyudisptkhtnpbuinm15 = pVhsyudisptkhtnpbuinm15;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn15() {
        return vhsyudisptkhtnpkkn15;
    }

    @Override
    public void setVhsyudisptkhtnpkkn15(C_Htnpkkn pVhsyudisptkhtnpkkn15) {
        vhsyudisptkhtnpkkn15 = pVhsyudisptkhtnpkkn15;
    }

    public String getVhsyudisptkhtnpbuicd25() {
        return vhsyudisptkhtnpbuicd25;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd25(String pVhsyudisptkhtnpbuicd25) {
        vhsyudisptkhtnpbuicd25 = pVhsyudisptkhtnpbuicd25;
    }

    public String getVhsyudisptkhtnpbuinm25() {
        return vhsyudisptkhtnpbuinm25;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm25(String pVhsyudisptkhtnpbuinm25) {
        vhsyudisptkhtnpbuinm25 = pVhsyudisptkhtnpbuinm25;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn25() {
        return vhsyudisptkhtnpkkn25;
    }

    @Override
    public void setVhsyudisptkhtnpkkn25(C_Htnpkkn pVhsyudisptkhtnpkkn25) {
        vhsyudisptkhtnpkkn25 = pVhsyudisptkhtnpkkn25;
    }

    public String getVhsyudisptkhtnpbuicd35() {
        return vhsyudisptkhtnpbuicd35;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd35(String pVhsyudisptkhtnpbuicd35) {
        vhsyudisptkhtnpbuicd35 = pVhsyudisptkhtnpbuicd35;
    }

    public String getVhsyudisptkhtnpbuinm35() {
        return vhsyudisptkhtnpbuinm35;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm35(String pVhsyudisptkhtnpbuinm35) {
        vhsyudisptkhtnpbuinm35 = pVhsyudisptkhtnpbuinm35;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn35() {
        return vhsyudisptkhtnpkkn35;
    }

    @Override
    public void setVhsyudisptkhtnpkkn35(C_Htnpkkn pVhsyudisptkhtnpkkn35) {
        vhsyudisptkhtnpkkn35 = pVhsyudisptkhtnpkkn35;
    }

    public String getVhsyudisptkhtnpbuicd45() {
        return vhsyudisptkhtnpbuicd45;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd45(String pVhsyudisptkhtnpbuicd45) {
        vhsyudisptkhtnpbuicd45 = pVhsyudisptkhtnpbuicd45;
    }

    public String getVhsyudisptkhtnpbuinm45() {
        return vhsyudisptkhtnpbuinm45;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm45(String pVhsyudisptkhtnpbuinm45) {
        vhsyudisptkhtnpbuinm45 = pVhsyudisptkhtnpbuinm45;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn45() {
        return vhsyudisptkhtnpkkn45;
    }

    @Override
    public void setVhsyudisptkhtnpkkn45(C_Htnpkkn pVhsyudisptkhtnpkkn45) {
        vhsyudisptkhtnpkkn45 = pVhsyudisptkhtnpkkn45;
    }

    public C_TokkoudosghtnpKbn getVhsyudisptktkkdsghtpkbn5() {
        return vhsyudisptktkkdsghtpkbn5;
    }

    @Override
    public void setVhsyudisptktkkdsghtpkbn5(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn5) {
        vhsyudisptktkkdsghtpkbn5 = pVhsyudisptktkkdsghtpkbn5;
    }

    public BizCurrency getVhsyudisptktutakngk5() {
        return vhsyudisptktutakngk5;
    }

    @Override
    public void setVhsyudisptktutakngk5(BizCurrency pVhsyudisptktutakngk5) {
        vhsyudisptktutakngk5 = pVhsyudisptktutakngk5;
    }

    public BizDate getVhsyudisptkkrkhasseiymd5() {
        return vhsyudisptkkrkhasseiymd5;
    }

    @Override
    public void setVhsyudisptkkrkhasseiymd5(BizDate pVhsyudisptkkrkhasseiymd5) {
        vhsyudisptkkrkhasseiymd5 = pVhsyudisptkkrkhasseiymd5;
    }

    public String getVhsyudisptksyouhnnm6() {
        return vhsyudisptksyouhnnm6;
    }

    @Override
    public void setVhsyudisptksyouhnnm6(String pVhsyudisptksyouhnnm6) {
        vhsyudisptksyouhnnm6 = pVhsyudisptksyouhnnm6;
    }

    public C_Tuukasyu getVhsyudisptkktuukasyu6() {
        return vhsyudisptkktuukasyu6;
    }

    @Override
    public void setVhsyudisptkktuukasyu6(C_Tuukasyu pVhsyudisptkktuukasyu6) {
        vhsyudisptkktuukasyu6 = pVhsyudisptkktuukasyu6;
    }

    public C_KataKbn getVhsyudisptokyakukatakbn6() {
        return vhsyudisptokyakukatakbn6;
    }

    @Override
    public void setVhsyudisptokyakukatakbn6(C_KataKbn pVhsyudisptokyakukatakbn6) {
        vhsyudisptokyakukatakbn6 = pVhsyudisptokyakukatakbn6;
    }

    public C_KyhgndkataKbn getVhsyudisptkkyhgdkatakbn6() {
        return vhsyudisptkkyhgdkatakbn6;
    }

    @Override
    public void setVhsyudisptkkyhgdkatakbn6(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn6) {
        vhsyudisptkkyhgdkatakbn6 = pVhsyudisptkkyhgdkatakbn6;
    }

    public Integer getVhsyudisptkhhknnen6() {
        return vhsyudisptkhhknnen6;
    }

    @Override
    public void setVhsyudisptkhhknnen6(Integer pVhsyudisptkhhknnen6) {
        vhsyudisptkhhknnen6 = pVhsyudisptkhhknnen6;
    }

    public BizDate getVhsyudisptkkykymd6() {
        return vhsyudisptkkykymd6;
    }

    @Override
    public void setVhsyudisptkkykymd6(BizDate pVhsyudisptkkykymd6) {
        vhsyudisptkkykymd6 = pVhsyudisptkkykymd6;
    }

    public BizDate getVhsyudisptksknnkaisiymd6() {
        return vhsyudisptksknnkaisiymd6;
    }

    @Override
    public void setVhsyudisptksknnkaisiymd6(BizDate pVhsyudisptksknnkaisiymd6) {
        vhsyudisptksknnkaisiymd6 = pVhsyudisptksknnkaisiymd6;
    }

    public BizDate getVhsyudisptkgaskkaisiymd6() {
        return vhsyudisptkgaskkaisiymd6;
    }

    @Override
    public void setVhsyudisptkgaskkaisiymd6(BizDate pVhsyudisptkgaskkaisiymd6) {
        vhsyudisptkgaskkaisiymd6 = pVhsyudisptkgaskkaisiymd6;
    }

    public BizDate getVhsyudisptkhkskkaisiymd6() {
        return vhsyudisptkhkskkaisiymd6;
    }

    @Override
    public void setVhsyudisptkhkskkaisiymd6(BizDate pVhsyudisptkhkskkaisiymd6) {
        vhsyudisptkhkskkaisiymd6 = pVhsyudisptkhkskkaisiymd6;
    }

    public BizDate getVhsyudisptkhkgskksiymd6() {
        return vhsyudisptkhkgskksiymd6;
    }

    @Override
    public void setVhsyudisptkhkgskksiymd6(BizDate pVhsyudisptkhkgskksiymd6) {
        vhsyudisptkhkgskksiymd6 = pVhsyudisptkhkgskksiymd6;
    }

    public Integer getVhsyudisptkhknkkn6() {
        return vhsyudisptkhknkkn6;
    }

    @Override
    public void setVhsyudisptkhknkkn6(Integer pVhsyudisptkhknkkn6) {
        vhsyudisptkhknkkn6 = pVhsyudisptkhknkkn6;
    }

    public C_HknkknsmnKbn getVhsyudisptkhknkknsmnkbn6() {
        return vhsyudisptkhknkknsmnkbn6;
    }

    @Override
    public void setVhsyudisptkhknkknsmnkbn6(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn6) {
        vhsyudisptkhknkknsmnkbn6 = pVhsyudisptkhknkknsmnkbn6;
    }

    public Integer getVhsyudisptkhrkkkn6() {
        return vhsyudisptkhrkkkn6;
    }

    @Override
    public void setVhsyudisptkhrkkkn6(Integer pVhsyudisptkhrkkkn6) {
        vhsyudisptkhrkkkn6 = pVhsyudisptkhrkkkn6;
    }

    public C_HrkkknsmnKbn getVhsyudisptkhrkkknsmnkbn6() {
        return vhsyudisptkhrkkknsmnkbn6;
    }

    @Override
    public void setVhsyudisptkhrkkknsmnkbn6(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn6) {
        vhsyudisptkhrkkknsmnkbn6 = pVhsyudisptkhrkkknsmnkbn6;
    }

    public C_KihonssyuruiKbn getVhsyudisptkkihsyuruikbn6() {
        return vhsyudisptkkihsyuruikbn6;
    }

    @Override
    public void setVhsyudisptkkihsyuruikbn6(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn6) {
        vhsyudisptkkihsyuruikbn6 = pVhsyudisptkkihsyuruikbn6;
    }

    public BizCurrency getVhsyudisptkkihons6() {
        return vhsyudisptkkihons6;
    }

    @Override
    public void setVhsyudisptkkihons6(BizCurrency pVhsyudisptkkihons6) {
        vhsyudisptkkihons6 = pVhsyudisptkkihons6;
    }

    public BizCurrency getVhsyudisptkp6() {
        return vhsyudisptkp6;
    }

    @Override
    public void setVhsyudisptkp6(BizCurrency pVhsyudisptkp6) {
        vhsyudisptkp6 = pVhsyudisptkp6;
    }

    public BizCurrency getVhsyudisptkkihonkyhgk6() {
        return vhsyudisptkkihonkyhgk6;
    }

    @Override
    public void setVhsyudisptkkihonkyhgk6(BizCurrency pVhsyudisptkkihonkyhgk6) {
        vhsyudisptkkihonkyhgk6 = pVhsyudisptkkihonkyhgk6;
    }

    public BizCurrency getVhsyudisptknextkosgop6() {
        return vhsyudisptknextkosgop6;
    }

    @Override
    public void setVhsyudisptknextkosgop6(BizCurrency pVhsyudisptknextkosgop6) {
        vhsyudisptknextkosgop6 = pVhsyudisptknextkosgop6;
    }

    public C_SyukyhkinkataKbn getVhsyudisptksykyhkatakbn6() {
        return vhsyudisptksykyhkatakbn6;
    }

    @Override
    public void setVhsyudisptksykyhkatakbn6(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn6) {
        vhsyudisptksykyhkatakbn6 = pVhsyudisptksykyhkatakbn6;
    }

    public C_6daiLdKbn getVhsyudisptk6daildkbn6() {
        return vhsyudisptk6daildkbn6;
    }

    @Override
    public void setVhsyudisptk6daildkbn6(C_6daiLdKbn pVhsyudisptk6daildkbn6) {
        vhsyudisptk6daildkbn6 = pVhsyudisptk6daildkbn6;
    }

    public BizCurrency getVhsyudisptkganyukyhntgk6() {
        return vhsyudisptkganyukyhntgk6;
    }

    @Override
    public void setVhsyudisptkganyukyhntgk6(BizCurrency pVhsyudisptkganyukyhntgk6) {
        vhsyudisptkganyukyhntgk6 = pVhsyudisptkganyukyhntgk6;
    }

    public BizDate getVhsyudisptkshrskgstrymd6() {
        return vhsyudisptkshrskgstrymd6;
    }

    @Override
    public void setVhsyudisptkshrskgstrymd6(BizDate pVhsyudisptkshrskgstrymd6) {
        vhsyudisptkshrskgstrymd6 = pVhsyudisptkshrskgstrymd6;
    }

    public BizDate getVhsyudisptkshrskgnedymd6() {
        return vhsyudisptkshrskgnedymd6;
    }

    @Override
    public void setVhsyudisptkshrskgnedymd6(BizDate pVhsyudisptkshrskgnedymd6) {
        vhsyudisptkshrskgnedymd6 = pVhsyudisptkshrskgnedymd6;
    }

    public BizCurrency getVhsyudisptkshrskgngos6() {
        return vhsyudisptkshrskgngos6;
    }

    @Override
    public void setVhsyudisptkshrskgngos6(BizCurrency pVhsyudisptkshrskgngos6) {
        vhsyudisptkshrskgngos6 = pVhsyudisptkshrskgngos6;
    }

    public C_Nenkinsyu getVhsyudisptknenkinsyukbn6() {
        return vhsyudisptknenkinsyukbn6;
    }

    @Override
    public void setVhsyudisptknenkinsyukbn6(C_Nenkinsyu pVhsyudisptknenkinsyukbn6) {
        vhsyudisptknenkinsyukbn6 = pVhsyudisptknenkinsyukbn6;
    }

    public Integer getVhsyudisptknenkinkkn6() {
        return vhsyudisptknenkinkkn6;
    }

    @Override
    public void setVhsyudisptknenkinkkn6(Integer pVhsyudisptknenkinkkn6) {
        vhsyudisptknenkinkkn6 = pVhsyudisptknenkinkkn6;
    }

    public C_Tkjyskgnkkn getVhsyudisptktkjyskgnkkn6() {
        return vhsyudisptktkjyskgnkkn6;
    }

    @Override
    public void setVhsyudisptktkjyskgnkkn6(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn6) {
        vhsyudisptktkjyskgnkkn6 = pVhsyudisptktkjyskgnkkn6;
    }

    public BizDate getVhsyudisptktkjkhkdsymd16() {
        return vhsyudisptktkjkhkdsymd16;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd16(BizDate pVhsyudisptktkjkhkdsymd16) {
        vhsyudisptktkjkhkdsymd16 = pVhsyudisptktkjkhkdsymd16;
    }

    public BizDate getVhsyudisptktkjkhkdeymd16() {
        return vhsyudisptktkjkhkdeymd16;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd16(BizDate pVhsyudisptktkjkhkdeymd16) {
        vhsyudisptktkjkhkdeymd16 = pVhsyudisptktkjkhkdeymd16;
    }

    public BizCurrency getVhsyudisptktkjyskgns16() {
        return vhsyudisptktkjyskgns16;
    }

    @Override
    public void setVhsyudisptktkjyskgns16(BizCurrency pVhsyudisptktkjyskgns16) {
        vhsyudisptktkjyskgns16 = pVhsyudisptktkjyskgns16;
    }

    public BizDate getVhsyudisptktkjkhkdsymd26() {
        return vhsyudisptktkjkhkdsymd26;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd26(BizDate pVhsyudisptktkjkhkdsymd26) {
        vhsyudisptktkjkhkdsymd26 = pVhsyudisptktkjkhkdsymd26;
    }

    public BizDate getVhsyudisptktkjkhkdeymd26() {
        return vhsyudisptktkjkhkdeymd26;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd26(BizDate pVhsyudisptktkjkhkdeymd26) {
        vhsyudisptktkjkhkdeymd26 = pVhsyudisptktkjkhkdeymd26;
    }

    public BizCurrency getVhsyudisptktkjyskgns26() {
        return vhsyudisptktkjyskgns26;
    }

    @Override
    public void setVhsyudisptktkjyskgns26(BizCurrency pVhsyudisptktkjyskgns26) {
        vhsyudisptktkjyskgns26 = pVhsyudisptktkjyskgns26;
    }

    public BizDate getVhsyudisptktkjkhkdsymd36() {
        return vhsyudisptktkjkhkdsymd36;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd36(BizDate pVhsyudisptktkjkhkdsymd36) {
        vhsyudisptktkjkhkdsymd36 = pVhsyudisptktkjkhkdsymd36;
    }

    public BizDate getVhsyudisptktkjkhkdeymd36() {
        return vhsyudisptktkjkhkdeymd36;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd36(BizDate pVhsyudisptktkjkhkdeymd36) {
        vhsyudisptktkjkhkdeymd36 = pVhsyudisptktkjkhkdeymd36;
    }

    public BizCurrency getVhsyudisptktkjyskgns36() {
        return vhsyudisptktkjyskgns36;
    }

    @Override
    public void setVhsyudisptktkjyskgns36(BizCurrency pVhsyudisptktkjyskgns36) {
        vhsyudisptktkjyskgns36 = pVhsyudisptktkjyskgns36;
    }

    public BizDate getVhsyudisptktkjkhkdsymd46() {
        return vhsyudisptktkjkhkdsymd46;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd46(BizDate pVhsyudisptktkjkhkdsymd46) {
        vhsyudisptktkjkhkdsymd46 = pVhsyudisptktkjkhkdsymd46;
    }

    public BizDate getVhsyudisptktkjkhkdeymd46() {
        return vhsyudisptktkjkhkdeymd46;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd46(BizDate pVhsyudisptktkjkhkdeymd46) {
        vhsyudisptktkjkhkdeymd46 = pVhsyudisptktkjkhkdeymd46;
    }

    public BizCurrency getVhsyudisptktkjyskgns46() {
        return vhsyudisptktkjyskgns46;
    }

    @Override
    public void setVhsyudisptktkjyskgns46(BizCurrency pVhsyudisptktkjyskgns46) {
        vhsyudisptktkjyskgns46 = pVhsyudisptktkjyskgns46;
    }

    public BizDate getVhsyudisptktkjkhkdsymd56() {
        return vhsyudisptktkjkhkdsymd56;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd56(BizDate pVhsyudisptktkjkhkdsymd56) {
        vhsyudisptktkjkhkdsymd56 = pVhsyudisptktkjkhkdsymd56;
    }

    public BizDate getVhsyudisptktkjkhkdeymd56() {
        return vhsyudisptktkjkhkdeymd56;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd56(BizDate pVhsyudisptktkjkhkdeymd56) {
        vhsyudisptktkjkhkdeymd56 = pVhsyudisptktkjkhkdeymd56;
    }

    public BizCurrency getVhsyudisptktkjyskgns56() {
        return vhsyudisptktkjyskgns56;
    }

    @Override
    public void setVhsyudisptktkjyskgns56(BizCurrency pVhsyudisptktkjyskgns56) {
        vhsyudisptktkjyskgns56 = pVhsyudisptktkjyskgns56;
    }

    public C_Tkjyhyouten getVhsyudisptktkjyhyouten6() {
        return vhsyudisptktkjyhyouten6;
    }

    @Override
    public void setVhsyudisptktkjyhyouten6(C_Tkjyhyouten pvhsyudisptktkjyhyouten6){
        vhsyudisptktkjyhyouten6 = pvhsyudisptktkjyhyouten6;
    }

    public BizCurrency getVhsyudisptktkjyp6() {
        return vhsyudisptktkjyp6;
    }

    @Override
    public void setVhsyudisptktkjyp6(BizCurrency pVhsyudisptktkjyp6) {
        vhsyudisptktkjyp6 = pVhsyudisptktkjyp6;
    }

    public String getVhsyudisptkhtnpbuicd16() {
        return vhsyudisptkhtnpbuicd16;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd16(String pVhsyudisptkhtnpbuicd16) {
        vhsyudisptkhtnpbuicd16 = pVhsyudisptkhtnpbuicd16;
    }

    public String getVhsyudisptkhtnpbuinm16() {
        return vhsyudisptkhtnpbuinm16;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm16(String pVhsyudisptkhtnpbuinm16) {
        vhsyudisptkhtnpbuinm16 = pVhsyudisptkhtnpbuinm16;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn16() {
        return vhsyudisptkhtnpkkn16;
    }

    @Override
    public void setVhsyudisptkhtnpkkn16(C_Htnpkkn pVhsyudisptkhtnpkkn16) {
        vhsyudisptkhtnpkkn16 = pVhsyudisptkhtnpkkn16;
    }

    public String getVhsyudisptkhtnpbuicd26() {
        return vhsyudisptkhtnpbuicd26;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd26(String pVhsyudisptkhtnpbuicd26) {
        vhsyudisptkhtnpbuicd26 = pVhsyudisptkhtnpbuicd26;
    }

    public String getVhsyudisptkhtnpbuinm26() {
        return vhsyudisptkhtnpbuinm26;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm26(String pVhsyudisptkhtnpbuinm26) {
        vhsyudisptkhtnpbuinm26 = pVhsyudisptkhtnpbuinm26;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn26() {
        return vhsyudisptkhtnpkkn26;
    }

    @Override
    public void setVhsyudisptkhtnpkkn26(C_Htnpkkn pVhsyudisptkhtnpkkn26) {
        vhsyudisptkhtnpkkn26 = pVhsyudisptkhtnpkkn26;
    }

    public String getVhsyudisptkhtnpbuicd36() {
        return vhsyudisptkhtnpbuicd36;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd36(String pVhsyudisptkhtnpbuicd36) {
        vhsyudisptkhtnpbuicd36 = pVhsyudisptkhtnpbuicd36;
    }

    public String getVhsyudisptkhtnpbuinm36() {
        return vhsyudisptkhtnpbuinm36;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm36(String pVhsyudisptkhtnpbuinm36) {
        vhsyudisptkhtnpbuinm36 = pVhsyudisptkhtnpbuinm36;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn36() {
        return vhsyudisptkhtnpkkn36;
    }

    @Override
    public void setVhsyudisptkhtnpkkn36(C_Htnpkkn pVhsyudisptkhtnpkkn36) {
        vhsyudisptkhtnpkkn36 = pVhsyudisptkhtnpkkn36;
    }

    public String getVhsyudisptkhtnpbuicd46() {
        return vhsyudisptkhtnpbuicd46;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd46(String pVhsyudisptkhtnpbuicd46) {
        vhsyudisptkhtnpbuicd46 = pVhsyudisptkhtnpbuicd46;
    }

    public String getVhsyudisptkhtnpbuinm46() {
        return vhsyudisptkhtnpbuinm46;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm46(String pVhsyudisptkhtnpbuinm46) {
        vhsyudisptkhtnpbuinm46 = pVhsyudisptkhtnpbuinm46;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn46() {
        return vhsyudisptkhtnpkkn46;
    }

    @Override
    public void setVhsyudisptkhtnpkkn46(C_Htnpkkn pVhsyudisptkhtnpkkn46) {
        vhsyudisptkhtnpkkn46 = pVhsyudisptkhtnpkkn46;
    }

    public C_TokkoudosghtnpKbn getVhsyudisptktkkdsghtpkbn6() {
        return vhsyudisptktkkdsghtpkbn6;
    }

    @Override
    public void setVhsyudisptktkkdsghtpkbn6(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn6) {
        vhsyudisptktkkdsghtpkbn6 = pVhsyudisptktkkdsghtpkbn6;
    }

    public BizCurrency getVhsyudisptktutakngk6() {
        return vhsyudisptktutakngk6;
    }

    @Override
    public void setVhsyudisptktutakngk6(BizCurrency pVhsyudisptktutakngk6) {
        vhsyudisptktutakngk6 = pVhsyudisptktutakngk6;
    }

    public BizDate getVhsyudisptkkrkhasseiymd6() {
        return vhsyudisptkkrkhasseiymd6;
    }

    @Override
    public void setVhsyudisptkkrkhasseiymd6(BizDate pVhsyudisptkkrkhasseiymd6) {
        vhsyudisptkkrkhasseiymd6 = pVhsyudisptkkrkhasseiymd6;
    }

    public String getVhsyudisptksyouhnnm7() {
        return vhsyudisptksyouhnnm7;
    }

    @Override
    public void setVhsyudisptksyouhnnm7(String pVhsyudisptksyouhnnm7) {
        vhsyudisptksyouhnnm7 = pVhsyudisptksyouhnnm7;
    }

    public C_Tuukasyu getVhsyudisptkktuukasyu7() {
        return vhsyudisptkktuukasyu7;
    }

    @Override
    public void setVhsyudisptkktuukasyu7(C_Tuukasyu pVhsyudisptkktuukasyu7) {
        vhsyudisptkktuukasyu7 = pVhsyudisptkktuukasyu7;
    }

    public C_KataKbn getVhsyudisptokyakukatakbn7() {
        return vhsyudisptokyakukatakbn7;
    }

    @Override
    public void setVhsyudisptokyakukatakbn7(C_KataKbn pVhsyudisptokyakukatakbn7) {
        vhsyudisptokyakukatakbn7 = pVhsyudisptokyakukatakbn7;
    }

    public C_KyhgndkataKbn getVhsyudisptkkyhgdkatakbn7() {
        return vhsyudisptkkyhgdkatakbn7;
    }

    @Override
    public void setVhsyudisptkkyhgdkatakbn7(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn7) {
        vhsyudisptkkyhgdkatakbn7 = pVhsyudisptkkyhgdkatakbn7;
    }

    public Integer getVhsyudisptkhhknnen7() {
        return vhsyudisptkhhknnen7;
    }

    @Override
    public void setVhsyudisptkhhknnen7(Integer pVhsyudisptkhhknnen7) {
        vhsyudisptkhhknnen7 = pVhsyudisptkhhknnen7;
    }

    public BizDate getVhsyudisptkkykymd7() {
        return vhsyudisptkkykymd7;
    }

    @Override
    public void setVhsyudisptkkykymd7(BizDate pVhsyudisptkkykymd7) {
        vhsyudisptkkykymd7 = pVhsyudisptkkykymd7;
    }

    public BizDate getVhsyudisptksknnkaisiymd7() {
        return vhsyudisptksknnkaisiymd7;
    }

    @Override
    public void setVhsyudisptksknnkaisiymd7(BizDate pVhsyudisptksknnkaisiymd7) {
        vhsyudisptksknnkaisiymd7 = pVhsyudisptksknnkaisiymd7;
    }

    public BizDate getVhsyudisptkgaskkaisiymd7() {
        return vhsyudisptkgaskkaisiymd7;
    }

    @Override
    public void setVhsyudisptkgaskkaisiymd7(BizDate pVhsyudisptkgaskkaisiymd7) {
        vhsyudisptkgaskkaisiymd7 = pVhsyudisptkgaskkaisiymd7;
    }

    public BizDate getVhsyudisptkhkskkaisiymd7() {
        return vhsyudisptkhkskkaisiymd7;
    }

    @Override
    public void setVhsyudisptkhkskkaisiymd7(BizDate pVhsyudisptkhkskkaisiymd7) {
        vhsyudisptkhkskkaisiymd7 = pVhsyudisptkhkskkaisiymd7;
    }

    public BizDate getVhsyudisptkhkgskksiymd7() {
        return vhsyudisptkhkgskksiymd7;
    }

    @Override
    public void setVhsyudisptkhkgskksiymd7(BizDate pVhsyudisptkhkgskksiymd7) {
        vhsyudisptkhkgskksiymd7 = pVhsyudisptkhkgskksiymd7;
    }

    public Integer getVhsyudisptkhknkkn7() {
        return vhsyudisptkhknkkn7;
    }

    @Override
    public void setVhsyudisptkhknkkn7(Integer pVhsyudisptkhknkkn7) {
        vhsyudisptkhknkkn7 = pVhsyudisptkhknkkn7;
    }

    public C_HknkknsmnKbn getVhsyudisptkhknkknsmnkbn7() {
        return vhsyudisptkhknkknsmnkbn7;
    }

    @Override
    public void setVhsyudisptkhknkknsmnkbn7(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn7) {
        vhsyudisptkhknkknsmnkbn7 = pVhsyudisptkhknkknsmnkbn7;
    }

    public Integer getVhsyudisptkhrkkkn7() {
        return vhsyudisptkhrkkkn7;
    }

    @Override
    public void setVhsyudisptkhrkkkn7(Integer pVhsyudisptkhrkkkn7) {
        vhsyudisptkhrkkkn7 = pVhsyudisptkhrkkkn7;
    }

    public C_HrkkknsmnKbn getVhsyudisptkhrkkknsmnkbn7() {
        return vhsyudisptkhrkkknsmnkbn7;
    }

    @Override
    public void setVhsyudisptkhrkkknsmnkbn7(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn7) {
        vhsyudisptkhrkkknsmnkbn7 = pVhsyudisptkhrkkknsmnkbn7;
    }

    public C_KihonssyuruiKbn getVhsyudisptkkihsyuruikbn7() {
        return vhsyudisptkkihsyuruikbn7;
    }

    @Override
    public void setVhsyudisptkkihsyuruikbn7(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn7) {
        vhsyudisptkkihsyuruikbn7 = pVhsyudisptkkihsyuruikbn7;
    }

    public BizCurrency getVhsyudisptkkihons7() {
        return vhsyudisptkkihons7;
    }

    @Override
    public void setVhsyudisptkkihons7(BizCurrency pVhsyudisptkkihons7) {
        vhsyudisptkkihons7 = pVhsyudisptkkihons7;
    }

    public BizCurrency getVhsyudisptkp7() {
        return vhsyudisptkp7;
    }

    @Override
    public void setVhsyudisptkp7(BizCurrency pVhsyudisptkp7) {
        vhsyudisptkp7 = pVhsyudisptkp7;
    }

    public BizCurrency getVhsyudisptkkihonkyhgk7() {
        return vhsyudisptkkihonkyhgk7;
    }

    @Override
    public void setVhsyudisptkkihonkyhgk7(BizCurrency pVhsyudisptkkihonkyhgk7) {
        vhsyudisptkkihonkyhgk7 = pVhsyudisptkkihonkyhgk7;
    }

    public BizCurrency getVhsyudisptknextkosgop7() {
        return vhsyudisptknextkosgop7;
    }

    @Override
    public void setVhsyudisptknextkosgop7(BizCurrency pVhsyudisptknextkosgop7) {
        vhsyudisptknextkosgop7 = pVhsyudisptknextkosgop7;
    }

    public C_SyukyhkinkataKbn getVhsyudisptksykyhkatakbn7() {
        return vhsyudisptksykyhkatakbn7;
    }

    @Override
    public void setVhsyudisptksykyhkatakbn7(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn7) {
        vhsyudisptksykyhkatakbn7 = pVhsyudisptksykyhkatakbn7;
    }

    public C_6daiLdKbn getVhsyudisptk6daildkbn7() {
        return vhsyudisptk6daildkbn7;
    }

    @Override
    public void setVhsyudisptk6daildkbn7(C_6daiLdKbn pVhsyudisptk6daildkbn7) {
        vhsyudisptk6daildkbn7 = pVhsyudisptk6daildkbn7;
    }

    public BizCurrency getVhsyudisptkganyukyhntgk7() {
        return vhsyudisptkganyukyhntgk7;
    }

    @Override
    public void setVhsyudisptkganyukyhntgk7(BizCurrency pVhsyudisptkganyukyhntgk7) {
        vhsyudisptkganyukyhntgk7 = pVhsyudisptkganyukyhntgk7;
    }

    public BizDate getVhsyudisptkshrskgstrymd7() {
        return vhsyudisptkshrskgstrymd7;
    }

    @Override
    public void setVhsyudisptkshrskgstrymd7(BizDate pVhsyudisptkshrskgstrymd7) {
        vhsyudisptkshrskgstrymd7 = pVhsyudisptkshrskgstrymd7;
    }

    public BizDate getVhsyudisptkshrskgnedymd7() {
        return vhsyudisptkshrskgnedymd7;
    }

    @Override
    public void setVhsyudisptkshrskgnedymd7(BizDate pVhsyudisptkshrskgnedymd7) {
        vhsyudisptkshrskgnedymd7 = pVhsyudisptkshrskgnedymd7;
    }

    public BizCurrency getVhsyudisptkshrskgngos7() {
        return vhsyudisptkshrskgngos7;
    }

    @Override
    public void setVhsyudisptkshrskgngos7(BizCurrency pVhsyudisptkshrskgngos7) {
        vhsyudisptkshrskgngos7 = pVhsyudisptkshrskgngos7;
    }

    public C_Nenkinsyu getVhsyudisptknenkinsyukbn7() {
        return vhsyudisptknenkinsyukbn7;
    }

    @Override
    public void setVhsyudisptknenkinsyukbn7(C_Nenkinsyu pVhsyudisptknenkinsyukbn7) {
        vhsyudisptknenkinsyukbn7 = pVhsyudisptknenkinsyukbn7;
    }

    public Integer getVhsyudisptknenkinkkn7() {
        return vhsyudisptknenkinkkn7;
    }

    @Override
    public void setVhsyudisptknenkinkkn7(Integer pVhsyudisptknenkinkkn7) {
        vhsyudisptknenkinkkn7 = pVhsyudisptknenkinkkn7;
    }

    public C_Tkjyskgnkkn getVhsyudisptktkjyskgnkkn7() {
        return vhsyudisptktkjyskgnkkn7;
    }

    @Override
    public void setVhsyudisptktkjyskgnkkn7(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn7) {
        vhsyudisptktkjyskgnkkn7 = pVhsyudisptktkjyskgnkkn7;
    }

    public BizDate getVhsyudisptktkjkhkdsymd17() {
        return vhsyudisptktkjkhkdsymd17;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd17(BizDate pVhsyudisptktkjkhkdsymd17) {
        vhsyudisptktkjkhkdsymd17 = pVhsyudisptktkjkhkdsymd17;
    }

    public BizDate getVhsyudisptktkjkhkdeymd17() {
        return vhsyudisptktkjkhkdeymd17;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd17(BizDate pVhsyudisptktkjkhkdeymd17) {
        vhsyudisptktkjkhkdeymd17 = pVhsyudisptktkjkhkdeymd17;
    }

    public BizCurrency getVhsyudisptktkjyskgns17() {
        return vhsyudisptktkjyskgns17;
    }

    @Override
    public void setVhsyudisptktkjyskgns17(BizCurrency pVhsyudisptktkjyskgns17) {
        vhsyudisptktkjyskgns17 = pVhsyudisptktkjyskgns17;
    }

    public BizDate getVhsyudisptktkjkhkdsymd27() {
        return vhsyudisptktkjkhkdsymd27;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd27(BizDate pVhsyudisptktkjkhkdsymd27) {
        vhsyudisptktkjkhkdsymd27 = pVhsyudisptktkjkhkdsymd27;
    }

    public BizDate getVhsyudisptktkjkhkdeymd27() {
        return vhsyudisptktkjkhkdeymd27;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd27(BizDate pVhsyudisptktkjkhkdeymd27) {
        vhsyudisptktkjkhkdeymd27 = pVhsyudisptktkjkhkdeymd27;
    }

    public BizCurrency getVhsyudisptktkjyskgns27() {
        return vhsyudisptktkjyskgns27;
    }

    @Override
    public void setVhsyudisptktkjyskgns27(BizCurrency pVhsyudisptktkjyskgns27) {
        vhsyudisptktkjyskgns27 = pVhsyudisptktkjyskgns27;
    }

    public BizDate getVhsyudisptktkjkhkdsymd37() {
        return vhsyudisptktkjkhkdsymd37;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd37(BizDate pVhsyudisptktkjkhkdsymd37) {
        vhsyudisptktkjkhkdsymd37 = pVhsyudisptktkjkhkdsymd37;
    }

    public BizDate getVhsyudisptktkjkhkdeymd37() {
        return vhsyudisptktkjkhkdeymd37;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd37(BizDate pVhsyudisptktkjkhkdeymd37) {
        vhsyudisptktkjkhkdeymd37 = pVhsyudisptktkjkhkdeymd37;
    }

    public BizCurrency getVhsyudisptktkjyskgns37() {
        return vhsyudisptktkjyskgns37;
    }

    @Override
    public void setVhsyudisptktkjyskgns37(BizCurrency pVhsyudisptktkjyskgns37) {
        vhsyudisptktkjyskgns37 = pVhsyudisptktkjyskgns37;
    }

    public BizDate getVhsyudisptktkjkhkdsymd47() {
        return vhsyudisptktkjkhkdsymd47;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd47(BizDate pVhsyudisptktkjkhkdsymd47) {
        vhsyudisptktkjkhkdsymd47 = pVhsyudisptktkjkhkdsymd47;
    }

    public BizDate getVhsyudisptktkjkhkdeymd47() {
        return vhsyudisptktkjkhkdeymd47;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd47(BizDate pVhsyudisptktkjkhkdeymd47) {
        vhsyudisptktkjkhkdeymd47 = pVhsyudisptktkjkhkdeymd47;
    }

    public BizCurrency getVhsyudisptktkjyskgns47() {
        return vhsyudisptktkjyskgns47;
    }

    @Override
    public void setVhsyudisptktkjyskgns47(BizCurrency pVhsyudisptktkjyskgns47) {
        vhsyudisptktkjyskgns47 = pVhsyudisptktkjyskgns47;
    }

    public BizDate getVhsyudisptktkjkhkdsymd57() {
        return vhsyudisptktkjkhkdsymd57;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd57(BizDate pVhsyudisptktkjkhkdsymd57) {
        vhsyudisptktkjkhkdsymd57 = pVhsyudisptktkjkhkdsymd57;
    }

    public BizDate getVhsyudisptktkjkhkdeymd57() {
        return vhsyudisptktkjkhkdeymd57;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd57(BizDate pVhsyudisptktkjkhkdeymd57) {
        vhsyudisptktkjkhkdeymd57 = pVhsyudisptktkjkhkdeymd57;
    }

    public BizCurrency getVhsyudisptktkjyskgns57() {
        return vhsyudisptktkjyskgns57;
    }

    @Override
    public void setVhsyudisptktkjyskgns57(BizCurrency pVhsyudisptktkjyskgns57) {
        vhsyudisptktkjyskgns57 = pVhsyudisptktkjyskgns57;
    }

    public C_Tkjyhyouten getVhsyudisptktkjyhyouten7() {
        return vhsyudisptktkjyhyouten7;
    }

    @Override
    public void setVhsyudisptktkjyhyouten7(C_Tkjyhyouten pVhsyudisptktkjyhyouten7) {
        vhsyudisptktkjyhyouten7 = pVhsyudisptktkjyhyouten7;
    }

    public BizCurrency getVhsyudisptktkjyp7() {
        return vhsyudisptktkjyp7;
    }

    @Override
    public void setVhsyudisptktkjyp7(BizCurrency pVhsyudisptktkjyp7) {
        vhsyudisptktkjyp7 = pVhsyudisptktkjyp7;
    }

    public String getVhsyudisptkhtnpbuicd17() {
        return vhsyudisptkhtnpbuicd17;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd17(String pVhsyudisptkhtnpbuicd17) {
        vhsyudisptkhtnpbuicd17 = pVhsyudisptkhtnpbuicd17;
    }

    public String getVhsyudisptkhtnpbuinm17() {
        return vhsyudisptkhtnpbuinm17;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm17(String pVhsyudisptkhtnpbuinm17) {
        vhsyudisptkhtnpbuinm17 = pVhsyudisptkhtnpbuinm17;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn17() {
        return vhsyudisptkhtnpkkn17;
    }

    @Override
    public void setVhsyudisptkhtnpkkn17(C_Htnpkkn pVhsyudisptkhtnpkkn17) {
        vhsyudisptkhtnpkkn17 = pVhsyudisptkhtnpkkn17;
    }

    public String getVhsyudisptkhtnpbuicd27() {
        return vhsyudisptkhtnpbuicd27;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd27(String pVhsyudisptkhtnpbuicd27) {
        vhsyudisptkhtnpbuicd27 = pVhsyudisptkhtnpbuicd27;
    }

    public String getVhsyudisptkhtnpbuinm27() {
        return vhsyudisptkhtnpbuinm27;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm27(String pVhsyudisptkhtnpbuinm27) {
        vhsyudisptkhtnpbuinm27 = pVhsyudisptkhtnpbuinm27;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn27() {
        return vhsyudisptkhtnpkkn27;
    }

    @Override
    public void setVhsyudisptkhtnpkkn27(C_Htnpkkn pVhsyudisptkhtnpkkn27) {
        vhsyudisptkhtnpkkn27 = pVhsyudisptkhtnpkkn27;
    }

    public String getVhsyudisptkhtnpbuicd37() {
        return vhsyudisptkhtnpbuicd37;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd37(String pVhsyudisptkhtnpbuicd37) {
        vhsyudisptkhtnpbuicd37 = pVhsyudisptkhtnpbuicd37;
    }

    public String getVhsyudisptkhtnpbuinm37() {
        return vhsyudisptkhtnpbuinm37;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm37(String pVhsyudisptkhtnpbuinm37) {
        vhsyudisptkhtnpbuinm37 = pVhsyudisptkhtnpbuinm37;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn37() {
        return vhsyudisptkhtnpkkn37;
    }

    @Override
    public void setVhsyudisptkhtnpkkn37(C_Htnpkkn pVhsyudisptkhtnpkkn37) {
        vhsyudisptkhtnpkkn37 = pVhsyudisptkhtnpkkn37;
    }

    public String getVhsyudisptkhtnpbuicd47() {
        return vhsyudisptkhtnpbuicd47;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd47(String pVhsyudisptkhtnpbuicd47) {
        vhsyudisptkhtnpbuicd47 = pVhsyudisptkhtnpbuicd47;
    }

    public String getVhsyudisptkhtnpbuinm47() {
        return vhsyudisptkhtnpbuinm47;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm47(String pVhsyudisptkhtnpbuinm47) {
        vhsyudisptkhtnpbuinm47 = pVhsyudisptkhtnpbuinm47;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn47() {
        return vhsyudisptkhtnpkkn47;
    }

    @Override
    public void setVhsyudisptkhtnpkkn47(C_Htnpkkn pVhsyudisptkhtnpkkn47) {
        vhsyudisptkhtnpkkn47 = pVhsyudisptkhtnpkkn47;
    }

    public C_TokkoudosghtnpKbn getVhsyudisptktkkdsghtpkbn7() {
        return vhsyudisptktkkdsghtpkbn7;
    }

    @Override
    public void setVhsyudisptktkkdsghtpkbn7(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn7) {
        vhsyudisptktkkdsghtpkbn7 = pVhsyudisptktkkdsghtpkbn7;
    }

    public BizCurrency getVhsyudisptktutakngk7() {
        return vhsyudisptktutakngk7;
    }

    @Override
    public void setVhsyudisptktutakngk7(BizCurrency pVhsyudisptktutakngk7) {
        vhsyudisptktutakngk7 = pVhsyudisptktutakngk7;
    }

    public BizDate getVhsyudisptkkrkhasseiymd7() {
        return vhsyudisptkkrkhasseiymd7;
    }

    @Override
    public void setVhsyudisptkkrkhasseiymd7(BizDate pVhsyudisptkkrkhasseiymd7) {
        vhsyudisptkkrkhasseiymd7 = pVhsyudisptkkrkhasseiymd7;
    }

    public String getVhsyudisptksyouhnnm8() {
        return vhsyudisptksyouhnnm8;
    }

    @Override
    public void setVhsyudisptksyouhnnm8(String pVhsyudisptksyouhnnm8) {
        vhsyudisptksyouhnnm8 = pVhsyudisptksyouhnnm8;
    }

    public C_Tuukasyu getVhsyudisptkktuukasyu8() {
        return vhsyudisptkktuukasyu8;
    }

    @Override
    public void setVhsyudisptkktuukasyu8(C_Tuukasyu pVhsyudisptkktuukasyu8) {
        vhsyudisptkktuukasyu8 = pVhsyudisptkktuukasyu8;
    }

    public C_KataKbn getVhsyudisptokyakukatakbn8() {
        return vhsyudisptokyakukatakbn8;
    }

    @Override
    public void setVhsyudisptokyakukatakbn8(C_KataKbn pVhsyudisptokyakukatakbn8) {
        vhsyudisptokyakukatakbn8 = pVhsyudisptokyakukatakbn8;
    }

    public C_KyhgndkataKbn getVhsyudisptkkyhgdkatakbn8() {
        return vhsyudisptkkyhgdkatakbn8;
    }

    @Override
    public void setVhsyudisptkkyhgdkatakbn8(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn8) {
        vhsyudisptkkyhgdkatakbn8 = pVhsyudisptkkyhgdkatakbn8;
    }

    public Integer getVhsyudisptkhhknnen8() {
        return vhsyudisptkhhknnen8;
    }

    @Override
    public void setVhsyudisptkhhknnen8(Integer pVhsyudisptkhhknnen8) {
        vhsyudisptkhhknnen8 = pVhsyudisptkhhknnen8;
    }

    public BizDate getVhsyudisptkkykymd8() {
        return vhsyudisptkkykymd8;
    }

    @Override
    public void setVhsyudisptkkykymd8(BizDate pVhsyudisptkkykymd8) {
        vhsyudisptkkykymd8 = pVhsyudisptkkykymd8;
    }

    public BizDate getVhsyudisptksknnkaisiymd8() {
        return vhsyudisptksknnkaisiymd8;
    }

    @Override
    public void setVhsyudisptksknnkaisiymd8(BizDate pVhsyudisptksknnkaisiymd8) {
        vhsyudisptksknnkaisiymd8 = pVhsyudisptksknnkaisiymd8;
    }

    public BizDate getVhsyudisptkgaskkaisiymd8() {
        return vhsyudisptkgaskkaisiymd8;
    }

    @Override
    public void setVhsyudisptkgaskkaisiymd8(BizDate pVhsyudisptkgaskkaisiymd8) {
        vhsyudisptkgaskkaisiymd8 = pVhsyudisptkgaskkaisiymd8;
    }

    public BizDate getVhsyudisptkhkskkaisiymd8() {
        return vhsyudisptkhkskkaisiymd8;
    }

    @Override
    public void setVhsyudisptkhkskkaisiymd8(BizDate pVhsyudisptkhkskkaisiymd8) {
        vhsyudisptkhkskkaisiymd8 = pVhsyudisptkhkskkaisiymd8;
    }

    public BizDate getVhsyudisptkhkgskksiymd8() {
        return vhsyudisptkhkgskksiymd8;
    }

    @Override
    public void setVhsyudisptkhkgskksiymd8(BizDate pVhsyudisptkhkgskksiymd8) {
        vhsyudisptkhkgskksiymd8 = pVhsyudisptkhkgskksiymd8;
    }

    public Integer getVhsyudisptkhknkkn8() {
        return vhsyudisptkhknkkn8;
    }

    @Override
    public void setVhsyudisptkhknkkn8(Integer pVhsyudisptkhknkkn8) {
        vhsyudisptkhknkkn8 = pVhsyudisptkhknkkn8;
    }

    public C_HknkknsmnKbn getVhsyudisptkhknkknsmnkbn8() {
        return vhsyudisptkhknkknsmnkbn8;
    }

    @Override
    public void setVhsyudisptkhknkknsmnkbn8(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn8) {
        vhsyudisptkhknkknsmnkbn8 = pVhsyudisptkhknkknsmnkbn8;
    }

    public Integer getVhsyudisptkhrkkkn8() {
        return vhsyudisptkhrkkkn8;
    }

    @Override
    public void setVhsyudisptkhrkkkn8(Integer pVhsyudisptkhrkkkn8) {
        vhsyudisptkhrkkkn8 = pVhsyudisptkhrkkkn8;
    }

    public C_HrkkknsmnKbn getVhsyudisptkhrkkknsmnkbn8() {
        return vhsyudisptkhrkkknsmnkbn8;
    }

    @Override
    public void setVhsyudisptkhrkkknsmnkbn8(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn8) {
        vhsyudisptkhrkkknsmnkbn8 = pVhsyudisptkhrkkknsmnkbn8;
    }

    public C_KihonssyuruiKbn getVhsyudisptkkihsyuruikbn8() {
        return vhsyudisptkkihsyuruikbn8;
    }

    @Override
    public void setVhsyudisptkkihsyuruikbn8(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn8) {
        vhsyudisptkkihsyuruikbn8 = pVhsyudisptkkihsyuruikbn8;
    }

    public BizCurrency getVhsyudisptkkihons8() {
        return vhsyudisptkkihons8;
    }

    @Override
    public void setVhsyudisptkkihons8(BizCurrency pVhsyudisptkkihons8) {
        vhsyudisptkkihons8 = pVhsyudisptkkihons8;
    }

    public BizCurrency getVhsyudisptkp8() {
        return vhsyudisptkp8;
    }

    @Override
    public void setVhsyudisptkp8(BizCurrency pVhsyudisptkp8) {
        vhsyudisptkp8 = pVhsyudisptkp8;
    }

    public BizCurrency getVhsyudisptkkihonkyhgk8() {
        return vhsyudisptkkihonkyhgk8;
    }

    @Override
    public void setVhsyudisptkkihonkyhgk8(BizCurrency pVhsyudisptkkihonkyhgk8) {
        vhsyudisptkkihonkyhgk8 = pVhsyudisptkkihonkyhgk8;
    }

    public BizCurrency getVhsyudisptknextkosgop8() {
        return vhsyudisptknextkosgop8;
    }

    @Override
    public void setVhsyudisptknextkosgop8(BizCurrency pVhsyudisptknextkosgop8) {
        vhsyudisptknextkosgop8 = pVhsyudisptknextkosgop8;
    }

    public C_SyukyhkinkataKbn getVhsyudisptksykyhkatakbn8() {
        return vhsyudisptksykyhkatakbn8;
    }

    @Override
    public void setVhsyudisptksykyhkatakbn8(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn8) {
        vhsyudisptksykyhkatakbn8 = pVhsyudisptksykyhkatakbn8;
    }

    public C_6daiLdKbn getVhsyudisptk6daildkbn8() {
        return vhsyudisptk6daildkbn8;
    }

    @Override
    public void setVhsyudisptk6daildkbn8(C_6daiLdKbn pVhsyudisptk6daildkbn8) {
        vhsyudisptk6daildkbn8 = pVhsyudisptk6daildkbn8;
    }

    public BizCurrency getVhsyudisptkganyukyhntgk8() {
        return vhsyudisptkganyukyhntgk8;
    }

    @Override
    public void setVhsyudisptkganyukyhntgk8(BizCurrency pVhsyudisptkganyukyhntgk8) {
        vhsyudisptkganyukyhntgk8 = pVhsyudisptkganyukyhntgk8;
    }

    public BizDate getVhsyudisptkshrskgstrymd8() {
        return vhsyudisptkshrskgstrymd8;
    }

    @Override
    public void setVhsyudisptkshrskgstrymd8(BizDate pVhsyudisptkshrskgstrymd8) {
        vhsyudisptkshrskgstrymd8 = pVhsyudisptkshrskgstrymd8;
    }

    public BizDate getVhsyudisptkshrskgnedymd8() {
        return vhsyudisptkshrskgnedymd8;
    }

    @Override
    public void setVhsyudisptkshrskgnedymd8(BizDate pVhsyudisptkshrskgnedymd8) {
        vhsyudisptkshrskgnedymd8 = pVhsyudisptkshrskgnedymd8;
    }

    public BizCurrency getVhsyudisptkshrskgngos8() {
        return vhsyudisptkshrskgngos8;
    }

    @Override
    public void setVhsyudisptkshrskgngos8(BizCurrency pVhsyudisptkshrskgngos8) {
        vhsyudisptkshrskgngos8 = pVhsyudisptkshrskgngos8;
    }

    public C_Nenkinsyu getVhsyudisptknenkinsyukbn8() {
        return vhsyudisptknenkinsyukbn8;
    }

    @Override
    public void setVhsyudisptknenkinsyukbn8(C_Nenkinsyu pVhsyudisptknenkinsyukbn8) {
        vhsyudisptknenkinsyukbn8 = pVhsyudisptknenkinsyukbn8;
    }

    public Integer getVhsyudisptknenkinkkn8() {
        return vhsyudisptknenkinkkn8;
    }

    @Override
    public void setVhsyudisptknenkinkkn8(Integer pVhsyudisptknenkinkkn8) {
        vhsyudisptknenkinkkn8 = pVhsyudisptknenkinkkn8;
    }

    public C_Tkjyskgnkkn getVhsyudisptktkjyskgnkkn8() {
        return vhsyudisptktkjyskgnkkn8;
    }

    @Override
    public void setVhsyudisptktkjyskgnkkn8(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn8) {
        vhsyudisptktkjyskgnkkn8 = pVhsyudisptktkjyskgnkkn8;
    }

    public BizDate getVhsyudisptktkjkhkdsymd18() {
        return vhsyudisptktkjkhkdsymd18;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd18(BizDate pVhsyudisptktkjkhkdsymd18) {
        vhsyudisptktkjkhkdsymd18 = pVhsyudisptktkjkhkdsymd18;
    }

    public BizDate getVhsyudisptktkjkhkdeymd18() {
        return vhsyudisptktkjkhkdeymd18;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd18(BizDate pVhsyudisptktkjkhkdeymd18) {
        vhsyudisptktkjkhkdeymd18 = pVhsyudisptktkjkhkdeymd18;
    }

    public BizCurrency getVhsyudisptktkjyskgns18() {
        return vhsyudisptktkjyskgns18;
    }

    @Override
    public void setVhsyudisptktkjyskgns18(BizCurrency pVhsyudisptktkjyskgns18) {
        vhsyudisptktkjyskgns18 = pVhsyudisptktkjyskgns18;
    }

    public BizDate getVhsyudisptktkjkhkdsymd28() {
        return vhsyudisptktkjkhkdsymd28;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd28(BizDate pVhsyudisptktkjkhkdsymd28) {
        vhsyudisptktkjkhkdsymd28 = pVhsyudisptktkjkhkdsymd28;
    }

    public BizDate getVhsyudisptktkjkhkdeymd28() {
        return vhsyudisptktkjkhkdeymd28;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd28(BizDate pVhsyudisptktkjkhkdeymd28) {
        vhsyudisptktkjkhkdeymd28 = pVhsyudisptktkjkhkdeymd28;
    }

    public BizCurrency getVhsyudisptktkjyskgns28() {
        return vhsyudisptktkjyskgns28;
    }

    @Override
    public void setVhsyudisptktkjyskgns28(BizCurrency pVhsyudisptktkjyskgns28) {
        vhsyudisptktkjyskgns28 = pVhsyudisptktkjyskgns28;
    }

    public BizDate getVhsyudisptktkjkhkdsymd38() {
        return vhsyudisptktkjkhkdsymd38;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd38(BizDate pVhsyudisptktkjkhkdsymd38) {
        vhsyudisptktkjkhkdsymd38 = pVhsyudisptktkjkhkdsymd38;
    }

    public BizDate getVhsyudisptktkjkhkdeymd38() {
        return vhsyudisptktkjkhkdeymd38;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd38(BizDate pVhsyudisptktkjkhkdeymd38) {
        vhsyudisptktkjkhkdeymd38 = pVhsyudisptktkjkhkdeymd38;
    }

    public BizCurrency getVhsyudisptktkjyskgns38() {
        return vhsyudisptktkjyskgns38;
    }

    @Override
    public void setVhsyudisptktkjyskgns38(BizCurrency pVhsyudisptktkjyskgns38) {
        vhsyudisptktkjyskgns38 = pVhsyudisptktkjyskgns38;
    }

    public BizDate getVhsyudisptktkjkhkdsymd48() {
        return vhsyudisptktkjkhkdsymd48;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd48(BizDate pVhsyudisptktkjkhkdsymd48) {
        vhsyudisptktkjkhkdsymd48 = pVhsyudisptktkjkhkdsymd48;
    }

    public BizDate getVhsyudisptktkjkhkdeymd48() {
        return vhsyudisptktkjkhkdeymd48;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd48(BizDate pVhsyudisptktkjkhkdeymd48) {
        vhsyudisptktkjkhkdeymd48 = pVhsyudisptktkjkhkdeymd48;
    }

    public BizCurrency getVhsyudisptktkjyskgns48() {
        return vhsyudisptktkjyskgns48;
    }

    @Override
    public void setVhsyudisptktkjyskgns48(BizCurrency pVhsyudisptktkjyskgns48) {
        vhsyudisptktkjyskgns48 = pVhsyudisptktkjyskgns48;
    }

    public BizDate getVhsyudisptktkjkhkdsymd58() {
        return vhsyudisptktkjkhkdsymd58;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd58(BizDate pVhsyudisptktkjkhkdsymd58) {
        vhsyudisptktkjkhkdsymd58 = pVhsyudisptktkjkhkdsymd58;
    }

    public BizDate getVhsyudisptktkjkhkdeymd58() {
        return vhsyudisptktkjkhkdeymd58;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd58(BizDate pVhsyudisptktkjkhkdeymd58) {
        vhsyudisptktkjkhkdeymd58 = pVhsyudisptktkjkhkdeymd58;
    }

    public BizCurrency getVhsyudisptktkjyskgns58() {
        return vhsyudisptktkjyskgns58;
    }

    @Override
    public void setVhsyudisptktkjyskgns58(BizCurrency pVhsyudisptktkjyskgns58) {
        vhsyudisptktkjyskgns58 = pVhsyudisptktkjyskgns58;
    }

    public C_Tkjyhyouten getVhsyudisptktkjyhyouten8() {
        return vhsyudisptktkjyhyouten8;
    }

    @Override
    public void setVhsyudisptktkjyhyouten8(C_Tkjyhyouten pVhsyudisptktkjyhyouten8) {
        vhsyudisptktkjyhyouten8 = pVhsyudisptktkjyhyouten8;
    }

    public BizCurrency getVhsyudisptktkjyp8() {
        return vhsyudisptktkjyp8;
    }

    @Override
    public void setVhsyudisptktkjyp8(BizCurrency pVhsyudisptktkjyp8) {
        vhsyudisptktkjyp8 = pVhsyudisptktkjyp8;
    }

    public String getVhsyudisptkhtnpbuicd18() {
        return vhsyudisptkhtnpbuicd18;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd18(String pVhsyudisptkhtnpbuicd18) {
        vhsyudisptkhtnpbuicd18 = pVhsyudisptkhtnpbuicd18;
    }

    public String getVhsyudisptkhtnpbuinm18() {
        return vhsyudisptkhtnpbuinm18;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm18(String pVhsyudisptkhtnpbuinm18) {
        vhsyudisptkhtnpbuinm18 = pVhsyudisptkhtnpbuinm18;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn18() {
        return vhsyudisptkhtnpkkn18;
    }

    @Override
    public void setVhsyudisptkhtnpkkn18(C_Htnpkkn pVhsyudisptkhtnpkkn18) {
        vhsyudisptkhtnpkkn18 = pVhsyudisptkhtnpkkn18;
    }

    public String getVhsyudisptkhtnpbuicd28() {
        return vhsyudisptkhtnpbuicd28;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd28(String pVhsyudisptkhtnpbuicd28) {
        vhsyudisptkhtnpbuicd28 = pVhsyudisptkhtnpbuicd28;
    }

    public String getVhsyudisptkhtnpbuinm28() {
        return vhsyudisptkhtnpbuinm28;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm28(String pVhsyudisptkhtnpbuinm28) {
        vhsyudisptkhtnpbuinm28 = pVhsyudisptkhtnpbuinm28;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn28() {
        return vhsyudisptkhtnpkkn28;
    }

    @Override
    public void setVhsyudisptkhtnpkkn28(C_Htnpkkn pVhsyudisptkhtnpkkn28) {
        vhsyudisptkhtnpkkn28 = pVhsyudisptkhtnpkkn28;
    }

    public String getVhsyudisptkhtnpbuicd38() {
        return vhsyudisptkhtnpbuicd38;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd38(String pVhsyudisptkhtnpbuicd38) {
        vhsyudisptkhtnpbuicd38 = pVhsyudisptkhtnpbuicd38;
    }

    public String getVhsyudisptkhtnpbuinm38() {
        return vhsyudisptkhtnpbuinm38;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm38(String pVhsyudisptkhtnpbuinm38) {
        vhsyudisptkhtnpbuinm38 = pVhsyudisptkhtnpbuinm38;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn38() {
        return vhsyudisptkhtnpkkn38;
    }

    @Override
    public void setVhsyudisptkhtnpkkn38(C_Htnpkkn pVhsyudisptkhtnpkkn38) {
        vhsyudisptkhtnpkkn38 = pVhsyudisptkhtnpkkn38;
    }

    public String getVhsyudisptkhtnpbuicd48() {
        return vhsyudisptkhtnpbuicd48;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd48(String pVhsyudisptkhtnpbuicd48) {
        vhsyudisptkhtnpbuicd48 = pVhsyudisptkhtnpbuicd48;
    }

    public String getVhsyudisptkhtnpbuinm48() {
        return vhsyudisptkhtnpbuinm48;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm48(String pVhsyudisptkhtnpbuinm48) {
        vhsyudisptkhtnpbuinm48 = pVhsyudisptkhtnpbuinm48;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn48() {
        return vhsyudisptkhtnpkkn48;
    }

    @Override
    public void setVhsyudisptkhtnpkkn48(C_Htnpkkn pVhsyudisptkhtnpkkn48) {
        vhsyudisptkhtnpkkn48 = pVhsyudisptkhtnpkkn48;
    }

    public C_TokkoudosghtnpKbn getVhsyudisptktkkdsghtpkbn8() {
        return vhsyudisptktkkdsghtpkbn8;
    }

    @Override
    public void setVhsyudisptktkkdsghtpkbn8(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn8) {
        vhsyudisptktkkdsghtpkbn8 = pVhsyudisptktkkdsghtpkbn8;
    }

    public BizCurrency getVhsyudisptktutakngk8() {
        return vhsyudisptktutakngk8;
    }

    @Override
    public void setVhsyudisptktutakngk8(BizCurrency pVhsyudisptktutakngk8) {
        vhsyudisptktutakngk8 = pVhsyudisptktutakngk8;
    }

    public BizDate getVhsyudisptkkrkhasseiymd8() {
        return vhsyudisptkkrkhasseiymd8;
    }

    @Override
    public void setVhsyudisptkkrkhasseiymd8(BizDate pVhsyudisptkkrkhasseiymd8) {
        vhsyudisptkkrkhasseiymd8 = pVhsyudisptkkrkhasseiymd8;
    }

    public String getVhsyudisptksyouhnnm9() {
        return vhsyudisptksyouhnnm9;
    }

    @Override
    public void setVhsyudisptksyouhnnm9(String pVhsyudisptksyouhnnm9) {
        vhsyudisptksyouhnnm9 = pVhsyudisptksyouhnnm9;
    }

    public C_Tuukasyu getVhsyudisptkktuukasyu9() {
        return vhsyudisptkktuukasyu9;
    }

    @Override
    public void setVhsyudisptkktuukasyu9(C_Tuukasyu pVhsyudisptkktuukasyu9) {
        vhsyudisptkktuukasyu9 = pVhsyudisptkktuukasyu9;
    }

    public C_KataKbn getVhsyudisptokyakukatakbn9() {
        return vhsyudisptokyakukatakbn9;
    }

    @Override
    public void setVhsyudisptokyakukatakbn9(C_KataKbn pVhsyudisptokyakukatakbn9) {
        vhsyudisptokyakukatakbn9 = pVhsyudisptokyakukatakbn9;
    }

    public C_KyhgndkataKbn getVhsyudisptkkyhgdkatakbn9() {
        return vhsyudisptkkyhgdkatakbn9;
    }

    @Override
    public void setVhsyudisptkkyhgdkatakbn9(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn9) {
        vhsyudisptkkyhgdkatakbn9 = pVhsyudisptkkyhgdkatakbn9;
    }

    public Integer getVhsyudisptkhhknnen9() {
        return vhsyudisptkhhknnen9;
    }

    @Override
    public void setVhsyudisptkhhknnen9(Integer pVhsyudisptkhhknnen9) {
        vhsyudisptkhhknnen9 = pVhsyudisptkhhknnen9;
    }

    public BizDate getVhsyudisptkkykymd9() {
        return vhsyudisptkkykymd9;
    }

    @Override
    public void setVhsyudisptkkykymd9(BizDate pVhsyudisptkkykymd9) {
        vhsyudisptkkykymd9 = pVhsyudisptkkykymd9;
    }

    public BizDate getVhsyudisptksknnkaisiymd9() {
        return vhsyudisptksknnkaisiymd9;
    }

    @Override
    public void setVhsyudisptksknnkaisiymd9(BizDate pVhsyudisptksknnkaisiymd9) {
        vhsyudisptksknnkaisiymd9 = pVhsyudisptksknnkaisiymd9;
    }

    public BizDate getVhsyudisptkgaskkaisiymd9() {
        return vhsyudisptkgaskkaisiymd9;
    }

    @Override
    public void setVhsyudisptkgaskkaisiymd9(BizDate pVhsyudisptkgaskkaisiymd9) {
        vhsyudisptkgaskkaisiymd9 = pVhsyudisptkgaskkaisiymd9;
    }

    public BizDate getVhsyudisptkhkskkaisiymd9() {
        return vhsyudisptkhkskkaisiymd9;
    }

    @Override
    public void setVhsyudisptkhkskkaisiymd9(BizDate pVhsyudisptkhkskkaisiymd9) {
        vhsyudisptkhkskkaisiymd9 = pVhsyudisptkhkskkaisiymd9;
    }

    public BizDate getVhsyudisptkhkgskksiymd9() {
        return vhsyudisptkhkgskksiymd9;
    }

    @Override
    public void setVhsyudisptkhkgskksiymd9(BizDate pVhsyudisptkhkgskksiymd9) {
        vhsyudisptkhkgskksiymd9 = pVhsyudisptkhkgskksiymd9;
    }

    public Integer getVhsyudisptkhknkkn9() {
        return vhsyudisptkhknkkn9;
    }

    @Override
    public void setVhsyudisptkhknkkn9(Integer pVhsyudisptkhknkkn9) {
        vhsyudisptkhknkkn9 = pVhsyudisptkhknkkn9;
    }

    public C_HknkknsmnKbn getVhsyudisptkhknkknsmnkbn9() {
        return vhsyudisptkhknkknsmnkbn9;
    }

    @Override
    public void setVhsyudisptkhknkknsmnkbn9(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn9) {
        vhsyudisptkhknkknsmnkbn9 = pVhsyudisptkhknkknsmnkbn9;
    }

    public Integer getVhsyudisptkhrkkkn9() {
        return vhsyudisptkhrkkkn9;
    }

    @Override
    public void setVhsyudisptkhrkkkn9(Integer pVhsyudisptkhrkkkn9) {
        vhsyudisptkhrkkkn9 = pVhsyudisptkhrkkkn9;
    }

    public C_HrkkknsmnKbn getVhsyudisptkhrkkknsmnkbn9() {
        return vhsyudisptkhrkkknsmnkbn9;
    }

    @Override
    public void setVhsyudisptkhrkkknsmnkbn9(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn9) {
        vhsyudisptkhrkkknsmnkbn9 = pVhsyudisptkhrkkknsmnkbn9;
    }

    public C_KihonssyuruiKbn getVhsyudisptkkihsyuruikbn9() {
        return vhsyudisptkkihsyuruikbn9;
    }

    @Override
    public void setVhsyudisptkkihsyuruikbn9(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn9) {
        vhsyudisptkkihsyuruikbn9 = pVhsyudisptkkihsyuruikbn9;
    }

    public BizCurrency getVhsyudisptkkihons9() {
        return vhsyudisptkkihons9;
    }

    @Override
    public void setVhsyudisptkkihons9(BizCurrency pVhsyudisptkkihons9) {
        vhsyudisptkkihons9 = pVhsyudisptkkihons9;
    }

    public BizCurrency getVhsyudisptkp9() {
        return vhsyudisptkp9;
    }

    @Override
    public void setVhsyudisptkp9(BizCurrency pVhsyudisptkp9) {
        vhsyudisptkp9 = pVhsyudisptkp9;
    }

    public BizCurrency getVhsyudisptkkihonkyhgk9() {
        return vhsyudisptkkihonkyhgk9;
    }

    @Override
    public void setVhsyudisptkkihonkyhgk9(BizCurrency pVhsyudisptkkihonkyhgk9) {
        vhsyudisptkkihonkyhgk9 = pVhsyudisptkkihonkyhgk9;
    }

    public BizCurrency getVhsyudisptknextkosgop9() {
        return vhsyudisptknextkosgop9;
    }

    @Override
    public void setVhsyudisptknextkosgop9(BizCurrency pVhsyudisptknextkosgop9) {
        vhsyudisptknextkosgop9 = pVhsyudisptknextkosgop9;
    }

    public C_SyukyhkinkataKbn getVhsyudisptksykyhkatakbn9() {
        return vhsyudisptksykyhkatakbn9;
    }

    @Override
    public void setVhsyudisptksykyhkatakbn9(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn9) {
        vhsyudisptksykyhkatakbn9 = pVhsyudisptksykyhkatakbn9;
    }

    public C_6daiLdKbn getVhsyudisptk6daildkbn9() {
        return vhsyudisptk6daildkbn9;
    }

    @Override
    public void setVhsyudisptk6daildkbn9(C_6daiLdKbn pVhsyudisptk6daildkbn9) {
        vhsyudisptk6daildkbn9 = pVhsyudisptk6daildkbn9;
    }

    public BizCurrency getVhsyudisptkganyukyhntgk9() {
        return vhsyudisptkganyukyhntgk9;
    }

    @Override
    public void setVhsyudisptkganyukyhntgk9(BizCurrency pVhsyudisptkganyukyhntgk9) {
        vhsyudisptkganyukyhntgk9 = pVhsyudisptkganyukyhntgk9;
    }

    public BizDate getVhsyudisptkshrskgstrymd9() {
        return vhsyudisptkshrskgstrymd9;
    }

    @Override
    public void setVhsyudisptkshrskgstrymd9(BizDate pVhsyudisptkshrskgstrymd9) {
        vhsyudisptkshrskgstrymd9 = pVhsyudisptkshrskgstrymd9;
    }

    public BizDate getVhsyudisptkshrskgnedymd9() {
        return vhsyudisptkshrskgnedymd9;
    }

    @Override
    public void setVhsyudisptkshrskgnedymd9(BizDate pVhsyudisptkshrskgnedymd9) {
        vhsyudisptkshrskgnedymd9 = pVhsyudisptkshrskgnedymd9;
    }

    public BizCurrency getVhsyudisptkshrskgngos9() {
        return vhsyudisptkshrskgngos9;
    }

    @Override
    public void setVhsyudisptkshrskgngos9(BizCurrency pVhsyudisptkshrskgngos9) {
        vhsyudisptkshrskgngos9 = pVhsyudisptkshrskgngos9;
    }

    public C_Nenkinsyu getVhsyudisptknenkinsyukbn9() {
        return vhsyudisptknenkinsyukbn9;
    }

    @Override
    public void setVhsyudisptknenkinsyukbn9(C_Nenkinsyu pVhsyudisptknenkinsyukbn9) {
        vhsyudisptknenkinsyukbn9 = pVhsyudisptknenkinsyukbn9;
    }

    public Integer getVhsyudisptknenkinkkn9() {
        return vhsyudisptknenkinkkn9;
    }

    @Override
    public void setVhsyudisptknenkinkkn9(Integer pVhsyudisptknenkinkkn9) {
        vhsyudisptknenkinkkn9 = pVhsyudisptknenkinkkn9;
    }

    public C_Tkjyskgnkkn getVhsyudisptktkjyskgnkkn9() {
        return vhsyudisptktkjyskgnkkn9;
    }

    @Override
    public void setVhsyudisptktkjyskgnkkn9(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn9) {
        vhsyudisptktkjyskgnkkn9 = pVhsyudisptktkjyskgnkkn9;
    }

    public BizDate getVhsyudisptktkjkhkdsymd19() {
        return vhsyudisptktkjkhkdsymd19;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd19(BizDate pVhsyudisptktkjkhkdsymd19) {
        vhsyudisptktkjkhkdsymd19 = pVhsyudisptktkjkhkdsymd19;
    }

    public BizDate getVhsyudisptktkjkhkdeymd19() {
        return vhsyudisptktkjkhkdeymd19;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd19(BizDate pVhsyudisptktkjkhkdeymd19) {
        vhsyudisptktkjkhkdeymd19 = pVhsyudisptktkjkhkdeymd19;
    }

    public BizCurrency getVhsyudisptktkjyskgns19() {
        return vhsyudisptktkjyskgns19;
    }

    @Override
    public void setVhsyudisptktkjyskgns19(BizCurrency pVhsyudisptktkjyskgns19) {
        vhsyudisptktkjyskgns19 = pVhsyudisptktkjyskgns19;
    }

    public BizDate getVhsyudisptktkjkhkdsymd29() {
        return vhsyudisptktkjkhkdsymd29;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd29(BizDate pVhsyudisptktkjkhkdsymd29) {
        vhsyudisptktkjkhkdsymd29 = pVhsyudisptktkjkhkdsymd29;
    }

    public BizDate getVhsyudisptktkjkhkdeymd29() {
        return vhsyudisptktkjkhkdeymd29;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd29(BizDate pVhsyudisptktkjkhkdeymd29) {
        vhsyudisptktkjkhkdeymd29 = pVhsyudisptktkjkhkdeymd29;
    }

    public BizCurrency getVhsyudisptktkjyskgns29() {
        return vhsyudisptktkjyskgns29;
    }

    @Override
    public void setVhsyudisptktkjyskgns29(BizCurrency pVhsyudisptktkjyskgns29) {
        vhsyudisptktkjyskgns29 = pVhsyudisptktkjyskgns29;
    }

    public BizDate getVhsyudisptktkjkhkdsymd39() {
        return vhsyudisptktkjkhkdsymd39;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd39(BizDate pVhsyudisptktkjkhkdsymd39) {
        vhsyudisptktkjkhkdsymd39 = pVhsyudisptktkjkhkdsymd39;
    }

    public BizDate getVhsyudisptktkjkhkdeymd39() {
        return vhsyudisptktkjkhkdeymd39;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd39(BizDate pVhsyudisptktkjkhkdeymd39) {
        vhsyudisptktkjkhkdeymd39 = pVhsyudisptktkjkhkdeymd39;
    }

    public BizCurrency getVhsyudisptktkjyskgns39() {
        return vhsyudisptktkjyskgns39;
    }

    @Override
    public void setVhsyudisptktkjyskgns39(BizCurrency pVhsyudisptktkjyskgns39) {
        vhsyudisptktkjyskgns39 = pVhsyudisptktkjyskgns39;
    }

    public BizDate getVhsyudisptktkjkhkdsymd49() {
        return vhsyudisptktkjkhkdsymd49;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd49(BizDate pVhsyudisptktkjkhkdsymd49) {
        vhsyudisptktkjkhkdsymd49 = pVhsyudisptktkjkhkdsymd49;
    }

    public BizDate getVhsyudisptktkjkhkdeymd49() {
        return vhsyudisptktkjkhkdeymd49;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd49(BizDate pVhsyudisptktkjkhkdeymd49) {
        vhsyudisptktkjkhkdeymd49 = pVhsyudisptktkjkhkdeymd49;
    }

    public BizCurrency getVhsyudisptktkjyskgns49() {
        return vhsyudisptktkjyskgns49;
    }

    @Override
    public void setVhsyudisptktkjyskgns49(BizCurrency pVhsyudisptktkjyskgns49) {
        vhsyudisptktkjyskgns49 = pVhsyudisptktkjyskgns49;
    }

    public BizDate getVhsyudisptktkjkhkdsymd59() {
        return vhsyudisptktkjkhkdsymd59;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd59(BizDate pVhsyudisptktkjkhkdsymd59) {
        vhsyudisptktkjkhkdsymd59 = pVhsyudisptktkjkhkdsymd59;
    }

    public BizDate getVhsyudisptktkjkhkdeymd59() {
        return vhsyudisptktkjkhkdeymd59;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd59(BizDate pVhsyudisptktkjkhkdeymd59) {
        vhsyudisptktkjkhkdeymd59 = pVhsyudisptktkjkhkdeymd59;
    }

    public BizCurrency getVhsyudisptktkjyskgns59() {
        return vhsyudisptktkjyskgns59;
    }

    @Override
    public void setVhsyudisptktkjyskgns59(BizCurrency pVhsyudisptktkjyskgns59) {
        vhsyudisptktkjyskgns59 = pVhsyudisptktkjyskgns59;
    }

    public C_Tkjyhyouten getVhsyudisptktkjyhyouten9() {
        return vhsyudisptktkjyhyouten9;
    }

    @Override
    public void setVhsyudisptktkjyhyouten9(C_Tkjyhyouten pVhsyudisptktkjyhyouten9) {
        vhsyudisptktkjyhyouten9 = pVhsyudisptktkjyhyouten9;
    }

    public BizCurrency getVhsyudisptktkjyp9() {
        return vhsyudisptktkjyp9;
    }

    @Override
    public void setVhsyudisptktkjyp9(BizCurrency pVhsyudisptktkjyp9) {
        vhsyudisptktkjyp9 = pVhsyudisptktkjyp9;
    }

    public String getVhsyudisptkhtnpbuicd19() {
        return vhsyudisptkhtnpbuicd19;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd19(String pVhsyudisptkhtnpbuicd19) {
        vhsyudisptkhtnpbuicd19 = pVhsyudisptkhtnpbuicd19;
    }

    public String getVhsyudisptkhtnpbuinm19() {
        return vhsyudisptkhtnpbuinm19;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm19(String pVhsyudisptkhtnpbuinm19) {
        vhsyudisptkhtnpbuinm19 = pVhsyudisptkhtnpbuinm19;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn19() {
        return vhsyudisptkhtnpkkn19;
    }

    @Override
    public void setVhsyudisptkhtnpkkn19(C_Htnpkkn pVhsyudisptkhtnpkkn19) {
        vhsyudisptkhtnpkkn19 = pVhsyudisptkhtnpkkn19;
    }

    public String getVhsyudisptkhtnpbuicd29() {
        return vhsyudisptkhtnpbuicd29;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd29(String pVhsyudisptkhtnpbuicd29) {
        vhsyudisptkhtnpbuicd29 = pVhsyudisptkhtnpbuicd29;
    }

    public String getVhsyudisptkhtnpbuinm29() {
        return vhsyudisptkhtnpbuinm29;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm29(String pVhsyudisptkhtnpbuinm29) {
        vhsyudisptkhtnpbuinm29 = pVhsyudisptkhtnpbuinm29;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn29() {
        return vhsyudisptkhtnpkkn29;
    }

    @Override
    public void setVhsyudisptkhtnpkkn29(C_Htnpkkn pVhsyudisptkhtnpkkn29) {
        vhsyudisptkhtnpkkn29 = pVhsyudisptkhtnpkkn29;
    }

    public String getVhsyudisptkhtnpbuicd39() {
        return vhsyudisptkhtnpbuicd39;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd39(String pVhsyudisptkhtnpbuicd39) {
        vhsyudisptkhtnpbuicd39 = pVhsyudisptkhtnpbuicd39;
    }

    public String getVhsyudisptkhtnpbuinm39() {
        return vhsyudisptkhtnpbuinm39;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm39(String pVhsyudisptkhtnpbuinm39) {
        vhsyudisptkhtnpbuinm39 = pVhsyudisptkhtnpbuinm39;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn39() {
        return vhsyudisptkhtnpkkn39;
    }

    @Override
    public void setVhsyudisptkhtnpkkn39(C_Htnpkkn pVhsyudisptkhtnpkkn39) {
        vhsyudisptkhtnpkkn39 = pVhsyudisptkhtnpkkn39;
    }

    public String getVhsyudisptkhtnpbuicd49() {
        return vhsyudisptkhtnpbuicd49;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd49(String pVhsyudisptkhtnpbuicd49) {
        vhsyudisptkhtnpbuicd49 = pVhsyudisptkhtnpbuicd49;
    }

    public String getVhsyudisptkhtnpbuinm49() {
        return vhsyudisptkhtnpbuinm49;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm49(String pVhsyudisptkhtnpbuinm49) {
        vhsyudisptkhtnpbuinm49 = pVhsyudisptkhtnpbuinm49;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn49() {
        return vhsyudisptkhtnpkkn49;
    }

    @Override
    public void setVhsyudisptkhtnpkkn49(C_Htnpkkn pVhsyudisptkhtnpkkn49) {
        vhsyudisptkhtnpkkn49 = pVhsyudisptkhtnpkkn49;
    }

    public C_TokkoudosghtnpKbn getVhsyudisptktkkdsghtpkbn9() {
        return vhsyudisptktkkdsghtpkbn9;
    }

    @Override
    public void setVhsyudisptktkkdsghtpkbn9(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn9) {
        vhsyudisptktkkdsghtpkbn9 = pVhsyudisptktkkdsghtpkbn9;
    }

    public BizCurrency getVhsyudisptktutakngk9() {
        return vhsyudisptktutakngk9;
    }

    @Override
    public void setVhsyudisptktutakngk9(BizCurrency pVhsyudisptktutakngk9) {
        vhsyudisptktutakngk9 = pVhsyudisptktutakngk9;
    }

    public BizDate getVhsyudisptkkrkhasseiymd9() {
        return vhsyudisptkkrkhasseiymd9;
    }

    @Override
    public void setVhsyudisptkkrkhasseiymd9(BizDate pVhsyudisptkkrkhasseiymd9) {
        vhsyudisptkkrkhasseiymd9 = pVhsyudisptkkrkhasseiymd9;
    }

    public String getVhsyudisptksyouhnnm10() {
        return vhsyudisptksyouhnnm10;
    }

    @Override
    public void setVhsyudisptksyouhnnm10(String pVhsyudisptksyouhnnm10) {
        vhsyudisptksyouhnnm10 = pVhsyudisptksyouhnnm10;
    }

    public C_Tuukasyu getVhsyudisptkktuukasyu10() {
        return vhsyudisptkktuukasyu10;
    }

    @Override
    public void setVhsyudisptkktuukasyu10(C_Tuukasyu pVhsyudisptkktuukasyu10) {
        vhsyudisptkktuukasyu10 = pVhsyudisptkktuukasyu10;
    }

    public C_KataKbn getVhsyudisptokyakukatakbn10() {
        return vhsyudisptokyakukatakbn10;
    }

    @Override
    public void setVhsyudisptokyakukatakbn10(C_KataKbn pVhsyudisptokyakukatakbn10) {
        vhsyudisptokyakukatakbn10 = pVhsyudisptokyakukatakbn10;
    }

    public C_KyhgndkataKbn getVhsyudisptkkyhgdkatakbn10() {
        return vhsyudisptkkyhgdkatakbn10;
    }

    @Override
    public void setVhsyudisptkkyhgdkatakbn10(C_KyhgndkataKbn pVhsyudisptkkyhgdkatakbn10) {
        vhsyudisptkkyhgdkatakbn10 = pVhsyudisptkkyhgdkatakbn10;
    }

    public Integer getVhsyudisptkhhknnen10() {
        return vhsyudisptkhhknnen10;
    }

    @Override
    public void setVhsyudisptkhhknnen10(Integer pVhsyudisptkhhknnen10) {
        vhsyudisptkhhknnen10 = pVhsyudisptkhhknnen10;
    }

    public BizDate getVhsyudisptkkykymd10() {
        return vhsyudisptkkykymd10;
    }

    @Override
    public void setVhsyudisptkkykymd10(BizDate pVhsyudisptkkykymd10) {
        vhsyudisptkkykymd10 = pVhsyudisptkkykymd10;
    }

    public BizDate getVhsyudisptksknnkaisiymd10() {
        return vhsyudisptksknnkaisiymd10;
    }

    @Override
    public void setVhsyudisptksknnkaisiymd10(BizDate pVhsyudisptksknnkaisiymd10) {
        vhsyudisptksknnkaisiymd10 = pVhsyudisptksknnkaisiymd10;
    }

    public BizDate getVhsyudisptkgaskkaisiymd10() {
        return vhsyudisptkgaskkaisiymd10;
    }

    @Override
    public void setVhsyudisptkgaskkaisiymd10(BizDate pVhsyudisptkgaskkaisiymd10) {
        vhsyudisptkgaskkaisiymd10 = pVhsyudisptkgaskkaisiymd10;
    }

    public BizDate getVhsyudisptkhkskkaisiymd10() {
        return vhsyudisptkhkskkaisiymd10;
    }

    @Override
    public void setVhsyudisptkhkskkaisiymd10(BizDate pVhsyudisptkhkskkaisiymd10) {
        vhsyudisptkhkskkaisiymd10 = pVhsyudisptkhkskkaisiymd10;
    }

    public BizDate getVhsyudisptkhkgskksiymd10() {
        return vhsyudisptkhkgskksiymd10;
    }

    @Override
    public void setVhsyudisptkhkgskksiymd10(BizDate pVhsyudisptkhkgskksiymd10) {
        vhsyudisptkhkgskksiymd10 = pVhsyudisptkhkgskksiymd10;
    }

    public Integer getVhsyudisptkhknkkn10() {
        return vhsyudisptkhknkkn10;
    }

    @Override
    public void setVhsyudisptkhknkkn10(Integer pVhsyudisptkhknkkn10) {
        vhsyudisptkhknkkn10 = pVhsyudisptkhknkkn10;
    }

    public C_HknkknsmnKbn getVhsyudisptkhknkknsmnkbn10() {
        return vhsyudisptkhknkknsmnkbn10;
    }

    @Override
    public void setVhsyudisptkhknkknsmnkbn10(C_HknkknsmnKbn pVhsyudisptkhknkknsmnkbn10) {
        vhsyudisptkhknkknsmnkbn10 = pVhsyudisptkhknkknsmnkbn10;
    }

    public Integer getVhsyudisptkhrkkkn10() {
        return vhsyudisptkhrkkkn10;
    }

    @Override
    public void setVhsyudisptkhrkkkn10(Integer pVhsyudisptkhrkkkn10) {
        vhsyudisptkhrkkkn10 = pVhsyudisptkhrkkkn10;
    }

    public C_HrkkknsmnKbn getVhsyudisptkhrkkknsmnkbn10() {
        return vhsyudisptkhrkkknsmnkbn10;
    }

    @Override
    public void setVhsyudisptkhrkkknsmnkbn10(C_HrkkknsmnKbn pVhsyudisptkhrkkknsmnkbn10) {
        vhsyudisptkhrkkknsmnkbn10 = pVhsyudisptkhrkkknsmnkbn10;
    }

    public C_KihonssyuruiKbn getVhsyudisptkkihsyuruikbn10() {
        return vhsyudisptkkihsyuruikbn10;
    }

    @Override
    public void setVhsyudisptkkihsyuruikbn10(C_KihonssyuruiKbn pVhsyudisptkkihsyuruikbn10) {
        vhsyudisptkkihsyuruikbn10 = pVhsyudisptkkihsyuruikbn10;
    }

    public BizCurrency getVhsyudisptkkihons10() {
        return vhsyudisptkkihons10;
    }

    @Override
    public void setVhsyudisptkkihons10(BizCurrency pVhsyudisptkkihons10) {
        vhsyudisptkkihons10 = pVhsyudisptkkihons10;
    }

    public BizCurrency getVhsyudisptkp10() {
        return vhsyudisptkp10;
    }

    @Override
    public void setVhsyudisptkp10(BizCurrency pVhsyudisptkp10) {
        vhsyudisptkp10 = pVhsyudisptkp10;
    }

    public BizCurrency getVhsyudisptkkihonkyhgk10() {
        return vhsyudisptkkihonkyhgk10;
    }

    @Override
    public void setVhsyudisptkkihonkyhgk10(BizCurrency pVhsyudisptkkihonkyhgk10) {
        vhsyudisptkkihonkyhgk10 = pVhsyudisptkkihonkyhgk10;
    }

    public BizCurrency getVhsyudisptknextkosgop10() {
        return vhsyudisptknextkosgop10;
    }

    @Override
    public void setVhsyudisptknextkosgop10(BizCurrency pVhsyudisptknextkosgop10) {
        vhsyudisptknextkosgop10 = pVhsyudisptknextkosgop10;
    }

    public C_SyukyhkinkataKbn getVhsyudisptksykyhkatakbn10() {
        return vhsyudisptksykyhkatakbn10;
    }

    @Override
    public void setVhsyudisptksykyhkatakbn10(C_SyukyhkinkataKbn pVhsyudisptksykyhkatakbn10) {
        vhsyudisptksykyhkatakbn10 = pVhsyudisptksykyhkatakbn10;
    }

    public C_6daiLdKbn getVhsyudisptk6daildkbn10() {
        return vhsyudisptk6daildkbn10;
    }

    @Override
    public void setVhsyudisptk6daildkbn10(C_6daiLdKbn pVhsyudisptk6daildkbn10) {
        vhsyudisptk6daildkbn10 = pVhsyudisptk6daildkbn10;
    }

    public BizCurrency getVhsyudisptkganyukyhntgk10() {
        return vhsyudisptkganyukyhntgk10;
    }

    @Override
    public void setVhsyudisptkganyukyhntgk10(BizCurrency pVhsyudisptkganyukyhntgk10) {
        vhsyudisptkganyukyhntgk10 = pVhsyudisptkganyukyhntgk10;
    }

    public BizDate getVhsyudisptkshrskgstrymd10() {
        return vhsyudisptkshrskgstrymd10;
    }

    @Override
    public void setVhsyudisptkshrskgstrymd10(BizDate pVhsyudisptkshrskgstrymd10) {
        vhsyudisptkshrskgstrymd10 = pVhsyudisptkshrskgstrymd10;
    }

    public BizDate getVhsyudisptkshrskgnedymd10() {
        return vhsyudisptkshrskgnedymd10;
    }

    @Override
    public void setVhsyudisptkshrskgnedymd10(BizDate pVhsyudisptkshrskgnedymd10) {
        vhsyudisptkshrskgnedymd10 = pVhsyudisptkshrskgnedymd10;
    }

    public BizCurrency getVhsyudisptkshrskgngos10() {
        return vhsyudisptkshrskgngos10;
    }

    @Override
    public void setVhsyudisptkshrskgngos10(BizCurrency pVhsyudisptkshrskgngos10) {
        vhsyudisptkshrskgngos10 = pVhsyudisptkshrskgngos10;
    }

    public C_Nenkinsyu getVhsyudisptknenkinsyukbn10() {
        return vhsyudisptknenkinsyukbn10;
    }

    @Override
    public void setVhsyudisptknenkinsyukbn10(C_Nenkinsyu pVhsyudisptknenkinsyukbn10) {
        vhsyudisptknenkinsyukbn10 = pVhsyudisptknenkinsyukbn10;
    }

    public Integer getVhsyudisptknenkinkkn10() {
        return vhsyudisptknenkinkkn10;
    }

    @Override
    public void setVhsyudisptknenkinkkn10(Integer pVhsyudisptknenkinkkn10) {
        vhsyudisptknenkinkkn10 = pVhsyudisptknenkinkkn10;
    }

    public C_Tkjyskgnkkn getVhsyudisptktkjyskgnkkn10() {
        return vhsyudisptktkjyskgnkkn10;
    }

    @Override
    public void setVhsyudisptktkjyskgnkkn10(C_Tkjyskgnkkn pVhsyudisptktkjyskgnkkn10) {
        vhsyudisptktkjyskgnkkn10 = pVhsyudisptktkjyskgnkkn10;
    }

    public BizDate getVhsyudisptktkjkhkdsymd110() {
        return vhsyudisptktkjkhkdsymd110;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd110(BizDate pVhsyudisptktkjkhkdsymd110) {
        vhsyudisptktkjkhkdsymd110 = pVhsyudisptktkjkhkdsymd110;
    }

    public BizDate getVhsyudisptktkjkhkdeymd110() {
        return vhsyudisptktkjkhkdeymd110;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd110(BizDate pVhsyudisptktkjkhkdeymd110) {
        vhsyudisptktkjkhkdeymd110 = pVhsyudisptktkjkhkdeymd110;
    }

    public BizCurrency getVhsyudisptktkjyskgns110() {
        return vhsyudisptktkjyskgns110;
    }

    @Override
    public void setVhsyudisptktkjyskgns110(BizCurrency pVhsyudisptktkjyskgns110) {
        vhsyudisptktkjyskgns110 = pVhsyudisptktkjyskgns110;
    }

    public BizDate getVhsyudisptktkjkhkdsymd210() {
        return vhsyudisptktkjkhkdsymd210;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd210(BizDate pVhsyudisptktkjkhkdsymd210) {
        vhsyudisptktkjkhkdsymd210 = pVhsyudisptktkjkhkdsymd210;
    }

    public BizDate getVhsyudisptktkjkhkdeymd210() {
        return vhsyudisptktkjkhkdeymd210;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd210(BizDate pVhsyudisptktkjkhkdeymd210) {
        vhsyudisptktkjkhkdeymd210 = pVhsyudisptktkjkhkdeymd210;
    }

    public BizCurrency getVhsyudisptktkjyskgns210() {
        return vhsyudisptktkjyskgns210;
    }

    @Override
    public void setVhsyudisptktkjyskgns210(BizCurrency pVhsyudisptktkjyskgns210) {
        vhsyudisptktkjyskgns210 = pVhsyudisptktkjyskgns210;
    }

    public BizDate getVhsyudisptktkjkhkdsymd310() {
        return vhsyudisptktkjkhkdsymd310;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd310(BizDate pVhsyudisptktkjkhkdsymd310) {
        vhsyudisptktkjkhkdsymd310 = pVhsyudisptktkjkhkdsymd310;
    }

    public BizDate getVhsyudisptktkjkhkdeymd310() {
        return vhsyudisptktkjkhkdeymd310;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd310(BizDate pVhsyudisptktkjkhkdeymd310) {
        vhsyudisptktkjkhkdeymd310 = pVhsyudisptktkjkhkdeymd310;
    }

    public BizCurrency getVhsyudisptktkjyskgns310() {
        return vhsyudisptktkjyskgns310;
    }

    @Override
    public void setVhsyudisptktkjyskgns310(BizCurrency pVhsyudisptktkjyskgns310) {
        vhsyudisptktkjyskgns310 = pVhsyudisptktkjyskgns310;
    }

    public BizDate getVhsyudisptktkjkhkdsymd410() {
        return vhsyudisptktkjkhkdsymd410;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd410(BizDate pVhsyudisptktkjkhkdsymd410) {
        vhsyudisptktkjkhkdsymd410 = pVhsyudisptktkjkhkdsymd410;
    }

    public BizDate getVhsyudisptktkjkhkdeymd410() {
        return vhsyudisptktkjkhkdeymd410;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd410(BizDate pVhsyudisptktkjkhkdeymd410) {
        vhsyudisptktkjkhkdeymd410 = pVhsyudisptktkjkhkdeymd410;
    }

    public BizCurrency getVhsyudisptktkjyskgns410() {
        return vhsyudisptktkjyskgns410;
    }

    @Override
    public void setVhsyudisptktkjyskgns410(BizCurrency pVhsyudisptktkjyskgns410) {
        vhsyudisptktkjyskgns410 = pVhsyudisptktkjyskgns410;
    }

    public BizDate getVhsyudisptktkjkhkdsymd510() {
        return vhsyudisptktkjkhkdsymd510;
    }

    @Override
    public void setVhsyudisptktkjkhkdsymd510(BizDate pVhsyudisptktkjkhkdsymd510) {
        vhsyudisptktkjkhkdsymd510 = pVhsyudisptktkjkhkdsymd510;
    }

    public BizDate getVhsyudisptktkjkhkdeymd510() {
        return vhsyudisptktkjkhkdeymd510;
    }

    @Override
    public void setVhsyudisptktkjkhkdeymd510(BizDate pVhsyudisptktkjkhkdeymd510) {
        vhsyudisptktkjkhkdeymd510 = pVhsyudisptktkjkhkdeymd510;
    }

    public BizCurrency getVhsyudisptktkjyskgns510() {
        return vhsyudisptktkjyskgns510;
    }

    @Override
    public void setVhsyudisptktkjyskgns510(BizCurrency pVhsyudisptktkjyskgns510) {
        vhsyudisptktkjyskgns510 = pVhsyudisptktkjyskgns510;
    }

    public C_Tkjyhyouten getVhsyudisptktkjyhyouten10() {
        return vhsyudisptktkjyhyouten10;
    }

    @Override
    public void setVhsyudisptktkjyhyouten10(C_Tkjyhyouten pVhsyudisptktkjyhyouten10) {
        vhsyudisptktkjyhyouten10 = pVhsyudisptktkjyhyouten10;
    }

    public BizCurrency getVhsyudisptktkjyp10() {
        return vhsyudisptktkjyp10;
    }

    @Override
    public void setVhsyudisptktkjyp10(BizCurrency pVhsyudisptktkjyp10) {
        vhsyudisptktkjyp10 = pVhsyudisptktkjyp10;
    }

    public String getVhsyudisptkhtnpbuicd110() {
        return vhsyudisptkhtnpbuicd110;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd110(String pVhsyudisptkhtnpbuicd110) {
        vhsyudisptkhtnpbuicd110 = pVhsyudisptkhtnpbuicd110;
    }

    public String getVhsyudisptkhtnpbuinm110() {
        return vhsyudisptkhtnpbuinm110;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm110(String pVhsyudisptkhtnpbuinm110) {
        vhsyudisptkhtnpbuinm110 = pVhsyudisptkhtnpbuinm110;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn110() {
        return vhsyudisptkhtnpkkn110;
    }

    @Override
    public void setVhsyudisptkhtnpkkn110(C_Htnpkkn pVhsyudisptkhtnpkkn110) {
        vhsyudisptkhtnpkkn110 = pVhsyudisptkhtnpkkn110;
    }

    public String getVhsyudisptkhtnpbuicd210() {
        return vhsyudisptkhtnpbuicd210;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd210(String pVhsyudisptkhtnpbuicd210) {
        vhsyudisptkhtnpbuicd210 = pVhsyudisptkhtnpbuicd210;
    }

    public String getVhsyudisptkhtnpbuinm210() {
        return vhsyudisptkhtnpbuinm210;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm210(String pVhsyudisptkhtnpbuinm210) {
        vhsyudisptkhtnpbuinm210 = pVhsyudisptkhtnpbuinm210;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn210() {
        return vhsyudisptkhtnpkkn210;
    }

    @Override
    public void setVhsyudisptkhtnpkkn210(C_Htnpkkn pVhsyudisptkhtnpkkn210) {
        vhsyudisptkhtnpkkn210 = pVhsyudisptkhtnpkkn210;
    }

    public String getVhsyudisptkhtnpbuicd310() {
        return vhsyudisptkhtnpbuicd310;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd310(String pVhsyudisptkhtnpbuicd310) {
        vhsyudisptkhtnpbuicd310 = pVhsyudisptkhtnpbuicd310;
    }

    public String getVhsyudisptkhtnpbuinm310() {
        return vhsyudisptkhtnpbuinm310;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm310(String pVhsyudisptkhtnpbuinm310) {
        vhsyudisptkhtnpbuinm310 = pVhsyudisptkhtnpbuinm310;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn310() {
        return vhsyudisptkhtnpkkn310;
    }

    @Override
    public void setVhsyudisptkhtnpkkn310(C_Htnpkkn pVhsyudisptkhtnpkkn310) {
        vhsyudisptkhtnpkkn310 = pVhsyudisptkhtnpkkn310;
    }

    public String getVhsyudisptkhtnpbuicd410() {
        return vhsyudisptkhtnpbuicd410;
    }

    @Override
    public void setVhsyudisptkhtnpbuicd410(String pVhsyudisptkhtnpbuicd410) {
        vhsyudisptkhtnpbuicd410 = pVhsyudisptkhtnpbuicd410;
    }

    public String getVhsyudisptkhtnpbuinm410() {
        return vhsyudisptkhtnpbuinm410;
    }

    @Override
    public void setVhsyudisptkhtnpbuinm410(String pVhsyudisptkhtnpbuinm410) {
        vhsyudisptkhtnpbuinm410 = pVhsyudisptkhtnpbuinm410;
    }

    public C_Htnpkkn getVhsyudisptkhtnpkkn410() {
        return vhsyudisptkhtnpkkn410;
    }

    @Override
    public void setVhsyudisptkhtnpkkn410(C_Htnpkkn pVhsyudisptkhtnpkkn410) {
        vhsyudisptkhtnpkkn410 = pVhsyudisptkhtnpkkn410;
    }

    public C_TokkoudosghtnpKbn getVhsyudisptktkkdsghtpkbn10() {
        return vhsyudisptktkkdsghtpkbn10;
    }

    @Override
    public void setVhsyudisptktkkdsghtpkbn10(C_TokkoudosghtnpKbn pVhsyudisptktkkdsghtpkbn10) {
        vhsyudisptktkkdsghtpkbn10 = pVhsyudisptktkkdsghtpkbn10;
    }

    public BizCurrency getVhsyudisptktutakngk10() {
        return vhsyudisptktutakngk10;
    }

    @Override
    public void setVhsyudisptktutakngk10(BizCurrency pVhsyudisptktutakngk10) {
        vhsyudisptktutakngk10 = pVhsyudisptktutakngk10;
    }

    public BizDate getVhsyudisptkkrkhasseiymd10() {
        return vhsyudisptkkrkhasseiymd10;
    }

    @Override
    public void setVhsyudisptkkrkhasseiymd10(BizDate pVhsyudisptkkrkhasseiymd10) {
        vhsyudisptkkrkhasseiymd10 = pVhsyudisptkkrkhasseiymd10;
    }

    public C_UmuKbn getVhsyusyunkhknumu() {
        return vhsyusyunkhknumu;
    }

    @Override
    public void setVhsyusyunkhknumu(C_UmuKbn pVhsyusyunkhknumu) {
        vhsyusyunkhknumu = pVhsyusyunkhknumu;
    }

    public C_UmuKbn getVhsyusyugannyukyhumu() {
        return vhsyusyugannyukyhumu;
    }

    @Override
    public void setVhsyusyugannyukyhumu(C_UmuKbn pVhsyusyugannyukyhumu) {
        vhsyusyugannyukyhumu = pVhsyusyugannyukyhumu;
    }

    public C_KhnkyhkgbairituKbn getVhsyusyukhnkyhkgbairitukbn() {
        return vhsyusyukhnkyhkgbairitukbn;
    }

    @Override
    public void setVhsyusyukhnkyhkgbairitukbn(C_KhnkyhkgbairituKbn pVhsyusyukhnkyhkgbairitukbn) {
        vhsyusyukhnkyhkgbairitukbn = pVhsyusyukhnkyhkgbairitukbn;
    }

    public C_UmuKbn getVhsyusyusndkyhkinshrskgnumu() {
        return vhsyusyusndkyhkinshrskgnumu;
    }

    @Override
    public void setVhsyusyusndkyhkinshrskgnumu(C_UmuKbn pVhsyusyusndkyhkinshrskgnumu) {
        vhsyusyusndkyhkinshrskgnumu = pVhsyusyusndkyhkinshrskgnumu;
    }

    public C_UmuKbn getVhsyusyuhghkumu() {
        return vhsyusyuhghkumu;
    }

    @Override
    public void setVhsyusyuhghkumu(C_UmuKbn pVhsyusyuhghkumu) {
        vhsyusyuhghkumu = pVhsyusyuhghkumu;
    }

    public C_UmuKbn getVhsyusyunextkosumu() {
        return vhsyusyunextkosumu;
    }

    @Override
    public void setVhsyusyunextkosumu(C_UmuKbn pVhsyudsyunextkosumu) {
        vhsyusyunextkosumu = pVhsyudsyunextkosumu;
    }

    public String getVhsyudisptksyouhncd1() {
        return vhsyudisptksyouhncd1;
    }

    @Override
    public void setVhsyudisptksyouhncd1(String pVhsyudisptksyouhncd1) {
        vhsyudisptksyouhncd1 = pVhsyudisptksyouhncd1;
    }

    public String getVhsyudisptksyouhncd2() {
        return vhsyudisptksyouhncd2;
    }

    @Override
    public void setVhsyudisptksyouhncd2(String pVhsyudisptksyouhncd2) {
        vhsyudisptksyouhncd2 = pVhsyudisptksyouhncd2;
    }

    public String getVhsyudisptksyouhncd3() {
        return vhsyudisptksyouhncd3;
    }

    @Override
    public void setVhsyudisptksyouhncd3(String pVhsyudisptksyouhncd3) {
        vhsyudisptksyouhncd3 = pVhsyudisptksyouhncd3;
    }

    public String getVhsyudisptksyouhncd4() {
        return vhsyudisptksyouhncd4;
    }

    @Override
    public void setVhsyudisptksyouhncd4(String pVhsyudisptksyouhncd4) {
        vhsyudisptksyouhncd4 = pVhsyudisptksyouhncd4;
    }

    public String getVhsyudisptksyouhncd5() {
        return vhsyudisptksyouhncd5;
    }

    @Override
    public void setVhsyudisptksyouhncd5(String pVhsyudisptksyouhncd5) {
        vhsyudisptksyouhncd5 = pVhsyudisptksyouhncd5;
    }

    public String getVhsyudisptksyouhncd6() {
        return vhsyudisptksyouhncd6;
    }

    @Override
    public void setVhsyudisptksyouhncd6(String pVhsyudisptksyouhncd6) {
        vhsyudisptksyouhncd6 = pVhsyudisptksyouhncd6;
    }

    public String getVhsyudisptksyouhncd7() {
        return vhsyudisptksyouhncd7;
    }

    @Override
    public void setVhsyudisptksyouhncd7(String pVhsyudisptksyouhncd7) {
        vhsyudisptksyouhncd7 = pVhsyudisptksyouhncd7;
    }

    public String getVhsyudisptksyouhncd8() {
        return vhsyudisptksyouhncd8;
    }

    @Override
    public void setVhsyudisptksyouhncd8(String pVhsyudisptksyouhncd8) {
        vhsyudisptksyouhncd8 = pVhsyudisptksyouhncd8;
    }

    public String getVhsyudisptksyouhncd9() {
        return vhsyudisptksyouhncd9;
    }

    @Override
    public void setVhsyudisptksyouhncd9(String pVhsyudisptksyouhncd9) {
        vhsyudisptksyouhncd9 = pVhsyudisptksyouhncd9;
    }

    public String getVhsyudisptksyouhncd10() {
        return vhsyudisptksyouhncd10;
    }

    @Override
    public void setVhsyudisptksyouhncd10(String pVhsyudisptksyouhncd10) {
        vhsyudisptksyouhncd10 = pVhsyudisptksyouhncd10;
    }

    public C_UmuKbn getVhsyudisptknkhknumu1() {
        return vhsyudisptknkhknumu1;
    }

    @Override
    public void setVhsyudisptknkhknumu1(C_UmuKbn pVhsyudisptknkhknumu1) {
        vhsyudisptknkhknumu1 = pVhsyudisptknkhknumu1;
    }

    public C_UmuKbn getVhsyudisptknkhknumu2() {
        return vhsyudisptknkhknumu2;
    }

    @Override
    public void setVhsyudisptknkhknumu2(C_UmuKbn pVhsyudisptknkhknumu2) {
        vhsyudisptknkhknumu2 = pVhsyudisptknkhknumu2;
    }

    public C_UmuKbn getVhsyudisptknkhknumu3() {
        return vhsyudisptknkhknumu3;
    }

    @Override
    public void setVhsyudisptknkhknumu3(C_UmuKbn pVhsyudisptknkhknumu3) {
        vhsyudisptknkhknumu3 = pVhsyudisptknkhknumu3;
    }

    public C_UmuKbn getVhsyudisptknkhknumu4() {
        return vhsyudisptknkhknumu4;
    }

    @Override
    public void setVhsyudisptknkhknumu4(C_UmuKbn pVhsyudisptknkhknumu4) {
        vhsyudisptknkhknumu4 = pVhsyudisptknkhknumu4;
    }

    public C_UmuKbn getVhsyudisptknkhknumu5() {
        return vhsyudisptknkhknumu5;
    }

    @Override
    public void setVhsyudisptknkhknumu5(C_UmuKbn pVhsyudisptknkhknumu5) {
        vhsyudisptknkhknumu5 = pVhsyudisptknkhknumu5;
    }

    public C_UmuKbn getVhsyudisptknkhknumu6() {
        return vhsyudisptknkhknumu6;
    }

    @Override
    public void setVhsyudisptknkhknumu6(C_UmuKbn pVhsyudisptknkhknumu6) {
        vhsyudisptknkhknumu6 = pVhsyudisptknkhknumu6;
    }

    public C_UmuKbn getVhsyudisptknkhknumu7() {
        return vhsyudisptknkhknumu7;
    }

    @Override
    public void setVhsyudisptknkhknumu7(C_UmuKbn pVhsyudisptknkhknumu7) {
        vhsyudisptknkhknumu7 = pVhsyudisptknkhknumu7;
    }

    public C_UmuKbn getVhsyudisptknkhknumu8() {
        return vhsyudisptknkhknumu8;
    }

    @Override
    public void setVhsyudisptknkhknumu8(C_UmuKbn pVhsyudisptknkhknumu8) {
        vhsyudisptknkhknumu8 = pVhsyudisptknkhknumu8;
    }

    public C_UmuKbn getVhsyudisptknkhknumu9() {
        return vhsyudisptknkhknumu9;
    }

    @Override
    public void setVhsyudisptknkhknumu9(C_UmuKbn pVhsyudisptknkhknumu9) {
        vhsyudisptknkhknumu9 = pVhsyudisptknkhknumu9;
    }

    public C_UmuKbn getVhsyudisptknkhknumu10() {
        return vhsyudisptknkhknumu10;
    }

    @Override
    public void setVhsyudisptknkhknumu10(C_UmuKbn pVhsyudisptknkhknumu10) {
        vhsyudisptknkhknumu10 = pVhsyudisptknkhknumu10;
    }

    public C_UmuKbn getVhsyudisptkhghkumu1() {
        return vhsyuddisptkhghkumu1;
    }

    @Override
    public void setVhsyudisptkhghkumu1(C_UmuKbn pVhsyudisptkhghkumu1) {
        vhsyuddisptkhghkumu1 = pVhsyudisptkhghkumu1;
    }

    public C_UmuKbn getVhsyudisptkhghkumu2() {
        return vhsyuddisptkhghkumu2;
    }

    @Override
    public void setVhsyudisptkhghkumu2(C_UmuKbn pVhsyudisptkhghkumu2) {
        vhsyuddisptkhghkumu2 = pVhsyudisptkhghkumu2;
    }

    public C_UmuKbn getVhsyudisptkhghkumu3() {
        return vhsyuddisptkhghkumu3;
    }

    @Override
    public void setVhsyudisptkhghkumu3(C_UmuKbn pVhsyudisptkhghkumu3) {
        vhsyuddisptkhghkumu3 = pVhsyudisptkhghkumu3;
    }

    public C_UmuKbn getVhsyudisptkhghkumu4() {
        return vhsyuddisptkhghkumu4;
    }

    @Override
    public void setVhsyudisptkhghkumu4(C_UmuKbn pVhsyudisptkhghkumu4) {
        vhsyuddisptkhghkumu4 = pVhsyudisptkhghkumu4;
    }

    public C_UmuKbn getVhsyudisptkhghkumu5() {
        return vhsyuddisptkhghkumu5;
    }

    @Override
    public void setVhsyudisptkhghkumu5(C_UmuKbn pVhsyudisptkhghkumu5) {
        vhsyuddisptkhghkumu5 = pVhsyudisptkhghkumu5;
    }

    public C_UmuKbn getVhsyudisptkhghkumu6() {
        return vhsyuddisptkhghkumu6;
    }

    @Override
    public void setVhsyudisptkhghkumu6(C_UmuKbn pVhsyudisptkhghkumu6) {
        vhsyuddisptkhghkumu6 = pVhsyudisptkhghkumu6;
    }

    public C_UmuKbn getVhsyudisptkhghkumu7() {
        return vhsyuddisptkhghkumu7;
    }

    @Override
    public void setVhsyudisptkhghkumu7(C_UmuKbn pVhsyudisptkhghkumu7) {
        vhsyuddisptkhghkumu7 = pVhsyudisptkhghkumu7;
    }

    public C_UmuKbn getVhsyudisptkhghkumu8() {
        return vhsyuddisptkhghkumu8;
    }

    @Override
    public void setVhsyudisptkhghkumu8(C_UmuKbn pVhsyudisptkhghkumu8) {
        vhsyuddisptkhghkumu8 = pVhsyudisptkhghkumu8;
    }

    public C_UmuKbn getVhsyudisptkhghkumu9() {
        return vhsyuddisptkhghkumu9;
    }

    @Override
    public void setVhsyudisptkhghkumu9(C_UmuKbn pVhsyudisptkhghkumu9) {
        vhsyuddisptkhghkumu9 = pVhsyudisptkhghkumu9;
    }

    public C_UmuKbn getVhsyudisptkhghkumu10() {
        return vhsyuddisptkhghkumu10;
    }

    @Override
    public void setVhsyudisptkhghkumu10(C_UmuKbn pVhsyudisptkhghkumu10) {
        vhsyuddisptkhghkumu10 = pVhsyudisptkhghkumu10;
    }

    public C_UmuKbn getVhsyudisptkgannyukyhumu1() {
        return vhsyuddisptkgannyukyhumu1 ;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu1 (C_UmuKbn pVhsyudisptkgannyukyhumu1 ) {
        vhsyuddisptkgannyukyhumu1  = pVhsyudisptkgannyukyhumu1 ;
    }

    public C_UmuKbn getVhsyudisptkgannyukyhumu2() {
        return vhsyuddisptkgannyukyhumu2;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu2(C_UmuKbn pVhsyudisptkgannyukyhumu2) {
        vhsyuddisptkgannyukyhumu2 = pVhsyudisptkgannyukyhumu2;
    }

    public C_UmuKbn getVhsyudisptkgannyukyhumu3() {
        return vhsyuddisptkgannyukyhumu3;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu3(C_UmuKbn pVhsyudisptkgannyukyhumu3) {
        vhsyuddisptkgannyukyhumu3 = pVhsyudisptkgannyukyhumu3;
    }

    public C_UmuKbn getVhsyudisptkgannyukyhumu4() {
        return vhsyuddisptkgannyukyhumu4;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu4(C_UmuKbn pVhsyudisptkgannyukyhumu4) {
        vhsyuddisptkgannyukyhumu4 = pVhsyudisptkgannyukyhumu4;
    }

    public C_UmuKbn getVhsyudisptkgannyukyhumu5() {
        return vhsyuddisptkgannyukyhumu5;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu5(C_UmuKbn pVhsyudisptkgannyukyhumu5) {
        vhsyuddisptkgannyukyhumu5 = pVhsyudisptkgannyukyhumu5;
    }

    public C_UmuKbn getVhsyudisptkgannyukyhumu6() {
        return vhsyuddisptkgannyukyhumu6;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu6(C_UmuKbn pVhsyudisptkgannyukyhumu6) {
        vhsyuddisptkgannyukyhumu6 = pVhsyudisptkgannyukyhumu6;
    }

    public C_UmuKbn getVhsyudisptkgannyukyhumu7() {
        return vhsyuddisptkgannyukyhumu7;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu7(C_UmuKbn pVhsyudisptkgannyukyhumu7) {
        vhsyuddisptkgannyukyhumu7 = pVhsyudisptkgannyukyhumu7;
    }

    public C_UmuKbn getVhsyudisptkgannyukyhumu8() {
        return vhsyuddisptkgannyukyhumu8;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu8(C_UmuKbn pVhsyudisptkgannyukyhumu8) {
        vhsyuddisptkgannyukyhumu8 = pVhsyudisptkgannyukyhumu8;
    }

    public C_UmuKbn getVhsyudisptkgannyukyhumu9() {
        return vhsyuddisptkgannyukyhumu9;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu9(C_UmuKbn pVhsyudisptkgannyukyhumu9) {
        vhsyuddisptkgannyukyhumu9 = pVhsyudisptkgannyukyhumu9;
    }

    public C_UmuKbn getVhsyudisptkgannyukyhumu10() {
        return vhsyuddisptkgannyukyhumu10;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu10(C_UmuKbn pVhsyudisptkgannyukyhumu10) {
        vhsyuddisptkgannyukyhumu10 = pVhsyudisptkgannyukyhumu10;
    }

    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu1() {
        return vhsyudisptksndkyhkinshrskgnumu1;
    }

    @Override
    public void setVhsyudisptksndkyhkinshrskgnumu1(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu1) {
        vhsyudisptksndkyhkinshrskgnumu1 = pVhsyudisptksndkyhkinshrskgnumu1;
    }

    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu2() {
        return vhsyudisptksndkyhkinshrskgnumu2;
    }

    @Override
    public void setVhsyudisptksndkyhkinshrskgnumu2(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu2) {
        vhsyudisptksndkyhkinshrskgnumu2 = pVhsyudisptksndkyhkinshrskgnumu2;
    }

    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu3() {
        return vhsyudisptksndkyhkinshrskgnumu3;
    }

    @Override
    public void setVhsyudisptksndkyhkinshrskgnumu3(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu3) {
        vhsyudisptksndkyhkinshrskgnumu3 = pVhsyudisptksndkyhkinshrskgnumu3;
    }

    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu4() {
        return vhsyudisptksndkyhkinshrskgnumu4;
    }

    @Override
    public void setVhsyudisptksndkyhkinshrskgnumu4(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu4) {
        vhsyudisptksndkyhkinshrskgnumu4 = pVhsyudisptksndkyhkinshrskgnumu4;
    }

    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu5() {
        return vhsyudisptksndkyhkinshrskgnumu5;
    }

    @Override
    public void setVhsyudisptksndkyhkinshrskgnumu5(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu5) {
        vhsyudisptksndkyhkinshrskgnumu5 = pVhsyudisptksndkyhkinshrskgnumu5;
    }

    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu6() {
        return vhsyudisptksndkyhkinshrskgnumu6;
    }

    @Override
    public void setVhsyudisptksndkyhkinshrskgnumu6(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu6) {
        vhsyudisptksndkyhkinshrskgnumu6 = pVhsyudisptksndkyhkinshrskgnumu6;
    }

    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu7() {
        return vhsyudisptksndkyhkinshrskgnumu7;
    }

    @Override
    public void setVhsyudisptksndkyhkinshrskgnumu7(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu7) {
        vhsyudisptksndkyhkinshrskgnumu7 = pVhsyudisptksndkyhkinshrskgnumu7;
    }

    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu8() {
        return vhsyudisptksndkyhkinshrskgnumu8;
    }

    @Override
    public void setVhsyudisptksndkyhkinshrskgnumu8(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu8) {
        vhsyudisptksndkyhkinshrskgnumu8 = pVhsyudisptksndkyhkinshrskgnumu8;
    }

    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu9() {
        return vhsyudisptksndkyhkinshrskgnumu9;
    }

    @Override
    public void setVhsyudisptksndkyhkinshrskgnumu9(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu9) {
        vhsyudisptksndkyhkinshrskgnumu9 = pVhsyudisptksndkyhkinshrskgnumu9;
    }

    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu10() {
        return vhsyudisptksndkyhkinshrskgnumu10;
    }

    @Override
    public void setVhsyudisptksndkyhkinshrskgnumu10(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu10) {
        vhsyudisptksndkyhkinshrskgnumu10 = pVhsyudisptksndkyhkinshrskgnumu10;
    }

    public C_UmuKbn getVhsyudisptknextkosumu1() {
        return vhsyudisptknextkosumu1;
    }

    @Override
    public void setVhsyudisptknextkosumu1(C_UmuKbn pVhsyudisptknextkosumu1) {
        vhsyudisptknextkosumu1 = pVhsyudisptknextkosumu1;
    }

    public C_UmuKbn getVhsyudisptknextkosumu2() {
        return vhsyudisptknextkosumu2;
    }

    @Override
    public void setVhsyudisptknextkosumu2(C_UmuKbn pVhsyudisptknextkosumu2) {
        vhsyudisptknextkosumu2 = pVhsyudisptknextkosumu2;
    }

    public C_UmuKbn getVhsyudisptknextkosumu3() {
        return vhsyudisptknextkosumu3;
    }

    @Override
    public void setVhsyudisptknextkosumu3(C_UmuKbn pVhsyudisptknextkosumu3) {
        vhsyudisptknextkosumu3 = pVhsyudisptknextkosumu3;
    }

    public C_UmuKbn getVhsyudisptknextkosumu4() {
        return vhsyudisptknextkosumu4;
    }

    @Override
    public void setVhsyudisptknextkosumu4(C_UmuKbn pVhsyudisptknextkosumu4) {
        vhsyudisptknextkosumu4 = pVhsyudisptknextkosumu4;
    }

    public C_UmuKbn getVhsyudisptknextkosumu5() {
        return vhsyudisptknextkosumu5;
    }

    @Override
    public void setVhsyudisptknextkosumu5(C_UmuKbn pVhsyudisptknextkosumu5) {
        vhsyudisptknextkosumu5 = pVhsyudisptknextkosumu5;
    }

    public C_UmuKbn getVhsyudisptknextkosumu6() {
        return vhsyudisptknextkosumu6;
    }

    @Override
    public void setVhsyudisptknextkosumu6(C_UmuKbn pVhsyudisptknextkosumu6) {
        vhsyudisptknextkosumu6 = pVhsyudisptknextkosumu6;
    }

    public C_UmuKbn getVhsyudisptknextkosumu7() {
        return vhsyudisptknextkosumu7;
    }

    @Override
    public void setVhsyudisptknextkosumu7(C_UmuKbn pVhsyudisptknextkosumu7) {
        vhsyudisptknextkosumu7 = pVhsyudisptknextkosumu7;
    }

    public C_UmuKbn getVhsyudisptknextkosumu8() {
        return vhsyudisptknextkosumu8;
    }

    @Override
    public void setVhsyudisptknextkosumu8(C_UmuKbn pVhsyudisptknextkosumu8) {
        vhsyudisptknextkosumu8 = pVhsyudisptknextkosumu8;
    }

    public C_UmuKbn getVhsyudisptknextkosumu9() {
        return vhsyudisptknextkosumu9;
    }

    @Override
    public void setVhsyudisptknextkosumu9(C_UmuKbn pVhsyudisptknextkosumu9) {
        vhsyudisptknextkosumu9 = pVhsyudisptknextkosumu9;
    }

    public C_UmuKbn getVhsyudisptknextkosumu10() {
        return vhsyudisptknextkosumu10;
    }

    @Override
    public void setVhsyudisptknextkosumu10(C_UmuKbn pVhsyudisptknextkosumu10) {
        vhsyudisptknextkosumu10 = pVhsyudisptknextkosumu10;
    }

    public C_UmuKbn getVhsyusyutsnshrgndhjumu() {
        return vhsyusyutsnshrgndhjumu;
    }

    @Override
    public void setVhsyusyutsnshrgndhjumu(C_UmuKbn pVhsyusyutsnshrgndhjumu) {
        vhsyusyutsnshrgndhjumu = pVhsyusyutsnshrgndhjumu;
    }

    public BizCurrency getVhsyudispsyutsnshrgndgk() {
        return vhsyudispsyutsnshrgndgk;
    }

    @Override
    public void setVhsyudispsyutsnshrgndgk(BizCurrency pVhsyudispsyutsnshrgndgk) {
        vhsyudispsyutsnshrgndgk = pVhsyudispsyutsnshrgndgk;
    }

    public C_UmuKbn getVhsyudisptktsnshrgndhjumu1() {
        return vhsyudisptktsnshrgndhjumu1;
    }

    @Override
    public void setVhsyudisptktsnshrgndhjumu1(C_UmuKbn pVhsyudisptktsnshrgndhjumu1) {
        vhsyudisptktsnshrgndhjumu1 = pVhsyudisptktsnshrgndhjumu1;
    }

    public C_UmuKbn getVhsyudisptktsnshrgndhjumu2() {
        return vhsyudisptktsnshrgndhjumu2;
    }

    @Override
    public void setVhsyudisptktsnshrgndhjumu2(C_UmuKbn pVhsyudisptktsnshrgndhjumu2) {
        vhsyudisptktsnshrgndhjumu2 = pVhsyudisptktsnshrgndhjumu2;
    }

    public C_UmuKbn getVhsyudisptktsnshrgndhjumu3() {
        return vhsyudisptktsnshrgndhjumu3;
    }

    @Override
    public void setVhsyudisptktsnshrgndhjumu3(C_UmuKbn pVhsyudisptktsnshrgndhjumu3) {
        vhsyudisptktsnshrgndhjumu3 = pVhsyudisptktsnshrgndhjumu3;
    }

    public C_UmuKbn getVhsyudisptktsnshrgndhjumu4() {
        return vhsyudisptktsnshrgndhjumu4;
    }

    @Override
    public void setVhsyudisptktsnshrgndhjumu4(C_UmuKbn pVhsyudisptktsnshrgndhjumu4) {
        vhsyudisptktsnshrgndhjumu4 = pVhsyudisptktsnshrgndhjumu4;
    }

    public C_UmuKbn getVhsyudisptktsnshrgndhjumu5() {
        return vhsyudisptktsnshrgndhjumu5;
    }

    @Override
    public void setVhsyudisptktsnshrgndhjumu5(C_UmuKbn pVhsyudisptktsnshrgndhjumu5) {
        vhsyudisptktsnshrgndhjumu5 = pVhsyudisptktsnshrgndhjumu5;
    }

    public C_UmuKbn getVhsyudisptktsnshrgndhjumu6() {
        return vhsyudisptktsnshrgndhjumu6;
    }

    @Override
    public void setVhsyudisptktsnshrgndhjumu6(C_UmuKbn pVhsyudisptktsnshrgndhjumu6) {
        vhsyudisptktsnshrgndhjumu6 = pVhsyudisptktsnshrgndhjumu6;
    }

    public C_UmuKbn getVhsyudisptktsnshrgndhjumu7() {
        return vhsyudisptktsnshrgndhjumu7;
    }

    @Override
    public void setVhsyudisptktsnshrgndhjumu7(C_UmuKbn pVhsyudisptktsnshrgndhjumu7) {
        vhsyudisptktsnshrgndhjumu7 = pVhsyudisptktsnshrgndhjumu7;
    }

    public C_UmuKbn getVhsyudisptktsnshrgndhjumu8() {
        return vhsyudisptktsnshrgndhjumu8;
    }

    @Override
    public void setVhsyudisptktsnshrgndhjumu8(C_UmuKbn pVhsyudisptktsnshrgndhjumu8) {
        vhsyudisptktsnshrgndhjumu8 = pVhsyudisptktsnshrgndhjumu8;
    }

    public C_UmuKbn getVhsyudisptktsnshrgndhjumu9() {
        return vhsyudisptktsnshrgndhjumu9;
    }

    @Override
    public void setVhsyudisptktsnshrgndhjumu9(C_UmuKbn pVhsyudisptktsnshrgndhjumu9) {
        vhsyudisptktsnshrgndhjumu9 = pVhsyudisptktsnshrgndhjumu9;
    }

    public C_UmuKbn getVhsyudisptktsnshrgndhjumu10() {
        return vhsyudisptktsnshrgndhjumu10;
    }

    @Override
    public void setVhsyudisptktsnshrgndhjumu10(C_UmuKbn pVhsyudisptktsnshrgndhjumu10) {
        vhsyudisptktsnshrgndhjumu10 = pVhsyudisptktsnshrgndhjumu10;
    }

    public BizCurrency getVhsyudisptktsnshrgndgk1() {
        return vhsyudisptktsnshrgndgk1;
    }

    @Override
    public void setVhsyudisptktsnshrgndgk1(BizCurrency pVhsyudisptktsnshrgndgk1) {
        vhsyudisptktsnshrgndgk1 = pVhsyudisptktsnshrgndgk1;
    }

    public BizCurrency getVhsyudisptktsnshrgndgk2() {
        return vhsyudisptktsnshrgndgk2;
    }

    @Override
    public void setVhsyudisptktsnshrgndgk2(BizCurrency pVhsyudisptktsnshrgndgk2) {
        vhsyudisptktsnshrgndgk2 = pVhsyudisptktsnshrgndgk2;
    }

    public BizCurrency getVhsyudisptktsnshrgndgk3() {
        return vhsyudisptktsnshrgndgk3;
    }

    @Override
    public void setVhsyudisptktsnshrgndgk3(BizCurrency pVhsyudisptktsnshrgndgk3) {
        vhsyudisptktsnshrgndgk3 = pVhsyudisptktsnshrgndgk3;
    }

    public BizCurrency getVhsyudisptktsnshrgndgk4() {
        return vhsyudisptktsnshrgndgk4;
    }

    @Override
    public void setVhsyudisptktsnshrgndgk4(BizCurrency pVhsyudisptktsnshrgndgk4) {
        vhsyudisptktsnshrgndgk4 = pVhsyudisptktsnshrgndgk4;
    }

    public BizCurrency getVhsyudisptktsnshrgndgk5() {
        return vhsyudisptktsnshrgndgk5;
    }

    @Override
    public void setVhsyudisptktsnshrgndgk5(BizCurrency pVhsyudisptktsnshrgndgk5) {
        vhsyudisptktsnshrgndgk5 = pVhsyudisptktsnshrgndgk5;
    }

    public BizCurrency getVhsyudisptktsnshrgndgk6() {
        return vhsyudisptktsnshrgndgk6;
    }

    @Override
    public void setVhsyudisptktsnshrgndgk6(BizCurrency pVhsyudisptktsnshrgndgk6) {
        vhsyudisptktsnshrgndgk6 = pVhsyudisptktsnshrgndgk6;
    }

    public BizCurrency getVhsyudisptktsnshrgndgk7() {
        return vhsyudisptktsnshrgndgk7;
    }

    @Override
    public void setVhsyudisptktsnshrgndgk7(BizCurrency pVhsyudisptktsnshrgndgk7) {
        vhsyudisptktsnshrgndgk7 = pVhsyudisptktsnshrgndgk7;
    }

    public BizCurrency getVhsyudisptktsnshrgndgk8() {
        return vhsyudisptktsnshrgndgk8;
    }

    @Override
    public void setVhsyudisptktsnshrgndgk8(BizCurrency pVhsyudisptktsnshrgndgk8) {
        vhsyudisptktsnshrgndgk8 = pVhsyudisptktsnshrgndgk8;
    }

    public BizCurrency getVhsyudisptktsnshrgndgk9() {
        return vhsyudisptktsnshrgndgk9;
    }

    @Override
    public void setVhsyudisptktsnshrgndgk9(BizCurrency pVhsyudisptktsnshrgndgk9) {
        vhsyudisptktsnshrgndgk9 = pVhsyudisptktsnshrgndgk9;
    }

    public BizCurrency getVhsyudisptktsnshrgndgk10() {
        return vhsyudisptktsnshrgndgk10;
    }

    @Override
    public void setVhsyudisptktsnshrgndgk10(BizCurrency pVhsyudisptktsnshrgndgk10) {
        vhsyudisptktsnshrgndgk10 = pVhsyudisptktsnshrgndgk10;
    }

    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn1() {
        return vhsyudisptkkgbairitukbn1;
    }

    @Override
    public void setVhsyudisptkkgbairitukbn1(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn1) {
        vhsyudisptkkgbairitukbn1 = pVhsyudisptkkgbairitukbn1;
    }

    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn2() {
        return vhsyudisptkkgbairitukbn2;
    }

    @Override
    public void setVhsyudisptkkgbairitukbn2(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn2) {
        vhsyudisptkkgbairitukbn2 = pVhsyudisptkkgbairitukbn2;
    }

    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn3() {
        return vhsyudisptkkgbairitukbn3;
    }

    @Override
    public void setVhsyudisptkkgbairitukbn3(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn3) {
        vhsyudisptkkgbairitukbn3 = pVhsyudisptkkgbairitukbn3;
    }

    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn4() {
        return vhsyudisptkkgbairitukbn4;
    }

    @Override
    public void setVhsyudisptkkgbairitukbn4(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn4) {
        vhsyudisptkkgbairitukbn4 = pVhsyudisptkkgbairitukbn4;
    }

    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn5() {
        return vhsyudisptkkgbairitukbn5;
    }

    @Override
    public void setVhsyudisptkkgbairitukbn5(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn5) {
        vhsyudisptkkgbairitukbn5 = pVhsyudisptkkgbairitukbn5;
    }

    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn6() {
        return vhsyudisptkkgbairitukbn6;
    }

    @Override
    public void setVhsyudisptkkgbairitukbn6(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn6) {
        vhsyudisptkkgbairitukbn6 = pVhsyudisptkkgbairitukbn6;
    }

    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn7() {
        return vhsyudisptkkgbairitukbn7;
    }

    @Override
    public void setVhsyudisptkkgbairitukbn7(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn7) {
        vhsyudisptkkgbairitukbn7 = pVhsyudisptkkgbairitukbn7;
    }

    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn8() {
        return vhsyudisptkkgbairitukbn8;
    }

    @Override
    public void setVhsyudisptkkgbairitukbn8(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn8) {
        vhsyudisptkkgbairitukbn8 = pVhsyudisptkkgbairitukbn8;
    }

    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn9() {
        return vhsyudisptkkgbairitukbn9;
    }

    @Override
    public void setVhsyudisptkkgbairitukbn9(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn9) {
        vhsyudisptkkgbairitukbn9 = pVhsyudisptkkgbairitukbn9;
    }

    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn10() {
        return vhsyudisptkkgbairitukbn10;
    }

    @Override
    public void setVhsyudisptkkgbairitukbn10(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn10) {
        vhsyudisptkkgbairitukbn10 = pVhsyudisptkkgbairitukbn10;
    }

    public C_UmuKbn getVhsyunstkhukaumukbn() {
        return vhsyunstkhukaumukbn;
    }

    @Override
    public void setVhsyunstkhukaumukbn(C_UmuKbn pVhsyunstkhukaumukbn) {
        vhsyunstkhukaumukbn = pVhsyunstkhukaumukbn;
    }

    public C_UmuKbn getVhsyuitijibrumu() {
        return vhsyuitijibrumu;
    }

    @Override
    public void setVhsyuitijibrumu(C_UmuKbn pVhsyuitijibrumu) {
        vhsyuitijibrumu = pVhsyuitijibrumu;
    }

    public C_UmuKbn getVhsyugenzaikngkhyjfukaumu() {
        return vhsyugenzaikngkhyjfukaumu;
    }

    @Override
    public void setVhsyugenzaikngkhyjfukaumu(C_UmuKbn pVhsyugenzaikngkhyjfukaumu) {
        vhsyugenzaikngkhyjfukaumu = pVhsyugenzaikngkhyjfukaumu;
    }

    public List<TbktInfoDataSourceBeanCommonParamImpl> getTbktInfoDataSourceBeanCommonParamLst() {
        return tbktInfoDataSourceBeanCommonParamLst;

    }

    @Override
    public TbktInfoDataSourceBeanCommonParam createTbktInfoDataSourceBean() {
        return new TbktInfoDataSourceBeanCommonParamImpl();
    }

    @Override
    public void convertTbktInfoForCommonParam(List<TbktInfoDataSourceBeanCommonParam> pTbktInfo) {
        List<TbktInfoDataSourceBeanCommonParamImpl> tbktInfoLst = new ArrayList<>();

        for (TbktInfoDataSourceBeanCommonParam beanPram : pTbktInfo) {
            tbktInfoLst.add((TbktInfoDataSourceBeanCommonParamImpl) beanPram);
        }

        tbktInfoDataSourceBeanCommonParamLst =tbktInfoLst;
    }




    @Override
    public void setVhsyusyohinhanteikbn(int pVhsyusyohinhanteikbn) {
        vhsyusyohinhanteikbn = pVhsyusyohinhanteikbn;
    }

    @Override
    public void setVhsyumvatekiumu(C_UmuKbn pVhsyumvatekiumu) {
        vhsyumvatekiumu = pVhsyumvatekiumu;
    }

    @Override
    public void setVhsyusbhkuktumu(C_UmuKbn pVhsyusbhkuktumu) {
        vhsyusbhkuktumu = pVhsyusbhkuktumu;
    }

    @Override
    public void setVhsyusbkyuuhukinuktumu(C_UmuKbn pVhsyusbkyuuhukinuktumu) {
        vhsyusbkyuuhukinuktumu = pVhsyusbkyuuhukinuktumu;
    }

    @Override
    public void setVhsyuyendthnkymd(BizDate pVhsyuyendthnkymd) {
        vhsyuyendthnkymd = pVhsyuyendthnkymd;
    }

    @Override
    public void setVhsyutmttknitenymd(BizDate pVhsyutmttknitenymd) {
        vhsyutmttknitenymd = pVhsyutmttknitenymd;
    }

    @Override
    public void setVhsyusyunkshrstartymd(BizDate pVhsyusyunkshrstartymd) {
        vhsyusyunkshrstartymd = pVhsyusyunkshrstartymd;
    }

    @Override
    public void setVhsyuteiritutmttkngk(BizCurrency pVhsyuteiritutmttkngk) {
        vhsyuteiritutmttkngk = pVhsyuteiritutmttkngk;
    }

    @Override
    public void setVhsyusisuurendoutmttkngk(BizCurrency pVhsyusisuurendoutmttkngk) {
        vhsyusisuurendoutmttkngk = pVhsyusisuurendoutmttkngk;
    }

    @Override
    public void setVhsyugenzaitmttkngk(BizCurrency pVhsyugenzaitmttkngk) {
        vhsyugenzaitmttkngk = pVhsyugenzaitmttkngk;
    }

    @Override
    public void setVhsyusisuurendourate(BizNumber pVhsyusisuurendourate) {
        vhsyusisuurendourate = pVhsyusisuurendourate;
    }

    @Override
    public void setVhsyuteiritutmttrate(BizNumber pVhsyuteiritutmttrate) {
        vhsyuteiritutmttrate = pVhsyuteiritutmttrate;
    }

    @Override
    public void setVhsyusisuunm(String pVhsyusisuunm) {
        vhsyusisuunm = pVhsyusisuunm;
    }

    @Override
    public void setVhsyusetteibairitu(BizNumber pVhsyusetteibairitu) {
        vhsyusetteibairitu = pVhsyusetteibairitu;
    }

    @Override
    public void setVhsyuyoteiriritu(BizNumber pVhsyuyoteiriritu) {
        vhsyuyoteiriritu = pVhsyuyoteiriritu;
    }

    @Override
    public void setVhsyutumitateriritu(BizNumber pVhsyutumitateriritu) {
        vhsyutumitateriritu = pVhsyutumitateriritu;
    }

    @Override
    public void setVhsyukyktumitateriritu(BizNumber pVhsyukyktumitateriritu) {
        vhsyukyktumitateriritu = pVhsyukyktumitateriritu;
    }

    @Override
    public void setVhsyu10nentumitateriritu(BizNumber pVhsyu10nentumitateriritu) {
        vhsyu10nentumitateriritu = pVhsyu10nentumitateriritu;
    }

    @Override
    public void setVhsyukyksjkkktyouseiriritu(BizNumber pVhsyukyksjkkktyouseiriritu) {
        vhsyukyksjkkktyouseiriritu = pVhsyukyksjkkktyouseiriritu;
    }

    @Override
    public void setVhsyuskisjkkktyouseiriritu(BizNumber pVhsyuskisjkkktyouseiriritu) {
        vhsyuskisjkkktyouseiriritu = pVhsyuskisjkkktyouseiriritu;
    }

    public int getVhsyusyohinhanteikbn() {
        return vhsyusyohinhanteikbn;
    }

    public C_UmuKbn getVhsyumvatekiumu() {
        return vhsyumvatekiumu;
    }

    public C_UmuKbn getVhsyusbhkuktumu() {
        return vhsyusbhkuktumu;
    }

    public C_UmuKbn getVhsyusbkyuuhukinuktumu() {
        return vhsyusbkyuuhukinuktumu;
    }

    public BizDate getVhsyuyendthnkymd() {
        return vhsyuyendthnkymd;
    }

    public BizDate getVhsyutmttknitenymd() {
        return vhsyutmttknitenymd;
    }

    public BizDate getVhsyusyunkshrstartymd() {
        return vhsyusyunkshrstartymd;
    }

    public BizCurrency getVhsyuteiritutmttkngk() {
        return vhsyuteiritutmttkngk;
    }

    public BizCurrency getVhsyusisuurendoutmttkngk() {
        return vhsyusisuurendoutmttkngk;
    }

    public BizCurrency getVhsyugenzaitmttkngk() {
        return vhsyugenzaitmttkngk;
    }

    public BizNumber getVhsyusisuurendourate() {
        return vhsyusisuurendourate;
    }

    public BizNumber getVhsyuteiritutmttrate() {
        return vhsyuteiritutmttrate;
    }

    public String getVhsyusisuunm() {
        return vhsyusisuunm;
    }

    public BizNumber getVhsyusetteibairitu() {
        return vhsyusetteibairitu;
    }

    public BizNumber getVhsyuyoteiriritu() {
        return vhsyuyoteiriritu;
    }

    public BizNumber getVhsyutumitateriritu() {
        return vhsyutumitateriritu;
    }

    public BizNumber getVhsyukyktumitateriritu() {
        return vhsyukyktumitateriritu;
    }

    public BizNumber getVhsyu10nentumitateriritu() {
        return vhsyu10nentumitateriritu;
    }

    public BizNumber getVhsyukyksjkkktyouseiriritu() {
        return vhsyukyksjkkktyouseiriritu;
    }

    public BizNumber getVhsyuskisjkkktyouseiriritu() {
        return vhsyuskisjkkktyouseiriritu;
    }

    public C_YendthnkJyoutaiKbn getVhsyuyendthnkjyoutaikbn() {
        return vhsyuyendthnkjyoutaikbn;
    }

    @Override
    public void setVhsyuyendthnkjyoutaikbn(C_YendthnkJyoutaiKbn pVhsyuyendthnkjyoutaikbn) {
        vhsyuyendthnkjyoutaikbn = pVhsyuyendthnkjyoutaikbn;
    }
}
