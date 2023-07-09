CREATE TABLE ZT_GentumiSkMikomirituULFRn_Z (
     zrnraysystemhyj                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ＲＡＹシステム表示 */
     zrndatakanrino                                     CHAR        (11)                                                      NOT NULL  ,  /* （連携用）データ管理番号 */
     zrnkhsyoumetujiyuu                                 CHAR        (2)                                                       NOT NULL  ,  /* （連携用）（契約保全）消滅事由 */
     zrnsymtymd                                         CHAR        (8)                                                       NOT NULL     /* （連携用）消滅年月日 */
)
;

ALTER TABLE ZT_GentumiSkMikomirituULFRn_Z ADD CONSTRAINT PK_GentumiSkMikomirituULFRn PRIMARY KEY (
     zrndatakanrino                                             /* （連携用）データ管理番号 */
) ;
