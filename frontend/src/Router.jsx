import { Routes, Route } from "react-router-dom";

export const Router = () => {
  const route = [
    {
      path: "/",
      element: <h1>hellloo</h1>,
    },
    {
      path: "/about",
      element: <h1>about</h1>,
    },
  ];

  return (
    <Routes>
      {route.map((item) => (
        <Route key={item.path} path={item.path} element={item.element} />
      ))}
    </Routes>
  );
};
