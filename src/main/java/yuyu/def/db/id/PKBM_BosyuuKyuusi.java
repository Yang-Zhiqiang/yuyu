package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.db.entity.BM_BosyuuKyuusi;
import yuyu.def.db.mapping.GenBM_BosyuuKyuusi;
import yuyu.def.db.meta.GenQBM_BosyuuKyuusi;
import yuyu.def.db.meta.QBM_BosyuuKyuusi;

/**
 * 募集休止マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_BosyuuKyuusi}</td><td colspan="3">募集休止マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSksyskbn sksyskbn}</td><td>新契約システム区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_SysKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getYoteiriritutkybr1 yoteiriritutkybr1}</td><td>予定利率適用分類１</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getYoteiriritutkybr2 yoteiriritutkybr2}</td><td>予定利率適用分類２</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkeijimukbn skeijimukbn}</td><td>新契約事務区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_SkeijimuKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHanteiyuusendo hanteiyuusendo}</td><td>判定優先度</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>boskyuusikijyunymdkbn</td><td>募集休止基準日区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BoskyuusiKijyunymdKbn C_BoskyuusiKijyunymdKbn}</td></tr>
 *  <tr><td>kyuusiymdfrom</td><td>休止年月日（自）</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kyuusiymdto</td><td>休止年月日（至）</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>boskyuusiriyuukbn</td><td>募集休止理由区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BoskyuusiRiyuuKbn C_BoskyuusiRiyuuKbn}</td></tr>
 *  <tr><td>hubisyubetukbn</td><td>不備種別区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HubisyubetuKbn C_HubisyubetuKbn}</td></tr>
 *  <tr><td>tokuninkahikbn</td><td>特認可否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KahiKbn C_KahiKbn}</td></tr>
 *  <tr><td>hubimsg</td><td>不備メッセージ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>seihowebmessage1</td><td>生保Ｗｅｂメッセージ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>seihowebmessage2</td><td>生保Ｗｅｂメッセージ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_BosyuuKyuusi
 * @see     GenBM_BosyuuKyuusi
 * @see     QBM_BosyuuKyuusi
 * @see     GenQBM_BosyuuKyuusi
 */
public class PKBM_BosyuuKyuusi extends AbstractExDBPrimaryKey<BM_BosyuuKyuusi, PKBM_BosyuuKyuusi> {

    private static final long serialVersionUID = 1L;

    public PKBM_BosyuuKyuusi() {
    }

    public PKBM_BosyuuKyuusi(
        C_SysKbn pSksyskbn,
        String pSyouhncd,
        String pYoteiriritutkybr1,
        String pYoteiriritutkybr2,
        C_SkeijimuKbn pSkeijimukbn,
        Integer pHanteiyuusendo
    ) {
        sksyskbn = pSksyskbn;
        syouhncd = pSyouhncd;
        yoteiriritutkybr1 = pYoteiriritutkybr1;
        yoteiriritutkybr2 = pYoteiriritutkybr2;
        skeijimukbn = pSkeijimukbn;
        hanteiyuusendo = pHanteiyuusendo;
    }

    @Transient
    @Override
    public Class<BM_BosyuuKyuusi> getEntityClass() {
        return BM_BosyuuKyuusi.class;
    }

    private C_SysKbn sksyskbn;

    @org.hibernate.annotations.Type(type="UserType_C_SysKbn")
    public C_SysKbn getSksyskbn() {
        return sksyskbn;
    }

    public void setSksyskbn(C_SysKbn pSksyskbn) {
        sksyskbn = pSksyskbn;
    }
    private String syouhncd;

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }
    private String yoteiriritutkybr1;

    public String getYoteiriritutkybr1() {
        return yoteiriritutkybr1;
    }

    public void setYoteiriritutkybr1(String pYoteiriritutkybr1) {
        yoteiriritutkybr1 = pYoteiriritutkybr1;
    }
    private String yoteiriritutkybr2;

    public String getYoteiriritutkybr2() {
        return yoteiriritutkybr2;
    }

    public void setYoteiriritutkybr2(String pYoteiriritutkybr2) {
        yoteiriritutkybr2 = pYoteiriritutkybr2;
    }
    private C_SkeijimuKbn skeijimukbn;

    @org.hibernate.annotations.Type(type="UserType_C_SkeijimuKbn")
    public C_SkeijimuKbn getSkeijimukbn() {
        return skeijimukbn;
    }

    public void setSkeijimukbn(C_SkeijimuKbn pSkeijimukbn) {
        skeijimukbn = pSkeijimukbn;
    }
    private Integer hanteiyuusendo;

    public Integer getHanteiyuusendo() {
        return hanteiyuusendo;
    }

    public void setHanteiyuusendo(Integer pHanteiyuusendo) {
        hanteiyuusendo = pHanteiyuusendo;
    }

}