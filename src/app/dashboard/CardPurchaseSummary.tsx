"use client";

import { useGetDashboardMetricsQuery } from "@/state/api";
import { TrendingDown, TrendingUp } from "lucide-react";
import numeral from "numeral";
import React from "react";
import {
  Area,
  AreaChart,
  ResponsiveContainer,
  Tooltip,
  XAxis,
  YAxis,
} from "recharts";

// Fake data (15 ngày, tăng giảm nhẹ nhàng)
const fakePurchaseData = [
  { date: "2025-03-01", totalPurchased: 100000, changePercentage: 1.5 },
  { date: "2025-03-02", totalPurchased: 123000, changePercentage: 2.5 },
  { date: "2025-03-03", totalPurchased: 121000, changePercentage: -0.8 },
  { date: "2025-03-04", totalPurchased: 126500, changePercentage: 2.0 },
  { date: "2025-03-05", totalPurchased: 129000, changePercentage: 1.9 },
  { date: "2025-03-06", totalPurchased: 127000, changePercentage: -1.6 },
  { date: "2025-03-07", totalPurchased: 131500, changePercentage: 3.5 },
  { date: "2025-03-08", totalPurchased: 134000, changePercentage: 1.9 },
  { date: "2025-03-09", totalPurchased: 132000, changePercentage: -1.5 },
  { date: "2025-03-10", totalPurchased: 135000, changePercentage: 2.3 },
  { date: "2025-03-11", totalPurchased: 136000, changePercentage: 0.8 },
  { date: "2025-03-12", totalPurchased: 208500, changePercentage: 1.8 },
  { date: "2025-03-13", totalPurchased: 120321, changePercentage: 1.1 },
  { date: "2025-03-14", totalPurchased: 102030, changePercentage: -0.7 },
  { date: "2025-03-15", totalPurchased: 142000, changePercentage: 2.2 },
  { date: "2025-03-16", totalPurchased: 144000, changePercentage: 1.6 },
  { date: "2025-03-17", totalPurchased: 143000, changePercentage: -0.9 },
  { date: "2025-03-18", totalPurchased: 102020, changePercentage: 2.1 },
  { date: "2025-03-19", totalPurchased: 148000, changePercentage: 1.4 },
  { date: "2025-03-20", totalPurchased: 100002, changePercentage: -4.9 },
  { date: "2025-03-21", totalPurchased: 150000, changePercentage: 2.0 },
  { date: "2025-03-22", totalPurchased: 152000, changePercentage: 1.5 },
  { date: "2025-03-23", totalPurchased: 151000, changePercentage: -0.8 },

];

const CardPurchaseSummary = () => {
  const { data, isLoading } = useGetDashboardMetricsQuery();

  const purchaseData = data?.purchaseSummary?.length
    ? data.purchaseSummary
    : fakePurchaseData;

  const lastDataPoint = purchaseData[purchaseData.length - 1] || null;

  return (
    <div className="flex flex-col justify-between row-span-2 xl:row-span-3 col-span-1 md:col-span-2 xl:col-span-1 bg-white shadow-lg rounded-3xl">
      {isLoading ? (
        <div className="m-5">Loading...</div>
      ) : (
        <>
          {/* HEADER */}
          <div>
            <h2 className="text-lg font-semibold mb-2 px-7 pt-5">
              Purchase Summary
            </h2>
            <hr />
          </div>

          {/* BODY */}
          <div>
            {/* BODY HEADER */}
            <div className="mb-4 mt-7 px-7">
              <p className="text-xs text-gray-400">Purchased</p>
              <div className="flex items-center">
                <p className="text-2xl font-bold">
                  {lastDataPoint
                    ? numeral(lastDataPoint.totalPurchased).format("$0.00a")
                    : "0"}
                </p>
                {lastDataPoint && (
                  <p
                    className={`text-sm ${lastDataPoint.changePercentage! >= 0
                      ? "text-green-500"
                      : "text-red-500"
                      } flex ml-3`}
                  >
                    {lastDataPoint.changePercentage! >= 0 ? (
                      <TrendingUp className="w-5 h-5 mr-1" />
                    ) : (
                      <TrendingDown className="w-5 h-5 mr-1" />
                    )}
                    {Math.abs(lastDataPoint.changePercentage!)}%
                  </p>
                )}
              </div>
            </div>

            {/* CHART */}
            <div className="w-full aspect-[3/1] md:aspect-[2/1] px-2">
              <ResponsiveContainer width="100%" height="100%">
                <AreaChart
                  data={purchaseData}
                  margin={{ top: 0, right: 0, left: -50, bottom: 70 }}
                >
                  {/* Gradient Fill */}
                  <defs>
                    <linearGradient id="colorPurchased" x1="0" y1="0" x2="0" y2="1">
                      <stop offset="5%" stopColor="#8884d8" stopOpacity={0.4} />
                      <stop offset="95%" stopColor="#8884d8" stopOpacity={0} />
                    </linearGradient>
                  </defs>

                  {/* Axis */}
                  <XAxis
                    dataKey="date"
                    tickFormatter={(date) => {
                      const d = new Date(date);
                      return `${d.getMonth() + 1}/${d.getDate()}`;
                    }}
                    tick={{ fontSize: 10, fill: "#aaa" }}
                    axisLine={false}
                    tickLine={false}
                  />
                  <YAxis
                    tickFormatter={(value) => `$${(value / 1000).toFixed(0)}k`}
                    tick={{ fontSize: 10, fill: "#aaa" }}
                    axisLine={false}
                    tickLine={false}
                  />

                  {/* Tooltip */}
                  <Tooltip
                    contentStyle={{ borderRadius: 10, borderColor: "#ccc" }}
                    formatter={(value: number) => [`$${numeral(value).format("0,0")}`]}
                    labelFormatter={(label) => {
                      const date = new Date(label);
                      return date.toLocaleDateString("en-US", {
                        weekday: "short",
                        month: "short",
                        day: "numeric",
                      });
                    }}
                  />

                  {/* Area Line */}
                  <Area
                    type="monotone"
                    dataKey="totalPurchased"
                    stroke="#8884d8"
                    strokeWidth={2}
                    fill="url(#colorPurchased)"
                    dot={false}
                  />
                </AreaChart>
              </ResponsiveContainer>
            </div>
          </div>
        </>
      )}
    </div>
  );
};

export default CardPurchaseSummary;
