package yuyu.def.biz.bean.mq;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）ＭＱ索引通算照会結果BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzMqSakuinTsnSyoukaiKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzMqSakuinTsnSyoukaiKekkaBean() {
    }

    @Column(order = 1, length = 4)
    private String iwsAcserrcd;

    public String getIwsAcserrcd() {
        return iwsAcserrcd;
    }

    public void setIwsAcserrcd(String pIwsAcserrcd) {
        iwsAcserrcd = pIwsAcserrcd;
    }

    @Column(order = 2, length = 1)
    private String iwsSakuininfosyoukaierrkbn;

    public String getIwsSakuininfosyoukaierrkbn() {
        return iwsSakuininfosyoukaierrkbn;
    }

    public void setIwsSakuininfosyoukaierrkbn(String pIwsSakuininfosyoukaierrkbn) {
        iwsSakuininfosyoukaierrkbn = pIwsSakuininfosyoukaierrkbn;
    }

    @Column(order = 3, length = 1)
    private String iwsMrsyoukaierrkbn;

    public String getIwsMrsyoukaierrkbn() {
        return iwsMrsyoukaierrkbn;
    }

    public void setIwsMrsyoukaierrkbn(String pIwsMrsyoukaierrkbn) {
        iwsMrsyoukaierrkbn = pIwsMrsyoukaierrkbn;
    }

    @Column(order = 4, length = 1)
    private String iwsSignalsyoukaierrkbn;

    public String getIwsSignalsyoukaierrkbn() {
        return iwsSignalsyoukaierrkbn;
    }

    public void setIwsSignalsyoukaierrkbn(String pIwsSignalsyoukaierrkbn) {
        iwsSignalsyoukaierrkbn = pIwsSignalsyoukaierrkbn;
    }

    @Column(order = 5, length = 1)
    private String iwsSinsntkhnsysyoukaierrkbn;

    public String getIwsSinsntkhnsysyoukaierrkbn() {
        return iwsSinsntkhnsysyoukaierrkbn;
    }

    public void setIwsSinsntkhnsysyoukaierrkbn(String pIwsSinsntkhnsysyoukaierrkbn) {
        iwsSinsntkhnsysyoukaierrkbn = pIwsSinsntkhnsysyoukaierrkbn;
    }

    @Column(order = 6, length = 1)
    private String iwsTsngksyoukaierrkbn;

    public String getIwsTsngksyoukaierrkbn() {
        return iwsTsngksyoukaierrkbn;
    }

    public void setIwsTsngksyoukaierrkbn(String pIwsTsngksyoukaierrkbn) {
        iwsTsngksyoukaierrkbn = pIwsTsngksyoukaierrkbn;
    }

    @Column(order = 7, length = 1)
    private String iwsKykdrttsnssyoukaierrkbn;

    public String getIwsKykdrttsnssyoukaierrkbn() {
        return iwsKykdrttsnssyoukaierrkbn;
    }

    public void setIwsKykdrttsnssyoukaierrkbn(String pIwsKykdrttsnssyoukaierrkbn) {
        iwsKykdrttsnssyoukaierrkbn = pIwsKykdrttsnssyoukaierrkbn;
    }

    @Column(order = 8, length = 1)
    private String iwsMosskskahisyoukaierrkbn;

    public String getIwsMosskskahisyoukaierrkbn() {
        return iwsMosskskahisyoukaierrkbn;
    }

    public void setIwsMosskskahisyoukaierrkbn(String pIwsMosskskahisyoukaierrkbn) {
        iwsMosskskahisyoukaierrkbn = pIwsMosskskahisyoukaierrkbn;
    }

    @Column(order = 9, length = 1)
    private String iwsHndketyhsyoukaierrkbn;

    public String getIwsHndketyhsyoukaierrkbn() {
        return iwsHndketyhsyoukaierrkbn;
    }

    public void setIwsHndketyhsyoukaierrkbn(String pIwsHndketyhsyoukaierrkbn) {
        iwsHndketyhsyoukaierrkbn = pIwsHndketyhsyoukaierrkbn;
    }

    @Column(order = 10, length = 1)
    private String iwsNysjissikekkakbn;

    public String getIwsNysjissikekkakbn() {
        return iwsNysjissikekkakbn;
    }

    public void setIwsNysjissikekkakbn(String pIwsNysjissikekkakbn) {
        iwsNysjissikekkakbn = pIwsNysjissikekkakbn;
    }

    @Column(order = 11, length = 1)
    private String iwsNysjyoutaikbn;

    public String getIwsNysjyoutaikbn() {
        return iwsNysjyoutaikbn;
    }

    public void setIwsNysjyoutaikbn(String pIwsNysjyoutaikbn) {
        iwsNysjyoutaikbn = pIwsNysjyoutaikbn;
    }

    @Column(order = 12, length = 10)
    private String iwsSakuinnmno;

    public String getIwsSakuinnmno() {
        return iwsSakuinnmno;
    }

    public void setIwsSakuinnmno(String pIwsSakuinnmno) {
        iwsSakuinnmno = pIwsSakuinnmno;
    }

    @Column(order = 13, length = 4)
    private String iwsPalerrriyuucd;

    public String getIwsPalerrriyuucd() {
        return iwsPalerrriyuucd;
    }

    public void setIwsPalerrriyuucd(String pIwsPalerrriyuucd) {
        iwsPalerrriyuucd = pIwsPalerrriyuucd;
    }

    @Column(order = 14, length = 2)
    private String iwsKykmfkobetukmkensuu;

    public String getIwsKykmfkobetukmkensuu() {
        return iwsKykmfkobetukmkensuu;
    }

    public void setIwsKykmfkobetukmkensuu(String pIwsKykmfkobetukmkensuu) {
        iwsKykmfkobetukmkensuu = pIwsKykmfkobetukmkensuu;
    }

    @Column(order = 15, length = 2)
    private String iwsMosfkobetukmkensuu;

    public String getIwsMosfkobetukmkensuu() {
        return iwsMosfkobetukmkensuu;
    }

    public void setIwsMosfkobetukmkensuu(String pIwsMosfkobetukmkensuu) {
        iwsMosfkobetukmkensuu = pIwsMosfkobetukmkensuu;
    }

    @Column(order = 16, length = 2)
    private String iwsSntkinfofkobetukmkensuu;

    public String getIwsSntkinfofkobetukmkensuu() {
        return iwsSntkinfofkobetukmkensuu;
    }

    public void setIwsSntkinfofkobetukmkensuu(String pIwsSntkinfofkobetukmkensuu) {
        iwsSntkinfofkobetukmkensuu = pIwsSntkinfofkobetukmkensuu;
    }

    @Column(order = 17, length = 2)
    private String iwsSueokifkobetukmkensuu;

    public String getIwsSueokifkobetukmkensuu() {
        return iwsSueokifkobetukmkensuu;
    }

    public void setIwsSueokifkobetukmkensuu(String pIwsSueokifkobetukmkensuu) {
        iwsSueokifkobetukmkensuu = pIwsSueokifkobetukmkensuu;
    }

    @Column(order = 18, length = 2)
    private String iwsNkfkobetukmkensuu;

    public String getIwsNkfkobetukmkensuu() {
        return iwsNkfkobetukmkensuu;
    }

    public void setIwsNkfkobetukmkensuu(String pIwsNkfkobetukmkensuu) {
        iwsNkfkobetukmkensuu = pIwsNkfkobetukmkensuu;
    }

    @Column(order = 19, length = 2)
    private String iwsKhkobetukmkensuu;

    public String getIwsKhkobetukmkensuu() {
        return iwsKhkobetukmkensuu;
    }

    public void setIwsKhkobetukmkensuu(String pIwsKhkobetukmkensuu) {
        iwsKhkobetukmkensuu = pIwsKhkobetukmkensuu;
    }

    @Column(order = 20, length = 2)
    private String iwsSkkobetukmkensuu;

    public String getIwsSkkobetukmkensuu() {
        return iwsSkkobetukmkensuu;
    }

    public void setIwsSkkobetukmkensuu(String pIwsSkkobetukmkensuu) {
        iwsSkkobetukmkensuu = pIwsSkkobetukmkensuu;
    }

    @Column(order = 21, length = 2)
    private String iwsNkshrkobetukmkensuu;

    public String getIwsNkshrkobetukmkensuu() {
        return iwsNkshrkobetukmkensuu;
    }

    public void setIwsNkshrkobetukmkensuu(String pIwsNkshrkobetukmkensuu) {
        iwsNkshrkobetukmkensuu = pIwsNkshrkobetukmkensuu;
    }

    @Column(order = 22, length = 1)
    private String iwsKykmfkensuutyoukahyj;

    public String getIwsKykmfkensuutyoukahyj() {
        return iwsKykmfkensuutyoukahyj;
    }

    public void setIwsKykmfkensuutyoukahyj(String pIwsKykmfkensuutyoukahyj) {
        iwsKykmfkensuutyoukahyj = pIwsKykmfkensuutyoukahyj;
    }

    @Column(order = 23, length = 1)
    private String iwsMosfkensuutyoukahyj;

    public String getIwsMosfkensuutyoukahyj() {
        return iwsMosfkensuutyoukahyj;
    }

    public void setIwsMosfkensuutyoukahyj(String pIwsMosfkensuutyoukahyj) {
        iwsMosfkensuutyoukahyj = pIwsMosfkensuutyoukahyj;
    }

    @Column(order = 24, length = 1)
    private String iwsSntkinfofkensuutyoukahyj;

    public String getIwsSntkinfofkensuutyoukahyj() {
        return iwsSntkinfofkensuutyoukahyj;
    }

    public void setIwsSntkinfofkensuutyoukahyj(String pIwsSntkinfofkensuutyoukahyj) {
        iwsSntkinfofkensuutyoukahyj = pIwsSntkinfofkensuutyoukahyj;
    }

    @Column(order = 25, length = 1)
    private String iwsSueokifkensuutyoukahyj;

    public String getIwsSueokifkensuutyoukahyj() {
        return iwsSueokifkensuutyoukahyj;
    }

    public void setIwsSueokifkensuutyoukahyj(String pIwsSueokifkensuutyoukahyj) {
        iwsSueokifkensuutyoukahyj = pIwsSueokifkensuutyoukahyj;
    }

    @Column(order = 26, length = 1)
    private String iwsNkfkensuutyoukahyj;

    public String getIwsNkfkensuutyoukahyj() {
        return iwsNkfkensuutyoukahyj;
    }

    public void setIwsNkfkensuutyoukahyj(String pIwsNkfkensuutyoukahyj) {
        iwsNkfkensuutyoukahyj = pIwsNkfkensuutyoukahyj;
    }

    @Column(order = 27, length = 1)
    private String iwsKhkensuutyoukahyj;

    public String getIwsKhkensuutyoukahyj() {
        return iwsKhkensuutyoukahyj;
    }

    public void setIwsKhkensuutyoukahyj(String pIwsKhkensuutyoukahyj) {
        iwsKhkensuutyoukahyj = pIwsKhkensuutyoukahyj;
    }

    @Column(order = 28, length = 1)
    private String iwsSkkensuutyoukahyj;

    public String getIwsSkkensuutyoukahyj() {
        return iwsSkkensuutyoukahyj;
    }

    public void setIwsSkkensuutyoukahyj(String pIwsSkkensuutyoukahyj) {
        iwsSkkensuutyoukahyj = pIwsSkkensuutyoukahyj;
    }

    @Column(order = 29, length = 1)
    private String iwsNkshrkensuutyoukahyj;

    public String getIwsNkshrkensuutyoukahyj() {
        return iwsNkshrkensuutyoukahyj;
    }

    public void setIwsNkshrkensuutyoukahyj(String pIwsNkshrkensuutyoukahyj) {
        iwsNkshrkensuutyoukahyj = pIwsNkshrkensuutyoukahyj;
    }

    @Column(order = 30, length = 11)
    private String iwsKykmfsyono1;

    public String getIwsKykmfsyono1() {
        return iwsKykmfsyono1;
    }

    public void setIwsKykmfsyono1(String pIwsKykmfsyono1) {
        iwsKykmfsyono1 = pIwsKykmfsyono1;
    }

    @Column(order = 31, length = 2)
    private String iwsKykmfkykmfsegkbn1;

    public String getIwsKykmfkykmfsegkbn1() {
        return iwsKykmfkykmfsegkbn1;
    }

    public void setIwsKykmfkykmfsegkbn1(String pIwsKykmfkykmfsegkbn1) {
        iwsKykmfkykmfsegkbn1 = pIwsKykmfkykmfsegkbn1;
    }

    @Column(order = 32, length = 2)
    private String iwsKykmfkykmfkojinkbn1;

    public String getIwsKykmfkykmfkojinkbn1() {
        return iwsKykmfkykmfkojinkbn1;
    }

    public void setIwsKykmfkykmfkojinkbn1(String pIwsKykmfkykmfkojinkbn1) {
        iwsKykmfkykmfkojinkbn1 = pIwsKykmfkykmfkojinkbn1;
    }

    @Column(order = 33, length = 1)
    private String iwsKykmfkykjyoutaikbn1;

    public String getIwsKykmfkykjyoutaikbn1() {
        return iwsKykmfkykjyoutaikbn1;
    }

    public void setIwsKykmfkykjyoutaikbn1(String pIwsKykmfkykjyoutaikbn1) {
        iwsKykmfkykjyoutaikbn1 = pIwsKykmfkykjyoutaikbn1;
    }

    @Column(order = 34, length = 8)
    private String iwsKykmfkykymd1;

    public String getIwsKykmfkykymd1() {
        return iwsKykmfkykymd1;
    }

    public void setIwsKykmfkykymd1(String pIwsKykmfkykymd1) {
        iwsKykmfkykymd1 = pIwsKykmfkykymd1;
    }

    @Column(order = 35, length = 4)
    private String iwsKykmfsyoumetucd1;

    public String getIwsKykmfsyoumetucd1() {
        return iwsKykmfsyoumetucd1;
    }

    public void setIwsKykmfsyoumetucd1(String pIwsKykmfsyoumetucd1) {
        iwsKykmfsyoumetucd1 = pIwsKykmfsyoumetucd1;
    }

    @Column(order = 36, length = 8)
    private String iwsKykmfsyoumetuymd1;

    public String getIwsKykmfsyoumetuymd1() {
        return iwsKykmfsyoumetuymd1;
    }

    public void setIwsKykmfsyoumetuymd1(String pIwsKykmfsyoumetuymd1) {
        iwsKykmfsyoumetuymd1 = pIwsKykmfsyoumetuymd1;
    }

    @Column(order = 37, length = 6)
    private String iwsKykmfbosyuuym1;

    public String getIwsKykmfbosyuuym1() {
        return iwsKykmfbosyuuym1;
    }

    public void setIwsKykmfbosyuuym1(String pIwsKykmfbosyuuym1) {
        iwsKykmfbosyuuym1 = pIwsKykmfbosyuuym1;
    }

    @Column(order = 38, length = 8)
    private String iwsKykmftaisyouseiymd1;

    public String getIwsKykmftaisyouseiymd1() {
        return iwsKykmftaisyouseiymd1;
    }

    public void setIwsKykmftaisyouseiymd1(String pIwsKykmftaisyouseiymd1) {
        iwsKykmftaisyouseiymd1 = pIwsKykmftaisyouseiymd1;
    }

    @Column(order = 39, length = 11)
    private String iwsKykmfsyono2;

    public String getIwsKykmfsyono2() {
        return iwsKykmfsyono2;
    }

    public void setIwsKykmfsyono2(String pIwsKykmfsyono2) {
        iwsKykmfsyono2 = pIwsKykmfsyono2;
    }

    @Column(order = 40, length = 2)
    private String iwsKykmfkykmfsegkbn2;

    public String getIwsKykmfkykmfsegkbn2() {
        return iwsKykmfkykmfsegkbn2;
    }

    public void setIwsKykmfkykmfsegkbn2(String pIwsKykmfkykmfsegkbn2) {
        iwsKykmfkykmfsegkbn2 = pIwsKykmfkykmfsegkbn2;
    }

    @Column(order = 41, length = 2)
    private String iwsKykmfkykmfkojinkbn2;

    public String getIwsKykmfkykmfkojinkbn2() {
        return iwsKykmfkykmfkojinkbn2;
    }

    public void setIwsKykmfkykmfkojinkbn2(String pIwsKykmfkykmfkojinkbn2) {
        iwsKykmfkykmfkojinkbn2 = pIwsKykmfkykmfkojinkbn2;
    }

    @Column(order = 42, length = 1)
    private String iwsKykmfkykjyoutaikbn2;

    public String getIwsKykmfkykjyoutaikbn2() {
        return iwsKykmfkykjyoutaikbn2;
    }

    public void setIwsKykmfkykjyoutaikbn2(String pIwsKykmfkykjyoutaikbn2) {
        iwsKykmfkykjyoutaikbn2 = pIwsKykmfkykjyoutaikbn2;
    }

    @Column(order = 43, length = 8)
    private String iwsKykmfkykymd2;

    public String getIwsKykmfkykymd2() {
        return iwsKykmfkykymd2;
    }

    public void setIwsKykmfkykymd2(String pIwsKykmfkykymd2) {
        iwsKykmfkykymd2 = pIwsKykmfkykymd2;
    }

    @Column(order = 44, length = 4)
    private String iwsKykmfsyoumetucd2;

    public String getIwsKykmfsyoumetucd2() {
        return iwsKykmfsyoumetucd2;
    }

    public void setIwsKykmfsyoumetucd2(String pIwsKykmfsyoumetucd2) {
        iwsKykmfsyoumetucd2 = pIwsKykmfsyoumetucd2;
    }

    @Column(order = 45, length = 8)
    private String iwsKykmfsyoumetuymd2;

    public String getIwsKykmfsyoumetuymd2() {
        return iwsKykmfsyoumetuymd2;
    }

    public void setIwsKykmfsyoumetuymd2(String pIwsKykmfsyoumetuymd2) {
        iwsKykmfsyoumetuymd2 = pIwsKykmfsyoumetuymd2;
    }

    @Column(order = 46, length = 6)
    private String iwsKykmfbosyuuym2;

    public String getIwsKykmfbosyuuym2() {
        return iwsKykmfbosyuuym2;
    }

    public void setIwsKykmfbosyuuym2(String pIwsKykmfbosyuuym2) {
        iwsKykmfbosyuuym2 = pIwsKykmfbosyuuym2;
    }

    @Column(order = 47, length = 8)
    private String iwsKykmftaisyouseiymd2;

    public String getIwsKykmftaisyouseiymd2() {
        return iwsKykmftaisyouseiymd2;
    }

    public void setIwsKykmftaisyouseiymd2(String pIwsKykmftaisyouseiymd2) {
        iwsKykmftaisyouseiymd2 = pIwsKykmftaisyouseiymd2;
    }

    @Column(order = 48, length = 11)
    private String iwsKykmfsyono3;

    public String getIwsKykmfsyono3() {
        return iwsKykmfsyono3;
    }

    public void setIwsKykmfsyono3(String pIwsKykmfsyono3) {
        iwsKykmfsyono3 = pIwsKykmfsyono3;
    }

    @Column(order = 49, length = 2)
    private String iwsKykmfkykmfsegkbn3;

    public String getIwsKykmfkykmfsegkbn3() {
        return iwsKykmfkykmfsegkbn3;
    }

    public void setIwsKykmfkykmfsegkbn3(String pIwsKykmfkykmfsegkbn3) {
        iwsKykmfkykmfsegkbn3 = pIwsKykmfkykmfsegkbn3;
    }

    @Column(order = 50, length = 2)
    private String iwsKykmfkykmfkojinkbn3;

    public String getIwsKykmfkykmfkojinkbn3() {
        return iwsKykmfkykmfkojinkbn3;
    }

    public void setIwsKykmfkykmfkojinkbn3(String pIwsKykmfkykmfkojinkbn3) {
        iwsKykmfkykmfkojinkbn3 = pIwsKykmfkykmfkojinkbn3;
    }

    @Column(order = 51, length = 1)
    private String iwsKykmfkykjyoutaikbn3;

    public String getIwsKykmfkykjyoutaikbn3() {
        return iwsKykmfkykjyoutaikbn3;
    }

    public void setIwsKykmfkykjyoutaikbn3(String pIwsKykmfkykjyoutaikbn3) {
        iwsKykmfkykjyoutaikbn3 = pIwsKykmfkykjyoutaikbn3;
    }

    @Column(order = 52, length = 8)
    private String iwsKykmfkykymd3;

    public String getIwsKykmfkykymd3() {
        return iwsKykmfkykymd3;
    }

    public void setIwsKykmfkykymd3(String pIwsKykmfkykymd3) {
        iwsKykmfkykymd3 = pIwsKykmfkykymd3;
    }

    @Column(order = 53, length = 4)
    private String iwsKykmfsyoumetucd3;

    public String getIwsKykmfsyoumetucd3() {
        return iwsKykmfsyoumetucd3;
    }

    public void setIwsKykmfsyoumetucd3(String pIwsKykmfsyoumetucd3) {
        iwsKykmfsyoumetucd3 = pIwsKykmfsyoumetucd3;
    }

    @Column(order = 54, length = 8)
    private String iwsKykmfsyoumetuymd3;

    public String getIwsKykmfsyoumetuymd3() {
        return iwsKykmfsyoumetuymd3;
    }

    public void setIwsKykmfsyoumetuymd3(String pIwsKykmfsyoumetuymd3) {
        iwsKykmfsyoumetuymd3 = pIwsKykmfsyoumetuymd3;
    }

    @Column(order = 55, length = 6)
    private String iwsKykmfbosyuuym3;

    public String getIwsKykmfbosyuuym3() {
        return iwsKykmfbosyuuym3;
    }

    public void setIwsKykmfbosyuuym3(String pIwsKykmfbosyuuym3) {
        iwsKykmfbosyuuym3 = pIwsKykmfbosyuuym3;
    }

    @Column(order = 56, length = 8)
    private String iwsKykmftaisyouseiymd3;

    public String getIwsKykmftaisyouseiymd3() {
        return iwsKykmftaisyouseiymd3;
    }

    public void setIwsKykmftaisyouseiymd3(String pIwsKykmftaisyouseiymd3) {
        iwsKykmftaisyouseiymd3 = pIwsKykmftaisyouseiymd3;
    }

    @Column(order = 57, length = 11)
    private String iwsKykmfsyono4;

    public String getIwsKykmfsyono4() {
        return iwsKykmfsyono4;
    }

    public void setIwsKykmfsyono4(String pIwsKykmfsyono4) {
        iwsKykmfsyono4 = pIwsKykmfsyono4;
    }

    @Column(order = 58, length = 2)
    private String iwsKykmfkykmfsegkbn4;

    public String getIwsKykmfkykmfsegkbn4() {
        return iwsKykmfkykmfsegkbn4;
    }

    public void setIwsKykmfkykmfsegkbn4(String pIwsKykmfkykmfsegkbn4) {
        iwsKykmfkykmfsegkbn4 = pIwsKykmfkykmfsegkbn4;
    }

    @Column(order = 59, length = 2)
    private String iwsKykmfkykmfkojinkbn4;

    public String getIwsKykmfkykmfkojinkbn4() {
        return iwsKykmfkykmfkojinkbn4;
    }

    public void setIwsKykmfkykmfkojinkbn4(String pIwsKykmfkykmfkojinkbn4) {
        iwsKykmfkykmfkojinkbn4 = pIwsKykmfkykmfkojinkbn4;
    }

    @Column(order = 60, length = 1)
    private String iwsKykmfkykjyoutaikbn4;

    public String getIwsKykmfkykjyoutaikbn4() {
        return iwsKykmfkykjyoutaikbn4;
    }

    public void setIwsKykmfkykjyoutaikbn4(String pIwsKykmfkykjyoutaikbn4) {
        iwsKykmfkykjyoutaikbn4 = pIwsKykmfkykjyoutaikbn4;
    }

    @Column(order = 61, length = 8)
    private String iwsKykmfkykymd4;

    public String getIwsKykmfkykymd4() {
        return iwsKykmfkykymd4;
    }

    public void setIwsKykmfkykymd4(String pIwsKykmfkykymd4) {
        iwsKykmfkykymd4 = pIwsKykmfkykymd4;
    }

    @Column(order = 62, length = 4)
    private String iwsKykmfsyoumetucd4;

    public String getIwsKykmfsyoumetucd4() {
        return iwsKykmfsyoumetucd4;
    }

    public void setIwsKykmfsyoumetucd4(String pIwsKykmfsyoumetucd4) {
        iwsKykmfsyoumetucd4 = pIwsKykmfsyoumetucd4;
    }

    @Column(order = 63, length = 8)
    private String iwsKykmfsyoumetuymd4;

    public String getIwsKykmfsyoumetuymd4() {
        return iwsKykmfsyoumetuymd4;
    }

    public void setIwsKykmfsyoumetuymd4(String pIwsKykmfsyoumetuymd4) {
        iwsKykmfsyoumetuymd4 = pIwsKykmfsyoumetuymd4;
    }

    @Column(order = 64, length = 6)
    private String iwsKykmfbosyuuym4;

    public String getIwsKykmfbosyuuym4() {
        return iwsKykmfbosyuuym4;
    }

    public void setIwsKykmfbosyuuym4(String pIwsKykmfbosyuuym4) {
        iwsKykmfbosyuuym4 = pIwsKykmfbosyuuym4;
    }

    @Column(order = 65, length = 8)
    private String iwsKykmftaisyouseiymd4;

    public String getIwsKykmftaisyouseiymd4() {
        return iwsKykmftaisyouseiymd4;
    }

    public void setIwsKykmftaisyouseiymd4(String pIwsKykmftaisyouseiymd4) {
        iwsKykmftaisyouseiymd4 = pIwsKykmftaisyouseiymd4;
    }

    @Column(order = 66, length = 11)
    private String iwsKykmfsyono5;

    public String getIwsKykmfsyono5() {
        return iwsKykmfsyono5;
    }

    public void setIwsKykmfsyono5(String pIwsKykmfsyono5) {
        iwsKykmfsyono5 = pIwsKykmfsyono5;
    }

    @Column(order = 67, length = 2)
    private String iwsKykmfkykmfsegkbn5;

    public String getIwsKykmfkykmfsegkbn5() {
        return iwsKykmfkykmfsegkbn5;
    }

    public void setIwsKykmfkykmfsegkbn5(String pIwsKykmfkykmfsegkbn5) {
        iwsKykmfkykmfsegkbn5 = pIwsKykmfkykmfsegkbn5;
    }

    @Column(order = 68, length = 2)
    private String iwsKykmfkykmfkojinkbn5;

    public String getIwsKykmfkykmfkojinkbn5() {
        return iwsKykmfkykmfkojinkbn5;
    }

    public void setIwsKykmfkykmfkojinkbn5(String pIwsKykmfkykmfkojinkbn5) {
        iwsKykmfkykmfkojinkbn5 = pIwsKykmfkykmfkojinkbn5;
    }

    @Column(order = 69, length = 1)
    private String iwsKykmfkykjyoutaikbn5;

    public String getIwsKykmfkykjyoutaikbn5() {
        return iwsKykmfkykjyoutaikbn5;
    }

    public void setIwsKykmfkykjyoutaikbn5(String pIwsKykmfkykjyoutaikbn5) {
        iwsKykmfkykjyoutaikbn5 = pIwsKykmfkykjyoutaikbn5;
    }

    @Column(order = 70, length = 8)
    private String iwsKykmfkykymd5;

    public String getIwsKykmfkykymd5() {
        return iwsKykmfkykymd5;
    }

    public void setIwsKykmfkykymd5(String pIwsKykmfkykymd5) {
        iwsKykmfkykymd5 = pIwsKykmfkykymd5;
    }

    @Column(order = 71, length = 4)
    private String iwsKykmfsyoumetucd5;

    public String getIwsKykmfsyoumetucd5() {
        return iwsKykmfsyoumetucd5;
    }

    public void setIwsKykmfsyoumetucd5(String pIwsKykmfsyoumetucd5) {
        iwsKykmfsyoumetucd5 = pIwsKykmfsyoumetucd5;
    }

    @Column(order = 72, length = 8)
    private String iwsKykmfsyoumetuymd5;

    public String getIwsKykmfsyoumetuymd5() {
        return iwsKykmfsyoumetuymd5;
    }

    public void setIwsKykmfsyoumetuymd5(String pIwsKykmfsyoumetuymd5) {
        iwsKykmfsyoumetuymd5 = pIwsKykmfsyoumetuymd5;
    }

    @Column(order = 73, length = 6)
    private String iwsKykmfbosyuuym5;

    public String getIwsKykmfbosyuuym5() {
        return iwsKykmfbosyuuym5;
    }

    public void setIwsKykmfbosyuuym5(String pIwsKykmfbosyuuym5) {
        iwsKykmfbosyuuym5 = pIwsKykmfbosyuuym5;
    }

    @Column(order = 74, length = 8)
    private String iwsKykmftaisyouseiymd5;

    public String getIwsKykmftaisyouseiymd5() {
        return iwsKykmftaisyouseiymd5;
    }

    public void setIwsKykmftaisyouseiymd5(String pIwsKykmftaisyouseiymd5) {
        iwsKykmftaisyouseiymd5 = pIwsKykmftaisyouseiymd5;
    }

    @Column(order = 75, length = 11)
    private String iwsKykmfsyono6;

    public String getIwsKykmfsyono6() {
        return iwsKykmfsyono6;
    }

    public void setIwsKykmfsyono6(String pIwsKykmfsyono6) {
        iwsKykmfsyono6 = pIwsKykmfsyono6;
    }

    @Column(order = 76, length = 2)
    private String iwsKykmfkykmfsegkbn6;

    public String getIwsKykmfkykmfsegkbn6() {
        return iwsKykmfkykmfsegkbn6;
    }

    public void setIwsKykmfkykmfsegkbn6(String pIwsKykmfkykmfsegkbn6) {
        iwsKykmfkykmfsegkbn6 = pIwsKykmfkykmfsegkbn6;
    }

    @Column(order = 77, length = 2)
    private String iwsKykmfkykmfkojinkbn6;

    public String getIwsKykmfkykmfkojinkbn6() {
        return iwsKykmfkykmfkojinkbn6;
    }

    public void setIwsKykmfkykmfkojinkbn6(String pIwsKykmfkykmfkojinkbn6) {
        iwsKykmfkykmfkojinkbn6 = pIwsKykmfkykmfkojinkbn6;
    }

    @Column(order = 78, length = 1)
    private String iwsKykmfkykjyoutaikbn6;

    public String getIwsKykmfkykjyoutaikbn6() {
        return iwsKykmfkykjyoutaikbn6;
    }

    public void setIwsKykmfkykjyoutaikbn6(String pIwsKykmfkykjyoutaikbn6) {
        iwsKykmfkykjyoutaikbn6 = pIwsKykmfkykjyoutaikbn6;
    }

    @Column(order = 79, length = 8)
    private String iwsKykmfkykymd6;

    public String getIwsKykmfkykymd6() {
        return iwsKykmfkykymd6;
    }

    public void setIwsKykmfkykymd6(String pIwsKykmfkykymd6) {
        iwsKykmfkykymd6 = pIwsKykmfkykymd6;
    }

    @Column(order = 80, length = 4)
    private String iwsKykmfsyoumetucd6;

    public String getIwsKykmfsyoumetucd6() {
        return iwsKykmfsyoumetucd6;
    }

    public void setIwsKykmfsyoumetucd6(String pIwsKykmfsyoumetucd6) {
        iwsKykmfsyoumetucd6 = pIwsKykmfsyoumetucd6;
    }

    @Column(order = 81, length = 8)
    private String iwsKykmfsyoumetuymd6;

    public String getIwsKykmfsyoumetuymd6() {
        return iwsKykmfsyoumetuymd6;
    }

    public void setIwsKykmfsyoumetuymd6(String pIwsKykmfsyoumetuymd6) {
        iwsKykmfsyoumetuymd6 = pIwsKykmfsyoumetuymd6;
    }

    @Column(order = 82, length = 6)
    private String iwsKykmfbosyuuym6;

    public String getIwsKykmfbosyuuym6() {
        return iwsKykmfbosyuuym6;
    }

    public void setIwsKykmfbosyuuym6(String pIwsKykmfbosyuuym6) {
        iwsKykmfbosyuuym6 = pIwsKykmfbosyuuym6;
    }

    @Column(order = 83, length = 8)
    private String iwsKykmftaisyouseiymd6;

    public String getIwsKykmftaisyouseiymd6() {
        return iwsKykmftaisyouseiymd6;
    }

    public void setIwsKykmftaisyouseiymd6(String pIwsKykmftaisyouseiymd6) {
        iwsKykmftaisyouseiymd6 = pIwsKykmftaisyouseiymd6;
    }

    @Column(order = 84, length = 11)
    private String iwsKykmfsyono7;

    public String getIwsKykmfsyono7() {
        return iwsKykmfsyono7;
    }

    public void setIwsKykmfsyono7(String pIwsKykmfsyono7) {
        iwsKykmfsyono7 = pIwsKykmfsyono7;
    }

    @Column(order = 85, length = 2)
    private String iwsKykmfkykmfsegkbn7;

    public String getIwsKykmfkykmfsegkbn7() {
        return iwsKykmfkykmfsegkbn7;
    }

    public void setIwsKykmfkykmfsegkbn7(String pIwsKykmfkykmfsegkbn7) {
        iwsKykmfkykmfsegkbn7 = pIwsKykmfkykmfsegkbn7;
    }

    @Column(order = 86, length = 2)
    private String iwsKykmfkykmfkojinkbn7;

    public String getIwsKykmfkykmfkojinkbn7() {
        return iwsKykmfkykmfkojinkbn7;
    }

    public void setIwsKykmfkykmfkojinkbn7(String pIwsKykmfkykmfkojinkbn7) {
        iwsKykmfkykmfkojinkbn7 = pIwsKykmfkykmfkojinkbn7;
    }

    @Column(order = 87, length = 1)
    private String iwsKykmfkykjyoutaikbn7;

    public String getIwsKykmfkykjyoutaikbn7() {
        return iwsKykmfkykjyoutaikbn7;
    }

    public void setIwsKykmfkykjyoutaikbn7(String pIwsKykmfkykjyoutaikbn7) {
        iwsKykmfkykjyoutaikbn7 = pIwsKykmfkykjyoutaikbn7;
    }

    @Column(order = 88, length = 8)
    private String iwsKykmfkykymd7;

    public String getIwsKykmfkykymd7() {
        return iwsKykmfkykymd7;
    }

    public void setIwsKykmfkykymd7(String pIwsKykmfkykymd7) {
        iwsKykmfkykymd7 = pIwsKykmfkykymd7;
    }

    @Column(order = 89, length = 4)
    private String iwsKykmfsyoumetucd7;

    public String getIwsKykmfsyoumetucd7() {
        return iwsKykmfsyoumetucd7;
    }

    public void setIwsKykmfsyoumetucd7(String pIwsKykmfsyoumetucd7) {
        iwsKykmfsyoumetucd7 = pIwsKykmfsyoumetucd7;
    }

    @Column(order = 90, length = 8)
    private String iwsKykmfsyoumetuymd7;

    public String getIwsKykmfsyoumetuymd7() {
        return iwsKykmfsyoumetuymd7;
    }

    public void setIwsKykmfsyoumetuymd7(String pIwsKykmfsyoumetuymd7) {
        iwsKykmfsyoumetuymd7 = pIwsKykmfsyoumetuymd7;
    }

    @Column(order = 91, length = 6)
    private String iwsKykmfbosyuuym7;

    public String getIwsKykmfbosyuuym7() {
        return iwsKykmfbosyuuym7;
    }

    public void setIwsKykmfbosyuuym7(String pIwsKykmfbosyuuym7) {
        iwsKykmfbosyuuym7 = pIwsKykmfbosyuuym7;
    }

    @Column(order = 92, length = 8)
    private String iwsKykmftaisyouseiymd7;

    public String getIwsKykmftaisyouseiymd7() {
        return iwsKykmftaisyouseiymd7;
    }

    public void setIwsKykmftaisyouseiymd7(String pIwsKykmftaisyouseiymd7) {
        iwsKykmftaisyouseiymd7 = pIwsKykmftaisyouseiymd7;
    }

    @Column(order = 93, length = 11)
    private String iwsKykmfsyono8;

    public String getIwsKykmfsyono8() {
        return iwsKykmfsyono8;
    }

    public void setIwsKykmfsyono8(String pIwsKykmfsyono8) {
        iwsKykmfsyono8 = pIwsKykmfsyono8;
    }

    @Column(order = 94, length = 2)
    private String iwsKykmfkykmfsegkbn8;

    public String getIwsKykmfkykmfsegkbn8() {
        return iwsKykmfkykmfsegkbn8;
    }

    public void setIwsKykmfkykmfsegkbn8(String pIwsKykmfkykmfsegkbn8) {
        iwsKykmfkykmfsegkbn8 = pIwsKykmfkykmfsegkbn8;
    }

    @Column(order = 95, length = 2)
    private String iwsKykmfkykmfkojinkbn8;

    public String getIwsKykmfkykmfkojinkbn8() {
        return iwsKykmfkykmfkojinkbn8;
    }

    public void setIwsKykmfkykmfkojinkbn8(String pIwsKykmfkykmfkojinkbn8) {
        iwsKykmfkykmfkojinkbn8 = pIwsKykmfkykmfkojinkbn8;
    }

    @Column(order = 96, length = 1)
    private String iwsKykmfkykjyoutaikbn8;

    public String getIwsKykmfkykjyoutaikbn8() {
        return iwsKykmfkykjyoutaikbn8;
    }

    public void setIwsKykmfkykjyoutaikbn8(String pIwsKykmfkykjyoutaikbn8) {
        iwsKykmfkykjyoutaikbn8 = pIwsKykmfkykjyoutaikbn8;
    }

    @Column(order = 97, length = 8)
    private String iwsKykmfkykymd8;

    public String getIwsKykmfkykymd8() {
        return iwsKykmfkykymd8;
    }

    public void setIwsKykmfkykymd8(String pIwsKykmfkykymd8) {
        iwsKykmfkykymd8 = pIwsKykmfkykymd8;
    }

    @Column(order = 98, length = 4)
    private String iwsKykmfsyoumetucd8;

    public String getIwsKykmfsyoumetucd8() {
        return iwsKykmfsyoumetucd8;
    }

    public void setIwsKykmfsyoumetucd8(String pIwsKykmfsyoumetucd8) {
        iwsKykmfsyoumetucd8 = pIwsKykmfsyoumetucd8;
    }

    @Column(order = 99, length = 8)
    private String iwsKykmfsyoumetuymd8;

    public String getIwsKykmfsyoumetuymd8() {
        return iwsKykmfsyoumetuymd8;
    }

    public void setIwsKykmfsyoumetuymd8(String pIwsKykmfsyoumetuymd8) {
        iwsKykmfsyoumetuymd8 = pIwsKykmfsyoumetuymd8;
    }

    @Column(order = 100, length = 6)
    private String iwsKykmfbosyuuym8;

    public String getIwsKykmfbosyuuym8() {
        return iwsKykmfbosyuuym8;
    }

    public void setIwsKykmfbosyuuym8(String pIwsKykmfbosyuuym8) {
        iwsKykmfbosyuuym8 = pIwsKykmfbosyuuym8;
    }

    @Column(order = 101, length = 8)
    private String iwsKykmftaisyouseiymd8;

    public String getIwsKykmftaisyouseiymd8() {
        return iwsKykmftaisyouseiymd8;
    }

    public void setIwsKykmftaisyouseiymd8(String pIwsKykmftaisyouseiymd8) {
        iwsKykmftaisyouseiymd8 = pIwsKykmftaisyouseiymd8;
    }

    @Column(order = 102, length = 11)
    private String iwsKykmfsyono9;

    public String getIwsKykmfsyono9() {
        return iwsKykmfsyono9;
    }

    public void setIwsKykmfsyono9(String pIwsKykmfsyono9) {
        iwsKykmfsyono9 = pIwsKykmfsyono9;
    }

    @Column(order = 103, length = 2)
    private String iwsKykmfkykmfsegkbn9;

    public String getIwsKykmfkykmfsegkbn9() {
        return iwsKykmfkykmfsegkbn9;
    }

    public void setIwsKykmfkykmfsegkbn9(String pIwsKykmfkykmfsegkbn9) {
        iwsKykmfkykmfsegkbn9 = pIwsKykmfkykmfsegkbn9;
    }

    @Column(order = 104, length = 2)
    private String iwsKykmfkykmfkojinkbn9;

    public String getIwsKykmfkykmfkojinkbn9() {
        return iwsKykmfkykmfkojinkbn9;
    }

    public void setIwsKykmfkykmfkojinkbn9(String pIwsKykmfkykmfkojinkbn9) {
        iwsKykmfkykmfkojinkbn9 = pIwsKykmfkykmfkojinkbn9;
    }

    @Column(order = 105, length = 1)
    private String iwsKykmfkykjyoutaikbn9;

    public String getIwsKykmfkykjyoutaikbn9() {
        return iwsKykmfkykjyoutaikbn9;
    }

    public void setIwsKykmfkykjyoutaikbn9(String pIwsKykmfkykjyoutaikbn9) {
        iwsKykmfkykjyoutaikbn9 = pIwsKykmfkykjyoutaikbn9;
    }

    @Column(order = 106, length = 8)
    private String iwsKykmfkykymd9;

    public String getIwsKykmfkykymd9() {
        return iwsKykmfkykymd9;
    }

    public void setIwsKykmfkykymd9(String pIwsKykmfkykymd9) {
        iwsKykmfkykymd9 = pIwsKykmfkykymd9;
    }

    @Column(order = 107, length = 4)
    private String iwsKykmfsyoumetucd9;

    public String getIwsKykmfsyoumetucd9() {
        return iwsKykmfsyoumetucd9;
    }

    public void setIwsKykmfsyoumetucd9(String pIwsKykmfsyoumetucd9) {
        iwsKykmfsyoumetucd9 = pIwsKykmfsyoumetucd9;
    }

    @Column(order = 108, length = 8)
    private String iwsKykmfsyoumetuymd9;

    public String getIwsKykmfsyoumetuymd9() {
        return iwsKykmfsyoumetuymd9;
    }

    public void setIwsKykmfsyoumetuymd9(String pIwsKykmfsyoumetuymd9) {
        iwsKykmfsyoumetuymd9 = pIwsKykmfsyoumetuymd9;
    }

    @Column(order = 109, length = 6)
    private String iwsKykmfbosyuuym9;

    public String getIwsKykmfbosyuuym9() {
        return iwsKykmfbosyuuym9;
    }

    public void setIwsKykmfbosyuuym9(String pIwsKykmfbosyuuym9) {
        iwsKykmfbosyuuym9 = pIwsKykmfbosyuuym9;
    }

    @Column(order = 110, length = 8)
    private String iwsKykmftaisyouseiymd9;

    public String getIwsKykmftaisyouseiymd9() {
        return iwsKykmftaisyouseiymd9;
    }

    public void setIwsKykmftaisyouseiymd9(String pIwsKykmftaisyouseiymd9) {
        iwsKykmftaisyouseiymd9 = pIwsKykmftaisyouseiymd9;
    }

    @Column(order = 111, length = 11)
    private String iwsKykmfsyono10;

    public String getIwsKykmfsyono10() {
        return iwsKykmfsyono10;
    }

    public void setIwsKykmfsyono10(String pIwsKykmfsyono10) {
        iwsKykmfsyono10 = pIwsKykmfsyono10;
    }

    @Column(order = 112, length = 2)
    private String iwsKykmfkykmfsegkbn10;

    public String getIwsKykmfkykmfsegkbn10() {
        return iwsKykmfkykmfsegkbn10;
    }

    public void setIwsKykmfkykmfsegkbn10(String pIwsKykmfkykmfsegkbn10) {
        iwsKykmfkykmfsegkbn10 = pIwsKykmfkykmfsegkbn10;
    }

    @Column(order = 113, length = 2)
    private String iwsKykmfkykmfkojinkbn10;

    public String getIwsKykmfkykmfkojinkbn10() {
        return iwsKykmfkykmfkojinkbn10;
    }

    public void setIwsKykmfkykmfkojinkbn10(String pIwsKykmfkykmfkojinkbn10) {
        iwsKykmfkykmfkojinkbn10 = pIwsKykmfkykmfkojinkbn10;
    }

    @Column(order = 114, length = 1)
    private String iwsKykmfkykjyoutaikbn10;

    public String getIwsKykmfkykjyoutaikbn10() {
        return iwsKykmfkykjyoutaikbn10;
    }

    public void setIwsKykmfkykjyoutaikbn10(String pIwsKykmfkykjyoutaikbn10) {
        iwsKykmfkykjyoutaikbn10 = pIwsKykmfkykjyoutaikbn10;
    }

    @Column(order = 115, length = 8)
    private String iwsKykmfkykymd10;

    public String getIwsKykmfkykymd10() {
        return iwsKykmfkykymd10;
    }

    public void setIwsKykmfkykymd10(String pIwsKykmfkykymd10) {
        iwsKykmfkykymd10 = pIwsKykmfkykymd10;
    }

    @Column(order = 116, length = 4)
    private String iwsKykmfsyoumetucd10;

    public String getIwsKykmfsyoumetucd10() {
        return iwsKykmfsyoumetucd10;
    }

    public void setIwsKykmfsyoumetucd10(String pIwsKykmfsyoumetucd10) {
        iwsKykmfsyoumetucd10 = pIwsKykmfsyoumetucd10;
    }

    @Column(order = 117, length = 8)
    private String iwsKykmfsyoumetuymd10;

    public String getIwsKykmfsyoumetuymd10() {
        return iwsKykmfsyoumetuymd10;
    }

    public void setIwsKykmfsyoumetuymd10(String pIwsKykmfsyoumetuymd10) {
        iwsKykmfsyoumetuymd10 = pIwsKykmfsyoumetuymd10;
    }

    @Column(order = 118, length = 6)
    private String iwsKykmfbosyuuym10;

    public String getIwsKykmfbosyuuym10() {
        return iwsKykmfbosyuuym10;
    }

    public void setIwsKykmfbosyuuym10(String pIwsKykmfbosyuuym10) {
        iwsKykmfbosyuuym10 = pIwsKykmfbosyuuym10;
    }

    @Column(order = 119, length = 8)
    private String iwsKykmftaisyouseiymd10;

    public String getIwsKykmftaisyouseiymd10() {
        return iwsKykmftaisyouseiymd10;
    }

    public void setIwsKykmftaisyouseiymd10(String pIwsKykmftaisyouseiymd10) {
        iwsKykmftaisyouseiymd10 = pIwsKykmftaisyouseiymd10;
    }

    @Column(order = 120, length = 9)
    private String iwsMosfmosno1;

    public String getIwsMosfmosno1() {
        return iwsMosfmosno1;
    }

    public void setIwsMosfmosno1(String pIwsMosfmosno1) {
        iwsMosfmosno1 = pIwsMosfmosno1;
    }

    @Column(order = 121, length = 2)
    private String iwsMosfmosfsegkbn1;

    public String getIwsMosfmosfsegkbn1() {
        return iwsMosfmosfsegkbn1;
    }

    public void setIwsMosfmosfsegkbn1(String pIwsMosfmosfsegkbn1) {
        iwsMosfmosfsegkbn1 = pIwsMosfmosfsegkbn1;
    }

    @Column(order = 122, length = 2)
    private String iwsMosfmofkojinkbn1;

    public String getIwsMosfmofkojinkbn1() {
        return iwsMosfmofkojinkbn1;
    }

    public void setIwsMosfmofkojinkbn1(String pIwsMosfmofkojinkbn1) {
        iwsMosfmofkojinkbn1 = pIwsMosfmofkojinkbn1;
    }

    @Column(order = 123, length = 1)
    private String iwsMosfkykmfsakuseizmhyj1;

    public String getIwsMosfkykmfsakuseizmhyj1() {
        return iwsMosfkykmfsakuseizmhyj1;
    }

    public void setIwsMosfkykmfsakuseizmhyj1(String pIwsMosfkykmfsakuseizmhyj1) {
        iwsMosfkykmfsakuseizmhyj1 = pIwsMosfkykmfsakuseizmhyj1;
    }

    @Column(order = 124, length = 8)
    private String iwsMosfmosymd1;

    public String getIwsMosfmosymd1() {
        return iwsMosfmosymd1;
    }

    public void setIwsMosfmosymd1(String pIwsMosfmosymd1) {
        iwsMosfmosymd1 = pIwsMosfmosymd1;
    }

    @Column(order = 125, length = 8)
    private String iwsMosfkykymd1;

    public String getIwsMosfkykymd1() {
        return iwsMosfkykymd1;
    }

    public void setIwsMosfkykymd1(String pIwsMosfkykymd1) {
        iwsMosfkykymd1 = pIwsMosfkykymd1;
    }

    @Column(order = 126, length = 1)
    private String iwsMosfmossyoumetukbn1;

    public String getIwsMosfmossyoumetukbn1() {
        return iwsMosfmossyoumetukbn1;
    }

    public void setIwsMosfmossyoumetukbn1(String pIwsMosfmossyoumetukbn1) {
        iwsMosfmossyoumetukbn1 = pIwsMosfmossyoumetukbn1;
    }

    @Column(order = 127, length = 8)
    private String iwsMosfmossyoumetukktymd1;

    public String getIwsMosfmossyoumetukktymd1() {
        return iwsMosfmossyoumetukktymd1;
    }

    public void setIwsMosfmossyoumetukktymd1(String pIwsMosfmossyoumetukktymd1) {
        iwsMosfmossyoumetukktymd1 = pIwsMosfmossyoumetukktymd1;
    }

    @Column(order = 128, length = 6)
    private String iwsMosfbosyuuym1;

    public String getIwsMosfbosyuuym1() {
        return iwsMosfbosyuuym1;
    }

    public void setIwsMosfbosyuuym1(String pIwsMosfbosyuuym1) {
        iwsMosfbosyuuym1 = pIwsMosfbosyuuym1;
    }

    @Column(order = 129, length = 8)
    private String iwsMosftaisyouseiymd1;

    public String getIwsMosftaisyouseiymd1() {
        return iwsMosftaisyouseiymd1;
    }

    public void setIwsMosftaisyouseiymd1(String pIwsMosftaisyouseiymd1) {
        iwsMosftaisyouseiymd1 = pIwsMosftaisyouseiymd1;
    }

    @Column(order = 130, length = 9)
    private String iwsMosfmosno2;

    public String getIwsMosfmosno2() {
        return iwsMosfmosno2;
    }

    public void setIwsMosfmosno2(String pIwsMosfmosno2) {
        iwsMosfmosno2 = pIwsMosfmosno2;
    }

    @Column(order = 131, length = 2)
    private String iwsMosfmosfsegkbn2;

    public String getIwsMosfmosfsegkbn2() {
        return iwsMosfmosfsegkbn2;
    }

    public void setIwsMosfmosfsegkbn2(String pIwsMosfmosfsegkbn2) {
        iwsMosfmosfsegkbn2 = pIwsMosfmosfsegkbn2;
    }

    @Column(order = 132, length = 2)
    private String iwsMosfmofkojinkbn2;

    public String getIwsMosfmofkojinkbn2() {
        return iwsMosfmofkojinkbn2;
    }

    public void setIwsMosfmofkojinkbn2(String pIwsMosfmofkojinkbn2) {
        iwsMosfmofkojinkbn2 = pIwsMosfmofkojinkbn2;
    }

    @Column(order = 133, length = 1)
    private String iwsMosfkykmfsakuseizmhyj2;

    public String getIwsMosfkykmfsakuseizmhyj2() {
        return iwsMosfkykmfsakuseizmhyj2;
    }

    public void setIwsMosfkykmfsakuseizmhyj2(String pIwsMosfkykmfsakuseizmhyj2) {
        iwsMosfkykmfsakuseizmhyj2 = pIwsMosfkykmfsakuseizmhyj2;
    }

    @Column(order = 134, length = 8)
    private String iwsMosfmosymd2;

    public String getIwsMosfmosymd2() {
        return iwsMosfmosymd2;
    }

    public void setIwsMosfmosymd2(String pIwsMosfmosymd2) {
        iwsMosfmosymd2 = pIwsMosfmosymd2;
    }

    @Column(order = 135, length = 8)
    private String iwsMosfkykymd2;

    public String getIwsMosfkykymd2() {
        return iwsMosfkykymd2;
    }

    public void setIwsMosfkykymd2(String pIwsMosfkykymd2) {
        iwsMosfkykymd2 = pIwsMosfkykymd2;
    }

    @Column(order = 136, length = 1)
    private String iwsMosfmossyoumetukbn2;

    public String getIwsMosfmossyoumetukbn2() {
        return iwsMosfmossyoumetukbn2;
    }

    public void setIwsMosfmossyoumetukbn2(String pIwsMosfmossyoumetukbn2) {
        iwsMosfmossyoumetukbn2 = pIwsMosfmossyoumetukbn2;
    }

    @Column(order = 137, length = 8)
    private String iwsMosfmossyoumetukktymd2;

    public String getIwsMosfmossyoumetukktymd2() {
        return iwsMosfmossyoumetukktymd2;
    }

    public void setIwsMosfmossyoumetukktymd2(String pIwsMosfmossyoumetukktymd2) {
        iwsMosfmossyoumetukktymd2 = pIwsMosfmossyoumetukktymd2;
    }

    @Column(order = 138, length = 6)
    private String iwsMosfbosyuuym2;

    public String getIwsMosfbosyuuym2() {
        return iwsMosfbosyuuym2;
    }

    public void setIwsMosfbosyuuym2(String pIwsMosfbosyuuym2) {
        iwsMosfbosyuuym2 = pIwsMosfbosyuuym2;
    }

    @Column(order = 139, length = 8)
    private String iwsMosftaisyouseiymd2;

    public String getIwsMosftaisyouseiymd2() {
        return iwsMosftaisyouseiymd2;
    }

    public void setIwsMosftaisyouseiymd2(String pIwsMosftaisyouseiymd2) {
        iwsMosftaisyouseiymd2 = pIwsMosftaisyouseiymd2;
    }

    @Column(order = 140, length = 9)
    private String iwsMosfmosno3;

    public String getIwsMosfmosno3() {
        return iwsMosfmosno3;
    }

    public void setIwsMosfmosno3(String pIwsMosfmosno3) {
        iwsMosfmosno3 = pIwsMosfmosno3;
    }

    @Column(order = 141, length = 2)
    private String iwsMosfmosfsegkbn3;

    public String getIwsMosfmosfsegkbn3() {
        return iwsMosfmosfsegkbn3;
    }

    public void setIwsMosfmosfsegkbn3(String pIwsMosfmosfsegkbn3) {
        iwsMosfmosfsegkbn3 = pIwsMosfmosfsegkbn3;
    }

    @Column(order = 142, length = 2)
    private String iwsMosfmofkojinkbn3;

    public String getIwsMosfmofkojinkbn3() {
        return iwsMosfmofkojinkbn3;
    }

    public void setIwsMosfmofkojinkbn3(String pIwsMosfmofkojinkbn3) {
        iwsMosfmofkojinkbn3 = pIwsMosfmofkojinkbn3;
    }

    @Column(order = 143, length = 1)
    private String iwsMosfkykmfsakuseizmhyj3;

    public String getIwsMosfkykmfsakuseizmhyj3() {
        return iwsMosfkykmfsakuseizmhyj3;
    }

    public void setIwsMosfkykmfsakuseizmhyj3(String pIwsMosfkykmfsakuseizmhyj3) {
        iwsMosfkykmfsakuseizmhyj3 = pIwsMosfkykmfsakuseizmhyj3;
    }

    @Column(order = 144, length = 8)
    private String iwsMosfmosymd3;

    public String getIwsMosfmosymd3() {
        return iwsMosfmosymd3;
    }

    public void setIwsMosfmosymd3(String pIwsMosfmosymd3) {
        iwsMosfmosymd3 = pIwsMosfmosymd3;
    }

    @Column(order = 145, length = 8)
    private String iwsMosfkykymd3;

    public String getIwsMosfkykymd3() {
        return iwsMosfkykymd3;
    }

    public void setIwsMosfkykymd3(String pIwsMosfkykymd3) {
        iwsMosfkykymd3 = pIwsMosfkykymd3;
    }

    @Column(order = 146, length = 1)
    private String iwsMosfmossyoumetukbn3;

    public String getIwsMosfmossyoumetukbn3() {
        return iwsMosfmossyoumetukbn3;
    }

    public void setIwsMosfmossyoumetukbn3(String pIwsMosfmossyoumetukbn3) {
        iwsMosfmossyoumetukbn3 = pIwsMosfmossyoumetukbn3;
    }

    @Column(order = 147, length = 8)
    private String iwsMosfmossyoumetukktymd3;

    public String getIwsMosfmossyoumetukktymd3() {
        return iwsMosfmossyoumetukktymd3;
    }

    public void setIwsMosfmossyoumetukktymd3(String pIwsMosfmossyoumetukktymd3) {
        iwsMosfmossyoumetukktymd3 = pIwsMosfmossyoumetukktymd3;
    }

    @Column(order = 148, length = 6)
    private String iwsMosfbosyuuym3;

    public String getIwsMosfbosyuuym3() {
        return iwsMosfbosyuuym3;
    }

    public void setIwsMosfbosyuuym3(String pIwsMosfbosyuuym3) {
        iwsMosfbosyuuym3 = pIwsMosfbosyuuym3;
    }

    @Column(order = 149, length = 8)
    private String iwsMosftaisyouseiymd3;

    public String getIwsMosftaisyouseiymd3() {
        return iwsMosftaisyouseiymd3;
    }

    public void setIwsMosftaisyouseiymd3(String pIwsMosftaisyouseiymd3) {
        iwsMosftaisyouseiymd3 = pIwsMosftaisyouseiymd3;
    }

    @Column(order = 150, length = 9)
    private String iwsMosfmosno4;

    public String getIwsMosfmosno4() {
        return iwsMosfmosno4;
    }

    public void setIwsMosfmosno4(String pIwsMosfmosno4) {
        iwsMosfmosno4 = pIwsMosfmosno4;
    }

    @Column(order = 151, length = 2)
    private String iwsMosfmosfsegkbn4;

    public String getIwsMosfmosfsegkbn4() {
        return iwsMosfmosfsegkbn4;
    }

    public void setIwsMosfmosfsegkbn4(String pIwsMosfmosfsegkbn4) {
        iwsMosfmosfsegkbn4 = pIwsMosfmosfsegkbn4;
    }

    @Column(order = 152, length = 2)
    private String iwsMosfmofkojinkbn4;

    public String getIwsMosfmofkojinkbn4() {
        return iwsMosfmofkojinkbn4;
    }

    public void setIwsMosfmofkojinkbn4(String pIwsMosfmofkojinkbn4) {
        iwsMosfmofkojinkbn4 = pIwsMosfmofkojinkbn4;
    }

    @Column(order = 153, length = 1)
    private String iwsMosfkykmfsakuseizmhyj4;

    public String getIwsMosfkykmfsakuseizmhyj4() {
        return iwsMosfkykmfsakuseizmhyj4;
    }

    public void setIwsMosfkykmfsakuseizmhyj4(String pIwsMosfkykmfsakuseizmhyj4) {
        iwsMosfkykmfsakuseizmhyj4 = pIwsMosfkykmfsakuseizmhyj4;
    }

    @Column(order = 154, length = 8)
    private String iwsMosfmosymd4;

    public String getIwsMosfmosymd4() {
        return iwsMosfmosymd4;
    }

    public void setIwsMosfmosymd4(String pIwsMosfmosymd4) {
        iwsMosfmosymd4 = pIwsMosfmosymd4;
    }

    @Column(order = 155, length = 8)
    private String iwsMosfkykymd4;

    public String getIwsMosfkykymd4() {
        return iwsMosfkykymd4;
    }

    public void setIwsMosfkykymd4(String pIwsMosfkykymd4) {
        iwsMosfkykymd4 = pIwsMosfkykymd4;
    }

    @Column(order = 156, length = 1)
    private String iwsMosfmossyoumetukbn4;

    public String getIwsMosfmossyoumetukbn4() {
        return iwsMosfmossyoumetukbn4;
    }

    public void setIwsMosfmossyoumetukbn4(String pIwsMosfmossyoumetukbn4) {
        iwsMosfmossyoumetukbn4 = pIwsMosfmossyoumetukbn4;
    }

    @Column(order = 157, length = 8)
    private String iwsMosfmossyoumetukktymd4;

    public String getIwsMosfmossyoumetukktymd4() {
        return iwsMosfmossyoumetukktymd4;
    }

    public void setIwsMosfmossyoumetukktymd4(String pIwsMosfmossyoumetukktymd4) {
        iwsMosfmossyoumetukktymd4 = pIwsMosfmossyoumetukktymd4;
    }

    @Column(order = 158, length = 6)
    private String iwsMosfbosyuuym4;

    public String getIwsMosfbosyuuym4() {
        return iwsMosfbosyuuym4;
    }

    public void setIwsMosfbosyuuym4(String pIwsMosfbosyuuym4) {
        iwsMosfbosyuuym4 = pIwsMosfbosyuuym4;
    }

    @Column(order = 159, length = 8)
    private String iwsMosftaisyouseiymd4;

    public String getIwsMosftaisyouseiymd4() {
        return iwsMosftaisyouseiymd4;
    }

    public void setIwsMosftaisyouseiymd4(String pIwsMosftaisyouseiymd4) {
        iwsMosftaisyouseiymd4 = pIwsMosftaisyouseiymd4;
    }

    @Column(order = 160, length = 9)
    private String iwsMosfmosno5;

    public String getIwsMosfmosno5() {
        return iwsMosfmosno5;
    }

    public void setIwsMosfmosno5(String pIwsMosfmosno5) {
        iwsMosfmosno5 = pIwsMosfmosno5;
    }

    @Column(order = 161, length = 2)
    private String iwsMosfmosfsegkbn5;

    public String getIwsMosfmosfsegkbn5() {
        return iwsMosfmosfsegkbn5;
    }

    public void setIwsMosfmosfsegkbn5(String pIwsMosfmosfsegkbn5) {
        iwsMosfmosfsegkbn5 = pIwsMosfmosfsegkbn5;
    }

    @Column(order = 162, length = 2)
    private String iwsMosfmofkojinkbn5;

    public String getIwsMosfmofkojinkbn5() {
        return iwsMosfmofkojinkbn5;
    }

    public void setIwsMosfmofkojinkbn5(String pIwsMosfmofkojinkbn5) {
        iwsMosfmofkojinkbn5 = pIwsMosfmofkojinkbn5;
    }

    @Column(order = 163, length = 1)
    private String iwsMosfkykmfsakuseizmhyj5;

    public String getIwsMosfkykmfsakuseizmhyj5() {
        return iwsMosfkykmfsakuseizmhyj5;
    }

    public void setIwsMosfkykmfsakuseizmhyj5(String pIwsMosfkykmfsakuseizmhyj5) {
        iwsMosfkykmfsakuseizmhyj5 = pIwsMosfkykmfsakuseizmhyj5;
    }

    @Column(order = 164, length = 8)
    private String iwsMosfmosymd5;

    public String getIwsMosfmosymd5() {
        return iwsMosfmosymd5;
    }

    public void setIwsMosfmosymd5(String pIwsMosfmosymd5) {
        iwsMosfmosymd5 = pIwsMosfmosymd5;
    }

    @Column(order = 165, length = 8)
    private String iwsMosfkykymd5;

    public String getIwsMosfkykymd5() {
        return iwsMosfkykymd5;
    }

    public void setIwsMosfkykymd5(String pIwsMosfkykymd5) {
        iwsMosfkykymd5 = pIwsMosfkykymd5;
    }

    @Column(order = 166, length = 1)
    private String iwsMosfmossyoumetukbn5;

    public String getIwsMosfmossyoumetukbn5() {
        return iwsMosfmossyoumetukbn5;
    }

    public void setIwsMosfmossyoumetukbn5(String pIwsMosfmossyoumetukbn5) {
        iwsMosfmossyoumetukbn5 = pIwsMosfmossyoumetukbn5;
    }

    @Column(order = 167, length = 8)
    private String iwsMosfmossyoumetukktymd5;

    public String getIwsMosfmossyoumetukktymd5() {
        return iwsMosfmossyoumetukktymd5;
    }

    public void setIwsMosfmossyoumetukktymd5(String pIwsMosfmossyoumetukktymd5) {
        iwsMosfmossyoumetukktymd5 = pIwsMosfmossyoumetukktymd5;
    }

    @Column(order = 168, length = 6)
    private String iwsMosfbosyuuym5;

    public String getIwsMosfbosyuuym5() {
        return iwsMosfbosyuuym5;
    }

    public void setIwsMosfbosyuuym5(String pIwsMosfbosyuuym5) {
        iwsMosfbosyuuym5 = pIwsMosfbosyuuym5;
    }

    @Column(order = 169, length = 8)
    private String iwsMosftaisyouseiymd5;

    public String getIwsMosftaisyouseiymd5() {
        return iwsMosftaisyouseiymd5;
    }

    public void setIwsMosftaisyouseiymd5(String pIwsMosftaisyouseiymd5) {
        iwsMosftaisyouseiymd5 = pIwsMosftaisyouseiymd5;
    }

    @Column(order = 170, length = 9)
    private String iwsMosfmosno6;

    public String getIwsMosfmosno6() {
        return iwsMosfmosno6;
    }

    public void setIwsMosfmosno6(String pIwsMosfmosno6) {
        iwsMosfmosno6 = pIwsMosfmosno6;
    }

    @Column(order = 171, length = 2)
    private String iwsMosfmosfsegkbn6;

    public String getIwsMosfmosfsegkbn6() {
        return iwsMosfmosfsegkbn6;
    }

    public void setIwsMosfmosfsegkbn6(String pIwsMosfmosfsegkbn6) {
        iwsMosfmosfsegkbn6 = pIwsMosfmosfsegkbn6;
    }

    @Column(order = 172, length = 2)
    private String iwsMosfmofkojinkbn6;

    public String getIwsMosfmofkojinkbn6() {
        return iwsMosfmofkojinkbn6;
    }

    public void setIwsMosfmofkojinkbn6(String pIwsMosfmofkojinkbn6) {
        iwsMosfmofkojinkbn6 = pIwsMosfmofkojinkbn6;
    }

    @Column(order = 173, length = 1)
    private String iwsMosfkykmfsakuseizmhyj6;

    public String getIwsMosfkykmfsakuseizmhyj6() {
        return iwsMosfkykmfsakuseizmhyj6;
    }

    public void setIwsMosfkykmfsakuseizmhyj6(String pIwsMosfkykmfsakuseizmhyj6) {
        iwsMosfkykmfsakuseizmhyj6 = pIwsMosfkykmfsakuseizmhyj6;
    }

    @Column(order = 174, length = 8)
    private String iwsMosfmosymd6;

    public String getIwsMosfmosymd6() {
        return iwsMosfmosymd6;
    }

    public void setIwsMosfmosymd6(String pIwsMosfmosymd6) {
        iwsMosfmosymd6 = pIwsMosfmosymd6;
    }

    @Column(order = 175, length = 8)
    private String iwsMosfkykymd6;

    public String getIwsMosfkykymd6() {
        return iwsMosfkykymd6;
    }

    public void setIwsMosfkykymd6(String pIwsMosfkykymd6) {
        iwsMosfkykymd6 = pIwsMosfkykymd6;
    }

    @Column(order = 176, length = 1)
    private String iwsMosfmossyoumetukbn6;

    public String getIwsMosfmossyoumetukbn6() {
        return iwsMosfmossyoumetukbn6;
    }

    public void setIwsMosfmossyoumetukbn6(String pIwsMosfmossyoumetukbn6) {
        iwsMosfmossyoumetukbn6 = pIwsMosfmossyoumetukbn6;
    }

    @Column(order = 177, length = 8)
    private String iwsMosfmossyoumetukktymd6;

    public String getIwsMosfmossyoumetukktymd6() {
        return iwsMosfmossyoumetukktymd6;
    }

    public void setIwsMosfmossyoumetukktymd6(String pIwsMosfmossyoumetukktymd6) {
        iwsMosfmossyoumetukktymd6 = pIwsMosfmossyoumetukktymd6;
    }

    @Column(order = 178, length = 6)
    private String iwsMosfbosyuuym6;

    public String getIwsMosfbosyuuym6() {
        return iwsMosfbosyuuym6;
    }

    public void setIwsMosfbosyuuym6(String pIwsMosfbosyuuym6) {
        iwsMosfbosyuuym6 = pIwsMosfbosyuuym6;
    }

    @Column(order = 179, length = 8)
    private String iwsMosftaisyouseiymd6;

    public String getIwsMosftaisyouseiymd6() {
        return iwsMosftaisyouseiymd6;
    }

    public void setIwsMosftaisyouseiymd6(String pIwsMosftaisyouseiymd6) {
        iwsMosftaisyouseiymd6 = pIwsMosftaisyouseiymd6;
    }

    @Column(order = 180, length = 9)
    private String iwsMosfmosno7;

    public String getIwsMosfmosno7() {
        return iwsMosfmosno7;
    }

    public void setIwsMosfmosno7(String pIwsMosfmosno7) {
        iwsMosfmosno7 = pIwsMosfmosno7;
    }

    @Column(order = 181, length = 2)
    private String iwsMosfmosfsegkbn7;

    public String getIwsMosfmosfsegkbn7() {
        return iwsMosfmosfsegkbn7;
    }

    public void setIwsMosfmosfsegkbn7(String pIwsMosfmosfsegkbn7) {
        iwsMosfmosfsegkbn7 = pIwsMosfmosfsegkbn7;
    }

    @Column(order = 182, length = 2)
    private String iwsMosfmofkojinkbn7;

    public String getIwsMosfmofkojinkbn7() {
        return iwsMosfmofkojinkbn7;
    }

    public void setIwsMosfmofkojinkbn7(String pIwsMosfmofkojinkbn7) {
        iwsMosfmofkojinkbn7 = pIwsMosfmofkojinkbn7;
    }

    @Column(order = 183, length = 1)
    private String iwsMosfkykmfsakuseizmhyj7;

    public String getIwsMosfkykmfsakuseizmhyj7() {
        return iwsMosfkykmfsakuseizmhyj7;
    }

    public void setIwsMosfkykmfsakuseizmhyj7(String pIwsMosfkykmfsakuseizmhyj7) {
        iwsMosfkykmfsakuseizmhyj7 = pIwsMosfkykmfsakuseizmhyj7;
    }

    @Column(order = 184, length = 8)
    private String iwsMosfmosymd7;

    public String getIwsMosfmosymd7() {
        return iwsMosfmosymd7;
    }

    public void setIwsMosfmosymd7(String pIwsMosfmosymd7) {
        iwsMosfmosymd7 = pIwsMosfmosymd7;
    }

    @Column(order = 185, length = 8)
    private String iwsMosfkykymd7;

    public String getIwsMosfkykymd7() {
        return iwsMosfkykymd7;
    }

    public void setIwsMosfkykymd7(String pIwsMosfkykymd7) {
        iwsMosfkykymd7 = pIwsMosfkykymd7;
    }

    @Column(order = 186, length = 1)
    private String iwsMosfmossyoumetukbn7;

    public String getIwsMosfmossyoumetukbn7() {
        return iwsMosfmossyoumetukbn7;
    }

    public void setIwsMosfmossyoumetukbn7(String pIwsMosfmossyoumetukbn7) {
        iwsMosfmossyoumetukbn7 = pIwsMosfmossyoumetukbn7;
    }

    @Column(order = 187, length = 8)
    private String iwsMosfmossyoumetukktymd7;

    public String getIwsMosfmossyoumetukktymd7() {
        return iwsMosfmossyoumetukktymd7;
    }

    public void setIwsMosfmossyoumetukktymd7(String pIwsMosfmossyoumetukktymd7) {
        iwsMosfmossyoumetukktymd7 = pIwsMosfmossyoumetukktymd7;
    }

    @Column(order = 188, length = 6)
    private String iwsMosfbosyuuym7;

    public String getIwsMosfbosyuuym7() {
        return iwsMosfbosyuuym7;
    }

    public void setIwsMosfbosyuuym7(String pIwsMosfbosyuuym7) {
        iwsMosfbosyuuym7 = pIwsMosfbosyuuym7;
    }

    @Column(order = 189, length = 8)
    private String iwsMosftaisyouseiymd7;

    public String getIwsMosftaisyouseiymd7() {
        return iwsMosftaisyouseiymd7;
    }

    public void setIwsMosftaisyouseiymd7(String pIwsMosftaisyouseiymd7) {
        iwsMosftaisyouseiymd7 = pIwsMosftaisyouseiymd7;
    }

    @Column(order = 190, length = 9)
    private String iwsMosfmosno8;

    public String getIwsMosfmosno8() {
        return iwsMosfmosno8;
    }

    public void setIwsMosfmosno8(String pIwsMosfmosno8) {
        iwsMosfmosno8 = pIwsMosfmosno8;
    }

    @Column(order = 191, length = 2)
    private String iwsMosfmosfsegkbn8;

    public String getIwsMosfmosfsegkbn8() {
        return iwsMosfmosfsegkbn8;
    }

    public void setIwsMosfmosfsegkbn8(String pIwsMosfmosfsegkbn8) {
        iwsMosfmosfsegkbn8 = pIwsMosfmosfsegkbn8;
    }

    @Column(order = 192, length = 2)
    private String iwsMosfmofkojinkbn8;

    public String getIwsMosfmofkojinkbn8() {
        return iwsMosfmofkojinkbn8;
    }

    public void setIwsMosfmofkojinkbn8(String pIwsMosfmofkojinkbn8) {
        iwsMosfmofkojinkbn8 = pIwsMosfmofkojinkbn8;
    }

    @Column(order = 193, length = 1)
    private String iwsMosfkykmfsakuseizmhyj8;

    public String getIwsMosfkykmfsakuseizmhyj8() {
        return iwsMosfkykmfsakuseizmhyj8;
    }

    public void setIwsMosfkykmfsakuseizmhyj8(String pIwsMosfkykmfsakuseizmhyj8) {
        iwsMosfkykmfsakuseizmhyj8 = pIwsMosfkykmfsakuseizmhyj8;
    }

    @Column(order = 194, length = 8)
    private String iwsMosfmosymd8;

    public String getIwsMosfmosymd8() {
        return iwsMosfmosymd8;
    }

    public void setIwsMosfmosymd8(String pIwsMosfmosymd8) {
        iwsMosfmosymd8 = pIwsMosfmosymd8;
    }

    @Column(order = 195, length = 8)
    private String iwsMosfkykymd8;

    public String getIwsMosfkykymd8() {
        return iwsMosfkykymd8;
    }

    public void setIwsMosfkykymd8(String pIwsMosfkykymd8) {
        iwsMosfkykymd8 = pIwsMosfkykymd8;
    }

    @Column(order = 196, length = 1)
    private String iwsMosfmossyoumetukbn8;

    public String getIwsMosfmossyoumetukbn8() {
        return iwsMosfmossyoumetukbn8;
    }

    public void setIwsMosfmossyoumetukbn8(String pIwsMosfmossyoumetukbn8) {
        iwsMosfmossyoumetukbn8 = pIwsMosfmossyoumetukbn8;
    }

    @Column(order = 197, length = 8)
    private String iwsMosfmossyoumetukktymd8;

    public String getIwsMosfmossyoumetukktymd8() {
        return iwsMosfmossyoumetukktymd8;
    }

    public void setIwsMosfmossyoumetukktymd8(String pIwsMosfmossyoumetukktymd8) {
        iwsMosfmossyoumetukktymd8 = pIwsMosfmossyoumetukktymd8;
    }

    @Column(order = 198, length = 6)
    private String iwsMosfbosyuuym8;

    public String getIwsMosfbosyuuym8() {
        return iwsMosfbosyuuym8;
    }

    public void setIwsMosfbosyuuym8(String pIwsMosfbosyuuym8) {
        iwsMosfbosyuuym8 = pIwsMosfbosyuuym8;
    }

    @Column(order = 199, length = 8)
    private String iwsMosftaisyouseiymd8;

    public String getIwsMosftaisyouseiymd8() {
        return iwsMosftaisyouseiymd8;
    }

    public void setIwsMosftaisyouseiymd8(String pIwsMosftaisyouseiymd8) {
        iwsMosftaisyouseiymd8 = pIwsMosftaisyouseiymd8;
    }

    @Column(order = 200, length = 9)
    private String iwsMosfmosno9;

    public String getIwsMosfmosno9() {
        return iwsMosfmosno9;
    }

    public void setIwsMosfmosno9(String pIwsMosfmosno9) {
        iwsMosfmosno9 = pIwsMosfmosno9;
    }

    @Column(order = 201, length = 2)
    private String iwsMosfmosfsegkbn9;

    public String getIwsMosfmosfsegkbn9() {
        return iwsMosfmosfsegkbn9;
    }

    public void setIwsMosfmosfsegkbn9(String pIwsMosfmosfsegkbn9) {
        iwsMosfmosfsegkbn9 = pIwsMosfmosfsegkbn9;
    }

    @Column(order = 202, length = 2)
    private String iwsMosfmofkojinkbn9;

    public String getIwsMosfmofkojinkbn9() {
        return iwsMosfmofkojinkbn9;
    }

    public void setIwsMosfmofkojinkbn9(String pIwsMosfmofkojinkbn9) {
        iwsMosfmofkojinkbn9 = pIwsMosfmofkojinkbn9;
    }

    @Column(order = 203, length = 1)
    private String iwsMosfkykmfsakuseizmhyj9;

    public String getIwsMosfkykmfsakuseizmhyj9() {
        return iwsMosfkykmfsakuseizmhyj9;
    }

    public void setIwsMosfkykmfsakuseizmhyj9(String pIwsMosfkykmfsakuseizmhyj9) {
        iwsMosfkykmfsakuseizmhyj9 = pIwsMosfkykmfsakuseizmhyj9;
    }

    @Column(order = 204, length = 8)
    private String iwsMosfmosymd9;

    public String getIwsMosfmosymd9() {
        return iwsMosfmosymd9;
    }

    public void setIwsMosfmosymd9(String pIwsMosfmosymd9) {
        iwsMosfmosymd9 = pIwsMosfmosymd9;
    }

    @Column(order = 205, length = 8)
    private String iwsMosfkykymd9;

    public String getIwsMosfkykymd9() {
        return iwsMosfkykymd9;
    }

    public void setIwsMosfkykymd9(String pIwsMosfkykymd9) {
        iwsMosfkykymd9 = pIwsMosfkykymd9;
    }

    @Column(order = 206, length = 1)
    private String iwsMosfmossyoumetukbn9;

    public String getIwsMosfmossyoumetukbn9() {
        return iwsMosfmossyoumetukbn9;
    }

    public void setIwsMosfmossyoumetukbn9(String pIwsMosfmossyoumetukbn9) {
        iwsMosfmossyoumetukbn9 = pIwsMosfmossyoumetukbn9;
    }

    @Column(order = 207, length = 8)
    private String iwsMosfmossyoumetukktymd9;

    public String getIwsMosfmossyoumetukktymd9() {
        return iwsMosfmossyoumetukktymd9;
    }

    public void setIwsMosfmossyoumetukktymd9(String pIwsMosfmossyoumetukktymd9) {
        iwsMosfmossyoumetukktymd9 = pIwsMosfmossyoumetukktymd9;
    }

    @Column(order = 208, length = 6)
    private String iwsMosfbosyuuym9;

    public String getIwsMosfbosyuuym9() {
        return iwsMosfbosyuuym9;
    }

    public void setIwsMosfbosyuuym9(String pIwsMosfbosyuuym9) {
        iwsMosfbosyuuym9 = pIwsMosfbosyuuym9;
    }

    @Column(order = 209, length = 8)
    private String iwsMosftaisyouseiymd9;

    public String getIwsMosftaisyouseiymd9() {
        return iwsMosftaisyouseiymd9;
    }

    public void setIwsMosftaisyouseiymd9(String pIwsMosftaisyouseiymd9) {
        iwsMosftaisyouseiymd9 = pIwsMosftaisyouseiymd9;
    }

    @Column(order = 210, length = 9)
    private String iwsMosfmosno10;

    public String getIwsMosfmosno10() {
        return iwsMosfmosno10;
    }

    public void setIwsMosfmosno10(String pIwsMosfmosno10) {
        iwsMosfmosno10 = pIwsMosfmosno10;
    }

    @Column(order = 211, length = 2)
    private String iwsMosfmosfsegkbn10;

    public String getIwsMosfmosfsegkbn10() {
        return iwsMosfmosfsegkbn10;
    }

    public void setIwsMosfmosfsegkbn10(String pIwsMosfmosfsegkbn10) {
        iwsMosfmosfsegkbn10 = pIwsMosfmosfsegkbn10;
    }

    @Column(order = 212, length = 2)
    private String iwsMosfmofkojinkbn10;

    public String getIwsMosfmofkojinkbn10() {
        return iwsMosfmofkojinkbn10;
    }

    public void setIwsMosfmofkojinkbn10(String pIwsMosfmofkojinkbn10) {
        iwsMosfmofkojinkbn10 = pIwsMosfmofkojinkbn10;
    }

    @Column(order = 213, length = 1)
    private String iwsMosfkykmfsakuseizmhyj10;

    public String getIwsMosfkykmfsakuseizmhyj10() {
        return iwsMosfkykmfsakuseizmhyj10;
    }

    public void setIwsMosfkykmfsakuseizmhyj10(String pIwsMosfkykmfsakuseizmhyj10) {
        iwsMosfkykmfsakuseizmhyj10 = pIwsMosfkykmfsakuseizmhyj10;
    }

    @Column(order = 214, length = 8)
    private String iwsMosfmosymd10;

    public String getIwsMosfmosymd10() {
        return iwsMosfmosymd10;
    }

    public void setIwsMosfmosymd10(String pIwsMosfmosymd10) {
        iwsMosfmosymd10 = pIwsMosfmosymd10;
    }

    @Column(order = 215, length = 8)
    private String iwsMosfkykymd10;

    public String getIwsMosfkykymd10() {
        return iwsMosfkykymd10;
    }

    public void setIwsMosfkykymd10(String pIwsMosfkykymd10) {
        iwsMosfkykymd10 = pIwsMosfkykymd10;
    }

    @Column(order = 216, length = 1)
    private String iwsMosfmossyoumetukbn10;

    public String getIwsMosfmossyoumetukbn10() {
        return iwsMosfmossyoumetukbn10;
    }

    public void setIwsMosfmossyoumetukbn10(String pIwsMosfmossyoumetukbn10) {
        iwsMosfmossyoumetukbn10 = pIwsMosfmossyoumetukbn10;
    }

    @Column(order = 217, length = 8)
    private String iwsMosfmossyoumetukktymd10;

    public String getIwsMosfmossyoumetukktymd10() {
        return iwsMosfmossyoumetukktymd10;
    }

    public void setIwsMosfmossyoumetukktymd10(String pIwsMosfmossyoumetukktymd10) {
        iwsMosfmossyoumetukktymd10 = pIwsMosfmossyoumetukktymd10;
    }

    @Column(order = 218, length = 6)
    private String iwsMosfbosyuuym10;

    public String getIwsMosfbosyuuym10() {
        return iwsMosfbosyuuym10;
    }

    public void setIwsMosfbosyuuym10(String pIwsMosfbosyuuym10) {
        iwsMosfbosyuuym10 = pIwsMosfbosyuuym10;
    }

    @Column(order = 219, length = 8)
    private String iwsMosftaisyouseiymd10;

    public String getIwsMosftaisyouseiymd10() {
        return iwsMosftaisyouseiymd10;
    }

    public void setIwsMosftaisyouseiymd10(String pIwsMosftaisyouseiymd10) {
        iwsMosftaisyouseiymd10 = pIwsMosftaisyouseiymd10;
    }

    @Column(order = 220, length = 11)
    private String iwsSntkinfono1;

    public String getIwsSntkinfono1() {
        return iwsSntkinfono1;
    }

    public void setIwsSntkinfono1(String pIwsSntkinfono1) {
        iwsSntkinfono1 = pIwsSntkinfono1;
    }

    @Column(order = 221, length = 2)
    private String iwsSntkinfofsegkbn1;

    public String getIwsSntkinfofsegkbn1() {
        return iwsSntkinfofsegkbn1;
    }

    public void setIwsSntkinfofsegkbn1(String pIwsSntkinfofsegkbn1) {
        iwsSntkinfofsegkbn1 = pIwsSntkinfofsegkbn1;
    }

    @Column(order = 222, length = 2)
    private String iwsSntkinfofkojinkbn1;

    public String getIwsSntkinfofkojinkbn1() {
        return iwsSntkinfofkojinkbn1;
    }

    public void setIwsSntkinfofkojinkbn1(String pIwsSntkinfofkojinkbn1) {
        iwsSntkinfofkojinkbn1 = pIwsSntkinfofkojinkbn1;
    }

    @Column(order = 223, length = 2)
    private String iwsSntkinfokbn1;

    public String getIwsSntkinfokbn1() {
        return iwsSntkinfokbn1;
    }

    public void setIwsSntkinfokbn1(String pIwsSntkinfokbn1) {
        iwsSntkinfokbn1 = pIwsSntkinfokbn1;
    }

    @Column(order = 224, length = 8)
    private String iwsSntkinfosakuseiymd1;

    public String getIwsSntkinfosakuseiymd1() {
        return iwsSntkinfosakuseiymd1;
    }

    public void setIwsSntkinfosakuseiymd1(String pIwsSntkinfosakuseiymd1) {
        iwsSntkinfosakuseiymd1 = pIwsSntkinfosakuseiymd1;
    }

    @Column(order = 225, length = 1)
    private String iwsMrarihyj1;

    public String getIwsMrarihyj1() {
        return iwsMrarihyj1;
    }

    public void setIwsMrarihyj1(String pIwsMrarihyj1) {
        iwsMrarihyj1 = pIwsMrarihyj1;
    }

    @Column(order = 226, length = 1)
    private String iwsDecarihyj1;

    public String getIwsDecarihyj1() {
        return iwsDecarihyj1;
    }

    public void setIwsDecarihyj1(String pIwsDecarihyj1) {
        iwsDecarihyj1 = pIwsDecarihyj1;
    }

    @Column(order = 227, length = 1)
    private String iwsInfokoukanarihyj1;

    public String getIwsInfokoukanarihyj1() {
        return iwsInfokoukanarihyj1;
    }

    public void setIwsInfokoukanarihyj1(String pIwsInfokoukanarihyj1) {
        iwsInfokoukanarihyj1 = pIwsInfokoukanarihyj1;
    }

    @Column(order = 228, length = 1)
    private String iwsNyuuinkyhkshrarihyj1;

    public String getIwsNyuuinkyhkshrarihyj1() {
        return iwsNyuuinkyhkshrarihyj1;
    }

    public void setIwsNyuuinkyhkshrarihyj1(String pIwsNyuuinkyhkshrarihyj1) {
        iwsNyuuinkyhkshrarihyj1 = pIwsNyuuinkyhkshrarihyj1;
    }

    @Column(order = 229, length = 1)
    private String iwsSyujyutukyhkshrarihyj1;

    public String getIwsSyujyutukyhkshrarihyj1() {
        return iwsSyujyutukyhkshrarihyj1;
    }

    public void setIwsSyujyutukyhkshrarihyj1(String pIwsSyujyutukyhkshrarihyj1) {
        iwsSyujyutukyhkshrarihyj1 = pIwsSyujyutukyhkshrarihyj1;
    }

    @Column(order = 230, length = 1)
    private String iwsSyougaikyhkshrarihyj1;

    public String getIwsSyougaikyhkshrarihyj1() {
        return iwsSyougaikyhkshrarihyj1;
    }

    public void setIwsSyougaikyhkshrarihyj1(String pIwsSyougaikyhkshrarihyj1) {
        iwsSyougaikyhkshrarihyj1 = pIwsSyougaikyhkshrarihyj1;
    }

    @Column(order = 231, length = 1)
    private String iwsKoudosyougaiarihyj1;

    public String getIwsKoudosyougaiarihyj1() {
        return iwsKoudosyougaiarihyj1;
    }

    public void setIwsKoudosyougaiarihyj1(String pIwsKoudosyougaiarihyj1) {
        iwsKoudosyougaiarihyj1 = pIwsKoudosyougaiarihyj1;
    }

    @Column(order = 232, length = 1)
    private String iwsPmenarihyj1;

    public String getIwsPmenarihyj1() {
        return iwsPmenarihyj1;
    }

    public void setIwsPmenarihyj1(String pIwsPmenarihyj1) {
        iwsPmenarihyj1 = pIwsPmenarihyj1;
    }

    @Column(order = 233, length = 1)
    private String iwsTorikaijyoarihyj1;

    public String getIwsTorikaijyoarihyj1() {
        return iwsTorikaijyoarihyj1;
    }

    public void setIwsTorikaijyoarihyj1(String pIwsTorikaijyoarihyj1) {
        iwsTorikaijyoarihyj1 = pIwsTorikaijyoarihyj1;
    }

    @Column(order = 234, length = 1)
    private String iwsSoukikeakyhkshrarihyj1;

    public String getIwsSoukikeakyhkshrarihyj1() {
        return iwsSoukikeakyhkshrarihyj1;
    }

    public void setIwsSoukikeakyhkshrarihyj1(String pIwsSoukikeakyhkshrarihyj1) {
        iwsSoukikeakyhkshrarihyj1 = pIwsSoukikeakyhkshrarihyj1;
    }

    @Column(order = 235, length = 1)
    private String iwsSonotakyhkshrarihyj1;

    public String getIwsSonotakyhkshrarihyj1() {
        return iwsSonotakyhkshrarihyj1;
    }

    public void setIwsSonotakyhkshrarihyj1(String pIwsSonotakyhkshrarihyj1) {
        iwsSonotakyhkshrarihyj1 = pIwsSonotakyhkshrarihyj1;
    }

    @Column(order = 236, length = 1)
    private String iwsKghsjjtkyhkshrarihyj1;

    public String getIwsKghsjjtkyhkshrarihyj1() {
        return iwsKghsjjtkyhkshrarihyj1;
    }

    public void setIwsKghsjjtkyhkshrarihyj1(String pIwsKghsjjtkyhkshrarihyj1) {
        iwsKghsjjtkyhkshrarihyj1 = pIwsKghsjjtkyhkshrarihyj1;
    }

    @Column(order = 237, length = 1)
    private String iwsHuho2mrarihyj1;

    public String getIwsHuho2mrarihyj1() {
        return iwsHuho2mrarihyj1;
    }

    public void setIwsHuho2mrarihyj1(String pIwsHuho2mrarihyj1) {
        iwsHuho2mrarihyj1 = pIwsHuho2mrarihyj1;
    }

    @Column(order = 238, length = 1)
    private String iwsHuho2decarihyj1;

    public String getIwsHuho2decarihyj1() {
        return iwsHuho2decarihyj1;
    }

    public void setIwsHuho2decarihyj1(String pIwsHuho2decarihyj1) {
        iwsHuho2decarihyj1 = pIwsHuho2decarihyj1;
    }

    @Column(order = 239, length = 1)
    private String iwsHuho2kdarihyj1;

    public String getIwsHuho2kdarihyj1() {
        return iwsHuho2kdarihyj1;
    }

    public void setIwsHuho2kdarihyj1(String pIwsHuho2kdarihyj1) {
        iwsHuho2kdarihyj1 = pIwsHuho2kdarihyj1;
    }

    @Column(order = 240, length = 1)
    private String iwsHuho2torikaijyoarihyj1;

    public String getIwsHuho2torikaijyoarihyj1() {
        return iwsHuho2torikaijyoarihyj1;
    }

    public void setIwsHuho2torikaijyoarihyj1(String pIwsHuho2torikaijyoarihyj1) {
        iwsHuho2torikaijyoarihyj1 = pIwsHuho2torikaijyoarihyj1;
    }

    @Column(order = 241, length = 11)
    private String iwsSntkinfono2;

    public String getIwsSntkinfono2() {
        return iwsSntkinfono2;
    }

    public void setIwsSntkinfono2(String pIwsSntkinfono2) {
        iwsSntkinfono2 = pIwsSntkinfono2;
    }

    @Column(order = 242, length = 2)
    private String iwsSntkinfofsegkbn2;

    public String getIwsSntkinfofsegkbn2() {
        return iwsSntkinfofsegkbn2;
    }

    public void setIwsSntkinfofsegkbn2(String pIwsSntkinfofsegkbn2) {
        iwsSntkinfofsegkbn2 = pIwsSntkinfofsegkbn2;
    }

    @Column(order = 243, length = 2)
    private String iwsSntkinfofkojinkbn2;

    public String getIwsSntkinfofkojinkbn2() {
        return iwsSntkinfofkojinkbn2;
    }

    public void setIwsSntkinfofkojinkbn2(String pIwsSntkinfofkojinkbn2) {
        iwsSntkinfofkojinkbn2 = pIwsSntkinfofkojinkbn2;
    }

    @Column(order = 244, length = 2)
    private String iwsSntkinfokbn2;

    public String getIwsSntkinfokbn2() {
        return iwsSntkinfokbn2;
    }

    public void setIwsSntkinfokbn2(String pIwsSntkinfokbn2) {
        iwsSntkinfokbn2 = pIwsSntkinfokbn2;
    }

    @Column(order = 245, length = 8)
    private String iwsSntkinfosakuseiymd2;

    public String getIwsSntkinfosakuseiymd2() {
        return iwsSntkinfosakuseiymd2;
    }

    public void setIwsSntkinfosakuseiymd2(String pIwsSntkinfosakuseiymd2) {
        iwsSntkinfosakuseiymd2 = pIwsSntkinfosakuseiymd2;
    }

    @Column(order = 246, length = 1)
    private String iwsMrarihyj2;

    public String getIwsMrarihyj2() {
        return iwsMrarihyj2;
    }

    public void setIwsMrarihyj2(String pIwsMrarihyj2) {
        iwsMrarihyj2 = pIwsMrarihyj2;
    }

    @Column(order = 247, length = 1)
    private String iwsDecarihyj2;

    public String getIwsDecarihyj2() {
        return iwsDecarihyj2;
    }

    public void setIwsDecarihyj2(String pIwsDecarihyj2) {
        iwsDecarihyj2 = pIwsDecarihyj2;
    }

    @Column(order = 248, length = 1)
    private String iwsInfokoukanarihyj2;

    public String getIwsInfokoukanarihyj2() {
        return iwsInfokoukanarihyj2;
    }

    public void setIwsInfokoukanarihyj2(String pIwsInfokoukanarihyj2) {
        iwsInfokoukanarihyj2 = pIwsInfokoukanarihyj2;
    }

    @Column(order = 249, length = 1)
    private String iwsNyuuinkyhkshrarihyj2;

    public String getIwsNyuuinkyhkshrarihyj2() {
        return iwsNyuuinkyhkshrarihyj2;
    }

    public void setIwsNyuuinkyhkshrarihyj2(String pIwsNyuuinkyhkshrarihyj2) {
        iwsNyuuinkyhkshrarihyj2 = pIwsNyuuinkyhkshrarihyj2;
    }

    @Column(order = 250, length = 1)
    private String iwsSyujyutukyhkshrarihyj2;

    public String getIwsSyujyutukyhkshrarihyj2() {
        return iwsSyujyutukyhkshrarihyj2;
    }

    public void setIwsSyujyutukyhkshrarihyj2(String pIwsSyujyutukyhkshrarihyj2) {
        iwsSyujyutukyhkshrarihyj2 = pIwsSyujyutukyhkshrarihyj2;
    }

    @Column(order = 251, length = 1)
    private String iwsSyougaikyhkshrarihyj2;

    public String getIwsSyougaikyhkshrarihyj2() {
        return iwsSyougaikyhkshrarihyj2;
    }

    public void setIwsSyougaikyhkshrarihyj2(String pIwsSyougaikyhkshrarihyj2) {
        iwsSyougaikyhkshrarihyj2 = pIwsSyougaikyhkshrarihyj2;
    }

    @Column(order = 252, length = 1)
    private String iwsKoudosyougaiarihyj2;

    public String getIwsKoudosyougaiarihyj2() {
        return iwsKoudosyougaiarihyj2;
    }

    public void setIwsKoudosyougaiarihyj2(String pIwsKoudosyougaiarihyj2) {
        iwsKoudosyougaiarihyj2 = pIwsKoudosyougaiarihyj2;
    }

    @Column(order = 253, length = 1)
    private String iwsPmenarihyj2;

    public String getIwsPmenarihyj2() {
        return iwsPmenarihyj2;
    }

    public void setIwsPmenarihyj2(String pIwsPmenarihyj2) {
        iwsPmenarihyj2 = pIwsPmenarihyj2;
    }

    @Column(order = 254, length = 1)
    private String iwsTorikaijyoarihyj2;

    public String getIwsTorikaijyoarihyj2() {
        return iwsTorikaijyoarihyj2;
    }

    public void setIwsTorikaijyoarihyj2(String pIwsTorikaijyoarihyj2) {
        iwsTorikaijyoarihyj2 = pIwsTorikaijyoarihyj2;
    }

    @Column(order = 255, length = 1)
    private String iwsSoukikeakyhkshrarihyj2;

    public String getIwsSoukikeakyhkshrarihyj2() {
        return iwsSoukikeakyhkshrarihyj2;
    }

    public void setIwsSoukikeakyhkshrarihyj2(String pIwsSoukikeakyhkshrarihyj2) {
        iwsSoukikeakyhkshrarihyj2 = pIwsSoukikeakyhkshrarihyj2;
    }

    @Column(order = 256, length = 1)
    private String iwsSonotakyhkshrarihyj2;

    public String getIwsSonotakyhkshrarihyj2() {
        return iwsSonotakyhkshrarihyj2;
    }

    public void setIwsSonotakyhkshrarihyj2(String pIwsSonotakyhkshrarihyj2) {
        iwsSonotakyhkshrarihyj2 = pIwsSonotakyhkshrarihyj2;
    }

    @Column(order = 257, length = 1)
    private String iwsKghsjjtkyhkshrarihyj2;

    public String getIwsKghsjjtkyhkshrarihyj2() {
        return iwsKghsjjtkyhkshrarihyj2;
    }

    public void setIwsKghsjjtkyhkshrarihyj2(String pIwsKghsjjtkyhkshrarihyj2) {
        iwsKghsjjtkyhkshrarihyj2 = pIwsKghsjjtkyhkshrarihyj2;
    }

    @Column(order = 258, length = 1)
    private String iwsHuho2mrarihyj2;

    public String getIwsHuho2mrarihyj2() {
        return iwsHuho2mrarihyj2;
    }

    public void setIwsHuho2mrarihyj2(String pIwsHuho2mrarihyj2) {
        iwsHuho2mrarihyj2 = pIwsHuho2mrarihyj2;
    }

    @Column(order = 259, length = 1)
    private String iwsHuho2decarihyj2;

    public String getIwsHuho2decarihyj2() {
        return iwsHuho2decarihyj2;
    }

    public void setIwsHuho2decarihyj2(String pIwsHuho2decarihyj2) {
        iwsHuho2decarihyj2 = pIwsHuho2decarihyj2;
    }

    @Column(order = 260, length = 1)
    private String iwsHuho2kdarihyj2;

    public String getIwsHuho2kdarihyj2() {
        return iwsHuho2kdarihyj2;
    }

    public void setIwsHuho2kdarihyj2(String pIwsHuho2kdarihyj2) {
        iwsHuho2kdarihyj2 = pIwsHuho2kdarihyj2;
    }

    @Column(order = 261, length = 1)
    private String iwsHuho2torikaijyoarihyj2;

    public String getIwsHuho2torikaijyoarihyj2() {
        return iwsHuho2torikaijyoarihyj2;
    }

    public void setIwsHuho2torikaijyoarihyj2(String pIwsHuho2torikaijyoarihyj2) {
        iwsHuho2torikaijyoarihyj2 = pIwsHuho2torikaijyoarihyj2;
    }

    @Column(order = 262, length = 11)
    private String iwsSntkinfono3;

    public String getIwsSntkinfono3() {
        return iwsSntkinfono3;
    }

    public void setIwsSntkinfono3(String pIwsSntkinfono3) {
        iwsSntkinfono3 = pIwsSntkinfono3;
    }

    @Column(order = 263, length = 2)
    private String iwsSntkinfofsegkbn3;

    public String getIwsSntkinfofsegkbn3() {
        return iwsSntkinfofsegkbn3;
    }

    public void setIwsSntkinfofsegkbn3(String pIwsSntkinfofsegkbn3) {
        iwsSntkinfofsegkbn3 = pIwsSntkinfofsegkbn3;
    }

    @Column(order = 264, length = 2)
    private String iwsSntkinfofkojinkbn3;

    public String getIwsSntkinfofkojinkbn3() {
        return iwsSntkinfofkojinkbn3;
    }

    public void setIwsSntkinfofkojinkbn3(String pIwsSntkinfofkojinkbn3) {
        iwsSntkinfofkojinkbn3 = pIwsSntkinfofkojinkbn3;
    }

    @Column(order = 265, length = 2)
    private String iwsSntkinfokbn3;

    public String getIwsSntkinfokbn3() {
        return iwsSntkinfokbn3;
    }

    public void setIwsSntkinfokbn3(String pIwsSntkinfokbn3) {
        iwsSntkinfokbn3 = pIwsSntkinfokbn3;
    }

    @Column(order = 266, length = 8)
    private String iwsSntkinfosakuseiymd3;

    public String getIwsSntkinfosakuseiymd3() {
        return iwsSntkinfosakuseiymd3;
    }

    public void setIwsSntkinfosakuseiymd3(String pIwsSntkinfosakuseiymd3) {
        iwsSntkinfosakuseiymd3 = pIwsSntkinfosakuseiymd3;
    }

    @Column(order = 267, length = 1)
    private String iwsMrarihyj3;

    public String getIwsMrarihyj3() {
        return iwsMrarihyj3;
    }

    public void setIwsMrarihyj3(String pIwsMrarihyj3) {
        iwsMrarihyj3 = pIwsMrarihyj3;
    }

    @Column(order = 268, length = 1)
    private String iwsDecarihyj3;

    public String getIwsDecarihyj3() {
        return iwsDecarihyj3;
    }

    public void setIwsDecarihyj3(String pIwsDecarihyj3) {
        iwsDecarihyj3 = pIwsDecarihyj3;
    }

    @Column(order = 269, length = 1)
    private String iwsInfokoukanarihyj3;

    public String getIwsInfokoukanarihyj3() {
        return iwsInfokoukanarihyj3;
    }

    public void setIwsInfokoukanarihyj3(String pIwsInfokoukanarihyj3) {
        iwsInfokoukanarihyj3 = pIwsInfokoukanarihyj3;
    }

    @Column(order = 270, length = 1)
    private String iwsNyuuinkyhkshrarihyj3;

    public String getIwsNyuuinkyhkshrarihyj3() {
        return iwsNyuuinkyhkshrarihyj3;
    }

    public void setIwsNyuuinkyhkshrarihyj3(String pIwsNyuuinkyhkshrarihyj3) {
        iwsNyuuinkyhkshrarihyj3 = pIwsNyuuinkyhkshrarihyj3;
    }

    @Column(order = 271, length = 1)
    private String iwsSyujyutukyhkshrarihyj3;

    public String getIwsSyujyutukyhkshrarihyj3() {
        return iwsSyujyutukyhkshrarihyj3;
    }

    public void setIwsSyujyutukyhkshrarihyj3(String pIwsSyujyutukyhkshrarihyj3) {
        iwsSyujyutukyhkshrarihyj3 = pIwsSyujyutukyhkshrarihyj3;
    }

    @Column(order = 272, length = 1)
    private String iwsSyougaikyhkshrarihyj3;

    public String getIwsSyougaikyhkshrarihyj3() {
        return iwsSyougaikyhkshrarihyj3;
    }

    public void setIwsSyougaikyhkshrarihyj3(String pIwsSyougaikyhkshrarihyj3) {
        iwsSyougaikyhkshrarihyj3 = pIwsSyougaikyhkshrarihyj3;
    }

    @Column(order = 273, length = 1)
    private String iwsKoudosyougaiarihyj3;

    public String getIwsKoudosyougaiarihyj3() {
        return iwsKoudosyougaiarihyj3;
    }

    public void setIwsKoudosyougaiarihyj3(String pIwsKoudosyougaiarihyj3) {
        iwsKoudosyougaiarihyj3 = pIwsKoudosyougaiarihyj3;
    }

    @Column(order = 274, length = 1)
    private String iwsPmenarihyj3;

    public String getIwsPmenarihyj3() {
        return iwsPmenarihyj3;
    }

    public void setIwsPmenarihyj3(String pIwsPmenarihyj3) {
        iwsPmenarihyj3 = pIwsPmenarihyj3;
    }

    @Column(order = 275, length = 1)
    private String iwsTorikaijyoarihyj3;

    public String getIwsTorikaijyoarihyj3() {
        return iwsTorikaijyoarihyj3;
    }

    public void setIwsTorikaijyoarihyj3(String pIwsTorikaijyoarihyj3) {
        iwsTorikaijyoarihyj3 = pIwsTorikaijyoarihyj3;
    }

    @Column(order = 276, length = 1)
    private String iwsSoukikeakyhkshrarihyj3;

    public String getIwsSoukikeakyhkshrarihyj3() {
        return iwsSoukikeakyhkshrarihyj3;
    }

    public void setIwsSoukikeakyhkshrarihyj3(String pIwsSoukikeakyhkshrarihyj3) {
        iwsSoukikeakyhkshrarihyj3 = pIwsSoukikeakyhkshrarihyj3;
    }

    @Column(order = 277, length = 1)
    private String iwsSonotakyhkshrarihyj3;

    public String getIwsSonotakyhkshrarihyj3() {
        return iwsSonotakyhkshrarihyj3;
    }

    public void setIwsSonotakyhkshrarihyj3(String pIwsSonotakyhkshrarihyj3) {
        iwsSonotakyhkshrarihyj3 = pIwsSonotakyhkshrarihyj3;
    }

    @Column(order = 278, length = 1)
    private String iwsKghsjjtkyhkshrarihyj3;

    public String getIwsKghsjjtkyhkshrarihyj3() {
        return iwsKghsjjtkyhkshrarihyj3;
    }

    public void setIwsKghsjjtkyhkshrarihyj3(String pIwsKghsjjtkyhkshrarihyj3) {
        iwsKghsjjtkyhkshrarihyj3 = pIwsKghsjjtkyhkshrarihyj3;
    }

    @Column(order = 279, length = 1)
    private String iwsHuho2mrarihyj3;

    public String getIwsHuho2mrarihyj3() {
        return iwsHuho2mrarihyj3;
    }

    public void setIwsHuho2mrarihyj3(String pIwsHuho2mrarihyj3) {
        iwsHuho2mrarihyj3 = pIwsHuho2mrarihyj3;
    }

    @Column(order = 280, length = 1)
    private String iwsHuho2decarihyj3;

    public String getIwsHuho2decarihyj3() {
        return iwsHuho2decarihyj3;
    }

    public void setIwsHuho2decarihyj3(String pIwsHuho2decarihyj3) {
        iwsHuho2decarihyj3 = pIwsHuho2decarihyj3;
    }

    @Column(order = 281, length = 1)
    private String iwsHuho2kdarihyj3;

    public String getIwsHuho2kdarihyj3() {
        return iwsHuho2kdarihyj3;
    }

    public void setIwsHuho2kdarihyj3(String pIwsHuho2kdarihyj3) {
        iwsHuho2kdarihyj3 = pIwsHuho2kdarihyj3;
    }

    @Column(order = 282, length = 1)
    private String iwsHuho2torikaijyoarihyj3;

    public String getIwsHuho2torikaijyoarihyj3() {
        return iwsHuho2torikaijyoarihyj3;
    }

    public void setIwsHuho2torikaijyoarihyj3(String pIwsHuho2torikaijyoarihyj3) {
        iwsHuho2torikaijyoarihyj3 = pIwsHuho2torikaijyoarihyj3;
    }

    @Column(order = 283, length = 11)
    private String iwsSntkinfono4;

    public String getIwsSntkinfono4() {
        return iwsSntkinfono4;
    }

    public void setIwsSntkinfono4(String pIwsSntkinfono4) {
        iwsSntkinfono4 = pIwsSntkinfono4;
    }

    @Column(order = 284, length = 2)
    private String iwsSntkinfofsegkbn4;

    public String getIwsSntkinfofsegkbn4() {
        return iwsSntkinfofsegkbn4;
    }

    public void setIwsSntkinfofsegkbn4(String pIwsSntkinfofsegkbn4) {
        iwsSntkinfofsegkbn4 = pIwsSntkinfofsegkbn4;
    }

    @Column(order = 285, length = 2)
    private String iwsSntkinfofkojinkbn4;

    public String getIwsSntkinfofkojinkbn4() {
        return iwsSntkinfofkojinkbn4;
    }

    public void setIwsSntkinfofkojinkbn4(String pIwsSntkinfofkojinkbn4) {
        iwsSntkinfofkojinkbn4 = pIwsSntkinfofkojinkbn4;
    }

    @Column(order = 286, length = 2)
    private String iwsSntkinfokbn4;

    public String getIwsSntkinfokbn4() {
        return iwsSntkinfokbn4;
    }

    public void setIwsSntkinfokbn4(String pIwsSntkinfokbn4) {
        iwsSntkinfokbn4 = pIwsSntkinfokbn4;
    }

    @Column(order = 287, length = 8)
    private String iwsSntkinfosakuseiymd4;

    public String getIwsSntkinfosakuseiymd4() {
        return iwsSntkinfosakuseiymd4;
    }

    public void setIwsSntkinfosakuseiymd4(String pIwsSntkinfosakuseiymd4) {
        iwsSntkinfosakuseiymd4 = pIwsSntkinfosakuseiymd4;
    }

    @Column(order = 288, length = 1)
    private String iwsMrarihyj4;

    public String getIwsMrarihyj4() {
        return iwsMrarihyj4;
    }

    public void setIwsMrarihyj4(String pIwsMrarihyj4) {
        iwsMrarihyj4 = pIwsMrarihyj4;
    }

    @Column(order = 289, length = 1)
    private String iwsDecarihyj4;

    public String getIwsDecarihyj4() {
        return iwsDecarihyj4;
    }

    public void setIwsDecarihyj4(String pIwsDecarihyj4) {
        iwsDecarihyj4 = pIwsDecarihyj4;
    }

    @Column(order = 290, length = 1)
    private String iwsInfokoukanarihyj4;

    public String getIwsInfokoukanarihyj4() {
        return iwsInfokoukanarihyj4;
    }

    public void setIwsInfokoukanarihyj4(String pIwsInfokoukanarihyj4) {
        iwsInfokoukanarihyj4 = pIwsInfokoukanarihyj4;
    }

    @Column(order = 291, length = 1)
    private String iwsNyuuinkyhkshrarihyj4;

    public String getIwsNyuuinkyhkshrarihyj4() {
        return iwsNyuuinkyhkshrarihyj4;
    }

    public void setIwsNyuuinkyhkshrarihyj4(String pIwsNyuuinkyhkshrarihyj4) {
        iwsNyuuinkyhkshrarihyj4 = pIwsNyuuinkyhkshrarihyj4;
    }

    @Column(order = 292, length = 1)
    private String iwsSyujyutukyhkshrarihyj4;

    public String getIwsSyujyutukyhkshrarihyj4() {
        return iwsSyujyutukyhkshrarihyj4;
    }

    public void setIwsSyujyutukyhkshrarihyj4(String pIwsSyujyutukyhkshrarihyj4) {
        iwsSyujyutukyhkshrarihyj4 = pIwsSyujyutukyhkshrarihyj4;
    }

    @Column(order = 293, length = 1)
    private String iwsSyougaikyhkshrarihyj4;

    public String getIwsSyougaikyhkshrarihyj4() {
        return iwsSyougaikyhkshrarihyj4;
    }

    public void setIwsSyougaikyhkshrarihyj4(String pIwsSyougaikyhkshrarihyj4) {
        iwsSyougaikyhkshrarihyj4 = pIwsSyougaikyhkshrarihyj4;
    }

    @Column(order = 294, length = 1)
    private String iwsKoudosyougaiarihyj4;

    public String getIwsKoudosyougaiarihyj4() {
        return iwsKoudosyougaiarihyj4;
    }

    public void setIwsKoudosyougaiarihyj4(String pIwsKoudosyougaiarihyj4) {
        iwsKoudosyougaiarihyj4 = pIwsKoudosyougaiarihyj4;
    }

    @Column(order = 295, length = 1)
    private String iwsPmenarihyj4;

    public String getIwsPmenarihyj4() {
        return iwsPmenarihyj4;
    }

    public void setIwsPmenarihyj4(String pIwsPmenarihyj4) {
        iwsPmenarihyj4 = pIwsPmenarihyj4;
    }

    @Column(order = 296, length = 1)
    private String iwsTorikaijyoarihyj4;

    public String getIwsTorikaijyoarihyj4() {
        return iwsTorikaijyoarihyj4;
    }

    public void setIwsTorikaijyoarihyj4(String pIwsTorikaijyoarihyj4) {
        iwsTorikaijyoarihyj4 = pIwsTorikaijyoarihyj4;
    }

    @Column(order = 297, length = 1)
    private String iwsSoukikeakyhkshrarihyj4;

    public String getIwsSoukikeakyhkshrarihyj4() {
        return iwsSoukikeakyhkshrarihyj4;
    }

    public void setIwsSoukikeakyhkshrarihyj4(String pIwsSoukikeakyhkshrarihyj4) {
        iwsSoukikeakyhkshrarihyj4 = pIwsSoukikeakyhkshrarihyj4;
    }

    @Column(order = 298, length = 1)
    private String iwsSonotakyhkshrarihyj4;

    public String getIwsSonotakyhkshrarihyj4() {
        return iwsSonotakyhkshrarihyj4;
    }

    public void setIwsSonotakyhkshrarihyj4(String pIwsSonotakyhkshrarihyj4) {
        iwsSonotakyhkshrarihyj4 = pIwsSonotakyhkshrarihyj4;
    }

    @Column(order = 299, length = 1)
    private String iwsKghsjjtkyhkshrarihyj4;

    public String getIwsKghsjjtkyhkshrarihyj4() {
        return iwsKghsjjtkyhkshrarihyj4;
    }

    public void setIwsKghsjjtkyhkshrarihyj4(String pIwsKghsjjtkyhkshrarihyj4) {
        iwsKghsjjtkyhkshrarihyj4 = pIwsKghsjjtkyhkshrarihyj4;
    }

    @Column(order = 300, length = 1)
    private String iwsHuho2mrarihyj4;

    public String getIwsHuho2mrarihyj4() {
        return iwsHuho2mrarihyj4;
    }

    public void setIwsHuho2mrarihyj4(String pIwsHuho2mrarihyj4) {
        iwsHuho2mrarihyj4 = pIwsHuho2mrarihyj4;
    }

    @Column(order = 301, length = 1)
    private String iwsHuho2decarihyj4;

    public String getIwsHuho2decarihyj4() {
        return iwsHuho2decarihyj4;
    }

    public void setIwsHuho2decarihyj4(String pIwsHuho2decarihyj4) {
        iwsHuho2decarihyj4 = pIwsHuho2decarihyj4;
    }

    @Column(order = 302, length = 1)
    private String iwsHuho2kdarihyj4;

    public String getIwsHuho2kdarihyj4() {
        return iwsHuho2kdarihyj4;
    }

    public void setIwsHuho2kdarihyj4(String pIwsHuho2kdarihyj4) {
        iwsHuho2kdarihyj4 = pIwsHuho2kdarihyj4;
    }

    @Column(order = 303, length = 1)
    private String iwsHuho2torikaijyoarihyj4;

    public String getIwsHuho2torikaijyoarihyj4() {
        return iwsHuho2torikaijyoarihyj4;
    }

    public void setIwsHuho2torikaijyoarihyj4(String pIwsHuho2torikaijyoarihyj4) {
        iwsHuho2torikaijyoarihyj4 = pIwsHuho2torikaijyoarihyj4;
    }

    @Column(order = 304, length = 11)
    private String iwsSntkinfono5;

    public String getIwsSntkinfono5() {
        return iwsSntkinfono5;
    }

    public void setIwsSntkinfono5(String pIwsSntkinfono5) {
        iwsSntkinfono5 = pIwsSntkinfono5;
    }

    @Column(order = 305, length = 2)
    private String iwsSntkinfofsegkbn5;

    public String getIwsSntkinfofsegkbn5() {
        return iwsSntkinfofsegkbn5;
    }

    public void setIwsSntkinfofsegkbn5(String pIwsSntkinfofsegkbn5) {
        iwsSntkinfofsegkbn5 = pIwsSntkinfofsegkbn5;
    }

    @Column(order = 306, length = 2)
    private String iwsSntkinfofkojinkbn5;

    public String getIwsSntkinfofkojinkbn5() {
        return iwsSntkinfofkojinkbn5;
    }

    public void setIwsSntkinfofkojinkbn5(String pIwsSntkinfofkojinkbn5) {
        iwsSntkinfofkojinkbn5 = pIwsSntkinfofkojinkbn5;
    }

    @Column(order = 307, length = 2)
    private String iwsSntkinfokbn5;

    public String getIwsSntkinfokbn5() {
        return iwsSntkinfokbn5;
    }

    public void setIwsSntkinfokbn5(String pIwsSntkinfokbn5) {
        iwsSntkinfokbn5 = pIwsSntkinfokbn5;
    }

    @Column(order = 308, length = 8)
    private String iwsSntkinfosakuseiymd5;

    public String getIwsSntkinfosakuseiymd5() {
        return iwsSntkinfosakuseiymd5;
    }

    public void setIwsSntkinfosakuseiymd5(String pIwsSntkinfosakuseiymd5) {
        iwsSntkinfosakuseiymd5 = pIwsSntkinfosakuseiymd5;
    }

    @Column(order = 309, length = 1)
    private String iwsMrarihyj5;

    public String getIwsMrarihyj5() {
        return iwsMrarihyj5;
    }

    public void setIwsMrarihyj5(String pIwsMrarihyj5) {
        iwsMrarihyj5 = pIwsMrarihyj5;
    }

    @Column(order = 310, length = 1)
    private String iwsDecarihyj5;

    public String getIwsDecarihyj5() {
        return iwsDecarihyj5;
    }

    public void setIwsDecarihyj5(String pIwsDecarihyj5) {
        iwsDecarihyj5 = pIwsDecarihyj5;
    }

    @Column(order = 311, length = 1)
    private String iwsInfokoukanarihyj5;

    public String getIwsInfokoukanarihyj5() {
        return iwsInfokoukanarihyj5;
    }

    public void setIwsInfokoukanarihyj5(String pIwsInfokoukanarihyj5) {
        iwsInfokoukanarihyj5 = pIwsInfokoukanarihyj5;
    }

    @Column(order = 312, length = 1)
    private String iwsNyuuinkyhkshrarihyj5;

    public String getIwsNyuuinkyhkshrarihyj5() {
        return iwsNyuuinkyhkshrarihyj5;
    }

    public void setIwsNyuuinkyhkshrarihyj5(String pIwsNyuuinkyhkshrarihyj5) {
        iwsNyuuinkyhkshrarihyj5 = pIwsNyuuinkyhkshrarihyj5;
    }

    @Column(order = 313, length = 1)
    private String iwsSyujyutukyhkshrarihyj5;

    public String getIwsSyujyutukyhkshrarihyj5() {
        return iwsSyujyutukyhkshrarihyj5;
    }

    public void setIwsSyujyutukyhkshrarihyj5(String pIwsSyujyutukyhkshrarihyj5) {
        iwsSyujyutukyhkshrarihyj5 = pIwsSyujyutukyhkshrarihyj5;
    }

    @Column(order = 314, length = 1)
    private String iwsSyougaikyhkshrarihyj5;

    public String getIwsSyougaikyhkshrarihyj5() {
        return iwsSyougaikyhkshrarihyj5;
    }

    public void setIwsSyougaikyhkshrarihyj5(String pIwsSyougaikyhkshrarihyj5) {
        iwsSyougaikyhkshrarihyj5 = pIwsSyougaikyhkshrarihyj5;
    }

    @Column(order = 315, length = 1)
    private String iwsKoudosyougaiarihyj5;

    public String getIwsKoudosyougaiarihyj5() {
        return iwsKoudosyougaiarihyj5;
    }

    public void setIwsKoudosyougaiarihyj5(String pIwsKoudosyougaiarihyj5) {
        iwsKoudosyougaiarihyj5 = pIwsKoudosyougaiarihyj5;
    }

    @Column(order = 316, length = 1)
    private String iwsPmenarihyj5;

    public String getIwsPmenarihyj5() {
        return iwsPmenarihyj5;
    }

    public void setIwsPmenarihyj5(String pIwsPmenarihyj5) {
        iwsPmenarihyj5 = pIwsPmenarihyj5;
    }

    @Column(order = 317, length = 1)
    private String iwsTorikaijyoarihyj5;

    public String getIwsTorikaijyoarihyj5() {
        return iwsTorikaijyoarihyj5;
    }

    public void setIwsTorikaijyoarihyj5(String pIwsTorikaijyoarihyj5) {
        iwsTorikaijyoarihyj5 = pIwsTorikaijyoarihyj5;
    }

    @Column(order = 318, length = 1)
    private String iwsSoukikeakyhkshrarihyj5;

    public String getIwsSoukikeakyhkshrarihyj5() {
        return iwsSoukikeakyhkshrarihyj5;
    }

    public void setIwsSoukikeakyhkshrarihyj5(String pIwsSoukikeakyhkshrarihyj5) {
        iwsSoukikeakyhkshrarihyj5 = pIwsSoukikeakyhkshrarihyj5;
    }

    @Column(order = 319, length = 1)
    private String iwsSonotakyhkshrarihyj5;

    public String getIwsSonotakyhkshrarihyj5() {
        return iwsSonotakyhkshrarihyj5;
    }

    public void setIwsSonotakyhkshrarihyj5(String pIwsSonotakyhkshrarihyj5) {
        iwsSonotakyhkshrarihyj5 = pIwsSonotakyhkshrarihyj5;
    }

    @Column(order = 320, length = 1)
    private String iwsKghsjjtkyhkshrarihyj5;

    public String getIwsKghsjjtkyhkshrarihyj5() {
        return iwsKghsjjtkyhkshrarihyj5;
    }

    public void setIwsKghsjjtkyhkshrarihyj5(String pIwsKghsjjtkyhkshrarihyj5) {
        iwsKghsjjtkyhkshrarihyj5 = pIwsKghsjjtkyhkshrarihyj5;
    }

    @Column(order = 321, length = 1)
    private String iwsHuho2mrarihyj5;

    public String getIwsHuho2mrarihyj5() {
        return iwsHuho2mrarihyj5;
    }

    public void setIwsHuho2mrarihyj5(String pIwsHuho2mrarihyj5) {
        iwsHuho2mrarihyj5 = pIwsHuho2mrarihyj5;
    }

    @Column(order = 322, length = 1)
    private String iwsHuho2decarihyj5;

    public String getIwsHuho2decarihyj5() {
        return iwsHuho2decarihyj5;
    }

    public void setIwsHuho2decarihyj5(String pIwsHuho2decarihyj5) {
        iwsHuho2decarihyj5 = pIwsHuho2decarihyj5;
    }

    @Column(order = 323, length = 1)
    private String iwsHuho2kdarihyj5;

    public String getIwsHuho2kdarihyj5() {
        return iwsHuho2kdarihyj5;
    }

    public void setIwsHuho2kdarihyj5(String pIwsHuho2kdarihyj5) {
        iwsHuho2kdarihyj5 = pIwsHuho2kdarihyj5;
    }

    @Column(order = 324, length = 1)
    private String iwsHuho2torikaijyoarihyj5;

    public String getIwsHuho2torikaijyoarihyj5() {
        return iwsHuho2torikaijyoarihyj5;
    }

    public void setIwsHuho2torikaijyoarihyj5(String pIwsHuho2torikaijyoarihyj5) {
        iwsHuho2torikaijyoarihyj5 = pIwsHuho2torikaijyoarihyj5;
    }

    @Column(order = 325, length = 11)
    private String iwsSntkinfono6;

    public String getIwsSntkinfono6() {
        return iwsSntkinfono6;
    }

    public void setIwsSntkinfono6(String pIwsSntkinfono6) {
        iwsSntkinfono6 = pIwsSntkinfono6;
    }

    @Column(order = 326, length = 2)
    private String iwsSntkinfofsegkbn6;

    public String getIwsSntkinfofsegkbn6() {
        return iwsSntkinfofsegkbn6;
    }

    public void setIwsSntkinfofsegkbn6(String pIwsSntkinfofsegkbn6) {
        iwsSntkinfofsegkbn6 = pIwsSntkinfofsegkbn6;
    }

    @Column(order = 327, length = 2)
    private String iwsSntkinfofkojinkbn6;

    public String getIwsSntkinfofkojinkbn6() {
        return iwsSntkinfofkojinkbn6;
    }

    public void setIwsSntkinfofkojinkbn6(String pIwsSntkinfofkojinkbn6) {
        iwsSntkinfofkojinkbn6 = pIwsSntkinfofkojinkbn6;
    }

    @Column(order = 328, length = 2)
    private String iwsSntkinfokbn6;

    public String getIwsSntkinfokbn6() {
        return iwsSntkinfokbn6;
    }

    public void setIwsSntkinfokbn6(String pIwsSntkinfokbn6) {
        iwsSntkinfokbn6 = pIwsSntkinfokbn6;
    }

    @Column(order = 329, length = 8)
    private String iwsSntkinfosakuseiymd6;

    public String getIwsSntkinfosakuseiymd6() {
        return iwsSntkinfosakuseiymd6;
    }

    public void setIwsSntkinfosakuseiymd6(String pIwsSntkinfosakuseiymd6) {
        iwsSntkinfosakuseiymd6 = pIwsSntkinfosakuseiymd6;
    }

    @Column(order = 330, length = 1)
    private String iwsMrarihyj6;

    public String getIwsMrarihyj6() {
        return iwsMrarihyj6;
    }

    public void setIwsMrarihyj6(String pIwsMrarihyj6) {
        iwsMrarihyj6 = pIwsMrarihyj6;
    }

    @Column(order = 331, length = 1)
    private String iwsDecarihyj6;

    public String getIwsDecarihyj6() {
        return iwsDecarihyj6;
    }

    public void setIwsDecarihyj6(String pIwsDecarihyj6) {
        iwsDecarihyj6 = pIwsDecarihyj6;
    }

    @Column(order = 332, length = 1)
    private String iwsInfokoukanarihyj6;

    public String getIwsInfokoukanarihyj6() {
        return iwsInfokoukanarihyj6;
    }

    public void setIwsInfokoukanarihyj6(String pIwsInfokoukanarihyj6) {
        iwsInfokoukanarihyj6 = pIwsInfokoukanarihyj6;
    }

    @Column(order = 333, length = 1)
    private String iwsNyuuinkyhkshrarihyj6;

    public String getIwsNyuuinkyhkshrarihyj6() {
        return iwsNyuuinkyhkshrarihyj6;
    }

    public void setIwsNyuuinkyhkshrarihyj6(String pIwsNyuuinkyhkshrarihyj6) {
        iwsNyuuinkyhkshrarihyj6 = pIwsNyuuinkyhkshrarihyj6;
    }

    @Column(order = 334, length = 1)
    private String iwsSyujyutukyhkshrarihyj6;

    public String getIwsSyujyutukyhkshrarihyj6() {
        return iwsSyujyutukyhkshrarihyj6;
    }

    public void setIwsSyujyutukyhkshrarihyj6(String pIwsSyujyutukyhkshrarihyj6) {
        iwsSyujyutukyhkshrarihyj6 = pIwsSyujyutukyhkshrarihyj6;
    }

    @Column(order = 335, length = 1)
    private String iwsSyougaikyhkshrarihyj6;

    public String getIwsSyougaikyhkshrarihyj6() {
        return iwsSyougaikyhkshrarihyj6;
    }

    public void setIwsSyougaikyhkshrarihyj6(String pIwsSyougaikyhkshrarihyj6) {
        iwsSyougaikyhkshrarihyj6 = pIwsSyougaikyhkshrarihyj6;
    }

    @Column(order = 336, length = 1)
    private String iwsKoudosyougaiarihyj6;

    public String getIwsKoudosyougaiarihyj6() {
        return iwsKoudosyougaiarihyj6;
    }

    public void setIwsKoudosyougaiarihyj6(String pIwsKoudosyougaiarihyj6) {
        iwsKoudosyougaiarihyj6 = pIwsKoudosyougaiarihyj6;
    }

    @Column(order = 337, length = 1)
    private String iwsPmenarihyj6;

    public String getIwsPmenarihyj6() {
        return iwsPmenarihyj6;
    }

    public void setIwsPmenarihyj6(String pIwsPmenarihyj6) {
        iwsPmenarihyj6 = pIwsPmenarihyj6;
    }

    @Column(order = 338, length = 1)
    private String iwsTorikaijyoarihyj6;

    public String getIwsTorikaijyoarihyj6() {
        return iwsTorikaijyoarihyj6;
    }

    public void setIwsTorikaijyoarihyj6(String pIwsTorikaijyoarihyj6) {
        iwsTorikaijyoarihyj6 = pIwsTorikaijyoarihyj6;
    }

    @Column(order = 339, length = 1)
    private String iwsSoukikeakyhkshrarihyj6;

    public String getIwsSoukikeakyhkshrarihyj6() {
        return iwsSoukikeakyhkshrarihyj6;
    }

    public void setIwsSoukikeakyhkshrarihyj6(String pIwsSoukikeakyhkshrarihyj6) {
        iwsSoukikeakyhkshrarihyj6 = pIwsSoukikeakyhkshrarihyj6;
    }

    @Column(order = 340, length = 1)
    private String iwsSonotakyhkshrarihyj6;

    public String getIwsSonotakyhkshrarihyj6() {
        return iwsSonotakyhkshrarihyj6;
    }

    public void setIwsSonotakyhkshrarihyj6(String pIwsSonotakyhkshrarihyj6) {
        iwsSonotakyhkshrarihyj6 = pIwsSonotakyhkshrarihyj6;
    }

    @Column(order = 341, length = 1)
    private String iwsKghsjjtkyhkshrarihyj6;

    public String getIwsKghsjjtkyhkshrarihyj6() {
        return iwsKghsjjtkyhkshrarihyj6;
    }

    public void setIwsKghsjjtkyhkshrarihyj6(String pIwsKghsjjtkyhkshrarihyj6) {
        iwsKghsjjtkyhkshrarihyj6 = pIwsKghsjjtkyhkshrarihyj6;
    }

    @Column(order = 342, length = 1)
    private String iwsHuho2mrarihyj6;

    public String getIwsHuho2mrarihyj6() {
        return iwsHuho2mrarihyj6;
    }

    public void setIwsHuho2mrarihyj6(String pIwsHuho2mrarihyj6) {
        iwsHuho2mrarihyj6 = pIwsHuho2mrarihyj6;
    }

    @Column(order = 343, length = 1)
    private String iwsHuho2decarihyj6;

    public String getIwsHuho2decarihyj6() {
        return iwsHuho2decarihyj6;
    }

    public void setIwsHuho2decarihyj6(String pIwsHuho2decarihyj6) {
        iwsHuho2decarihyj6 = pIwsHuho2decarihyj6;
    }

    @Column(order = 344, length = 1)
    private String iwsHuho2kdarihyj6;

    public String getIwsHuho2kdarihyj6() {
        return iwsHuho2kdarihyj6;
    }

    public void setIwsHuho2kdarihyj6(String pIwsHuho2kdarihyj6) {
        iwsHuho2kdarihyj6 = pIwsHuho2kdarihyj6;
    }

    @Column(order = 345, length = 1)
    private String iwsHuho2torikaijyoarihyj6;

    public String getIwsHuho2torikaijyoarihyj6() {
        return iwsHuho2torikaijyoarihyj6;
    }

    public void setIwsHuho2torikaijyoarihyj6(String pIwsHuho2torikaijyoarihyj6) {
        iwsHuho2torikaijyoarihyj6 = pIwsHuho2torikaijyoarihyj6;
    }

    @Column(order = 346, length = 11)
    private String iwsSntkinfono7;

    public String getIwsSntkinfono7() {
        return iwsSntkinfono7;
    }

    public void setIwsSntkinfono7(String pIwsSntkinfono7) {
        iwsSntkinfono7 = pIwsSntkinfono7;
    }

    @Column(order = 347, length = 2)
    private String iwsSntkinfofsegkbn7;

    public String getIwsSntkinfofsegkbn7() {
        return iwsSntkinfofsegkbn7;
    }

    public void setIwsSntkinfofsegkbn7(String pIwsSntkinfofsegkbn7) {
        iwsSntkinfofsegkbn7 = pIwsSntkinfofsegkbn7;
    }

    @Column(order = 348, length = 2)
    private String iwsSntkinfofkojinkbn7;

    public String getIwsSntkinfofkojinkbn7() {
        return iwsSntkinfofkojinkbn7;
    }

    public void setIwsSntkinfofkojinkbn7(String pIwsSntkinfofkojinkbn7) {
        iwsSntkinfofkojinkbn7 = pIwsSntkinfofkojinkbn7;
    }

    @Column(order = 349, length = 2)
    private String iwsSntkinfokbn7;

    public String getIwsSntkinfokbn7() {
        return iwsSntkinfokbn7;
    }

    public void setIwsSntkinfokbn7(String pIwsSntkinfokbn7) {
        iwsSntkinfokbn7 = pIwsSntkinfokbn7;
    }

    @Column(order = 350, length = 8)
    private String iwsSntkinfosakuseiymd7;

    public String getIwsSntkinfosakuseiymd7() {
        return iwsSntkinfosakuseiymd7;
    }

    public void setIwsSntkinfosakuseiymd7(String pIwsSntkinfosakuseiymd7) {
        iwsSntkinfosakuseiymd7 = pIwsSntkinfosakuseiymd7;
    }

    @Column(order = 351, length = 1)
    private String iwsMrarihyj7;

    public String getIwsMrarihyj7() {
        return iwsMrarihyj7;
    }

    public void setIwsMrarihyj7(String pIwsMrarihyj7) {
        iwsMrarihyj7 = pIwsMrarihyj7;
    }

    @Column(order = 352, length = 1)
    private String iwsDecarihyj7;

    public String getIwsDecarihyj7() {
        return iwsDecarihyj7;
    }

    public void setIwsDecarihyj7(String pIwsDecarihyj7) {
        iwsDecarihyj7 = pIwsDecarihyj7;
    }

    @Column(order = 353, length = 1)
    private String iwsInfokoukanarihyj7;

    public String getIwsInfokoukanarihyj7() {
        return iwsInfokoukanarihyj7;
    }

    public void setIwsInfokoukanarihyj7(String pIwsInfokoukanarihyj7) {
        iwsInfokoukanarihyj7 = pIwsInfokoukanarihyj7;
    }

    @Column(order = 354, length = 1)
    private String iwsNyuuinkyhkshrarihyj7;

    public String getIwsNyuuinkyhkshrarihyj7() {
        return iwsNyuuinkyhkshrarihyj7;
    }

    public void setIwsNyuuinkyhkshrarihyj7(String pIwsNyuuinkyhkshrarihyj7) {
        iwsNyuuinkyhkshrarihyj7 = pIwsNyuuinkyhkshrarihyj7;
    }

    @Column(order = 355, length = 1)
    private String iwsSyujyutukyhkshrarihyj7;

    public String getIwsSyujyutukyhkshrarihyj7() {
        return iwsSyujyutukyhkshrarihyj7;
    }

    public void setIwsSyujyutukyhkshrarihyj7(String pIwsSyujyutukyhkshrarihyj7) {
        iwsSyujyutukyhkshrarihyj7 = pIwsSyujyutukyhkshrarihyj7;
    }

    @Column(order = 356, length = 1)
    private String iwsSyougaikyhkshrarihyj7;

    public String getIwsSyougaikyhkshrarihyj7() {
        return iwsSyougaikyhkshrarihyj7;
    }

    public void setIwsSyougaikyhkshrarihyj7(String pIwsSyougaikyhkshrarihyj7) {
        iwsSyougaikyhkshrarihyj7 = pIwsSyougaikyhkshrarihyj7;
    }

    @Column(order = 357, length = 1)
    private String iwsKoudosyougaiarihyj7;

    public String getIwsKoudosyougaiarihyj7() {
        return iwsKoudosyougaiarihyj7;
    }

    public void setIwsKoudosyougaiarihyj7(String pIwsKoudosyougaiarihyj7) {
        iwsKoudosyougaiarihyj7 = pIwsKoudosyougaiarihyj7;
    }

    @Column(order = 358, length = 1)
    private String iwsPmenarihyj7;

    public String getIwsPmenarihyj7() {
        return iwsPmenarihyj7;
    }

    public void setIwsPmenarihyj7(String pIwsPmenarihyj7) {
        iwsPmenarihyj7 = pIwsPmenarihyj7;
    }

    @Column(order = 359, length = 1)
    private String iwsTorikaijyoarihyj7;

    public String getIwsTorikaijyoarihyj7() {
        return iwsTorikaijyoarihyj7;
    }

    public void setIwsTorikaijyoarihyj7(String pIwsTorikaijyoarihyj7) {
        iwsTorikaijyoarihyj7 = pIwsTorikaijyoarihyj7;
    }

    @Column(order = 360, length = 1)
    private String iwsSoukikeakyhkshrarihyj7;

    public String getIwsSoukikeakyhkshrarihyj7() {
        return iwsSoukikeakyhkshrarihyj7;
    }

    public void setIwsSoukikeakyhkshrarihyj7(String pIwsSoukikeakyhkshrarihyj7) {
        iwsSoukikeakyhkshrarihyj7 = pIwsSoukikeakyhkshrarihyj7;
    }

    @Column(order = 361, length = 1)
    private String iwsSonotakyhkshrarihyj7;

    public String getIwsSonotakyhkshrarihyj7() {
        return iwsSonotakyhkshrarihyj7;
    }

    public void setIwsSonotakyhkshrarihyj7(String pIwsSonotakyhkshrarihyj7) {
        iwsSonotakyhkshrarihyj7 = pIwsSonotakyhkshrarihyj7;
    }

    @Column(order = 362, length = 1)
    private String iwsKghsjjtkyhkshrarihyj7;

    public String getIwsKghsjjtkyhkshrarihyj7() {
        return iwsKghsjjtkyhkshrarihyj7;
    }

    public void setIwsKghsjjtkyhkshrarihyj7(String pIwsKghsjjtkyhkshrarihyj7) {
        iwsKghsjjtkyhkshrarihyj7 = pIwsKghsjjtkyhkshrarihyj7;
    }

    @Column(order = 363, length = 1)
    private String iwsHuho2mrarihyj7;

    public String getIwsHuho2mrarihyj7() {
        return iwsHuho2mrarihyj7;
    }

    public void setIwsHuho2mrarihyj7(String pIwsHuho2mrarihyj7) {
        iwsHuho2mrarihyj7 = pIwsHuho2mrarihyj7;
    }

    @Column(order = 364, length = 1)
    private String iwsHuho2decarihyj7;

    public String getIwsHuho2decarihyj7() {
        return iwsHuho2decarihyj7;
    }

    public void setIwsHuho2decarihyj7(String pIwsHuho2decarihyj7) {
        iwsHuho2decarihyj7 = pIwsHuho2decarihyj7;
    }

    @Column(order = 365, length = 1)
    private String iwsHuho2kdarihyj7;

    public String getIwsHuho2kdarihyj7() {
        return iwsHuho2kdarihyj7;
    }

    public void setIwsHuho2kdarihyj7(String pIwsHuho2kdarihyj7) {
        iwsHuho2kdarihyj7 = pIwsHuho2kdarihyj7;
    }

    @Column(order = 366, length = 1)
    private String iwsHuho2torikaijyoarihyj7;

    public String getIwsHuho2torikaijyoarihyj7() {
        return iwsHuho2torikaijyoarihyj7;
    }

    public void setIwsHuho2torikaijyoarihyj7(String pIwsHuho2torikaijyoarihyj7) {
        iwsHuho2torikaijyoarihyj7 = pIwsHuho2torikaijyoarihyj7;
    }

    @Column(order = 367, length = 11)
    private String iwsSntkinfono8;

    public String getIwsSntkinfono8() {
        return iwsSntkinfono8;
    }

    public void setIwsSntkinfono8(String pIwsSntkinfono8) {
        iwsSntkinfono8 = pIwsSntkinfono8;
    }

    @Column(order = 368, length = 2)
    private String iwsSntkinfofsegkbn8;

    public String getIwsSntkinfofsegkbn8() {
        return iwsSntkinfofsegkbn8;
    }

    public void setIwsSntkinfofsegkbn8(String pIwsSntkinfofsegkbn8) {
        iwsSntkinfofsegkbn8 = pIwsSntkinfofsegkbn8;
    }

    @Column(order = 369, length = 2)
    private String iwsSntkinfofkojinkbn8;

    public String getIwsSntkinfofkojinkbn8() {
        return iwsSntkinfofkojinkbn8;
    }

    public void setIwsSntkinfofkojinkbn8(String pIwsSntkinfofkojinkbn8) {
        iwsSntkinfofkojinkbn8 = pIwsSntkinfofkojinkbn8;
    }

    @Column(order = 370, length = 2)
    private String iwsSntkinfokbn8;

    public String getIwsSntkinfokbn8() {
        return iwsSntkinfokbn8;
    }

    public void setIwsSntkinfokbn8(String pIwsSntkinfokbn8) {
        iwsSntkinfokbn8 = pIwsSntkinfokbn8;
    }

    @Column(order = 371, length = 8)
    private String iwsSntkinfosakuseiymd8;

    public String getIwsSntkinfosakuseiymd8() {
        return iwsSntkinfosakuseiymd8;
    }

    public void setIwsSntkinfosakuseiymd8(String pIwsSntkinfosakuseiymd8) {
        iwsSntkinfosakuseiymd8 = pIwsSntkinfosakuseiymd8;
    }

    @Column(order = 372, length = 1)
    private String iwsMrarihyj8;

    public String getIwsMrarihyj8() {
        return iwsMrarihyj8;
    }

    public void setIwsMrarihyj8(String pIwsMrarihyj8) {
        iwsMrarihyj8 = pIwsMrarihyj8;
    }

    @Column(order = 373, length = 1)
    private String iwsDecarihyj8;

    public String getIwsDecarihyj8() {
        return iwsDecarihyj8;
    }

    public void setIwsDecarihyj8(String pIwsDecarihyj8) {
        iwsDecarihyj8 = pIwsDecarihyj8;
    }

    @Column(order = 374, length = 1)
    private String iwsInfokoukanarihyj8;

    public String getIwsInfokoukanarihyj8() {
        return iwsInfokoukanarihyj8;
    }

    public void setIwsInfokoukanarihyj8(String pIwsInfokoukanarihyj8) {
        iwsInfokoukanarihyj8 = pIwsInfokoukanarihyj8;
    }

    @Column(order = 375, length = 1)
    private String iwsNyuuinkyhkshrarihyj8;

    public String getIwsNyuuinkyhkshrarihyj8() {
        return iwsNyuuinkyhkshrarihyj8;
    }

    public void setIwsNyuuinkyhkshrarihyj8(String pIwsNyuuinkyhkshrarihyj8) {
        iwsNyuuinkyhkshrarihyj8 = pIwsNyuuinkyhkshrarihyj8;
    }

    @Column(order = 376, length = 1)
    private String iwsSyujyutukyhkshrarihyj8;

    public String getIwsSyujyutukyhkshrarihyj8() {
        return iwsSyujyutukyhkshrarihyj8;
    }

    public void setIwsSyujyutukyhkshrarihyj8(String pIwsSyujyutukyhkshrarihyj8) {
        iwsSyujyutukyhkshrarihyj8 = pIwsSyujyutukyhkshrarihyj8;
    }

    @Column(order = 377, length = 1)
    private String iwsSyougaikyhkshrarihyj8;

    public String getIwsSyougaikyhkshrarihyj8() {
        return iwsSyougaikyhkshrarihyj8;
    }

    public void setIwsSyougaikyhkshrarihyj8(String pIwsSyougaikyhkshrarihyj8) {
        iwsSyougaikyhkshrarihyj8 = pIwsSyougaikyhkshrarihyj8;
    }

    @Column(order = 378, length = 1)
    private String iwsKoudosyougaiarihyj8;

    public String getIwsKoudosyougaiarihyj8() {
        return iwsKoudosyougaiarihyj8;
    }

    public void setIwsKoudosyougaiarihyj8(String pIwsKoudosyougaiarihyj8) {
        iwsKoudosyougaiarihyj8 = pIwsKoudosyougaiarihyj8;
    }

    @Column(order = 379, length = 1)
    private String iwsPmenarihyj8;

    public String getIwsPmenarihyj8() {
        return iwsPmenarihyj8;
    }

    public void setIwsPmenarihyj8(String pIwsPmenarihyj8) {
        iwsPmenarihyj8 = pIwsPmenarihyj8;
    }

    @Column(order = 380, length = 1)
    private String iwsTorikaijyoarihyj8;

    public String getIwsTorikaijyoarihyj8() {
        return iwsTorikaijyoarihyj8;
    }

    public void setIwsTorikaijyoarihyj8(String pIwsTorikaijyoarihyj8) {
        iwsTorikaijyoarihyj8 = pIwsTorikaijyoarihyj8;
    }

    @Column(order = 381, length = 1)
    private String iwsSoukikeakyhkshrarihyj8;

    public String getIwsSoukikeakyhkshrarihyj8() {
        return iwsSoukikeakyhkshrarihyj8;
    }

    public void setIwsSoukikeakyhkshrarihyj8(String pIwsSoukikeakyhkshrarihyj8) {
        iwsSoukikeakyhkshrarihyj8 = pIwsSoukikeakyhkshrarihyj8;
    }

    @Column(order = 382, length = 1)
    private String iwsSonotakyhkshrarihyj8;

    public String getIwsSonotakyhkshrarihyj8() {
        return iwsSonotakyhkshrarihyj8;
    }

    public void setIwsSonotakyhkshrarihyj8(String pIwsSonotakyhkshrarihyj8) {
        iwsSonotakyhkshrarihyj8 = pIwsSonotakyhkshrarihyj8;
    }

    @Column(order = 383, length = 1)
    private String iwsKghsjjtkyhkshrarihyj8;

    public String getIwsKghsjjtkyhkshrarihyj8() {
        return iwsKghsjjtkyhkshrarihyj8;
    }

    public void setIwsKghsjjtkyhkshrarihyj8(String pIwsKghsjjtkyhkshrarihyj8) {
        iwsKghsjjtkyhkshrarihyj8 = pIwsKghsjjtkyhkshrarihyj8;
    }

    @Column(order = 384, length = 1)
    private String iwsHuho2mrarihyj8;

    public String getIwsHuho2mrarihyj8() {
        return iwsHuho2mrarihyj8;
    }

    public void setIwsHuho2mrarihyj8(String pIwsHuho2mrarihyj8) {
        iwsHuho2mrarihyj8 = pIwsHuho2mrarihyj8;
    }

    @Column(order = 385, length = 1)
    private String iwsHuho2decarihyj8;

    public String getIwsHuho2decarihyj8() {
        return iwsHuho2decarihyj8;
    }

    public void setIwsHuho2decarihyj8(String pIwsHuho2decarihyj8) {
        iwsHuho2decarihyj8 = pIwsHuho2decarihyj8;
    }

    @Column(order = 386, length = 1)
    private String iwsHuho2kdarihyj8;

    public String getIwsHuho2kdarihyj8() {
        return iwsHuho2kdarihyj8;
    }

    public void setIwsHuho2kdarihyj8(String pIwsHuho2kdarihyj8) {
        iwsHuho2kdarihyj8 = pIwsHuho2kdarihyj8;
    }

    @Column(order = 387, length = 1)
    private String iwsHuho2torikaijyoarihyj8;

    public String getIwsHuho2torikaijyoarihyj8() {
        return iwsHuho2torikaijyoarihyj8;
    }

    public void setIwsHuho2torikaijyoarihyj8(String pIwsHuho2torikaijyoarihyj8) {
        iwsHuho2torikaijyoarihyj8 = pIwsHuho2torikaijyoarihyj8;
    }

    @Column(order = 388, length = 11)
    private String iwsSntkinfono9;

    public String getIwsSntkinfono9() {
        return iwsSntkinfono9;
    }

    public void setIwsSntkinfono9(String pIwsSntkinfono9) {
        iwsSntkinfono9 = pIwsSntkinfono9;
    }

    @Column(order = 389, length = 2)
    private String iwsSntkinfofsegkbn9;

    public String getIwsSntkinfofsegkbn9() {
        return iwsSntkinfofsegkbn9;
    }

    public void setIwsSntkinfofsegkbn9(String pIwsSntkinfofsegkbn9) {
        iwsSntkinfofsegkbn9 = pIwsSntkinfofsegkbn9;
    }

    @Column(order = 390, length = 2)
    private String iwsSntkinfofkojinkbn9;

    public String getIwsSntkinfofkojinkbn9() {
        return iwsSntkinfofkojinkbn9;
    }

    public void setIwsSntkinfofkojinkbn9(String pIwsSntkinfofkojinkbn9) {
        iwsSntkinfofkojinkbn9 = pIwsSntkinfofkojinkbn9;
    }

    @Column(order = 391, length = 2)
    private String iwsSntkinfokbn9;

    public String getIwsSntkinfokbn9() {
        return iwsSntkinfokbn9;
    }

    public void setIwsSntkinfokbn9(String pIwsSntkinfokbn9) {
        iwsSntkinfokbn9 = pIwsSntkinfokbn9;
    }

    @Column(order = 392, length = 8)
    private String iwsSntkinfosakuseiymd9;

    public String getIwsSntkinfosakuseiymd9() {
        return iwsSntkinfosakuseiymd9;
    }

    public void setIwsSntkinfosakuseiymd9(String pIwsSntkinfosakuseiymd9) {
        iwsSntkinfosakuseiymd9 = pIwsSntkinfosakuseiymd9;
    }

    @Column(order = 393, length = 1)
    private String iwsMrarihyj9;

    public String getIwsMrarihyj9() {
        return iwsMrarihyj9;
    }

    public void setIwsMrarihyj9(String pIwsMrarihyj9) {
        iwsMrarihyj9 = pIwsMrarihyj9;
    }

    @Column(order = 394, length = 1)
    private String iwsDecarihyj9;

    public String getIwsDecarihyj9() {
        return iwsDecarihyj9;
    }

    public void setIwsDecarihyj9(String pIwsDecarihyj9) {
        iwsDecarihyj9 = pIwsDecarihyj9;
    }

    @Column(order = 395, length = 1)
    private String iwsInfokoukanarihyj9;

    public String getIwsInfokoukanarihyj9() {
        return iwsInfokoukanarihyj9;
    }

    public void setIwsInfokoukanarihyj9(String pIwsInfokoukanarihyj9) {
        iwsInfokoukanarihyj9 = pIwsInfokoukanarihyj9;
    }

    @Column(order = 396, length = 1)
    private String iwsNyuuinkyhkshrarihyj9;

    public String getIwsNyuuinkyhkshrarihyj9() {
        return iwsNyuuinkyhkshrarihyj9;
    }

    public void setIwsNyuuinkyhkshrarihyj9(String pIwsNyuuinkyhkshrarihyj9) {
        iwsNyuuinkyhkshrarihyj9 = pIwsNyuuinkyhkshrarihyj9;
    }

    @Column(order = 397, length = 1)
    private String iwsSyujyutukyhkshrarihyj9;

    public String getIwsSyujyutukyhkshrarihyj9() {
        return iwsSyujyutukyhkshrarihyj9;
    }

    public void setIwsSyujyutukyhkshrarihyj9(String pIwsSyujyutukyhkshrarihyj9) {
        iwsSyujyutukyhkshrarihyj9 = pIwsSyujyutukyhkshrarihyj9;
    }

    @Column(order = 398, length = 1)
    private String iwsSyougaikyhkshrarihyj9;

    public String getIwsSyougaikyhkshrarihyj9() {
        return iwsSyougaikyhkshrarihyj9;
    }

    public void setIwsSyougaikyhkshrarihyj9(String pIwsSyougaikyhkshrarihyj9) {
        iwsSyougaikyhkshrarihyj9 = pIwsSyougaikyhkshrarihyj9;
    }

    @Column(order = 399, length = 1)
    private String iwsKoudosyougaiarihyj9;

    public String getIwsKoudosyougaiarihyj9() {
        return iwsKoudosyougaiarihyj9;
    }

    public void setIwsKoudosyougaiarihyj9(String pIwsKoudosyougaiarihyj9) {
        iwsKoudosyougaiarihyj9 = pIwsKoudosyougaiarihyj9;
    }

    @Column(order = 400, length = 1)
    private String iwsPmenarihyj9;

    public String getIwsPmenarihyj9() {
        return iwsPmenarihyj9;
    }

    public void setIwsPmenarihyj9(String pIwsPmenarihyj9) {
        iwsPmenarihyj9 = pIwsPmenarihyj9;
    }

    @Column(order = 401, length = 1)
    private String iwsTorikaijyoarihyj9;

    public String getIwsTorikaijyoarihyj9() {
        return iwsTorikaijyoarihyj9;
    }

    public void setIwsTorikaijyoarihyj9(String pIwsTorikaijyoarihyj9) {
        iwsTorikaijyoarihyj9 = pIwsTorikaijyoarihyj9;
    }

    @Column(order = 402, length = 1)
    private String iwsSoukikeakyhkshrarihyj9;

    public String getIwsSoukikeakyhkshrarihyj9() {
        return iwsSoukikeakyhkshrarihyj9;
    }

    public void setIwsSoukikeakyhkshrarihyj9(String pIwsSoukikeakyhkshrarihyj9) {
        iwsSoukikeakyhkshrarihyj9 = pIwsSoukikeakyhkshrarihyj9;
    }

    @Column(order = 403, length = 1)
    private String iwsSonotakyhkshrarihyj9;

    public String getIwsSonotakyhkshrarihyj9() {
        return iwsSonotakyhkshrarihyj9;
    }

    public void setIwsSonotakyhkshrarihyj9(String pIwsSonotakyhkshrarihyj9) {
        iwsSonotakyhkshrarihyj9 = pIwsSonotakyhkshrarihyj9;
    }

    @Column(order = 404, length = 1)
    private String iwsKghsjjtkyhkshrarihyj9;

    public String getIwsKghsjjtkyhkshrarihyj9() {
        return iwsKghsjjtkyhkshrarihyj9;
    }

    public void setIwsKghsjjtkyhkshrarihyj9(String pIwsKghsjjtkyhkshrarihyj9) {
        iwsKghsjjtkyhkshrarihyj9 = pIwsKghsjjtkyhkshrarihyj9;
    }

    @Column(order = 405, length = 1)
    private String iwsHuho2mrarihyj9;

    public String getIwsHuho2mrarihyj9() {
        return iwsHuho2mrarihyj9;
    }

    public void setIwsHuho2mrarihyj9(String pIwsHuho2mrarihyj9) {
        iwsHuho2mrarihyj9 = pIwsHuho2mrarihyj9;
    }

    @Column(order = 406, length = 1)
    private String iwsHuho2decarihyj9;

    public String getIwsHuho2decarihyj9() {
        return iwsHuho2decarihyj9;
    }

    public void setIwsHuho2decarihyj9(String pIwsHuho2decarihyj9) {
        iwsHuho2decarihyj9 = pIwsHuho2decarihyj9;
    }

    @Column(order = 407, length = 1)
    private String iwsHuho2kdarihyj9;

    public String getIwsHuho2kdarihyj9() {
        return iwsHuho2kdarihyj9;
    }

    public void setIwsHuho2kdarihyj9(String pIwsHuho2kdarihyj9) {
        iwsHuho2kdarihyj9 = pIwsHuho2kdarihyj9;
    }

    @Column(order = 408, length = 1)
    private String iwsHuho2torikaijyoarihyj9;

    public String getIwsHuho2torikaijyoarihyj9() {
        return iwsHuho2torikaijyoarihyj9;
    }

    public void setIwsHuho2torikaijyoarihyj9(String pIwsHuho2torikaijyoarihyj9) {
        iwsHuho2torikaijyoarihyj9 = pIwsHuho2torikaijyoarihyj9;
    }

    @Column(order = 409, length = 11)
    private String iwsSntkinfono10;

    public String getIwsSntkinfono10() {
        return iwsSntkinfono10;
    }

    public void setIwsSntkinfono10(String pIwsSntkinfono10) {
        iwsSntkinfono10 = pIwsSntkinfono10;
    }

    @Column(order = 410, length = 2)
    private String iwsSntkinfofsegkbn10;

    public String getIwsSntkinfofsegkbn10() {
        return iwsSntkinfofsegkbn10;
    }

    public void setIwsSntkinfofsegkbn10(String pIwsSntkinfofsegkbn10) {
        iwsSntkinfofsegkbn10 = pIwsSntkinfofsegkbn10;
    }

    @Column(order = 411, length = 2)
    private String iwsSntkinfofkojinkbn10;

    public String getIwsSntkinfofkojinkbn10() {
        return iwsSntkinfofkojinkbn10;
    }

    public void setIwsSntkinfofkojinkbn10(String pIwsSntkinfofkojinkbn10) {
        iwsSntkinfofkojinkbn10 = pIwsSntkinfofkojinkbn10;
    }

    @Column(order = 412, length = 2)
    private String iwsSntkinfokbn10;

    public String getIwsSntkinfokbn10() {
        return iwsSntkinfokbn10;
    }

    public void setIwsSntkinfokbn10(String pIwsSntkinfokbn10) {
        iwsSntkinfokbn10 = pIwsSntkinfokbn10;
    }

    @Column(order = 413, length = 8)
    private String iwsSntkinfosakuseiymd10;

    public String getIwsSntkinfosakuseiymd10() {
        return iwsSntkinfosakuseiymd10;
    }

    public void setIwsSntkinfosakuseiymd10(String pIwsSntkinfosakuseiymd10) {
        iwsSntkinfosakuseiymd10 = pIwsSntkinfosakuseiymd10;
    }

    @Column(order = 414, length = 1)
    private String iwsMrarihyj10;

    public String getIwsMrarihyj10() {
        return iwsMrarihyj10;
    }

    public void setIwsMrarihyj10(String pIwsMrarihyj10) {
        iwsMrarihyj10 = pIwsMrarihyj10;
    }

    @Column(order = 415, length = 1)
    private String iwsDecarihyj10;

    public String getIwsDecarihyj10() {
        return iwsDecarihyj10;
    }

    public void setIwsDecarihyj10(String pIwsDecarihyj10) {
        iwsDecarihyj10 = pIwsDecarihyj10;
    }

    @Column(order = 416, length = 1)
    private String iwsInfokoukanarihyj10;

    public String getIwsInfokoukanarihyj10() {
        return iwsInfokoukanarihyj10;
    }

    public void setIwsInfokoukanarihyj10(String pIwsInfokoukanarihyj10) {
        iwsInfokoukanarihyj10 = pIwsInfokoukanarihyj10;
    }

    @Column(order = 417, length = 1)
    private String iwsNyuuinkyhkshrarihyj10;

    public String getIwsNyuuinkyhkshrarihyj10() {
        return iwsNyuuinkyhkshrarihyj10;
    }

    public void setIwsNyuuinkyhkshrarihyj10(String pIwsNyuuinkyhkshrarihyj10) {
        iwsNyuuinkyhkshrarihyj10 = pIwsNyuuinkyhkshrarihyj10;
    }

    @Column(order = 418, length = 1)
    private String iwsSyujyutukyhkshrarihyj10;

    public String getIwsSyujyutukyhkshrarihyj10() {
        return iwsSyujyutukyhkshrarihyj10;
    }

    public void setIwsSyujyutukyhkshrarihyj10(String pIwsSyujyutukyhkshrarihyj10) {
        iwsSyujyutukyhkshrarihyj10 = pIwsSyujyutukyhkshrarihyj10;
    }

    @Column(order = 419, length = 1)
    private String iwsSyougaikyhkshrarihyj10;

    public String getIwsSyougaikyhkshrarihyj10() {
        return iwsSyougaikyhkshrarihyj10;
    }

    public void setIwsSyougaikyhkshrarihyj10(String pIwsSyougaikyhkshrarihyj10) {
        iwsSyougaikyhkshrarihyj10 = pIwsSyougaikyhkshrarihyj10;
    }

    @Column(order = 420, length = 1)
    private String iwsKoudosyougaiarihyj10;

    public String getIwsKoudosyougaiarihyj10() {
        return iwsKoudosyougaiarihyj10;
    }

    public void setIwsKoudosyougaiarihyj10(String pIwsKoudosyougaiarihyj10) {
        iwsKoudosyougaiarihyj10 = pIwsKoudosyougaiarihyj10;
    }

    @Column(order = 421, length = 1)
    private String iwsPmenarihyj10;

    public String getIwsPmenarihyj10() {
        return iwsPmenarihyj10;
    }

    public void setIwsPmenarihyj10(String pIwsPmenarihyj10) {
        iwsPmenarihyj10 = pIwsPmenarihyj10;
    }

    @Column(order = 422, length = 1)
    private String iwsTorikaijyoarihyj10;

    public String getIwsTorikaijyoarihyj10() {
        return iwsTorikaijyoarihyj10;
    }

    public void setIwsTorikaijyoarihyj10(String pIwsTorikaijyoarihyj10) {
        iwsTorikaijyoarihyj10 = pIwsTorikaijyoarihyj10;
    }

    @Column(order = 423, length = 1)
    private String iwsSoukikeakyhkshrarihyj10;

    public String getIwsSoukikeakyhkshrarihyj10() {
        return iwsSoukikeakyhkshrarihyj10;
    }

    public void setIwsSoukikeakyhkshrarihyj10(String pIwsSoukikeakyhkshrarihyj10) {
        iwsSoukikeakyhkshrarihyj10 = pIwsSoukikeakyhkshrarihyj10;
    }

    @Column(order = 424, length = 1)
    private String iwsSonotakyhkshrarihyj10;

    public String getIwsSonotakyhkshrarihyj10() {
        return iwsSonotakyhkshrarihyj10;
    }

    public void setIwsSonotakyhkshrarihyj10(String pIwsSonotakyhkshrarihyj10) {
        iwsSonotakyhkshrarihyj10 = pIwsSonotakyhkshrarihyj10;
    }

    @Column(order = 425, length = 1)
    private String iwsKghsjjtkyhkshrarihyj10;

    public String getIwsKghsjjtkyhkshrarihyj10() {
        return iwsKghsjjtkyhkshrarihyj10;
    }

    public void setIwsKghsjjtkyhkshrarihyj10(String pIwsKghsjjtkyhkshrarihyj10) {
        iwsKghsjjtkyhkshrarihyj10 = pIwsKghsjjtkyhkshrarihyj10;
    }

    @Column(order = 426, length = 1)
    private String iwsHuho2mrarihyj10;

    public String getIwsHuho2mrarihyj10() {
        return iwsHuho2mrarihyj10;
    }

    public void setIwsHuho2mrarihyj10(String pIwsHuho2mrarihyj10) {
        iwsHuho2mrarihyj10 = pIwsHuho2mrarihyj10;
    }

    @Column(order = 427, length = 1)
    private String iwsHuho2decarihyj10;

    public String getIwsHuho2decarihyj10() {
        return iwsHuho2decarihyj10;
    }

    public void setIwsHuho2decarihyj10(String pIwsHuho2decarihyj10) {
        iwsHuho2decarihyj10 = pIwsHuho2decarihyj10;
    }

    @Column(order = 428, length = 1)
    private String iwsHuho2kdarihyj10;

    public String getIwsHuho2kdarihyj10() {
        return iwsHuho2kdarihyj10;
    }

    public void setIwsHuho2kdarihyj10(String pIwsHuho2kdarihyj10) {
        iwsHuho2kdarihyj10 = pIwsHuho2kdarihyj10;
    }

    @Column(order = 429, length = 1)
    private String iwsHuho2torikaijyoarihyj10;

    public String getIwsHuho2torikaijyoarihyj10() {
        return iwsHuho2torikaijyoarihyj10;
    }

    public void setIwsHuho2torikaijyoarihyj10(String pIwsHuho2torikaijyoarihyj10) {
        iwsHuho2torikaijyoarihyj10 = pIwsHuho2torikaijyoarihyj10;
    }

    @Column(order = 430, length = 11)
    private String iwsSueokifsysyno1;

    public String getIwsSueokifsysyno1() {
        return iwsSueokifsysyno1;
    }

    public void setIwsSueokifsysyno1(String pIwsSueokifsysyno1) {
        iwsSueokifsysyno1 = pIwsSueokifsysyno1;
    }

    @Column(order = 431, length = 2)
    private String iwsSueokifhknkinfsegkbn1;

    public String getIwsSueokifhknkinfsegkbn1() {
        return iwsSueokifhknkinfsegkbn1;
    }

    public void setIwsSueokifhknkinfsegkbn1(String pIwsSueokifhknkinfsegkbn1) {
        iwsSueokifhknkinfsegkbn1 = pIwsSueokifhknkinfsegkbn1;
    }

    @Column(order = 432, length = 2)
    private String iwsSueokifhknkinkojinkbn1;

    public String getIwsSueokifhknkinkojinkbn1() {
        return iwsSueokifhknkinkojinkbn1;
    }

    public void setIwsSueokifhknkinkojinkbn1(String pIwsSueokifhknkinkojinkbn1) {
        iwsSueokifhknkinkojinkbn1 = pIwsSueokifhknkinkojinkbn1;
    }

    @Column(order = 433, length = 1)
    private String iwsSueokifsueokijtkbn1;

    public String getIwsSueokifsueokijtkbn1() {
        return iwsSueokifsueokijtkbn1;
    }

    public void setIwsSueokifsueokijtkbn1(String pIwsSueokifsueokijtkbn1) {
        iwsSueokifsueokijtkbn1 = pIwsSueokifsueokijtkbn1;
    }

    @Column(order = 434, length = 8)
    private String iwsSueokifsueokikaisiymd1;

    public String getIwsSueokifsueokikaisiymd1() {
        return iwsSueokifsueokikaisiymd1;
    }

    public void setIwsSueokifsueokikaisiymd1(String pIwsSueokifsueokikaisiymd1) {
        iwsSueokifsueokikaisiymd1 = pIwsSueokifsueokikaisiymd1;
    }

    @Column(order = 435, length = 2)
    private String iwsSueokifsueokikkn1;

    public String getIwsSueokifsueokikkn1() {
        return iwsSueokifsueokikkn1;
    }

    public void setIwsSueokifsueokikkn1(String pIwsSueokifsueokikkn1) {
        iwsSueokifsueokikkn1 = pIwsSueokifsueokikkn1;
    }

    @Column(order = 436, length = 8)
    private String iwsSueokifuktseiymd1;

    public String getIwsSueokifuktseiymd1() {
        return iwsSueokifuktseiymd1;
    }

    public void setIwsSueokifuktseiymd1(String pIwsSueokifuktseiymd1) {
        iwsSueokifuktseiymd1 = pIwsSueokifuktseiymd1;
    }

    @Column(order = 437, length = 11)
    private String iwsSueokifsysyno2;

    public String getIwsSueokifsysyno2() {
        return iwsSueokifsysyno2;
    }

    public void setIwsSueokifsysyno2(String pIwsSueokifsysyno2) {
        iwsSueokifsysyno2 = pIwsSueokifsysyno2;
    }

    @Column(order = 438, length = 2)
    private String iwsSueokifhknkinfsegkbn2;

    public String getIwsSueokifhknkinfsegkbn2() {
        return iwsSueokifhknkinfsegkbn2;
    }

    public void setIwsSueokifhknkinfsegkbn2(String pIwsSueokifhknkinfsegkbn2) {
        iwsSueokifhknkinfsegkbn2 = pIwsSueokifhknkinfsegkbn2;
    }

    @Column(order = 439, length = 2)
    private String iwsSueokifhknkinkojinkbn2;

    public String getIwsSueokifhknkinkojinkbn2() {
        return iwsSueokifhknkinkojinkbn2;
    }

    public void setIwsSueokifhknkinkojinkbn2(String pIwsSueokifhknkinkojinkbn2) {
        iwsSueokifhknkinkojinkbn2 = pIwsSueokifhknkinkojinkbn2;
    }

    @Column(order = 440, length = 1)
    private String iwsSueokifsueokijtkbn2;

    public String getIwsSueokifsueokijtkbn2() {
        return iwsSueokifsueokijtkbn2;
    }

    public void setIwsSueokifsueokijtkbn2(String pIwsSueokifsueokijtkbn2) {
        iwsSueokifsueokijtkbn2 = pIwsSueokifsueokijtkbn2;
    }

    @Column(order = 441, length = 8)
    private String iwsSueokifsueokikaisiymd2;

    public String getIwsSueokifsueokikaisiymd2() {
        return iwsSueokifsueokikaisiymd2;
    }

    public void setIwsSueokifsueokikaisiymd2(String pIwsSueokifsueokikaisiymd2) {
        iwsSueokifsueokikaisiymd2 = pIwsSueokifsueokikaisiymd2;
    }

    @Column(order = 442, length = 2)
    private String iwsSueokifsueokikkn2;

    public String getIwsSueokifsueokikkn2() {
        return iwsSueokifsueokikkn2;
    }

    public void setIwsSueokifsueokikkn2(String pIwsSueokifsueokikkn2) {
        iwsSueokifsueokikkn2 = pIwsSueokifsueokikkn2;
    }

    @Column(order = 443, length = 8)
    private String iwsSueokifuktseiymd2;

    public String getIwsSueokifuktseiymd2() {
        return iwsSueokifuktseiymd2;
    }

    public void setIwsSueokifuktseiymd2(String pIwsSueokifuktseiymd2) {
        iwsSueokifuktseiymd2 = pIwsSueokifuktseiymd2;
    }

    @Column(order = 444, length = 11)
    private String iwsSueokifsysyno3;

    public String getIwsSueokifsysyno3() {
        return iwsSueokifsysyno3;
    }

    public void setIwsSueokifsysyno3(String pIwsSueokifsysyno3) {
        iwsSueokifsysyno3 = pIwsSueokifsysyno3;
    }

    @Column(order = 445, length = 2)
    private String iwsSueokifhknkinfsegkbn3;

    public String getIwsSueokifhknkinfsegkbn3() {
        return iwsSueokifhknkinfsegkbn3;
    }

    public void setIwsSueokifhknkinfsegkbn3(String pIwsSueokifhknkinfsegkbn3) {
        iwsSueokifhknkinfsegkbn3 = pIwsSueokifhknkinfsegkbn3;
    }

    @Column(order = 446, length = 2)
    private String iwsSueokifhknkinkojinkbn3;

    public String getIwsSueokifhknkinkojinkbn3() {
        return iwsSueokifhknkinkojinkbn3;
    }

    public void setIwsSueokifhknkinkojinkbn3(String pIwsSueokifhknkinkojinkbn3) {
        iwsSueokifhknkinkojinkbn3 = pIwsSueokifhknkinkojinkbn3;
    }

    @Column(order = 447, length = 1)
    private String iwsSueokifsueokijtkbn3;

    public String getIwsSueokifsueokijtkbn3() {
        return iwsSueokifsueokijtkbn3;
    }

    public void setIwsSueokifsueokijtkbn3(String pIwsSueokifsueokijtkbn3) {
        iwsSueokifsueokijtkbn3 = pIwsSueokifsueokijtkbn3;
    }

    @Column(order = 448, length = 8)
    private String iwsSueokifsueokikaisiymd3;

    public String getIwsSueokifsueokikaisiymd3() {
        return iwsSueokifsueokikaisiymd3;
    }

    public void setIwsSueokifsueokikaisiymd3(String pIwsSueokifsueokikaisiymd3) {
        iwsSueokifsueokikaisiymd3 = pIwsSueokifsueokikaisiymd3;
    }

    @Column(order = 449, length = 2)
    private String iwsSueokifsueokikkn3;

    public String getIwsSueokifsueokikkn3() {
        return iwsSueokifsueokikkn3;
    }

    public void setIwsSueokifsueokikkn3(String pIwsSueokifsueokikkn3) {
        iwsSueokifsueokikkn3 = pIwsSueokifsueokikkn3;
    }

    @Column(order = 450, length = 8)
    private String iwsSueokifuktseiymd3;

    public String getIwsSueokifuktseiymd3() {
        return iwsSueokifuktseiymd3;
    }

    public void setIwsSueokifuktseiymd3(String pIwsSueokifuktseiymd3) {
        iwsSueokifuktseiymd3 = pIwsSueokifuktseiymd3;
    }

    @Column(order = 451, length = 11)
    private String iwsSueokifsysyno4;

    public String getIwsSueokifsysyno4() {
        return iwsSueokifsysyno4;
    }

    public void setIwsSueokifsysyno4(String pIwsSueokifsysyno4) {
        iwsSueokifsysyno4 = pIwsSueokifsysyno4;
    }

    @Column(order = 452, length = 2)
    private String iwsSueokifhknkinfsegkbn4;

    public String getIwsSueokifhknkinfsegkbn4() {
        return iwsSueokifhknkinfsegkbn4;
    }

    public void setIwsSueokifhknkinfsegkbn4(String pIwsSueokifhknkinfsegkbn4) {
        iwsSueokifhknkinfsegkbn4 = pIwsSueokifhknkinfsegkbn4;
    }

    @Column(order = 453, length = 2)
    private String iwsSueokifhknkinkojinkbn4;

    public String getIwsSueokifhknkinkojinkbn4() {
        return iwsSueokifhknkinkojinkbn4;
    }

    public void setIwsSueokifhknkinkojinkbn4(String pIwsSueokifhknkinkojinkbn4) {
        iwsSueokifhknkinkojinkbn4 = pIwsSueokifhknkinkojinkbn4;
    }

    @Column(order = 454, length = 1)
    private String iwsSueokifsueokijtkbn4;

    public String getIwsSueokifsueokijtkbn4() {
        return iwsSueokifsueokijtkbn4;
    }

    public void setIwsSueokifsueokijtkbn4(String pIwsSueokifsueokijtkbn4) {
        iwsSueokifsueokijtkbn4 = pIwsSueokifsueokijtkbn4;
    }

    @Column(order = 455, length = 8)
    private String iwsSueokifsueokikaisiymd4;

    public String getIwsSueokifsueokikaisiymd4() {
        return iwsSueokifsueokikaisiymd4;
    }

    public void setIwsSueokifsueokikaisiymd4(String pIwsSueokifsueokikaisiymd4) {
        iwsSueokifsueokikaisiymd4 = pIwsSueokifsueokikaisiymd4;
    }

    @Column(order = 456, length = 2)
    private String iwsSueokifsueokikkn4;

    public String getIwsSueokifsueokikkn4() {
        return iwsSueokifsueokikkn4;
    }

    public void setIwsSueokifsueokikkn4(String pIwsSueokifsueokikkn4) {
        iwsSueokifsueokikkn4 = pIwsSueokifsueokikkn4;
    }

    @Column(order = 457, length = 8)
    private String iwsSueokifuktseiymd4;

    public String getIwsSueokifuktseiymd4() {
        return iwsSueokifuktseiymd4;
    }

    public void setIwsSueokifuktseiymd4(String pIwsSueokifuktseiymd4) {
        iwsSueokifuktseiymd4 = pIwsSueokifuktseiymd4;
    }

    @Column(order = 458, length = 11)
    private String iwsSueokifsysyno5;

    public String getIwsSueokifsysyno5() {
        return iwsSueokifsysyno5;
    }

    public void setIwsSueokifsysyno5(String pIwsSueokifsysyno5) {
        iwsSueokifsysyno5 = pIwsSueokifsysyno5;
    }

    @Column(order = 459, length = 2)
    private String iwsSueokifhknkinfsegkbn5;

    public String getIwsSueokifhknkinfsegkbn5() {
        return iwsSueokifhknkinfsegkbn5;
    }

    public void setIwsSueokifhknkinfsegkbn5(String pIwsSueokifhknkinfsegkbn5) {
        iwsSueokifhknkinfsegkbn5 = pIwsSueokifhknkinfsegkbn5;
    }

    @Column(order = 460, length = 2)
    private String iwsSueokifhknkinkojinkbn5;

    public String getIwsSueokifhknkinkojinkbn5() {
        return iwsSueokifhknkinkojinkbn5;
    }

    public void setIwsSueokifhknkinkojinkbn5(String pIwsSueokifhknkinkojinkbn5) {
        iwsSueokifhknkinkojinkbn5 = pIwsSueokifhknkinkojinkbn5;
    }

    @Column(order = 461, length = 1)
    private String iwsSueokifsueokijtkbn5;

    public String getIwsSueokifsueokijtkbn5() {
        return iwsSueokifsueokijtkbn5;
    }

    public void setIwsSueokifsueokijtkbn5(String pIwsSueokifsueokijtkbn5) {
        iwsSueokifsueokijtkbn5 = pIwsSueokifsueokijtkbn5;
    }

    @Column(order = 462, length = 8)
    private String iwsSueokifsueokikaisiymd5;

    public String getIwsSueokifsueokikaisiymd5() {
        return iwsSueokifsueokikaisiymd5;
    }

    public void setIwsSueokifsueokikaisiymd5(String pIwsSueokifsueokikaisiymd5) {
        iwsSueokifsueokikaisiymd5 = pIwsSueokifsueokikaisiymd5;
    }

    @Column(order = 463, length = 2)
    private String iwsSueokifsueokikkn5;

    public String getIwsSueokifsueokikkn5() {
        return iwsSueokifsueokikkn5;
    }

    public void setIwsSueokifsueokikkn5(String pIwsSueokifsueokikkn5) {
        iwsSueokifsueokikkn5 = pIwsSueokifsueokikkn5;
    }

    @Column(order = 464, length = 8)
    private String iwsSueokifuktseiymd5;

    public String getIwsSueokifuktseiymd5() {
        return iwsSueokifuktseiymd5;
    }

    public void setIwsSueokifuktseiymd5(String pIwsSueokifuktseiymd5) {
        iwsSueokifuktseiymd5 = pIwsSueokifuktseiymd5;
    }

    @Column(order = 465, length = 11)
    private String iwsSueokifsysyno6;

    public String getIwsSueokifsysyno6() {
        return iwsSueokifsysyno6;
    }

    public void setIwsSueokifsysyno6(String pIwsSueokifsysyno6) {
        iwsSueokifsysyno6 = pIwsSueokifsysyno6;
    }

    @Column(order = 466, length = 2)
    private String iwsSueokifhknkinfsegkbn6;

    public String getIwsSueokifhknkinfsegkbn6() {
        return iwsSueokifhknkinfsegkbn6;
    }

    public void setIwsSueokifhknkinfsegkbn6(String pIwsSueokifhknkinfsegkbn6) {
        iwsSueokifhknkinfsegkbn6 = pIwsSueokifhknkinfsegkbn6;
    }

    @Column(order = 467, length = 2)
    private String iwsSueokifhknkinkojinkbn6;

    public String getIwsSueokifhknkinkojinkbn6() {
        return iwsSueokifhknkinkojinkbn6;
    }

    public void setIwsSueokifhknkinkojinkbn6(String pIwsSueokifhknkinkojinkbn6) {
        iwsSueokifhknkinkojinkbn6 = pIwsSueokifhknkinkojinkbn6;
    }

    @Column(order = 468, length = 1)
    private String iwsSueokifsueokijtkbn6;

    public String getIwsSueokifsueokijtkbn6() {
        return iwsSueokifsueokijtkbn6;
    }

    public void setIwsSueokifsueokijtkbn6(String pIwsSueokifsueokijtkbn6) {
        iwsSueokifsueokijtkbn6 = pIwsSueokifsueokijtkbn6;
    }

    @Column(order = 469, length = 8)
    private String iwsSueokifsueokikaisiymd6;

    public String getIwsSueokifsueokikaisiymd6() {
        return iwsSueokifsueokikaisiymd6;
    }

    public void setIwsSueokifsueokikaisiymd6(String pIwsSueokifsueokikaisiymd6) {
        iwsSueokifsueokikaisiymd6 = pIwsSueokifsueokikaisiymd6;
    }

    @Column(order = 470, length = 2)
    private String iwsSueokifsueokikkn6;

    public String getIwsSueokifsueokikkn6() {
        return iwsSueokifsueokikkn6;
    }

    public void setIwsSueokifsueokikkn6(String pIwsSueokifsueokikkn6) {
        iwsSueokifsueokikkn6 = pIwsSueokifsueokikkn6;
    }

    @Column(order = 471, length = 8)
    private String iwsSueokifuktseiymd6;

    public String getIwsSueokifuktseiymd6() {
        return iwsSueokifuktseiymd6;
    }

    public void setIwsSueokifuktseiymd6(String pIwsSueokifuktseiymd6) {
        iwsSueokifuktseiymd6 = pIwsSueokifuktseiymd6;
    }

    @Column(order = 472, length = 11)
    private String iwsSueokifsysyno7;

    public String getIwsSueokifsysyno7() {
        return iwsSueokifsysyno7;
    }

    public void setIwsSueokifsysyno7(String pIwsSueokifsysyno7) {
        iwsSueokifsysyno7 = pIwsSueokifsysyno7;
    }

    @Column(order = 473, length = 2)
    private String iwsSueokifhknkinfsegkbn7;

    public String getIwsSueokifhknkinfsegkbn7() {
        return iwsSueokifhknkinfsegkbn7;
    }

    public void setIwsSueokifhknkinfsegkbn7(String pIwsSueokifhknkinfsegkbn7) {
        iwsSueokifhknkinfsegkbn7 = pIwsSueokifhknkinfsegkbn7;
    }

    @Column(order = 474, length = 2)
    private String iwsSueokifhknkinkojinkbn7;

    public String getIwsSueokifhknkinkojinkbn7() {
        return iwsSueokifhknkinkojinkbn7;
    }

    public void setIwsSueokifhknkinkojinkbn7(String pIwsSueokifhknkinkojinkbn7) {
        iwsSueokifhknkinkojinkbn7 = pIwsSueokifhknkinkojinkbn7;
    }

    @Column(order = 475, length = 1)
    private String iwsSueokifsueokijtkbn7;

    public String getIwsSueokifsueokijtkbn7() {
        return iwsSueokifsueokijtkbn7;
    }

    public void setIwsSueokifsueokijtkbn7(String pIwsSueokifsueokijtkbn7) {
        iwsSueokifsueokijtkbn7 = pIwsSueokifsueokijtkbn7;
    }

    @Column(order = 476, length = 8)
    private String iwsSueokifsueokikaisiymd7;

    public String getIwsSueokifsueokikaisiymd7() {
        return iwsSueokifsueokikaisiymd7;
    }

    public void setIwsSueokifsueokikaisiymd7(String pIwsSueokifsueokikaisiymd7) {
        iwsSueokifsueokikaisiymd7 = pIwsSueokifsueokikaisiymd7;
    }

    @Column(order = 477, length = 2)
    private String iwsSueokifsueokikkn7;

    public String getIwsSueokifsueokikkn7() {
        return iwsSueokifsueokikkn7;
    }

    public void setIwsSueokifsueokikkn7(String pIwsSueokifsueokikkn7) {
        iwsSueokifsueokikkn7 = pIwsSueokifsueokikkn7;
    }

    @Column(order = 478, length = 8)
    private String iwsSueokifuktseiymd7;

    public String getIwsSueokifuktseiymd7() {
        return iwsSueokifuktseiymd7;
    }

    public void setIwsSueokifuktseiymd7(String pIwsSueokifuktseiymd7) {
        iwsSueokifuktseiymd7 = pIwsSueokifuktseiymd7;
    }

    @Column(order = 479, length = 11)
    private String iwsSueokifsysyno8;

    public String getIwsSueokifsysyno8() {
        return iwsSueokifsysyno8;
    }

    public void setIwsSueokifsysyno8(String pIwsSueokifsysyno8) {
        iwsSueokifsysyno8 = pIwsSueokifsysyno8;
    }

    @Column(order = 480, length = 2)
    private String iwsSueokifhknkinfsegkbn8;

    public String getIwsSueokifhknkinfsegkbn8() {
        return iwsSueokifhknkinfsegkbn8;
    }

    public void setIwsSueokifhknkinfsegkbn8(String pIwsSueokifhknkinfsegkbn8) {
        iwsSueokifhknkinfsegkbn8 = pIwsSueokifhknkinfsegkbn8;
    }

    @Column(order = 481, length = 2)
    private String iwsSueokifhknkinkojinkbn8;

    public String getIwsSueokifhknkinkojinkbn8() {
        return iwsSueokifhknkinkojinkbn8;
    }

    public void setIwsSueokifhknkinkojinkbn8(String pIwsSueokifhknkinkojinkbn8) {
        iwsSueokifhknkinkojinkbn8 = pIwsSueokifhknkinkojinkbn8;
    }

    @Column(order = 482, length = 1)
    private String iwsSueokifsueokijtkbn8;

    public String getIwsSueokifsueokijtkbn8() {
        return iwsSueokifsueokijtkbn8;
    }

    public void setIwsSueokifsueokijtkbn8(String pIwsSueokifsueokijtkbn8) {
        iwsSueokifsueokijtkbn8 = pIwsSueokifsueokijtkbn8;
    }

    @Column(order = 483, length = 8)
    private String iwsSueokifsueokikaisiymd8;

    public String getIwsSueokifsueokikaisiymd8() {
        return iwsSueokifsueokikaisiymd8;
    }

    public void setIwsSueokifsueokikaisiymd8(String pIwsSueokifsueokikaisiymd8) {
        iwsSueokifsueokikaisiymd8 = pIwsSueokifsueokikaisiymd8;
    }

    @Column(order = 484, length = 2)
    private String iwsSueokifsueokikkn8;

    public String getIwsSueokifsueokikkn8() {
        return iwsSueokifsueokikkn8;
    }

    public void setIwsSueokifsueokikkn8(String pIwsSueokifsueokikkn8) {
        iwsSueokifsueokikkn8 = pIwsSueokifsueokikkn8;
    }

    @Column(order = 485, length = 8)
    private String iwsSueokifuktseiymd8;

    public String getIwsSueokifuktseiymd8() {
        return iwsSueokifuktseiymd8;
    }

    public void setIwsSueokifuktseiymd8(String pIwsSueokifuktseiymd8) {
        iwsSueokifuktseiymd8 = pIwsSueokifuktseiymd8;
    }

    @Column(order = 486, length = 11)
    private String iwsSueokifsysyno9;

    public String getIwsSueokifsysyno9() {
        return iwsSueokifsysyno9;
    }

    public void setIwsSueokifsysyno9(String pIwsSueokifsysyno9) {
        iwsSueokifsysyno9 = pIwsSueokifsysyno9;
    }

    @Column(order = 487, length = 2)
    private String iwsSueokifhknkinfsegkbn9;

    public String getIwsSueokifhknkinfsegkbn9() {
        return iwsSueokifhknkinfsegkbn9;
    }

    public void setIwsSueokifhknkinfsegkbn9(String pIwsSueokifhknkinfsegkbn9) {
        iwsSueokifhknkinfsegkbn9 = pIwsSueokifhknkinfsegkbn9;
    }

    @Column(order = 488, length = 2)
    private String iwsSueokifhknkinkojinkbn9;

    public String getIwsSueokifhknkinkojinkbn9() {
        return iwsSueokifhknkinkojinkbn9;
    }

    public void setIwsSueokifhknkinkojinkbn9(String pIwsSueokifhknkinkojinkbn9) {
        iwsSueokifhknkinkojinkbn9 = pIwsSueokifhknkinkojinkbn9;
    }

    @Column(order = 489, length = 1)
    private String iwsSueokifsueokijtkbn9;

    public String getIwsSueokifsueokijtkbn9() {
        return iwsSueokifsueokijtkbn9;
    }

    public void setIwsSueokifsueokijtkbn9(String pIwsSueokifsueokijtkbn9) {
        iwsSueokifsueokijtkbn9 = pIwsSueokifsueokijtkbn9;
    }

    @Column(order = 490, length = 8)
    private String iwsSueokifsueokikaisiymd9;

    public String getIwsSueokifsueokikaisiymd9() {
        return iwsSueokifsueokikaisiymd9;
    }

    public void setIwsSueokifsueokikaisiymd9(String pIwsSueokifsueokikaisiymd9) {
        iwsSueokifsueokikaisiymd9 = pIwsSueokifsueokikaisiymd9;
    }

    @Column(order = 491, length = 2)
    private String iwsSueokifsueokikkn9;

    public String getIwsSueokifsueokikkn9() {
        return iwsSueokifsueokikkn9;
    }

    public void setIwsSueokifsueokikkn9(String pIwsSueokifsueokikkn9) {
        iwsSueokifsueokikkn9 = pIwsSueokifsueokikkn9;
    }

    @Column(order = 492, length = 8)
    private String iwsSueokifuktseiymd9;

    public String getIwsSueokifuktseiymd9() {
        return iwsSueokifuktseiymd9;
    }

    public void setIwsSueokifuktseiymd9(String pIwsSueokifuktseiymd9) {
        iwsSueokifuktseiymd9 = pIwsSueokifuktseiymd9;
    }

    @Column(order = 493, length = 11)
    private String iwsSueokifsysyno10;

    public String getIwsSueokifsysyno10() {
        return iwsSueokifsysyno10;
    }

    public void setIwsSueokifsysyno10(String pIwsSueokifsysyno10) {
        iwsSueokifsysyno10 = pIwsSueokifsysyno10;
    }

    @Column(order = 494, length = 2)
    private String iwsSueokifhknkinfsegkbn10;

    public String getIwsSueokifhknkinfsegkbn10() {
        return iwsSueokifhknkinfsegkbn10;
    }

    public void setIwsSueokifhknkinfsegkbn10(String pIwsSueokifhknkinfsegkbn10) {
        iwsSueokifhknkinfsegkbn10 = pIwsSueokifhknkinfsegkbn10;
    }

    @Column(order = 495, length = 2)
    private String iwsSueokifhknkinkojinkbn10;

    public String getIwsSueokifhknkinkojinkbn10() {
        return iwsSueokifhknkinkojinkbn10;
    }

    public void setIwsSueokifhknkinkojinkbn10(String pIwsSueokifhknkinkojinkbn10) {
        iwsSueokifhknkinkojinkbn10 = pIwsSueokifhknkinkojinkbn10;
    }

    @Column(order = 496, length = 1)
    private String iwsSueokifsueokijtkbn10;

    public String getIwsSueokifsueokijtkbn10() {
        return iwsSueokifsueokijtkbn10;
    }

    public void setIwsSueokifsueokijtkbn10(String pIwsSueokifsueokijtkbn10) {
        iwsSueokifsueokijtkbn10 = pIwsSueokifsueokijtkbn10;
    }

    @Column(order = 497, length = 8)
    private String iwsSueokifsueokikaisiymd10;

    public String getIwsSueokifsueokikaisiymd10() {
        return iwsSueokifsueokikaisiymd10;
    }

    public void setIwsSueokifsueokikaisiymd10(String pIwsSueokifsueokikaisiymd10) {
        iwsSueokifsueokikaisiymd10 = pIwsSueokifsueokikaisiymd10;
    }

    @Column(order = 498, length = 2)
    private String iwsSueokifsueokikkn10;

    public String getIwsSueokifsueokikkn10() {
        return iwsSueokifsueokikkn10;
    }

    public void setIwsSueokifsueokikkn10(String pIwsSueokifsueokikkn10) {
        iwsSueokifsueokikkn10 = pIwsSueokifsueokikkn10;
    }

    @Column(order = 499, length = 8)
    private String iwsSueokifuktseiymd10;

    public String getIwsSueokifuktseiymd10() {
        return iwsSueokifuktseiymd10;
    }

    public void setIwsSueokifuktseiymd10(String pIwsSueokifuktseiymd10) {
        iwsSueokifuktseiymd10 = pIwsSueokifuktseiymd10;
    }

    @Column(order = 500, length = 11)
    private String iwsSounenfnksysyno1;

    public String getIwsSounenfnksysyno1() {
        return iwsSounenfnksysyno1;
    }

    public void setIwsSounenfnksysyno1(String pIwsSounenfnksysyno1) {
        iwsSounenfnksysyno1 = pIwsSounenfnksysyno1;
    }

    @Column(order = 501, length = 2)
    private String iwsSounenfsgnkshrfsegkbn1;

    public String getIwsSounenfsgnkshrfsegkbn1() {
        return iwsSounenfsgnkshrfsegkbn1;
    }

    public void setIwsSounenfsgnkshrfsegkbn1(String pIwsSounenfsgnkshrfsegkbn1) {
        iwsSounenfsgnkshrfsegkbn1 = pIwsSounenfsgnkshrfsegkbn1;
    }

    @Column(order = 502, length = 2)
    private String iwsSounenfsgnkshrfkjnkbn1;

    public String getIwsSounenfsgnkshrfkjnkbn1() {
        return iwsSounenfsgnkshrfkjnkbn1;
    }

    public void setIwsSounenfsgnkshrfkjnkbn1(String pIwsSounenfsgnkshrfkjnkbn1) {
        iwsSounenfsgnkshrfkjnkbn1 = pIwsSounenfsgnkshrfkjnkbn1;
    }

    @Column(order = 503, length = 1)
    private String iwsSounenfkykjyoutaikbn1;

    public String getIwsSounenfkykjyoutaikbn1() {
        return iwsSounenfkykjyoutaikbn1;
    }

    public void setIwsSounenfkykjyoutaikbn1(String pIwsSounenfkykjyoutaikbn1) {
        iwsSounenfkykjyoutaikbn1 = pIwsSounenfkykjyoutaikbn1;
    }

    @Column(order = 504, length = 8)
    private String iwsSounenfsyokainkshrymd1;

    public String getIwsSounenfsyokainkshrymd1() {
        return iwsSounenfsyokainkshrymd1;
    }

    public void setIwsSounenfsyokainkshrymd1(String pIwsSounenfsyokainkshrymd1) {
        iwsSounenfsyokainkshrymd1 = pIwsSounenfsyokainkshrymd1;
    }

    @Column(order = 505, length = 8)
    private String iwsSounenfkykymd1;

    public String getIwsSounenfkykymd1() {
        return iwsSounenfkykymd1;
    }

    public void setIwsSounenfkykymd1(String pIwsSounenfkykymd1) {
        iwsSounenfkykymd1 = pIwsSounenfkykymd1;
    }

    @Column(order = 506, length = 2)
    private String iwsSounenfnksyoumetucd1;

    public String getIwsSounenfnksyoumetucd1() {
        return iwsSounenfnksyoumetucd1;
    }

    public void setIwsSounenfnksyoumetucd1(String pIwsSounenfnksyoumetucd1) {
        iwsSounenfnksyoumetucd1 = pIwsSounenfnksyoumetucd1;
    }

    @Column(order = 507, length = 8)
    private String iwsSounenfnksyoumetuymd1;

    public String getIwsSounenfnksyoumetuymd1() {
        return iwsSounenfnksyoumetuymd1;
    }

    public void setIwsSounenfnksyoumetuymd1(String pIwsSounenfnksyoumetuymd1) {
        iwsSounenfnksyoumetuymd1 = pIwsSounenfnksyoumetuymd1;
    }

    @Column(order = 508, length = 8)
    private String iwsSounenftaisyouseiymd1;

    public String getIwsSounenftaisyouseiymd1() {
        return iwsSounenftaisyouseiymd1;
    }

    public void setIwsSounenftaisyouseiymd1(String pIwsSounenftaisyouseiymd1) {
        iwsSounenftaisyouseiymd1 = pIwsSounenftaisyouseiymd1;
    }

    @Column(order = 509, length = 11)
    private String iwsSounenfnksysyno2;

    public String getIwsSounenfnksysyno2() {
        return iwsSounenfnksysyno2;
    }

    public void setIwsSounenfnksysyno2(String pIwsSounenfnksysyno2) {
        iwsSounenfnksysyno2 = pIwsSounenfnksysyno2;
    }

    @Column(order = 510, length = 2)
    private String iwsSounenfsgnkshrfsegkbn2;

    public String getIwsSounenfsgnkshrfsegkbn2() {
        return iwsSounenfsgnkshrfsegkbn2;
    }

    public void setIwsSounenfsgnkshrfsegkbn2(String pIwsSounenfsgnkshrfsegkbn2) {
        iwsSounenfsgnkshrfsegkbn2 = pIwsSounenfsgnkshrfsegkbn2;
    }

    @Column(order = 511, length = 2)
    private String iwsSounenfsgnkshrfkjnkbn2;

    public String getIwsSounenfsgnkshrfkjnkbn2() {
        return iwsSounenfsgnkshrfkjnkbn2;
    }

    public void setIwsSounenfsgnkshrfkjnkbn2(String pIwsSounenfsgnkshrfkjnkbn2) {
        iwsSounenfsgnkshrfkjnkbn2 = pIwsSounenfsgnkshrfkjnkbn2;
    }

    @Column(order = 512, length = 1)
    private String iwsSounenfkykjyoutaikbn2;

    public String getIwsSounenfkykjyoutaikbn2() {
        return iwsSounenfkykjyoutaikbn2;
    }

    public void setIwsSounenfkykjyoutaikbn2(String pIwsSounenfkykjyoutaikbn2) {
        iwsSounenfkykjyoutaikbn2 = pIwsSounenfkykjyoutaikbn2;
    }

    @Column(order = 513, length = 8)
    private String iwsSounenfsyokainkshrymd2;

    public String getIwsSounenfsyokainkshrymd2() {
        return iwsSounenfsyokainkshrymd2;
    }

    public void setIwsSounenfsyokainkshrymd2(String pIwsSounenfsyokainkshrymd2) {
        iwsSounenfsyokainkshrymd2 = pIwsSounenfsyokainkshrymd2;
    }

    @Column(order = 514, length = 8)
    private String iwsSounenfkykymd2;

    public String getIwsSounenfkykymd2() {
        return iwsSounenfkykymd2;
    }

    public void setIwsSounenfkykymd2(String pIwsSounenfkykymd2) {
        iwsSounenfkykymd2 = pIwsSounenfkykymd2;
    }

    @Column(order = 515, length = 2)
    private String iwsSounenfnksyoumetucd2;

    public String getIwsSounenfnksyoumetucd2() {
        return iwsSounenfnksyoumetucd2;
    }

    public void setIwsSounenfnksyoumetucd2(String pIwsSounenfnksyoumetucd2) {
        iwsSounenfnksyoumetucd2 = pIwsSounenfnksyoumetucd2;
    }

    @Column(order = 516, length = 8)
    private String iwsSounenfnksyoumetuymd2;

    public String getIwsSounenfnksyoumetuymd2() {
        return iwsSounenfnksyoumetuymd2;
    }

    public void setIwsSounenfnksyoumetuymd2(String pIwsSounenfnksyoumetuymd2) {
        iwsSounenfnksyoumetuymd2 = pIwsSounenfnksyoumetuymd2;
    }

    @Column(order = 517, length = 8)
    private String iwsSounenftaisyouseiymd2;

    public String getIwsSounenftaisyouseiymd2() {
        return iwsSounenftaisyouseiymd2;
    }

    public void setIwsSounenftaisyouseiymd2(String pIwsSounenftaisyouseiymd2) {
        iwsSounenftaisyouseiymd2 = pIwsSounenftaisyouseiymd2;
    }

    @Column(order = 518, length = 11)
    private String iwsSounenfnksysyno3;

    public String getIwsSounenfnksysyno3() {
        return iwsSounenfnksysyno3;
    }

    public void setIwsSounenfnksysyno3(String pIwsSounenfnksysyno3) {
        iwsSounenfnksysyno3 = pIwsSounenfnksysyno3;
    }

    @Column(order = 519, length = 2)
    private String iwsSounenfsgnkshrfsegkbn3;

    public String getIwsSounenfsgnkshrfsegkbn3() {
        return iwsSounenfsgnkshrfsegkbn3;
    }

    public void setIwsSounenfsgnkshrfsegkbn3(String pIwsSounenfsgnkshrfsegkbn3) {
        iwsSounenfsgnkshrfsegkbn3 = pIwsSounenfsgnkshrfsegkbn3;
    }

    @Column(order = 520, length = 2)
    private String iwsSounenfsgnkshrfkjnkbn3;

    public String getIwsSounenfsgnkshrfkjnkbn3() {
        return iwsSounenfsgnkshrfkjnkbn3;
    }

    public void setIwsSounenfsgnkshrfkjnkbn3(String pIwsSounenfsgnkshrfkjnkbn3) {
        iwsSounenfsgnkshrfkjnkbn3 = pIwsSounenfsgnkshrfkjnkbn3;
    }

    @Column(order = 521, length = 1)
    private String iwsSounenfkykjyoutaikbn3;

    public String getIwsSounenfkykjyoutaikbn3() {
        return iwsSounenfkykjyoutaikbn3;
    }

    public void setIwsSounenfkykjyoutaikbn3(String pIwsSounenfkykjyoutaikbn3) {
        iwsSounenfkykjyoutaikbn3 = pIwsSounenfkykjyoutaikbn3;
    }

    @Column(order = 522, length = 8)
    private String iwsSounenfsyokainkshrymd3;

    public String getIwsSounenfsyokainkshrymd3() {
        return iwsSounenfsyokainkshrymd3;
    }

    public void setIwsSounenfsyokainkshrymd3(String pIwsSounenfsyokainkshrymd3) {
        iwsSounenfsyokainkshrymd3 = pIwsSounenfsyokainkshrymd3;
    }

    @Column(order = 523, length = 8)
    private String iwsSounenfkykymd3;

    public String getIwsSounenfkykymd3() {
        return iwsSounenfkykymd3;
    }

    public void setIwsSounenfkykymd3(String pIwsSounenfkykymd3) {
        iwsSounenfkykymd3 = pIwsSounenfkykymd3;
    }

    @Column(order = 524, length = 2)
    private String iwsSounenfnksyoumetucd3;

    public String getIwsSounenfnksyoumetucd3() {
        return iwsSounenfnksyoumetucd3;
    }

    public void setIwsSounenfnksyoumetucd3(String pIwsSounenfnksyoumetucd3) {
        iwsSounenfnksyoumetucd3 = pIwsSounenfnksyoumetucd3;
    }

    @Column(order = 525, length = 8)
    private String iwsSounenfnksyoumetuymd3;

    public String getIwsSounenfnksyoumetuymd3() {
        return iwsSounenfnksyoumetuymd3;
    }

    public void setIwsSounenfnksyoumetuymd3(String pIwsSounenfnksyoumetuymd3) {
        iwsSounenfnksyoumetuymd3 = pIwsSounenfnksyoumetuymd3;
    }

    @Column(order = 526, length = 8)
    private String iwsSounenftaisyouseiymd3;

    public String getIwsSounenftaisyouseiymd3() {
        return iwsSounenftaisyouseiymd3;
    }

    public void setIwsSounenftaisyouseiymd3(String pIwsSounenftaisyouseiymd3) {
        iwsSounenftaisyouseiymd3 = pIwsSounenftaisyouseiymd3;
    }

    @Column(order = 527, length = 11)
    private String iwsSounenfnksysyno4;

    public String getIwsSounenfnksysyno4() {
        return iwsSounenfnksysyno4;
    }

    public void setIwsSounenfnksysyno4(String pIwsSounenfnksysyno4) {
        iwsSounenfnksysyno4 = pIwsSounenfnksysyno4;
    }

    @Column(order = 528, length = 2)
    private String iwsSounenfsgnkshrfsegkbn4;

    public String getIwsSounenfsgnkshrfsegkbn4() {
        return iwsSounenfsgnkshrfsegkbn4;
    }

    public void setIwsSounenfsgnkshrfsegkbn4(String pIwsSounenfsgnkshrfsegkbn4) {
        iwsSounenfsgnkshrfsegkbn4 = pIwsSounenfsgnkshrfsegkbn4;
    }

    @Column(order = 529, length = 2)
    private String iwsSounenfsgnkshrfkjnkbn4;

    public String getIwsSounenfsgnkshrfkjnkbn4() {
        return iwsSounenfsgnkshrfkjnkbn4;
    }

    public void setIwsSounenfsgnkshrfkjnkbn4(String pIwsSounenfsgnkshrfkjnkbn4) {
        iwsSounenfsgnkshrfkjnkbn4 = pIwsSounenfsgnkshrfkjnkbn4;
    }

    @Column(order = 530, length = 1)
    private String iwsSounenfkykjyoutaikbn4;

    public String getIwsSounenfkykjyoutaikbn4() {
        return iwsSounenfkykjyoutaikbn4;
    }

    public void setIwsSounenfkykjyoutaikbn4(String pIwsSounenfkykjyoutaikbn4) {
        iwsSounenfkykjyoutaikbn4 = pIwsSounenfkykjyoutaikbn4;
    }

    @Column(order = 531, length = 8)
    private String iwsSounenfsyokainkshrymd4;

    public String getIwsSounenfsyokainkshrymd4() {
        return iwsSounenfsyokainkshrymd4;
    }

    public void setIwsSounenfsyokainkshrymd4(String pIwsSounenfsyokainkshrymd4) {
        iwsSounenfsyokainkshrymd4 = pIwsSounenfsyokainkshrymd4;
    }

    @Column(order = 532, length = 8)
    private String iwsSounenfkykymd4;

    public String getIwsSounenfkykymd4() {
        return iwsSounenfkykymd4;
    }

    public void setIwsSounenfkykymd4(String pIwsSounenfkykymd4) {
        iwsSounenfkykymd4 = pIwsSounenfkykymd4;
    }

    @Column(order = 533, length = 2)
    private String iwsSounenfnksyoumetucd4;

    public String getIwsSounenfnksyoumetucd4() {
        return iwsSounenfnksyoumetucd4;
    }

    public void setIwsSounenfnksyoumetucd4(String pIwsSounenfnksyoumetucd4) {
        iwsSounenfnksyoumetucd4 = pIwsSounenfnksyoumetucd4;
    }

    @Column(order = 534, length = 8)
    private String iwsSounenfnksyoumetuymd4;

    public String getIwsSounenfnksyoumetuymd4() {
        return iwsSounenfnksyoumetuymd4;
    }

    public void setIwsSounenfnksyoumetuymd4(String pIwsSounenfnksyoumetuymd4) {
        iwsSounenfnksyoumetuymd4 = pIwsSounenfnksyoumetuymd4;
    }

    @Column(order = 535, length = 8)
    private String iwsSounenftaisyouseiymd4;

    public String getIwsSounenftaisyouseiymd4() {
        return iwsSounenftaisyouseiymd4;
    }

    public void setIwsSounenftaisyouseiymd4(String pIwsSounenftaisyouseiymd4) {
        iwsSounenftaisyouseiymd4 = pIwsSounenftaisyouseiymd4;
    }

    @Column(order = 536, length = 11)
    private String iwsSounenfnksysyno5;

    public String getIwsSounenfnksysyno5() {
        return iwsSounenfnksysyno5;
    }

    public void setIwsSounenfnksysyno5(String pIwsSounenfnksysyno5) {
        iwsSounenfnksysyno5 = pIwsSounenfnksysyno5;
    }

    @Column(order = 537, length = 2)
    private String iwsSounenfsgnkshrfsegkbn5;

    public String getIwsSounenfsgnkshrfsegkbn5() {
        return iwsSounenfsgnkshrfsegkbn5;
    }

    public void setIwsSounenfsgnkshrfsegkbn5(String pIwsSounenfsgnkshrfsegkbn5) {
        iwsSounenfsgnkshrfsegkbn5 = pIwsSounenfsgnkshrfsegkbn5;
    }

    @Column(order = 538, length = 2)
    private String iwsSounenfsgnkshrfkjnkbn5;

    public String getIwsSounenfsgnkshrfkjnkbn5() {
        return iwsSounenfsgnkshrfkjnkbn5;
    }

    public void setIwsSounenfsgnkshrfkjnkbn5(String pIwsSounenfsgnkshrfkjnkbn5) {
        iwsSounenfsgnkshrfkjnkbn5 = pIwsSounenfsgnkshrfkjnkbn5;
    }

    @Column(order = 539, length = 1)
    private String iwsSounenfkykjyoutaikbn5;

    public String getIwsSounenfkykjyoutaikbn5() {
        return iwsSounenfkykjyoutaikbn5;
    }

    public void setIwsSounenfkykjyoutaikbn5(String pIwsSounenfkykjyoutaikbn5) {
        iwsSounenfkykjyoutaikbn5 = pIwsSounenfkykjyoutaikbn5;
    }

    @Column(order = 540, length = 8)
    private String iwsSounenfsyokainkshrymd5;

    public String getIwsSounenfsyokainkshrymd5() {
        return iwsSounenfsyokainkshrymd5;
    }

    public void setIwsSounenfsyokainkshrymd5(String pIwsSounenfsyokainkshrymd5) {
        iwsSounenfsyokainkshrymd5 = pIwsSounenfsyokainkshrymd5;
    }

    @Column(order = 541, length = 8)
    private String iwsSounenfkykymd5;

    public String getIwsSounenfkykymd5() {
        return iwsSounenfkykymd5;
    }

    public void setIwsSounenfkykymd5(String pIwsSounenfkykymd5) {
        iwsSounenfkykymd5 = pIwsSounenfkykymd5;
    }

    @Column(order = 542, length = 2)
    private String iwsSounenfnksyoumetucd5;

    public String getIwsSounenfnksyoumetucd5() {
        return iwsSounenfnksyoumetucd5;
    }

    public void setIwsSounenfnksyoumetucd5(String pIwsSounenfnksyoumetucd5) {
        iwsSounenfnksyoumetucd5 = pIwsSounenfnksyoumetucd5;
    }

    @Column(order = 543, length = 8)
    private String iwsSounenfnksyoumetuymd5;

    public String getIwsSounenfnksyoumetuymd5() {
        return iwsSounenfnksyoumetuymd5;
    }

    public void setIwsSounenfnksyoumetuymd5(String pIwsSounenfnksyoumetuymd5) {
        iwsSounenfnksyoumetuymd5 = pIwsSounenfnksyoumetuymd5;
    }

    @Column(order = 544, length = 8)
    private String iwsSounenftaisyouseiymd5;

    public String getIwsSounenftaisyouseiymd5() {
        return iwsSounenftaisyouseiymd5;
    }

    public void setIwsSounenftaisyouseiymd5(String pIwsSounenftaisyouseiymd5) {
        iwsSounenftaisyouseiymd5 = pIwsSounenftaisyouseiymd5;
    }

    @Column(order = 545, length = 11)
    private String iwsSounenfnksysyno6;

    public String getIwsSounenfnksysyno6() {
        return iwsSounenfnksysyno6;
    }

    public void setIwsSounenfnksysyno6(String pIwsSounenfnksysyno6) {
        iwsSounenfnksysyno6 = pIwsSounenfnksysyno6;
    }

    @Column(order = 546, length = 2)
    private String iwsSounenfsgnkshrfsegkbn6;

    public String getIwsSounenfsgnkshrfsegkbn6() {
        return iwsSounenfsgnkshrfsegkbn6;
    }

    public void setIwsSounenfsgnkshrfsegkbn6(String pIwsSounenfsgnkshrfsegkbn6) {
        iwsSounenfsgnkshrfsegkbn6 = pIwsSounenfsgnkshrfsegkbn6;
    }

    @Column(order = 547, length = 2)
    private String iwsSounenfsgnkshrfkjnkbn6;

    public String getIwsSounenfsgnkshrfkjnkbn6() {
        return iwsSounenfsgnkshrfkjnkbn6;
    }

    public void setIwsSounenfsgnkshrfkjnkbn6(String pIwsSounenfsgnkshrfkjnkbn6) {
        iwsSounenfsgnkshrfkjnkbn6 = pIwsSounenfsgnkshrfkjnkbn6;
    }

    @Column(order = 548, length = 1)
    private String iwsSounenfkykjyoutaikbn6;

    public String getIwsSounenfkykjyoutaikbn6() {
        return iwsSounenfkykjyoutaikbn6;
    }

    public void setIwsSounenfkykjyoutaikbn6(String pIwsSounenfkykjyoutaikbn6) {
        iwsSounenfkykjyoutaikbn6 = pIwsSounenfkykjyoutaikbn6;
    }

    @Column(order = 549, length = 8)
    private String iwsSounenfsyokainkshrymd6;

    public String getIwsSounenfsyokainkshrymd6() {
        return iwsSounenfsyokainkshrymd6;
    }

    public void setIwsSounenfsyokainkshrymd6(String pIwsSounenfsyokainkshrymd6) {
        iwsSounenfsyokainkshrymd6 = pIwsSounenfsyokainkshrymd6;
    }

    @Column(order = 550, length = 8)
    private String iwsSounenfkykymd6;

    public String getIwsSounenfkykymd6() {
        return iwsSounenfkykymd6;
    }

    public void setIwsSounenfkykymd6(String pIwsSounenfkykymd6) {
        iwsSounenfkykymd6 = pIwsSounenfkykymd6;
    }

    @Column(order = 551, length = 2)
    private String iwsSounenfnksyoumetucd6;

    public String getIwsSounenfnksyoumetucd6() {
        return iwsSounenfnksyoumetucd6;
    }

    public void setIwsSounenfnksyoumetucd6(String pIwsSounenfnksyoumetucd6) {
        iwsSounenfnksyoumetucd6 = pIwsSounenfnksyoumetucd6;
    }

    @Column(order = 552, length = 8)
    private String iwsSounenfnksyoumetuymd6;

    public String getIwsSounenfnksyoumetuymd6() {
        return iwsSounenfnksyoumetuymd6;
    }

    public void setIwsSounenfnksyoumetuymd6(String pIwsSounenfnksyoumetuymd6) {
        iwsSounenfnksyoumetuymd6 = pIwsSounenfnksyoumetuymd6;
    }

    @Column(order = 553, length = 8)
    private String iwsSounenftaisyouseiymd6;

    public String getIwsSounenftaisyouseiymd6() {
        return iwsSounenftaisyouseiymd6;
    }

    public void setIwsSounenftaisyouseiymd6(String pIwsSounenftaisyouseiymd6) {
        iwsSounenftaisyouseiymd6 = pIwsSounenftaisyouseiymd6;
    }

    @Column(order = 554, length = 11)
    private String iwsSounenfnksysyno7;

    public String getIwsSounenfnksysyno7() {
        return iwsSounenfnksysyno7;
    }

    public void setIwsSounenfnksysyno7(String pIwsSounenfnksysyno7) {
        iwsSounenfnksysyno7 = pIwsSounenfnksysyno7;
    }

    @Column(order = 555, length = 2)
    private String iwsSounenfsgnkshrfsegkbn7;

    public String getIwsSounenfsgnkshrfsegkbn7() {
        return iwsSounenfsgnkshrfsegkbn7;
    }

    public void setIwsSounenfsgnkshrfsegkbn7(String pIwsSounenfsgnkshrfsegkbn7) {
        iwsSounenfsgnkshrfsegkbn7 = pIwsSounenfsgnkshrfsegkbn7;
    }

    @Column(order = 556, length = 2)
    private String iwsSounenfsgnkshrfkjnkbn7;

    public String getIwsSounenfsgnkshrfkjnkbn7() {
        return iwsSounenfsgnkshrfkjnkbn7;
    }

    public void setIwsSounenfsgnkshrfkjnkbn7(String pIwsSounenfsgnkshrfkjnkbn7) {
        iwsSounenfsgnkshrfkjnkbn7 = pIwsSounenfsgnkshrfkjnkbn7;
    }

    @Column(order = 557, length = 1)
    private String iwsSounenfkykjyoutaikbn7;

    public String getIwsSounenfkykjyoutaikbn7() {
        return iwsSounenfkykjyoutaikbn7;
    }

    public void setIwsSounenfkykjyoutaikbn7(String pIwsSounenfkykjyoutaikbn7) {
        iwsSounenfkykjyoutaikbn7 = pIwsSounenfkykjyoutaikbn7;
    }

    @Column(order = 558, length = 8)
    private String iwsSounenfsyokainkshrymd7;

    public String getIwsSounenfsyokainkshrymd7() {
        return iwsSounenfsyokainkshrymd7;
    }

    public void setIwsSounenfsyokainkshrymd7(String pIwsSounenfsyokainkshrymd7) {
        iwsSounenfsyokainkshrymd7 = pIwsSounenfsyokainkshrymd7;
    }

    @Column(order = 559, length = 8)
    private String iwsSounenfkykymd7;

    public String getIwsSounenfkykymd7() {
        return iwsSounenfkykymd7;
    }

    public void setIwsSounenfkykymd7(String pIwsSounenfkykymd7) {
        iwsSounenfkykymd7 = pIwsSounenfkykymd7;
    }

    @Column(order = 560, length = 2)
    private String iwsSounenfnksyoumetucd7;

    public String getIwsSounenfnksyoumetucd7() {
        return iwsSounenfnksyoumetucd7;
    }

    public void setIwsSounenfnksyoumetucd7(String pIwsSounenfnksyoumetucd7) {
        iwsSounenfnksyoumetucd7 = pIwsSounenfnksyoumetucd7;
    }

    @Column(order = 561, length = 8)
    private String iwsSounenfnksyoumetuymd7;

    public String getIwsSounenfnksyoumetuymd7() {
        return iwsSounenfnksyoumetuymd7;
    }

    public void setIwsSounenfnksyoumetuymd7(String pIwsSounenfnksyoumetuymd7) {
        iwsSounenfnksyoumetuymd7 = pIwsSounenfnksyoumetuymd7;
    }

    @Column(order = 562, length = 8)
    private String iwsSounenftaisyouseiymd7;

    public String getIwsSounenftaisyouseiymd7() {
        return iwsSounenftaisyouseiymd7;
    }

    public void setIwsSounenftaisyouseiymd7(String pIwsSounenftaisyouseiymd7) {
        iwsSounenftaisyouseiymd7 = pIwsSounenftaisyouseiymd7;
    }

    @Column(order = 563, length = 11)
    private String iwsSounenfnksysyno8;

    public String getIwsSounenfnksysyno8() {
        return iwsSounenfnksysyno8;
    }

    public void setIwsSounenfnksysyno8(String pIwsSounenfnksysyno8) {
        iwsSounenfnksysyno8 = pIwsSounenfnksysyno8;
    }

    @Column(order = 564, length = 2)
    private String iwsSounenfsgnkshrfsegkbn8;

    public String getIwsSounenfsgnkshrfsegkbn8() {
        return iwsSounenfsgnkshrfsegkbn8;
    }

    public void setIwsSounenfsgnkshrfsegkbn8(String pIwsSounenfsgnkshrfsegkbn8) {
        iwsSounenfsgnkshrfsegkbn8 = pIwsSounenfsgnkshrfsegkbn8;
    }

    @Column(order = 565, length = 2)
    private String iwsSounenfsgnkshrfkjnkbn8;

    public String getIwsSounenfsgnkshrfkjnkbn8() {
        return iwsSounenfsgnkshrfkjnkbn8;
    }

    public void setIwsSounenfsgnkshrfkjnkbn8(String pIwsSounenfsgnkshrfkjnkbn8) {
        iwsSounenfsgnkshrfkjnkbn8 = pIwsSounenfsgnkshrfkjnkbn8;
    }

    @Column(order = 566, length = 1)
    private String iwsSounenfkykjyoutaikbn8;

    public String getIwsSounenfkykjyoutaikbn8() {
        return iwsSounenfkykjyoutaikbn8;
    }

    public void setIwsSounenfkykjyoutaikbn8(String pIwsSounenfkykjyoutaikbn8) {
        iwsSounenfkykjyoutaikbn8 = pIwsSounenfkykjyoutaikbn8;
    }

    @Column(order = 567, length = 8)
    private String iwsSounenfsyokainkshrymd8;

    public String getIwsSounenfsyokainkshrymd8() {
        return iwsSounenfsyokainkshrymd8;
    }

    public void setIwsSounenfsyokainkshrymd8(String pIwsSounenfsyokainkshrymd8) {
        iwsSounenfsyokainkshrymd8 = pIwsSounenfsyokainkshrymd8;
    }

    @Column(order = 568, length = 8)
    private String iwsSounenfkykymd8;

    public String getIwsSounenfkykymd8() {
        return iwsSounenfkykymd8;
    }

    public void setIwsSounenfkykymd8(String pIwsSounenfkykymd8) {
        iwsSounenfkykymd8 = pIwsSounenfkykymd8;
    }

    @Column(order = 569, length = 2)
    private String iwsSounenfnksyoumetucd8;

    public String getIwsSounenfnksyoumetucd8() {
        return iwsSounenfnksyoumetucd8;
    }

    public void setIwsSounenfnksyoumetucd8(String pIwsSounenfnksyoumetucd8) {
        iwsSounenfnksyoumetucd8 = pIwsSounenfnksyoumetucd8;
    }

    @Column(order = 570, length = 8)
    private String iwsSounenfnksyoumetuymd8;

    public String getIwsSounenfnksyoumetuymd8() {
        return iwsSounenfnksyoumetuymd8;
    }

    public void setIwsSounenfnksyoumetuymd8(String pIwsSounenfnksyoumetuymd8) {
        iwsSounenfnksyoumetuymd8 = pIwsSounenfnksyoumetuymd8;
    }

    @Column(order = 571, length = 8)
    private String iwsSounenftaisyouseiymd8;

    public String getIwsSounenftaisyouseiymd8() {
        return iwsSounenftaisyouseiymd8;
    }

    public void setIwsSounenftaisyouseiymd8(String pIwsSounenftaisyouseiymd8) {
        iwsSounenftaisyouseiymd8 = pIwsSounenftaisyouseiymd8;
    }

    @Column(order = 572, length = 11)
    private String iwsSounenfnksysyno9;

    public String getIwsSounenfnksysyno9() {
        return iwsSounenfnksysyno9;
    }

    public void setIwsSounenfnksysyno9(String pIwsSounenfnksysyno9) {
        iwsSounenfnksysyno9 = pIwsSounenfnksysyno9;
    }

    @Column(order = 573, length = 2)
    private String iwsSounenfsgnkshrfsegkbn9;

    public String getIwsSounenfsgnkshrfsegkbn9() {
        return iwsSounenfsgnkshrfsegkbn9;
    }

    public void setIwsSounenfsgnkshrfsegkbn9(String pIwsSounenfsgnkshrfsegkbn9) {
        iwsSounenfsgnkshrfsegkbn9 = pIwsSounenfsgnkshrfsegkbn9;
    }

    @Column(order = 574, length = 2)
    private String iwsSounenfsgnkshrfkjnkbn9;

    public String getIwsSounenfsgnkshrfkjnkbn9() {
        return iwsSounenfsgnkshrfkjnkbn9;
    }

    public void setIwsSounenfsgnkshrfkjnkbn9(String pIwsSounenfsgnkshrfkjnkbn9) {
        iwsSounenfsgnkshrfkjnkbn9 = pIwsSounenfsgnkshrfkjnkbn9;
    }

    @Column(order = 575, length = 1)
    private String iwsSounenfkykjyoutaikbn9;

    public String getIwsSounenfkykjyoutaikbn9() {
        return iwsSounenfkykjyoutaikbn9;
    }

    public void setIwsSounenfkykjyoutaikbn9(String pIwsSounenfkykjyoutaikbn9) {
        iwsSounenfkykjyoutaikbn9 = pIwsSounenfkykjyoutaikbn9;
    }

    @Column(order = 576, length = 8)
    private String iwsSounenfsyokainkshrymd9;

    public String getIwsSounenfsyokainkshrymd9() {
        return iwsSounenfsyokainkshrymd9;
    }

    public void setIwsSounenfsyokainkshrymd9(String pIwsSounenfsyokainkshrymd9) {
        iwsSounenfsyokainkshrymd9 = pIwsSounenfsyokainkshrymd9;
    }

    @Column(order = 577, length = 8)
    private String iwsSounenfkykymd9;

    public String getIwsSounenfkykymd9() {
        return iwsSounenfkykymd9;
    }

    public void setIwsSounenfkykymd9(String pIwsSounenfkykymd9) {
        iwsSounenfkykymd9 = pIwsSounenfkykymd9;
    }

    @Column(order = 578, length = 2)
    private String iwsSounenfnksyoumetucd9;

    public String getIwsSounenfnksyoumetucd9() {
        return iwsSounenfnksyoumetucd9;
    }

    public void setIwsSounenfnksyoumetucd9(String pIwsSounenfnksyoumetucd9) {
        iwsSounenfnksyoumetucd9 = pIwsSounenfnksyoumetucd9;
    }

    @Column(order = 579, length = 8)
    private String iwsSounenfnksyoumetuymd9;

    public String getIwsSounenfnksyoumetuymd9() {
        return iwsSounenfnksyoumetuymd9;
    }

    public void setIwsSounenfnksyoumetuymd9(String pIwsSounenfnksyoumetuymd9) {
        iwsSounenfnksyoumetuymd9 = pIwsSounenfnksyoumetuymd9;
    }

    @Column(order = 580, length = 8)
    private String iwsSounenftaisyouseiymd9;

    public String getIwsSounenftaisyouseiymd9() {
        return iwsSounenftaisyouseiymd9;
    }

    public void setIwsSounenftaisyouseiymd9(String pIwsSounenftaisyouseiymd9) {
        iwsSounenftaisyouseiymd9 = pIwsSounenftaisyouseiymd9;
    }

    @Column(order = 581, length = 11)
    private String iwsSounenfnksysyno10;

    public String getIwsSounenfnksysyno10() {
        return iwsSounenfnksysyno10;
    }

    public void setIwsSounenfnksysyno10(String pIwsSounenfnksysyno10) {
        iwsSounenfnksysyno10 = pIwsSounenfnksysyno10;
    }

    @Column(order = 582, length = 2)
    private String iwsSounenfsgnkshrfsegkbn10;

    public String getIwsSounenfsgnkshrfsegkbn10() {
        return iwsSounenfsgnkshrfsegkbn10;
    }

    public void setIwsSounenfsgnkshrfsegkbn10(String pIwsSounenfsgnkshrfsegkbn10) {
        iwsSounenfsgnkshrfsegkbn10 = pIwsSounenfsgnkshrfsegkbn10;
    }

    @Column(order = 583, length = 2)
    private String iwsSounenfsgnkshrfkjnkbn10;

    public String getIwsSounenfsgnkshrfkjnkbn10() {
        return iwsSounenfsgnkshrfkjnkbn10;
    }

    public void setIwsSounenfsgnkshrfkjnkbn10(String pIwsSounenfsgnkshrfkjnkbn10) {
        iwsSounenfsgnkshrfkjnkbn10 = pIwsSounenfsgnkshrfkjnkbn10;
    }

    @Column(order = 584, length = 1)
    private String iwsSounenfkykjyoutaikbn10;

    public String getIwsSounenfkykjyoutaikbn10() {
        return iwsSounenfkykjyoutaikbn10;
    }

    public void setIwsSounenfkykjyoutaikbn10(String pIwsSounenfkykjyoutaikbn10) {
        iwsSounenfkykjyoutaikbn10 = pIwsSounenfkykjyoutaikbn10;
    }

    @Column(order = 585, length = 8)
    private String iwsSounenfsyokainkshrymd10;

    public String getIwsSounenfsyokainkshrymd10() {
        return iwsSounenfsyokainkshrymd10;
    }

    public void setIwsSounenfsyokainkshrymd10(String pIwsSounenfsyokainkshrymd10) {
        iwsSounenfsyokainkshrymd10 = pIwsSounenfsyokainkshrymd10;
    }

    @Column(order = 586, length = 8)
    private String iwsSounenfkykymd10;

    public String getIwsSounenfkykymd10() {
        return iwsSounenfkykymd10;
    }

    public void setIwsSounenfkykymd10(String pIwsSounenfkykymd10) {
        iwsSounenfkykymd10 = pIwsSounenfkykymd10;
    }

    @Column(order = 587, length = 2)
    private String iwsSounenfnksyoumetucd10;

    public String getIwsSounenfnksyoumetucd10() {
        return iwsSounenfnksyoumetucd10;
    }

    public void setIwsSounenfnksyoumetucd10(String pIwsSounenfnksyoumetucd10) {
        iwsSounenfnksyoumetucd10 = pIwsSounenfnksyoumetucd10;
    }

    @Column(order = 588, length = 8)
    private String iwsSounenfnksyoumetuymd10;

    public String getIwsSounenfnksyoumetuymd10() {
        return iwsSounenfnksyoumetuymd10;
    }

    public void setIwsSounenfnksyoumetuymd10(String pIwsSounenfnksyoumetuymd10) {
        iwsSounenfnksyoumetuymd10 = pIwsSounenfnksyoumetuymd10;
    }

    @Column(order = 589, length = 8)
    private String iwsSounenftaisyouseiymd10;

    public String getIwsSounenftaisyouseiymd10() {
        return iwsSounenftaisyouseiymd10;
    }

    public void setIwsSounenftaisyouseiymd10(String pIwsSounenftaisyouseiymd10) {
        iwsSounenftaisyouseiymd10 = pIwsSounenftaisyouseiymd10;
    }

    @Column(order = 590, length = 11)
    private String iwsKhsyono1;

    public String getIwsKhsyono1() {
        return iwsKhsyono1;
    }

    public void setIwsKhsyono1(String pIwsKhsyono1) {
        iwsKhsyono1 = pIwsKhsyono1;
    }

    @Column(order = 591, length = 2)
    private String iwsKhkykfsegkbn1;

    public String getIwsKhkykfsegkbn1() {
        return iwsKhkykfsegkbn1;
    }

    public void setIwsKhkykfsegkbn1(String pIwsKhkykfsegkbn1) {
        iwsKhkykfsegkbn1 = pIwsKhkykfsegkbn1;
    }

    @Column(order = 592, length = 2)
    private String iwsKhkykfkojinkbn1;

    public String getIwsKhkykfkojinkbn1() {
        return iwsKhkykfkojinkbn1;
    }

    public void setIwsKhkykfkojinkbn1(String pIwsKhkykfkojinkbn1) {
        iwsKhkykfkojinkbn1 = pIwsKhkykfkojinkbn1;
    }

    @Column(order = 593, length = 1)
    private String iwsKhyuukousyoumetukbn1;

    public String getIwsKhyuukousyoumetukbn1() {
        return iwsKhyuukousyoumetukbn1;
    }

    public void setIwsKhyuukousyoumetukbn1(String pIwsKhyuukousyoumetukbn1) {
        iwsKhyuukousyoumetukbn1 = pIwsKhyuukousyoumetukbn1;
    }

    @Column(order = 594, length = 2)
    private String iwsKhkykjyoutai1;

    public String getIwsKhkykjyoutai1() {
        return iwsKhkykjyoutai1;
    }

    public void setIwsKhkykjyoutai1(String pIwsKhkykjyoutai1) {
        iwsKhkykjyoutai1 = pIwsKhkykjyoutai1;
    }

    @Column(order = 595, length = 8)
    private String iwsKhkykymd1;

    public String getIwsKhkykymd1() {
        return iwsKhkykymd1;
    }

    public void setIwsKhkykymd1(String pIwsKhkykymd1) {
        iwsKhkykymd1 = pIwsKhkykymd1;
    }

    @Column(order = 596, length = 2)
    private String iwsKhsyoumetujiyuu1;

    public String getIwsKhsyoumetujiyuu1() {
        return iwsKhsyoumetujiyuu1;
    }

    public void setIwsKhsyoumetujiyuu1(String pIwsKhsyoumetujiyuu1) {
        iwsKhsyoumetujiyuu1 = pIwsKhsyoumetujiyuu1;
    }

    @Column(order = 597, length = 8)
    private String iwsKhsyoumetuymd1;

    public String getIwsKhsyoumetuymd1() {
        return iwsKhsyoumetuymd1;
    }

    public void setIwsKhsyoumetuymd1(String pIwsKhsyoumetuymd1) {
        iwsKhsyoumetuymd1 = pIwsKhsyoumetuymd1;
    }

    @Column(order = 598, length = 2)
    private String iwsKhsyouhncd1;

    public String getIwsKhsyouhncd1() {
        return iwsKhsyouhncd1;
    }

    public void setIwsKhsyouhncd1(String pIwsKhsyouhncd1) {
        iwsKhsyouhncd1 = pIwsKhsyouhncd1;
    }

    @Column(order = 599, length = 6)
    private String iwsKhbosyuuym1;

    public String getIwsKhbosyuuym1() {
        return iwsKhbosyuuym1;
    }

    public void setIwsKhbosyuuym1(String pIwsKhbosyuuym1) {
        iwsKhbosyuuym1 = pIwsKhbosyuuym1;
    }

    @Column(order = 600, length = 8)
    private String iwsKhtaisyouseiymd1;

    public String getIwsKhtaisyouseiymd1() {
        return iwsKhtaisyouseiymd1;
    }

    public void setIwsKhtaisyouseiymd1(String pIwsKhtaisyouseiymd1) {
        iwsKhtaisyouseiymd1 = pIwsKhtaisyouseiymd1;
    }

    @Column(order = 601, length = 2)
    private String iwsKhsyouhnsdno1;

    public String getIwsKhsyouhnsdno1() {
        return iwsKhsyouhnsdno1;
    }

    public void setIwsKhsyouhnsdno1(String pIwsKhsyouhnsdno1) {
        iwsKhsyouhnsdno1 = pIwsKhsyouhnsdno1;
    }

    @Column(order = 602, length = 11)
    private String iwsKhsyono2;

    public String getIwsKhsyono2() {
        return iwsKhsyono2;
    }

    public void setIwsKhsyono2(String pIwsKhsyono2) {
        iwsKhsyono2 = pIwsKhsyono2;
    }

    @Column(order = 603, length = 2)
    private String iwsKhkykfsegkbn2;

    public String getIwsKhkykfsegkbn2() {
        return iwsKhkykfsegkbn2;
    }

    public void setIwsKhkykfsegkbn2(String pIwsKhkykfsegkbn2) {
        iwsKhkykfsegkbn2 = pIwsKhkykfsegkbn2;
    }

    @Column(order = 604, length = 2)
    private String iwsKhkykfkojinkbn2;

    public String getIwsKhkykfkojinkbn2() {
        return iwsKhkykfkojinkbn2;
    }

    public void setIwsKhkykfkojinkbn2(String pIwsKhkykfkojinkbn2) {
        iwsKhkykfkojinkbn2 = pIwsKhkykfkojinkbn2;
    }

    @Column(order = 605, length = 1)
    private String iwsKhyuukousyoumetukbn2;

    public String getIwsKhyuukousyoumetukbn2() {
        return iwsKhyuukousyoumetukbn2;
    }

    public void setIwsKhyuukousyoumetukbn2(String pIwsKhyuukousyoumetukbn2) {
        iwsKhyuukousyoumetukbn2 = pIwsKhyuukousyoumetukbn2;
    }

    @Column(order = 606, length = 2)
    private String iwsKhkykjyoutai2;

    public String getIwsKhkykjyoutai2() {
        return iwsKhkykjyoutai2;
    }

    public void setIwsKhkykjyoutai2(String pIwsKhkykjyoutai2) {
        iwsKhkykjyoutai2 = pIwsKhkykjyoutai2;
    }

    @Column(order = 607, length = 8)
    private String iwsKhkykymd2;

    public String getIwsKhkykymd2() {
        return iwsKhkykymd2;
    }

    public void setIwsKhkykymd2(String pIwsKhkykymd2) {
        iwsKhkykymd2 = pIwsKhkykymd2;
    }

    @Column(order = 608, length = 2)
    private String iwsKhsyoumetujiyuu2;

    public String getIwsKhsyoumetujiyuu2() {
        return iwsKhsyoumetujiyuu2;
    }

    public void setIwsKhsyoumetujiyuu2(String pIwsKhsyoumetujiyuu2) {
        iwsKhsyoumetujiyuu2 = pIwsKhsyoumetujiyuu2;
    }

    @Column(order = 609, length = 8)
    private String iwsKhsyoumetuymd2;

    public String getIwsKhsyoumetuymd2() {
        return iwsKhsyoumetuymd2;
    }

    public void setIwsKhsyoumetuymd2(String pIwsKhsyoumetuymd2) {
        iwsKhsyoumetuymd2 = pIwsKhsyoumetuymd2;
    }

    @Column(order = 610, length = 2)
    private String iwsKhsyouhncd2;

    public String getIwsKhsyouhncd2() {
        return iwsKhsyouhncd2;
    }

    public void setIwsKhsyouhncd2(String pIwsKhsyouhncd2) {
        iwsKhsyouhncd2 = pIwsKhsyouhncd2;
    }

    @Column(order = 611, length = 6)
    private String iwsKhbosyuuym2;

    public String getIwsKhbosyuuym2() {
        return iwsKhbosyuuym2;
    }

    public void setIwsKhbosyuuym2(String pIwsKhbosyuuym2) {
        iwsKhbosyuuym2 = pIwsKhbosyuuym2;
    }

    @Column(order = 612, length = 8)
    private String iwsKhtaisyouseiymd2;

    public String getIwsKhtaisyouseiymd2() {
        return iwsKhtaisyouseiymd2;
    }

    public void setIwsKhtaisyouseiymd2(String pIwsKhtaisyouseiymd2) {
        iwsKhtaisyouseiymd2 = pIwsKhtaisyouseiymd2;
    }

    @Column(order = 613, length = 2)
    private String iwsKhsyouhnsdno2;

    public String getIwsKhsyouhnsdno2() {
        return iwsKhsyouhnsdno2;
    }

    public void setIwsKhsyouhnsdno2(String pIwsKhsyouhnsdno2) {
        iwsKhsyouhnsdno2 = pIwsKhsyouhnsdno2;
    }

    @Column(order = 614, length = 11)
    private String iwsKhsyono3;

    public String getIwsKhsyono3() {
        return iwsKhsyono3;
    }

    public void setIwsKhsyono3(String pIwsKhsyono3) {
        iwsKhsyono3 = pIwsKhsyono3;
    }

    @Column(order = 615, length = 2)
    private String iwsKhkykfsegkbn3;

    public String getIwsKhkykfsegkbn3() {
        return iwsKhkykfsegkbn3;
    }

    public void setIwsKhkykfsegkbn3(String pIwsKhkykfsegkbn3) {
        iwsKhkykfsegkbn3 = pIwsKhkykfsegkbn3;
    }

    @Column(order = 616, length = 2)
    private String iwsKhkykfkojinkbn3;

    public String getIwsKhkykfkojinkbn3() {
        return iwsKhkykfkojinkbn3;
    }

    public void setIwsKhkykfkojinkbn3(String pIwsKhkykfkojinkbn3) {
        iwsKhkykfkojinkbn3 = pIwsKhkykfkojinkbn3;
    }

    @Column(order = 617, length = 1)
    private String iwsKhyuukousyoumetukbn3;

    public String getIwsKhyuukousyoumetukbn3() {
        return iwsKhyuukousyoumetukbn3;
    }

    public void setIwsKhyuukousyoumetukbn3(String pIwsKhyuukousyoumetukbn3) {
        iwsKhyuukousyoumetukbn3 = pIwsKhyuukousyoumetukbn3;
    }

    @Column(order = 618, length = 2)
    private String iwsKhkykjyoutai3;

    public String getIwsKhkykjyoutai3() {
        return iwsKhkykjyoutai3;
    }

    public void setIwsKhkykjyoutai3(String pIwsKhkykjyoutai3) {
        iwsKhkykjyoutai3 = pIwsKhkykjyoutai3;
    }

    @Column(order = 619, length = 8)
    private String iwsKhkykymd3;

    public String getIwsKhkykymd3() {
        return iwsKhkykymd3;
    }

    public void setIwsKhkykymd3(String pIwsKhkykymd3) {
        iwsKhkykymd3 = pIwsKhkykymd3;
    }

    @Column(order = 620, length = 2)
    private String iwsKhsyoumetujiyuu3;

    public String getIwsKhsyoumetujiyuu3() {
        return iwsKhsyoumetujiyuu3;
    }

    public void setIwsKhsyoumetujiyuu3(String pIwsKhsyoumetujiyuu3) {
        iwsKhsyoumetujiyuu3 = pIwsKhsyoumetujiyuu3;
    }

    @Column(order = 621, length = 8)
    private String iwsKhsyoumetuymd3;

    public String getIwsKhsyoumetuymd3() {
        return iwsKhsyoumetuymd3;
    }

    public void setIwsKhsyoumetuymd3(String pIwsKhsyoumetuymd3) {
        iwsKhsyoumetuymd3 = pIwsKhsyoumetuymd3;
    }

    @Column(order = 622, length = 2)
    private String iwsKhsyouhncd3;

    public String getIwsKhsyouhncd3() {
        return iwsKhsyouhncd3;
    }

    public void setIwsKhsyouhncd3(String pIwsKhsyouhncd3) {
        iwsKhsyouhncd3 = pIwsKhsyouhncd3;
    }

    @Column(order = 623, length = 6)
    private String iwsKhbosyuuym3;

    public String getIwsKhbosyuuym3() {
        return iwsKhbosyuuym3;
    }

    public void setIwsKhbosyuuym3(String pIwsKhbosyuuym3) {
        iwsKhbosyuuym3 = pIwsKhbosyuuym3;
    }

    @Column(order = 624, length = 8)
    private String iwsKhtaisyouseiymd3;

    public String getIwsKhtaisyouseiymd3() {
        return iwsKhtaisyouseiymd3;
    }

    public void setIwsKhtaisyouseiymd3(String pIwsKhtaisyouseiymd3) {
        iwsKhtaisyouseiymd3 = pIwsKhtaisyouseiymd3;
    }

    @Column(order = 625, length = 2)
    private String iwsKhsyouhnsdno3;

    public String getIwsKhsyouhnsdno3() {
        return iwsKhsyouhnsdno3;
    }

    public void setIwsKhsyouhnsdno3(String pIwsKhsyouhnsdno3) {
        iwsKhsyouhnsdno3 = pIwsKhsyouhnsdno3;
    }

    @Column(order = 626, length = 11)
    private String iwsKhsyono4;

    public String getIwsKhsyono4() {
        return iwsKhsyono4;
    }

    public void setIwsKhsyono4(String pIwsKhsyono4) {
        iwsKhsyono4 = pIwsKhsyono4;
    }

    @Column(order = 627, length = 2)
    private String iwsKhkykfsegkbn4;

    public String getIwsKhkykfsegkbn4() {
        return iwsKhkykfsegkbn4;
    }

    public void setIwsKhkykfsegkbn4(String pIwsKhkykfsegkbn4) {
        iwsKhkykfsegkbn4 = pIwsKhkykfsegkbn4;
    }

    @Column(order = 628, length = 2)
    private String iwsKhkykfkojinkbn4;

    public String getIwsKhkykfkojinkbn4() {
        return iwsKhkykfkojinkbn4;
    }

    public void setIwsKhkykfkojinkbn4(String pIwsKhkykfkojinkbn4) {
        iwsKhkykfkojinkbn4 = pIwsKhkykfkojinkbn4;
    }

    @Column(order = 629, length = 1)
    private String iwsKhyuukousyoumetukbn4;

    public String getIwsKhyuukousyoumetukbn4() {
        return iwsKhyuukousyoumetukbn4;
    }

    public void setIwsKhyuukousyoumetukbn4(String pIwsKhyuukousyoumetukbn4) {
        iwsKhyuukousyoumetukbn4 = pIwsKhyuukousyoumetukbn4;
    }

    @Column(order = 630, length = 2)
    private String iwsKhkykjyoutai4;

    public String getIwsKhkykjyoutai4() {
        return iwsKhkykjyoutai4;
    }

    public void setIwsKhkykjyoutai4(String pIwsKhkykjyoutai4) {
        iwsKhkykjyoutai4 = pIwsKhkykjyoutai4;
    }

    @Column(order = 631, length = 8)
    private String iwsKhkykymd4;

    public String getIwsKhkykymd4() {
        return iwsKhkykymd4;
    }

    public void setIwsKhkykymd4(String pIwsKhkykymd4) {
        iwsKhkykymd4 = pIwsKhkykymd4;
    }

    @Column(order = 632, length = 2)
    private String iwsKhsyoumetujiyuu4;

    public String getIwsKhsyoumetujiyuu4() {
        return iwsKhsyoumetujiyuu4;
    }

    public void setIwsKhsyoumetujiyuu4(String pIwsKhsyoumetujiyuu4) {
        iwsKhsyoumetujiyuu4 = pIwsKhsyoumetujiyuu4;
    }

    @Column(order = 633, length = 8)
    private String iwsKhsyoumetuymd4;

    public String getIwsKhsyoumetuymd4() {
        return iwsKhsyoumetuymd4;
    }

    public void setIwsKhsyoumetuymd4(String pIwsKhsyoumetuymd4) {
        iwsKhsyoumetuymd4 = pIwsKhsyoumetuymd4;
    }

    @Column(order = 634, length = 2)
    private String iwsKhsyouhncd4;

    public String getIwsKhsyouhncd4() {
        return iwsKhsyouhncd4;
    }

    public void setIwsKhsyouhncd4(String pIwsKhsyouhncd4) {
        iwsKhsyouhncd4 = pIwsKhsyouhncd4;
    }

    @Column(order = 635, length = 6)
    private String iwsKhbosyuuym4;

    public String getIwsKhbosyuuym4() {
        return iwsKhbosyuuym4;
    }

    public void setIwsKhbosyuuym4(String pIwsKhbosyuuym4) {
        iwsKhbosyuuym4 = pIwsKhbosyuuym4;
    }

    @Column(order = 636, length = 8)
    private String iwsKhtaisyouseiymd4;

    public String getIwsKhtaisyouseiymd4() {
        return iwsKhtaisyouseiymd4;
    }

    public void setIwsKhtaisyouseiymd4(String pIwsKhtaisyouseiymd4) {
        iwsKhtaisyouseiymd4 = pIwsKhtaisyouseiymd4;
    }

    @Column(order = 637, length = 2)
    private String iwsKhsyouhnsdno4;

    public String getIwsKhsyouhnsdno4() {
        return iwsKhsyouhnsdno4;
    }

    public void setIwsKhsyouhnsdno4(String pIwsKhsyouhnsdno4) {
        iwsKhsyouhnsdno4 = pIwsKhsyouhnsdno4;
    }

    @Column(order = 638, length = 11)
    private String iwsKhsyono5;

    public String getIwsKhsyono5() {
        return iwsKhsyono5;
    }

    public void setIwsKhsyono5(String pIwsKhsyono5) {
        iwsKhsyono5 = pIwsKhsyono5;
    }

    @Column(order = 639, length = 2)
    private String iwsKhkykfsegkbn5;

    public String getIwsKhkykfsegkbn5() {
        return iwsKhkykfsegkbn5;
    }

    public void setIwsKhkykfsegkbn5(String pIwsKhkykfsegkbn5) {
        iwsKhkykfsegkbn5 = pIwsKhkykfsegkbn5;
    }

    @Column(order = 640, length = 2)
    private String iwsKhkykfkojinkbn5;

    public String getIwsKhkykfkojinkbn5() {
        return iwsKhkykfkojinkbn5;
    }

    public void setIwsKhkykfkojinkbn5(String pIwsKhkykfkojinkbn5) {
        iwsKhkykfkojinkbn5 = pIwsKhkykfkojinkbn5;
    }

    @Column(order = 641, length = 1)
    private String iwsKhyuukousyoumetukbn5;

    public String getIwsKhyuukousyoumetukbn5() {
        return iwsKhyuukousyoumetukbn5;
    }

    public void setIwsKhyuukousyoumetukbn5(String pIwsKhyuukousyoumetukbn5) {
        iwsKhyuukousyoumetukbn5 = pIwsKhyuukousyoumetukbn5;
    }

    @Column(order = 642, length = 2)
    private String iwsKhkykjyoutai5;

    public String getIwsKhkykjyoutai5() {
        return iwsKhkykjyoutai5;
    }

    public void setIwsKhkykjyoutai5(String pIwsKhkykjyoutai5) {
        iwsKhkykjyoutai5 = pIwsKhkykjyoutai5;
    }

    @Column(order = 643, length = 8)
    private String iwsKhkykymd5;

    public String getIwsKhkykymd5() {
        return iwsKhkykymd5;
    }

    public void setIwsKhkykymd5(String pIwsKhkykymd5) {
        iwsKhkykymd5 = pIwsKhkykymd5;
    }

    @Column(order = 644, length = 2)
    private String iwsKhsyoumetujiyuu5;

    public String getIwsKhsyoumetujiyuu5() {
        return iwsKhsyoumetujiyuu5;
    }

    public void setIwsKhsyoumetujiyuu5(String pIwsKhsyoumetujiyuu5) {
        iwsKhsyoumetujiyuu5 = pIwsKhsyoumetujiyuu5;
    }

    @Column(order = 645, length = 8)
    private String iwsKhsyoumetuymd5;

    public String getIwsKhsyoumetuymd5() {
        return iwsKhsyoumetuymd5;
    }

    public void setIwsKhsyoumetuymd5(String pIwsKhsyoumetuymd5) {
        iwsKhsyoumetuymd5 = pIwsKhsyoumetuymd5;
    }

    @Column(order = 646, length = 2)
    private String iwsKhsyouhncd5;

    public String getIwsKhsyouhncd5() {
        return iwsKhsyouhncd5;
    }

    public void setIwsKhsyouhncd5(String pIwsKhsyouhncd5) {
        iwsKhsyouhncd5 = pIwsKhsyouhncd5;
    }

    @Column(order = 647, length = 6)
    private String iwsKhbosyuuym5;

    public String getIwsKhbosyuuym5() {
        return iwsKhbosyuuym5;
    }

    public void setIwsKhbosyuuym5(String pIwsKhbosyuuym5) {
        iwsKhbosyuuym5 = pIwsKhbosyuuym5;
    }

    @Column(order = 648, length = 8)
    private String iwsKhtaisyouseiymd5;

    public String getIwsKhtaisyouseiymd5() {
        return iwsKhtaisyouseiymd5;
    }

    public void setIwsKhtaisyouseiymd5(String pIwsKhtaisyouseiymd5) {
        iwsKhtaisyouseiymd5 = pIwsKhtaisyouseiymd5;
    }

    @Column(order = 649, length = 2)
    private String iwsKhsyouhnsdno5;

    public String getIwsKhsyouhnsdno5() {
        return iwsKhsyouhnsdno5;
    }

    public void setIwsKhsyouhnsdno5(String pIwsKhsyouhnsdno5) {
        iwsKhsyouhnsdno5 = pIwsKhsyouhnsdno5;
    }

    @Column(order = 650, length = 11)
    private String iwsKhsyono6;

    public String getIwsKhsyono6() {
        return iwsKhsyono6;
    }

    public void setIwsKhsyono6(String pIwsKhsyono6) {
        iwsKhsyono6 = pIwsKhsyono6;
    }

    @Column(order = 651, length = 2)
    private String iwsKhkykfsegkbn6;

    public String getIwsKhkykfsegkbn6() {
        return iwsKhkykfsegkbn6;
    }

    public void setIwsKhkykfsegkbn6(String pIwsKhkykfsegkbn6) {
        iwsKhkykfsegkbn6 = pIwsKhkykfsegkbn6;
    }

    @Column(order = 652, length = 2)
    private String iwsKhkykfkojinkbn6;

    public String getIwsKhkykfkojinkbn6() {
        return iwsKhkykfkojinkbn6;
    }

    public void setIwsKhkykfkojinkbn6(String pIwsKhkykfkojinkbn6) {
        iwsKhkykfkojinkbn6 = pIwsKhkykfkojinkbn6;
    }

    @Column(order = 653, length = 1)
    private String iwsKhyuukousyoumetukbn6;

    public String getIwsKhyuukousyoumetukbn6() {
        return iwsKhyuukousyoumetukbn6;
    }

    public void setIwsKhyuukousyoumetukbn6(String pIwsKhyuukousyoumetukbn6) {
        iwsKhyuukousyoumetukbn6 = pIwsKhyuukousyoumetukbn6;
    }

    @Column(order = 654, length = 2)
    private String iwsKhkykjyoutai6;

    public String getIwsKhkykjyoutai6() {
        return iwsKhkykjyoutai6;
    }

    public void setIwsKhkykjyoutai6(String pIwsKhkykjyoutai6) {
        iwsKhkykjyoutai6 = pIwsKhkykjyoutai6;
    }

    @Column(order = 655, length = 8)
    private String iwsKhkykymd6;

    public String getIwsKhkykymd6() {
        return iwsKhkykymd6;
    }

    public void setIwsKhkykymd6(String pIwsKhkykymd6) {
        iwsKhkykymd6 = pIwsKhkykymd6;
    }

    @Column(order = 656, length = 2)
    private String iwsKhsyoumetujiyuu6;

    public String getIwsKhsyoumetujiyuu6() {
        return iwsKhsyoumetujiyuu6;
    }

    public void setIwsKhsyoumetujiyuu6(String pIwsKhsyoumetujiyuu6) {
        iwsKhsyoumetujiyuu6 = pIwsKhsyoumetujiyuu6;
    }

    @Column(order = 657, length = 8)
    private String iwsKhsyoumetuymd6;

    public String getIwsKhsyoumetuymd6() {
        return iwsKhsyoumetuymd6;
    }

    public void setIwsKhsyoumetuymd6(String pIwsKhsyoumetuymd6) {
        iwsKhsyoumetuymd6 = pIwsKhsyoumetuymd6;
    }

    @Column(order = 658, length = 2)
    private String iwsKhsyouhncd6;

    public String getIwsKhsyouhncd6() {
        return iwsKhsyouhncd6;
    }

    public void setIwsKhsyouhncd6(String pIwsKhsyouhncd6) {
        iwsKhsyouhncd6 = pIwsKhsyouhncd6;
    }

    @Column(order = 659, length = 6)
    private String iwsKhbosyuuym6;

    public String getIwsKhbosyuuym6() {
        return iwsKhbosyuuym6;
    }

    public void setIwsKhbosyuuym6(String pIwsKhbosyuuym6) {
        iwsKhbosyuuym6 = pIwsKhbosyuuym6;
    }

    @Column(order = 660, length = 8)
    private String iwsKhtaisyouseiymd6;

    public String getIwsKhtaisyouseiymd6() {
        return iwsKhtaisyouseiymd6;
    }

    public void setIwsKhtaisyouseiymd6(String pIwsKhtaisyouseiymd6) {
        iwsKhtaisyouseiymd6 = pIwsKhtaisyouseiymd6;
    }

    @Column(order = 661, length = 2)
    private String iwsKhsyouhnsdno6;

    public String getIwsKhsyouhnsdno6() {
        return iwsKhsyouhnsdno6;
    }

    public void setIwsKhsyouhnsdno6(String pIwsKhsyouhnsdno6) {
        iwsKhsyouhnsdno6 = pIwsKhsyouhnsdno6;
    }

    @Column(order = 662, length = 11)
    private String iwsKhsyono7;

    public String getIwsKhsyono7() {
        return iwsKhsyono7;
    }

    public void setIwsKhsyono7(String pIwsKhsyono7) {
        iwsKhsyono7 = pIwsKhsyono7;
    }

    @Column(order = 663, length = 2)
    private String iwsKhkykfsegkbn7;

    public String getIwsKhkykfsegkbn7() {
        return iwsKhkykfsegkbn7;
    }

    public void setIwsKhkykfsegkbn7(String pIwsKhkykfsegkbn7) {
        iwsKhkykfsegkbn7 = pIwsKhkykfsegkbn7;
    }

    @Column(order = 664, length = 2)
    private String iwsKhkykfkojinkbn7;

    public String getIwsKhkykfkojinkbn7() {
        return iwsKhkykfkojinkbn7;
    }

    public void setIwsKhkykfkojinkbn7(String pIwsKhkykfkojinkbn7) {
        iwsKhkykfkojinkbn7 = pIwsKhkykfkojinkbn7;
    }

    @Column(order = 665, length = 1)
    private String iwsKhyuukousyoumetukbn7;

    public String getIwsKhyuukousyoumetukbn7() {
        return iwsKhyuukousyoumetukbn7;
    }

    public void setIwsKhyuukousyoumetukbn7(String pIwsKhyuukousyoumetukbn7) {
        iwsKhyuukousyoumetukbn7 = pIwsKhyuukousyoumetukbn7;
    }

    @Column(order = 666, length = 2)
    private String iwsKhkykjyoutai7;

    public String getIwsKhkykjyoutai7() {
        return iwsKhkykjyoutai7;
    }

    public void setIwsKhkykjyoutai7(String pIwsKhkykjyoutai7) {
        iwsKhkykjyoutai7 = pIwsKhkykjyoutai7;
    }

    @Column(order = 667, length = 8)
    private String iwsKhkykymd7;

    public String getIwsKhkykymd7() {
        return iwsKhkykymd7;
    }

    public void setIwsKhkykymd7(String pIwsKhkykymd7) {
        iwsKhkykymd7 = pIwsKhkykymd7;
    }

    @Column(order = 668, length = 2)
    private String iwsKhsyoumetujiyuu7;

    public String getIwsKhsyoumetujiyuu7() {
        return iwsKhsyoumetujiyuu7;
    }

    public void setIwsKhsyoumetujiyuu7(String pIwsKhsyoumetujiyuu7) {
        iwsKhsyoumetujiyuu7 = pIwsKhsyoumetujiyuu7;
    }

    @Column(order = 669, length = 8)
    private String iwsKhsyoumetuymd7;

    public String getIwsKhsyoumetuymd7() {
        return iwsKhsyoumetuymd7;
    }

    public void setIwsKhsyoumetuymd7(String pIwsKhsyoumetuymd7) {
        iwsKhsyoumetuymd7 = pIwsKhsyoumetuymd7;
    }

    @Column(order = 670, length = 2)
    private String iwsKhsyouhncd7;

    public String getIwsKhsyouhncd7() {
        return iwsKhsyouhncd7;
    }

    public void setIwsKhsyouhncd7(String pIwsKhsyouhncd7) {
        iwsKhsyouhncd7 = pIwsKhsyouhncd7;
    }

    @Column(order = 671, length = 6)
    private String iwsKhbosyuuym7;

    public String getIwsKhbosyuuym7() {
        return iwsKhbosyuuym7;
    }

    public void setIwsKhbosyuuym7(String pIwsKhbosyuuym7) {
        iwsKhbosyuuym7 = pIwsKhbosyuuym7;
    }

    @Column(order = 672, length = 8)
    private String iwsKhtaisyouseiymd7;

    public String getIwsKhtaisyouseiymd7() {
        return iwsKhtaisyouseiymd7;
    }

    public void setIwsKhtaisyouseiymd7(String pIwsKhtaisyouseiymd7) {
        iwsKhtaisyouseiymd7 = pIwsKhtaisyouseiymd7;
    }

    @Column(order = 673, length = 2)
    private String iwsKhsyouhnsdno7;

    public String getIwsKhsyouhnsdno7() {
        return iwsKhsyouhnsdno7;
    }

    public void setIwsKhsyouhnsdno7(String pIwsKhsyouhnsdno7) {
        iwsKhsyouhnsdno7 = pIwsKhsyouhnsdno7;
    }

    @Column(order = 674, length = 11)
    private String iwsKhsyono8;

    public String getIwsKhsyono8() {
        return iwsKhsyono8;
    }

    public void setIwsKhsyono8(String pIwsKhsyono8) {
        iwsKhsyono8 = pIwsKhsyono8;
    }

    @Column(order = 675, length = 2)
    private String iwsKhkykfsegkbn8;

    public String getIwsKhkykfsegkbn8() {
        return iwsKhkykfsegkbn8;
    }

    public void setIwsKhkykfsegkbn8(String pIwsKhkykfsegkbn8) {
        iwsKhkykfsegkbn8 = pIwsKhkykfsegkbn8;
    }

    @Column(order = 676, length = 2)
    private String iwsKhkykfkojinkbn8;

    public String getIwsKhkykfkojinkbn8() {
        return iwsKhkykfkojinkbn8;
    }

    public void setIwsKhkykfkojinkbn8(String pIwsKhkykfkojinkbn8) {
        iwsKhkykfkojinkbn8 = pIwsKhkykfkojinkbn8;
    }

    @Column(order = 677, length = 1)
    private String iwsKhyuukousyoumetukbn8;

    public String getIwsKhyuukousyoumetukbn8() {
        return iwsKhyuukousyoumetukbn8;
    }

    public void setIwsKhyuukousyoumetukbn8(String pIwsKhyuukousyoumetukbn8) {
        iwsKhyuukousyoumetukbn8 = pIwsKhyuukousyoumetukbn8;
    }

    @Column(order = 678, length = 2)
    private String iwsKhkykjyoutai8;

    public String getIwsKhkykjyoutai8() {
        return iwsKhkykjyoutai8;
    }

    public void setIwsKhkykjyoutai8(String pIwsKhkykjyoutai8) {
        iwsKhkykjyoutai8 = pIwsKhkykjyoutai8;
    }

    @Column(order = 679, length = 8)
    private String iwsKhkykymd8;

    public String getIwsKhkykymd8() {
        return iwsKhkykymd8;
    }

    public void setIwsKhkykymd8(String pIwsKhkykymd8) {
        iwsKhkykymd8 = pIwsKhkykymd8;
    }

    @Column(order = 680, length = 2)
    private String iwsKhsyoumetujiyuu8;

    public String getIwsKhsyoumetujiyuu8() {
        return iwsKhsyoumetujiyuu8;
    }

    public void setIwsKhsyoumetujiyuu8(String pIwsKhsyoumetujiyuu8) {
        iwsKhsyoumetujiyuu8 = pIwsKhsyoumetujiyuu8;
    }

    @Column(order = 681, length = 8)
    private String iwsKhsyoumetuymd8;

    public String getIwsKhsyoumetuymd8() {
        return iwsKhsyoumetuymd8;
    }

    public void setIwsKhsyoumetuymd8(String pIwsKhsyoumetuymd8) {
        iwsKhsyoumetuymd8 = pIwsKhsyoumetuymd8;
    }

    @Column(order = 682, length = 2)
    private String iwsKhsyouhncd8;

    public String getIwsKhsyouhncd8() {
        return iwsKhsyouhncd8;
    }

    public void setIwsKhsyouhncd8(String pIwsKhsyouhncd8) {
        iwsKhsyouhncd8 = pIwsKhsyouhncd8;
    }

    @Column(order = 683, length = 6)
    private String iwsKhbosyuuym8;

    public String getIwsKhbosyuuym8() {
        return iwsKhbosyuuym8;
    }

    public void setIwsKhbosyuuym8(String pIwsKhbosyuuym8) {
        iwsKhbosyuuym8 = pIwsKhbosyuuym8;
    }

    @Column(order = 684, length = 8)
    private String iwsKhtaisyouseiymd8;

    public String getIwsKhtaisyouseiymd8() {
        return iwsKhtaisyouseiymd8;
    }

    public void setIwsKhtaisyouseiymd8(String pIwsKhtaisyouseiymd8) {
        iwsKhtaisyouseiymd8 = pIwsKhtaisyouseiymd8;
    }

    @Column(order = 685, length = 2)
    private String iwsKhsyouhnsdno8;

    public String getIwsKhsyouhnsdno8() {
        return iwsKhsyouhnsdno8;
    }

    public void setIwsKhsyouhnsdno8(String pIwsKhsyouhnsdno8) {
        iwsKhsyouhnsdno8 = pIwsKhsyouhnsdno8;
    }

    @Column(order = 686, length = 11)
    private String iwsKhsyono9;

    public String getIwsKhsyono9() {
        return iwsKhsyono9;
    }

    public void setIwsKhsyono9(String pIwsKhsyono9) {
        iwsKhsyono9 = pIwsKhsyono9;
    }

    @Column(order = 687, length = 2)
    private String iwsKhkykfsegkbn9;

    public String getIwsKhkykfsegkbn9() {
        return iwsKhkykfsegkbn9;
    }

    public void setIwsKhkykfsegkbn9(String pIwsKhkykfsegkbn9) {
        iwsKhkykfsegkbn9 = pIwsKhkykfsegkbn9;
    }

    @Column(order = 688, length = 2)
    private String iwsKhkykfkojinkbn9;

    public String getIwsKhkykfkojinkbn9() {
        return iwsKhkykfkojinkbn9;
    }

    public void setIwsKhkykfkojinkbn9(String pIwsKhkykfkojinkbn9) {
        iwsKhkykfkojinkbn9 = pIwsKhkykfkojinkbn9;
    }

    @Column(order = 689, length = 1)
    private String iwsKhyuukousyoumetukbn9;

    public String getIwsKhyuukousyoumetukbn9() {
        return iwsKhyuukousyoumetukbn9;
    }

    public void setIwsKhyuukousyoumetukbn9(String pIwsKhyuukousyoumetukbn9) {
        iwsKhyuukousyoumetukbn9 = pIwsKhyuukousyoumetukbn9;
    }

    @Column(order = 690, length = 2)
    private String iwsKhkykjyoutai9;

    public String getIwsKhkykjyoutai9() {
        return iwsKhkykjyoutai9;
    }

    public void setIwsKhkykjyoutai9(String pIwsKhkykjyoutai9) {
        iwsKhkykjyoutai9 = pIwsKhkykjyoutai9;
    }

    @Column(order = 691, length = 8)
    private String iwsKhkykymd9;

    public String getIwsKhkykymd9() {
        return iwsKhkykymd9;
    }

    public void setIwsKhkykymd9(String pIwsKhkykymd9) {
        iwsKhkykymd9 = pIwsKhkykymd9;
    }

    @Column(order = 692, length = 2)
    private String iwsKhsyoumetujiyuu9;

    public String getIwsKhsyoumetujiyuu9() {
        return iwsKhsyoumetujiyuu9;
    }

    public void setIwsKhsyoumetujiyuu9(String pIwsKhsyoumetujiyuu9) {
        iwsKhsyoumetujiyuu9 = pIwsKhsyoumetujiyuu9;
    }

    @Column(order = 693, length = 8)
    private String iwsKhsyoumetuymd9;

    public String getIwsKhsyoumetuymd9() {
        return iwsKhsyoumetuymd9;
    }

    public void setIwsKhsyoumetuymd9(String pIwsKhsyoumetuymd9) {
        iwsKhsyoumetuymd9 = pIwsKhsyoumetuymd9;
    }

    @Column(order = 694, length = 2)
    private String iwsKhsyouhncd9;

    public String getIwsKhsyouhncd9() {
        return iwsKhsyouhncd9;
    }

    public void setIwsKhsyouhncd9(String pIwsKhsyouhncd9) {
        iwsKhsyouhncd9 = pIwsKhsyouhncd9;
    }

    @Column(order = 695, length = 6)
    private String iwsKhbosyuuym9;

    public String getIwsKhbosyuuym9() {
        return iwsKhbosyuuym9;
    }

    public void setIwsKhbosyuuym9(String pIwsKhbosyuuym9) {
        iwsKhbosyuuym9 = pIwsKhbosyuuym9;
    }

    @Column(order = 696, length = 8)
    private String iwsKhtaisyouseiymd9;

    public String getIwsKhtaisyouseiymd9() {
        return iwsKhtaisyouseiymd9;
    }

    public void setIwsKhtaisyouseiymd9(String pIwsKhtaisyouseiymd9) {
        iwsKhtaisyouseiymd9 = pIwsKhtaisyouseiymd9;
    }

    @Column(order = 697, length = 2)
    private String iwsKhsyouhnsdno9;

    public String getIwsKhsyouhnsdno9() {
        return iwsKhsyouhnsdno9;
    }

    public void setIwsKhsyouhnsdno9(String pIwsKhsyouhnsdno9) {
        iwsKhsyouhnsdno9 = pIwsKhsyouhnsdno9;
    }

    @Column(order = 698, length = 11)
    private String iwsKhsyono10;

    public String getIwsKhsyono10() {
        return iwsKhsyono10;
    }

    public void setIwsKhsyono10(String pIwsKhsyono10) {
        iwsKhsyono10 = pIwsKhsyono10;
    }

    @Column(order = 699, length = 2)
    private String iwsKhkykfsegkbn10;

    public String getIwsKhkykfsegkbn10() {
        return iwsKhkykfsegkbn10;
    }

    public void setIwsKhkykfsegkbn10(String pIwsKhkykfsegkbn10) {
        iwsKhkykfsegkbn10 = pIwsKhkykfsegkbn10;
    }

    @Column(order = 700, length = 2)
    private String iwsKhkykfkojinkbn10;

    public String getIwsKhkykfkojinkbn10() {
        return iwsKhkykfkojinkbn10;
    }

    public void setIwsKhkykfkojinkbn10(String pIwsKhkykfkojinkbn10) {
        iwsKhkykfkojinkbn10 = pIwsKhkykfkojinkbn10;
    }

    @Column(order = 701, length = 1)
    private String iwsKhyuukousyoumetukbn10;

    public String getIwsKhyuukousyoumetukbn10() {
        return iwsKhyuukousyoumetukbn10;
    }

    public void setIwsKhyuukousyoumetukbn10(String pIwsKhyuukousyoumetukbn10) {
        iwsKhyuukousyoumetukbn10 = pIwsKhyuukousyoumetukbn10;
    }

    @Column(order = 702, length = 2)
    private String iwsKhkykjyoutai10;

    public String getIwsKhkykjyoutai10() {
        return iwsKhkykjyoutai10;
    }

    public void setIwsKhkykjyoutai10(String pIwsKhkykjyoutai10) {
        iwsKhkykjyoutai10 = pIwsKhkykjyoutai10;
    }

    @Column(order = 703, length = 8)
    private String iwsKhkykymd10;

    public String getIwsKhkykymd10() {
        return iwsKhkykymd10;
    }

    public void setIwsKhkykymd10(String pIwsKhkykymd10) {
        iwsKhkykymd10 = pIwsKhkykymd10;
    }

    @Column(order = 704, length = 2)
    private String iwsKhsyoumetujiyuu10;

    public String getIwsKhsyoumetujiyuu10() {
        return iwsKhsyoumetujiyuu10;
    }

    public void setIwsKhsyoumetujiyuu10(String pIwsKhsyoumetujiyuu10) {
        iwsKhsyoumetujiyuu10 = pIwsKhsyoumetujiyuu10;
    }

    @Column(order = 705, length = 8)
    private String iwsKhsyoumetuymd10;

    public String getIwsKhsyoumetuymd10() {
        return iwsKhsyoumetuymd10;
    }

    public void setIwsKhsyoumetuymd10(String pIwsKhsyoumetuymd10) {
        iwsKhsyoumetuymd10 = pIwsKhsyoumetuymd10;
    }

    @Column(order = 706, length = 2)
    private String iwsKhsyouhncd10;

    public String getIwsKhsyouhncd10() {
        return iwsKhsyouhncd10;
    }

    public void setIwsKhsyouhncd10(String pIwsKhsyouhncd10) {
        iwsKhsyouhncd10 = pIwsKhsyouhncd10;
    }

    @Column(order = 707, length = 6)
    private String iwsKhbosyuuym10;

    public String getIwsKhbosyuuym10() {
        return iwsKhbosyuuym10;
    }

    public void setIwsKhbosyuuym10(String pIwsKhbosyuuym10) {
        iwsKhbosyuuym10 = pIwsKhbosyuuym10;
    }

    @Column(order = 708, length = 8)
    private String iwsKhtaisyouseiymd10;

    public String getIwsKhtaisyouseiymd10() {
        return iwsKhtaisyouseiymd10;
    }

    public void setIwsKhtaisyouseiymd10(String pIwsKhtaisyouseiymd10) {
        iwsKhtaisyouseiymd10 = pIwsKhtaisyouseiymd10;
    }

    @Column(order = 709, length = 2)
    private String iwsKhsyouhnsdno10;

    public String getIwsKhsyouhnsdno10() {
        return iwsKhsyouhnsdno10;
    }

    public void setIwsKhsyouhnsdno10(String pIwsKhsyouhnsdno10) {
        iwsKhsyouhnsdno10 = pIwsKhsyouhnsdno10;
    }

    @Column(order = 710, length = 9)
    private String iwsSkmosno1;

    public String getIwsSkmosno1() {
        return iwsSkmosno1;
    }

    public void setIwsSkmosno1(String pIwsSkmosno1) {
        iwsSkmosno1 = pIwsSkmosno1;
    }

    @Column(order = 711, length = 2)
    private String iwsSkskfsegkbn1;

    public String getIwsSkskfsegkbn1() {
        return iwsSkskfsegkbn1;
    }

    public void setIwsSkskfsegkbn1(String pIwsSkskfsegkbn1) {
        iwsSkskfsegkbn1 = pIwsSkskfsegkbn1;
    }

    @Column(order = 712, length = 2)
    private String iwsSkskfkojinkbn1;

    public String getIwsSkskfkojinkbn1() {
        return iwsSkskfkojinkbn1;
    }

    public void setIwsSkskfkojinkbn1(String pIwsSkskfkojinkbn1) {
        iwsSkskfkojinkbn1 = pIwsSkskfkojinkbn1;
    }

    @Column(order = 713, length = 1)
    private String iwsSkmfrenflg1;

    public String getIwsSkmfrenflg1() {
        return iwsSkmfrenflg1;
    }

    public void setIwsSkmfrenflg1(String pIwsSkmfrenflg1) {
        iwsSkmfrenflg1 = pIwsSkmfrenflg1;
    }

    @Column(order = 714, length = 8)
    private String iwsSkmosymd1;

    public String getIwsSkmosymd1() {
        return iwsSkmosymd1;
    }

    public void setIwsSkmosymd1(String pIwsSkmosymd1) {
        iwsSkmosymd1 = pIwsSkmosymd1;
    }

    @Column(order = 715, length = 8)
    private String iwsSkkykymd1;

    public String getIwsSkkykymd1() {
        return iwsSkkykymd1;
    }

    public void setIwsSkkykymd1(String pIwsSkkykymd1) {
        iwsSkkykymd1 = pIwsSkkykymd1;
    }

    @Column(order = 716, length = 1)
    private String iwsSkseiritukbn1;

    public String getIwsSkseiritukbn1() {
        return iwsSkseiritukbn1;
    }

    public void setIwsSkseiritukbn1(String pIwsSkseiritukbn1) {
        iwsSkseiritukbn1 = pIwsSkseiritukbn1;
    }

    @Column(order = 717, length = 8)
    private String iwsSksrsyoriymd1;

    public String getIwsSksrsyoriymd1() {
        return iwsSksrsyoriymd1;
    }

    public void setIwsSksrsyoriymd1(String pIwsSksrsyoriymd1) {
        iwsSksrsyoriymd1 = pIwsSksrsyoriymd1;
    }

    @Column(order = 718, length = 2)
    private String iwsSksyouhncd1;

    public String getIwsSksyouhncd1() {
        return iwsSksyouhncd1;
    }

    public void setIwsSksyouhncd1(String pIwsSksyouhncd1) {
        iwsSksyouhncd1 = pIwsSksyouhncd1;
    }

    @Column(order = 719, length = 6)
    private String iwsSkbosyuuym1;

    public String getIwsSkbosyuuym1() {
        return iwsSkbosyuuym1;
    }

    public void setIwsSkbosyuuym1(String pIwsSkbosyuuym1) {
        iwsSkbosyuuym1 = pIwsSkbosyuuym1;
    }

    @Column(order = 720, length = 1)
    private String iwsSktaisyounayosejtkbn1;

    public String getIwsSktaisyounayosejtkbn1() {
        return iwsSktaisyounayosejtkbn1;
    }

    public void setIwsSktaisyounayosejtkbn1(String pIwsSktaisyounayosejtkbn1) {
        iwsSktaisyounayosejtkbn1 = pIwsSktaisyounayosejtkbn1;
    }

    @Column(order = 721, length = 10)
    private String iwsSktaisyousakuinnmno1;

    public String getIwsSktaisyousakuinnmno1() {
        return iwsSktaisyousakuinnmno1;
    }

    public void setIwsSktaisyousakuinnmno1(String pIwsSktaisyousakuinnmno1) {
        iwsSktaisyousakuinnmno1 = pIwsSktaisyousakuinnmno1;
    }

    @Column(order = 722, length = 8)
    private String iwsSktaisyouseiymd1;

    public String getIwsSktaisyouseiymd1() {
        return iwsSktaisyouseiymd1;
    }

    public void setIwsSktaisyouseiymd1(String pIwsSktaisyouseiymd1) {
        iwsSktaisyouseiymd1 = pIwsSktaisyouseiymd1;
    }

    @Column(order = 723, length = 2)
    private String iwsSksyouhnsdno1;

    public String getIwsSksyouhnsdno1() {
        return iwsSksyouhnsdno1;
    }

    public void setIwsSksyouhnsdno1(String pIwsSksyouhnsdno1) {
        iwsSksyouhnsdno1 = pIwsSksyouhnsdno1;
    }

    @Column(order = 724, length = 9)
    private String iwsSkmosno2;

    public String getIwsSkmosno2() {
        return iwsSkmosno2;
    }

    public void setIwsSkmosno2(String pIwsSkmosno2) {
        iwsSkmosno2 = pIwsSkmosno2;
    }

    @Column(order = 725, length = 2)
    private String iwsSkskfsegkbn2;

    public String getIwsSkskfsegkbn2() {
        return iwsSkskfsegkbn2;
    }

    public void setIwsSkskfsegkbn2(String pIwsSkskfsegkbn2) {
        iwsSkskfsegkbn2 = pIwsSkskfsegkbn2;
    }

    @Column(order = 726, length = 2)
    private String iwsSkskfkojinkbn2;

    public String getIwsSkskfkojinkbn2() {
        return iwsSkskfkojinkbn2;
    }

    public void setIwsSkskfkojinkbn2(String pIwsSkskfkojinkbn2) {
        iwsSkskfkojinkbn2 = pIwsSkskfkojinkbn2;
    }

    @Column(order = 727, length = 1)
    private String iwsSkmfrenflg2;

    public String getIwsSkmfrenflg2() {
        return iwsSkmfrenflg2;
    }

    public void setIwsSkmfrenflg2(String pIwsSkmfrenflg2) {
        iwsSkmfrenflg2 = pIwsSkmfrenflg2;
    }

    @Column(order = 728, length = 8)
    private String iwsSkmosymd2;

    public String getIwsSkmosymd2() {
        return iwsSkmosymd2;
    }

    public void setIwsSkmosymd2(String pIwsSkmosymd2) {
        iwsSkmosymd2 = pIwsSkmosymd2;
    }

    @Column(order = 729, length = 8)
    private String iwsSkkykymd2;

    public String getIwsSkkykymd2() {
        return iwsSkkykymd2;
    }

    public void setIwsSkkykymd2(String pIwsSkkykymd2) {
        iwsSkkykymd2 = pIwsSkkykymd2;
    }

    @Column(order = 730, length = 1)
    private String iwsSkseiritukbn2;

    public String getIwsSkseiritukbn2() {
        return iwsSkseiritukbn2;
    }

    public void setIwsSkseiritukbn2(String pIwsSkseiritukbn2) {
        iwsSkseiritukbn2 = pIwsSkseiritukbn2;
    }

    @Column(order = 731, length = 8)
    private String iwsSksrsyoriymd2;

    public String getIwsSksrsyoriymd2() {
        return iwsSksrsyoriymd2;
    }

    public void setIwsSksrsyoriymd2(String pIwsSksrsyoriymd2) {
        iwsSksrsyoriymd2 = pIwsSksrsyoriymd2;
    }

    @Column(order = 732, length = 2)
    private String iwsSksyouhncd2;

    public String getIwsSksyouhncd2() {
        return iwsSksyouhncd2;
    }

    public void setIwsSksyouhncd2(String pIwsSksyouhncd2) {
        iwsSksyouhncd2 = pIwsSksyouhncd2;
    }

    @Column(order = 733, length = 6)
    private String iwsSkbosyuuym2;

    public String getIwsSkbosyuuym2() {
        return iwsSkbosyuuym2;
    }

    public void setIwsSkbosyuuym2(String pIwsSkbosyuuym2) {
        iwsSkbosyuuym2 = pIwsSkbosyuuym2;
    }

    @Column(order = 734, length = 1)
    private String iwsSktaisyounayosejtkbn2;

    public String getIwsSktaisyounayosejtkbn2() {
        return iwsSktaisyounayosejtkbn2;
    }

    public void setIwsSktaisyounayosejtkbn2(String pIwsSktaisyounayosejtkbn2) {
        iwsSktaisyounayosejtkbn2 = pIwsSktaisyounayosejtkbn2;
    }

    @Column(order = 735, length = 10)
    private String iwsSktaisyousakuinnmno2;

    public String getIwsSktaisyousakuinnmno2() {
        return iwsSktaisyousakuinnmno2;
    }

    public void setIwsSktaisyousakuinnmno2(String pIwsSktaisyousakuinnmno2) {
        iwsSktaisyousakuinnmno2 = pIwsSktaisyousakuinnmno2;
    }

    @Column(order = 736, length = 8)
    private String iwsSktaisyouseiymd2;

    public String getIwsSktaisyouseiymd2() {
        return iwsSktaisyouseiymd2;
    }

    public void setIwsSktaisyouseiymd2(String pIwsSktaisyouseiymd2) {
        iwsSktaisyouseiymd2 = pIwsSktaisyouseiymd2;
    }

    @Column(order = 737, length = 2)
    private String iwsSksyouhnsdno2;

    public String getIwsSksyouhnsdno2() {
        return iwsSksyouhnsdno2;
    }

    public void setIwsSksyouhnsdno2(String pIwsSksyouhnsdno2) {
        iwsSksyouhnsdno2 = pIwsSksyouhnsdno2;
    }

    @Column(order = 738, length = 9)
    private String iwsSkmosno3;

    public String getIwsSkmosno3() {
        return iwsSkmosno3;
    }

    public void setIwsSkmosno3(String pIwsSkmosno3) {
        iwsSkmosno3 = pIwsSkmosno3;
    }

    @Column(order = 739, length = 2)
    private String iwsSkskfsegkbn3;

    public String getIwsSkskfsegkbn3() {
        return iwsSkskfsegkbn3;
    }

    public void setIwsSkskfsegkbn3(String pIwsSkskfsegkbn3) {
        iwsSkskfsegkbn3 = pIwsSkskfsegkbn3;
    }

    @Column(order = 740, length = 2)
    private String iwsSkskfkojinkbn3;

    public String getIwsSkskfkojinkbn3() {
        return iwsSkskfkojinkbn3;
    }

    public void setIwsSkskfkojinkbn3(String pIwsSkskfkojinkbn3) {
        iwsSkskfkojinkbn3 = pIwsSkskfkojinkbn3;
    }

    @Column(order = 741, length = 1)
    private String iwsSkmfrenflg3;

    public String getIwsSkmfrenflg3() {
        return iwsSkmfrenflg3;
    }

    public void setIwsSkmfrenflg3(String pIwsSkmfrenflg3) {
        iwsSkmfrenflg3 = pIwsSkmfrenflg3;
    }

    @Column(order = 742, length = 8)
    private String iwsSkmosymd3;

    public String getIwsSkmosymd3() {
        return iwsSkmosymd3;
    }

    public void setIwsSkmosymd3(String pIwsSkmosymd3) {
        iwsSkmosymd3 = pIwsSkmosymd3;
    }

    @Column(order = 743, length = 8)
    private String iwsSkkykymd3;

    public String getIwsSkkykymd3() {
        return iwsSkkykymd3;
    }

    public void setIwsSkkykymd3(String pIwsSkkykymd3) {
        iwsSkkykymd3 = pIwsSkkykymd3;
    }

    @Column(order = 744, length = 1)
    private String iwsSkseiritukbn3;

    public String getIwsSkseiritukbn3() {
        return iwsSkseiritukbn3;
    }

    public void setIwsSkseiritukbn3(String pIwsSkseiritukbn3) {
        iwsSkseiritukbn3 = pIwsSkseiritukbn3;
    }

    @Column(order = 745, length = 8)
    private String iwsSksrsyoriymd3;

    public String getIwsSksrsyoriymd3() {
        return iwsSksrsyoriymd3;
    }

    public void setIwsSksrsyoriymd3(String pIwsSksrsyoriymd3) {
        iwsSksrsyoriymd3 = pIwsSksrsyoriymd3;
    }

    @Column(order = 746, length = 2)
    private String iwsSksyouhncd3;

    public String getIwsSksyouhncd3() {
        return iwsSksyouhncd3;
    }

    public void setIwsSksyouhncd3(String pIwsSksyouhncd3) {
        iwsSksyouhncd3 = pIwsSksyouhncd3;
    }

    @Column(order = 747, length = 6)
    private String iwsSkbosyuuym3;

    public String getIwsSkbosyuuym3() {
        return iwsSkbosyuuym3;
    }

    public void setIwsSkbosyuuym3(String pIwsSkbosyuuym3) {
        iwsSkbosyuuym3 = pIwsSkbosyuuym3;
    }

    @Column(order = 748, length = 1)
    private String iwsSktaisyounayosejtkbn3;

    public String getIwsSktaisyounayosejtkbn3() {
        return iwsSktaisyounayosejtkbn3;
    }

    public void setIwsSktaisyounayosejtkbn3(String pIwsSktaisyounayosejtkbn3) {
        iwsSktaisyounayosejtkbn3 = pIwsSktaisyounayosejtkbn3;
    }

    @Column(order = 749, length = 10)
    private String iwsSktaisyousakuinnmno3;

    public String getIwsSktaisyousakuinnmno3() {
        return iwsSktaisyousakuinnmno3;
    }

    public void setIwsSktaisyousakuinnmno3(String pIwsSktaisyousakuinnmno3) {
        iwsSktaisyousakuinnmno3 = pIwsSktaisyousakuinnmno3;
    }

    @Column(order = 750, length = 8)
    private String iwsSktaisyouseiymd3;

    public String getIwsSktaisyouseiymd3() {
        return iwsSktaisyouseiymd3;
    }

    public void setIwsSktaisyouseiymd3(String pIwsSktaisyouseiymd3) {
        iwsSktaisyouseiymd3 = pIwsSktaisyouseiymd3;
    }

    @Column(order = 751, length = 2)
    private String iwsSksyouhnsdno3;

    public String getIwsSksyouhnsdno3() {
        return iwsSksyouhnsdno3;
    }

    public void setIwsSksyouhnsdno3(String pIwsSksyouhnsdno3) {
        iwsSksyouhnsdno3 = pIwsSksyouhnsdno3;
    }

    @Column(order = 752, length = 9)
    private String iwsSkmosno4;

    public String getIwsSkmosno4() {
        return iwsSkmosno4;
    }

    public void setIwsSkmosno4(String pIwsSkmosno4) {
        iwsSkmosno4 = pIwsSkmosno4;
    }

    @Column(order = 753, length = 2)
    private String iwsSkskfsegkbn4;

    public String getIwsSkskfsegkbn4() {
        return iwsSkskfsegkbn4;
    }

    public void setIwsSkskfsegkbn4(String pIwsSkskfsegkbn4) {
        iwsSkskfsegkbn4 = pIwsSkskfsegkbn4;
    }

    @Column(order = 754, length = 2)
    private String iwsSkskfkojinkbn4;

    public String getIwsSkskfkojinkbn4() {
        return iwsSkskfkojinkbn4;
    }

    public void setIwsSkskfkojinkbn4(String pIwsSkskfkojinkbn4) {
        iwsSkskfkojinkbn4 = pIwsSkskfkojinkbn4;
    }

    @Column(order = 755, length = 1)
    private String iwsSkmfrenflg4;

    public String getIwsSkmfrenflg4() {
        return iwsSkmfrenflg4;
    }

    public void setIwsSkmfrenflg4(String pIwsSkmfrenflg4) {
        iwsSkmfrenflg4 = pIwsSkmfrenflg4;
    }

    @Column(order = 756, length = 8)
    private String iwsSkmosymd4;

    public String getIwsSkmosymd4() {
        return iwsSkmosymd4;
    }

    public void setIwsSkmosymd4(String pIwsSkmosymd4) {
        iwsSkmosymd4 = pIwsSkmosymd4;
    }

    @Column(order = 757, length = 8)
    private String iwsSkkykymd4;

    public String getIwsSkkykymd4() {
        return iwsSkkykymd4;
    }

    public void setIwsSkkykymd4(String pIwsSkkykymd4) {
        iwsSkkykymd4 = pIwsSkkykymd4;
    }

    @Column(order = 758, length = 1)
    private String iwsSkseiritukbn4;

    public String getIwsSkseiritukbn4() {
        return iwsSkseiritukbn4;
    }

    public void setIwsSkseiritukbn4(String pIwsSkseiritukbn4) {
        iwsSkseiritukbn4 = pIwsSkseiritukbn4;
    }

    @Column(order = 759, length = 8)
    private String iwsSksrsyoriymd4;

    public String getIwsSksrsyoriymd4() {
        return iwsSksrsyoriymd4;
    }

    public void setIwsSksrsyoriymd4(String pIwsSksrsyoriymd4) {
        iwsSksrsyoriymd4 = pIwsSksrsyoriymd4;
    }

    @Column(order = 760, length = 2)
    private String iwsSksyouhncd4;

    public String getIwsSksyouhncd4() {
        return iwsSksyouhncd4;
    }

    public void setIwsSksyouhncd4(String pIwsSksyouhncd4) {
        iwsSksyouhncd4 = pIwsSksyouhncd4;
    }

    @Column(order = 761, length = 6)
    private String iwsSkbosyuuym4;

    public String getIwsSkbosyuuym4() {
        return iwsSkbosyuuym4;
    }

    public void setIwsSkbosyuuym4(String pIwsSkbosyuuym4) {
        iwsSkbosyuuym4 = pIwsSkbosyuuym4;
    }

    @Column(order = 762, length = 1)
    private String iwsSktaisyounayosejtkbn4;

    public String getIwsSktaisyounayosejtkbn4() {
        return iwsSktaisyounayosejtkbn4;
    }

    public void setIwsSktaisyounayosejtkbn4(String pIwsSktaisyounayosejtkbn4) {
        iwsSktaisyounayosejtkbn4 = pIwsSktaisyounayosejtkbn4;
    }

    @Column(order = 763, length = 10)
    private String iwsSktaisyousakuinnmno4;

    public String getIwsSktaisyousakuinnmno4() {
        return iwsSktaisyousakuinnmno4;
    }

    public void setIwsSktaisyousakuinnmno4(String pIwsSktaisyousakuinnmno4) {
        iwsSktaisyousakuinnmno4 = pIwsSktaisyousakuinnmno4;
    }

    @Column(order = 764, length = 8)
    private String iwsSktaisyouseiymd4;

    public String getIwsSktaisyouseiymd4() {
        return iwsSktaisyouseiymd4;
    }

    public void setIwsSktaisyouseiymd4(String pIwsSktaisyouseiymd4) {
        iwsSktaisyouseiymd4 = pIwsSktaisyouseiymd4;
    }

    @Column(order = 765, length = 2)
    private String iwsSksyouhnsdno4;

    public String getIwsSksyouhnsdno4() {
        return iwsSksyouhnsdno4;
    }

    public void setIwsSksyouhnsdno4(String pIwsSksyouhnsdno4) {
        iwsSksyouhnsdno4 = pIwsSksyouhnsdno4;
    }

    @Column(order = 766, length = 9)
    private String iwsSkmosno5;

    public String getIwsSkmosno5() {
        return iwsSkmosno5;
    }

    public void setIwsSkmosno5(String pIwsSkmosno5) {
        iwsSkmosno5 = pIwsSkmosno5;
    }

    @Column(order = 767, length = 2)
    private String iwsSkskfsegkbn5;

    public String getIwsSkskfsegkbn5() {
        return iwsSkskfsegkbn5;
    }

    public void setIwsSkskfsegkbn5(String pIwsSkskfsegkbn5) {
        iwsSkskfsegkbn5 = pIwsSkskfsegkbn5;
    }

    @Column(order = 768, length = 2)
    private String iwsSkskfkojinkbn5;

    public String getIwsSkskfkojinkbn5() {
        return iwsSkskfkojinkbn5;
    }

    public void setIwsSkskfkojinkbn5(String pIwsSkskfkojinkbn5) {
        iwsSkskfkojinkbn5 = pIwsSkskfkojinkbn5;
    }

    @Column(order = 769, length = 1)
    private String iwsSkmfrenflg5;

    public String getIwsSkmfrenflg5() {
        return iwsSkmfrenflg5;
    }

    public void setIwsSkmfrenflg5(String pIwsSkmfrenflg5) {
        iwsSkmfrenflg5 = pIwsSkmfrenflg5;
    }

    @Column(order = 770, length = 8)
    private String iwsSkmosymd5;

    public String getIwsSkmosymd5() {
        return iwsSkmosymd5;
    }

    public void setIwsSkmosymd5(String pIwsSkmosymd5) {
        iwsSkmosymd5 = pIwsSkmosymd5;
    }

    @Column(order = 771, length = 8)
    private String iwsSkkykymd5;

    public String getIwsSkkykymd5() {
        return iwsSkkykymd5;
    }

    public void setIwsSkkykymd5(String pIwsSkkykymd5) {
        iwsSkkykymd5 = pIwsSkkykymd5;
    }

    @Column(order = 772, length = 1)
    private String iwsSkseiritukbn5;

    public String getIwsSkseiritukbn5() {
        return iwsSkseiritukbn5;
    }

    public void setIwsSkseiritukbn5(String pIwsSkseiritukbn5) {
        iwsSkseiritukbn5 = pIwsSkseiritukbn5;
    }

    @Column(order = 773, length = 8)
    private String iwsSksrsyoriymd5;

    public String getIwsSksrsyoriymd5() {
        return iwsSksrsyoriymd5;
    }

    public void setIwsSksrsyoriymd5(String pIwsSksrsyoriymd5) {
        iwsSksrsyoriymd5 = pIwsSksrsyoriymd5;
    }

    @Column(order = 774, length = 2)
    private String iwsSksyouhncd5;

    public String getIwsSksyouhncd5() {
        return iwsSksyouhncd5;
    }

    public void setIwsSksyouhncd5(String pIwsSksyouhncd5) {
        iwsSksyouhncd5 = pIwsSksyouhncd5;
    }

    @Column(order = 775, length = 6)
    private String iwsSkbosyuuym5;

    public String getIwsSkbosyuuym5() {
        return iwsSkbosyuuym5;
    }

    public void setIwsSkbosyuuym5(String pIwsSkbosyuuym5) {
        iwsSkbosyuuym5 = pIwsSkbosyuuym5;
    }

    @Column(order = 776, length = 1)
    private String iwsSktaisyounayosejtkbn5;

    public String getIwsSktaisyounayosejtkbn5() {
        return iwsSktaisyounayosejtkbn5;
    }

    public void setIwsSktaisyounayosejtkbn5(String pIwsSktaisyounayosejtkbn5) {
        iwsSktaisyounayosejtkbn5 = pIwsSktaisyounayosejtkbn5;
    }

    @Column(order = 777, length = 10)
    private String iwsSktaisyousakuinnmno5;

    public String getIwsSktaisyousakuinnmno5() {
        return iwsSktaisyousakuinnmno5;
    }

    public void setIwsSktaisyousakuinnmno5(String pIwsSktaisyousakuinnmno5) {
        iwsSktaisyousakuinnmno5 = pIwsSktaisyousakuinnmno5;
    }

    @Column(order = 778, length = 8)
    private String iwsSktaisyouseiymd5;

    public String getIwsSktaisyouseiymd5() {
        return iwsSktaisyouseiymd5;
    }

    public void setIwsSktaisyouseiymd5(String pIwsSktaisyouseiymd5) {
        iwsSktaisyouseiymd5 = pIwsSktaisyouseiymd5;
    }

    @Column(order = 779, length = 2)
    private String iwsSksyouhnsdno5;

    public String getIwsSksyouhnsdno5() {
        return iwsSksyouhnsdno5;
    }

    public void setIwsSksyouhnsdno5(String pIwsSksyouhnsdno5) {
        iwsSksyouhnsdno5 = pIwsSksyouhnsdno5;
    }

    @Column(order = 780, length = 9)
    private String iwsSkmosno6;

    public String getIwsSkmosno6() {
        return iwsSkmosno6;
    }

    public void setIwsSkmosno6(String pIwsSkmosno6) {
        iwsSkmosno6 = pIwsSkmosno6;
    }

    @Column(order = 781, length = 2)
    private String iwsSkskfsegkbn6;

    public String getIwsSkskfsegkbn6() {
        return iwsSkskfsegkbn6;
    }

    public void setIwsSkskfsegkbn6(String pIwsSkskfsegkbn6) {
        iwsSkskfsegkbn6 = pIwsSkskfsegkbn6;
    }

    @Column(order = 782, length = 2)
    private String iwsSkskfkojinkbn6;

    public String getIwsSkskfkojinkbn6() {
        return iwsSkskfkojinkbn6;
    }

    public void setIwsSkskfkojinkbn6(String pIwsSkskfkojinkbn6) {
        iwsSkskfkojinkbn6 = pIwsSkskfkojinkbn6;
    }

    @Column(order = 783, length = 1)
    private String iwsSkmfrenflg6;

    public String getIwsSkmfrenflg6() {
        return iwsSkmfrenflg6;
    }

    public void setIwsSkmfrenflg6(String pIwsSkmfrenflg6) {
        iwsSkmfrenflg6 = pIwsSkmfrenflg6;
    }

    @Column(order = 784, length = 8)
    private String iwsSkmosymd6;

    public String getIwsSkmosymd6() {
        return iwsSkmosymd6;
    }

    public void setIwsSkmosymd6(String pIwsSkmosymd6) {
        iwsSkmosymd6 = pIwsSkmosymd6;
    }

    @Column(order = 785, length = 8)
    private String iwsSkkykymd6;

    public String getIwsSkkykymd6() {
        return iwsSkkykymd6;
    }

    public void setIwsSkkykymd6(String pIwsSkkykymd6) {
        iwsSkkykymd6 = pIwsSkkykymd6;
    }

    @Column(order = 786, length = 1)
    private String iwsSkseiritukbn6;

    public String getIwsSkseiritukbn6() {
        return iwsSkseiritukbn6;
    }

    public void setIwsSkseiritukbn6(String pIwsSkseiritukbn6) {
        iwsSkseiritukbn6 = pIwsSkseiritukbn6;
    }

    @Column(order = 787, length = 8)
    private String iwsSksrsyoriymd6;

    public String getIwsSksrsyoriymd6() {
        return iwsSksrsyoriymd6;
    }

    public void setIwsSksrsyoriymd6(String pIwsSksrsyoriymd6) {
        iwsSksrsyoriymd6 = pIwsSksrsyoriymd6;
    }

    @Column(order = 788, length = 2)
    private String iwsSksyouhncd6;

    public String getIwsSksyouhncd6() {
        return iwsSksyouhncd6;
    }

    public void setIwsSksyouhncd6(String pIwsSksyouhncd6) {
        iwsSksyouhncd6 = pIwsSksyouhncd6;
    }

    @Column(order = 789, length = 6)
    private String iwsSkbosyuuym6;

    public String getIwsSkbosyuuym6() {
        return iwsSkbosyuuym6;
    }

    public void setIwsSkbosyuuym6(String pIwsSkbosyuuym6) {
        iwsSkbosyuuym6 = pIwsSkbosyuuym6;
    }

    @Column(order = 790, length = 1)
    private String iwsSktaisyounayosejtkbn6;

    public String getIwsSktaisyounayosejtkbn6() {
        return iwsSktaisyounayosejtkbn6;
    }

    public void setIwsSktaisyounayosejtkbn6(String pIwsSktaisyounayosejtkbn6) {
        iwsSktaisyounayosejtkbn6 = pIwsSktaisyounayosejtkbn6;
    }

    @Column(order = 791, length = 10)
    private String iwsSktaisyousakuinnmno6;

    public String getIwsSktaisyousakuinnmno6() {
        return iwsSktaisyousakuinnmno6;
    }

    public void setIwsSktaisyousakuinnmno6(String pIwsSktaisyousakuinnmno6) {
        iwsSktaisyousakuinnmno6 = pIwsSktaisyousakuinnmno6;
    }

    @Column(order = 792, length = 8)
    private String iwsSktaisyouseiymd6;

    public String getIwsSktaisyouseiymd6() {
        return iwsSktaisyouseiymd6;
    }

    public void setIwsSktaisyouseiymd6(String pIwsSktaisyouseiymd6) {
        iwsSktaisyouseiymd6 = pIwsSktaisyouseiymd6;
    }

    @Column(order = 793, length = 2)
    private String iwsSksyouhnsdno6;

    public String getIwsSksyouhnsdno6() {
        return iwsSksyouhnsdno6;
    }

    public void setIwsSksyouhnsdno6(String pIwsSksyouhnsdno6) {
        iwsSksyouhnsdno6 = pIwsSksyouhnsdno6;
    }

    @Column(order = 794, length = 9)
    private String iwsSkmosno7;

    public String getIwsSkmosno7() {
        return iwsSkmosno7;
    }

    public void setIwsSkmosno7(String pIwsSkmosno7) {
        iwsSkmosno7 = pIwsSkmosno7;
    }

    @Column(order = 795, length = 2)
    private String iwsSkskfsegkbn7;

    public String getIwsSkskfsegkbn7() {
        return iwsSkskfsegkbn7;
    }

    public void setIwsSkskfsegkbn7(String pIwsSkskfsegkbn7) {
        iwsSkskfsegkbn7 = pIwsSkskfsegkbn7;
    }

    @Column(order = 796, length = 2)
    private String iwsSkskfkojinkbn7;

    public String getIwsSkskfkojinkbn7() {
        return iwsSkskfkojinkbn7;
    }

    public void setIwsSkskfkojinkbn7(String pIwsSkskfkojinkbn7) {
        iwsSkskfkojinkbn7 = pIwsSkskfkojinkbn7;
    }

    @Column(order = 797, length = 1)
    private String iwsSkmfrenflg7;

    public String getIwsSkmfrenflg7() {
        return iwsSkmfrenflg7;
    }

    public void setIwsSkmfrenflg7(String pIwsSkmfrenflg7) {
        iwsSkmfrenflg7 = pIwsSkmfrenflg7;
    }

    @Column(order = 798, length = 8)
    private String iwsSkmosymd7;

    public String getIwsSkmosymd7() {
        return iwsSkmosymd7;
    }

    public void setIwsSkmosymd7(String pIwsSkmosymd7) {
        iwsSkmosymd7 = pIwsSkmosymd7;
    }

    @Column(order = 799, length = 8)
    private String iwsSkkykymd7;

    public String getIwsSkkykymd7() {
        return iwsSkkykymd7;
    }

    public void setIwsSkkykymd7(String pIwsSkkykymd7) {
        iwsSkkykymd7 = pIwsSkkykymd7;
    }

    @Column(order = 800, length = 1)
    private String iwsSkseiritukbn7;

    public String getIwsSkseiritukbn7() {
        return iwsSkseiritukbn7;
    }

    public void setIwsSkseiritukbn7(String pIwsSkseiritukbn7) {
        iwsSkseiritukbn7 = pIwsSkseiritukbn7;
    }

    @Column(order = 801, length = 8)
    private String iwsSksrsyoriymd7;

    public String getIwsSksrsyoriymd7() {
        return iwsSksrsyoriymd7;
    }

    public void setIwsSksrsyoriymd7(String pIwsSksrsyoriymd7) {
        iwsSksrsyoriymd7 = pIwsSksrsyoriymd7;
    }

    @Column(order = 802, length = 2)
    private String iwsSksyouhncd7;

    public String getIwsSksyouhncd7() {
        return iwsSksyouhncd7;
    }

    public void setIwsSksyouhncd7(String pIwsSksyouhncd7) {
        iwsSksyouhncd7 = pIwsSksyouhncd7;
    }

    @Column(order = 803, length = 6)
    private String iwsSkbosyuuym7;

    public String getIwsSkbosyuuym7() {
        return iwsSkbosyuuym7;
    }

    public void setIwsSkbosyuuym7(String pIwsSkbosyuuym7) {
        iwsSkbosyuuym7 = pIwsSkbosyuuym7;
    }

    @Column(order = 804, length = 1)
    private String iwsSktaisyounayosejtkbn7;

    public String getIwsSktaisyounayosejtkbn7() {
        return iwsSktaisyounayosejtkbn7;
    }

    public void setIwsSktaisyounayosejtkbn7(String pIwsSktaisyounayosejtkbn7) {
        iwsSktaisyounayosejtkbn7 = pIwsSktaisyounayosejtkbn7;
    }

    @Column(order = 805, length = 10)
    private String iwsSktaisyousakuinnmno7;

    public String getIwsSktaisyousakuinnmno7() {
        return iwsSktaisyousakuinnmno7;
    }

    public void setIwsSktaisyousakuinnmno7(String pIwsSktaisyousakuinnmno7) {
        iwsSktaisyousakuinnmno7 = pIwsSktaisyousakuinnmno7;
    }

    @Column(order = 806, length = 8)
    private String iwsSktaisyouseiymd7;

    public String getIwsSktaisyouseiymd7() {
        return iwsSktaisyouseiymd7;
    }

    public void setIwsSktaisyouseiymd7(String pIwsSktaisyouseiymd7) {
        iwsSktaisyouseiymd7 = pIwsSktaisyouseiymd7;
    }

    @Column(order = 807, length = 2)
    private String iwsSksyouhnsdno7;

    public String getIwsSksyouhnsdno7() {
        return iwsSksyouhnsdno7;
    }

    public void setIwsSksyouhnsdno7(String pIwsSksyouhnsdno7) {
        iwsSksyouhnsdno7 = pIwsSksyouhnsdno7;
    }

    @Column(order = 808, length = 9)
    private String iwsSkmosno8;

    public String getIwsSkmosno8() {
        return iwsSkmosno8;
    }

    public void setIwsSkmosno8(String pIwsSkmosno8) {
        iwsSkmosno8 = pIwsSkmosno8;
    }

    @Column(order = 809, length = 2)
    private String iwsSkskfsegkbn8;

    public String getIwsSkskfsegkbn8() {
        return iwsSkskfsegkbn8;
    }

    public void setIwsSkskfsegkbn8(String pIwsSkskfsegkbn8) {
        iwsSkskfsegkbn8 = pIwsSkskfsegkbn8;
    }

    @Column(order = 810, length = 2)
    private String iwsSkskfkojinkbn8;

    public String getIwsSkskfkojinkbn8() {
        return iwsSkskfkojinkbn8;
    }

    public void setIwsSkskfkojinkbn8(String pIwsSkskfkojinkbn8) {
        iwsSkskfkojinkbn8 = pIwsSkskfkojinkbn8;
    }

    @Column(order = 811, length = 1)
    private String iwsSkmfrenflg8;

    public String getIwsSkmfrenflg8() {
        return iwsSkmfrenflg8;
    }

    public void setIwsSkmfrenflg8(String pIwsSkmfrenflg8) {
        iwsSkmfrenflg8 = pIwsSkmfrenflg8;
    }

    @Column(order = 812, length = 8)
    private String iwsSkmosymd8;

    public String getIwsSkmosymd8() {
        return iwsSkmosymd8;
    }

    public void setIwsSkmosymd8(String pIwsSkmosymd8) {
        iwsSkmosymd8 = pIwsSkmosymd8;
    }

    @Column(order = 813, length = 8)
    private String iwsSkkykymd8;

    public String getIwsSkkykymd8() {
        return iwsSkkykymd8;
    }

    public void setIwsSkkykymd8(String pIwsSkkykymd8) {
        iwsSkkykymd8 = pIwsSkkykymd8;
    }

    @Column(order = 814, length = 1)
    private String iwsSkseiritukbn8;

    public String getIwsSkseiritukbn8() {
        return iwsSkseiritukbn8;
    }

    public void setIwsSkseiritukbn8(String pIwsSkseiritukbn8) {
        iwsSkseiritukbn8 = pIwsSkseiritukbn8;
    }

    @Column(order = 815, length = 8)
    private String iwsSksrsyoriymd8;

    public String getIwsSksrsyoriymd8() {
        return iwsSksrsyoriymd8;
    }

    public void setIwsSksrsyoriymd8(String pIwsSksrsyoriymd8) {
        iwsSksrsyoriymd8 = pIwsSksrsyoriymd8;
    }

    @Column(order = 816, length = 2)
    private String iwsSksyouhncd8;

    public String getIwsSksyouhncd8() {
        return iwsSksyouhncd8;
    }

    public void setIwsSksyouhncd8(String pIwsSksyouhncd8) {
        iwsSksyouhncd8 = pIwsSksyouhncd8;
    }

    @Column(order = 817, length = 6)
    private String iwsSkbosyuuym8;

    public String getIwsSkbosyuuym8() {
        return iwsSkbosyuuym8;
    }

    public void setIwsSkbosyuuym8(String pIwsSkbosyuuym8) {
        iwsSkbosyuuym8 = pIwsSkbosyuuym8;
    }

    @Column(order = 818, length = 1)
    private String iwsSktaisyounayosejtkbn8;

    public String getIwsSktaisyounayosejtkbn8() {
        return iwsSktaisyounayosejtkbn8;
    }

    public void setIwsSktaisyounayosejtkbn8(String pIwsSktaisyounayosejtkbn8) {
        iwsSktaisyounayosejtkbn8 = pIwsSktaisyounayosejtkbn8;
    }

    @Column(order = 819, length = 10)
    private String iwsSktaisyousakuinnmno8;

    public String getIwsSktaisyousakuinnmno8() {
        return iwsSktaisyousakuinnmno8;
    }

    public void setIwsSktaisyousakuinnmno8(String pIwsSktaisyousakuinnmno8) {
        iwsSktaisyousakuinnmno8 = pIwsSktaisyousakuinnmno8;
    }

    @Column(order = 820, length = 8)
    private String iwsSktaisyouseiymd8;

    public String getIwsSktaisyouseiymd8() {
        return iwsSktaisyouseiymd8;
    }

    public void setIwsSktaisyouseiymd8(String pIwsSktaisyouseiymd8) {
        iwsSktaisyouseiymd8 = pIwsSktaisyouseiymd8;
    }

    @Column(order = 821, length = 2)
    private String iwsSksyouhnsdno8;

    public String getIwsSksyouhnsdno8() {
        return iwsSksyouhnsdno8;
    }

    public void setIwsSksyouhnsdno8(String pIwsSksyouhnsdno8) {
        iwsSksyouhnsdno8 = pIwsSksyouhnsdno8;
    }

    @Column(order = 822, length = 9)
    private String iwsSkmosno9;

    public String getIwsSkmosno9() {
        return iwsSkmosno9;
    }

    public void setIwsSkmosno9(String pIwsSkmosno9) {
        iwsSkmosno9 = pIwsSkmosno9;
    }

    @Column(order = 823, length = 2)
    private String iwsSkskfsegkbn9;

    public String getIwsSkskfsegkbn9() {
        return iwsSkskfsegkbn9;
    }

    public void setIwsSkskfsegkbn9(String pIwsSkskfsegkbn9) {
        iwsSkskfsegkbn9 = pIwsSkskfsegkbn9;
    }

    @Column(order = 824, length = 2)
    private String iwsSkskfkojinkbn9;

    public String getIwsSkskfkojinkbn9() {
        return iwsSkskfkojinkbn9;
    }

    public void setIwsSkskfkojinkbn9(String pIwsSkskfkojinkbn9) {
        iwsSkskfkojinkbn9 = pIwsSkskfkojinkbn9;
    }

    @Column(order = 825, length = 1)
    private String iwsSkmfrenflg9;

    public String getIwsSkmfrenflg9() {
        return iwsSkmfrenflg9;
    }

    public void setIwsSkmfrenflg9(String pIwsSkmfrenflg9) {
        iwsSkmfrenflg9 = pIwsSkmfrenflg9;
    }

    @Column(order = 826, length = 8)
    private String iwsSkmosymd9;

    public String getIwsSkmosymd9() {
        return iwsSkmosymd9;
    }

    public void setIwsSkmosymd9(String pIwsSkmosymd9) {
        iwsSkmosymd9 = pIwsSkmosymd9;
    }

    @Column(order = 827, length = 8)
    private String iwsSkkykymd9;

    public String getIwsSkkykymd9() {
        return iwsSkkykymd9;
    }

    public void setIwsSkkykymd9(String pIwsSkkykymd9) {
        iwsSkkykymd9 = pIwsSkkykymd9;
    }

    @Column(order = 828, length = 1)
    private String iwsSkseiritukbn9;

    public String getIwsSkseiritukbn9() {
        return iwsSkseiritukbn9;
    }

    public void setIwsSkseiritukbn9(String pIwsSkseiritukbn9) {
        iwsSkseiritukbn9 = pIwsSkseiritukbn9;
    }

    @Column(order = 829, length = 8)
    private String iwsSksrsyoriymd9;

    public String getIwsSksrsyoriymd9() {
        return iwsSksrsyoriymd9;
    }

    public void setIwsSksrsyoriymd9(String pIwsSksrsyoriymd9) {
        iwsSksrsyoriymd9 = pIwsSksrsyoriymd9;
    }

    @Column(order = 830, length = 2)
    private String iwsSksyouhncd9;

    public String getIwsSksyouhncd9() {
        return iwsSksyouhncd9;
    }

    public void setIwsSksyouhncd9(String pIwsSksyouhncd9) {
        iwsSksyouhncd9 = pIwsSksyouhncd9;
    }

    @Column(order = 831, length = 6)
    private String iwsSkbosyuuym9;

    public String getIwsSkbosyuuym9() {
        return iwsSkbosyuuym9;
    }

    public void setIwsSkbosyuuym9(String pIwsSkbosyuuym9) {
        iwsSkbosyuuym9 = pIwsSkbosyuuym9;
    }

    @Column(order = 832, length = 1)
    private String iwsSktaisyounayosejtkbn9;

    public String getIwsSktaisyounayosejtkbn9() {
        return iwsSktaisyounayosejtkbn9;
    }

    public void setIwsSktaisyounayosejtkbn9(String pIwsSktaisyounayosejtkbn9) {
        iwsSktaisyounayosejtkbn9 = pIwsSktaisyounayosejtkbn9;
    }

    @Column(order = 833, length = 10)
    private String iwsSktaisyousakuinnmno9;

    public String getIwsSktaisyousakuinnmno9() {
        return iwsSktaisyousakuinnmno9;
    }

    public void setIwsSktaisyousakuinnmno9(String pIwsSktaisyousakuinnmno9) {
        iwsSktaisyousakuinnmno9 = pIwsSktaisyousakuinnmno9;
    }

    @Column(order = 834, length = 8)
    private String iwsSktaisyouseiymd9;

    public String getIwsSktaisyouseiymd9() {
        return iwsSktaisyouseiymd9;
    }

    public void setIwsSktaisyouseiymd9(String pIwsSktaisyouseiymd9) {
        iwsSktaisyouseiymd9 = pIwsSktaisyouseiymd9;
    }

    @Column(order = 835, length = 2)
    private String iwsSksyouhnsdno9;

    public String getIwsSksyouhnsdno9() {
        return iwsSksyouhnsdno9;
    }

    public void setIwsSksyouhnsdno9(String pIwsSksyouhnsdno9) {
        iwsSksyouhnsdno9 = pIwsSksyouhnsdno9;
    }

    @Column(order = 836, length = 9)
    private String iwsSkmosno10;

    public String getIwsSkmosno10() {
        return iwsSkmosno10;
    }

    public void setIwsSkmosno10(String pIwsSkmosno10) {
        iwsSkmosno10 = pIwsSkmosno10;
    }

    @Column(order = 837, length = 2)
    private String iwsSkskfsegkbn10;

    public String getIwsSkskfsegkbn10() {
        return iwsSkskfsegkbn10;
    }

    public void setIwsSkskfsegkbn10(String pIwsSkskfsegkbn10) {
        iwsSkskfsegkbn10 = pIwsSkskfsegkbn10;
    }

    @Column(order = 838, length = 2)
    private String iwsSkskfkojinkbn10;

    public String getIwsSkskfkojinkbn10() {
        return iwsSkskfkojinkbn10;
    }

    public void setIwsSkskfkojinkbn10(String pIwsSkskfkojinkbn10) {
        iwsSkskfkojinkbn10 = pIwsSkskfkojinkbn10;
    }

    @Column(order = 839, length = 1)
    private String iwsSkmfrenflg10;

    public String getIwsSkmfrenflg10() {
        return iwsSkmfrenflg10;
    }

    public void setIwsSkmfrenflg10(String pIwsSkmfrenflg10) {
        iwsSkmfrenflg10 = pIwsSkmfrenflg10;
    }

    @Column(order = 840, length = 8)
    private String iwsSkmosymd10;

    public String getIwsSkmosymd10() {
        return iwsSkmosymd10;
    }

    public void setIwsSkmosymd10(String pIwsSkmosymd10) {
        iwsSkmosymd10 = pIwsSkmosymd10;
    }

    @Column(order = 841, length = 8)
    private String iwsSkkykymd10;

    public String getIwsSkkykymd10() {
        return iwsSkkykymd10;
    }

    public void setIwsSkkykymd10(String pIwsSkkykymd10) {
        iwsSkkykymd10 = pIwsSkkykymd10;
    }

    @Column(order = 842, length = 1)
    private String iwsSkseiritukbn10;

    public String getIwsSkseiritukbn10() {
        return iwsSkseiritukbn10;
    }

    public void setIwsSkseiritukbn10(String pIwsSkseiritukbn10) {
        iwsSkseiritukbn10 = pIwsSkseiritukbn10;
    }

    @Column(order = 843, length = 8)
    private String iwsSksrsyoriymd10;

    public String getIwsSksrsyoriymd10() {
        return iwsSksrsyoriymd10;
    }

    public void setIwsSksrsyoriymd10(String pIwsSksrsyoriymd10) {
        iwsSksrsyoriymd10 = pIwsSksrsyoriymd10;
    }

    @Column(order = 844, length = 2)
    private String iwsSksyouhncd10;

    public String getIwsSksyouhncd10() {
        return iwsSksyouhncd10;
    }

    public void setIwsSksyouhncd10(String pIwsSksyouhncd10) {
        iwsSksyouhncd10 = pIwsSksyouhncd10;
    }

    @Column(order = 845, length = 6)
    private String iwsSkbosyuuym10;

    public String getIwsSkbosyuuym10() {
        return iwsSkbosyuuym10;
    }

    public void setIwsSkbosyuuym10(String pIwsSkbosyuuym10) {
        iwsSkbosyuuym10 = pIwsSkbosyuuym10;
    }

    @Column(order = 846, length = 1)
    private String iwsSktaisyounayosejtkbn10;

    public String getIwsSktaisyounayosejtkbn10() {
        return iwsSktaisyounayosejtkbn10;
    }

    public void setIwsSktaisyounayosejtkbn10(String pIwsSktaisyounayosejtkbn10) {
        iwsSktaisyounayosejtkbn10 = pIwsSktaisyounayosejtkbn10;
    }

    @Column(order = 847, length = 10)
    private String iwsSktaisyousakuinnmno10;

    public String getIwsSktaisyousakuinnmno10() {
        return iwsSktaisyousakuinnmno10;
    }

    public void setIwsSktaisyousakuinnmno10(String pIwsSktaisyousakuinnmno10) {
        iwsSktaisyousakuinnmno10 = pIwsSktaisyousakuinnmno10;
    }

    @Column(order = 848, length = 8)
    private String iwsSktaisyouseiymd10;

    public String getIwsSktaisyouseiymd10() {
        return iwsSktaisyouseiymd10;
    }

    public void setIwsSktaisyouseiymd10(String pIwsSktaisyouseiymd10) {
        iwsSktaisyouseiymd10 = pIwsSktaisyouseiymd10;
    }

    @Column(order = 849, length = 2)
    private String iwsSksyouhnsdno10;

    public String getIwsSksyouhnsdno10() {
        return iwsSksyouhnsdno10;
    }

    public void setIwsSksyouhnsdno10(String pIwsSksyouhnsdno10) {
        iwsSksyouhnsdno10 = pIwsSksyouhnsdno10;
    }

    @Column(order = 850, length = 11)
    private String iwsNknksysyno1;

    public String getIwsNknksysyno1() {
        return iwsNknksysyno1;
    }

    public void setIwsNknksysyno1(String pIwsNknksysyno1) {
        iwsNknksysyno1 = pIwsNknksysyno1;
    }

    @Column(order = 851, length = 2)
    private String iwsNknkshrfsegkbn1;

    public String getIwsNknkshrfsegkbn1() {
        return iwsNknkshrfsegkbn1;
    }

    public void setIwsNknkshrfsegkbn1(String pIwsNknkshrfsegkbn1) {
        iwsNknkshrfsegkbn1 = pIwsNknkshrfsegkbn1;
    }

    @Column(order = 852, length = 2)
    private String iwsNknkshrfkojinkbn1;

    public String getIwsNknkshrfkojinkbn1() {
        return iwsNknkshrfkojinkbn1;
    }

    public void setIwsNknkshrfkojinkbn1(String pIwsNknkshrfkojinkbn1) {
        iwsNknkshrfkojinkbn1 = pIwsNknkshrfkojinkbn1;
    }

    @Column(order = 853, length = 8)
    private String iwsNkkykymd1;

    public String getIwsNkkykymd1() {
        return iwsNkkykymd1;
    }

    public void setIwsNkkykymd1(String pIwsNkkykymd1) {
        iwsNkkykymd1 = pIwsNkkykymd1;
    }

    @Column(order = 854, length = 8)
    private String iwsNknkshrstartymd1;

    public String getIwsNknkshrstartymd1() {
        return iwsNknkshrstartymd1;
    }

    public void setIwsNknkshrstartymd1(String pIwsNknkshrstartymd1) {
        iwsNknkshrstartymd1 = pIwsNknkshrstartymd1;
    }

    @Column(order = 855, length = 2)
    private String iwsNknksyoumetucd1;

    public String getIwsNknksyoumetucd1() {
        return iwsNknksyoumetucd1;
    }

    public void setIwsNknksyoumetucd1(String pIwsNknksyoumetucd1) {
        iwsNknksyoumetucd1 = pIwsNknksyoumetucd1;
    }

    @Column(order = 856, length = 8)
    private String iwsNksyoumetuymd1;

    public String getIwsNksyoumetuymd1() {
        return iwsNksyoumetuymd1;
    }

    public void setIwsNksyoumetuymd1(String pIwsNksyoumetuymd1) {
        iwsNksyoumetuymd1 = pIwsNksyoumetuymd1;
    }

    @Column(order = 857, length = 2)
    private String iwsNksyouhncd1;

    public String getIwsNksyouhncd1() {
        return iwsNksyouhncd1;
    }

    public void setIwsNksyouhncd1(String pIwsNksyouhncd1) {
        iwsNksyouhncd1 = pIwsNksyouhncd1;
    }

    @Column(order = 858, length = 2)
    private String iwsNknenkinsyu1;

    public String getIwsNknenkinsyu1() {
        return iwsNknenkinsyu1;
    }

    public void setIwsNknenkinsyu1(String pIwsNknenkinsyu1) {
        iwsNknenkinsyu1 = pIwsNknenkinsyu1;
    }

    @Column(order = 859, length = 8)
    private String iwsNktaisyouseiymd1;

    public String getIwsNktaisyouseiymd1() {
        return iwsNktaisyouseiymd1;
    }

    public void setIwsNktaisyouseiymd1(String pIwsNktaisyouseiymd1) {
        iwsNktaisyouseiymd1 = pIwsNktaisyouseiymd1;
    }

    @Column(order = 860, length = 2)
    private String iwsNksyouhnsdno1;

    public String getIwsNksyouhnsdno1() {
        return iwsNksyouhnsdno1;
    }

    public void setIwsNksyouhnsdno1(String pIwsNksyouhnsdno1) {
        iwsNksyouhnsdno1 = pIwsNksyouhnsdno1;
    }

    @Column(order = 861, length = 11)
    private String iwsNknksysyno2;

    public String getIwsNknksysyno2() {
        return iwsNknksysyno2;
    }

    public void setIwsNknksysyno2(String pIwsNknksysyno2) {
        iwsNknksysyno2 = pIwsNknksysyno2;
    }

    @Column(order = 862, length = 2)
    private String iwsNknkshrfsegkbn2;

    public String getIwsNknkshrfsegkbn2() {
        return iwsNknkshrfsegkbn2;
    }

    public void setIwsNknkshrfsegkbn2(String pIwsNknkshrfsegkbn2) {
        iwsNknkshrfsegkbn2 = pIwsNknkshrfsegkbn2;
    }

    @Column(order = 863, length = 2)
    private String iwsNknkshrfkojinkbn2;

    public String getIwsNknkshrfkojinkbn2() {
        return iwsNknkshrfkojinkbn2;
    }

    public void setIwsNknkshrfkojinkbn2(String pIwsNknkshrfkojinkbn2) {
        iwsNknkshrfkojinkbn2 = pIwsNknkshrfkojinkbn2;
    }

    @Column(order = 864, length = 8)
    private String iwsNkkykymd2;

    public String getIwsNkkykymd2() {
        return iwsNkkykymd2;
    }

    public void setIwsNkkykymd2(String pIwsNkkykymd2) {
        iwsNkkykymd2 = pIwsNkkykymd2;
    }

    @Column(order = 865, length = 8)
    private String iwsNknkshrstartymd2;

    public String getIwsNknkshrstartymd2() {
        return iwsNknkshrstartymd2;
    }

    public void setIwsNknkshrstartymd2(String pIwsNknkshrstartymd2) {
        iwsNknkshrstartymd2 = pIwsNknkshrstartymd2;
    }

    @Column(order = 866, length = 2)
    private String iwsNknksyoumetucd2;

    public String getIwsNknksyoumetucd2() {
        return iwsNknksyoumetucd2;
    }

    public void setIwsNknksyoumetucd2(String pIwsNknksyoumetucd2) {
        iwsNknksyoumetucd2 = pIwsNknksyoumetucd2;
    }

    @Column(order = 867, length = 8)
    private String iwsNksyoumetuymd2;

    public String getIwsNksyoumetuymd2() {
        return iwsNksyoumetuymd2;
    }

    public void setIwsNksyoumetuymd2(String pIwsNksyoumetuymd2) {
        iwsNksyoumetuymd2 = pIwsNksyoumetuymd2;
    }

    @Column(order = 868, length = 2)
    private String iwsNksyouhncd2;

    public String getIwsNksyouhncd2() {
        return iwsNksyouhncd2;
    }

    public void setIwsNksyouhncd2(String pIwsNksyouhncd2) {
        iwsNksyouhncd2 = pIwsNksyouhncd2;
    }

    @Column(order = 869, length = 2)
    private String iwsNknenkinsyu2;

    public String getIwsNknenkinsyu2() {
        return iwsNknenkinsyu2;
    }

    public void setIwsNknenkinsyu2(String pIwsNknenkinsyu2) {
        iwsNknenkinsyu2 = pIwsNknenkinsyu2;
    }

    @Column(order = 870, length = 8)
    private String iwsNktaisyouseiymd2;

    public String getIwsNktaisyouseiymd2() {
        return iwsNktaisyouseiymd2;
    }

    public void setIwsNktaisyouseiymd2(String pIwsNktaisyouseiymd2) {
        iwsNktaisyouseiymd2 = pIwsNktaisyouseiymd2;
    }

    @Column(order = 871, length = 2)
    private String iwsNksyouhnsdno2;

    public String getIwsNksyouhnsdno2() {
        return iwsNksyouhnsdno2;
    }

    public void setIwsNksyouhnsdno2(String pIwsNksyouhnsdno2) {
        iwsNksyouhnsdno2 = pIwsNksyouhnsdno2;
    }

    @Column(order = 872, length = 11)
    private String iwsNknksysyno3;

    public String getIwsNknksysyno3() {
        return iwsNknksysyno3;
    }

    public void setIwsNknksysyno3(String pIwsNknksysyno3) {
        iwsNknksysyno3 = pIwsNknksysyno3;
    }

    @Column(order = 873, length = 2)
    private String iwsNknkshrfsegkbn3;

    public String getIwsNknkshrfsegkbn3() {
        return iwsNknkshrfsegkbn3;
    }

    public void setIwsNknkshrfsegkbn3(String pIwsNknkshrfsegkbn3) {
        iwsNknkshrfsegkbn3 = pIwsNknkshrfsegkbn3;
    }

    @Column(order = 874, length = 2)
    private String iwsNknkshrfkojinkbn3;

    public String getIwsNknkshrfkojinkbn3() {
        return iwsNknkshrfkojinkbn3;
    }

    public void setIwsNknkshrfkojinkbn3(String pIwsNknkshrfkojinkbn3) {
        iwsNknkshrfkojinkbn3 = pIwsNknkshrfkojinkbn3;
    }

    @Column(order = 875, length = 8)
    private String iwsNkkykymd3;

    public String getIwsNkkykymd3() {
        return iwsNkkykymd3;
    }

    public void setIwsNkkykymd3(String pIwsNkkykymd3) {
        iwsNkkykymd3 = pIwsNkkykymd3;
    }

    @Column(order = 876, length = 8)
    private String iwsNknkshrstartymd3;

    public String getIwsNknkshrstartymd3() {
        return iwsNknkshrstartymd3;
    }

    public void setIwsNknkshrstartymd3(String pIwsNknkshrstartymd3) {
        iwsNknkshrstartymd3 = pIwsNknkshrstartymd3;
    }

    @Column(order = 877, length = 2)
    private String iwsNknksyoumetucd3;

    public String getIwsNknksyoumetucd3() {
        return iwsNknksyoumetucd3;
    }

    public void setIwsNknksyoumetucd3(String pIwsNknksyoumetucd3) {
        iwsNknksyoumetucd3 = pIwsNknksyoumetucd3;
    }

    @Column(order = 878, length = 8)
    private String iwsNksyoumetuymd3;

    public String getIwsNksyoumetuymd3() {
        return iwsNksyoumetuymd3;
    }

    public void setIwsNksyoumetuymd3(String pIwsNksyoumetuymd3) {
        iwsNksyoumetuymd3 = pIwsNksyoumetuymd3;
    }

    @Column(order = 879, length = 2)
    private String iwsNksyouhncd3;

    public String getIwsNksyouhncd3() {
        return iwsNksyouhncd3;
    }

    public void setIwsNksyouhncd3(String pIwsNksyouhncd3) {
        iwsNksyouhncd3 = pIwsNksyouhncd3;
    }

    @Column(order = 880, length = 2)
    private String iwsNknenkinsyu3;

    public String getIwsNknenkinsyu3() {
        return iwsNknenkinsyu3;
    }

    public void setIwsNknenkinsyu3(String pIwsNknenkinsyu3) {
        iwsNknenkinsyu3 = pIwsNknenkinsyu3;
    }

    @Column(order = 881, length = 8)
    private String iwsNktaisyouseiymd3;

    public String getIwsNktaisyouseiymd3() {
        return iwsNktaisyouseiymd3;
    }

    public void setIwsNktaisyouseiymd3(String pIwsNktaisyouseiymd3) {
        iwsNktaisyouseiymd3 = pIwsNktaisyouseiymd3;
    }

    @Column(order = 882, length = 2)
    private String iwsNksyouhnsdno3;

    public String getIwsNksyouhnsdno3() {
        return iwsNksyouhnsdno3;
    }

    public void setIwsNksyouhnsdno3(String pIwsNksyouhnsdno3) {
        iwsNksyouhnsdno3 = pIwsNksyouhnsdno3;
    }

    @Column(order = 883, length = 11)
    private String iwsNknksysyno4;

    public String getIwsNknksysyno4() {
        return iwsNknksysyno4;
    }

    public void setIwsNknksysyno4(String pIwsNknksysyno4) {
        iwsNknksysyno4 = pIwsNknksysyno4;
    }

    @Column(order = 884, length = 2)
    private String iwsNknkshrfsegkbn4;

    public String getIwsNknkshrfsegkbn4() {
        return iwsNknkshrfsegkbn4;
    }

    public void setIwsNknkshrfsegkbn4(String pIwsNknkshrfsegkbn4) {
        iwsNknkshrfsegkbn4 = pIwsNknkshrfsegkbn4;
    }

    @Column(order = 885, length = 2)
    private String iwsNknkshrfkojinkbn4;

    public String getIwsNknkshrfkojinkbn4() {
        return iwsNknkshrfkojinkbn4;
    }

    public void setIwsNknkshrfkojinkbn4(String pIwsNknkshrfkojinkbn4) {
        iwsNknkshrfkojinkbn4 = pIwsNknkshrfkojinkbn4;
    }

    @Column(order = 886, length = 8)
    private String iwsNkkykymd4;

    public String getIwsNkkykymd4() {
        return iwsNkkykymd4;
    }

    public void setIwsNkkykymd4(String pIwsNkkykymd4) {
        iwsNkkykymd4 = pIwsNkkykymd4;
    }

    @Column(order = 887, length = 8)
    private String iwsNknkshrstartymd4;

    public String getIwsNknkshrstartymd4() {
        return iwsNknkshrstartymd4;
    }

    public void setIwsNknkshrstartymd4(String pIwsNknkshrstartymd4) {
        iwsNknkshrstartymd4 = pIwsNknkshrstartymd4;
    }

    @Column(order = 888, length = 2)
    private String iwsNknksyoumetucd4;

    public String getIwsNknksyoumetucd4() {
        return iwsNknksyoumetucd4;
    }

    public void setIwsNknksyoumetucd4(String pIwsNknksyoumetucd4) {
        iwsNknksyoumetucd4 = pIwsNknksyoumetucd4;
    }

    @Column(order = 889, length = 8)
    private String iwsNksyoumetuymd4;

    public String getIwsNksyoumetuymd4() {
        return iwsNksyoumetuymd4;
    }

    public void setIwsNksyoumetuymd4(String pIwsNksyoumetuymd4) {
        iwsNksyoumetuymd4 = pIwsNksyoumetuymd4;
    }

    @Column(order = 890, length = 2)
    private String iwsNksyouhncd4;

    public String getIwsNksyouhncd4() {
        return iwsNksyouhncd4;
    }

    public void setIwsNksyouhncd4(String pIwsNksyouhncd4) {
        iwsNksyouhncd4 = pIwsNksyouhncd4;
    }

    @Column(order = 891, length = 2)
    private String iwsNknenkinsyu4;

    public String getIwsNknenkinsyu4() {
        return iwsNknenkinsyu4;
    }

    public void setIwsNknenkinsyu4(String pIwsNknenkinsyu4) {
        iwsNknenkinsyu4 = pIwsNknenkinsyu4;
    }

    @Column(order = 892, length = 8)
    private String iwsNktaisyouseiymd4;

    public String getIwsNktaisyouseiymd4() {
        return iwsNktaisyouseiymd4;
    }

    public void setIwsNktaisyouseiymd4(String pIwsNktaisyouseiymd4) {
        iwsNktaisyouseiymd4 = pIwsNktaisyouseiymd4;
    }

    @Column(order = 893, length = 2)
    private String iwsNksyouhnsdno4;

    public String getIwsNksyouhnsdno4() {
        return iwsNksyouhnsdno4;
    }

    public void setIwsNksyouhnsdno4(String pIwsNksyouhnsdno4) {
        iwsNksyouhnsdno4 = pIwsNksyouhnsdno4;
    }

    @Column(order = 894, length = 11)
    private String iwsNknksysyno5;

    public String getIwsNknksysyno5() {
        return iwsNknksysyno5;
    }

    public void setIwsNknksysyno5(String pIwsNknksysyno5) {
        iwsNknksysyno5 = pIwsNknksysyno5;
    }

    @Column(order = 895, length = 2)
    private String iwsNknkshrfsegkbn5;

    public String getIwsNknkshrfsegkbn5() {
        return iwsNknkshrfsegkbn5;
    }

    public void setIwsNknkshrfsegkbn5(String pIwsNknkshrfsegkbn5) {
        iwsNknkshrfsegkbn5 = pIwsNknkshrfsegkbn5;
    }

    @Column(order = 896, length = 2)
    private String iwsNknkshrfkojinkbn5;

    public String getIwsNknkshrfkojinkbn5() {
        return iwsNknkshrfkojinkbn5;
    }

    public void setIwsNknkshrfkojinkbn5(String pIwsNknkshrfkojinkbn5) {
        iwsNknkshrfkojinkbn5 = pIwsNknkshrfkojinkbn5;
    }

    @Column(order = 897, length = 8)
    private String iwsNkkykymd5;

    public String getIwsNkkykymd5() {
        return iwsNkkykymd5;
    }

    public void setIwsNkkykymd5(String pIwsNkkykymd5) {
        iwsNkkykymd5 = pIwsNkkykymd5;
    }

    @Column(order = 898, length = 8)
    private String iwsNknkshrstartymd5;

    public String getIwsNknkshrstartymd5() {
        return iwsNknkshrstartymd5;
    }

    public void setIwsNknkshrstartymd5(String pIwsNknkshrstartymd5) {
        iwsNknkshrstartymd5 = pIwsNknkshrstartymd5;
    }

    @Column(order = 899, length = 2)
    private String iwsNknksyoumetucd5;

    public String getIwsNknksyoumetucd5() {
        return iwsNknksyoumetucd5;
    }

    public void setIwsNknksyoumetucd5(String pIwsNknksyoumetucd5) {
        iwsNknksyoumetucd5 = pIwsNknksyoumetucd5;
    }

    @Column(order = 900, length = 8)
    private String iwsNksyoumetuymd5;

    public String getIwsNksyoumetuymd5() {
        return iwsNksyoumetuymd5;
    }

    public void setIwsNksyoumetuymd5(String pIwsNksyoumetuymd5) {
        iwsNksyoumetuymd5 = pIwsNksyoumetuymd5;
    }

    @Column(order = 901, length = 2)
    private String iwsNksyouhncd5;

    public String getIwsNksyouhncd5() {
        return iwsNksyouhncd5;
    }

    public void setIwsNksyouhncd5(String pIwsNksyouhncd5) {
        iwsNksyouhncd5 = pIwsNksyouhncd5;
    }

    @Column(order = 902, length = 2)
    private String iwsNknenkinsyu5;

    public String getIwsNknenkinsyu5() {
        return iwsNknenkinsyu5;
    }

    public void setIwsNknenkinsyu5(String pIwsNknenkinsyu5) {
        iwsNknenkinsyu5 = pIwsNknenkinsyu5;
    }

    @Column(order = 903, length = 8)
    private String iwsNktaisyouseiymd5;

    public String getIwsNktaisyouseiymd5() {
        return iwsNktaisyouseiymd5;
    }

    public void setIwsNktaisyouseiymd5(String pIwsNktaisyouseiymd5) {
        iwsNktaisyouseiymd5 = pIwsNktaisyouseiymd5;
    }

    @Column(order = 904, length = 2)
    private String iwsNksyouhnsdno5;

    public String getIwsNksyouhnsdno5() {
        return iwsNksyouhnsdno5;
    }

    public void setIwsNksyouhnsdno5(String pIwsNksyouhnsdno5) {
        iwsNksyouhnsdno5 = pIwsNksyouhnsdno5;
    }

    @Column(order = 905, length = 11)
    private String iwsNknksysyno6;

    public String getIwsNknksysyno6() {
        return iwsNknksysyno6;
    }

    public void setIwsNknksysyno6(String pIwsNknksysyno6) {
        iwsNknksysyno6 = pIwsNknksysyno6;
    }

    @Column(order = 906, length = 2)
    private String iwsNknkshrfsegkbn6;

    public String getIwsNknkshrfsegkbn6() {
        return iwsNknkshrfsegkbn6;
    }

    public void setIwsNknkshrfsegkbn6(String pIwsNknkshrfsegkbn6) {
        iwsNknkshrfsegkbn6 = pIwsNknkshrfsegkbn6;
    }

    @Column(order = 907, length = 2)
    private String iwsNknkshrfkojinkbn6;

    public String getIwsNknkshrfkojinkbn6() {
        return iwsNknkshrfkojinkbn6;
    }

    public void setIwsNknkshrfkojinkbn6(String pIwsNknkshrfkojinkbn6) {
        iwsNknkshrfkojinkbn6 = pIwsNknkshrfkojinkbn6;
    }

    @Column(order = 908, length = 8)
    private String iwsNkkykymd6;

    public String getIwsNkkykymd6() {
        return iwsNkkykymd6;
    }

    public void setIwsNkkykymd6(String pIwsNkkykymd6) {
        iwsNkkykymd6 = pIwsNkkykymd6;
    }

    @Column(order = 909, length = 8)
    private String iwsNknkshrstartymd6;

    public String getIwsNknkshrstartymd6() {
        return iwsNknkshrstartymd6;
    }

    public void setIwsNknkshrstartymd6(String pIwsNknkshrstartymd6) {
        iwsNknkshrstartymd6 = pIwsNknkshrstartymd6;
    }

    @Column(order = 910, length = 2)
    private String iwsNknksyoumetucd6;

    public String getIwsNknksyoumetucd6() {
        return iwsNknksyoumetucd6;
    }

    public void setIwsNknksyoumetucd6(String pIwsNknksyoumetucd6) {
        iwsNknksyoumetucd6 = pIwsNknksyoumetucd6;
    }

    @Column(order = 911, length = 8)
    private String iwsNksyoumetuymd6;

    public String getIwsNksyoumetuymd6() {
        return iwsNksyoumetuymd6;
    }

    public void setIwsNksyoumetuymd6(String pIwsNksyoumetuymd6) {
        iwsNksyoumetuymd6 = pIwsNksyoumetuymd6;
    }

    @Column(order = 912, length = 2)
    private String iwsNksyouhncd6;

    public String getIwsNksyouhncd6() {
        return iwsNksyouhncd6;
    }

    public void setIwsNksyouhncd6(String pIwsNksyouhncd6) {
        iwsNksyouhncd6 = pIwsNksyouhncd6;
    }

    @Column(order = 913, length = 2)
    private String iwsNknenkinsyu6;

    public String getIwsNknenkinsyu6() {
        return iwsNknenkinsyu6;
    }

    public void setIwsNknenkinsyu6(String pIwsNknenkinsyu6) {
        iwsNknenkinsyu6 = pIwsNknenkinsyu6;
    }

    @Column(order = 914, length = 8)
    private String iwsNktaisyouseiymd6;

    public String getIwsNktaisyouseiymd6() {
        return iwsNktaisyouseiymd6;
    }

    public void setIwsNktaisyouseiymd6(String pIwsNktaisyouseiymd6) {
        iwsNktaisyouseiymd6 = pIwsNktaisyouseiymd6;
    }

    @Column(order = 915, length = 2)
    private String iwsNksyouhnsdno6;

    public String getIwsNksyouhnsdno6() {
        return iwsNksyouhnsdno6;
    }

    public void setIwsNksyouhnsdno6(String pIwsNksyouhnsdno6) {
        iwsNksyouhnsdno6 = pIwsNksyouhnsdno6;
    }

    @Column(order = 916, length = 11)
    private String iwsNknksysyno7;

    public String getIwsNknksysyno7() {
        return iwsNknksysyno7;
    }

    public void setIwsNknksysyno7(String pIwsNknksysyno7) {
        iwsNknksysyno7 = pIwsNknksysyno7;
    }

    @Column(order = 917, length = 2)
    private String iwsNknkshrfsegkbn7;

    public String getIwsNknkshrfsegkbn7() {
        return iwsNknkshrfsegkbn7;
    }

    public void setIwsNknkshrfsegkbn7(String pIwsNknkshrfsegkbn7) {
        iwsNknkshrfsegkbn7 = pIwsNknkshrfsegkbn7;
    }

    @Column(order = 918, length = 2)
    private String iwsNknkshrfkojinkbn7;

    public String getIwsNknkshrfkojinkbn7() {
        return iwsNknkshrfkojinkbn7;
    }

    public void setIwsNknkshrfkojinkbn7(String pIwsNknkshrfkojinkbn7) {
        iwsNknkshrfkojinkbn7 = pIwsNknkshrfkojinkbn7;
    }

    @Column(order = 919, length = 8)
    private String iwsNkkykymd7;

    public String getIwsNkkykymd7() {
        return iwsNkkykymd7;
    }

    public void setIwsNkkykymd7(String pIwsNkkykymd7) {
        iwsNkkykymd7 = pIwsNkkykymd7;
    }

    @Column(order = 920, length = 8)
    private String iwsNknkshrstartymd7;

    public String getIwsNknkshrstartymd7() {
        return iwsNknkshrstartymd7;
    }

    public void setIwsNknkshrstartymd7(String pIwsNknkshrstartymd7) {
        iwsNknkshrstartymd7 = pIwsNknkshrstartymd7;
    }

    @Column(order = 921, length = 2)
    private String iwsNknksyoumetucd7;

    public String getIwsNknksyoumetucd7() {
        return iwsNknksyoumetucd7;
    }

    public void setIwsNknksyoumetucd7(String pIwsNknksyoumetucd7) {
        iwsNknksyoumetucd7 = pIwsNknksyoumetucd7;
    }

    @Column(order = 922, length = 8)
    private String iwsNksyoumetuymd7;

    public String getIwsNksyoumetuymd7() {
        return iwsNksyoumetuymd7;
    }

    public void setIwsNksyoumetuymd7(String pIwsNksyoumetuymd7) {
        iwsNksyoumetuymd7 = pIwsNksyoumetuymd7;
    }

    @Column(order = 923, length = 2)
    private String iwsNksyouhncd7;

    public String getIwsNksyouhncd7() {
        return iwsNksyouhncd7;
    }

    public void setIwsNksyouhncd7(String pIwsNksyouhncd7) {
        iwsNksyouhncd7 = pIwsNksyouhncd7;
    }

    @Column(order = 924, length = 2)
    private String iwsNknenkinsyu7;

    public String getIwsNknenkinsyu7() {
        return iwsNknenkinsyu7;
    }

    public void setIwsNknenkinsyu7(String pIwsNknenkinsyu7) {
        iwsNknenkinsyu7 = pIwsNknenkinsyu7;
    }

    @Column(order = 925, length = 8)
    private String iwsNktaisyouseiymd7;

    public String getIwsNktaisyouseiymd7() {
        return iwsNktaisyouseiymd7;
    }

    public void setIwsNktaisyouseiymd7(String pIwsNktaisyouseiymd7) {
        iwsNktaisyouseiymd7 = pIwsNktaisyouseiymd7;
    }

    @Column(order = 926, length = 2)
    private String iwsNksyouhnsdno7;

    public String getIwsNksyouhnsdno7() {
        return iwsNksyouhnsdno7;
    }

    public void setIwsNksyouhnsdno7(String pIwsNksyouhnsdno7) {
        iwsNksyouhnsdno7 = pIwsNksyouhnsdno7;
    }

    @Column(order = 927, length = 11)
    private String iwsNknksysyno8;

    public String getIwsNknksysyno8() {
        return iwsNknksysyno8;
    }

    public void setIwsNknksysyno8(String pIwsNknksysyno8) {
        iwsNknksysyno8 = pIwsNknksysyno8;
    }

    @Column(order = 928, length = 2)
    private String iwsNknkshrfsegkbn8;

    public String getIwsNknkshrfsegkbn8() {
        return iwsNknkshrfsegkbn8;
    }

    public void setIwsNknkshrfsegkbn8(String pIwsNknkshrfsegkbn8) {
        iwsNknkshrfsegkbn8 = pIwsNknkshrfsegkbn8;
    }

    @Column(order = 929, length = 2)
    private String iwsNknkshrfkojinkbn8;

    public String getIwsNknkshrfkojinkbn8() {
        return iwsNknkshrfkojinkbn8;
    }

    public void setIwsNknkshrfkojinkbn8(String pIwsNknkshrfkojinkbn8) {
        iwsNknkshrfkojinkbn8 = pIwsNknkshrfkojinkbn8;
    }

    @Column(order = 930, length = 8)
    private String iwsNkkykymd8;

    public String getIwsNkkykymd8() {
        return iwsNkkykymd8;
    }

    public void setIwsNkkykymd8(String pIwsNkkykymd8) {
        iwsNkkykymd8 = pIwsNkkykymd8;
    }

    @Column(order = 931, length = 8)
    private String iwsNknkshrstartymd8;

    public String getIwsNknkshrstartymd8() {
        return iwsNknkshrstartymd8;
    }

    public void setIwsNknkshrstartymd8(String pIwsNknkshrstartymd8) {
        iwsNknkshrstartymd8 = pIwsNknkshrstartymd8;
    }

    @Column(order = 932, length = 2)
    private String iwsNknksyoumetucd8;

    public String getIwsNknksyoumetucd8() {
        return iwsNknksyoumetucd8;
    }

    public void setIwsNknksyoumetucd8(String pIwsNknksyoumetucd8) {
        iwsNknksyoumetucd8 = pIwsNknksyoumetucd8;
    }

    @Column(order = 933, length = 8)
    private String iwsNksyoumetuymd8;

    public String getIwsNksyoumetuymd8() {
        return iwsNksyoumetuymd8;
    }

    public void setIwsNksyoumetuymd8(String pIwsNksyoumetuymd8) {
        iwsNksyoumetuymd8 = pIwsNksyoumetuymd8;
    }

    @Column(order = 934, length = 2)
    private String iwsNksyouhncd8;

    public String getIwsNksyouhncd8() {
        return iwsNksyouhncd8;
    }

    public void setIwsNksyouhncd8(String pIwsNksyouhncd8) {
        iwsNksyouhncd8 = pIwsNksyouhncd8;
    }

    @Column(order = 935, length = 2)
    private String iwsNknenkinsyu8;

    public String getIwsNknenkinsyu8() {
        return iwsNknenkinsyu8;
    }

    public void setIwsNknenkinsyu8(String pIwsNknenkinsyu8) {
        iwsNknenkinsyu8 = pIwsNknenkinsyu8;
    }

    @Column(order = 936, length = 8)
    private String iwsNktaisyouseiymd8;

    public String getIwsNktaisyouseiymd8() {
        return iwsNktaisyouseiymd8;
    }

    public void setIwsNktaisyouseiymd8(String pIwsNktaisyouseiymd8) {
        iwsNktaisyouseiymd8 = pIwsNktaisyouseiymd8;
    }

    @Column(order = 937, length = 2)
    private String iwsNksyouhnsdno8;

    public String getIwsNksyouhnsdno8() {
        return iwsNksyouhnsdno8;
    }

    public void setIwsNksyouhnsdno8(String pIwsNksyouhnsdno8) {
        iwsNksyouhnsdno8 = pIwsNksyouhnsdno8;
    }

    @Column(order = 938, length = 11)
    private String iwsNknksysyno9;

    public String getIwsNknksysyno9() {
        return iwsNknksysyno9;
    }

    public void setIwsNknksysyno9(String pIwsNknksysyno9) {
        iwsNknksysyno9 = pIwsNknksysyno9;
    }

    @Column(order = 939, length = 2)
    private String iwsNknkshrfsegkbn9;

    public String getIwsNknkshrfsegkbn9() {
        return iwsNknkshrfsegkbn9;
    }

    public void setIwsNknkshrfsegkbn9(String pIwsNknkshrfsegkbn9) {
        iwsNknkshrfsegkbn9 = pIwsNknkshrfsegkbn9;
    }

    @Column(order = 940, length = 2)
    private String iwsNknkshrfkojinkbn9;

    public String getIwsNknkshrfkojinkbn9() {
        return iwsNknkshrfkojinkbn9;
    }

    public void setIwsNknkshrfkojinkbn9(String pIwsNknkshrfkojinkbn9) {
        iwsNknkshrfkojinkbn9 = pIwsNknkshrfkojinkbn9;
    }

    @Column(order = 941, length = 8)
    private String iwsNkkykymd9;

    public String getIwsNkkykymd9() {
        return iwsNkkykymd9;
    }

    public void setIwsNkkykymd9(String pIwsNkkykymd9) {
        iwsNkkykymd9 = pIwsNkkykymd9;
    }

    @Column(order = 942, length = 8)
    private String iwsNknkshrstartymd9;

    public String getIwsNknkshrstartymd9() {
        return iwsNknkshrstartymd9;
    }

    public void setIwsNknkshrstartymd9(String pIwsNknkshrstartymd9) {
        iwsNknkshrstartymd9 = pIwsNknkshrstartymd9;
    }

    @Column(order = 943, length = 2)
    private String iwsNknksyoumetucd9;

    public String getIwsNknksyoumetucd9() {
        return iwsNknksyoumetucd9;
    }

    public void setIwsNknksyoumetucd9(String pIwsNknksyoumetucd9) {
        iwsNknksyoumetucd9 = pIwsNknksyoumetucd9;
    }

    @Column(order = 944, length = 8)
    private String iwsNksyoumetuymd9;

    public String getIwsNksyoumetuymd9() {
        return iwsNksyoumetuymd9;
    }

    public void setIwsNksyoumetuymd9(String pIwsNksyoumetuymd9) {
        iwsNksyoumetuymd9 = pIwsNksyoumetuymd9;
    }

    @Column(order = 945, length = 2)
    private String iwsNksyouhncd9;

    public String getIwsNksyouhncd9() {
        return iwsNksyouhncd9;
    }

    public void setIwsNksyouhncd9(String pIwsNksyouhncd9) {
        iwsNksyouhncd9 = pIwsNksyouhncd9;
    }

    @Column(order = 946, length = 2)
    private String iwsNknenkinsyu9;

    public String getIwsNknenkinsyu9() {
        return iwsNknenkinsyu9;
    }

    public void setIwsNknenkinsyu9(String pIwsNknenkinsyu9) {
        iwsNknenkinsyu9 = pIwsNknenkinsyu9;
    }

    @Column(order = 947, length = 8)
    private String iwsNktaisyouseiymd9;

    public String getIwsNktaisyouseiymd9() {
        return iwsNktaisyouseiymd9;
    }

    public void setIwsNktaisyouseiymd9(String pIwsNktaisyouseiymd9) {
        iwsNktaisyouseiymd9 = pIwsNktaisyouseiymd9;
    }

    @Column(order = 948, length = 2)
    private String iwsNksyouhnsdno9;

    public String getIwsNksyouhnsdno9() {
        return iwsNksyouhnsdno9;
    }

    public void setIwsNksyouhnsdno9(String pIwsNksyouhnsdno9) {
        iwsNksyouhnsdno9 = pIwsNksyouhnsdno9;
    }

    @Column(order = 949, length = 11)
    private String iwsNknksysyno10;

    public String getIwsNknksysyno10() {
        return iwsNknksysyno10;
    }

    public void setIwsNknksysyno10(String pIwsNknksysyno10) {
        iwsNknksysyno10 = pIwsNknksysyno10;
    }

    @Column(order = 950, length = 2)
    private String iwsNknkshrfsegkbn10;

    public String getIwsNknkshrfsegkbn10() {
        return iwsNknkshrfsegkbn10;
    }

    public void setIwsNknkshrfsegkbn10(String pIwsNknkshrfsegkbn10) {
        iwsNknkshrfsegkbn10 = pIwsNknkshrfsegkbn10;
    }

    @Column(order = 951, length = 2)
    private String iwsNknkshrfkojinkbn10;

    public String getIwsNknkshrfkojinkbn10() {
        return iwsNknkshrfkojinkbn10;
    }

    public void setIwsNknkshrfkojinkbn10(String pIwsNknkshrfkojinkbn10) {
        iwsNknkshrfkojinkbn10 = pIwsNknkshrfkojinkbn10;
    }

    @Column(order = 952, length = 8)
    private String iwsNkkykymd10;

    public String getIwsNkkykymd10() {
        return iwsNkkykymd10;
    }

    public void setIwsNkkykymd10(String pIwsNkkykymd10) {
        iwsNkkykymd10 = pIwsNkkykymd10;
    }

    @Column(order = 953, length = 8)
    private String iwsNknkshrstartymd10;

    public String getIwsNknkshrstartymd10() {
        return iwsNknkshrstartymd10;
    }

    public void setIwsNknkshrstartymd10(String pIwsNknkshrstartymd10) {
        iwsNknkshrstartymd10 = pIwsNknkshrstartymd10;
    }

    @Column(order = 954, length = 2)
    private String iwsNknksyoumetucd10;

    public String getIwsNknksyoumetucd10() {
        return iwsNknksyoumetucd10;
    }

    public void setIwsNknksyoumetucd10(String pIwsNknksyoumetucd10) {
        iwsNknksyoumetucd10 = pIwsNknksyoumetucd10;
    }

    @Column(order = 955, length = 8)
    private String iwsNksyoumetuymd10;

    public String getIwsNksyoumetuymd10() {
        return iwsNksyoumetuymd10;
    }

    public void setIwsNksyoumetuymd10(String pIwsNksyoumetuymd10) {
        iwsNksyoumetuymd10 = pIwsNksyoumetuymd10;
    }

    @Column(order = 956, length = 2)
    private String iwsNksyouhncd10;

    public String getIwsNksyouhncd10() {
        return iwsNksyouhncd10;
    }

    public void setIwsNksyouhncd10(String pIwsNksyouhncd10) {
        iwsNksyouhncd10 = pIwsNksyouhncd10;
    }

    @Column(order = 957, length = 2)
    private String iwsNknenkinsyu10;

    public String getIwsNknenkinsyu10() {
        return iwsNknenkinsyu10;
    }

    public void setIwsNknenkinsyu10(String pIwsNknenkinsyu10) {
        iwsNknenkinsyu10 = pIwsNknenkinsyu10;
    }

    @Column(order = 958, length = 8)
    private String iwsNktaisyouseiymd10;

    public String getIwsNktaisyouseiymd10() {
        return iwsNktaisyouseiymd10;
    }

    public void setIwsNktaisyouseiymd10(String pIwsNktaisyouseiymd10) {
        iwsNktaisyouseiymd10 = pIwsNktaisyouseiymd10;
    }

    @Column(order = 959, length = 2)
    private String iwsNksyouhnsdno10;

    public String getIwsNksyouhnsdno10() {
        return iwsNksyouhnsdno10;
    }

    public void setIwsNksyouhnsdno10(String pIwsNksyouhnsdno10) {
        iwsNksyouhnsdno10 = pIwsNksyouhnsdno10;
    }

    @Column(order = 960, length = 1)
    private String iwsSntkinfomrarihyj;

    public String getIwsSntkinfomrarihyj() {
        return iwsSntkinfomrarihyj;
    }

    public void setIwsSntkinfomrarihyj(String pIwsSntkinfomrarihyj) {
        iwsSntkinfomrarihyj = pIwsSntkinfomrarihyj;
    }

    @Column(order = 961, length = 1)
    private String iwsSntkinfohnsyaarihyj;

    public String getIwsSntkinfohnsyaarihyj() {
        return iwsSntkinfohnsyaarihyj;
    }

    public void setIwsSntkinfohnsyaarihyj(String pIwsSntkinfohnsyaarihyj) {
        iwsSntkinfohnsyaarihyj = pIwsSntkinfohnsyaarihyj;
    }

    @Column(order = 962, length = 1)
    private String iwsSignalinfoarihyj;

    public String getIwsSignalinfoarihyj() {
        return iwsSignalinfoarihyj;
    }

    public void setIwsSignalinfoarihyj(String pIwsSignalinfoarihyj) {
        iwsSignalinfoarihyj = pIwsSignalinfoarihyj;
    }

    @Column(order = 963, length = 1)
    private String iwsSignalinfohnsyaarihyj;

    public String getIwsSignalinfohnsyaarihyj() {
        return iwsSignalinfohnsyaarihyj;
    }

    public void setIwsSignalinfohnsyaarihyj(String pIwsSignalinfohnsyaarihyj) {
        iwsSignalinfohnsyaarihyj = pIwsSignalinfohnsyaarihyj;
    }

    @Column(order = 964, length = 1)
    private String iwsGaikokupepshyj;

    public String getIwsGaikokupepshyj() {
        return iwsGaikokupepshyj;
    }

    public void setIwsGaikokupepshyj(String pIwsGaikokupepshyj) {
        iwsGaikokupepshyj = pIwsGaikokupepshyj;
    }

    @Column(order = 965, length = 1)
    private String iwsSinsntkinfohnsyaarihyj;

    public String getIwsSinsntkinfohnsyaarihyj() {
        return iwsSinsntkinfohnsyaarihyj;
    }

    public void setIwsSinsntkinfohnsyaarihyj(String pIwsSinsntkinfohnsyaarihyj) {
        iwsSinsntkinfohnsyaarihyj = pIwsSinsntkinfohnsyaarihyj;
    }

    @Column(order = 966, length = 11)
    private String iwsTsnsousibous;

    public String getIwsTsnsousibous() {
        return iwsTsnsousibous;
    }

    public void setIwsTsnsousibous(String pIwsTsnsousibous) {
        iwsTsnsousibous = pIwsTsnsousibous;
    }

    @Column(order = 967, length = 11)
    private String iwsTsnninenmikeikasousibous;

    public String getIwsTsnninenmikeikasousibous() {
        return iwsTsnninenmikeikasousibous;
    }

    public void setIwsTsnninenmikeikasousibous(String pIwsTsnninenmikeikasousibous) {
        iwsTsnninenmikeikasousibous = pIwsTsnninenmikeikasousibous;
    }

    @Column(order = 968, length = 11)
    private String iwsTsnninenkeikasousibous;

    public String getIwsTsnninenkeikasousibous() {
        return iwsTsnninenkeikasousibous;
    }

    public void setIwsTsnninenkeikasousibous(String pIwsTsnninenkeikasousibous) {
        iwsTsnninenkeikasousibous = pIwsTsnninenkeikasousibous;
    }

    @Column(order = 969, length = 11)
    private String iwsTsnketteisousibous;

    public String getIwsTsnketteisousibous() {
        return iwsTsnketteisousibous;
    }

    public void setIwsTsnketteisousibous(String pIwsTsnketteisousibous) {
        iwsTsnketteisousibous = pIwsTsnketteisousibous;
    }

    @Column(order = 970, length = 11)
    private String iwsTsnketteisousibous2;

    public String getIwsTsnketteisousibous2() {
        return iwsTsnketteisousibous2;
    }

    public void setIwsTsnketteisousibous2(String pIwsTsnketteisousibous2) {
        iwsTsnketteisousibous2 = pIwsTsnketteisousibous2;
    }

    @Column(order = 971, length = 11)
    private String iwsTsnsoukktjituhsgk;

    public String getIwsTsnsoukktjituhsgk() {
        return iwsTsnsoukktjituhsgk;
    }

    public void setIwsTsnsoukktjituhsgk(String pIwsTsnsoukktjituhsgk) {
        iwsTsnsoukktjituhsgk = pIwsTsnsoukktjituhsgk;
    }

    @Column(order = 972, length = 11)
    private String iwsTsnkktjituhsgk1;

    public String getIwsTsnkktjituhsgk1() {
        return iwsTsnkktjituhsgk1;
    }

    public void setIwsTsnkktjituhsgk1(String pIwsTsnkktjituhsgk1) {
        iwsTsnkktjituhsgk1 = pIwsTsnkktjituhsgk1;
    }

    @Column(order = 973, length = 11)
    private String iwsTsnkktjituhsgk2;

    public String getIwsTsnkktjituhsgk2() {
        return iwsTsnkktjituhsgk2;
    }

    public void setIwsTsnkktjituhsgk2(String pIwsTsnkktjituhsgk2) {
        iwsTsnkktjituhsgk2 = pIwsTsnkktjituhsgk2;
    }

    @Column(order = 974, length = 11)
    private String iwsTsnkktitijibrisysnjs;

    public String getIwsTsnkktitijibrisysnjs() {
        return iwsTsnkktitijibrisysnjs;
    }

    public void setIwsTsnkktitijibrisysnjs(String pIwsTsnkktitijibrisysnjs) {
        iwsTsnkktitijibrisysnjs = pIwsTsnkktitijibrisysnjs;
    }

    @Column(order = 975, length = 11)
    private String iwsTsnnkgns;

    public String getIwsTsnnkgns() {
        return iwsTsnnkgns;
    }

    public void setIwsTsnnkgns(String pIwsTsnnkgns) {
        iwsTsnnkgns = pIwsTsnnkgns;
    }

    @Column(order = 976, length = 11)
    private String iwsTsnmsnynenbtsousibous;

    public String getIwsTsnmsnynenbtsousibous() {
        return iwsTsnmsnynenbtsousibous;
    }

    public void setIwsTsnmsnynenbtsousibous(String pIwsTsnmsnynenbtsousibous) {
        iwsTsnmsnynenbtsousibous = pIwsTsnmsnynenbtsousibous;
    }

    @Column(order = 977, length = 11)
    private String iwsTsnagebtitijibrisousbus;

    public String getIwsTsnagebtitijibrisousbus() {
        return iwsTsnagebtitijibrisousbus;
    }

    public void setIwsTsnagebtitijibrisousbus(String pIwsTsnagebtitijibrisousbus) {
        iwsTsnagebtitijibrisousbus = pIwsTsnagebtitijibrisousbus;
    }

    @Column(order = 978, length = 11)
    private String iwsTsnitijibrsysnp;

    public String getIwsTsnitijibrsysnp() {
        return iwsTsnitijibrsysnp;
    }

    public void setIwsTsnitijibrsysnp(String pIwsTsnitijibrsysnp) {
        iwsTsnitijibrsysnp = pIwsTsnitijibrsysnp;
    }

    @Column(order = 979, length = 11)
    private String iwsTsnninenmikeikahtnkns;

    public String getIwsTsnninenmikeikahtnkns() {
        return iwsTsnninenmikeikahtnkns;
    }

    public void setIwsTsnninenmikeikahtnkns(String pIwsTsnninenmikeikahtnkns) {
        iwsTsnninenmikeikahtnkns = pIwsTsnninenmikeikahtnkns;
    }

    @Column(order = 980, length = 11)
    private String iwsTsnninenkeikadfp;

    public String getIwsTsnninenkeikadfp() {
        return iwsTsnninenkeikadfp;
    }

    public void setIwsTsnninenkeikadfp(String pIwsTsnninenkeikadfp) {
        iwsTsnninenkeikadfp = pIwsTsnninenkeikadfp;
    }

    @Column(order = 981, length = 11)
    private String iwsTsnsntktuukahijynsysns;

    public String getIwsTsnsntktuukahijynsysns() {
        return iwsTsnsntktuukahijynsysns;
    }

    public void setIwsTsnsntktuukahijynsysns(String pIwsTsnsntktuukahijynsysns) {
        iwsTsnsntktuukahijynsysns = pIwsTsnsntktuukahijynsysns;
    }

    @Column(order = 982, length = 1)
    private String iwsTsnkaigomehrtkarihyj;

    public String getIwsTsnkaigomehrtkarihyj() {
        return iwsTsnkaigomehrtkarihyj;
    }

    public void setIwsTsnkaigomehrtkarihyj(String pIwsTsnkaigomehrtkarihyj) {
        iwsTsnkaigomehrtkarihyj = pIwsTsnkaigomehrtkarihyj;
    }

    @Column(order = 983, length = 11)
    private String iwsKykdrtentsns;

    public String getIwsKykdrtentsns() {
        return iwsKykdrtentsns;
    }

    public void setIwsKykdrtentsns(String pIwsKykdrtentsns) {
        iwsKykdrtentsns = pIwsKykdrtentsns;
    }

    @Column(order = 984, length = 1)
    private String iwsSibouriskmoshukahyj;

    public String getIwsSibouriskmoshukahyj() {
        return iwsSibouriskmoshukahyj;
    }

    public void setIwsSibouriskmoshukahyj(String pIwsSibouriskmoshukahyj) {
        iwsSibouriskmoshukahyj = pIwsSibouriskmoshukahyj;
    }

    @Column(order = 985, length = 1)
    private String iwsKktsibouriskmoshukahyj;

    public String getIwsKktsibouriskmoshukahyj() {
        return iwsKktsibouriskmoshukahyj;
    }

    public void setIwsKktsibouriskmoshukahyj(String pIwsKktsibouriskmoshukahyj) {
        iwsKktsibouriskmoshukahyj = pIwsKktsibouriskmoshukahyj;
    }

    @Column(order = 986, length = 1)
    private String iwsItineninaienkigaitouhyj;

    public String getIwsItineninaienkigaitouhyj() {
        return iwsItineninaienkigaitouhyj;
    }

    public void setIwsItineninaienkigaitouhyj(String pIwsItineninaienkigaitouhyj) {
        iwsItineninaienkigaitouhyj = pIwsItineninaienkigaitouhyj;
    }

    @Column(order = 987, length = 1)
    private String iwsItekisntkhndktyouhyj;

    public String getIwsItekisntkhndktyouhyj() {
        return iwsItekisntkhndktyouhyj;
    }

    public void setIwsItekisntkhndktyouhyj(String pIwsItekisntkhndktyouhyj) {
        iwsItekisntkhndktyouhyj = pIwsItekisntkhndktyouhyj;
    }

    @Column(order = 988, length = 1)
    private String iwsTtdktyuuiknkhndktyouhyj;

    public String getIwsTtdktyuuiknkhndktyouhyj() {
        return iwsTtdktyuuiknkhndktyouhyj;
    }

    public void setIwsTtdktyuuiknkhndktyouhyj(String pIwsTtdktyuuiknkhndktyouhyj) {
        iwsTtdktyuuiknkhndktyouhyj = pIwsTtdktyuuiknkhndktyouhyj;
    }

    @Column(order = 989, length = 1)
    private String iwsUktttdktyuuihndktyouhyj;

    public String getIwsUktttdktyuuihndktyouhyj() {
        return iwsUktttdktyuuihndktyouhyj;
    }

    public void setIwsUktttdktyuuihndktyouhyj(String pIwsUktttdktyuuihndktyouhyj) {
        iwsUktttdktyuuihndktyouhyj = pIwsUktttdktyuuihndktyouhyj;
    }

    @Column(order = 990, length = 1)
    private String iwsKyhkinuktkitkhndktyouhyj;

    public String getIwsKyhkinuktkitkhndktyouhyj() {
        return iwsKyhkinuktkitkhndktyouhyj;
    }

    public void setIwsKyhkinuktkitkhndktyouhyj(String pIwsKyhkinuktkitkhndktyouhyj) {
        iwsKyhkinuktkitkhndktyouhyj = pIwsKyhkinuktkitkhndktyouhyj;
    }

    @Column(order = 991, length = 1)
    private String iwsDoujimositekihndktyouhyj;

    public String getIwsDoujimositekihndktyouhyj() {
        return iwsDoujimositekihndktyouhyj;
    }

    public void setIwsDoujimositekihndktyouhyj(String pIwsDoujimositekihndktyouhyj) {
        iwsDoujimositekihndktyouhyj = pIwsDoujimositekihndktyouhyj;
    }

    @Column(order = 992, length = 1)
    private String iwsDoujimosknkhndktyouhyj;

    public String getIwsDoujimosknkhndktyouhyj() {
        return iwsDoujimosknkhndktyouhyj;
    }

    public void setIwsDoujimosknkhndktyouhyj(String pIwsDoujimosknkhndktyouhyj) {
        iwsDoujimosknkhndktyouhyj = pIwsDoujimosknkhndktyouhyj;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
