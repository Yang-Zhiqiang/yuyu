package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SkFurikaeDenpyouHikaeTy;
import yuyu.def.db.mapping.GenZT_SkFurikaeDenpyouHikaeTy;
import yuyu.def.db.meta.GenQZT_SkFurikaeDenpyouHikaeTy;
import yuyu.def.db.meta.QZT_SkFurikaeDenpyouHikaeTy;

/**
 * 新契約振替伝票（控）テーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SkFurikaeDenpyouHikaeTy}</td><td colspan="3">新契約振替伝票（控）テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztykytkmksyoruicd</td><td>（中継用）共通項目書類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykytkmktyouhyousksymd</td><td>（中継用）共通項目帳票作成年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykytkmksystemkbn</td><td>（中継用）共通項目システム区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykytkmktorihikino</td><td>（中継用）共通項目取引番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykytkmktorihikinoedano</td><td>（中継用）共通項目取引番号枝番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykytkmkseifukukbn</td><td>（中継用）共通項目正副区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykytkmkfuridenhassoukbn</td><td>（中継用）共通項目振替伝票用発送区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykytkmkyobi</td><td>（中継用）共通項目予備項目</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysystemkbn</td><td>（中継用）システム区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytorihikinoc8 ztytorihikinoc8}</td><td>（中継用）取引番号Ｃ８</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytorihikinoedano ztytorihikinoedano}</td><td>（中継用）取引番号枝番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjhikaeinjikm</td><td>（中継用）漢字控印字項目</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytorihikiymdgengokbn ztytorihikiymdgengokbn}</td><td>（中継用）取引年月日元号区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytorihikinen ztytorihikinen}</td><td>（中継用）取引年</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytorihikituki ztytorihikituki}</td><td>（中継用）取引月</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytorihikibi ztytorihikibi}</td><td>（中継用）取引日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykanjyoukbn</td><td>（中継用）勘定区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykanjyoukbnnm</td><td>（中継用）勘定区分名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjtantoukanm</td><td>（中継用）漢字担当課名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjtantoucd</td><td>（中継用）漢字担当コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjsystemnm</td><td>（中継用）漢字システム名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykarikurikosikingaku</td><td>（中継用）借方繰越金額</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykasikurikosikingaku</td><td>（中継用）貸方繰越金額</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydenpyoukbnnm</td><td>（中継用）伝票区分名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkarikurikosigkhyjkm</td><td>（中継用）漢字借方繰越合計表示項目</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykarikurikosigkkingaku</td><td>（中継用）借方繰越合計金額</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkasikurikosigkhyjkm</td><td>（中継用）漢字貸方繰越合計表示項目</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykasikurikosigkkingaku</td><td>（中継用）貸方繰越合計金額</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjtekiyou1</td><td>（中継用）漢字摘要１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjtekiyou2</td><td>（中継用）漢字摘要２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjtekiyou3</td><td>（中継用）漢字摘要３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkarikanjyoukamokunm1</td><td>（中継用）漢字借方勘定科目名１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkasikanjyoukamokunm1</td><td>（中継用）漢字貸方勘定科目名１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaritekiyoukm1</td><td>（中継用）借方摘要項目１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykarikingaku1</td><td>（中継用）借方金額１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykasitekiyoukm1</td><td>（中継用）貸方摘要項目１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykasikingaku1</td><td>（中継用）貸方金額１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkaritekiyoukm1</td><td>（中継用）漢字借方摘要項目１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkasitekiyoukm1</td><td>（中継用）漢字貸方摘要項目１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkarikanjyoukamokunm2</td><td>（中継用）漢字借方勘定科目名２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkasikanjyoukamokunm2</td><td>（中継用）漢字貸方勘定科目名２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaritekiyoukm2</td><td>（中継用）借方摘要項目２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykarikingaku2</td><td>（中継用）借方金額２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykasitekiyoukm2</td><td>（中継用）貸方摘要項目２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykasikingaku2</td><td>（中継用）貸方金額２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkaritekiyoukm2</td><td>（中継用）漢字借方摘要項目２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkasitekiyoukm2</td><td>（中継用）漢字貸方摘要項目２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkarikanjyoukamokunm3</td><td>（中継用）漢字借方勘定科目名３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkasikanjyoukamokunm3</td><td>（中継用）漢字貸方勘定科目名３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaritekiyoukm3</td><td>（中継用）借方摘要項目３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykarikingaku3</td><td>（中継用）借方金額３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykasitekiyoukm3</td><td>（中継用）貸方摘要項目３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykasikingaku3</td><td>（中継用）貸方金額３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkaritekiyoukm3</td><td>（中継用）漢字借方摘要項目３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkasitekiyoukm3</td><td>（中継用）漢字貸方摘要項目３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkarikanjyoukamokunm4</td><td>（中継用）漢字借方勘定科目名４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkasikanjyoukamokunm4</td><td>（中継用）漢字貸方勘定科目名４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaritekiyoukm4</td><td>（中継用）借方摘要項目４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykarikingaku4</td><td>（中継用）借方金額４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykasitekiyoukm4</td><td>（中継用）貸方摘要項目４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykasikingaku4</td><td>（中継用）貸方金額４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkaritekiyoukm4</td><td>（中継用）漢字借方摘要項目４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkasitekiyoukm4</td><td>（中継用）漢字貸方摘要項目４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SkFurikaeDenpyouHikaeTy
 * @see     GenZT_SkFurikaeDenpyouHikaeTy
 * @see     QZT_SkFurikaeDenpyouHikaeTy
 * @see     GenQZT_SkFurikaeDenpyouHikaeTy
 */
