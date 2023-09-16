package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.mapping.GenJT_SiDetail;


/**
 * 支払明細テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SiDetail} の JavaDoc を参照してください。<br />
 * @see     GenJT_SiDetail<br />
 * @see     PKJT_SiDetail<br />
 * @see     QJT_SiDetail<br />
 * @see     GenQJT_SiDetail<br />
 */
@Entity
public class JT_SiDetail extends GenJT_SiDetail {

    private static final long serialVersionUID = 1L;

    public JT_SiDetail() {
    }

    public JT_SiDetail(String pSkno,String pSyono,Integer pSeikyuurirekino,Integer pUketukeno,C_SyutkKbn pSyutkkbn,String pSyouhncd,C_KyhgndkataKbn pKyhgndkatakbn,Integer pSyouhnsdno,Integer pKyksyouhnrenno,String pKyuuhucd,Integer pRenno) {
        super(pSkno,pSyono,pSeikyuurirekino,pUketukeno,pSyutkkbn,pSyouhncd,pKyhgndkatakbn,pSyouhnsdno,pKyksyouhnrenno,pKyuuhucd,pRenno);
    }



    private JT_SkJiyuu jT_SkJiyuu ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JT_SiDetail.SKNO  , referencedColumnName=JT_SkJiyuu.SKNO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SiDetail.SYONO  , referencedColumnName=JT_SkJiyuu.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SiDetail.SEIKYUURIREKINO  , referencedColumnName=JT_SkJiyuu.SEIKYUURIREKINO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SiDetail.UKETUKENO  , referencedColumnName=JT_SkJiyuu.UKETUKENO, insertable=false, updatable=false)
    })
    public JT_SkJiyuu getSkJiyuu() {
        return jT_SkJiyuu;
    }

    public void setSkJiyuu(JT_SkJiyuu pJT_SkJiyuu) {
        this.jT_SkJiyuu = pJT_SkJiyuu;
    }

}

