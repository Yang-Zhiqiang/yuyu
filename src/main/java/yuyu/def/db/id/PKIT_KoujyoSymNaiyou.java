package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.def.db.entity.IT_KoujyoSymNaiyou;
import yuyu.def.db.mapping.GenIT_KoujyoSymNaiyou;
import yuyu.def.db.meta.GenQIT_KoujyoSymNaiyou;
import yuyu.def.db.meta.QIT_KoujyoSymNaiyou;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 控除証明内容テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KoujyoSymNaiyou}</td><td colspan="3">控除証明内容テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>koujyosyoumeinnd</td><td>控除証明年度</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoumeistartym</td><td>証明開始年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>syoumeiendym</td><td>証明終了年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>koujyosyoumeipkbn</td><td>控除証明保険料区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KoujyosyoumeipKbn C_KoujyosyoumeipKbn}</td></tr>
 *  <tr><td>tekiyouseidokbn</td><td>適用制度区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TekiyouseidoKbn C_TekiyouseidoKbn}</td></tr>
 *  <tr><td>koujyosymnaiyoureckbn</td><td>控除証明内容レコード区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KoujyosymnaiyourecKbn C_KoujyosymnaiyourecKbn}</td></tr>
 *  <tr><td>koujyosyoumeigk</td><td>控除証明額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>jyutoustartym</td><td>充当開始年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>nyknjskrrkrenno</td><td>入金実績履歴連番</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kihrkpssrrkrenno</td><td>既払込Ｐ精算履歴連番</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kjsmhakkouzumiflg</td><td>控除証明書発行済フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kjsmhakkouzumiflg C_Kjsmhakkouzumiflg}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sakujyoflg</td><td>削除フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Delflag C_Delflag}</td></tr>
 *  <tr><td>zennoukaisiymd</td><td>前納開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>zennourenno</td><td>前納連番</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>keisanhukahyoujikbn</td><td>計算不可表示区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DispKbn C_DispKbn}</td></tr>
 *  <tr><td>keisanhukariyuucd</td><td>計算不可理由コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KoujyoSymNaiyou
 * @see     GenIT_KoujyoSymNaiyou
 * @see     QIT_KoujyoSymNaiyou
 * @see     GenQIT_KoujyoSymNaiyou
 */
public class PKIT_KoujyoSymNaiyou extends AbstractExDBPrimaryKey<IT_KoujyoSymNaiyou, PKIT_KoujyoSymNaiyou> {

    private static final long serialVersionUID = 1L;

    public PKIT_KoujyoSymNaiyou() {
    }

    public PKIT_KoujyoSymNaiyou(
        String pKbnkey,
        String pSyono,
        String pSyouhncd,
        Integer pRenno3keta
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        syouhncd = pSyouhncd;
        renno3keta = pRenno3keta;
    }

    @Transient
    @Override
    public Class<IT_KoujyoSymNaiyou> getEntityClass() {
        return IT_KoujyoSymNaiyou.class;
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
    private String syouhncd;

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }
    private Integer renno3keta;

    public Integer getRenno3keta() {
        return renno3keta;
    }

    public void setRenno3keta(Integer pRenno3keta) {
        renno3keta = pRenno3keta;
    }

}