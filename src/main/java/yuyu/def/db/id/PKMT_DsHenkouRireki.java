package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.MT_DsHenkouRireki;
import yuyu.def.db.mapping.GenMT_DsHenkouRireki;
import yuyu.def.db.meta.GenQMT_DsHenkouRireki;
import yuyu.def.db.meta.QMT_DsHenkouRireki;

/**
 * ＤＳ変更履歴テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsHenkouRireki}</td><td colspan="3">ＤＳ変更履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>tablenm</td><td>テーブル名称</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tableid</td><td>テーブルＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hnksyuruikbn</td><td>変更種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HnkSyuruiKbn C_HnkSyuruiKbn}</td></tr>
 *  <tr><td>hanbetukoumokunm</td><td>判別項目名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>henkoukoumokuid</td><td>変更項目ID</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>henkoukoumokunm</td><td>変更項目名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bfrnaiyouoriginal</td><td>変更前内容原本</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bfrnaiyou</td><td>変更前内容</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>newnaiyouoriginal</td><td>変更後内容原本</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>newnaiyou</td><td>変更後内容</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsHenkouRireki
 * @see     GenMT_DsHenkouRireki
 * @see     QMT_DsHenkouRireki
 * @see     GenQMT_DsHenkouRireki
 */
public class PKMT_DsHenkouRireki extends AbstractExDBPrimaryKey<MT_DsHenkouRireki, PKMT_DsHenkouRireki> {

    private static final long serialVersionUID = 1L;

    public PKMT_DsHenkouRireki() {
    }

    public PKMT_DsHenkouRireki(
        String pDskokno,
        String pHenkousikibetukey,
        Integer pRenno
    ) {
        dskokno = pDskokno;
        henkousikibetukey = pHenkousikibetukey;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<MT_DsHenkouRireki> getEntityClass() {
        return MT_DsHenkouRireki.class;
    }

    private String dskokno;

    public String getDskokno() {
        return dskokno;
    }

    public void setDskokno(String pDskokno) {
        dskokno = pDskokno;
    }
    private String henkousikibetukey;

    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}