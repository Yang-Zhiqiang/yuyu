package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.def.db.entity.IT_KoujyoSymNaiyouD;
import yuyu.def.db.mapping.GenIT_KoujyoSymNaiyouD;
import yuyu.def.db.meta.GenQIT_KoujyoSymNaiyouD;
import yuyu.def.db.meta.QIT_KoujyoSymNaiyouD;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 控除証明内容Ｄテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KoujyoSymNaiyouD}</td><td colspan="3">控除証明内容Ｄテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>koujyosyoumeinnd</td><td>控除証明年度</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>koujyosyoumeid</td><td>控除証明Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>haitounendo</td><td>配当年度</td><td>&nbsp;</td><td align="center">V</td><td>BizDateY</td></tr>
 *  <tr><td>haitoukanrirenno</td><td>配当管理連番</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>haitoukinskskbn</td><td>配当金作成区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HaitoukinsksKbn C_HaitoukinsksKbn}</td></tr>
 *  <tr><td>haitoumeisaikbn</td><td>配当明細区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HaitoumeisaiKbn C_HaitoumeisaiKbn}</td></tr>
 *  <tr><td>kjsmhakkouzumiflg</td><td>控除証明書発行済フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kjsmhakkouzumiflg C_Kjsmhakkouzumiflg}</td></tr>
 *  <tr><td>sakujyoflg</td><td>削除フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Delflag C_Delflag}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KoujyoSymNaiyouD
 * @see     GenIT_KoujyoSymNaiyouD
 * @see     QIT_KoujyoSymNaiyouD
 * @see     GenQIT_KoujyoSymNaiyouD
 */
public class PKIT_KoujyoSymNaiyouD extends AbstractExDBPrimaryKey<IT_KoujyoSymNaiyouD, PKIT_KoujyoSymNaiyouD> {

    private static final long serialVersionUID = 1L;

    public PKIT_KoujyoSymNaiyouD() {
    }

    public PKIT_KoujyoSymNaiyouD(
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
    public Class<IT_KoujyoSymNaiyouD> getEntityClass() {
        return IT_KoujyoSymNaiyouD.class;
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