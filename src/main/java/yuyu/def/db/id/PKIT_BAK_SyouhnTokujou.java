package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_BAK_SyouhnTokujou;
import yuyu.def.db.mapping.GenIT_BAK_SyouhnTokujou;
import yuyu.def.db.meta.GenQIT_BAK_SyouhnTokujou;
import yuyu.def.db.meta.QIT_BAK_SyouhnTokujou;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 商品特条バックアップテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_SyouhnTokujou}</td><td colspan="3">商品特条バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyutkkbn syutkkbn}</td><td>主契約特約区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKyksyouhnrenno kyksyouhnrenno}</td><td>契約商品連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>henkousikibetukey</td><td>変更識別キー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tkjyhyouten</td><td>特条標点</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tkjyhyouten C_Tkjyhyouten}</td></tr>
 *  <tr><td>tkjyp</td><td>特条保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tkjyskgnkkn</td><td>特条削減期間</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tkjyskgnkkn C_Tkjyskgnkkn}</td></tr>
 *  <tr><td>htnpbuicd1</td><td>不担保部位コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>htnpkkn1</td><td>不担保期間１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Htnpkkn C_Htnpkkn}</td></tr>
 *  <tr><td>htnpbuicd2</td><td>不担保部位コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>htnpkkn2</td><td>不担保期間２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Htnpkkn C_Htnpkkn}</td></tr>
 *  <tr><td>htnpbuicd3</td><td>不担保部位コード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>htnpkkn3</td><td>不担保期間３</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Htnpkkn C_Htnpkkn}</td></tr>
 *  <tr><td>htnpbuicd4</td><td>不担保部位コード４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>htnpkkn4</td><td>不担保期間４</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Htnpkkn C_Htnpkkn}</td></tr>
 *  <tr><td>tokkoudosghtnpkbn</td><td>特定高度障害不担保区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TokkoudosghtnpKbn C_TokkoudosghtnpKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_SyouhnTokujou
 * @see     GenIT_BAK_SyouhnTokujou
 * @see     QIT_BAK_SyouhnTokujou
 * @see     GenQIT_BAK_SyouhnTokujou
 */
public class PKIT_BAK_SyouhnTokujou extends AbstractExDBPrimaryKey<IT_BAK_SyouhnTokujou, PKIT_BAK_SyouhnTokujou> {

    private static final long serialVersionUID = 1L;

    public PKIT_BAK_SyouhnTokujou() {
    }

    public PKIT_BAK_SyouhnTokujou(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        C_SyutkKbn pSyutkkbn,
        String pSyouhncd,
        Integer pSyouhnsdno,
        Integer pKyksyouhnrenno
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        trkssikibetukey = pTrkssikibetukey;
        syutkkbn = pSyutkkbn;
        syouhncd = pSyouhncd;
        syouhnsdno = pSyouhnsdno;
        kyksyouhnrenno = pKyksyouhnrenno;
    }

    @Transient
    @Override
    public Class<IT_BAK_SyouhnTokujou> getEntityClass() {
        return IT_BAK_SyouhnTokujou.class;
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
    private C_SyutkKbn syutkkbn;

    @org.hibernate.annotations.Type(type="UserType_C_SyutkKbn")
    public C_SyutkKbn getSyutkkbn() {
        return syutkkbn;
    }

    public void setSyutkkbn(C_SyutkKbn pSyutkkbn) {
        syutkkbn = pSyutkkbn;
    }
    private String syouhncd;

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }
    private Integer syouhnsdno;

    public Integer getSyouhnsdno() {
        return syouhnsdno;
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        syouhnsdno = pSyouhnsdno;
    }
    private Integer kyksyouhnrenno;

    public Integer getKyksyouhnrenno() {
        return kyksyouhnrenno;
    }

    public void setKyksyouhnrenno(Integer pKyksyouhnrenno) {
        kyksyouhnrenno = pKyksyouhnrenno;
    }

}