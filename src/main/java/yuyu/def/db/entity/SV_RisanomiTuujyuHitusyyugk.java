package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.mapping.GenSV_RisanomiTuujyuHitusyyugk;
import yuyu.def.classification.C_SyutkKbn;

/**
 * 利差のみ通常配当所要額情報ビュー エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenSV_RisanomiTuujyuHitusyyugk} の JavaDoc を参照してください。<br />
 * @see     GenSV_RisanomiTuujyuHitusyyugk<br />
 * @see     PKSV_RisanomiTuujyuHitusyyugk<br />
 * @see     QSV_RisanomiTuujyuHitusyyugk<br />
 * @see     GenQSV_RisanomiTuujyuHitusyyugk<br />
 */
@Entity
public class SV_RisanomiTuujyuHitusyyugk extends GenSV_RisanomiTuujyuHitusyyugk {

    private static final long serialVersionUID = 1L;

    public SV_RisanomiTuujyuHitusyyugk() {
    }

    public SV_RisanomiTuujyuHitusyyugk(String pSyono,C_SyutkKbn pSyutkkbn,String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno) {
        super(pSyono,pSyutkkbn,pSyouhncd,pSyouhnsdno,pKyksyouhnrenno);
    }

}
