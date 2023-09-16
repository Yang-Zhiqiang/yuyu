package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_BosKoumokuCheckError;
import yuyu.def.db.mapping.GenHT_BosKoumokuCheckError;
import yuyu.def.db.meta.GenQHT_BosKoumokuCheckError;
import yuyu.def.db.meta.QHT_BosKoumokuCheckError;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 募集項目チェックエラーテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_BosKoumokuCheckError}</td><td colspan="3">募集項目チェックエラーテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>errorkm</td><td>エラー項目</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_BosKoumokuCheckError
 * @see     GenHT_BosKoumokuCheckError
 * @see     QHT_BosKoumokuCheckError
 * @see     GenQHT_BosKoumokuCheckError
 */
public class PKHT_BosKoumokuCheckError extends AbstractExDBPrimaryKey<HT_BosKoumokuCheckError, PKHT_BosKoumokuCheckError> {

    private static final long serialVersionUID = 1L;

    public PKHT_BosKoumokuCheckError() {
    }

    public PKHT_BosKoumokuCheckError(String pMosno, Integer pRenno3keta) {
        mosno = pMosno;
        renno3keta = pRenno3keta;
    }

    @Transient
    @Override
    public Class<HT_BosKoumokuCheckError> getEntityClass() {
        return HT_BosKoumokuCheckError.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }
    private Integer renno3keta;

    public Integer getRenno3keta() {
        return renno3keta;
    }

    public void setRenno3keta(Integer pRenno3keta) {
        renno3keta = pRenno3keta;
    }

}