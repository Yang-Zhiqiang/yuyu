CREATE TABLE ZT_GentumiSkMikomirituULFTy (
     ztyraysystemhyj                                    VARCHAR     (1)                                                                 ,  /* （中継用）ＲＡＹシステム表示 */
     ztydatakanrino                                     VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）データ管理番号 */
     ztykhsyoumetujiyuu                                 VARCHAR     (2)                                                                 ,  /* （中継用）（契約保全）消滅事由 */
     ztysymtymd                                         VARCHAR     (8)                                                                 ,  /* （中継用）消滅年月日 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_GentumiSkMikomirituULFTy ADD CONSTRAINT PK_GentumiSkMikomirituULFTy PRIMARY KEY (
     ztydatakanrino                                             /* （中継用）データ管理番号 */
) ;
