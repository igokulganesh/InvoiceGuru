import { Menu } from "primereact/menu";
import { useNavigate } from "react-router-dom";

export default function Sidebar() {
  const navigate = useNavigate();

  const items = [
    {
      id: "dashboard",
      label: "Dashboard",
      icon: "pi pi-file",
      expanded: true,
      command: () => navigate("/"),
    },
    {
      separator: true,
    },
    {
      label: "Customer",
      icon: "pi pi-cloud",
      command: () => navigate("/customer"),
    },
    {
      label: "Supplier",
      icon: "pi pi-desktop",
      command: () => navigate("/supplier"),
    },
    {
      label: "Items",
      icon: "pi pi-desktop",
      command: () => navigate("/item"),
    },
    {
      separator: true,
    },
    {
      label: "Settings",
      items: [{ label: "Change Company" }],
    },
  ];

  return (
    <div>
      <Menu tabIndex={"dashboard"} model={items} className="h-screen w-14rem" />
    </div>
  );
}
