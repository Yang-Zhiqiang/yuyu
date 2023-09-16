package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.IT_BAK_NyknJissekiRireki;
import yuyu.def.db.mapping.GenIT_BAK_NyknJissekiRireki;
import yuyu.def.db.meta.GenQIT_BAK_NyknJissekiRireki;
import yuyu.def.db.meta.QIT_BAK_NyknJissekiRireki;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 入金実績履歴バックアップテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_NyknJissekiRireki}</td><td colspan="3">入金実績履歴バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getJyutoustartym jyutoustartym}</td><td>充当開始年月</td><td align="center">○</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>jyutouendym</td><td>充当終了年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>rsgaku</td><td>領収金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>rstuukasyu</td><td>領収通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>ryosyukwsratekjymd</td><td>領収為替レート基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>ryosyukwsrate</td><td>領収為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hrkp</td><td>払込保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>iktwaribikikgk</td><td>一括割引料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>nyksyoriymd</td><td>入金処理日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>ryosyuymd</td><td>領収日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nykdenno</td><td>入金伝票番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nykdenymd</td><td>入金伝票日付</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nykkeiro</td><td>入金経路</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Nykkeiro C_Nykkeiro}</td></tr>
 *  <tr><td>hrkkaisuu</td><td>払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>tikiktbrisyuruikbn</td><td>定期一括払種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TkiktbrisyuruiKbn C_TkiktbrisyuruiKbn}</td></tr>
 *  <tr><td>ikkatuyoupkaisuu</td><td>一括要Ｐ回数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>jyutoukaisuuy</td><td>充当回数（年）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>jyutoukaisuum</td><td>充当回数（月）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>nyknaiyoukbn</td><td>入金内容区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NyknaiyouKbn C_NyknaiyouKbn}</td></tr>
 *  <tr><td>iktnyuukinnumu</td><td>一括入金有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>nyktrksflg</td><td>入金取消フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Nyktrksflg C_Nyktrksflg}</td></tr>
 *  <tr><td>nyktrksymd</td><td>入金取消処理日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nyktrksdenno</td><td>入金取消伝票番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nyktrksdenymd</td><td>入金取消伝票日付</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>yenkansannyknkingk</td><td>円換算入金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkansantkykwsrateymd</td><td>円換算適用為替レート基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>yenkansantkykwsrate</td><td>円換算適用為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>henkousikibetukey</td><td>変更識別キー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditkessaiyouno</td><td>クレジットカード決済用番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_NyknJissekiRireki
 * @see     GenIT_BAK_NyknJissekiRireki
 * @see     QIT_BAK_NyknJissekiRireki
 * @see     GenQIT_BAK_NyknJissekiRireki
 */
public class PKIT_BAK_NyknJissekiRireki extends AbstractExDBPrimaryKey<IT_BAK_NyknJissekiRireki, PKIT_BAK_NyknJissekiRireki> {

    private static final long serialVersionUID = 1L;

    public PKIT_BAK_NyknJissekiRireki() {
    }

    public PKIT_BAK_NyknJissekiRireki(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        BizDateYM pJyutoustartym,
        Integer pRenno
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        trkssikibetukey = pTrkssikibetukey;
        jyutoustartym = pJyutoustartym;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<IT_BAK_NyknJissekiRireki> getEntityClass() {
        return IT_BAK_NyknJissekiRireki.class;
    }

    private String kbnkey;

    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
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
    private BizDateYM jyutoustartym;

    @org.hibernate.annotations.Type(type="BizDateYMType")
    public BizDateYM getJyutoustartym() {
        return jyutoustartym;
    }

    public void setJyutoustartym(BizDateYM pJyutoustartym) {
        jyutoustartym = pJyutoustartym;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}