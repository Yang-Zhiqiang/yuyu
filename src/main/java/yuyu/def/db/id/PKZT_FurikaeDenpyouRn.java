package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_FurikaeDenpyouRn;
import yuyu.def.db.mapping.GenZT_FurikaeDenpyouRn;
import yuyu.def.db.meta.GenQZT_FurikaeDenpyouRn;
import yuyu.def.db.meta.QZT_FurikaeDenpyouRn;

/**
 * 振替伝票テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_FurikaeDenpyouRn}</td><td colspan="3">振替伝票テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrnkytkmksyoruicd</td><td>（連携用）共通項目書類コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkytkmktyouhyousksymd</td><td>（連携用）共通項目帳票作成年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkytkmksystemkbn</td><td>（連携用）共通項目システム区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkytkmktorihikino</td><td>（連携用）共通項目取引番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkytkmktorihikinoedano</td><td>（連携用）共通項目取引番号枝番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkytkmkseifukukbn</td><td>（連携用）共通項目正副区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkytkmkfuridenhassoukbn</td><td>（連携用）共通項目振替伝票用発送区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkytkmkyobi</td><td>（連携用）共通項目予備項目</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsystemkbn</td><td>（連携用）システム区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntorihikinoc8 zrntorihikinoc8}</td><td>（連携用）取引番号Ｃ８</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntorihikinoedano zrntorihikinoedano}</td><td>（連携用）取引番号枝番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjhikaeinjikm</td><td>（連携用）漢字控印字項目</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntorihikiymdgengokbn zrntorihikiymdgengokbn}</td><td>（連携用）取引年月日元号区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntorihikinen zrntorihikinen}</td><td>（連携用）取引年</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntorihikituki zrntorihikituki}</td><td>（連携用）取引月</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntorihikibi zrntorihikibi}</td><td>（連携用）取引日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkanjyoukbn</td><td>（連携用）勘定区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkanjyoukbnnm</td><td>（連携用）勘定区分名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkjtantoukanm</td><td>（連携用）漢字担当課名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkjtantoucd</td><td>（連携用）漢字担当コード</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkjsystemnm</td><td>（連携用）漢字システム名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkarikurikosikingaku</td><td>（連携用）借方繰越金額</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkasikurikosikingaku</td><td>（連携用）貸方繰越金額</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndenpyoukbnnm</td><td>（連携用）伝票区分名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkjkarikurikosigkhyjkm</td><td>（連携用）漢字借方繰越合計表示項目</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkarikurikosigkkingaku</td><td>（連携用）借方繰越合計金額</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjkasikurikosigkhyjkm</td><td>（連携用）漢字貸方繰越合計表示項目</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkasikurikosigkkingaku</td><td>（連携用）貸方繰越合計金額</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjtekiyou1</td><td>（連携用）漢字摘要１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkjtekiyou2</td><td>（連携用）漢字摘要２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkjtekiyou3</td><td>（連携用）漢字摘要３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkjkarikanjyoukamokunm1</td><td>（連携用）漢字借方勘定科目名１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkjkasikanjyoukamokunm1</td><td>（連携用）漢字貸方勘定科目名１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkaritekiyoukm1</td><td>（連携用）借方摘要項目１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkarikingaku1</td><td>（連携用）借方金額１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkasitekiyoukm1</td><td>（連携用）貸方摘要項目１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkasikingaku1</td><td>（連携用）貸方金額１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjkaritekiyoukm1</td><td>（連携用）漢字借方摘要項目１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkjkasitekiyoukm1</td><td>（連携用）漢字貸方摘要項目１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkjkarikanjyoukamokunm2</td><td>（連携用）漢字借方勘定科目名２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkjkasikanjyoukamokunm2</td><td>（連携用）漢字貸方勘定科目名２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkaritekiyoukm2</td><td>（連携用）借方摘要項目２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkarikingaku2</td><td>（連携用）借方金額２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkasitekiyoukm2</td><td>（連携用）貸方摘要項目２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkasikingaku2</td><td>（連携用）貸方金額２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjkaritekiyoukm2</td><td>（連携用）漢字借方摘要項目２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkjkasitekiyoukm2</td><td>（連携用）漢字貸方摘要項目２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkjkarikanjyoukamokunm3</td><td>（連携用）漢字借方勘定科目名３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkjkasikanjyoukamokunm3</td><td>（連携用）漢字貸方勘定科目名３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkaritekiyoukm3</td><td>（連携用）借方摘要項目３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkarikingaku3</td><td>（連携用）借方金額３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkasitekiyoukm3</td><td>（連携用）貸方摘要項目３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkasikingaku3</td><td>（連携用）貸方金額３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjkaritekiyoukm3</td><td>（連携用）漢字借方摘要項目３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkjkasitekiyoukm3</td><td>（連携用）漢字貸方摘要項目３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkjkarikanjyoukamokunm4</td><td>（連携用）漢字借方勘定科目名４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkjkasikanjyoukamokunm4</td><td>（連携用）漢字貸方勘定科目名４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkaritekiyoukm4</td><td>（連携用）借方摘要項目４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkarikingaku4</td><td>（連携用）借方金額４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkasitekiyoukm4</td><td>（連携用）貸方摘要項目４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkasikingaku4</td><td>（連携用）貸方金額４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjkaritekiyoukm4</td><td>（連携用）漢字借方摘要項目４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkjkasitekiyoukm4</td><td>（連携用）漢字貸方摘要項目４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 * </table>
 * @see     ZT_FurikaeDenpyouRn
 * @see     GenZT_FurikaeDenpyouRn
 * @see     QZT_FurikaeDenpyouRn
 * @see     GenQZT_FurikaeDenpyouRn
 */
