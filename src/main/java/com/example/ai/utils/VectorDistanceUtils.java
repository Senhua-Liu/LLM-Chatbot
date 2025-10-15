package com.itheima.ai.utils;

/**
 * 工具类：用于计算向量之间的距离与相似度
 */
public class VectorDistanceUtils {

    // 防止实例化
    private VectorDistanceUtils() {}

    // 浮点数计算精度阈值
    private static final double EPSILON = 1e-12;

    /**
     * 计算欧氏距离 (Euclidean Distance)
     * @param vectorA 向量A（非空且与B等长）
     * @param vectorB 向量B（非空且与A等长）
     * @return 欧氏距离
     * @throws IllegalArgumentException 参数不合法时抛出
     */
    public static double euclideanDistance(float[] vectorA, float[] vectorB) {
        validateVectors(vectorA, vectorB);

        double sum = 0.0;
        for (int i = 0; i < vectorA.length; i++) {
            double diff = vectorA[i] - vectorB[i];
            sum += diff * diff;
        }
        return Math.sqrt(sum);
    }

    /**
     * 计算余弦相似度 (Cosine Similarity)
     * @param vectorA 向量A（非空且与B等长）
     * @param vectorB 向量B（非空且与A等长）
     * @return 余弦相似度（范围：-1 ~ 1）
     * @throws IllegalArgumentException 参数不合法时抛出
     */
    public static double cosineDistance(float[] vectorA, float[] vectorB) {
        validateVectors(vectorA, vectorB);

        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;

        for (int i = 0; i < vectorA.length; i++) {
            dotProduct += vectorA[i] * vectorB[i];
            normA += vectorA[i] * vectorA[i];
            normB += vectorB[i] * vectorB[i];
        }

        double denominator = Math.sqrt(normA) * Math.sqrt(normB);
        if (denominator < EPSILON) {
            throw new IllegalArgumentException("Vector norm too small, possible zero vector.");
        }

        return dotProduct / denominator;
    }

    /**
     * 校验向量是否有效
     */
    private static void validateVectors(float[] vectorA, float[] vectorB) {
        if (vectorA == null || vectorB == null) {
            throw new IllegalArgumentException("Vectors must not be null");
        }
        if (vectorA.length != vectorB.length) {
            throw new IllegalArgumentException("Vectors must have the same length");
        }
    }
}
