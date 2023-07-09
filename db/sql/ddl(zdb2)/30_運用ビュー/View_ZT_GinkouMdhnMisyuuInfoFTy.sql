CREATE VIEW ZT_GinkouMdhnMisyuuInfoFTy AS SELECT
     ztybsydrtencd ,         /* （中継用）募集代理店コード */
     ztyyobiv63 ,         /* （中継用）予備項目Ｖ６３ */
     ztydatakbn ,         /* （中継用）データ区分 */
     ztydatasakuseiymd ,         /* （中継用）データ作成日 */
     ztyhknkaisyacd ,         /* （中継用）保険会社コード */
     ztyhknsyuruicd ,         /* （中継用）保険種類コード */
     ztysyonosyuban ,         /* （中継用）証券番号主番 */
     ztysyonoedaban ,         /* （中継用）証券番号枝番 */
     ztymisyuutatekaekbn ,         /* （中継用）未収立替区分 */
     ztymisyuutatekaeym ,         /* （中継用）未収立替発生年月 */
     ztymisyuukg ,         /* （中継用）未収金額 */
     ztybnkaisuu ,         /* （中継用）分割回数 */
     ztymisyuujiyuu ,         /* （中継用）未収事由 */
     ztyjikaidatakousinymd ,         /* （中継用）次回データ更新日 */
     ztyikkatubaraikbn ,         /* （中継用）一括払区分 */
     ztyikkatubaraikaisuu ,         /* （中継用）一括払回数 */
     ztyyobiv28 ,         /* （中継用）予備項目Ｖ２８ */
     ztykosyaareav40 ,         /* （中継用）個社領域Ｖ４０ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ZT_GinkouMdhnMisyuuInfoFTy_Z;