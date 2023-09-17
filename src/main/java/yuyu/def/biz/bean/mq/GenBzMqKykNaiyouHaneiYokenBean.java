package yuyu.def.biz.bean.mq;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.file.description.annotations.MultiByte;
import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.Tel;

/**
 * （共通）ＭＱ契約内容反映与件BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzMqKykNaiyouHaneiYokenBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzMqKykNaiyouHaneiYokenBean() {
    }

    @Column(order = 1, length = 4)
    @NotNull
    private String iwsSyoricd;

    public String getIwsSyoricd() {
        return iwsSyoricd;
    }

    public void setIwsSyoricd(String pIwsSyoricd) {
        iwsSyoricd = pIwsSyoricd;
    }

    @Column(order = 2, length = 1)
    @NotNull
    private String iwsKugirihugou;

    public String getIwsKugirihugou() {
        return iwsKugirihugou;
    }

    public void setIwsKugirihugou(String pIwsKugirihugou) {
        iwsKugirihugou = pIwsKugirihugou;
    }

    @Column(order = 3, length = 1)
    @NotNull
    private String iwsHuho2kyknokbn;

    public String getIwsHuho2kyknokbn() {
        return iwsHuho2kyknokbn;
    }

    public void setIwsHuho2kyknokbn(String pIwsHuho2kyknokbn) {
        iwsHuho2kyknokbn = pIwsHuho2kyknokbn;
    }

    @Column(order = 4, length = 11)
    @NotNull
    private String iwsHuho2kykno;

    public String getIwsHuho2kykno() {
        return iwsHuho2kykno;
    }

    public void setIwsHuho2kykno(String pIwsHuho2kykno) {
        iwsHuho2kykno = pIwsHuho2kykno;
    }

    @Column(order = 5, length = 1)
    @NotNull
    private String iwsRecordsakujyohyouji;

    public String getIwsRecordsakujyohyouji() {
        return iwsRecordsakujyohyouji;
    }

    public void setIwsRecordsakujyohyouji(String pIwsRecordsakujyohyouji) {
        iwsRecordsakujyohyouji = pIwsRecordsakujyohyouji;
    }

    @Column(order = 6, length = 2)
    @NotNull
    private String iwsKhsyouhncd;

    public String getIwsKhsyouhncd() {
        return iwsKhsyouhncd;
    }

    public void setIwsKhsyouhncd(String pIwsKhsyouhncd) {
        iwsKhsyouhncd = pIwsKhsyouhncd;
    }

    @Column(order = 7, length = 2)
    @NotNull
    private String iwsKhkykjyoutai;

    public String getIwsKhkykjyoutai() {
        return iwsKhkykjyoutai;
    }

    public void setIwsKhkykjyoutai(String pIwsKhkykjyoutai) {
        iwsKhkykjyoutai = pIwsKhkykjyoutai;
    }

    @Column(order = 8, length = 8)
    @NotNull
    private BizDate iwsKhkykymd;

    public BizDate getIwsKhkykymd() {
        return iwsKhkykymd;
    }

    public void setIwsKhkykymd(BizDate pIwsKhkykymd) {
        iwsKhkykymd = pIwsKhkykymd;
    }

    @Column(order = 9, length = 1)
    @NotNull
    private String iwsKhyuukousyoumetukbn;

    public String getIwsKhyuukousyoumetukbn() {
        return iwsKhyuukousyoumetukbn;
    }

    public void setIwsKhyuukousyoumetukbn(String pIwsKhyuukousyoumetukbn) {
        iwsKhyuukousyoumetukbn = pIwsKhyuukousyoumetukbn;
    }

    @Column(order = 10, length = 2)
    @NotNull
    private String iwsKhsyoumetujiyuu;

    public String getIwsKhsyoumetujiyuu() {
        return iwsKhsyoumetujiyuu;
    }

    public void setIwsKhsyoumetujiyuu(String pIwsKhsyoumetujiyuu) {
        iwsKhsyoumetujiyuu = pIwsKhsyoumetujiyuu;
    }

    @Column(order = 11, length = 8)
    @NotNull
    private BizDate iwsKhsyoumetuymd;

    public BizDate getIwsKhsyoumetuymd() {
        return iwsKhsyoumetuymd;
    }

    public void setIwsKhsyoumetuymd(BizDate pIwsKhsyoumetuymd) {
        iwsKhsyoumetuymd = pIwsKhsyoumetuymd;
    }

    @Column(order = 12, length = 3)
    @NotNull
    private String iwsKhtsntuukasyu;

    public String getIwsKhtsntuukasyu() {
        return iwsKhtsntuukasyu;
    }

    public void setIwsKhtsntuukasyu(String pIwsKhtsntuukasyu) {
        iwsKhtsntuukasyu = pIwsKhtsntuukasyu;
    }

    @Column(order = 13, length = 11)
    @NotNull
    private String iwsKhtsnyousibous;

    public String getIwsKhtsnyousibous() {
        return iwsKhtsnyousibous;
    }

    public void setIwsKhtsnyousibous(String pIwsKhtsnyousibous) {
        iwsKhtsnyousibous = pIwsKhtsnyousibous;
    }

    @Column(order = 14, length = 11)
    @NotNull
    private String iwsKhtsnyouitijip;

    public String getIwsKhtsnyouitijip() {
        return iwsKhtsnyouitijip;
    }

    public void setIwsKhtsnyouitijip(String pIwsKhtsnyouitijip) {
        iwsKhtsnyouitijip = pIwsKhtsnyouitijip;
    }

    @Column(order = 15, length = 11)
    @NotNull
    private String iwsKhtsnyounkgns;

    public String getIwsKhtsnyounkgns() {
        return iwsKhtsnyounkgns;
    }

    public void setIwsKhtsnyounkgns(String pIwsKhtsnyounkgns) {
        iwsKhtsnyounkgns = pIwsKhtsnyounkgns;
    }

    @Column(order = 16, length = 2)
    @NotNull
    private Integer iwsKhhrkkkn;

    public Integer getIwsKhhrkkkn() {
        return iwsKhhrkkkn;
    }

    public void setIwsKhhrkkkn(Integer pIwsKhhrkkkn) {
        iwsKhhrkkkn = pIwsKhhrkkkn;
    }

    @Column(order = 17, length = 2)
    @NotNull
    private String iwsKhsntkhoukbn;

    public String getIwsKhsntkhoukbn() {
        return iwsKhsntkhoukbn;
    }

    public void setIwsKhsntkhoukbn(String pIwsKhsntkhoukbn) {
        iwsKhsntkhoukbn = pIwsKhsntkhoukbn;
    }

    @Column(order = 18, length = 6)
    @NotNull
    private BizDateYM iwsKhbosyuuym;

    public BizDateYM getIwsKhbosyuuym() {
        return iwsKhbosyuuym;
    }

    public void setIwsKhbosyuuym(BizDateYM pIwsKhbosyuuym) {
        iwsKhbosyuuym = pIwsKhbosyuuym;
    }

    @Column(order = 19, length = 1)
    @NotNull
    private String iwsKhkykhhkndouhyouji;

    public String getIwsKhkykhhkndouhyouji() {
        return iwsKhkykhhkndouhyouji;
    }

    public void setIwsKhkykhhkndouhyouji(String pIwsKhkykhhkndouhyouji) {
        iwsKhkykhhkndouhyouji = pIwsKhkykhhkndouhyouji;
    }

    @Column(order = 20, length = 2)
    @NotNull
    private String iwsKhttdktyuuikbn1;

    public String getIwsKhttdktyuuikbn1() {
        return iwsKhttdktyuuikbn1;
    }

    public void setIwsKhttdktyuuikbn1(String pIwsKhttdktyuuikbn1) {
        iwsKhttdktyuuikbn1 = pIwsKhttdktyuuikbn1;
    }

    @Column(order = 21, length = 2)
    @NotNull
    private String iwsKhttdktyuuikbn2;

    public String getIwsKhttdktyuuikbn2() {
        return iwsKhttdktyuuikbn2;
    }

    public void setIwsKhttdktyuuikbn2(String pIwsKhttdktyuuikbn2) {
        iwsKhttdktyuuikbn2 = pIwsKhttdktyuuikbn2;
    }

    @Column(order = 22, length = 2)
    @NotNull
    private String iwsKhttdktyuuikbn3;

    public String getIwsKhttdktyuuikbn3() {
        return iwsKhttdktyuuikbn3;
    }

    public void setIwsKhttdktyuuikbn3(String pIwsKhttdktyuuikbn3) {
        iwsKhttdktyuuikbn3 = pIwsKhttdktyuuikbn3;
    }

    @Column(order = 23, length = 2)
    @NotNull
    private String iwsKhttdktyuuikbn4;

    public String getIwsKhttdktyuuikbn4() {
        return iwsKhttdktyuuikbn4;
    }

    public void setIwsKhttdktyuuikbn4(String pIwsKhttdktyuuikbn4) {
        iwsKhttdktyuuikbn4 = pIwsKhttdktyuuikbn4;
    }

    @Column(order = 24, length = 2)
    @NotNull
    private String iwsKhttdktyuuikbn5;

    public String getIwsKhttdktyuuikbn5() {
        return iwsKhttdktyuuikbn5;
    }

    public void setIwsKhttdktyuuikbn5(String pIwsKhttdktyuuikbn5) {
        iwsKhttdktyuuikbn5 = pIwsKhttdktyuuikbn5;
    }

    @Column(order = 25, length = 2)
    @NotNull
    private Integer iwsKhsyouhnsdno;

    public Integer getIwsKhsyouhnsdno() {
        return iwsKhsyouhnsdno;
    }

    public void setIwsKhsyouhnsdno(Integer pIwsKhsyouhnsdno) {
        iwsKhsyouhnsdno = pIwsKhsyouhnsdno;
    }

    @Column(order = 26, length = 1)
    @NotNull
    private String iwsKhkaigomaehrtkykarihyj;

    public String getIwsKhkaigomaehrtkykarihyj() {
        return iwsKhkaigomaehrtkykarihyj;
    }

    public void setIwsKhkaigomaehrtkykarihyj(String pIwsKhkaigomaehrtkykarihyj) {
        iwsKhkaigomaehrtkykarihyj = pIwsKhkaigomaehrtkykarihyj;
    }

    @Column(order = 27, length = 1)
    @NotNull
    private String iwsKhpyennykntkykarihyj;

    public String getIwsKhpyennykntkykarihyj() {
        return iwsKhpyennykntkykarihyj;
    }

    public void setIwsKhpyennykntkykarihyj(String pIwsKhpyennykntkykarihyj) {
        iwsKhpyennykntkykarihyj = pIwsKhpyennykntkykarihyj;
    }

    @Column(order = 28, length = 11)
    @NotNull
    private String iwsKhtsnyennyknkgk;

    public String getIwsKhtsnyennyknkgk() {
        return iwsKhtsnyennyknkgk;
    }

    public void setIwsKhtsnyennyknkgk(String pIwsKhtsnyennyknkgk) {
        iwsKhtsnyennyknkgk = pIwsKhtsnyennyknkgk;
    }

    @Column(order = 29, length = 9)
    @NotNull
    private String iwsKhskmosno;

    public String getIwsKhskmosno() {
        return iwsKhskmosno;
    }

    public void setIwsKhskmosno(String pIwsKhskmosno) {
        iwsKhskmosno = pIwsKhskmosno;
    }

    @Column(order = 30, length = 1)
    @NotNull
    private String iwsHouteityotikuseiarihyj;

    public String getIwsHouteityotikuseiarihyj() {
        return iwsHouteityotikuseiarihyj;
    }

    public void setIwsHouteityotikuseiarihyj(String pIwsHouteityotikuseiarihyj) {
        iwsHouteityotikuseiarihyj = pIwsHouteityotikuseiarihyj;
    }

    @Column(order = 31, length = 1)
    @NotNull
    private String iwsSeiritujitrhkjikakkbn;

    public String getIwsSeiritujitrhkjikakkbn() {
        return iwsSeiritujitrhkjikakkbn;
    }

    public void setIwsSeiritujitrhkjikakkbn(String pIwsSeiritujitrhkjikakkbn) {
        iwsSeiritujitrhkjikakkbn = pIwsSeiritujitrhkjikakkbn;
    }

    @Column(order = 32, length = 1)
    @NotNull
    private String iwsKhhrkkeirokbn;

    public String getIwsKhhrkkeirokbn() {
        return iwsKhhrkkeirokbn;
    }

    public void setIwsKhhrkkeirokbn(String pIwsKhhrkkeirokbn) {
        iwsKhhrkkeirokbn = pIwsKhhrkkeirokbn;
    }

    @Column(order = 33, length = 2)
    @NotNull
    private String iwsSksyouhncd;

    public String getIwsSksyouhncd() {
        return iwsSksyouhncd;
    }

    public void setIwsSksyouhncd(String pIwsSksyouhncd) {
        iwsSksyouhncd = pIwsSksyouhncd;
    }

    @Column(order = 34, length = 8)
    @NotNull
    private BizDate iwsSkmosymd;

    public BizDate getIwsSkmosymd() {
        return iwsSkmosymd;
    }

    public void setIwsSkmosymd(BizDate pIwsSkmosymd) {
        iwsSkmosymd = pIwsSkmosymd;
    }

    @Column(order = 35, length = 8)
    @NotNull
    private BizDate iwsSkkykymd;

    public BizDate getIwsSkkykymd() {
        return iwsSkkykymd;
    }

    public void setIwsSkkykymd(BizDate pIwsSkkykymd) {
        iwsSkkykymd = pIwsSkkykymd;
    }

    @Column(order = 36, length = 8)
    @NotNull
    private BizDate iwsSksknnkaisiymd;

    public BizDate getIwsSksknnkaisiymd() {
        return iwsSksknnkaisiymd;
    }

    public void setIwsSksknnkaisiymd(BizDate pIwsSksknnkaisiymd) {
        iwsSksknnkaisiymd = pIwsSksknnkaisiymd;
    }

    @Column(order = 37, length = 1)
    @NotNull
    private String iwsSkseiritukbn;

    public String getIwsSkseiritukbn() {
        return iwsSkseiritukbn;
    }

    public void setIwsSkseiritukbn(String pIwsSkseiritukbn) {
        iwsSkseiritukbn = pIwsSkseiritukbn;
    }

    @Column(order = 38, length = 8)
    @NotNull
    private BizDate iwsSksrsyoriymd;

    public BizDate getIwsSksrsyoriymd() {
        return iwsSksrsyoriymd;
    }

    public void setIwsSksrsyoriymd(BizDate pIwsSksrsyoriymd) {
        iwsSksrsyoriymd = pIwsSksrsyoriymd;
    }

    @Column(order = 39, length = 1)
    @NotNull
    private String iwsSkmfrenflg;

    public String getIwsSkmfrenflg() {
        return iwsSkmfrenflg;
    }

    public void setIwsSkmfrenflg(String pIwsSkmfrenflg) {
        iwsSkmfrenflg = pIwsSkmfrenflg;
    }

    @Column(order = 40, length = 11)
    @NotNull
    private String iwsSksyono;

    public String getIwsSksyono() {
        return iwsSksyono;
    }

    public void setIwsSksyono(String pIwsSksyono) {
        iwsSksyono = pIwsSksyono;
    }

    @Column(order = 41, length = 3)
    @NotNull
    private String iwsSktsntuukasyu;

    public String getIwsSktsntuukasyu() {
        return iwsSktsntuukasyu;
    }

    public void setIwsSktsntuukasyu(String pIwsSktsntuukasyu) {
        iwsSktsntuukasyu = pIwsSktsntuukasyu;
    }

    @Column(order = 42, length = 11)
    @NotNull
    private String iwsSktsnyousibous;

    public String getIwsSktsnyousibous() {
        return iwsSktsnyousibous;
    }

    public void setIwsSktsnyousibous(String pIwsSktsnyousibous) {
        iwsSktsnyousibous = pIwsSktsnyousibous;
    }

    @Column(order = 43, length = 11)
    @NotNull
    private String iwsSktsnyouitijip;

    public String getIwsSktsnyouitijip() {
        return iwsSktsnyouitijip;
    }

    public void setIwsSktsnyouitijip(String pIwsSktsnyouitijip) {
        iwsSktsnyouitijip = pIwsSktsnyouitijip;
    }

    @Column(order = 44, length = 11)
    @NotNull
    private String iwsSktsnyounkgns;

    public String getIwsSktsnyounkgns() {
        return iwsSktsnyounkgns;
    }

    public void setIwsSktsnyounkgns(String pIwsSktsnyounkgns) {
        iwsSktsnyounkgns = pIwsSktsnyounkgns;
    }

    @Column(order = 45, length = 2)
    @NotNull
    private Integer iwsSkhrkkkn;

    public Integer getIwsSkhrkkkn() {
        return iwsSkhrkkkn;
    }

    public void setIwsSkhrkkkn(Integer pIwsSkhrkkkn) {
        iwsSkhrkkkn = pIwsSkhrkkkn;
    }

    @Column(order = 46, length = 2)
    @NotNull
    private String iwsSksntkhoukbn;

    public String getIwsSksntkhoukbn() {
        return iwsSksntkhoukbn;
    }

    public void setIwsSksntkhoukbn(String pIwsSksntkhoukbn) {
        iwsSksntkhoukbn = pIwsSksntkhoukbn;
    }

    @Column(order = 47, length = 6)
    @NotNull
    private BizDateYM iwsSkbosyuuym;

    public BizDateYM getIwsSkbosyuuym() {
        return iwsSkbosyuuym;
    }

    public void setIwsSkbosyuuym(BizDateYM pIwsSkbosyuuym) {
        iwsSkbosyuuym = pIwsSkbosyuuym;
    }

    @Column(order = 48, length = 1)
    @NotNull
    private String iwsSkkykhhkndouhyouji;

    public String getIwsSkkykhhkndouhyouji() {
        return iwsSkkykhhkndouhyouji;
    }

    public void setIwsSkkykhhkndouhyouji(String pIwsSkkykhhkndouhyouji) {
        iwsSkkykhhkndouhyouji = pIwsSkkykhhkndouhyouji;
    }

    @Column(order = 49, length = 1)
    @NotNull
    private String iwsSkmossyoumetukbn;

    public String getIwsSkmossyoumetukbn() {
        return iwsSkmossyoumetukbn;
    }

    public void setIwsSkmossyoumetukbn(String pIwsSkmossyoumetukbn) {
        iwsSkmossyoumetukbn = pIwsSkmossyoumetukbn;
    }

    @Column(order = 50, length = 2)
    @NotNull
    private Integer iwsSksyouhnsdno;

    public Integer getIwsSksyouhnsdno() {
        return iwsSksyouhnsdno;
    }

    public void setIwsSksyouhnsdno(Integer pIwsSksyouhnsdno) {
        iwsSksyouhnsdno = pIwsSksyouhnsdno;
    }

    @Column(order = 51, length = 1)
    @NotNull
    private String iwsSkkaigomaehrtkykarihyj;

    public String getIwsSkkaigomaehrtkykarihyj() {
        return iwsSkkaigomaehrtkykarihyj;
    }

    public void setIwsSkkaigomaehrtkykarihyj(String pIwsSkkaigomaehrtkykarihyj) {
        iwsSkkaigomaehrtkykarihyj = pIwsSkkaigomaehrtkykarihyj;
    }

    @Column(order = 52, length = 1)
    @NotNull
    private String iwsSkpyennykntkykarihyj;

    public String getIwsSkpyennykntkykarihyj() {
        return iwsSkpyennykntkykarihyj;
    }

    public void setIwsSkpyennykntkykarihyj(String pIwsSkpyennykntkykarihyj) {
        iwsSkpyennykntkykarihyj = pIwsSkpyennykntkykarihyj;
    }

    @Column(order = 53, length = 11)
    @NotNull
    private String iwsSktsnyennyknkgk;

    public String getIwsSktsnyennyknkgk() {
        return iwsSktsnyennyknkgk;
    }

    public void setIwsSktsnyennyknkgk(String pIwsSktsnyennyknkgk) {
        iwsSktsnyennyknkgk = pIwsSktsnyennyknkgk;
    }

    @Column(order = 54, length = 1)
    @NotNull
    private String iwsSkhrkkeirokbn;

    public String getIwsSkhrkkeirokbn() {
        return iwsSkhrkkeirokbn;
    }

    public void setIwsSkhrkkeirokbn(String pIwsSkhrkkeirokbn) {
        iwsSkhrkkeirokbn = pIwsSkhrkkeirokbn;
    }

    @Column(order = 55, length = 2)
    @NotNull
    private String iwsNksyouhncd;

    public String getIwsNksyouhncd() {
        return iwsNksyouhncd;
    }

    public void setIwsNksyouhncd(String pIwsNksyouhncd) {
        iwsNksyouhncd = pIwsNksyouhncd;
    }

    @Column(order = 56, length = 8)
    @NotNull
    private BizDate iwsNknkshrstartymd;

    public BizDate getIwsNknkshrstartymd() {
        return iwsNknkshrstartymd;
    }

    public void setIwsNknkshrstartymd(BizDate pIwsNknkshrstartymd) {
        iwsNknkshrstartymd = pIwsNknkshrstartymd;
    }

    @Column(order = 57, length = 8)
    @NotNull
    private BizDate iwsNkkykymd;

    public BizDate getIwsNkkykymd() {
        return iwsNkkykymd;
    }

    public void setIwsNkkykymd(BizDate pIwsNkkykymd) {
        iwsNkkykymd = pIwsNkkykymd;
    }

    @Column(order = 58, length = 2)
    @NotNull
    private String iwsNknksyoumetucd;

    public String getIwsNknksyoumetucd() {
        return iwsNknksyoumetucd;
    }

    public void setIwsNknksyoumetucd(String pIwsNknksyoumetucd) {
        iwsNknksyoumetucd = pIwsNknksyoumetucd;
    }

    @Column(order = 59, length = 8)
    @NotNull
    private BizDate iwsNksyoumtymd;

    public BizDate getIwsNksyoumtymd() {
        return iwsNksyoumtymd;
    }

    public void setIwsNksyoumtymd(BizDate pIwsNksyoumtymd) {
        iwsNksyoumtymd = pIwsNksyoumtymd;
    }

    @Column(order = 60, length = 3)
    @NotNull
    private String iwsNkshrtuukasyu;

    public String getIwsNkshrtuukasyu() {
        return iwsNkshrtuukasyu;
    }

    public void setIwsNkshrtuukasyu(String pIwsNkshrtuukasyu) {
        iwsNkshrtuukasyu = pIwsNkshrtuukasyu;
    }

    @Column(order = 61, length = 2)
    @NotNull
    private String iwsNkteinksyu;

    public String getIwsNkteinksyu() {
        return iwsNkteinksyu;
    }

    public void setIwsNkteinksyu(String pIwsNkteinksyu) {
        iwsNkteinksyu = pIwsNkteinksyu;
    }

    @Column(order = 62, length = 11)
    @NotNull
    private String iwsNktsnnkgns;

    public String getIwsNktsnnkgns() {
        return iwsNktsnnkgns;
    }

    public void setIwsNktsnnkgns(String pIwsNktsnnkgns) {
        iwsNktsnnkgns = pIwsNktsnnkgns;
    }

    @Column(order = 63, length = 1)
    @NotNull
    private String iwsNknkukthhkndouhyouji;

    public String getIwsNknkukthhkndouhyouji() {
        return iwsNknkukthhkndouhyouji;
    }

    public void setIwsNknkukthhkndouhyouji(String pIwsNknkukthhkndouhyouji) {
        iwsNknkukthhkndouhyouji = pIwsNknkukthhkndouhyouji;
    }

    @Column(order = 64, length = 2)
    @NotNull
    private Integer iwsNksyouhnsdno;

    public Integer getIwsNksyouhnsdno() {
        return iwsNksyouhnsdno;
    }

    public void setIwsNksyouhnsdno(Integer pIwsNksyouhnsdno) {
        iwsNksyouhnsdno = pIwsNksyouhnsdno;
    }

    @Column(order = 65, length = 18)
    @NotNull
    @MaxLength(max=18)
    @SingleByteStrings
    @InvalidCharacter
    private String iwsHhknnm;

    public String getIwsHhknnm() {
        return iwsHhknnm;
    }

    public void setIwsHhknnm(String pIwsHhknnm) {
        iwsHhknnm = pIwsHhknnm;
    }

    @Column(order = 66, length = 15)
    @MultiByte
    @NotNull
    private String iwsKjhhknnm;

    public String getIwsKjhhknnm() {
        return iwsKjhhknnm;
    }

    @DataConvert("toMultiByte")
    public void setIwsKjhhknnm(String pIwsKjhhknnm) {
        iwsKjhhknnm = pIwsKjhhknnm;
    }

    @Column(order = 67, length = 8)
    @NotNull
    @ValidDate
    private BizDate iwsHhknseiymd;

    public BizDate getIwsHhknseiymd() {
        return iwsHhknseiymd;
    }

    public void setIwsHhknseiymd(BizDate pIwsHhknseiymd) {
        iwsHhknseiymd = pIwsHhknseiymd;
    }

    @Column(order = 68, length = 1)
    @NotNull
    @MaxLength(max=1)
    @SingleByteStrings
    private String iwsHhknseikbn;

    public String getIwsHhknseikbn() {
        return iwsHhknseikbn;
    }

    public void setIwsHhknseikbn(String pIwsHhknseikbn) {
        iwsHhknseikbn = pIwsHhknseikbn;
    }

    @Column(order = 69, length = 7)
    @NotNull
    private String iwsHhknnewyno;

    public String getIwsHhknnewyno() {
        return iwsHhknnewyno;
    }

    public void setIwsHhknnewyno(String pIwsHhknnewyno) {
        iwsHhknnewyno = pIwsHhknnewyno;
    }

    @Column(order = 70, length = 62)
    @MultiByte
    @NotNull
    private String iwsHhknadr;

    public String getIwsHhknadr() {
        return iwsHhknadr;
    }

    @DataConvert("toMultiByte")
    public void setIwsHhknadr(String pIwsHhknadr) {
        iwsHhknadr = pIwsHhknadr;
    }

    @Column(order = 71, length = 14)
    @NotNull
    private String iwsHhkntelno;

    public String getIwsHhkntelno() {
        return iwsHhkntelno;
    }

    public void setIwsHhkntelno(String pIwsHhkntelno) {
        iwsHhkntelno = pIwsHhkntelno;
    }

    @Column(order = 72, length = 3)
    @NotNull
    private String iwsHhknsyokugyoucd;

    public String getIwsHhknsyokugyoucd() {
        return iwsHhknsyokugyoucd;
    }

    public void setIwsHhknsyokugyoucd(String pIwsHhknsyokugyoucd) {
        iwsHhknsyokugyoucd = pIwsHhknsyokugyoucd;
    }

    @Column(order = 73, length = 18)
    @NotNull
    @MaxLength(max=18)
    @SingleByteStrings
    @InvalidCharacter
    private String iwsKyknm;

    public String getIwsKyknm() {
        return iwsKyknm;
    }

    public void setIwsKyknm(String pIwsKyknm) {
        iwsKyknm = pIwsKyknm;
    }

    @Column(order = 74, length = 15)
    @MultiByte
    @NotNull
    private String iwsKjkyknm;

    public String getIwsKjkyknm() {
        return iwsKjkyknm;
    }

    @DataConvert("toMultiByte")
    public void setIwsKjkyknm(String pIwsKjkyknm) {
        iwsKjkyknm = pIwsKjkyknm;
    }

    @Column(order = 75, length = 8)
    @NotNull
    private BizDate iwsKyksyaseiymd;

    public BizDate getIwsKyksyaseiymd() {
        return iwsKyksyaseiymd;
    }

    public void setIwsKyksyaseiymd(BizDate pIwsKyksyaseiymd) {
        iwsKyksyaseiymd = pIwsKyksyaseiymd;
    }

    @Column(order = 76, length = 18)
    @NotNull
    private String iwsNkuktnm;

    public String getIwsNkuktnm() {
        return iwsNkuktnm;
    }

    public void setIwsNkuktnm(String pIwsNkuktnm) {
        iwsNkuktnm = pIwsNkuktnm;
    }

    @Column(order = 77, length = 15)
    @MultiByte
    @NotNull
    private String iwsKjnkuktnm;

    public String getIwsKjnkuktnm() {
        return iwsKjnkuktnm;
    }

    @DataConvert("toMultiByte")
    public void setIwsKjnkuktnm(String pIwsKjnkuktnm) {
        iwsKjnkuktnm = pIwsKjnkuktnm;
    }

    @Column(order = 78, length = 8)
    @NotNull
    private BizDate iwsNenkinuktseiymd;

    public BizDate getIwsNenkinuktseiymd() {
        return iwsNenkinuktseiymd;
    }

    public void setIwsNenkinuktseiymd(BizDate pIwsNenkinuktseiymd) {
        iwsNenkinuktseiymd = pIwsNenkinuktseiymd;
    }

    @Column(order = 79, length = 7)
    @NotNull
    private String iwsTsnsknewyno;

    public String getIwsTsnsknewyno() {
        return iwsTsnsknewyno;
    }

    public void setIwsTsnsknewyno(String pIwsTsnsknewyno) {
        iwsTsnsknewyno = pIwsTsnsknewyno;
    }

    @Column(order = 80, length = 62)
    @MultiByte
    @NotNull
    private String iwsTsinadr;

    public String getIwsTsinadr() {
        return iwsTsinadr;
    }

    @DataConvert("toMultiByte")
    public void setIwsTsinadr(String pIwsTsinadr) {
        iwsTsinadr = pIwsTsinadr;
    }

    @Column(order = 81, length = 14)
    @NotNull
    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    private String iwsTsintelno;

    public String getIwsTsintelno() {
        return iwsTsintelno;
    }

    public void setIwsTsintelno(String pIwsTsintelno) {
        iwsTsintelno = pIwsTsintelno;
    }

    @Column(order = 82, length = 18)
    @NotNull
    private String iwsSbuktnm1;

    public String getIwsSbuktnm1() {
        return iwsSbuktnm1;
    }

    public void setIwsSbuktnm1(String pIwsSbuktnm1) {
        iwsSbuktnm1 = pIwsSbuktnm1;
    }

    @Column(order = 83, length = 15)
    @MultiByte
    @NotNull
    private String iwsKjsbuktnm1;

    public String getIwsKjsbuktnm1() {
        return iwsKjsbuktnm1;
    }

    @DataConvert("toMultiByte")
    public void setIwsKjsbuktnm1(String pIwsKjsbuktnm1) {
        iwsKjsbuktnm1 = pIwsKjsbuktnm1;
    }

    @Column(order = 84, length = 18)
    @NotNull
    private String iwsSbuktnm2;

    public String getIwsSbuktnm2() {
        return iwsSbuktnm2;
    }

    public void setIwsSbuktnm2(String pIwsSbuktnm2) {
        iwsSbuktnm2 = pIwsSbuktnm2;
    }

    @Column(order = 85, length = 15)
    @MultiByte
    @NotNull
    private String iwsKjsbuktnm2;

    public String getIwsKjsbuktnm2() {
        return iwsKjsbuktnm2;
    }

    @DataConvert("toMultiByte")
    public void setIwsKjsbuktnm2(String pIwsKjsbuktnm2) {
        iwsKjsbuktnm2 = pIwsKjsbuktnm2;
    }

    @Column(order = 86, length = 18)
    @NotNull
    private String iwsSbuktnm3;

    public String getIwsSbuktnm3() {
        return iwsSbuktnm3;
    }

    public void setIwsSbuktnm3(String pIwsSbuktnm3) {
        iwsSbuktnm3 = pIwsSbuktnm3;
    }

    @Column(order = 87, length = 15)
    @MultiByte
    @NotNull
    private String iwsKjsbuktnm3;

    public String getIwsKjsbuktnm3() {
        return iwsKjsbuktnm3;
    }

    @DataConvert("toMultiByte")
    public void setIwsKjsbuktnm3(String pIwsKjsbuktnm3) {
        iwsKjsbuktnm3 = pIwsKjsbuktnm3;
    }

    @Column(order = 88, length = 18)
    @NotNull
    private String iwsSbuktnm4;

    public String getIwsSbuktnm4() {
        return iwsSbuktnm4;
    }

    public void setIwsSbuktnm4(String pIwsSbuktnm4) {
        iwsSbuktnm4 = pIwsSbuktnm4;
    }

    @Column(order = 89, length = 15)
    @MultiByte
    @NotNull
    private String iwsKjsbuktnm4;

    public String getIwsKjsbuktnm4() {
        return iwsKjsbuktnm4;
    }

    @DataConvert("toMultiByte")
    public void setIwsKjsbuktnm4(String pIwsKjsbuktnm4) {
        iwsKjsbuktnm4 = pIwsKjsbuktnm4;
    }

    @Column(order = 90, length = 18)
    @NotNull
    private String iwsStdrsknm;

    public String getIwsStdrsknm() {
        return iwsStdrsknm;
    }

    public void setIwsStdrsknm(String pIwsStdrsknm) {
        iwsStdrsknm = pIwsStdrsknm;
    }

    @Column(order = 91, length = 15)
    @MultiByte
    @NotNull
    private String iwsKjstdrsknm;

    public String getIwsKjstdrsknm() {
        return iwsKjstdrsknm;
    }

    @DataConvert("toMultiByte")
    public void setIwsKjstdrsknm(String pIwsKjstdrsknm) {
        iwsKjstdrsknm = pIwsKjstdrsknm;
    }

    @Column(order = 92, length = 18)
    @NotNull
    private String iwsKykdairinm;

    public String getIwsKykdairinm() {
        return iwsKykdairinm;
    }

    public void setIwsKykdairinm(String pIwsKykdairinm) {
        iwsKykdairinm = pIwsKykdairinm;
    }

    @Column(order = 93, length = 15)
    @MultiByte
    @NotNull
    private String iwsKjkykdairinm;

    public String getIwsKjkykdairinm() {
        return iwsKjkykdairinm;
    }

    @DataConvert("toMultiByte")
    public void setIwsKjkykdairinm(String pIwsKjkykdairinm) {
        iwsKjkykdairinm = pIwsKjkykdairinm;
    }

    @Column(order = 94, length = 18)
    @NotNull
    private String iwsKzktourokunm1;

    public String getIwsKzktourokunm1() {
        return iwsKzktourokunm1;
    }

    public void setIwsKzktourokunm1(String pIwsKzktourokunm1) {
        iwsKzktourokunm1 = pIwsKzktourokunm1;
    }

    @Column(order = 95, length = 15)
    @MultiByte
    @NotNull
    private String iwsKjkzktourokunm1;

    public String getIwsKjkzktourokunm1() {
        return iwsKjkzktourokunm1;
    }

    @DataConvert("toMultiByte")
    public void setIwsKjkzktourokunm1(String pIwsKjkzktourokunm1) {
        iwsKjkzktourokunm1 = pIwsKjkzktourokunm1;
    }

    @Column(order = 96, length = 18)
    @NotNull
    private String iwsKzktourokunm2;

    public String getIwsKzktourokunm2() {
        return iwsKzktourokunm2;
    }

    public void setIwsKzktourokunm2(String pIwsKzktourokunm2) {
        iwsKzktourokunm2 = pIwsKzktourokunm2;
    }

    @Column(order = 97, length = 15)
    @MultiByte
    @NotNull
    private String iwsKjkzktourokunm2;

    public String getIwsKjkzktourokunm2() {
        return iwsKjkzktourokunm2;
    }

    @DataConvert("toMultiByte")
    public void setIwsKjkzktourokunm2(String pIwsKjkzktourokunm2) {
        iwsKjkzktourokunm2 = pIwsKjkzktourokunm2;
    }

    @Column(order = 98, length = 4)
    @NotNull
    private String iwsBankcd;

    public String getIwsBankcd() {
        return iwsBankcd;
    }

    public void setIwsBankcd(String pIwsBankcd) {
        iwsBankcd = pIwsBankcd;
    }

    @Column(order = 99, length = 3)
    @NotNull
    private String iwsSitencd;

    public String getIwsSitencd() {
        return iwsSitencd;
    }

    public void setIwsSitencd(String pIwsSitencd) {
        iwsSitencd = pIwsSitencd;
    }

    @Column(order = 100, length = 1)
    @NotNull
    private String iwsYokinkbn;

    public String getIwsYokinkbn() {
        return iwsYokinkbn;
    }

    public void setIwsYokinkbn(String pIwsYokinkbn) {
        iwsYokinkbn = pIwsYokinkbn;
    }

    @Column(order = 101, length = 7)
    @NotNull
    private String iwsKouzano7keta;

    public String getIwsKouzano7keta() {
        return iwsKouzano7keta;
    }

    public void setIwsKouzano7keta(String pIwsKouzano7keta) {
        iwsKouzano7keta = pIwsKouzano7keta;
    }

    @Column(order = 102, length = 30)
    @NotNull
    private String iwsKzmeiginmei;

    public String getIwsKzmeiginmei() {
        return iwsKzmeiginmei;
    }

    public void setIwsKzmeiginmei(String pIwsKzmeiginmei) {
        iwsKzmeiginmei = pIwsKzmeiginmei;
    }

    @Column(order = 103, length = 1)
    @NotNull
    private String iwsKzkykdouhyouji;

    public String getIwsKzkykdouhyouji() {
        return iwsKzkykdouhyouji;
    }

    public void setIwsKzkykdouhyouji(String pIwsKzkykdouhyouji) {
        iwsKzkykdouhyouji = pIwsKzkykdouhyouji;
    }

    @Column(order = 104, length = 7)
    @NotNull
    private String iwsDairitencd1;

    public String getIwsDairitencd1() {
        return iwsDairitencd1;
    }

    public void setIwsDairitencd1(String pIwsDairitencd1) {
        iwsDairitencd1 = pIwsDairitencd1;
    }

    @Column(order = 105, length = 3)
    @NotNull
    private BizNumber iwsBunwari1;

    public BizNumber getIwsBunwari1() {
        return iwsBunwari1;
    }

    public void setIwsBunwari1(BizNumber pIwsBunwari1) {
        iwsBunwari1 = pIwsBunwari1;
    }

    @Column(order = 106, length = 7)
    @NotNull
    private String iwsDairitencd2;

    public String getIwsDairitencd2() {
        return iwsDairitencd2;
    }

    public void setIwsDairitencd2(String pIwsDairitencd2) {
        iwsDairitencd2 = pIwsDairitencd2;
    }

    @Column(order = 107, length = 3)
    @NotNull
    private BizNumber iwsBunwari2;

    public BizNumber getIwsBunwari2() {
        return iwsBunwari2;
    }

    public void setIwsBunwari2(BizNumber pIwsBunwari2) {
        iwsBunwari2 = pIwsBunwari2;
    }

    @Column(order = 108, length = 7)
    @NotNull
    private String iwsAatukaisosikicd;

    public String getIwsAatukaisosikicd() {
        return iwsAatukaisosikicd;
    }

    public void setIwsAatukaisosikicd(String pIwsAatukaisosikicd) {
        iwsAatukaisosikicd = pIwsAatukaisosikicd;
    }

    @Column(order = 109, length = 7)
    @NotNull
    private String iwsBatukaisosikicd;

    public String getIwsBatukaisosikicd() {
        return iwsBatukaisosikicd;
    }

    public void setIwsBatukaisosikicd(String pIwsBatukaisosikicd) {
        iwsBatukaisosikicd = pIwsBatukaisosikicd;
    }

    @Column(order = 110, length = 18)
    @NotNull
    private String iwsYoukyuuno;

    public String getIwsYoukyuuno() {
        return iwsYoukyuuno;
    }

    public void setIwsYoukyuuno(String pIwsYoukyuuno) {
        iwsYoukyuuno = pIwsYoukyuuno;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
