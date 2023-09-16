package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.mapping.GenSV_TuujyuHitusyyugk;
import yuyu.def.classification.C_SyutkKbn;

/**
 * 通常配当所要額情報ビュー エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenSV_TuujyuHitusyyugk} の JavaDoc を参照してください。<br />
 * @see     GenSV_TuujyuHitusyyugk<br />
 * @see     PKSV_TuujyuHitusyyugk<br />
 * @see     QSV_TuujyuHitusyyugk<br />
 * @see     GenQSV_TuujyuHitusyyugk<br />
 */
@Entity
public class SV_TuujyuHitusyyugk extends GenSV_TuujyuHitusyyugk {

    private static final long serialVersionUID = 1L;

    public SV_TuujyuHitusyyugk() {
    }

    public SV_TuujyuHitusyyugk(String pSyono,C_SyutkKbn pSyutkkbn,String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno) {
        super(pSyono,pSyutkkbn,pSyouhncd,pSyouhnsdno,pKyksyouhnrenno);
    }

}