public class PKZT_FurikaeDenpyouRn extends AbstractExDBPrimaryKey<ZT_FurikaeDenpyouRn, PKZT_FurikaeDenpyouRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_FurikaeDenpyouRn() {
    }

    public PKZT_FurikaeDenpyouRn(
        String pZrntorihikinoc8,
        String pZrntorihikinoedano,
        String pZrntorihikiymdgengokbn,
        String pZrntorihikinen,
        String pZrntorihikituki,
        String pZrntorihikibi
    ) {
        zrntorihikinoc8 = pZrntorihikinoc8;
        zrntorihikinoedano = pZrntorihikinoedano;
        zrntorihikiymdgengokbn = pZrntorihikiymdgengokbn;
        zrntorihikinen = pZrntorihikinen;
        zrntorihikituki = pZrntorihikituki;
        zrntorihikibi = pZrntorihikibi;
    }

    @Transient
    @Override
    public Class<ZT_FurikaeDenpyouRn> getEntityClass() {
        return ZT_FurikaeDenpyouRn.class;
    }

    private String zrntorihikinoc8;

    public String getZrntorihikinoc8() {
        return zrntorihikinoc8;
    }

    public void setZrntorihikinoc8(String pZrntorihikinoc8) {
        zrntorihikinoc8 = pZrntorihikinoc8;
    }
    private String zrntorihikinoedano;

    public String getZrntorihikinoedano() {
        return zrntorihikinoedano;
    }

    public void setZrntorihikinoedano(String pZrntorihikinoedano) {
        zrntorihikinoedano = pZrntorihikinoedano;
    }
    private String zrntorihikiymdgengokbn;

    public String getZrntorihikiymdgengokbn() {
        return zrntorihikiymdgengokbn;
    }

    public void setZrntorihikiymdgengokbn(String pZrntorihikiymdgengokbn) {
        zrntorihikiymdgengokbn = pZrntorihikiymdgengokbn;
    }
    private String zrntorihikinen;

    public String getZrntorihikinen() {
        return zrntorihikinen;
    }

    public void setZrntorihikinen(String pZrntorihikinen) {
        zrntorihikinen = pZrntorihikinen;
    }
    private String zrntorihikituki;

    public String getZrntorihikituki() {
        return zrntorihikituki;
    }

    public void setZrntorihikituki(String pZrntorihikituki) {
        zrntorihikituki = pZrntorihikituki;
    }
    private String zrntorihikibi;

    public String getZrntorihikibi() {
        return zrntorihikibi;
    }

    public void setZrntorihikibi(String pZrntorihikibi) {
        zrntorihikibi = pZrntorihikibi;
    }

}