public class PKZT_SkFurikaeDenpyouHikaeTy extends AbstractExDBPrimaryKey<ZT_SkFurikaeDenpyouHikaeTy, PKZT_SkFurikaeDenpyouHikaeTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_SkFurikaeDenpyouHikaeTy() {
    }

    public PKZT_SkFurikaeDenpyouHikaeTy(
        String pZtytorihikinoc8,
        String pZtytorihikinoedano,
        String pZtytorihikiymdgengokbn,
        String pZtytorihikinen,
        String pZtytorihikituki,
        String pZtytorihikibi
    ) {
        ztytorihikinoc8 = pZtytorihikinoc8;
        ztytorihikinoedano = pZtytorihikinoedano;
        ztytorihikiymdgengokbn = pZtytorihikiymdgengokbn;
        ztytorihikinen = pZtytorihikinen;
        ztytorihikituki = pZtytorihikituki;
        ztytorihikibi = pZtytorihikibi;
    }

    @Transient
    @Override
    public Class<ZT_SkFurikaeDenpyouHikaeTy> getEntityClass() {
        return ZT_SkFurikaeDenpyouHikaeTy.class;
    }

    private String ztytorihikinoc8;

    public String getZtytorihikinoc8() {
        return ztytorihikinoc8;
    }

    public void setZtytorihikinoc8(String pZtytorihikinoc8) {
        ztytorihikinoc8 = pZtytorihikinoc8;
    }
    private String ztytorihikinoedano;

    public String getZtytorihikinoedano() {
        return ztytorihikinoedano;
    }

    public void setZtytorihikinoedano(String pZtytorihikinoedano) {
        ztytorihikinoedano = pZtytorihikinoedano;
    }
    private String ztytorihikiymdgengokbn;

    public String getZtytorihikiymdgengokbn() {
        return ztytorihikiymdgengokbn;
    }

    public void setZtytorihikiymdgengokbn(String pZtytorihikiymdgengokbn) {
        ztytorihikiymdgengokbn = pZtytorihikiymdgengokbn;
    }
    private String ztytorihikinen;

    public String getZtytorihikinen() {
        return ztytorihikinen;
    }

    public void setZtytorihikinen(String pZtytorihikinen) {
        ztytorihikinen = pZtytorihikinen;
    }
    private String ztytorihikituki;

    public String getZtytorihikituki() {
        return ztytorihikituki;
    }

    public void setZtytorihikituki(String pZtytorihikituki) {
        ztytorihikituki = pZtytorihikituki;
    }
    private String ztytorihikibi;

    public String getZtytorihikibi() {
        return ztytorihikibi;
    }

    public void setZtytorihikibi(String pZtytorihikibi) {
        ztytorihikibi = pZtytorihikibi;
    }

}