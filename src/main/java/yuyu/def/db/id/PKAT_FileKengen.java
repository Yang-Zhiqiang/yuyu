package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.db.entity.AT_FileKengen;
import yuyu.def.db.mapping.GenAT_FileKengen;
import yuyu.def.db.meta.GenQAT_FileKengen;
import yuyu.def.db.meta.QAT_FileKengen;

/**
 * ファイル権限テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_FileKengen}</td><td colspan="3">ファイル権限テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getRoleCd roleCd}</td><td>ロールコード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getFileSyuruiCd fileSyuruiCd}</td><td>ファイル種類コード</td><td align="center">○</td><td align="center">V</td><td>{@link C_FileSyuruiCdKbn}</td></tr>
 * </table>
 * @see     AT_FileKengen
 * @see     GenAT_FileKengen
 * @see     QAT_FileKengen
 * @see     GenQAT_FileKengen
 */
public class PKAT_FileKengen extends AbstractExDBPrimaryKey<AT_FileKengen, PKAT_FileKengen> {

    private static final long serialVersionUID = 1L;

    public PKAT_FileKengen() {
    }

    public PKAT_FileKengen(String pRoleCd, C_FileSyuruiCdKbn pFileSyuruiCd) {
        roleCd = pRoleCd;
        fileSyuruiCd = pFileSyuruiCd;
    }

    @Transient
    @Override
    public Class<AT_FileKengen> getEntityClass() {
        return AT_FileKengen.class;
    }

    private String roleCd;

    public String getRoleCd() {
        return roleCd;
    }

    public void setRoleCd(String pRoleCd) {
        roleCd = pRoleCd;
    }
    private C_FileSyuruiCdKbn fileSyuruiCd;

    @org.hibernate.annotations.Type(type="UserType_C_FileSyuruiCdKbn")
    public C_FileSyuruiCdKbn getFileSyuruiCd() {
        return fileSyuruiCd;
    }

    public void setFileSyuruiCd(C_FileSyuruiCdKbn pFileSyuruiCd) {
        fileSyuruiCd = pFileSyuruiCd;
    }

}