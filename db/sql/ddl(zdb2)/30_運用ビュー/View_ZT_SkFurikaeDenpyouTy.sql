CREATE VIEW ZT_SkFurikaeDenpyouTy AS SELECT
     ztykytkmksyoruicd ,         /* （中継用）共通項目書類コード */
     ztykytkmktyouhyousksymd ,         /* （中継用）共通項目帳票作成年月日 */
     ztykytkmksystemkbn ,         /* （中継用）共通項目システム区分 */
     ztykytkmktorihikino ,         /* （中継用）共通項目取引番号 */
     ztykytkmktorihikinoedano ,         /* （中継用）共通項目取引番号枝番号 */
     ztykytkmkseifukukbn ,         /* （中継用）共通項目正副区分 */
     ztykytkmkfuridenhassoukbn ,         /* （中継用）共通項目振替伝票用発送区分 */
     ztykytkmkyobi ,         /* （中継用）共通項目予備項目 */
     ztysystemkbn ,         /* （中継用）システム区分 */
     ztytorihikinoc8 ,         /* （中継用）取引番号Ｃ８ */
     ztytorihikinoedano ,         /* （中継用）取引番号枝番号 */
     ztykjhikaeinjikm ,         /* （中継用）漢字控印字項目 */
     ztytorihikiymdgengokbn ,         /* （中継用）取引年月日元号区分 */
     ztytorihikinen ,         /* （中継用）取引年 */
     ztytorihikituki ,         /* （中継用）取引月 */
     ztytorihikibi ,         /* （中継用）取引日 */
     ztykanjyoukbn ,         /* （中継用）勘定区分 */
     ztykanjyoukbnnm ,         /* （中継用）勘定区分名 */
     ztykjtantoukanm ,         /* （中継用）漢字担当課名 */
     ztykjtantoucd ,         /* （中継用）漢字担当コード */
     ztykjsystemnm ,         /* （中継用）漢字システム名 */
     ztykarikurikosikingaku ,         /* （中継用）借方繰越金額 */
     ztykasikurikosikingaku ,         /* （中継用）貸方繰越金額 */
     ztydenpyoukbnnm ,         /* （中継用）伝票区分名 */
     ztykjkarikurikosigkhyjkm ,         /* （中継用）漢字借方繰越合計表示項目 */
     ztykarikurikosigkkingaku ,         /* （中継用）借方繰越合計金額 */
     ztykjkasikurikosigkhyjkm ,         /* （中継用）漢字貸方繰越合計表示項目 */
     ztykasikurikosigkkingaku ,         /* （中継用）貸方繰越合計金額 */
     ztykjtekiyou1 ,         /* （中継用）漢字摘要１ */
     ztykjtekiyou2 ,         /* （中継用）漢字摘要２ */
     ztykjtekiyou3 ,         /* （中継用）漢字摘要３ */
     ztykjkarikanjyoukamokunm1 ,         /* （中継用）漢字借方勘定科目名１ */
     ztykjkasikanjyoukamokunm1 ,         /* （中継用）漢字貸方勘定科目名１ */
     ztykaritekiyoukm1 ,         /* （中継用）借方摘要項目１ */
     ztykarikingaku1 ,         /* （中継用）借方金額１ */
     ztykasitekiyoukm1 ,         /* （中継用）貸方摘要項目１ */
     ztykasikingaku1 ,         /* （中継用）貸方金額１ */
     ztykjkaritekiyoukm1 ,         /* （中継用）漢字借方摘要項目１ */
     ztykjkasitekiyoukm1 ,         /* （中継用）漢字貸方摘要項目１ */
     ztykjkarikanjyoukamokunm2 ,         /* （中継用）漢字借方勘定科目名２ */
     ztykjkasikanjyoukamokunm2 ,         /* （中継用）漢字貸方勘定科目名２ */
     ztykaritekiyoukm2 ,         /* （中継用）借方摘要項目２ */
     ztykarikingaku2 ,         /* （中継用）借方金額２ */
     ztykasitekiyoukm2 ,         /* （中継用）貸方摘要項目２ */
     ztykasikingaku2 ,         /* （中継用）貸方金額２ */
     ztykjkaritekiyoukm2 ,         /* （中継用）漢字借方摘要項目２ */
     ztykjkasitekiyoukm2 ,         /* （中継用）漢字貸方摘要項目２ */
     ztykjkarikanjyoukamokunm3 ,         /* （中継用）漢字借方勘定科目名３ */
     ztykjkasikanjyoukamokunm3 ,         /* （中継用）漢字貸方勘定科目名３ */
     ztykaritekiyoukm3 ,         /* （中継用）借方摘要項目３ */
     ztykarikingaku3 ,         /* （中継用）借方金額３ */
     ztykasitekiyoukm3 ,         /* （中継用）貸方摘要項目３ */
     ztykasikingaku3 ,         /* （中継用）貸方金額３ */
     ztykjkaritekiyoukm3 ,         /* （中継用）漢字借方摘要項目３ */
     ztykjkasitekiyoukm3 ,         /* （中継用）漢字貸方摘要項目３ */
     ztykjkarikanjyoukamokunm4 ,         /* （中継用）漢字借方勘定科目名４ */
     ztykjkasikanjyoukamokunm4 ,         /* （中継用）漢字貸方勘定科目名４ */
     ztykaritekiyoukm4 ,         /* （中継用）借方摘要項目４ */
     ztykarikingaku4 ,         /* （中継用）借方金額４ */
     ztykasitekiyoukm4 ,         /* （中継用）貸方摘要項目４ */
     ztykasikingaku4 ,         /* （中継用）貸方金額４ */
     ztykjkaritekiyoukm4 ,         /* （中継用）漢字借方摘要項目４ */
     ztykjkasitekiyoukm4 ,         /* （中継用）漢字貸方摘要項目４ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ZT_SkFurikaeDenpyouTy_Z;