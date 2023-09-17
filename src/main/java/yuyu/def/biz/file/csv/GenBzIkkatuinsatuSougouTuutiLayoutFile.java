package yuyu.def.biz.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Htnpkkn;
import yuyu.def.classification.C_KihonssyuruiKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_SknnkaisikitkKbn;
import yuyu.def.classification.C_SyukyhkinkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TokkoudosghtnpKbn;
import yuyu.def.classification.C_TyhyrenrakusikibetuKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * （共通）専用帳票一括印刷送信ファイル（総合通知レコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzIkkatuinsatuSougouTuutiLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzIkkatuinsatuSougouTuutiLayoutFile() {
    }

    @Column(order = 1, label = "（ＩＦｃ）レコード区分")
    private String ifcRecordkbn;

    public String getIfcRecordkbn() {
        return ifcRecordkbn;
    }

    public void setIfcRecordkbn(String pIfcRecordkbn) {
        ifcRecordkbn = pIfcRecordkbn;
    }

    @Column(order = 2, label = "（ＩＦｃ）書類コード")
    private String ifcSyoruicd;

    public String getIfcSyoruicd() {
        return ifcSyoruicd;
    }

    public void setIfcSyoruicd(String pIfcSyoruicd) {
        ifcSyoruicd = pIfcSyoruicd;
    }

    @Column(order = 3, label = "（ＩＦｃ）一連番号")
    private String ifcItirenno;

    public String getIfcItirenno() {
        return ifcItirenno;
    }

    public void setIfcItirenno(String pIfcItirenno) {
        ifcItirenno = pIfcItirenno;
    }

    @Column(order = 4, label = "（ＩＦｃ）証券番号")
    private String ifcSyono;

    public String getIfcSyono() {
        return ifcSyono;
    }

    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }

    @Column(order = 5, label = "（ＩＦｃ）帳票作成日")
    private BizDate ifcTyouhyousakuseiymd;

    public BizDate getIfcTyouhyousakuseiymd() {
        return ifcTyouhyousakuseiymd;
    }

    public void setIfcTyouhyousakuseiymd(BizDate pIfcTyouhyousakuseiymd) {
        ifcTyouhyousakuseiymd = pIfcTyouhyousakuseiymd;
    }

    @Column(order = 6, label = "（ＩＦｃ）帳票作成日（印刷用）")
    private BizDate ifcTyouhyouprtymd;

    public BizDate getIfcTyouhyouprtymd() {
        return ifcTyouhyouprtymd;
    }

    public void setIfcTyouhyouprtymd(BizDate pIfcTyouhyouprtymd) {
        ifcTyouhyouprtymd = pIfcTyouhyouprtymd;
    }

    @Column(order = 7, label = "（ＩＦｃ）契約日")
    private BizDate ifcKykymd;

    public BizDate getIfcKykymd() {
        return ifcKykymd;
    }

    public void setIfcKykymd(BizDate pIfcKykymd) {
        ifcKykymd = pIfcKykymd;
    }

    @Column(order = 8, label = "（ＩＦｃ）責任開始日")
    private BizDate ifcSknnkaisiymd;

    public BizDate getIfcSknnkaisiymd() {
        return ifcSknnkaisiymd;
    }

    public void setIfcSknnkaisiymd(BizDate pIfcSknnkaisiymd) {
        ifcSknnkaisiymd = pIfcSknnkaisiymd;
    }

    @Column(order = 9, label = "（ＩＦｃ）商品名（証券用）")
    private String ifcSyouhnnmsyouken;

    public String getIfcSyouhnnmsyouken() {
        return ifcSyouhnnmsyouken;
    }

    public void setIfcSyouhnnmsyouken(String pIfcSyouhnnmsyouken) {
        ifcSyouhnnmsyouken = pIfcSyouhnnmsyouken;
    }

    @Column(order = 10, label = "（ＩＦｃ）契約者名（漢字）")
    private String ifcKyknmkj;

    public String getIfcKyknmkj() {
        return ifcKyknmkj;
    }

    public void setIfcKyknmkj(String pIfcKyknmkj) {
        ifcKyknmkj = pIfcKyknmkj;
    }

    @Column(order = 11, label = "（ＩＦｃ）契約者名漢字化不可区分")
    private C_KjkhukaKbn ifcKyknmkjkhukakbn;

    public C_KjkhukaKbn getIfcKyknmkjkhukakbn() {
        return ifcKyknmkjkhukakbn;
    }

    public void setIfcKyknmkjkhukakbn(C_KjkhukaKbn pIfcKyknmkjkhukakbn) {
        ifcKyknmkjkhukakbn = pIfcKyknmkjkhukakbn;
    }

    @Column(order = 12, label = "（ＩＦｃ）被保険者名（漢字）")
    private String ifcHhknnmkj;

    public String getIfcHhknnmkj() {
        return ifcHhknnmkj;
    }

    public void setIfcHhknnmkj(String pIfcHhknnmkj) {
        ifcHhknnmkj = pIfcHhknnmkj;
    }

    @Column(order = 13, label = "（ＩＦｃ）被保険者名漢字化不可区分")
    private C_KjkhukaKbn ifcHhknnmkjkhukakbn;

    public C_KjkhukaKbn getIfcHhknnmkjkhukakbn() {
        return ifcHhknnmkjkhukakbn;
    }

    public void setIfcHhknnmkjkhukakbn(C_KjkhukaKbn pIfcHhknnmkjkhukakbn) {
        ifcHhknnmkjkhukakbn = pIfcHhknnmkjkhukakbn;
    }

    @Column(order = 14, label = "（ＩＦｃ）被保険者生年月日")
    private BizDate ifcHhknseiymd;

    public BizDate getIfcHhknseiymd() {
        return ifcHhknseiymd;
    }

    public void setIfcHhknseiymd(BizDate pIfcHhknseiymd) {
        ifcHhknseiymd = pIfcHhknseiymd;
    }

    @Column(order = 15, label = "（ＩＦｃ）被保険者性別")
    private C_Hhknsei ifcHhknsei;

    public C_Hhknsei getIfcHhknsei() {
        return ifcHhknsei;
    }

    public void setIfcHhknsei(C_Hhknsei pIfcHhknsei) {
        ifcHhknsei = pIfcHhknsei;
    }

    @Column(order = 16, label = "（ＩＦｃ）被保険者年齢")
    private Integer ifcHhknnen;

    public Integer getIfcHhknnen() {
        return ifcHhknnen;
    }

    public void setIfcHhknnen(Integer pIfcHhknnen) {
        ifcHhknnen = pIfcHhknnen;
    }

    @Column(order = 17, label = "（ＩＦｃ）死亡返還金受取人氏名（漢字）")
    private String ifcSbhenkanuktnmkj;

    public String getIfcSbhenkanuktnmkj() {
        return ifcSbhenkanuktnmkj;
    }

    public void setIfcSbhenkanuktnmkj(String pIfcSbhenkanuktnmkj) {
        ifcSbhenkanuktnmkj = pIfcSbhenkanuktnmkj;
    }

    @Column(order = 18, label = "（ＩＦｃ）死亡返還金受取人生年月日")
    private BizDate ifcSbhkknuktseiymd;

    public BizDate getIfcSbhkknuktseiymd() {
        return ifcSbhkknuktseiymd;
    }

    public void setIfcSbhkknuktseiymd(BizDate pIfcSbhkknuktseiymd) {
        ifcSbhkknuktseiymd = pIfcSbhkknuktseiymd;
    }

    @Column(order = 19, label = "（ＩＦｃ）指定代理請求人名（漢字）")
    private String ifcStdrsknmkj;

    public String getIfcStdrsknmkj() {
        return ifcStdrsknmkj;
    }

    public void setIfcStdrsknmkj(String pIfcStdrsknmkj) {
        ifcStdrsknmkj = pIfcStdrsknmkj;
    }

    @Column(order = 20, label = "（ＩＦｃ）指定代理請求人生年月日")
    private BizDate ifcStdrskseiymd;

    public BizDate getIfcStdrskseiymd() {
        return ifcStdrskseiymd;
    }

    public void setIfcStdrskseiymd(BizDate pIfcStdrskseiymd) {
        ifcStdrskseiymd = pIfcStdrskseiymd;
    }

    @Column(order = 21, label = "（ＩＦｃ）払込保険料")
    private String ifcHrkp;

    public String getIfcHrkp() {
        return ifcHrkp;
    }

    public void setIfcHrkp(String pIfcHrkp) {
        ifcHrkp = pIfcHrkp;
    }

    @Column(order = 22, label = "（ＩＦｃ）払込回数")
    private C_Hrkkaisuu ifcHrkkaisuu;

    public C_Hrkkaisuu getIfcHrkkaisuu() {
        return ifcHrkkaisuu;
    }

    public void setIfcHrkkaisuu(C_Hrkkaisuu pIfcHrkkaisuu) {
        ifcHrkkaisuu = pIfcHrkkaisuu;
    }

    @Column(order = 23, label = "（ＩＦｃ）払込経路")
    private C_Hrkkeiro ifcHrkkeiro;

    public C_Hrkkeiro getIfcHrkkeiro() {
        return ifcHrkkeiro;
    }

    public void setIfcHrkkeiro(C_Hrkkeiro pIfcHrkkeiro) {
        ifcHrkkeiro = pIfcHrkkeiro;
    }

    @Column(order = 24, label = "（ＩＦｃ）主契約特約区分_1")
    private C_SyutkKbn ifcSyutkkbn1;

    public C_SyutkKbn getIfcSyutkkbn1() {
        return ifcSyutkkbn1;
    }

    public void setIfcSyutkkbn1(C_SyutkKbn pIfcSyutkkbn1) {
        ifcSyutkkbn1 = pIfcSyutkkbn1;
    }

    @Column(order = 25, label = "（ＩＦｃ）主契約特約区分_2")
    private C_SyutkKbn ifcSyutkkbn2;

    public C_SyutkKbn getIfcSyutkkbn2() {
        return ifcSyutkkbn2;
    }

    public void setIfcSyutkkbn2(C_SyutkKbn pIfcSyutkkbn2) {
        ifcSyutkkbn2 = pIfcSyutkkbn2;
    }

    @Column(order = 26, label = "（ＩＦｃ）主契約特約区分_3")
    private C_SyutkKbn ifcSyutkkbn3;

    public C_SyutkKbn getIfcSyutkkbn3() {
        return ifcSyutkkbn3;
    }

    public void setIfcSyutkkbn3(C_SyutkKbn pIfcSyutkkbn3) {
        ifcSyutkkbn3 = pIfcSyutkkbn3;
    }

    @Column(order = 27, label = "（ＩＦｃ）主契約特約区分_4")
    private C_SyutkKbn ifcSyutkkbn4;

    public C_SyutkKbn getIfcSyutkkbn4() {
        return ifcSyutkkbn4;
    }

    public void setIfcSyutkkbn4(C_SyutkKbn pIfcSyutkkbn4) {
        ifcSyutkkbn4 = pIfcSyutkkbn4;
    }

    @Column(order = 28, label = "（ＩＦｃ）主契約特約区分_5")
    private C_SyutkKbn ifcSyutkkbn5;

    public C_SyutkKbn getIfcSyutkkbn5() {
        return ifcSyutkkbn5;
    }

    public void setIfcSyutkkbn5(C_SyutkKbn pIfcSyutkkbn5) {
        ifcSyutkkbn5 = pIfcSyutkkbn5;
    }

    @Column(order = 29, label = "（ＩＦｃ）主契約特約区分_6")
    private C_SyutkKbn ifcSyutkkbn6;

    public C_SyutkKbn getIfcSyutkkbn6() {
        return ifcSyutkkbn6;
    }

    public void setIfcSyutkkbn6(C_SyutkKbn pIfcSyutkkbn6) {
        ifcSyutkkbn6 = pIfcSyutkkbn6;
    }

    @Column(order = 30, label = "（ＩＦｃ）主契約特約区分_7")
    private C_SyutkKbn ifcSyutkkbn7;

    public C_SyutkKbn getIfcSyutkkbn7() {
        return ifcSyutkkbn7;
    }

    public void setIfcSyutkkbn7(C_SyutkKbn pIfcSyutkkbn7) {
        ifcSyutkkbn7 = pIfcSyutkkbn7;
    }

    @Column(order = 31, label = "（ＩＦｃ）主契約特約区分_8")
    private C_SyutkKbn ifcSyutkkbn8;

    public C_SyutkKbn getIfcSyutkkbn8() {
        return ifcSyutkkbn8;
    }

    public void setIfcSyutkkbn8(C_SyutkKbn pIfcSyutkkbn8) {
        ifcSyutkkbn8 = pIfcSyutkkbn8;
    }

    @Column(order = 32, label = "（ＩＦｃ）主契約特約区分_9")
    private C_SyutkKbn ifcSyutkkbn9;

    public C_SyutkKbn getIfcSyutkkbn9() {
        return ifcSyutkkbn9;
    }

    public void setIfcSyutkkbn9(C_SyutkKbn pIfcSyutkkbn9) {
        ifcSyutkkbn9 = pIfcSyutkkbn9;
    }

    @Column(order = 33, label = "（ＩＦｃ）主契約特約区分_10")
    private C_SyutkKbn ifcSyutkkbn10;

    public C_SyutkKbn getIfcSyutkkbn10() {
        return ifcSyutkkbn10;
    }

    public void setIfcSyutkkbn10(C_SyutkKbn pIfcSyutkkbn10) {
        ifcSyutkkbn10 = pIfcSyutkkbn10;
    }

    @Column(order = 34, label = "（ＩＦｃ）商品コード_1")
    private String ifcSyouhncd1;

    public String getIfcSyouhncd1() {
        return ifcSyouhncd1;
    }

    public void setIfcSyouhncd1(String pIfcSyouhncd1) {
        ifcSyouhncd1 = pIfcSyouhncd1;
    }

    @Column(order = 35, label = "（ＩＦｃ）商品コード_2")
    private String ifcSyouhncd2;

    public String getIfcSyouhncd2() {
        return ifcSyouhncd2;
    }

    public void setIfcSyouhncd2(String pIfcSyouhncd2) {
        ifcSyouhncd2 = pIfcSyouhncd2;
    }

    @Column(order = 36, label = "（ＩＦｃ）商品コード_3")
    private String ifcSyouhncd3;

    public String getIfcSyouhncd3() {
        return ifcSyouhncd3;
    }

    public void setIfcSyouhncd3(String pIfcSyouhncd3) {
        ifcSyouhncd3 = pIfcSyouhncd3;
    }

    @Column(order = 37, label = "（ＩＦｃ）商品コード_4")
    private String ifcSyouhncd4;

    public String getIfcSyouhncd4() {
        return ifcSyouhncd4;
    }

    public void setIfcSyouhncd4(String pIfcSyouhncd4) {
        ifcSyouhncd4 = pIfcSyouhncd4;
    }

    @Column(order = 38, label = "（ＩＦｃ）商品コード_5")
    private String ifcSyouhncd5;

    public String getIfcSyouhncd5() {
        return ifcSyouhncd5;
    }

    public void setIfcSyouhncd5(String pIfcSyouhncd5) {
        ifcSyouhncd5 = pIfcSyouhncd5;
    }

    @Column(order = 39, label = "（ＩＦｃ）商品コード_6")
    private String ifcSyouhncd6;

    public String getIfcSyouhncd6() {
        return ifcSyouhncd6;
    }

    public void setIfcSyouhncd6(String pIfcSyouhncd6) {
        ifcSyouhncd6 = pIfcSyouhncd6;
    }

    @Column(order = 40, label = "（ＩＦｃ）商品コード_7")
    private String ifcSyouhncd7;

    public String getIfcSyouhncd7() {
        return ifcSyouhncd7;
    }

    public void setIfcSyouhncd7(String pIfcSyouhncd7) {
        ifcSyouhncd7 = pIfcSyouhncd7;
    }

    @Column(order = 41, label = "（ＩＦｃ）商品コード_8")
    private String ifcSyouhncd8;

    public String getIfcSyouhncd8() {
        return ifcSyouhncd8;
    }

    public void setIfcSyouhncd8(String pIfcSyouhncd8) {
        ifcSyouhncd8 = pIfcSyouhncd8;
    }

    @Column(order = 42, label = "（ＩＦｃ）商品コード_9")
    private String ifcSyouhncd9;

    public String getIfcSyouhncd9() {
        return ifcSyouhncd9;
    }

    public void setIfcSyouhncd9(String pIfcSyouhncd9) {
        ifcSyouhncd9 = pIfcSyouhncd9;
    }

    @Column(order = 43, label = "（ＩＦｃ）商品コード_10")
    private String ifcSyouhncd10;

    public String getIfcSyouhncd10() {
        return ifcSyouhncd10;
    }

    public void setIfcSyouhncd10(String pIfcSyouhncd10) {
        ifcSyouhncd10 = pIfcSyouhncd10;
    }

    @Column(order = 44, label = "（ＩＦｃ）商品世代番号_1")
    private Integer ifcSyouhnsdno1;

    public Integer getIfcSyouhnsdno1() {
        return ifcSyouhnsdno1;
    }

    public void setIfcSyouhnsdno1(Integer pIfcSyouhnsdno1) {
        ifcSyouhnsdno1 = pIfcSyouhnsdno1;
    }

    @Column(order = 45, label = "（ＩＦｃ）商品世代番号_2")
    private Integer ifcSyouhnsdno2;

    public Integer getIfcSyouhnsdno2() {
        return ifcSyouhnsdno2;
    }

    public void setIfcSyouhnsdno2(Integer pIfcSyouhnsdno2) {
        ifcSyouhnsdno2 = pIfcSyouhnsdno2;
    }

    @Column(order = 46, label = "（ＩＦｃ）商品世代番号_3")
    private Integer ifcSyouhnsdno3;

    public Integer getIfcSyouhnsdno3() {
        return ifcSyouhnsdno3;
    }

    public void setIfcSyouhnsdno3(Integer pIfcSyouhnsdno3) {
        ifcSyouhnsdno3 = pIfcSyouhnsdno3;
    }

    @Column(order = 47, label = "（ＩＦｃ）商品世代番号_4")
    private Integer ifcSyouhnsdno4;

    public Integer getIfcSyouhnsdno4() {
        return ifcSyouhnsdno4;
    }

    public void setIfcSyouhnsdno4(Integer pIfcSyouhnsdno4) {
        ifcSyouhnsdno4 = pIfcSyouhnsdno4;
    }

    @Column(order = 48, label = "（ＩＦｃ）商品世代番号_5")
    private Integer ifcSyouhnsdno5;

    public Integer getIfcSyouhnsdno5() {
        return ifcSyouhnsdno5;
    }

    public void setIfcSyouhnsdno5(Integer pIfcSyouhnsdno5) {
        ifcSyouhnsdno5 = pIfcSyouhnsdno5;
    }

    @Column(order = 49, label = "（ＩＦｃ）商品世代番号_6")
    private Integer ifcSyouhnsdno6;

    public Integer getIfcSyouhnsdno6() {
        return ifcSyouhnsdno6;
    }

    public void setIfcSyouhnsdno6(Integer pIfcSyouhnsdno6) {
        ifcSyouhnsdno6 = pIfcSyouhnsdno6;
    }

    @Column(order = 50, label = "（ＩＦｃ）商品世代番号_7")
    private Integer ifcSyouhnsdno7;

    public Integer getIfcSyouhnsdno7() {
        return ifcSyouhnsdno7;
    }

    public void setIfcSyouhnsdno7(Integer pIfcSyouhnsdno7) {
        ifcSyouhnsdno7 = pIfcSyouhnsdno7;
    }

    @Column(order = 51, label = "（ＩＦｃ）商品世代番号_8")
    private Integer ifcSyouhnsdno8;

    public Integer getIfcSyouhnsdno8() {
        return ifcSyouhnsdno8;
    }

    public void setIfcSyouhnsdno8(Integer pIfcSyouhnsdno8) {
        ifcSyouhnsdno8 = pIfcSyouhnsdno8;
    }

    @Column(order = 52, label = "（ＩＦｃ）商品世代番号_9")
    private Integer ifcSyouhnsdno9;

    public Integer getIfcSyouhnsdno9() {
        return ifcSyouhnsdno9;
    }

    public void setIfcSyouhnsdno9(Integer pIfcSyouhnsdno9) {
        ifcSyouhnsdno9 = pIfcSyouhnsdno9;
    }

    @Column(order = 53, label = "（ＩＦｃ）商品世代番号_10")
    private Integer ifcSyouhnsdno10;

    public Integer getIfcSyouhnsdno10() {
        return ifcSyouhnsdno10;
    }

    public void setIfcSyouhnsdno10(Integer pIfcSyouhnsdno10) {
        ifcSyouhnsdno10 = pIfcSyouhnsdno10;
    }

    @Column(order = 54, label = "（ＩＦｃ）契約商品連番_1")
    private Integer ifcKyksyouhnrenno1;

    public Integer getIfcKyksyouhnrenno1() {
        return ifcKyksyouhnrenno1;
    }

    public void setIfcKyksyouhnrenno1(Integer pIfcKyksyouhnrenno1) {
        ifcKyksyouhnrenno1 = pIfcKyksyouhnrenno1;
    }

    @Column(order = 55, label = "（ＩＦｃ）契約商品連番_2")
    private Integer ifcKyksyouhnrenno2;

    public Integer getIfcKyksyouhnrenno2() {
        return ifcKyksyouhnrenno2;
    }

    public void setIfcKyksyouhnrenno2(Integer pIfcKyksyouhnrenno2) {
        ifcKyksyouhnrenno2 = pIfcKyksyouhnrenno2;
    }

    @Column(order = 56, label = "（ＩＦｃ）契約商品連番_3")
    private Integer ifcKyksyouhnrenno3;

    public Integer getIfcKyksyouhnrenno3() {
        return ifcKyksyouhnrenno3;
    }

    public void setIfcKyksyouhnrenno3(Integer pIfcKyksyouhnrenno3) {
        ifcKyksyouhnrenno3 = pIfcKyksyouhnrenno3;
    }

    @Column(order = 57, label = "（ＩＦｃ）契約商品連番_4")
    private Integer ifcKyksyouhnrenno4;

    public Integer getIfcKyksyouhnrenno4() {
        return ifcKyksyouhnrenno4;
    }

    public void setIfcKyksyouhnrenno4(Integer pIfcKyksyouhnrenno4) {
        ifcKyksyouhnrenno4 = pIfcKyksyouhnrenno4;
    }

    @Column(order = 58, label = "（ＩＦｃ）契約商品連番_5")
    private Integer ifcKyksyouhnrenno5;

    public Integer getIfcKyksyouhnrenno5() {
        return ifcKyksyouhnrenno5;
    }

    public void setIfcKyksyouhnrenno5(Integer pIfcKyksyouhnrenno5) {
        ifcKyksyouhnrenno5 = pIfcKyksyouhnrenno5;
    }

    @Column(order = 59, label = "（ＩＦｃ）契約商品連番_6")
    private Integer ifcKyksyouhnrenno6;

    public Integer getIfcKyksyouhnrenno6() {
        return ifcKyksyouhnrenno6;
    }

    public void setIfcKyksyouhnrenno6(Integer pIfcKyksyouhnrenno6) {
        ifcKyksyouhnrenno6 = pIfcKyksyouhnrenno6;
    }

    @Column(order = 60, label = "（ＩＦｃ）契約商品連番_7")
    private Integer ifcKyksyouhnrenno7;

    public Integer getIfcKyksyouhnrenno7() {
        return ifcKyksyouhnrenno7;
    }

    public void setIfcKyksyouhnrenno7(Integer pIfcKyksyouhnrenno7) {
        ifcKyksyouhnrenno7 = pIfcKyksyouhnrenno7;
    }

    @Column(order = 61, label = "（ＩＦｃ）契約商品連番_8")
    private Integer ifcKyksyouhnrenno8;

    public Integer getIfcKyksyouhnrenno8() {
        return ifcKyksyouhnrenno8;
    }

    public void setIfcKyksyouhnrenno8(Integer pIfcKyksyouhnrenno8) {
        ifcKyksyouhnrenno8 = pIfcKyksyouhnrenno8;
    }

    @Column(order = 62, label = "（ＩＦｃ）契約商品連番_9")
    private Integer ifcKyksyouhnrenno9;

    public Integer getIfcKyksyouhnrenno9() {
        return ifcKyksyouhnrenno9;
    }

    public void setIfcKyksyouhnrenno9(Integer pIfcKyksyouhnrenno9) {
        ifcKyksyouhnrenno9 = pIfcKyksyouhnrenno9;
    }

    @Column(order = 63, label = "（ＩＦｃ）契約商品連番_10")
    private Integer ifcKyksyouhnrenno10;

    public Integer getIfcKyksyouhnrenno10() {
        return ifcKyksyouhnrenno10;
    }

    public void setIfcKyksyouhnrenno10(Integer pIfcKyksyouhnrenno10) {
        ifcKyksyouhnrenno10 = pIfcKyksyouhnrenno10;
    }

    @Column(order = 64, label = "（ＩＦｃ）給付限度型区分_1")
    private C_KyhgndkataKbn ifcKyhgndkatakbn1;

    public C_KyhgndkataKbn getIfcKyhgndkatakbn1() {
        return ifcKyhgndkatakbn1;
    }

    public void setIfcKyhgndkatakbn1(C_KyhgndkataKbn pIfcKyhgndkatakbn1) {
        ifcKyhgndkatakbn1 = pIfcKyhgndkatakbn1;
    }

    @Column(order = 65, label = "（ＩＦｃ）給付限度型区分_2")
    private C_KyhgndkataKbn ifcKyhgndkatakbn2;

    public C_KyhgndkataKbn getIfcKyhgndkatakbn2() {
        return ifcKyhgndkatakbn2;
    }

    public void setIfcKyhgndkatakbn2(C_KyhgndkataKbn pIfcKyhgndkatakbn2) {
        ifcKyhgndkatakbn2 = pIfcKyhgndkatakbn2;
    }

    @Column(order = 66, label = "（ＩＦｃ）給付限度型区分_3")
    private C_KyhgndkataKbn ifcKyhgndkatakbn3;

    public C_KyhgndkataKbn getIfcKyhgndkatakbn3() {
        return ifcKyhgndkatakbn3;
    }

    public void setIfcKyhgndkatakbn3(C_KyhgndkataKbn pIfcKyhgndkatakbn3) {
        ifcKyhgndkatakbn3 = pIfcKyhgndkatakbn3;
    }

    @Column(order = 67, label = "（ＩＦｃ）給付限度型区分_4")
    private C_KyhgndkataKbn ifcKyhgndkatakbn4;

    public C_KyhgndkataKbn getIfcKyhgndkatakbn4() {
        return ifcKyhgndkatakbn4;
    }

    public void setIfcKyhgndkatakbn4(C_KyhgndkataKbn pIfcKyhgndkatakbn4) {
        ifcKyhgndkatakbn4 = pIfcKyhgndkatakbn4;
    }

    @Column(order = 68, label = "（ＩＦｃ）給付限度型区分_5")
    private C_KyhgndkataKbn ifcKyhgndkatakbn5;

    public C_KyhgndkataKbn getIfcKyhgndkatakbn5() {
        return ifcKyhgndkatakbn5;
    }

    public void setIfcKyhgndkatakbn5(C_KyhgndkataKbn pIfcKyhgndkatakbn5) {
        ifcKyhgndkatakbn5 = pIfcKyhgndkatakbn5;
    }

    @Column(order = 69, label = "（ＩＦｃ）給付限度型区分_6")
    private C_KyhgndkataKbn ifcKyhgndkatakbn6;

    public C_KyhgndkataKbn getIfcKyhgndkatakbn6() {
        return ifcKyhgndkatakbn6;
    }

    public void setIfcKyhgndkatakbn6(C_KyhgndkataKbn pIfcKyhgndkatakbn6) {
        ifcKyhgndkatakbn6 = pIfcKyhgndkatakbn6;
    }

    @Column(order = 70, label = "（ＩＦｃ）給付限度型区分_7")
    private C_KyhgndkataKbn ifcKyhgndkatakbn7;

    public C_KyhgndkataKbn getIfcKyhgndkatakbn7() {
        return ifcKyhgndkatakbn7;
    }

    public void setIfcKyhgndkatakbn7(C_KyhgndkataKbn pIfcKyhgndkatakbn7) {
        ifcKyhgndkatakbn7 = pIfcKyhgndkatakbn7;
    }

    @Column(order = 71, label = "（ＩＦｃ）給付限度型区分_8")
    private C_KyhgndkataKbn ifcKyhgndkatakbn8;

    public C_KyhgndkataKbn getIfcKyhgndkatakbn8() {
        return ifcKyhgndkatakbn8;
    }

    public void setIfcKyhgndkatakbn8(C_KyhgndkataKbn pIfcKyhgndkatakbn8) {
        ifcKyhgndkatakbn8 = pIfcKyhgndkatakbn8;
    }

    @Column(order = 72, label = "（ＩＦｃ）給付限度型区分_9")
    private C_KyhgndkataKbn ifcKyhgndkatakbn9;

    public C_KyhgndkataKbn getIfcKyhgndkatakbn9() {
        return ifcKyhgndkatakbn9;
    }

    public void setIfcKyhgndkatakbn9(C_KyhgndkataKbn pIfcKyhgndkatakbn9) {
        ifcKyhgndkatakbn9 = pIfcKyhgndkatakbn9;
    }

    @Column(order = 73, label = "（ＩＦｃ）給付限度型区分_10")
    private C_KyhgndkataKbn ifcKyhgndkatakbn10;

    public C_KyhgndkataKbn getIfcKyhgndkatakbn10() {
        return ifcKyhgndkatakbn10;
    }

    public void setIfcKyhgndkatakbn10(C_KyhgndkataKbn pIfcKyhgndkatakbn10) {
        ifcKyhgndkatakbn10 = pIfcKyhgndkatakbn10;
    }

    @Column(order = 74, label = "（ＩＦｃ）保険期間歳満期区分_1")
    private C_HknkknsmnKbn ifcHknkknsmnkbn1;

    public C_HknkknsmnKbn getIfcHknkknsmnkbn1() {
        return ifcHknkknsmnkbn1;
    }

    public void setIfcHknkknsmnkbn1(C_HknkknsmnKbn pIfcHknkknsmnkbn1) {
        ifcHknkknsmnkbn1 = pIfcHknkknsmnkbn1;
    }

    @Column(order = 75, label = "（ＩＦｃ）保険期間歳満期区分_2")
    private C_HknkknsmnKbn ifcHknkknsmnkbn2;

    public C_HknkknsmnKbn getIfcHknkknsmnkbn2() {
        return ifcHknkknsmnkbn2;
    }

    public void setIfcHknkknsmnkbn2(C_HknkknsmnKbn pIfcHknkknsmnkbn2) {
        ifcHknkknsmnkbn2 = pIfcHknkknsmnkbn2;
    }

    @Column(order = 76, label = "（ＩＦｃ）保険期間歳満期区分_3")
    private C_HknkknsmnKbn ifcHknkknsmnkbn3;

    public C_HknkknsmnKbn getIfcHknkknsmnkbn3() {
        return ifcHknkknsmnkbn3;
    }

    public void setIfcHknkknsmnkbn3(C_HknkknsmnKbn pIfcHknkknsmnkbn3) {
        ifcHknkknsmnkbn3 = pIfcHknkknsmnkbn3;
    }

    @Column(order = 77, label = "（ＩＦｃ）保険期間歳満期区分_4")
    private C_HknkknsmnKbn ifcHknkknsmnkbn4;

    public C_HknkknsmnKbn getIfcHknkknsmnkbn4() {
        return ifcHknkknsmnkbn4;
    }

    public void setIfcHknkknsmnkbn4(C_HknkknsmnKbn pIfcHknkknsmnkbn4) {
        ifcHknkknsmnkbn4 = pIfcHknkknsmnkbn4;
    }

    @Column(order = 78, label = "（ＩＦｃ）保険期間歳満期区分_5")
    private C_HknkknsmnKbn ifcHknkknsmnkbn5;

    public C_HknkknsmnKbn getIfcHknkknsmnkbn5() {
        return ifcHknkknsmnkbn5;
    }

    public void setIfcHknkknsmnkbn5(C_HknkknsmnKbn pIfcHknkknsmnkbn5) {
        ifcHknkknsmnkbn5 = pIfcHknkknsmnkbn5;
    }

    @Column(order = 79, label = "（ＩＦｃ）保険期間歳満期区分_6")
    private C_HknkknsmnKbn ifcHknkknsmnkbn6;

    public C_HknkknsmnKbn getIfcHknkknsmnkbn6() {
        return ifcHknkknsmnkbn6;
    }

    public void setIfcHknkknsmnkbn6(C_HknkknsmnKbn pIfcHknkknsmnkbn6) {
        ifcHknkknsmnkbn6 = pIfcHknkknsmnkbn6;
    }

    @Column(order = 80, label = "（ＩＦｃ）保険期間歳満期区分_7")
    private C_HknkknsmnKbn ifcHknkknsmnkbn7;

    public C_HknkknsmnKbn getIfcHknkknsmnkbn7() {
        return ifcHknkknsmnkbn7;
    }

    public void setIfcHknkknsmnkbn7(C_HknkknsmnKbn pIfcHknkknsmnkbn7) {
        ifcHknkknsmnkbn7 = pIfcHknkknsmnkbn7;
    }

    @Column(order = 81, label = "（ＩＦｃ）保険期間歳満期区分_8")
    private C_HknkknsmnKbn ifcHknkknsmnkbn8;

    public C_HknkknsmnKbn getIfcHknkknsmnkbn8() {
        return ifcHknkknsmnkbn8;
    }

    public void setIfcHknkknsmnkbn8(C_HknkknsmnKbn pIfcHknkknsmnkbn8) {
        ifcHknkknsmnkbn8 = pIfcHknkknsmnkbn8;
    }

    @Column(order = 82, label = "（ＩＦｃ）保険期間歳満期区分_9")
    private C_HknkknsmnKbn ifcHknkknsmnkbn9;

    public C_HknkknsmnKbn getIfcHknkknsmnkbn9() {
        return ifcHknkknsmnkbn9;
    }

    public void setIfcHknkknsmnkbn9(C_HknkknsmnKbn pIfcHknkknsmnkbn9) {
        ifcHknkknsmnkbn9 = pIfcHknkknsmnkbn9;
    }

    @Column(order = 83, label = "（ＩＦｃ）保険期間歳満期区分_10")
    private C_HknkknsmnKbn ifcHknkknsmnkbn10;

    public C_HknkknsmnKbn getIfcHknkknsmnkbn10() {
        return ifcHknkknsmnkbn10;
    }

    public void setIfcHknkknsmnkbn10(C_HknkknsmnKbn pIfcHknkknsmnkbn10) {
        ifcHknkknsmnkbn10 = pIfcHknkknsmnkbn10;
    }

    @Column(order = 84, label = "（ＩＦｃ）保険期間_1")
    private Integer ifcHknkkn1;

    public Integer getIfcHknkkn1() {
        return ifcHknkkn1;
    }

    public void setIfcHknkkn1(Integer pIfcHknkkn1) {
        ifcHknkkn1 = pIfcHknkkn1;
    }

    @Column(order = 85, label = "（ＩＦｃ）保険期間_2")
    private Integer ifcHknkkn2;

    public Integer getIfcHknkkn2() {
        return ifcHknkkn2;
    }

    public void setIfcHknkkn2(Integer pIfcHknkkn2) {
        ifcHknkkn2 = pIfcHknkkn2;
    }

    @Column(order = 86, label = "（ＩＦｃ）保険期間_3")
    private Integer ifcHknkkn3;

    public Integer getIfcHknkkn3() {
        return ifcHknkkn3;
    }

    public void setIfcHknkkn3(Integer pIfcHknkkn3) {
        ifcHknkkn3 = pIfcHknkkn3;
    }

    @Column(order = 87, label = "（ＩＦｃ）保険期間_4")
    private Integer ifcHknkkn4;

    public Integer getIfcHknkkn4() {
        return ifcHknkkn4;
    }

    public void setIfcHknkkn4(Integer pIfcHknkkn4) {
        ifcHknkkn4 = pIfcHknkkn4;
    }

    @Column(order = 88, label = "（ＩＦｃ）保険期間_5")
    private Integer ifcHknkkn5;

    public Integer getIfcHknkkn5() {
        return ifcHknkkn5;
    }

    public void setIfcHknkkn5(Integer pIfcHknkkn5) {
        ifcHknkkn5 = pIfcHknkkn5;
    }

    @Column(order = 89, label = "（ＩＦｃ）保険期間_6")
    private Integer ifcHknkkn6;

    public Integer getIfcHknkkn6() {
        return ifcHknkkn6;
    }

    public void setIfcHknkkn6(Integer pIfcHknkkn6) {
        ifcHknkkn6 = pIfcHknkkn6;
    }

    @Column(order = 90, label = "（ＩＦｃ）保険期間_7")
    private Integer ifcHknkkn7;

    public Integer getIfcHknkkn7() {
        return ifcHknkkn7;
    }

    public void setIfcHknkkn7(Integer pIfcHknkkn7) {
        ifcHknkkn7 = pIfcHknkkn7;
    }

    @Column(order = 91, label = "（ＩＦｃ）保険期間_8")
    private Integer ifcHknkkn8;

    public Integer getIfcHknkkn8() {
        return ifcHknkkn8;
    }

    public void setIfcHknkkn8(Integer pIfcHknkkn8) {
        ifcHknkkn8 = pIfcHknkkn8;
    }

    @Column(order = 92, label = "（ＩＦｃ）保険期間_9")
    private Integer ifcHknkkn9;

    public Integer getIfcHknkkn9() {
        return ifcHknkkn9;
    }

    public void setIfcHknkkn9(Integer pIfcHknkkn9) {
        ifcHknkkn9 = pIfcHknkkn9;
    }

    @Column(order = 93, label = "（ＩＦｃ）保険期間_10")
    private Integer ifcHknkkn10;

    public Integer getIfcHknkkn10() {
        return ifcHknkkn10;
    }

    public void setIfcHknkkn10(Integer pIfcHknkkn10) {
        ifcHknkkn10 = pIfcHknkkn10;
    }

    @Column(order = 94, label = "（ＩＦｃ）払込期間歳満期区分_1")
    private C_HrkkknsmnKbn ifcHrkkknsmnkbn1;

    public C_HrkkknsmnKbn getIfcHrkkknsmnkbn1() {
        return ifcHrkkknsmnkbn1;
    }

    public void setIfcHrkkknsmnkbn1(C_HrkkknsmnKbn pIfcHrkkknsmnkbn1) {
        ifcHrkkknsmnkbn1 = pIfcHrkkknsmnkbn1;
    }

    @Column(order = 95, label = "（ＩＦｃ）払込期間歳満期区分_2")
    private C_HrkkknsmnKbn ifcHrkkknsmnkbn2;

    public C_HrkkknsmnKbn getIfcHrkkknsmnkbn2() {
        return ifcHrkkknsmnkbn2;
    }

    public void setIfcHrkkknsmnkbn2(C_HrkkknsmnKbn pIfcHrkkknsmnkbn2) {
        ifcHrkkknsmnkbn2 = pIfcHrkkknsmnkbn2;
    }

    @Column(order = 96, label = "（ＩＦｃ）払込期間歳満期区分_3")
    private C_HrkkknsmnKbn ifcHrkkknsmnkbn3;

    public C_HrkkknsmnKbn getIfcHrkkknsmnkbn3() {
        return ifcHrkkknsmnkbn3;
    }

    public void setIfcHrkkknsmnkbn3(C_HrkkknsmnKbn pIfcHrkkknsmnkbn3) {
        ifcHrkkknsmnkbn3 = pIfcHrkkknsmnkbn3;
    }

    @Column(order = 97, label = "（ＩＦｃ）払込期間歳満期区分_4")
    private C_HrkkknsmnKbn ifcHrkkknsmnkbn4;

    public C_HrkkknsmnKbn getIfcHrkkknsmnkbn4() {
        return ifcHrkkknsmnkbn4;
    }

    public void setIfcHrkkknsmnkbn4(C_HrkkknsmnKbn pIfcHrkkknsmnkbn4) {
        ifcHrkkknsmnkbn4 = pIfcHrkkknsmnkbn4;
    }

    @Column(order = 98, label = "（ＩＦｃ）払込期間歳満期区分_5")
    private C_HrkkknsmnKbn ifcHrkkknsmnkbn5;

    public C_HrkkknsmnKbn getIfcHrkkknsmnkbn5() {
        return ifcHrkkknsmnkbn5;
    }

    public void setIfcHrkkknsmnkbn5(C_HrkkknsmnKbn pIfcHrkkknsmnkbn5) {
        ifcHrkkknsmnkbn5 = pIfcHrkkknsmnkbn5;
    }

    @Column(order = 99, label = "（ＩＦｃ）払込期間歳満期区分_6")
    private C_HrkkknsmnKbn ifcHrkkknsmnkbn6;

    public C_HrkkknsmnKbn getIfcHrkkknsmnkbn6() {
        return ifcHrkkknsmnkbn6;
    }

    public void setIfcHrkkknsmnkbn6(C_HrkkknsmnKbn pIfcHrkkknsmnkbn6) {
        ifcHrkkknsmnkbn6 = pIfcHrkkknsmnkbn6;
    }

    @Column(order = 100, label = "（ＩＦｃ）払込期間歳満期区分_7")
    private C_HrkkknsmnKbn ifcHrkkknsmnkbn7;

    public C_HrkkknsmnKbn getIfcHrkkknsmnkbn7() {
        return ifcHrkkknsmnkbn7;
    }

    public void setIfcHrkkknsmnkbn7(C_HrkkknsmnKbn pIfcHrkkknsmnkbn7) {
        ifcHrkkknsmnkbn7 = pIfcHrkkknsmnkbn7;
    }

    @Column(order = 101, label = "（ＩＦｃ）払込期間歳満期区分_8")
    private C_HrkkknsmnKbn ifcHrkkknsmnkbn8;

    public C_HrkkknsmnKbn getIfcHrkkknsmnkbn8() {
        return ifcHrkkknsmnkbn8;
    }

    public void setIfcHrkkknsmnkbn8(C_HrkkknsmnKbn pIfcHrkkknsmnkbn8) {
        ifcHrkkknsmnkbn8 = pIfcHrkkknsmnkbn8;
    }

    @Column(order = 102, label = "（ＩＦｃ）払込期間歳満期区分_9")
    private C_HrkkknsmnKbn ifcHrkkknsmnkbn9;

    public C_HrkkknsmnKbn getIfcHrkkknsmnkbn9() {
        return ifcHrkkknsmnkbn9;
    }

    public void setIfcHrkkknsmnkbn9(C_HrkkknsmnKbn pIfcHrkkknsmnkbn9) {
        ifcHrkkknsmnkbn9 = pIfcHrkkknsmnkbn9;
    }

    @Column(order = 103, label = "（ＩＦｃ）払込期間歳満期区分_10")
    private C_HrkkknsmnKbn ifcHrkkknsmnkbn10;

    public C_HrkkknsmnKbn getIfcHrkkknsmnkbn10() {
        return ifcHrkkknsmnkbn10;
    }

    public void setIfcHrkkknsmnkbn10(C_HrkkknsmnKbn pIfcHrkkknsmnkbn10) {
        ifcHrkkknsmnkbn10 = pIfcHrkkknsmnkbn10;
    }

    @Column(order = 104, label = "（ＩＦｃ）払込期間_1")
    private Integer ifcHrkkkn1;

    public Integer getIfcHrkkkn1() {
        return ifcHrkkkn1;
    }

    public void setIfcHrkkkn1(Integer pIfcHrkkkn1) {
        ifcHrkkkn1 = pIfcHrkkkn1;
    }

    @Column(order = 105, label = "（ＩＦｃ）払込期間_2")
    private Integer ifcHrkkkn2;

    public Integer getIfcHrkkkn2() {
        return ifcHrkkkn2;
    }

    public void setIfcHrkkkn2(Integer pIfcHrkkkn2) {
        ifcHrkkkn2 = pIfcHrkkkn2;
    }

    @Column(order = 106, label = "（ＩＦｃ）払込期間_3")
    private Integer ifcHrkkkn3;

    public Integer getIfcHrkkkn3() {
        return ifcHrkkkn3;
    }

    public void setIfcHrkkkn3(Integer pIfcHrkkkn3) {
        ifcHrkkkn3 = pIfcHrkkkn3;
    }

    @Column(order = 107, label = "（ＩＦｃ）払込期間_4")
    private Integer ifcHrkkkn4;

    public Integer getIfcHrkkkn4() {
        return ifcHrkkkn4;
    }

    public void setIfcHrkkkn4(Integer pIfcHrkkkn4) {
        ifcHrkkkn4 = pIfcHrkkkn4;
    }

    @Column(order = 108, label = "（ＩＦｃ）払込期間_5")
    private Integer ifcHrkkkn5;

    public Integer getIfcHrkkkn5() {
        return ifcHrkkkn5;
    }

    public void setIfcHrkkkn5(Integer pIfcHrkkkn5) {
        ifcHrkkkn5 = pIfcHrkkkn5;
    }

    @Column(order = 109, label = "（ＩＦｃ）払込期間_6")
    private Integer ifcHrkkkn6;

    public Integer getIfcHrkkkn6() {
        return ifcHrkkkn6;
    }

    public void setIfcHrkkkn6(Integer pIfcHrkkkn6) {
        ifcHrkkkn6 = pIfcHrkkkn6;
    }

    @Column(order = 110, label = "（ＩＦｃ）払込期間_7")
    private Integer ifcHrkkkn7;

    public Integer getIfcHrkkkn7() {
        return ifcHrkkkn7;
    }

    public void setIfcHrkkkn7(Integer pIfcHrkkkn7) {
        ifcHrkkkn7 = pIfcHrkkkn7;
    }

    @Column(order = 111, label = "（ＩＦｃ）払込期間_8")
    private Integer ifcHrkkkn8;

    public Integer getIfcHrkkkn8() {
        return ifcHrkkkn8;
    }

    public void setIfcHrkkkn8(Integer pIfcHrkkkn8) {
        ifcHrkkkn8 = pIfcHrkkkn8;
    }

    @Column(order = 112, label = "（ＩＦｃ）払込期間_9")
    private Integer ifcHrkkkn9;

    public Integer getIfcHrkkkn9() {
        return ifcHrkkkn9;
    }

    public void setIfcHrkkkn9(Integer pIfcHrkkkn9) {
        ifcHrkkkn9 = pIfcHrkkkn9;
    }

    @Column(order = 113, label = "（ＩＦｃ）払込期間_10")
    private Integer ifcHrkkkn10;

    public Integer getIfcHrkkkn10() {
        return ifcHrkkkn10;
    }

    public void setIfcHrkkkn10(Integer pIfcHrkkkn10) {
        ifcHrkkkn10 = pIfcHrkkkn10;
    }

    @Column(order = 114, label = "（ＩＦｃ）商品名_1")
    private String ifcSyouhnnm1;

    public String getIfcSyouhnnm1() {
        return ifcSyouhnnm1;
    }

    public void setIfcSyouhnnm1(String pIfcSyouhnnm1) {
        ifcSyouhnnm1 = pIfcSyouhnnm1;
    }

    @Column(order = 115, label = "（ＩＦｃ）商品名_2")
    private String ifcSyouhnnm2;

    public String getIfcSyouhnnm2() {
        return ifcSyouhnnm2;
    }

    public void setIfcSyouhnnm2(String pIfcSyouhnnm2) {
        ifcSyouhnnm2 = pIfcSyouhnnm2;
    }

    @Column(order = 116, label = "（ＩＦｃ）商品名_3")
    private String ifcSyouhnnm3;

    public String getIfcSyouhnnm3() {
        return ifcSyouhnnm3;
    }

    public void setIfcSyouhnnm3(String pIfcSyouhnnm3) {
        ifcSyouhnnm3 = pIfcSyouhnnm3;
    }

    @Column(order = 117, label = "（ＩＦｃ）商品名_4")
    private String ifcSyouhnnm4;

    public String getIfcSyouhnnm4() {
        return ifcSyouhnnm4;
    }

    public void setIfcSyouhnnm4(String pIfcSyouhnnm4) {
        ifcSyouhnnm4 = pIfcSyouhnnm4;
    }

    @Column(order = 118, label = "（ＩＦｃ）商品名_5")
    private String ifcSyouhnnm5;

    public String getIfcSyouhnnm5() {
        return ifcSyouhnnm5;
    }

    public void setIfcSyouhnnm5(String pIfcSyouhnnm5) {
        ifcSyouhnnm5 = pIfcSyouhnnm5;
    }

    @Column(order = 119, label = "（ＩＦｃ）商品名_6")
    private String ifcSyouhnnm6;

    public String getIfcSyouhnnm6() {
        return ifcSyouhnnm6;
    }

    public void setIfcSyouhnnm6(String pIfcSyouhnnm6) {
        ifcSyouhnnm6 = pIfcSyouhnnm6;
    }

    @Column(order = 120, label = "（ＩＦｃ）商品名_7")
    private String ifcSyouhnnm7;

    public String getIfcSyouhnnm7() {
        return ifcSyouhnnm7;
    }

    public void setIfcSyouhnnm7(String pIfcSyouhnnm7) {
        ifcSyouhnnm7 = pIfcSyouhnnm7;
    }

    @Column(order = 121, label = "（ＩＦｃ）商品名_8")
    private String ifcSyouhnnm8;

    public String getIfcSyouhnnm8() {
        return ifcSyouhnnm8;
    }

    public void setIfcSyouhnnm8(String pIfcSyouhnnm8) {
        ifcSyouhnnm8 = pIfcSyouhnnm8;
    }

    @Column(order = 122, label = "（ＩＦｃ）商品名_9")
    private String ifcSyouhnnm9;

    public String getIfcSyouhnnm9() {
        return ifcSyouhnnm9;
    }

    public void setIfcSyouhnnm9(String pIfcSyouhnnm9) {
        ifcSyouhnnm9 = pIfcSyouhnnm9;
    }

    @Column(order = 123, label = "（ＩＦｃ）商品名_10")
    private String ifcSyouhnnm10;

    public String getIfcSyouhnnm10() {
        return ifcSyouhnnm10;
    }

    public void setIfcSyouhnnm10(String pIfcSyouhnnm10) {
        ifcSyouhnnm10 = pIfcSyouhnnm10;
    }

    @Column(order = 124, label = "（ＩＦｃ）基本Ｓ_1")
    private String ifcKihons1;

    public String getIfcKihons1() {
        return ifcKihons1;
    }

    public void setIfcKihons1(String pIfcKihons1) {
        ifcKihons1 = pIfcKihons1;
    }

    @Column(order = 125, label = "（ＩＦｃ）基本Ｓ_2")
    private String ifcKihons2;

    public String getIfcKihons2() {
        return ifcKihons2;
    }

    public void setIfcKihons2(String pIfcKihons2) {
        ifcKihons2 = pIfcKihons2;
    }

    @Column(order = 126, label = "（ＩＦｃ）基本Ｓ_3")
    private String ifcKihons3;

    public String getIfcKihons3() {
        return ifcKihons3;
    }

    public void setIfcKihons3(String pIfcKihons3) {
        ifcKihons3 = pIfcKihons3;
    }

    @Column(order = 127, label = "（ＩＦｃ）基本Ｓ_4")
    private String ifcKihons4;

    public String getIfcKihons4() {
        return ifcKihons4;
    }

    public void setIfcKihons4(String pIfcKihons4) {
        ifcKihons4 = pIfcKihons4;
    }

    @Column(order = 128, label = "（ＩＦｃ）基本Ｓ_5")
    private String ifcKihons5;

    public String getIfcKihons5() {
        return ifcKihons5;
    }

    public void setIfcKihons5(String pIfcKihons5) {
        ifcKihons5 = pIfcKihons5;
    }

    @Column(order = 129, label = "（ＩＦｃ）基本Ｓ_6")
    private String ifcKihons6;

    public String getIfcKihons6() {
        return ifcKihons6;
    }

    public void setIfcKihons6(String pIfcKihons6) {
        ifcKihons6 = pIfcKihons6;
    }

    @Column(order = 130, label = "（ＩＦｃ）基本Ｓ_7")
    private String ifcKihons7;

    public String getIfcKihons7() {
        return ifcKihons7;
    }

    public void setIfcKihons7(String pIfcKihons7) {
        ifcKihons7 = pIfcKihons7;
    }

    @Column(order = 131, label = "（ＩＦｃ）基本Ｓ_8")
    private String ifcKihons8;

    public String getIfcKihons8() {
        return ifcKihons8;
    }

    public void setIfcKihons8(String pIfcKihons8) {
        ifcKihons8 = pIfcKihons8;
    }

    @Column(order = 132, label = "（ＩＦｃ）基本Ｓ_9")
    private String ifcKihons9;

    public String getIfcKihons9() {
        return ifcKihons9;
    }

    public void setIfcKihons9(String pIfcKihons9) {
        ifcKihons9 = pIfcKihons9;
    }

    @Column(order = 133, label = "（ＩＦｃ）基本Ｓ_10")
    private String ifcKihons10;

    public String getIfcKihons10() {
        return ifcKihons10;
    }

    public void setIfcKihons10(String pIfcKihons10) {
        ifcKihons10 = pIfcKihons10;
    }

    @Column(order = 134, label = "（ＩＦｃ）保険料_1")
    private String ifcP1;

    public String getIfcP1() {
        return ifcP1;
    }

    public void setIfcP1(String pIfcP1) {
        ifcP1 = pIfcP1;
    }

    @Column(order = 135, label = "（ＩＦｃ）保険料_2")
    private String ifcP2;

    public String getIfcP2() {
        return ifcP2;
    }

    public void setIfcP2(String pIfcP2) {
        ifcP2 = pIfcP2;
    }

    @Column(order = 136, label = "（ＩＦｃ）保険料_3")
    private String ifcP3;

    public String getIfcP3() {
        return ifcP3;
    }

    public void setIfcP3(String pIfcP3) {
        ifcP3 = pIfcP3;
    }

    @Column(order = 137, label = "（ＩＦｃ）保険料_4")
    private String ifcP4;

    public String getIfcP4() {
        return ifcP4;
    }

    public void setIfcP4(String pIfcP4) {
        ifcP4 = pIfcP4;
    }

    @Column(order = 138, label = "（ＩＦｃ）保険料_5")
    private String ifcP5;

    public String getIfcP5() {
        return ifcP5;
    }

    public void setIfcP5(String pIfcP5) {
        ifcP5 = pIfcP5;
    }

    @Column(order = 139, label = "（ＩＦｃ）保険料_6")
    private String ifcP6;

    public String getIfcP6() {
        return ifcP6;
    }

    public void setIfcP6(String pIfcP6) {
        ifcP6 = pIfcP6;
    }

    @Column(order = 140, label = "（ＩＦｃ）保険料_7")
    private String ifcP7;

    public String getIfcP7() {
        return ifcP7;
    }

    public void setIfcP7(String pIfcP7) {
        ifcP7 = pIfcP7;
    }

    @Column(order = 141, label = "（ＩＦｃ）保険料_8")
    private String ifcP8;

    public String getIfcP8() {
        return ifcP8;
    }

    public void setIfcP8(String pIfcP8) {
        ifcP8 = pIfcP8;
    }

    @Column(order = 142, label = "（ＩＦｃ）保険料_9")
    private String ifcP9;

    public String getIfcP9() {
        return ifcP9;
    }

    public void setIfcP9(String pIfcP9) {
        ifcP9 = pIfcP9;
    }

    @Column(order = 143, label = "（ＩＦｃ）保険料_10")
    private String ifcP10;

    public String getIfcP10() {
        return ifcP10;
    }

    public void setIfcP10(String pIfcP10) {
        ifcP10 = pIfcP10;
    }

    @Column(order = 144, label = "（ＩＦｃ）基本Ｓ種類区分_1")
    private C_KihonssyuruiKbn ifcKihonssyuruikbn1;

    public C_KihonssyuruiKbn getIfcKihonssyuruikbn1() {
        return ifcKihonssyuruikbn1;
    }

    public void setIfcKihonssyuruikbn1(C_KihonssyuruiKbn pIfcKihonssyuruikbn1) {
        ifcKihonssyuruikbn1 = pIfcKihonssyuruikbn1;
    }

    @Column(order = 145, label = "（ＩＦｃ）基本Ｓ種類区分_2")
    private C_KihonssyuruiKbn ifcKihonssyuruikbn2;

    public C_KihonssyuruiKbn getIfcKihonssyuruikbn2() {
        return ifcKihonssyuruikbn2;
    }

    public void setIfcKihonssyuruikbn2(C_KihonssyuruiKbn pIfcKihonssyuruikbn2) {
        ifcKihonssyuruikbn2 = pIfcKihonssyuruikbn2;
    }

    @Column(order = 146, label = "（ＩＦｃ）基本Ｓ種類区分_3")
    private C_KihonssyuruiKbn ifcKihonssyuruikbn3;

    public C_KihonssyuruiKbn getIfcKihonssyuruikbn3() {
        return ifcKihonssyuruikbn3;
    }

    public void setIfcKihonssyuruikbn3(C_KihonssyuruiKbn pIfcKihonssyuruikbn3) {
        ifcKihonssyuruikbn3 = pIfcKihonssyuruikbn3;
    }

    @Column(order = 147, label = "（ＩＦｃ）基本Ｓ種類区分_4")
    private C_KihonssyuruiKbn ifcKihonssyuruikbn4;

    public C_KihonssyuruiKbn getIfcKihonssyuruikbn4() {
        return ifcKihonssyuruikbn4;
    }

    public void setIfcKihonssyuruikbn4(C_KihonssyuruiKbn pIfcKihonssyuruikbn4) {
        ifcKihonssyuruikbn4 = pIfcKihonssyuruikbn4;
    }

    @Column(order = 148, label = "（ＩＦｃ）基本Ｓ種類区分_5")
    private C_KihonssyuruiKbn ifcKihonssyuruikbn5;

    public C_KihonssyuruiKbn getIfcKihonssyuruikbn5() {
        return ifcKihonssyuruikbn5;
    }

    public void setIfcKihonssyuruikbn5(C_KihonssyuruiKbn pIfcKihonssyuruikbn5) {
        ifcKihonssyuruikbn5 = pIfcKihonssyuruikbn5;
    }

    @Column(order = 149, label = "（ＩＦｃ）基本Ｓ種類区分_6")
    private C_KihonssyuruiKbn ifcKihonssyuruikbn6;

    public C_KihonssyuruiKbn getIfcKihonssyuruikbn6() {
        return ifcKihonssyuruikbn6;
    }

    public void setIfcKihonssyuruikbn6(C_KihonssyuruiKbn pIfcKihonssyuruikbn6) {
        ifcKihonssyuruikbn6 = pIfcKihonssyuruikbn6;
    }

    @Column(order = 150, label = "（ＩＦｃ）基本Ｓ種類区分_7")
    private C_KihonssyuruiKbn ifcKihonssyuruikbn7;

    public C_KihonssyuruiKbn getIfcKihonssyuruikbn7() {
        return ifcKihonssyuruikbn7;
    }

    public void setIfcKihonssyuruikbn7(C_KihonssyuruiKbn pIfcKihonssyuruikbn7) {
        ifcKihonssyuruikbn7 = pIfcKihonssyuruikbn7;
    }

    @Column(order = 151, label = "（ＩＦｃ）基本Ｓ種類区分_8")
    private C_KihonssyuruiKbn ifcKihonssyuruikbn8;

    public C_KihonssyuruiKbn getIfcKihonssyuruikbn8() {
        return ifcKihonssyuruikbn8;
    }

    public void setIfcKihonssyuruikbn8(C_KihonssyuruiKbn pIfcKihonssyuruikbn8) {
        ifcKihonssyuruikbn8 = pIfcKihonssyuruikbn8;
    }

    @Column(order = 152, label = "（ＩＦｃ）基本Ｓ種類区分_9")
    private C_KihonssyuruiKbn ifcKihonssyuruikbn9;

    public C_KihonssyuruiKbn getIfcKihonssyuruikbn9() {
        return ifcKihonssyuruikbn9;
    }

    public void setIfcKihonssyuruikbn9(C_KihonssyuruiKbn pIfcKihonssyuruikbn9) {
        ifcKihonssyuruikbn9 = pIfcKihonssyuruikbn9;
    }

    @Column(order = 153, label = "（ＩＦｃ）基本Ｓ種類区分_10")
    private C_KihonssyuruiKbn ifcKihonssyuruikbn10;

    public C_KihonssyuruiKbn getIfcKihonssyuruikbn10() {
        return ifcKihonssyuruikbn10;
    }

    public void setIfcKihonssyuruikbn10(C_KihonssyuruiKbn pIfcKihonssyuruikbn10) {
        ifcKihonssyuruikbn10 = pIfcKihonssyuruikbn10;
    }

    @Column(order = 154, label = "（ＩＦｃ）手術給付金型区分_1")
    private C_SyukyhkinkataKbn ifcSyukyhkinkatakbn1;

    public C_SyukyhkinkataKbn getIfcSyukyhkinkatakbn1() {
        return ifcSyukyhkinkatakbn1;
    }

    public void setIfcSyukyhkinkatakbn1(C_SyukyhkinkataKbn pIfcSyukyhkinkatakbn1) {
        ifcSyukyhkinkatakbn1 = pIfcSyukyhkinkatakbn1;
    }

    @Column(order = 155, label = "（ＩＦｃ）手術給付金型区分_2")
    private C_SyukyhkinkataKbn ifcSyukyhkinkatakbn2;

    public C_SyukyhkinkataKbn getIfcSyukyhkinkatakbn2() {
        return ifcSyukyhkinkatakbn2;
    }

    public void setIfcSyukyhkinkatakbn2(C_SyukyhkinkataKbn pIfcSyukyhkinkatakbn2) {
        ifcSyukyhkinkatakbn2 = pIfcSyukyhkinkatakbn2;
    }

    @Column(order = 156, label = "（ＩＦｃ）手術給付金型区分_3")
    private C_SyukyhkinkataKbn ifcSyukyhkinkatakbn3;

    public C_SyukyhkinkataKbn getIfcSyukyhkinkatakbn3() {
        return ifcSyukyhkinkatakbn3;
    }

    public void setIfcSyukyhkinkatakbn3(C_SyukyhkinkataKbn pIfcSyukyhkinkatakbn3) {
        ifcSyukyhkinkatakbn3 = pIfcSyukyhkinkatakbn3;
    }

    @Column(order = 157, label = "（ＩＦｃ）手術給付金型区分_4")
    private C_SyukyhkinkataKbn ifcSyukyhkinkatakbn4;

    public C_SyukyhkinkataKbn getIfcSyukyhkinkatakbn4() {
        return ifcSyukyhkinkatakbn4;
    }

    public void setIfcSyukyhkinkatakbn4(C_SyukyhkinkataKbn pIfcSyukyhkinkatakbn4) {
        ifcSyukyhkinkatakbn4 = pIfcSyukyhkinkatakbn4;
    }

    @Column(order = 158, label = "（ＩＦｃ）手術給付金型区分_5")
    private C_SyukyhkinkataKbn ifcSyukyhkinkatakbn5;

    public C_SyukyhkinkataKbn getIfcSyukyhkinkatakbn5() {
        return ifcSyukyhkinkatakbn5;
    }

    public void setIfcSyukyhkinkatakbn5(C_SyukyhkinkataKbn pIfcSyukyhkinkatakbn5) {
        ifcSyukyhkinkatakbn5 = pIfcSyukyhkinkatakbn5;
    }

    @Column(order = 159, label = "（ＩＦｃ）手術給付金型区分_6")
    private C_SyukyhkinkataKbn ifcSyukyhkinkatakbn6;

    public C_SyukyhkinkataKbn getIfcSyukyhkinkatakbn6() {
        return ifcSyukyhkinkatakbn6;
    }

    public void setIfcSyukyhkinkatakbn6(C_SyukyhkinkataKbn pIfcSyukyhkinkatakbn6) {
        ifcSyukyhkinkatakbn6 = pIfcSyukyhkinkatakbn6;
    }

    @Column(order = 160, label = "（ＩＦｃ）手術給付金型区分_7")
    private C_SyukyhkinkataKbn ifcSyukyhkinkatakbn7;

    public C_SyukyhkinkataKbn getIfcSyukyhkinkatakbn7() {
        return ifcSyukyhkinkatakbn7;
    }

    public void setIfcSyukyhkinkatakbn7(C_SyukyhkinkataKbn pIfcSyukyhkinkatakbn7) {
        ifcSyukyhkinkatakbn7 = pIfcSyukyhkinkatakbn7;
    }

    @Column(order = 161, label = "（ＩＦｃ）手術給付金型区分_8")
    private C_SyukyhkinkataKbn ifcSyukyhkinkatakbn8;

    public C_SyukyhkinkataKbn getIfcSyukyhkinkatakbn8() {
        return ifcSyukyhkinkatakbn8;
    }

    public void setIfcSyukyhkinkatakbn8(C_SyukyhkinkataKbn pIfcSyukyhkinkatakbn8) {
        ifcSyukyhkinkatakbn8 = pIfcSyukyhkinkatakbn8;
    }

    @Column(order = 162, label = "（ＩＦｃ）手術給付金型区分_9")
    private C_SyukyhkinkataKbn ifcSyukyhkinkatakbn9;

    public C_SyukyhkinkataKbn getIfcSyukyhkinkatakbn9() {
        return ifcSyukyhkinkatakbn9;
    }

    public void setIfcSyukyhkinkatakbn9(C_SyukyhkinkataKbn pIfcSyukyhkinkatakbn9) {
        ifcSyukyhkinkatakbn9 = pIfcSyukyhkinkatakbn9;
    }

    @Column(order = 163, label = "（ＩＦｃ）手術給付金型区分_10")
    private C_SyukyhkinkataKbn ifcSyukyhkinkatakbn10;

    public C_SyukyhkinkataKbn getIfcSyukyhkinkatakbn10() {
        return ifcSyukyhkinkatakbn10;
    }

    public void setIfcSyukyhkinkatakbn10(C_SyukyhkinkataKbn pIfcSyukyhkinkatakbn10) {
        ifcSyukyhkinkatakbn10 = pIfcSyukyhkinkatakbn10;
    }

    @Column(order = 164, label = "（ＩＦｃ）６大生活習慣病追加給付型区分_1")
    private C_6daiLdKbn ifc6daisktsykntkkyhktkbn1;

    public C_6daiLdKbn getIfc6daisktsykntkkyhktkbn1() {
        return ifc6daisktsykntkkyhktkbn1;
    }

    public void setIfc6daisktsykntkkyhktkbn1(C_6daiLdKbn pIfc6daisktsykntkkyhktkbn1) {
        ifc6daisktsykntkkyhktkbn1 = pIfc6daisktsykntkkyhktkbn1;
    }

    @Column(order = 165, label = "（ＩＦｃ）６大生活習慣病追加給付型区分_2")
    private C_6daiLdKbn ifc6daisktsykntkkyhktkbn2;

    public C_6daiLdKbn getIfc6daisktsykntkkyhktkbn2() {
        return ifc6daisktsykntkkyhktkbn2;
    }

    public void setIfc6daisktsykntkkyhktkbn2(C_6daiLdKbn pIfc6daisktsykntkkyhktkbn2) {
        ifc6daisktsykntkkyhktkbn2 = pIfc6daisktsykntkkyhktkbn2;
    }

    @Column(order = 166, label = "（ＩＦｃ）６大生活習慣病追加給付型区分_3")
    private C_6daiLdKbn ifc6daisktsykntkkyhktkbn3;

    public C_6daiLdKbn getIfc6daisktsykntkkyhktkbn3() {
        return ifc6daisktsykntkkyhktkbn3;
    }

    public void setIfc6daisktsykntkkyhktkbn3(C_6daiLdKbn pIfc6daisktsykntkkyhktkbn3) {
        ifc6daisktsykntkkyhktkbn3 = pIfc6daisktsykntkkyhktkbn3;
    }

    @Column(order = 167, label = "（ＩＦｃ）６大生活習慣病追加給付型区分_4")
    private C_6daiLdKbn ifc6daisktsykntkkyhktkbn4;

    public C_6daiLdKbn getIfc6daisktsykntkkyhktkbn4() {
        return ifc6daisktsykntkkyhktkbn4;
    }

    public void setIfc6daisktsykntkkyhktkbn4(C_6daiLdKbn pIfc6daisktsykntkkyhktkbn4) {
        ifc6daisktsykntkkyhktkbn4 = pIfc6daisktsykntkkyhktkbn4;
    }

    @Column(order = 168, label = "（ＩＦｃ）６大生活習慣病追加給付型区分_5")
    private C_6daiLdKbn ifc6daisktsykntkkyhktkbn5;

    public C_6daiLdKbn getIfc6daisktsykntkkyhktkbn5() {
        return ifc6daisktsykntkkyhktkbn5;
    }

    public void setIfc6daisktsykntkkyhktkbn5(C_6daiLdKbn pIfc6daisktsykntkkyhktkbn5) {
        ifc6daisktsykntkkyhktkbn5 = pIfc6daisktsykntkkyhktkbn5;
    }

    @Column(order = 169, label = "（ＩＦｃ）６大生活習慣病追加給付型区分_6")
    private C_6daiLdKbn ifc6daisktsykntkkyhktkbn6;

    public C_6daiLdKbn getIfc6daisktsykntkkyhktkbn6() {
        return ifc6daisktsykntkkyhktkbn6;
    }

    public void setIfc6daisktsykntkkyhktkbn6(C_6daiLdKbn pIfc6daisktsykntkkyhktkbn6) {
        ifc6daisktsykntkkyhktkbn6 = pIfc6daisktsykntkkyhktkbn6;
    }

    @Column(order = 170, label = "（ＩＦｃ）６大生活習慣病追加給付型区分_7")
    private C_6daiLdKbn ifc6daisktsykntkkyhktkbn7;

    public C_6daiLdKbn getIfc6daisktsykntkkyhktkbn7() {
        return ifc6daisktsykntkkyhktkbn7;
    }

    public void setIfc6daisktsykntkkyhktkbn7(C_6daiLdKbn pIfc6daisktsykntkkyhktkbn7) {
        ifc6daisktsykntkkyhktkbn7 = pIfc6daisktsykntkkyhktkbn7;
    }

    @Column(order = 171, label = "（ＩＦｃ）６大生活習慣病追加給付型区分_8")
    private C_6daiLdKbn ifc6daisktsykntkkyhktkbn8;

    public C_6daiLdKbn getIfc6daisktsykntkkyhktkbn8() {
        return ifc6daisktsykntkkyhktkbn8;
    }

    public void setIfc6daisktsykntkkyhktkbn8(C_6daiLdKbn pIfc6daisktsykntkkyhktkbn8) {
        ifc6daisktsykntkkyhktkbn8 = pIfc6daisktsykntkkyhktkbn8;
    }

    @Column(order = 172, label = "（ＩＦｃ）６大生活習慣病追加給付型区分_9")
    private C_6daiLdKbn ifc6daisktsykntkkyhktkbn9;

    public C_6daiLdKbn getIfc6daisktsykntkkyhktkbn9() {
        return ifc6daisktsykntkkyhktkbn9;
    }

    public void setIfc6daisktsykntkkyhktkbn9(C_6daiLdKbn pIfc6daisktsykntkkyhktkbn9) {
        ifc6daisktsykntkkyhktkbn9 = pIfc6daisktsykntkkyhktkbn9;
    }

    @Column(order = 173, label = "（ＩＦｃ）６大生活習慣病追加給付型区分_10")
    private C_6daiLdKbn ifc6daisktsykntkkyhktkbn10;

    public C_6daiLdKbn getIfc6daisktsykntkkyhktkbn10() {
        return ifc6daisktsykntkkyhktkbn10;
    }

    public void setIfc6daisktsykntkkyhktkbn10(C_6daiLdKbn pIfc6daisktsykntkkyhktkbn10) {
        ifc6daisktsykntkkyhktkbn10 = pIfc6daisktsykntkkyhktkbn10;
    }

    @Column(order = 174, label = "（ＩＦｃ）基本給付金額_1")
    private String ifcKhnkyhgk1;

    public String getIfcKhnkyhgk1() {
        return ifcKhnkyhgk1;
    }

    public void setIfcKhnkyhgk1(String pIfcKhnkyhgk1) {
        ifcKhnkyhgk1 = pIfcKhnkyhgk1;
    }

    @Column(order = 175, label = "（ＩＦｃ）基本給付金額_2")
    private String ifcKhnkyhgk2;

    public String getIfcKhnkyhgk2() {
        return ifcKhnkyhgk2;
    }

    public void setIfcKhnkyhgk2(String pIfcKhnkyhgk2) {
        ifcKhnkyhgk2 = pIfcKhnkyhgk2;
    }

    @Column(order = 176, label = "（ＩＦｃ）基本給付金額_3")
    private String ifcKhnkyhgk3;

    public String getIfcKhnkyhgk3() {
        return ifcKhnkyhgk3;
    }

    public void setIfcKhnkyhgk3(String pIfcKhnkyhgk3) {
        ifcKhnkyhgk3 = pIfcKhnkyhgk3;
    }

    @Column(order = 177, label = "（ＩＦｃ）基本給付金額_4")
    private String ifcKhnkyhgk4;

    public String getIfcKhnkyhgk4() {
        return ifcKhnkyhgk4;
    }

    public void setIfcKhnkyhgk4(String pIfcKhnkyhgk4) {
        ifcKhnkyhgk4 = pIfcKhnkyhgk4;
    }

    @Column(order = 178, label = "（ＩＦｃ）基本給付金額_5")
    private String ifcKhnkyhgk5;

    public String getIfcKhnkyhgk5() {
        return ifcKhnkyhgk5;
    }

    public void setIfcKhnkyhgk5(String pIfcKhnkyhgk5) {
        ifcKhnkyhgk5 = pIfcKhnkyhgk5;
    }

    @Column(order = 179, label = "（ＩＦｃ）基本給付金額_6")
    private String ifcKhnkyhgk6;

    public String getIfcKhnkyhgk6() {
        return ifcKhnkyhgk6;
    }

    public void setIfcKhnkyhgk6(String pIfcKhnkyhgk6) {
        ifcKhnkyhgk6 = pIfcKhnkyhgk6;
    }

    @Column(order = 180, label = "（ＩＦｃ）基本給付金額_7")
    private String ifcKhnkyhgk7;

    public String getIfcKhnkyhgk7() {
        return ifcKhnkyhgk7;
    }

    public void setIfcKhnkyhgk7(String pIfcKhnkyhgk7) {
        ifcKhnkyhgk7 = pIfcKhnkyhgk7;
    }

    @Column(order = 181, label = "（ＩＦｃ）基本給付金額_8")
    private String ifcKhnkyhgk8;

    public String getIfcKhnkyhgk8() {
        return ifcKhnkyhgk8;
    }

    public void setIfcKhnkyhgk8(String pIfcKhnkyhgk8) {
        ifcKhnkyhgk8 = pIfcKhnkyhgk8;
    }

    @Column(order = 182, label = "（ＩＦｃ）基本給付金額_9")
    private String ifcKhnkyhgk9;

    public String getIfcKhnkyhgk9() {
        return ifcKhnkyhgk9;
    }

    public void setIfcKhnkyhgk9(String pIfcKhnkyhgk9) {
        ifcKhnkyhgk9 = pIfcKhnkyhgk9;
    }

    @Column(order = 183, label = "（ＩＦｃ）基本給付金額_10")
    private String ifcKhnkyhgk10;

    public String getIfcKhnkyhgk10() {
        return ifcKhnkyhgk10;
    }

    public void setIfcKhnkyhgk10(String pIfcKhnkyhgk10) {
        ifcKhnkyhgk10 = pIfcKhnkyhgk10;
    }

    @Column(order = 184, label = "（ＩＦｃ）通信先郵便番号")
    private String ifcTsinyno;

    public String getIfcTsinyno() {
        return ifcTsinyno;
    }

    public void setIfcTsinyno(String pIfcTsinyno) {
        ifcTsinyno = pIfcTsinyno;
    }

    @Column(order = 185, label = "（ＩＦｃ）通信先住所１（漢字）")
    private String ifcTsinadr1kj;

    public String getIfcTsinadr1kj() {
        return ifcTsinadr1kj;
    }

    public void setIfcTsinadr1kj(String pIfcTsinadr1kj) {
        ifcTsinadr1kj = pIfcTsinadr1kj;
    }

    @Column(order = 186, label = "（ＩＦｃ）通信先住所２（漢字）")
    private String ifcTsinadr2kj;

    public String getIfcTsinadr2kj() {
        return ifcTsinadr2kj;
    }

    public void setIfcTsinadr2kj(String pIfcTsinadr2kj) {
        ifcTsinadr2kj = pIfcTsinadr2kj;
    }

    @Column(order = 187, label = "（ＩＦｃ）通信先住所３（漢字）")
    private String ifcTsinadr3kj;

    public String getIfcTsinadr3kj() {
        return ifcTsinadr3kj;
    }

    public void setIfcTsinadr3kj(String pIfcTsinadr3kj) {
        ifcTsinadr3kj = pIfcTsinadr3kj;
    }

    @Column(order = 188, label = "（ＩＦｃ）通信先住所４（漢字）")
    private String ifcTsinadr4kj;

    public String getIfcTsinadr4kj() {
        return ifcTsinadr4kj;
    }

    public void setIfcTsinadr4kj(String pIfcTsinadr4kj) {
        ifcTsinadr4kj = pIfcTsinadr4kj;
    }

    @Column(order = 189, label = "（ＩＦｃ）相手先証券番号")
    private String ifcAitesyono;

    public String getIfcAitesyono() {
        return ifcAitesyono;
    }

    public void setIfcAitesyono(String pIfcAitesyono) {
        ifcAitesyono = pIfcAitesyono;
    }

    @Column(order = 190, label = "（ＩＦｃ）新規再発行区分（文字列）")
    private String ifcSinsaihkkbnstr;

    public String getIfcSinsaihkkbnstr() {
        return ifcSinsaihkkbnstr;
    }

    public void setIfcSinsaihkkbnstr(String pIfcSinsaihkkbnstr) {
        ifcSinsaihkkbnstr = pIfcSinsaihkkbnstr;
    }

    @Column(order = 191, label = "（ＩＦｃ）代理店コード")
    private String ifcDrtencd;

    public String getIfcDrtencd() {
        return ifcDrtencd;
    }

    public void setIfcDrtencd(String pIfcDrtencd) {
        ifcDrtencd = pIfcDrtencd;
    }

    @Column(order = 192, label = "（ＩＦｃ）代理店名（漢字）")
    private String ifcDrtennmkj;

    public String getIfcDrtennmkj() {
        return ifcDrtennmkj;
    }

    public void setIfcDrtennmkj(String pIfcDrtennmkj) {
        ifcDrtennmkj = pIfcDrtennmkj;
    }

    @Column(order = 193, label = "（ＩＦｃ）解約返戻金有無区分")
    private C_UmuKbn ifcKaiyakuhrum;

    public C_UmuKbn getIfcKaiyakuhrum() {
        return ifcKaiyakuhrum;
    }

    public void setIfcKaiyakuhrum(C_UmuKbn pIfcKaiyakuhrum) {
        ifcKaiyakuhrum = pIfcKaiyakuhrum;
    }

    @Column(order = 194, label = "（ＩＦｃ）解約返戻金")
    private String ifcKaiyakuhr;

    public String getIfcKaiyakuhr() {
        return ifcKaiyakuhr;
    }

    public void setIfcKaiyakuhr(String pIfcKaiyakuhr) {
        ifcKaiyakuhr = pIfcKaiyakuhr;
    }

    @Column(order = 195, label = "（ＩＦｃ）死亡返還金")
    private String ifcSbhenkan;

    public String getIfcSbhenkan() {
        return ifcSbhenkan;
    }

    public void setIfcSbhenkan(String pIfcSbhenkan) {
        ifcSbhenkan = pIfcSbhenkan;
    }

    @Column(order = 196, label = "（ＩＦｃ）不担保部位名１")
    private String ifcHtnpbuinm1;

    public String getIfcHtnpbuinm1() {
        return ifcHtnpbuinm1;
    }

    public void setIfcHtnpbuinm1(String pIfcHtnpbuinm1) {
        ifcHtnpbuinm1 = pIfcHtnpbuinm1;
    }

    @Column(order = 197, label = "（ＩＦｃ）不担保期間１")
    private C_Htnpkkn ifcHtnpkkn1;

    public C_Htnpkkn getIfcHtnpkkn1() {
        return ifcHtnpkkn1;
    }

    public void setIfcHtnpkkn1(C_Htnpkkn pIfcHtnpkkn1) {
        ifcHtnpkkn1 = pIfcHtnpkkn1;
    }

    @Column(order = 198, label = "（ＩＦｃ）不担保部位名２")
    private String ifcHtnpbuinm2;

    public String getIfcHtnpbuinm2() {
        return ifcHtnpbuinm2;
    }

    public void setIfcHtnpbuinm2(String pIfcHtnpbuinm2) {
        ifcHtnpbuinm2 = pIfcHtnpbuinm2;
    }

    @Column(order = 199, label = "（ＩＦｃ）不担保期間２")
    private C_Htnpkkn ifcHtnpkkn2;

    public C_Htnpkkn getIfcHtnpkkn2() {
        return ifcHtnpkkn2;
    }

    public void setIfcHtnpkkn2(C_Htnpkkn pIfcHtnpkkn2) {
        ifcHtnpkkn2 = pIfcHtnpkkn2;
    }

    @Column(order = 200, label = "（ＩＦｃ）不担保部位名３")
    private String ifcHtnpbuinm3;

    public String getIfcHtnpbuinm3() {
        return ifcHtnpbuinm3;
    }

    public void setIfcHtnpbuinm3(String pIfcHtnpbuinm3) {
        ifcHtnpbuinm3 = pIfcHtnpbuinm3;
    }

    @Column(order = 201, label = "（ＩＦｃ）不担保期間３")
    private C_Htnpkkn ifcHtnpkkn3;

    public C_Htnpkkn getIfcHtnpkkn3() {
        return ifcHtnpkkn3;
    }

    public void setIfcHtnpkkn3(C_Htnpkkn pIfcHtnpkkn3) {
        ifcHtnpkkn3 = pIfcHtnpkkn3;
    }

    @Column(order = 202, label = "（ＩＦｃ）不担保部位名４")
    private String ifcHtnpbuinm4;

    public String getIfcHtnpbuinm4() {
        return ifcHtnpbuinm4;
    }

    public void setIfcHtnpbuinm4(String pIfcHtnpbuinm4) {
        ifcHtnpbuinm4 = pIfcHtnpbuinm4;
    }

    @Column(order = 203, label = "（ＩＦｃ）不担保期間４")
    private C_Htnpkkn ifcHtnpkkn4;

    public C_Htnpkkn getIfcHtnpkkn4() {
        return ifcHtnpkkn4;
    }

    public void setIfcHtnpkkn4(C_Htnpkkn pIfcHtnpkkn4) {
        ifcHtnpkkn4 = pIfcHtnpkkn4;
    }

    @Column(order = 204, label = "（ＩＦｃ）特定高度障害不担保区分")
    private C_TokkoudosghtnpKbn ifcTokkoudosghtnpkbn;

    public C_TokkoudosghtnpKbn getIfcTokkoudosghtnpkbn() {
        return ifcTokkoudosghtnpkbn;
    }

    public void setIfcTokkoudosghtnpkbn(C_TokkoudosghtnpKbn pIfcTokkoudosghtnpkbn) {
        ifcTokkoudosghtnpkbn = pIfcTokkoudosghtnpkbn;
    }

    @Column(order = 205, label = "（ＩＦｃ）保険証券書留区分（文字列）")
    private String ifcHknsyokakitomekbnstr;

    public String getIfcHknsyokakitomekbnstr() {
        return ifcHknsyokakitomekbnstr;
    }

    public void setIfcHknsyokakitomekbnstr(String pIfcHknsyokakitomekbnstr) {
        ifcHknsyokakitomekbnstr = pIfcHknsyokakitomekbnstr;
    }

    @Column(order = 206, label = "（ＩＦｃ）取扱コード")
    private Integer ifcTratkicd;

    public Integer getIfcTratkicd() {
        return ifcTratkicd;
    }

    public void setIfcTratkicd(Integer pIfcTratkicd) {
        ifcTratkicd = pIfcTratkicd;
    }

    @Column(order = 207, label = "（ＩＦｃ）帳票コード")
    private String ifcTyouhyoucd;

    public String getIfcTyouhyoucd() {
        return ifcTyouhyoucd;
    }

    public void setIfcTyouhyoucd(String pIfcTyouhyoucd) {
        ifcTyouhyoucd = pIfcTyouhyoucd;
    }

    @Column(order = 208, label = "（ＩＦｃ）帳票連絡先識別区分")
    private C_TyhyrenrakusikibetuKbn ifcTyhyrenrakusikibetukbn;

    public C_TyhyrenrakusikibetuKbn getIfcTyhyrenrakusikibetukbn() {
        return ifcTyhyrenrakusikibetukbn;
    }

    public void setIfcTyhyrenrakusikibetukbn(C_TyhyrenrakusikibetuKbn pIfcTyhyrenrakusikibetukbn) {
        ifcTyhyrenrakusikibetukbn = pIfcTyhyrenrakusikibetukbn;
    }

    @Column(order = 209, label = "（ＩＦｃ）がん責任開始日")
    private BizDate ifcGansknnkaisiymd;

    public BizDate getIfcGansknnkaisiymd() {
        return ifcGansknnkaisiymd;
    }

    public void setIfcGansknnkaisiymd(BizDate pIfcGansknnkaisiymd) {
        ifcGansknnkaisiymd = pIfcGansknnkaisiymd;
    }

    @Column(order = 210, label = "（ＩＦｃ）保険料免除特約区分")
    private C_PmnjtkKbn ifcPmnjtkkbn;

    public C_PmnjtkKbn getIfcPmnjtkkbn() {
        return ifcPmnjtkkbn;
    }

    public void setIfcPmnjtkkbn(C_PmnjtkKbn pIfcPmnjtkkbn) {
        ifcPmnjtkkbn = pIfcPmnjtkkbn;
    }

    @Column(order = 211, label = "（ＩＦｃ）申込書受付日")
    private BizDate ifcMosukeymd;

    public BizDate getIfcMosukeymd() {
        return ifcMosukeymd;
    }

    public void setIfcMosukeymd(BizDate pIfcMosukeymd) {
        ifcMosukeymd = pIfcMosukeymd;
    }

    @Column(order = 212, label = "（ＩＦｃ）責任開始期特約区分")
    private C_SknnkaisikitkKbn ifcSknnkaisikitkkbn;

    public C_SknnkaisikitkKbn getIfcSknnkaisikitkkbn() {
        return ifcSknnkaisikitkkbn;
    }

    public void setIfcSknnkaisikitkkbn(C_SknnkaisikitkKbn pIfcSknnkaisikitkkbn) {
        ifcSknnkaisikitkkbn = pIfcSknnkaisikitkkbn;
    }

    @Column(order = 213, label = "（ＩＦｃ）控除証明書レコード数")
    private Integer ifcKoujyosyoumeirecnum;

    public Integer getIfcKoujyosyoumeirecnum() {
        return ifcKoujyosyoumeirecnum;
    }

    public void setIfcKoujyosyoumeirecnum(Integer pIfcKoujyosyoumeirecnum) {
        ifcKoujyosyoumeirecnum = pIfcKoujyosyoumeirecnum;
    }

    @Column(order = 214, label = "（ＩＦｃ）復活責任開始日")
    private BizDate ifcHksknnkaisiymd;

    public BizDate getIfcHksknnkaisiymd() {
        return ifcHksknnkaisiymd;
    }

    public void setIfcHksknnkaisiymd(BizDate pIfcHksknnkaisiymd) {
        ifcHksknnkaisiymd = pIfcHksknnkaisiymd;
    }

    @Column(order = 215, label = "（ＩＦｃ）エンド")
    private String ifcEnd;

    public String getIfcEnd() {
        return ifcEnd;
    }

    public void setIfcEnd(String pIfcEnd) {
        ifcEnd = pIfcEnd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
