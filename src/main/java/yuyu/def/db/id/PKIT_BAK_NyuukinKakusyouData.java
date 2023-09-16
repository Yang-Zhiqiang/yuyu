package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_BAK_NyuukinKakusyouData;
import yuyu.def.db.mapping.GenIT_BAK_NyuukinKakusyouData;
import yuyu.def.db.meta.GenQIT_BAK_NyuukinKakusyouData;
import yuyu.def.db.meta.QIT_BAK_NyuukinKakusyouData;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 入金確証データバックアップテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_NyuukinKakusyouData}</td><td colspan="3">入金確証データバックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getNyuukinkakusyouno nyuukinkakusyouno}</td><td>入金確証番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nyksyoriymd</td><td>入金処理日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nyuukinkakusyounrkymd</td><td>入金確証入力年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nykkeiro</td><td>入金経路</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Nykkeiro C_Nykkeiro}</td></tr>
 *  <tr><td>hrkkaisuu</td><td>払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>nyknaiyoukbn</td><td>入金内容区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NyknaiyouKbn C_NyknaiyouKbn}</td></tr>
 *  <tr><td>iktnyuukinnumu</td><td>一括入金有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>jyuutouym</td><td>充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>jyutoukaisuuy</td><td>充当回数（年）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>jyutoukaisuum</td><td>充当回数（月）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>rsgaku</td><td>領収金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>ryosyuymd</td><td>領収日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>denrenno</td><td>伝票データ連番</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>edano</td><td>枝番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>suitoubumoncd</td><td>出納部門コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>henkousikibetukey</td><td>変更識別キー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nykhouhoukbn</td><td>入金方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NykhouhouKbn C_NykhouhouKbn}</td></tr>
 *  <tr><td>tikiktbrisyuruikbn</td><td>定期一括払種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TkiktbrisyuruiKbn C_TkiktbrisyuruiKbn}</td></tr>
 *  <tr><td>nykdenymd</td><td>入金伝票日付</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>tabakarikanjyono</td><td>束仮勘定番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nyuukinkakusyounrkno</td><td>入金確証入力番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nyuuryokukbn</td><td>入力区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NyuuryokuKbn C_NyuuryokuKbn}</td></tr>
 *  <tr><td>suitono</td><td>出納番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmyousinkkbn</td><td>振込用紙入金区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KrkPayEasyHrkmyousiNkKbn C_KrkPayEasyHrkmyousiNkKbn}</td></tr>
 *  <tr><td>suitososhikicd</td><td>出納組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzhurikaebankcd</td><td>口座振替銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzhurikaesitencd</td><td>口座振替支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>uketuketencd</td><td>受付店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>cvscd</td><td>ＣＶＳコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ryousyuuhm</td><td>領収時分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hurikomiyousiokyksmno</td><td>振込用紙お客さま番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hurikomiyousikakuninno</td><td>振込用紙確認番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kinyuukikankbn</td><td>金融機関区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditkessaiyouno</td><td>クレジットカード決済用番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syuudaikocd</td><td>収納代行社コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Syuudaikocd C_Syuudaikocd}</td></tr>
 *  <tr><td>credituriageseikyuukbn</td><td>クレジットカード売上請求区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_CreditUriageSeikyuuKbn C_CreditUriageSeikyuuKbn}</td></tr>
 * </table>
 * @see     IT_BAK_NyuukinKakusyouData
 * @see     GenIT_BAK_NyuukinKakusyouData
 * @see     QIT_BAK_NyuukinKakusyouData
 * @see     GenQIT_BAK_NyuukinKakusyouData
 */
public class PKIT_BAK_NyuukinKakusyouData extends AbstractExDBPrimaryKey<IT_BAK_NyuukinKakusyouData, PKIT_BAK_NyuukinKakusyouData> {

    private static final long serialVersionUID = 1L;

    public PKIT_BAK_NyuukinKakusyouData() {
    }

    public PKIT_BAK_NyuukinKakusyouData(
        String pKbnkey,
        String pNyuukinkakusyouno,
        String pSyono,
        String pTrkssikibetukey
    ) {
        kbnkey = pKbnkey;
        nyuukinkakusyouno = pNyuukinkakusyouno;
        syono = pSyono;
        trkssikibetukey = pTrkssikibetukey;
    }

    @Transient
    @Override
    public Class<IT_BAK_NyuukinKakusyouData> getEntityClass() {
        return IT_BAK_NyuukinKakusyouData.class;
    }

    private String kbnkey;

    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
    }
    private String nyuukinkakusyouno;

    public String getNyuukinkakusyouno() {
        return nyuukinkakusyouno;
    }

    public void setNyuukinkakusyouno(String pNyuukinkakusyouno) {
        nyuukinkakusyouno = pNyuukinkakusyouno;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private String trkssikibetukey;

    public String getTrkssikibetukey() {
        return trkssikibetukey;
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        trkssikibetukey = pTrkssikibetukey;
    }

}