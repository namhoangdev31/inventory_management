"use client";

import { useGetDashboardMetricsQuery } from "@/state/api";
import { TrendingDown, TrendingUp } from "lucide-react";
import numeral from "numeral";
import React from "react";
import {
  LineChart,
  Line,
  ResponsiveContainer,
  Tooltip,
  XAxis,
  YAxis,
  CartesianGrid,
} from "recharts";

const fakePurchaseData = [
  { date: "2025-03-01", totalPurchased: 100000, totalInvoices: 130000 },
  { date: "2025-03-02", totalPurchased: 123000, totalInvoices: 100000 },
  { date: "2025-03-03", totalPurchased: 121000, totalInvoices: 145000 },
  { date: "2025-03-04", totalPurchased: 126500, totalInvoices: 110000 },
  { date: "2025-03-05", totalPurchased: 129000, totalInvoices: 160000 },
  { date: "2025-03-06", totalPurchased: 127000, totalInvoices: 98000 },
  { date: "2025-03-07", totalPurchased: 131500, totalInvoices: 170000 },
  { date: "2025-03-08", totalPurchased: 134000, totalInvoices: 100000 },
  { date: "2025-03-09", totalPurchased: 132000, totalInvoices: 158000 },
  { date: "2025-03-10", totalPurchased: 135000, totalInvoices: 105000 },
  { date: "2025-03-11", totalPurchased: 136000, totalInvoices: 165000 },
  { date: "2025-03-12", totalPurchased: 208500, totalInvoices: 175000 },
  { date: "2025-03-13", totalPurchased: 120321, totalInvoices: 90000 },
  { date: "2025-03-14", totalPurchased: 102030, totalInvoices: 140000 },
  { date: "2025-03-15", totalPurchased: 142000, totalInvoices: 110000 },
  { date: "2025-03-16", totalPurchased: 144000, totalInvoices: 168000 },
  { date: "2025-03-17", totalPurchased: 143000, totalInvoices: 95000 },
  { date: "2025-03-18", totalPurchased: 102020, totalInvoices: 135000 },
  { date: "2025-03-19", totalPurchased: 148000, totalInvoices: 115000 },
  { date: "2025-03-20", totalPurchased: 100002, totalInvoices: 160000 },
  { date: "2025-03-21", totalPurchased: 150000, totalInvoices: 95000 },
  { date: "2025-03-22", totalPurchased: 152000, totalInvoices: 180000 },
  { date: "2025-03-23", totalPurchased: 151000, totalInvoices: 108000 },
];

const CardPurchaseSummary = () => {
  const { data, isLoading } = useGetDashboardMetricsQuery();
  const purchaseData = data?.purchaseSummary?.length ? data.purchaseSummary : fakePurchaseData;
  const lastDataPoint = purchaseData[purchaseData.length - 1] || null;
  const percentageChange = lastDataPoint
    ? (((lastDataPoint.totalPurchased - lastDataPoint.totalInvoices) / lastDataPoint.totalInvoices) * 100).toFixed(2)
    : null;


  return (
    <div className="flex flex-col justify-between row-span-2 xl:row-span-3 col-span-1 md:col-span-2 xl:col-span-1 bg-white shadow-lg rounded-3xl">
      {isLoading ? (
        <div className="m-5">Loading...</div>
      ) : (
        <>
          <div>
            <h2 className="text-lg font-semibold mb-2 px-7 pt-5">Purchase Summary</h2>
            <hr />
          </div>

          <div className="px-7 mt-6">
            <p className="text-xs text-gray-400">Purchased</p>
            <div className="flex items-center">
              <p className="text-2xl font-bold">
                {lastDataPoint ? numeral(lastDataPoint.totalPurchased).format("$0.00a") : "0"}
              </p>
              {percentageChange !== null && (
                <p
                  className={`text-sm ${Number(percentageChange) >= 0 ? "text-green-500" : "text-red-500"} flex ml-3`}
                >
                  {Number(percentageChange) >= 0 ? (
                    <TrendingUp className="w-5 h-5 mr-1" />
                  ) : (
                    <TrendingDown className="w-5 h-5 mr-1" />
                  )}
                  {Math.abs(Number(percentageChange))}%
                </p>
              )}
            </div>
          </div>

          <div className="w-full max-w-full overflow-hidden px-2 pt-2 pb-7">
            <ResponsiveContainer width="100%" height={190}>
              <LineChart data={purchaseData} margin={{ top: 10, right: 10, left: 0, bottom: 30 }}>
                <CartesianGrid strokeDasharray="3 3" stroke="#eee" />
                <XAxis
                  dataKey="date"
                  tickFormatter={(date) => {
                    const d = new Date(date);
                    return `${d.getMonth() + 1}/${d.getDate()}`;
                  }}
                  tick={{ fontSize: 9, fill: "#aaa" }}
                  interval="preserveStartEnd"
                  minTickGap={15}
                  axisLine={false}
                  tickLine={false}
                />
                <YAxis
                  tickFormatter={(value) => `$${(value / 1000).toFixed(0)}k`}
                  tick={{ fontSize: 9, fill: "#aaa" }}
                  axisLine={false}
                  tickLine={false}
                />
                <Tooltip
                  contentStyle={{ borderRadius: 10, borderColor: "#ccc" }}
                  formatter={(value) => [`$${numeral(value).format("0,0")}`]}
                  labelFormatter={(label) => {
                    const date = new Date(label);
                    return date.toLocaleDateString("en-US", {
                      weekday: "short",
                      month: "short",
                      day: "numeric",
                    });
                  }}
                />
                <Line
                  type="monotone"
                  dataKey="totalPurchased"
                  stroke="#6366f1"
                  strokeWidth={2}
                  dot={{ r: 3, stroke: '#6366f1', strokeWidth: 2, fill: '#fff' }}
                  activeDot={{ r: 5 }}
                />
                <Line
                  type="monotone"
                  dataKey="totalInvoices"
                  stroke="#10b981"
                  strokeWidth={2}
                  dot={{ r: 3, stroke: '#10b981', strokeWidth: 2, fill: '#fff' }}
                  activeDot={{ r: 5 }}
                  name="Invoices"
                />
              </LineChart>
            </ResponsiveContainer>
          </div>
        </>
      )}
    </div>
  );
};

export default CardPurchaseSummary;