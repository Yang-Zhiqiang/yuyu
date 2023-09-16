package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.db.entity.HT_NayoseKekka;
import yuyu.def.db.mapping.GenHT_NayoseKekka;
import yuyu.def.db.meta.GenQHT_NayoseKekka;
import yuyu.def.db.meta.QHT_NayoseKekka;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 名寄せ結果テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_NayoseKekka}</td><td colspan="3">名寄せ結果テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSntkinfotaisyousyakbn sntkinfotaisyousyakbn}</td><td>選択情報対象者区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_SntkInfoTaisyousyaKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getEdano edano}</td><td>枝番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>sakuinnmno</td><td>索引名番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nysjissikekkakbn</td><td>名寄せ実施結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NayoseJissiKekkaKbn C_NayoseJissiKekkaKbn}</td></tr>
 *  <tr><td>nysjyoutaikbn</td><td>名寄せ状態区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NayoseJyoutaiKbn C_NayoseJyoutaiKbn}</td></tr>
 *  <tr><td>sakuininfosyoukaierrkbn</td><td>索引情報照会エラー区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MQSyoukaiErrorKbn C_MQSyoukaiErrorKbn}</td></tr>
 *  <tr><td>mrsyoukaierrkbn</td><td>ＭＲ照会エラー区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MQSyoukaiErrorKbn C_MQSyoukaiErrorKbn}</td></tr>
 *  <tr><td>signalsyoukaierrkbn</td><td>シグナル照会エラー区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MQSyoukaiErrorKbn C_MQSyoukaiErrorKbn}</td></tr>
 *  <tr><td>sinsntkhnsysyoukaierrkbn</td><td>新選択情報反社照会エラー区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MQSyoukaiErrorKbn C_MQSyoukaiErrorKbn}</td></tr>
 *  <tr><td>tsngksyoukaierrkbn</td><td>通算金額照会エラー区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MQSyoukaiErrorKbn C_MQSyoukaiErrorKbn}</td></tr>
 *  <tr><td>kykdrtentsnssyoukaierrkbn</td><td>契約者同一代理店通算Ｓ照会エラー区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MQSyoukaiErrorKbn C_MQSyoukaiErrorKbn}</td></tr>
 *  <tr><td>mossakuseikahisyoukaierrkbn</td><td>申込書作成可否照会エラー区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MQSyoukaiErrorKbn C_MQSyoukaiErrorKbn}</td></tr>
 *  <tr><td>hndketyhsyoukaierrkbn</td><td>ハンド決定要否照会エラー区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MQSyoukaiErrorKbn C_MQSyoukaiErrorKbn}</td></tr>
 *  <tr><td>sntkinfomrumukbn</td><td>選択情報ＭＲ有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BlnktkumuKbn C_BlnktkumuKbn}</td></tr>
 *  <tr><td>sntkinfohnsyumukbn</td><td>選択情報反社有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BlnktkumuKbn C_BlnktkumuKbn}</td></tr>
 *  <tr><td>signalsetteiumukbn</td><td>シグナル設定有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BlnktkumuKbn C_BlnktkumuKbn}</td></tr>
 *  <tr><td>signalinfohnsyumukbn</td><td>シグナル情報反社有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BlnktkumuKbn C_BlnktkumuKbn}</td></tr>
 *  <tr><td>gaikokupepsumukbn</td><td>外国ＰＥＰｓ有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BlnktkumuKbn C_BlnktkumuKbn}</td></tr>
 *  <tr><td>sinsntkhnsyumukbn</td><td>新選択情報反社有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BlnktkumuKbn C_BlnktkumuKbn}</td></tr>
 *  <tr><td>itekisntkhndktyhkbn</td><td>医的選択情報ハンド決定要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YouhiblnkKbn C_YouhiblnkKbn}</td></tr>
 *  <tr><td>ttdktyuuiknkhndktyhkbn</td><td>手続注意環境ハンド決定要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YouhiblnkKbn C_YouhiblnkKbn}</td></tr>
 *  <tr><td>kyhkinuktkariitkhndktyhkbn</td><td>給付金受付有医的ハンド決定要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YouhiblnkKbn C_YouhiblnkKbn}</td></tr>
 *  <tr><td>doujimositekihndktyhkbn</td><td>同時申込医的ハンド決定要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YouhiblnkKbn C_YouhiblnkKbn}</td></tr>
 *  <tr><td>doujimosknkhndktyhkbn</td><td>同時申込環境ハンド決定要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YouhiblnkKbn C_YouhiblnkKbn}</td></tr>
 *  <tr><td>sirajikykkbn</td><td>白地契約区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SirajiKykKbn C_SirajiKykKbn}</td></tr>
 *  <tr><td>kikykinfoseiymd</td><td>既契約情報生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_NayoseKekka
 * @see     GenHT_NayoseKekka
 * @see     QHT_NayoseKekka
 * @see     GenQHT_NayoseKekka
 */
public class PKHT_NayoseKekka extends AbstractExDBPrimaryKey<HT_NayoseKekka, PKHT_NayoseKekka> {

    private static final long serialVersionUID = 1L;

    public PKHT_NayoseKekka() {
    }

    public PKHT_NayoseKekka(
        String pMosno,
        C_SntkInfoTaisyousyaKbn pSntkinfotaisyousyakbn,
        Integer pEdano
    ) {
        mosno = pMosno;
        sntkinfotaisyousyakbn = pSntkinfotaisyousyakbn;
        edano = pEdano;
    }

    @Transient
    @Override
    public Class<HT_NayoseKekka> getEntityClass() {
        return HT_NayoseKekka.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }
    private C_SntkInfoTaisyousyaKbn sntkinfotaisyousyakbn;

    @org.hibernate.annotations.Type(type="UserType_C_SntkInfoTaisyousyaKbn")
    public C_SntkInfoTaisyousyaKbn getSntkinfotaisyousyakbn() {
        return sntkinfotaisyousyakbn;
    }

    public void setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn pSntkinfotaisyousyakbn) {
        sntkinfotaisyousyakbn = pSntkinfotaisyousyakbn;
    }
    private Integer edano;

    public Integer getEdano() {
        return edano;
    }

    public void setEdano(Integer pEdano) {
        edano = pEdano;
    }

}