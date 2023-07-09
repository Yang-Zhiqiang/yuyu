CREATE VIEW ZT_GentumiSkMikomirituULFTy AS SELECT
     ztyraysystemhyj ,         /* （中継用）ＲＡＹシステム表示 */
     ztydatakanrino ,         /* （中継用）データ管理番号 */
     ztykhsyoumetujiyuu ,         /* （中継用）（契約保全）消滅事由 */
     ztysymtymd ,         /* （中継用）消滅年月日 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ZT_GentumiSkMikomirituULFTy_Z;